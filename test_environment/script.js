jQuery(function() {

function start() {
	//1) output mit Ladebalken ersetzen (optional)
	var reloading = document.createElement('div');
	reloading.setAttribute('id','reloading');
	jQuery('#output').prepend(reloading);
	
	//2) Eingabe auslesen //wenn eingabe leer, hier abbrechen (aber ladebalken wieder entfernen)
	var input = jQuery('#username').val();

	//3) Anfrage senden (findAccounts/EINGABE)
	jQuery.getJSON('services/AccountService/serve/'+input, runRequest(input));
}
	
var runRequest = function(accountname) {
	var subheader = createSubheader(accountname);
	
	return function(json) {
		//4) antwort (json) in liste umformen
		var list = createList(json);

		//5) output.innerHTML durch Liste ersetzen
		jQuery('#output').empty();
		jQuery('#output').append(subheader);
		jQuery('#output').append(list);
	};
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

function createSubheader(accountname) {
	var subheader = document.createElement('h2');
	subheader.innerHTML = 'There are accounts for "' + accountname + '" at:"';
	return subheader;
}

function createList(json) {
	//take the json,
	//return something like this structure (but as nodes, not as string)

	//<ul>
	// <li><a href="URL">account</a> on PORTAL_NAME</li>
	//</ul>

	var list = document.createElement('ul');

	for(var acc in json) {
		var listPoint = document.createElement('li');
		listPoint.innerHTML = '<a href="' + json[acc].url + '">' + json[acc].name + '</a>';
		list.append(listPoint);
	}

	return list;
}

});