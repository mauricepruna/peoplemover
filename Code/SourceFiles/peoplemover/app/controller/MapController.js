/*
 * File: app/controller/MapController.js
 */

Ext.define('PeopleMover.controller.MapController', {
    extend: 'Ext.app.Controller',

    requires: [
        'Ext.JSON',
        'Ext.util.DelayedTask'
    ],

    config: {
        models: [
            'MapLocations'
        ],
        stores: [
            'MapStore'
        ],
        views: [
            'MyMap',
            'MainView'
        ],

        refs: {
            mapComponent: '#mymap',
            nearMeButton: '#nearme',
            nearMeRoute: '#bhighnorthRoute',
            nearMeRoute2: '#bhighsouthRoute',
            nearMeRoute3: '#bmiddlenorthRoute',
            nearMeRoute4: '#bmiddlesouthRoute' 

        },

        control: {
            "#mymap": {
                maprender: 'onMymapMaprender'
            },
            "#nearme": {
                tap: 'onButtonClick'
            },
            "#bhighnorthRoute":{
                tap: 'showNearestestStopHighNorth'
            },
            "#bhighsouthRoute":{
                tap: 'showNearestestStopHighSouth'
            },
            "#bmiddlenorthRoute":{
                tap: 'showNearestestStopMidNorth'
            },
            "#bmiddlesouthRoute":{
                tap: 'showNearestestStopMidSouth'
            }
        }
    },

    showNearestestStopHighNorth: function(button, map, gmap, eOpts) {
        var map = Ext.getCmp('mymap').getMap();

        var geo = Ext.create('Ext.util.Geolocation', {
              autoUpdate: true,

                    listeners: {
                        locationupdate: function (geo) {        

                            var directionsDisplay = new google.maps.DirectionsRenderer();
                            var directionsService = new google.maps.DirectionsService();

                            var center = new google.maps.LatLng(geo.getLatitude(), geo.getLongitude());
                            var closest = near_meHighNorth(geo.getLatitude(), geo.getLongitude());

                           var closestLat = closest[0];
                           var closestLon = closest[1];

                           var location = new google.maps.LatLng(closestLat, closestLon);


                           var marker = new google.maps.Marker({map: map, position: new google.maps.LatLng( closestLat, closestLon ), clickable: true});

                            marker.info = new google.maps.InfoWindow({
                              content: '<b>this is the closest location</b>'
                            });

                            google.maps.event.addListener(marker, 'click', function() {
                              marker.info.open(map, marker);
                            });

                            // directionsDisplay.setMap(map);

                            // var request = {
                            //     origin: center,
                            //     destination: location,
                            //     travelMode: google.maps.TravelMode.DRIVING
                            // };

                            // directionsService.route(request, function(result, status){
                            //     //console.log(status);
                            //     if(status = google.maps.DirectionsStatus.OK){
                            //         console.log(result);
                            //         directionsDisplay.setDirections(result);
                            //     }
                            // });


                            //Ext.getCmp('nearme').hide();
                            //Ext.getCmp('hideButton').show();
                        },



                        locationerror: function (geo, bTimeout, bPermissionDenied, bLocationUnavailable, message) {

                            if (bTimeout) {
                                alert('Timeout occurred.');
                            } 
                            else {
                                alert('Error occurred.');
                            }

                }

            }

        });

        var overlay = Ext.getCmp('overlay').hide();
    },
    showNearestestStopHighSouth: function(button, map, gmap, eOpts) {
        var map = Ext.getCmp('mymap').getMap();
        highSouth = Ext.getStore('HighSouthStore');
        highSouth.load();
    
        var geo = Ext.create('Ext.util.Geolocation', {
              autoUpdate: true,

                    listeners: {
                        locationupdate: function (geo) {        

                            var directionsDisplay = new google.maps.DirectionsRenderer();
                            var directionsService = new google.maps.DirectionsService();

                            var center = new google.maps.LatLng(geo.getLatitude(), geo.getLongitude());
                            var closest = near_meHighSouth(geo.getLatitude(), geo.getLongitude());

                           var closestLat = closest[0];
                           var closestLon = closest[1];

                           var location = new google.maps.LatLng(closestLat, closestLon);

                           

                           var marker = new google.maps.Marker({map: map, position: new google.maps.LatLng( closestLat, closestLon ), clickable: true});

                           if(marker.title == 'test'){
                            console.log('it worked');
                           }
                            marker.info = new google.maps.InfoWindow({
                              content: '<b>this is the closest location</b>'
                            });

                            google.maps.event.addListener(marker, 'click', function() {
                              marker.info.open(map, marker);
                            });

                            // directionsDisplay.setMap(map);

                            // var request = {
                            //     origin: center,
                            //     destination: location,
                            //     travelMode: google.maps.TravelMode.DRIVING
                            // };

                            // directionsService.route(request, function(result, status){
                            //     //console.log(status);
                            //     if(status = google.maps.DirectionsStatus.OK){
                            //         console.log(result);
                            //         directionsDisplay.setDirections(result);
                            //     }
                            // });


                            //Ext.getCmp('nearme').hide();
                            //Ext.getCmp('hideButton').show();
                        },



                        locationerror: function (geo, bTimeout, bPermissionDenied, bLocationUnavailable, message) {

                            if (bTimeout) {
                                alert('Timeout occurred.');
                            } 
                            else {
                                alert('Error occurred.');
                            }

                }

            }

        });
        var overlay = Ext.getCmp('overlay').hide();

    },
    showNearestestStopMidNorth: function(button, map, gmap, eOpts) {
        var map = Ext.getCmp('mymap').getMap();
        midNorth = Ext.getStore('MiddleNorthStore');
        midNorth.load();


        var geo = Ext.create('Ext.util.Geolocation', {
              autoUpdate: true,

                    listeners: {
                        locationupdate: function (geo) {        

                            var directionsDisplay = new google.maps.DirectionsRenderer();
                            var directionsService = new google.maps.DirectionsService();

                            var center = new google.maps.LatLng(geo.getLatitude(), geo.getLongitude());
                            var closest = near_meMidNorth(geo.getLatitude(), geo.getLongitude());

                           var closestLat = closest[0];
                           var closestLon = closest[1];

                           var location = new google.maps.LatLng(closestLat, closestLon);


                           var marker = new google.maps.Marker({id: 'test', map: map, position: new google.maps.LatLng( closestLat, closestLon ), clickable: true, title: 'test'});

                            marker.info = new google.maps.InfoWindow({
                              content: '<b>this is the closest location</b>'
                            });

                            google.maps.event.addListener(marker, 'click', function() {
                              marker.info.open(map, marker);
                            });

                            // directionsDisplay.setMap(map);

                            // var request = {
                            //     origin: center,
                            //     destination: location,
                            //     travelMode: google.maps.TravelMode.DRIVING
                            // };

                            // directionsService.route(request, function(result, status){
                            //     //console.log(status);
                            //     if(status = google.maps.DirectionsStatus.OK){
                            //         console.log(result);
                            //         directionsDisplay.setDirections(result);
                            //     }
                            // });


                            //Ext.getCmp('nearme').hide();
                            //Ext.getCmp('hideButton').show();
                        },



                        locationerror: function (geo, bTimeout, bPermissionDenied, bLocationUnavailable, message) {

                            if (bTimeout) {
                                alert('Timeout occurred.');
                            } 
                            else {
                                alert('Error occurred.');
                            }

                }

            }

        });
        var overlay = Ext.getCmp('overlay').hide();
    },
    showNearestestStopMidSouth: function(button, map, gmap, eOpts) {
        var map = Ext.getCmp('mymap').getMap();
        midSouth = Ext.getStore('MiddleSouthStore');
        midSouth.load();

        var geo = Ext.create('Ext.util.Geolocation', {
              autoUpdate: true,

                    listeners: {
                        locationupdate: function (geo) {        

                            var directionsDisplay = new google.maps.DirectionsRenderer();
                            var directionsService = new google.maps.DirectionsService();

                            var center = new google.maps.LatLng(geo.getLatitude(), geo.getLongitude());
                            var closest = near_meMidSouth(geo.getLatitude(), geo.getLongitude());

                           var closestLat = closest[0];
                           var closestLon = closest[1];

                           var location = new google.maps.LatLng(closestLat, closestLon);


                           var marker = new google.maps.Marker({map: map, position: new google.maps.LatLng( closestLat, closestLon ), clickable: true});

                            marker.info = new google.maps.InfoWindow({
                              content: '<b>this is the closest location</b>'
                            });

                            google.maps.event.addListener(marker, 'click', function() {
                              marker.info.open(map, marker);
                            });

                            // directionsDisplay.setMap(map);

                            // var request = {
                            //     origin: center,
                            //     destination: location,
                            //     travelMode: google.maps.TravelMode.DRIVING
                            // };

                            // directionsService.route(request, function(result, status){
                            //     //console.log(status);
                            //     if(status = google.maps.DirectionsStatus.OK){
                            //         console.log(result);
                            //         directionsDisplay.setDirections(result);
                            //     }
                            // });


                            //Ext.getCmp('nearme').hide();
                            //Ext.getCmp('hideButton').show();
                        },



                        locationerror: function (geo, bTimeout, bPermissionDenied, bLocationUnavailable, message) {

                            if (bTimeout) {
                                alert('Timeout occurred.');
                            } 
                            else {
                                alert('Error occurred.');
                            }

                }

            }

        });
        var overlay = Ext.getCmp('overlay').hide();
    },

    onButtonClick: function(map, gmap, eOpts){

        //var gMap = this.getMapComponent();

        var map = Ext.getCmp('mymap').getMap();

        //Ext.getCmp('nearme').setCls('x-button-pressing');

            

    },

    onMymapMaprender: function(map, gmap, eOpts) {
        var store, latLng, marker, midNorth, midSouth, highNorth, highSouth, i;
        
        var iconBase = 'resources/images/';
        var gMap = this.getMapComponent();
        var map = Ext.getCmp('mymap').getMap();
        var midSouthWayPoints = new Array();
        var midNorthWayPoints = new Array();
        var highSouthWayPoints = new Array();
        var highNorthWayPoints = new Array();

        var SouthTotalDist = 0;
        
                waypointMidSouth = Ext.getStore('WayPointStore1');
                waypointMidSouth.load();

                waypointMidSouth.each(function(record,index,length){

                    var x = 0;
                    var y = record.data.listwp.length -1 ;
                    //console.log("total number is : " + y);
                    var southRouteDistance = 0;

                    //total distance of the entire route
                    while(y >= 1)
                    {
                       // console.log(record.get('listwp')[y].latitude + ',' + record.get('listwp')[y].longitude);
                        //console.log(record.get('listwp')[y-1].latitude + ',' + record.get('listwp')[y-1].longitude);
                        var total_distance = find_estimated_distance( record.get('listwp')[y].latitude, record.get('listwp')[y].longitude,
                            record.get('listwp')[y-1].latitude, record.get('listwp')[y-1].longitude );

                        southRouteDistance += total_distance;
                        SouthTotalDist += total_distance;

                        y--;

                    }
                    //console.log("from each stop: " + southRouteDistance + ' ');
                    //console.log("estimted time to arrival " + southRouteDistance/35*60*60 + ' seconds');



                   while(x < record.data.listwp.length){
                        var temp = new google.maps.LatLng(record.get('listwp')[x].latitude, record.get('listwp')[x].longitude); 
                        midSouthWayPoints.push(temp);
                        //console.log(record.get('listwp')[x].latitude)
                        x++;


                    }

                });
                //console.log("total distance of south route is: " + SouthTotalDist + ' ');
                var pathMS = new google.maps.Polyline({
                    path: midSouthWayPoints,
                    strokeColor: '#f08616',
                    strokeOpacity: 1.0,
                    strokeWeight: 5
                });
               pathMS.setMap(map);

               midSouthWayPoints = [];


            // Get Store for Middle North WayPoints
                waypointMidNorth = Ext.getStore('WayPointStore2');
                waypointMidNorth.load();

                waypointMidNorth.each(function(record,index,length){

                    var x = 0;

                   while(x < record.data.listwp.length){
                        var temp = new google.maps.LatLng(record.get('listwp')[x].latitude, record.get('listwp')[x].longitude); 
                        midNorthWayPoints.push(temp);
                        x++;
                    }

                });
                var pathMN = new google.maps.Polyline({
                    path: midNorthWayPoints,
                    strokeColor: '#f08616',
                    strokeOpacity: 1.0,
                    strokeWeight: 5
                });
               pathMN.setMap(map);

               midNorthWayPoints = [];


               //Get Store for High South WayPoints

                waypointHighSouth = Ext.getStore('WayPointStore3');
                waypointHighSouth.load();

                waypointHighSouth.each(function(record,index,length){

                    var x = 0;

                   while(x < record.data.listwp.length){
                        var temp = new google.maps.LatLng(record.get('listwp')[x].latitude, record.get('listwp')[x].longitude); 
                        highSouthWayPoints.push(temp);
                        // console.log(record.get('listwp')[x].latitude+','+ record.get('listwp')[x].longitude);
                        x++;
                    }

                });
                var pathHS = new google.maps.Polyline({
                    path: highSouthWayPoints,
                    strokeColor: '#40c5e6',
                    strokeOpacity: 0.65,
                    strokeWeight: 5
                });
               pathHS.setMap(map);

               highSouthWayPoints = [];



                //Get Store for High South WayPoints

                waypointHighNorth = Ext.getStore('WayPointStore4');
                waypointHighNorth.load();

                waypointHighNorth.each(function(record,index,length){

                    var x = 0;

                   while(x < record.data.listwp.length){
                        var temp = new google.maps.LatLng(record.get('listwp')[x].latitude, record.get('listwp')[x].longitude); 
                        highNorthWayPoints.push(temp);
                        //console.log(record.get('listwp')[x].latitude+','+ record.get('listwp')[x].longitude);
                        x++;
                    }

                });
                var pathHN = new google.maps.Polyline({
                    path: highNorthWayPoints,
                    strokeColor: '#40c5e6',
                    strokeOpacity: 0.65,
                    strokeWeight: 5
                });
               pathHN.setMap(map);

               highNorthWayPoints = [];


                store = Ext.getStore('MapStore');
                store.load();

                trolleys = [];


                //get store for the stops
                midSouth = Ext.getStore('MiddleSouthStore');
                midNorth = Ext.getStore('MiddleNorthStore');
                highSouth = Ext.getStore('HighSouthStore');
                highNorth = Ext.getStore('HighNorthStore');
                midSouth.load();
                midNorth.load();
                highSouth.load();
                highNorth.load();

      



                // shows the stops for High School South Route
                highSouth.each(function(record,index,length) {

                    var x = new google.maps.LatLng(record.data.latitude, record.data.longitude);

                    marker = new google.maps.Marker({
                        position: x,
                        animation: google.maps.Animation.DROP,
                        draggable: false,
                        id: record.data.stopId,
                        customInfo: record.data.routeId,
                        title: record.data.street,
                        icon: iconBase + 'bus.png'
                    });
                                //var holder = markerClick(marker,record.data.routeId, record.data.stopId);
                                
                            (function(i, marker) {
                                google.maps.event.addListener(marker, "click", function()  
                                    {  
                                        // Make an AJAX request to get the data  
                                        // The return will be put into the InfoWindow  
                                        Ext.Ajax.request({  
                                            url: "http://pm-dev.cs.fiu.edu:8080/ppmws/getTimes", 
                                            params: {
                                             "RouteId": record.data.routeId,
                                             "StopId": record.data.stopId
                                            },
                                            disableCaching: false,
                                            useDefaultXhrHeader: false, 
                                            success: function(data) {  
                                                 var jsonResp = Ext.JSON.decode(data.responseText);
                                                var infowindow = new google.maps.InfoWindow({
                                                        content: ''+ marker.getTitle() +'<br/>High School Route' +  '<br/>Scheduled Time ' + record.data.scheduledTime + '<br/>Estimated Time: ' + jsonResp.message//new google.maps.LatLng(block3[0],block3[1])
                                                    });
                                                    //infowindow2.setContent(data.responseText);  
                                                infowindow.open(map, marker);  
                                            }  
                                        });  
                                    });
                                })(i, marker);

                    marker.setMap(map);

                });

                // shows the stops for High School North Route
                highNorth.each(function(record,index,length) {

                    var x = new google.maps.LatLng(record.data.latitude, record.data.longitude);

                    marker = new google.maps.Marker({
                        position: x,
                        animation: google.maps.Animation.DROP,
                        draggable: false,
                        id: record.data.stopId,
                        customInfo: record.data.routeId,
                        title: record.data.street,
                        icon: iconBase + 'bus.png'
                    });


                                (function(i, marker) {
                                    // Creating the event listener. It now has access to the values of
                                    // i and marker as they were during its creation
                                    google.maps.event.addListener(marker, 'click', function() {

                                        Ext.Ajax.request({  
                                            url: "http://pm-dev.cs.fiu.edu:8080/ppmws/getTimes", 
                                            params: {
                                             "RouteId": record.data.routeId,
                                             "StopId": record.data.stopId
                                            },
                                            disableCaching: false,
                                            useDefaultXhrHeader: false, 
                                            success: function(data) {  
                                                 var jsonResp = Ext.JSON.decode(data.responseText);
                                                var infowindow = new google.maps.InfoWindow({
                                                    content: '' + marker.getTitle() + '<br/>High School Route' + '<br/>Scheduled Time ' + record.data.scheduledTime + '<br/>Estimated Time: ' + jsonResp.message//new google.maps.LatLng(block3[0],block3[1])
                                                    });
                                                    //infowindow2.setContent(data.responseText);  
                                                infowindow.open(map, marker);  
                                            }  
                                        }); 
                                    });
                                    })(i, marker);

                    marker.setMap(map);

                });

                // shows the stops for Middle School South Route
                midSouth.each(function(record,index,length) {

                    var x = new google.maps.LatLng(record.data.latitude, record.data.longitude);

                    marker = new google.maps.Marker({
                        position: x,
                        animation: google.maps.Animation.DROP,
                        draggable: false,
                        id: record.data.stopId,
                        customInfo: record.data.routeId,
                        title: record.data.street,
                        icon: iconBase + 'bus2.png'
                    });

                                (function(i, marker) {
                                    // Creating the event listener. It now has access to the values of
                                    // i and marker as they were during its creation
                                    google.maps.event.addListener(marker, 'click', function() {
                                        Ext.Ajax.request({  
                                            url: "http://pm-dev.cs.fiu.edu:8080/ppmws/getTimes", 
                                            params: {
                                             "RouteId": record.data.routeId,
                                             "StopId": record.data.stopId
                                            },
                                            disableCaching: false,
                                            useDefaultXhrHeader: false, 
                                            success: function(data) {  
                                                 var jsonResp = Ext.JSON.decode(data.responseText);
                                                var infowindow = new google.maps.InfoWindow({
                                                    content: '' + marker.getTitle() + '<br/>Middle School Route' + '<br/>Scheduled Time ' + record.data.scheduledTime + '<br/>Estimated Time: ' + jsonResp.message//new google.maps.LatLng(block3[0],block3[1])
                                                    });
                                                    //infowindow2.setContent(data.responseText);  
                                                infowindow.open(map, marker);  
                                            }  
                                        }); 
                                    });
                                    })(i, marker);

                    marker.setMap(map);

                });

                // shows the stops for Middle School North Route
                midNorth.each(function(record,index,length) {

                    var x = new google.maps.LatLng(record.data.latitude, record.data.longitude);

                    marker = new google.maps.Marker({
                        position: x,
                        animation: google.maps.Animation.DROP,
                        draggable: false,
                        id: record.data.stopId,
                        customInfo: record.data.routeId,
                        title: record.data.street,
                        icon: iconBase + 'bus2.png'
                    });
                        var currentTime = new Date()
                        var hours = currentTime.getHours()
                        var minutes = currentTime.getMinutes()
                        if (minutes < 10){
                        minutes = "0" + minutes
                        }
                        //console.log("current time is " + currentTime );
                        //console.log(hours + ":" + minutes + " ");


                                (function(i, marker) {
                                    // Creating the event listener. It now has access to the values of
                                    // i and marker as they were during its creation
                                    
                                     google.maps.event.addListener(marker, 'click', function() {
                                    //     if((currentTime.getHours() <= 8 && currentTime.getMinutes() < 30) || (hours > 9)){
                                    //     var infowindow = new google.maps.InfoWindow({
                                    //                     content: ''+ marker.getTitle() +'<br/>Middle School Route' +  '<br/>Scheduled Time ' + record.data.scheduledTime + '<br/>Not on the Route'//new google.maps.LatLng(block3[0],block3[1])
                                    //                 });
                                    //                 //infowindow2.setContent(data.responseText);  
                                    //             infowindow.open(map, marker);
                                    // }else{
                                        
                                        Ext.Ajax.request({  
                                            url: "http://pm-dev.cs.fiu.edu:8080/ppmws/getTimes", 
                                            params: {
                                             "RouteId": record.data.routeId,
                                             "StopId": record.data.stopId
                                            },
                                            disableCaching: false,
                                            useDefaultXhrHeader: false, 
                                            success: function(data) {  
                                                 var jsonResp = Ext.JSON.decode(data.responseText);
                                                var infowindow = new google.maps.InfoWindow({
                                                    content: '' + marker.getTitle() + '<br/>Middle School Route' + '<br/>Scheduled Time ' + record.data.scheduledTime + '<br/>Estimated Time: ' + jsonResp.message//new google.maps.LatLng(block3[0],block3[1])
                                                    });
                                                    //infowindow2.setContent(data.responseText);  
                                                infowindow.open(map, marker);  
                                            }  
                                        }); 
                                       // }
                                    });

                                    })(i, marker);

                    marker.setMap(map);

                });




                // On each store record
                store.each(function(record, index, length) {

                    // Get position
                                        //var m = new google.maps.LatLng(record.data.lastLatitude, record.data.lastLongitude);

                                // var allStops = [
                                //     [25.683558, -80.302937],[25.679579, -80.314014],[25.674111, -80.310723],
                                //     [25.672324, -80.309774],[25.670047, -80.310594],[25.669206, -80.314628],[25.673928, -80.317830],
                                //     [25.668423, -80.318685],[25.666770, -80.311508],[25.659658, -80.303406],[25.657376, -80.318258],
                                //     [25.655606, -80.314575],[25.651925, -80.313009],[25.654467, -80.318168],[25.655188, -80.327312],
                                //     [25.651581, -80.324233],[25.651474, -80.327800],[25.651408, -80.329799],[25.643997, -80.330056],
                                //     [25.644072, -80.325969],[25.644183, -80.321865],[25.645683, -80.321900],[25.644609, -80.307684],
                                //     [25.647133, -80.305715],[25.649387, -80.301740],[25.650818, -80.305817],[25.655838, -80.306032],
                                //     [25.647511, -80.293629],[25.653779, -80.290729],[25.655539, -80.290804],[25.647486, -80.293639],
                                //     [25.650833, -80.305817],[25.646519, -80.305731],[25.647196, -80.317854],[25.645668, -80.321910],
                                //     [25.645117, -80.326008],[25.645914, -80.326047],[25.644013, -80.330060],[25.647717, -80.329019],
                                //     [25.648631, -80.330221],[25.649666, -80.327764],[25.651407, -80.329754],[25.651460, -80.327796],
                                //     [25.655198, -80.327260],[25.655377, -80.322298],[25.661114, -80.316250],[25.659031, -80.325006],
                                //     [25.662501, -80.323666],[25.665944, -80.322421],[25.668420, -80.318673],[25.671978, -80.318802],
                                //     [25.673951, -80.317826],[25.669190, -80.314601],[25.672333, -80.309795],[25.679566, -80.314011],
                                //     [25.681500, -80.311029],[25.667100, -80.298287],[25.659692, -80.300003],[25.659650, -80.303408]
                                //     ];


                    // for(var r = 0; r < allStops.length; r++){
                    //     var stops = allStops[r];

                        //var estimatedTime = find_estimated_distance( record.data.lastLatitude, record.data.lastLongitude, stops[0], stops[1] );

                        var m = new google.maps.LatLng(record.data.lastLatitude, record.data.lastLongitude)

                    // Create marker
                    marker = new google.maps.Marker({
                        position: m,
                        animation: google.maps.Animation.DROP,
                        draggable: false,
                        icon: iconBase + 'logo_icon.png',
                        title: record.data.unitID
                    });

                marker.setMap(map);

                trolleys.push(marker);

                for( i = 0; i < trolleys.length; i++)
                {
                    var contentString = 'Trolley ID: ' + record.data.unitID + '<br/>Location: ' + record.data.address;


                    var infowindow = new google.maps.InfoWindow({
                          content: contentString
                      });

                    google.maps.event.addListener(marker, 'click', function() {
                        infowindow.open(map,this);
                      });
                }
                   setInterval(function() {

                 for( i = 0; i < trolleys.length; i++)
                 {
                    trolleys[i].setMap(null);
                 }
                 trolleys = [];

             }, 9000);

                });

    },

    launch: function() {

        var autocallFunction = function() {
        var task = Ext.create('Ext.util.DelayedTask', function() {
        var store, latLng, marker;
        var iconBase = 'resources/images/';
        var map = Ext.getCmp('mymap').getMap();
                // Get store
                store = Ext.getStore('MapStore');
                store.load();
                // On each store record
                var trolley = [];
                store.each(function(record, index, length) {

                    // Get position
                    var m = new google.maps.LatLng(record.data.lastLatitude, record.data.lastLongitude);


                        var m = new google.maps.LatLng(record.data.lastLatitude, record.data.lastLongitude)


                    // Create marker
                    marker = new google.maps.Marker({
                        position: m,
                        title: record.data.unitID,
                        draggable: false,

                        icon: iconBase + 'logo_icon.png'
                    });

                    trolley.push(marker);

                 setInterval(function() {

                 for( i = 0; i < trolley.length; i++)
                 {
                    trolley[i].setMap(null);
                 }

       
             }, 10000);

                     marker.setMap(map);
                     position = m;
                     marker.setPosition(position);

                    for( j = 0; j < trolley.length; j++)
                {
                    var contentString = 'Trolley ID: ' + record.data.unitID + '<br/>Location: ' + record.data.address;
                    //console.log(record.data.address);
                    var infowindow = new google.maps.InfoWindow({
                          content: contentString
                      });

                    google.maps.event.addListener(marker, 'click', function() {
                        infowindow.open(map,this);
                      });
                }

                });

                        autocallFunction.call(this);
                    }, this);

                    task.delay(10000);
                };
                autocallFunction();
    }


});

