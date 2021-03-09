# CDC Demo Legacy Application

A **development container** is a running [Docker](https://www.docker.com) container with a well-defined tool/runtime stack and its prerequisites. This uses **[Visual Studio Code Remote - Containers](https://aka.ms/vscode-remote/containers)**.

## Setting up the development container

Follow these steps to open this sample in a container using the VS Code Remote - Containers extension:

1. If this is your first time using a development container, please ensure your system meets the pre-reqs (i.e. have Docker installed) in the [getting started steps](https://aka.ms/vscode-remote/containers/getting-started).

2. To use this repository, you can either open the repository in an isolated Docker volume:

    - Press <kbd>F1</kbd> and select the **Remote-Containers: Try a Sample...** command.
    - Choose the "PHP" sample, wait for the container to start, and try things out!
        > **Note:** Under the hood, this will use the **Remote-Containers: Clone Repository in Container Volume...** command to clone the source code in a Docker volume instead of the local filesystem. [Volumes](https://docs.docker.com/storage/volumes/) are the preferred mechanism for persisting container data.

   Or open a locally cloned copy of the code:

   - Clone this repository to your local filesystem.
   - Press <kbd>F1</kbd> and select the **Remote-Containers: Open Folder in Container...** command.
   - Select the cloned copy of this folder, wait for the container to start, and try things out!

## Things to try

Once you have this sample opened, you'll be able to work with it like you would locally.

> **Note:** This container runs as a non-root user with sudo access by default. Comment out `"remoteUser": "vscode"` in `.devcontainer/devcontainer.json` if you'd prefer to run as root.

Some things to try:

1. **Edit:**
   - Open `index.php`
   - Try adding some code and check out the language features.
   - Notice that PHP debugging and IntelliSense are already included in the container since the `.devcontainer/devcontainer.json` lists `"felixfbecker.php-debug"`, `"bmewburn.vscode-intelephense-client"`, and `"mrmlnc.vscode-apache"` as extensions to install automatically when the container is created.
1. **Terminal:** Press <kbd>ctrl</kbd>+<kbd>shift</kbd>+<kbd>\`</kbd> and type `uname` and other Linux commands from the terminal window.
1. **Run and Debug:**
   - Open `index.php`
   - Add a breakpoint (e.g. on line 4).
   - Press <kbd>F5</kbd> to launch the app in the container.
   - Once the breakpoint is hit, try hovering over variables, examining locals, and more.
1. **Running a server:**
   - From the terminal, run `php -S 0.0.0.0:8000`
   - Press <kbd>F1</kbd> and run the **Forward a Port** command.
   - Select port `8000`.
   - Click "Open Browser" in the notification that appears to access the web app on this new port.
   - Look back at the terminal, and you should see the output from your site navigations
   - Edit the text on line 21 in `index.php` and refresh the page to see the changes immediately take affect
1. **Attach debugger to the server:**
   - Follow the previous steps to start up a PHP server and open a browser on port `8000`
   - Press <kbd>F1</kbd> and select the **View: Show Debug** command
   - Pick "Listen for XDebug" from the dropdown
   - Press <kbd>F5</kbd> to attach the debugger
   - Add a breakpoint to `index.php` if you haven't already
   - Reload your browser window
   - Once the breakpoint is hit, try hovering over variables, examining locals, and more.

## Building the Container

From the root of this repo, run this command:

```
docker build -t quay.io/mhildenb/cdc-legacy-app:1.0 -f .docker/Dockerfile .
```

Then optionally push the container:

```
docker push quay.io/mhildenb/cdc-legacy-app:1.0
```

And finally, optionally tag this as latest:

```
docker tag quay.io/mhildenb/cdc-legacy-app:1.0 quay.io/mhildenb/cdc-legacy-app:latest
docker push quay.io/mhildenb/cdc-legacy-app:latest
```