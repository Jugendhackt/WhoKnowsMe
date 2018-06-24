jQuery(function() {

function start() {
	//1) output mit Ladebalken ersetzen (optional)
	
	//2) Eingabe auslesen //wenn eingabe leer, hier abbrechen (aber ladebalken wieder entfernen)
	var input = escape(jQuery('#username').val());

	//3) Anfrage senden (findAccounts/EINGABE)
	jQuery.getJSON('services/AccountService/serve/'+input, runRequest);
}
	
var runRequest = function(json) {
	//4) antwort (json) in liste umformen
	var list = createList(json);


	//5) output.innerHTML durch Liste ersetzen
	jQuery('#output').empty();
	jQuery('#output').append(list);
	
};



//====INPUT=EVENTS==============

//this function will be run when enter is pressed in the #username input
jQuery('#username').keypress(function (e) {
	if (e.which == 13) {
   		start();
   	}
});

//this function will run when button #submit is clicked
jQuery('#submit').click(function() {
	start();	
});



//====HELPER=FUNCTIONS========

function createList(json) {
	//take the json,
	//return somthing like this structur (but as nodes, not as string)

	//<ul>
	// <li><a href="URL">account</a> on PORTAL_NAME</li>
	// //mehr list-elemente
	//</ul>

	var list = document.createElement('ul');

	for(var acc in json) {
		var listPoint = document.createElement('li');
		listPoint.innerHTML = 'There is an <a href="' + json[acc].url + '">account</a> at ' + json[acc].name;
		list.append(listPoint);
	}

	return list;
}

});