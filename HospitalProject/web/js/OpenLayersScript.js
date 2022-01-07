map = new OpenLayers.Map("map");
map.addLayer(new OpenLayers.Layer.OSM());

var lonLat = new OpenLayers.LonLat( -0.1279688 ,51.5077286 )
    .transform(
        new OpenLayers.Projection("EPSG:4326"),
        map.getProjectionObject()
    );
                              
var zoom=16;

var markers = new OpenLayers.Layer.Markers( "Markers" );
map.addLayer(markers);
                        
markers.addMarker(new OpenLayers.Marker(lonLat));
                        
map.setCenter (lonLat, zoom);
