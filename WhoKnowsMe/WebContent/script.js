function searchStarter() {
    var username = document.getElementById("bname").value;
    document.getElementById("divId").innerHTML = username;

    var reloading = document.createElement("div")
    reloading.id = "divreloading"
    document.getElementById("searchButton").innerHTML = "";
    document.getElementById("searchButton").appendChild(reloading);
}
function keyEnterPress(event){
    if(event.keyCode == 13){
        searchStarter();
    }
}
window.addEventListener("keydown", keyEnterPress, false);