function near_meMidSouth( lat1, lon1 ) {  

    var allStops = [];

    var pi = Math.PI;
    var R = 6371; //equatorial radius
    var distances = [];
    var closest = -1;
    var lat3;
    var lon3;
    //var x;
    //var map = Ext.getCmp('mymap').getMap();

    stops1 = Ext.getStore('MiddleSouthStore');
    stops1.load()

    var markers = new Array();


    stops1.each(function(record,index,length){

                    markers.push({
                        latitude: record.data.latitude,
                        longitude: record.data.longitude
                    });

                });


//console.log(markers.length);
    for( i=0; i < markers.length; i++ ) {  
        var lat2 = markers[i].latitude;
        var lon2 = markers[i].longitude;

        var chLat = lat2-lat1;
        var chLon = lon2-lon1;

        var dLat = chLat*(pi/180);
        var dLon = chLon*(pi/180);

        var rLat1 = lat1*(pi/180);
        var rLat2 = lat2*(pi/180);

        var a = Math.sin(dLat/2) * Math.sin(dLat/2) + 
                    Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(rLat1) * Math.cos(rLat2); 
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        var d = R * c;

        distances[i] = d;
        if ( closest == -1 || d < distances[closest] ) {
            closest = i;
            lat3 = lat2;
            lon3 = lon2;
        }
    }
    return [lat3, lon3];
    
};

