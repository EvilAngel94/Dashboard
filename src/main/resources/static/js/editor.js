function execCommandWithArgument(command, valueToChange) {
    document.execCommand(command, false, valueToChange);
}

function execCmd(command) {
    execCommandWithArgument(command, null);
}