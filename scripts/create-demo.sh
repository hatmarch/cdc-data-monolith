#!/bin/bash

set -Eeuxo pipefail

declare -r SCRIPT_DIR=$(cd -P $(dirname $0) && pwd)
declare PROJECT_PREFIX="cdc-demo"
declare -r ANSIBLE_DEMO_PLAYBOOK_DIR="${SCRIPT_DIR}/../ansible/demo"

display_usage() {
cat << EOF
$0: Create CDC Monolith Demo --

  Usage: ${0##*/} [ OPTIONS ]
  
    -p <TEXT>  [optional] Project prefix to use.  Defaults to "cdc-demo"
    -v         [optional] Run ansible playbooks in verbose mode
    -i         [optional] Install pre-requisites

EOF
}

get_and_validate_options() {
  # Transform long options to short ones
#   for arg in "$@"; do
#     shift
#     case "$arg" in
#       "--long-x") set -- "$@" "-x" ;;
#       "--long-y") set -- "$@" "-y" ;;
#       *)        set -- "$@" "$arg"
#     esac
#   done

  
  # parse options
  while getopts ':vip:h' option; do
      case "${option}" in
          p  ) p_flag=true; PROJECT_PREFIX="${OPTARG}";;
          v  ) ANSIBLE_VERBOSE="-vvvvv";;
          i  ) ANSIBLE_INSTALL_PRE="-e install_prereqs=true";;
          h  ) display_usage; exit;;
          \? ) printf "%s\n\n" "  Invalid option: -${OPTARG}" >&2; display_usage >&2; exit 1;;
          :  ) printf "%s\n\n%s\n\n\n" "  Option -${OPTARG} requires an argument." >&2; display_usage >&2; exit 1;;
      esac
  done
  shift "$((OPTIND - 1))"

  if [[ -z "${PROJECT_PREFIX}" ]]; then
      printf '%s\n\n' 'ERROR - PROJECT_PREFIX must not be null' >&2
      display_usage >&2
      exit 1
  fi
}

main() {
    # import common functions
    . $SCRIPT_DIR/common-func.sh

    trap 'error' ERR
    trap 'cleanup' EXIT SIGTERM
    trap 'interrupt' SIGINT

    get_and_validate_options "$@"

    #create the dev project if it doesn't already exist
    dev_prj="${PROJECT_PREFIX}-dev"
    oc get ns $dev_prj 2>/dev/null  || { 
        oc new-project $dev_prj
    }

    # Run the ansible playbook (see inventory file for additional variables that can be overriden with -e)
    echo "Attempting to run the ansible playbook for demo"
    ansible-playbook -i ${ANSIBLE_DEMO_PLAYBOOK_DIR}/inventory ${ANSIBLE_DEMO_PLAYBOOK_DIR}/main.yaml \
      -e "ACTION=create" \
      -e "dev_project=${dev_prj}" \
      $(echo ${ANSIBLE_VERBOSE:-""}) $(echo "${ANSIBLE_INSTALL_PRE:-""""}")

    echo "Demo installation completed without error."
}

main "$@"