function near_meMidNorth( lat1, lon1 ) {  

    var allStops = [];

    var pi = Math.PI;
    var R = 6371; //equatorial radius
    var distances = [];
    var closest = -1;
    var lat3;
    var lon3;
    //var x;
    //var map = Ext.getCmp('mymap').getMap();

    stops2 = Ext.getStore('MiddleNorthStore');
    stops2.load();

    var markers = new Array();


    stops2.each(function(record,index,length){

                    markers.push({
                        latitude: record.data.latitude,
                        longitude: record.data.longitude
                    });

                });

//console.log(markers.length);
    for( i=0; i < markers.length; i++ ) {  
        var lat2 = markers[i].latitude;
        var lon2 = markers[i].longitude;

        var chLat = lat2-lat1;
        var chLon = lon2-lon1;

        var dLat = chLat*(pi/180);
        var dLon = chLon*(pi/180);

        var rLat1 = lat1*(pi/180);
        var rLat2 = lat2*(pi/180);

        var a = Math.sin(dLat/2) * Math.sin(dLat/2) + 
                    Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(rLat1) * Math.cos(rLat2); 
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        var d = R * c;

        distances[i] = d;
        if ( closest == -1 || d < distances[closest] ) {
            closest = i;
            lat3 = lat2;
            lon3 = lon2;
        }
    }
    return [lat3, lon3];
    
}; 

