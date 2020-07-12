/*
    This class is responsible for all the scripts needed for the editor.
 */

function execCommandWithArgument(command, valueToChange) {
    document.execCommand(command, false, valueToChange);
}

function execCmd(command) {
    execCommandWithArgument(command, null);
}

// This methods makes sure the content will be saved.
setInterval(function () {
    localStorage["text"] = document.getElementById("editor").innerHTML
}, 1000);
