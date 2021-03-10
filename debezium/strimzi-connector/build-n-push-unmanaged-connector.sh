#!/bin/bash

set -Eeuo pipefail

declare -r SCRIPT_DIR=$(cd -P $(dirname $0) && pwd)

declare IMAGE_TAG=${1:-latest}
declare IMAGE_NAME=${2:-cdc-demo-dbz-connect-unmanaged}
declare DOCKERFILE=${3:-Dockerfile-unmanaged}
declare REGISTRY=${4:-"quay.io"}
declare ACCOUNT=${5:-"mhildenb"}

DOCKER_BUILDKIT=1 docker build --progress=plain --secret id=myuser,src=../../secrets/myuser.txt --secret id=mypass,src=../../secrets/mypass.txt -f ${DOCKERFILE} -t ${REGISTRY}/${ACCOUNT}/${IMAGE_NAME}:$IMAGE_TAG $SCRIPT_DIR

docker tag ${REGISTRY}/${ACCOUNT}/${IMAGE_NAME}:${IMAGE_TAG} ${REGISTRY}/${ACCOUNT}/${IMAGE_NAME}:latest

docker push ${REGISTRY}/${ACCOUNT}/${IMAGE_NAME}:${IMAGE_TAG}
docker push ${REGISTRY}/${ACCOUNT}/${IMAGE_NAME}:latest