function near_meHighSouth( lat1, lon1 ) {  

    var allStops = [];

    var pi = Math.PI;
    var R = 6371; //equatorial radius
    var distances = [];
    var closest = -1;
    var lat3;
    var lon3;
    //var x;
    //var map = Ext.getCmp('mymap').getMap();

    stops3 = Ext.getStore('HighSouthStore');
    stops3.load();

    var markers = new Array();


    stops3.each(function(record,index,length){

                    markers.push({
                        latitude: record.data.latitude,
                        longitude: record.data.longitude
                    });

                });

//console.log(markers.length);
    for( i=0; i < markers.length; i++ ) {  
        var lat2 = markers[i].latitude;
        var lon2 = markers[i].longitude;

        var chLat = lat2-lat1;
        var chLon = lon2-lon1;

        var dLat = chLat*(pi/180);
        var dLon = chLon*(pi/180);

        var rLat1 = lat1*(pi/180);
        var rLat2 = lat2*(pi/180);

        var a = Math.sin(dLat/2) * Math.sin(dLat/2) + 
                    Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(rLat1) * Math.cos(rLat2); 
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        var d = R * c;

        distances[i] = d;
        if ( closest == -1 || d < distances[closest] ) {
            closest = i;
            lat3 = lat2;
            lon3 = lon2;
        }
    }
    return [lat3, lon3];
    
}; 

