function getMap()
{
	
	initialize();
    createlightbox();
	return false;
}

var map;
function initialize()
{   
	
	var myCenter=new google.maps.LatLng(12.931288,77.587582);
	var mapProp = {
		center:myCenter,
		//zoom:5,
		zoom:12,
		mapTypeId:google.maps.MapTypeId.ROADMAP
	};

    map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
   //var marker=new google.maps.Marker({position:myCenter,});
   //marker.setMap(map);
  
   google.maps.event.addListener(map, 'click', function(event)
   {
     placeMarker(event.latLng);
    
   });
}

function placeMarker(location) 
{
	  var marker = new google.maps.Marker({
	    position: location,
	    map: map,
		});
 
	  var infowindow = new google.maps.InfoWindow(
	  {
	    	content: 'Latitude: ' + location.lat() + '<br>Longitude: ' + location.lng()
	  });
 	 infowindow.open(map,marker);
 	 
 	 //Setting The Latitude and Longitude Value in Input Field
 	//document.getElementById("x").value = location.lat();
 	//document.getElementById("y").value = location.lng();
 	
 	//Fixing Till 6 Decimal Point
 	document.getElementById("x").value = location.lat().toFixed(6);
 	document.getElementById("y").value = location.lng().toFixed(6);
 	
}

function createlightbox()
{
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';
}
function closelightbox()
{
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none'
    
}

