// // reference to the iFrame name
// let editorDashboard;

function enableEditMode() {
    editorDashboard.document.designMode = 'On'
}

// This function is responsible the markup of the text field
function execCmd(command) {
    editorDashboard.document.execCommand(command, false, null)
}

function execCommandWithArgument(command, valueToChange) {
    editorDashboard.document.execCommand(command, false, valueToChange)
}