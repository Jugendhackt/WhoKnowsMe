function submitClick() {
	//1) output mit Ladebalken ersetzen (optional)
	let reloading = document.createElement('div');
	reloading.setAttribute('id','reloading');
	document.getElementById('output').innerHTML = '';
	document.getElementById('output').appendChild(reloading);
	
	//2) Eingabe auslesen //wenn eingabe leer, hier abbrechen (aber ladebalken wieder entfernen)
	let input = encodeURI(document.getElementById('username').value);

	//3) Anfrage senden (findAccounts/EINGABE)
	let url = 'services/AccountService/serve/' + input;

	webRequest('GET', url)
	// when the request is successful
	  .then(j => runRequest(input, JSON.parse(j)))
	// when the request fails
	  .catch(e => errorRequest(e));
}

//====INPUT=EVENTS==============

window.onload = function() {
	// pseudo button press, when you press enter while focusing the nickname input field
	this.document.getElementById('username').addEventListener('keypress', function(e) {
		if (e.keyCode == 13) {
			submitClick();
		}
	})
}

//====HELPER=FUNCTIONS========

function runRequest(username, json) {
	let subheader       = document.createElement('h2');
	subheader.innerHTML = 'There are accounts for "' + decodeURI(username) + '" at:';

	let list = createList(json);

	let output = document.getElementById('output');

	// Clear divs content
	output.innerHTML = '';

	output.appendChild(subheader);
	output.appendChild(list);
};

function errorRequest(error) {
	let subheader       = document.createElement('h2');
	subheader.innerHTML = 'Oops, it seems like something went wrong.';

	let output = document.getElementById('output');
	output.innerHTML = '';

	output.appendChild(subheader);	

	// Displays the full error log
	for (const prop in error) {
		if (error.hasOwnProperty(prop)) {
			let pNode = document.createElement('p');
			pNode.innerHTML = error[prop];
			output.appendChild(pNode);
		}
	}	
}

function createList(json) {
	//take the json,
	//return something like this structure (but as nodes, not as string)

	//<ul>
	// <li><a href="URL">account</a> on PORTAL_NAME</li>
	//</ul>

	let list = document.createElement('ul');

	for(let acc in json) {
		let listPoint = document.createElement('li');
		console.log(json[acc])
		
		let aNode = createRefNode(json[acc].name, json[acc].url);
		listPoint.appendChild(aNode);
		list.append(listPoint);
	}

	return list;

	function createRefNode(text, url) {
		let node = document.createElement('a');
		node.setAttribute('href', url);
		node.innerHTML = text;

		return node;
	}
}

function webRequest(method, url) {
	return new Promise(function(resolve, reject) {

		let xhr = new XMLHttpRequest();
		xhr.open(method, url);
		xhr.onload = function() {

			// Good statuscodes, we can continue
			if (this.status >= 200 && this.status < 300) {
				resolve(xhr.response);
			} else {
				reject({
					url: this.responseURL,
					status: this.status,
					statusText: this.statusText
				});
			}
		};
		xhr.onerror = function() {
			reject({
				status: this.status,
				statusText: xhr.statusText	
			})
		}
		xhr.send();
	});	
}