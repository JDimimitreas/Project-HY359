var checkBox = document.getElementById('map-checkbox');

// Initialise checkbox
function initCheckbox() {
	checkBox.checked = false;
};

// Collapsible function for div that contains map
function collapse() {
	if (checkBox.checked) {
		updateMap();
		document.getElementById('map').style.height = '500px';
		document.getElementById('map').style.visibility = 'visible';
	}else {
		document.getElementById('map').style.height = '0px';
		document.getElementById('map').style.visibility = 'hidden';
	}
}

// Hide map (on input in the location fields)
function hideMap() {
	document.getElementById('map').style.height = '0px';
	document.getElementById('map').style.visibility = 'hidden';
	checkBox.checked = false;
}

// Show map (for Geolocation)
function showMap() {
	document.getElementById('map').style.height = '500px';
	document.getElementById('map').style.visibility = 'visible';
}

// Geolocation button visibility
var msg = document.getElementById("geolocation-error-msg");
function buttonVisibility() {
	if (navigator.geolocation) {
		document.getElementById('geolocation-btn').style.visibility = 'visible';
	} else {
	   	document.getElementById('geolocation-btn').style.visibility = 'hidden';
	}
}
// Geolocation map function
document.getElementById("geolocation-btn").addEventListener("click", function() {
	if (navigator.geolocation) {
		hideMap();
	   	navigator.geolocation.getCurrentPosition(showPosition);
	} else {
	   	msg.innerHTML = "Geolocation is not supported by this browser.";
	}
});
function showPosition(position) {
	var ourRequest	= new XMLHttpRequest();

	var lon		= document.getElementById('lon').value;
        lon             = position.coords.longitude;
	var lat		= document.getElementById('lat').value;
        lat             = position.coords.latitude;;


	//NOTE: Very hacky way to do the query, however what is needed at the moment is simple so I just roll with it...
	const urlBASE	= 'https://nominatim.openstreetmap.org/reverse?format=geojson';
	var query	= '&lat=' + lat + '&lon=' + lon;

	var URL 		= urlBASE + query;

	ourRequest.onload = function() {
		var locationData	= JSON.parse(ourRequest.responseText);
		if (locationData !== "") {
			document.getElementById('country').value= locationData.features[0].properties.address.country_code.toUpperCase();
			document.getElementById('city').value	= locationData.features[0].properties.address.municipality;
                        document.getElementById('lon').value	= locationData.features[0].geometry.coordinates[0];
                        document.getElementById('lat').value	= locationData.features[0].geometry.coordinates[1];

		}
	};
	ourRequest.open('GET',URL);
	ourRequest.send();

	updateMap();
	showMap();
}

// Update map with the new coordinates
function updateMap() {
    var x = document.getElementById('lon').value;
    var y = document.getElementById('lat').value;
    console.log("lon:" + " " + x + " " + "lat:" + " " + y);
    var lonLat = new OpenLayers.LonLat( x ,y )
        .transform(
            new OpenLayers.Projection("EPSG:4326"),
            map.getProjectionObject()
        );
                                          
    var zoom=16;

    var markers = new OpenLayers.Layer.Markers( "Markers" );
    map.addLayer(markers);
                                    
    markers.addMarker(new OpenLayers.Marker(lonLat));                              
    map.setCenter (lonLat, zoom);
}

document.getElementById('country').oninput	= hideMap;
document.getElementById('city').oninput		= hideMap;
document.getElementById('address').oninput	= hideMap;
