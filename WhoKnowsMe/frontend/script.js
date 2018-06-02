function searchStarter() {
    var username = document.getElementById("bname").value;
    document.getElementById("divId").innerHTML = username;
}
function keyEnterPress(event){
    if(event.keyCode == 13){
        searchStarter();
    }
}
window.addEventListener("keydown", keyEnterPress, false);