function near_meHighNorth(lat1, lon1){
    var allStops = [];

    var pi = Math.PI;
    var R = 6371; //equatorial radius
    var distances = [];
    var closest = -1;
    var lat3;
    var lon3;
    //var x;
    //var map = Ext.getCmp('mymap').getMap();

    stops4 = Ext.getStore('HighNorthStore');
    stops4.load();

    var markers = new Array();


    stops4.each(function(record,index,length){

                    markers.push({
                        latitude: record.data.latitude,
                        longitude: record.data.longitude
                    });

                });

//console.log(markers.length);
    for( i=0; i < markers.length; i++ ) {  
        var lat2 = markers[i].latitude;
        var lon2 = markers[i].longitude;

        var chLat = lat2-lat1;
        var chLon = lon2-lon1;

        var dLat = chLat*(pi/180);
        var dLon = chLon*(pi/180);

        var rLat1 = lat1*(pi/180);
        var rLat2 = lat2*(pi/180);

        var a = Math.sin(dLat/2) * Math.sin(dLat/2) + 
                    Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(rLat1) * Math.cos(rLat2); 
        var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
        var d = R * c;

        distances[i] = d;
        if ( closest == -1 || d < distances[closest] ) {
            closest = i;
            lat3 = lat2;
            lon3 = lon2;
        }
    }
    return [lat3, lon3];

};



function formatAMPM(date) {
  var hours = date.getHours();
  var minutes = date.getMinutes();
  var ampm = hours >= 12 ? 'pm' : 'am';
  hours = hours % 12;
  hours = hours ? hours : 12; // the hour '0' should be '12'
  minutes = minutes < 10 ? '0'+minutes : minutes;
  var strTime = hours + ':' + minutes + ' ' + ampm;
  return strTime;
};


function find_estimated_distance( lat1, lon1, lat2, lon2 ) {    

    var R = 6371/1.609344; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1); 
  var a = 
    Math.sin(dLat/2) * Math.sin(dLat/2) +
    Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
    Math.sin(dLon/2) * Math.sin(dLon/2)
    ; 
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  var d = R * c; // Distance in km

  //d = d * 3280.34; //distance in feet

  return d;  
}   ;

function deg2rad(deg) {
  return deg * (Math.PI/180)

};
