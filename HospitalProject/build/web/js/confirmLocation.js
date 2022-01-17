function confirmLocation() {
	const ourRequest	= new XMLHttpRequest();

	var country		= document.getElementById('country').value;
	var city		= document.getElementById('city').value;
	var address             = document.getElementById('address').value;

	const data = null;

	ourRequest.withCredentials = true;
	
	ourRequest.addEventListener("readystatechange", function () {
		if (this.readyState === this.DONE) {
			console.log(this.responseText);
		}
	});

	const urlBASE	= 'https://forward-reverse-geocoding.p.rapidapi.com/v1/search?q=';
	if (address === '') {
		var query	= city + '%20' + country + '&accept-language=en&polygon_threshold=0.0';
	}else {
		var query	= city + '%20' + address + '%20' + country + '&accept-language=en&polygon_threshold=0.0';
	}
	var URL 		= urlBASE + query;
	ourRequest.open("GET", URL);
	ourRequest.setRequestHeader("x-rapidapi-host", "forward-reverse-geocoding.p.rapidapi.com");
	ourRequest.setRequestHeader("x-rapidapi-key", "738752bdd4msh5d514c07bab0bbap1570a1jsn6618d36d19dc");
	ourRequest.send(data);

	ourRequest.onload = function() {
		var addressData;

		//If  API sends empty JSON data it means the user typed location was not found
		if (ourRequest.responseText == "{}") {
			document.getElementById('location-confirmed').innerHTML = '✖';
			document.getElementById('city').setCustomValidity("Invalid Location");
			document.getElementById('address').setCustomValidity("Invalid Location");
		}else if (city != "") {
			addressData = JSON.parse(ourRequest.responseText);
			document.getElementById('location-confirmed').innerHTML = '✓';
			document.getElementById('city').setCustomValidity("");
			document.getElementById('address').setCustomValidity("");
			document.getElementById('lon').value = addressData[0].lon;
			document.getElementById('lat').value = addressData[0].lat;	
		}else if (city === "") {
			document.getElementById('location-confirmed').innerHTML = '';
			document.getElementById('city').setCustomValidity("Please enter a city name");
			document.getElementById('address').setCustomValidity("");
			document.getElementById('lon').value = "";
			document.getElementById('lat').value = "";
		}
	};
}
