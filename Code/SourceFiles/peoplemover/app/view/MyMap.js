/*
 * File: app/view/MyMap.js
 */

Ext.define('PeopleMover.view.MyMap', {
    extend: 'Ext.Map',
    alias: 'widget.mymap',
    store: 'MapStore',

    requires: [
        'Ext.data.Store'
        ],

    config: {
        id: 'mymap',
        itemId: 'mymap',
        //useCurrentLocation: true,
        mapListeners: '//test',
        mapOptions: {
            center: new google.maps.LatLng(25.662715,
            -80.308101),
            zoom: 14,
            navigationControl: true,
            disableDefaultUI: true
            
        },
        monitorResize : true,
		 listeners: {
			onResize: function() {
				console.log('MAP');
				  var gmap = this.getMap();
				  if(gmap)
				  {
					  console.log('MAP painted');
						google.maps.event.trigger(gmap.map, 'resize');
					}
			}
		}
    },

    initialize: function() {
        var gMap = this.getMap();




                var task = Ext.create('Ext.util.DelayedTask', function() {
                    //load the list's store here. The list will be automatically updated
                    listComp.getStore().load();    // Assuming your list component is "listComp"
                    listComp.refresh();

                    // The task will be called after each 10000 ms
                    task.delay(10000);
                }, this);



                var maprender = function() {
                                	        // Get a ref to the google map object (should be provided
                                	        // as an argument to the listener but apparently there is
                                	        // a bug...)
                                	//var gMap = this.getMap();
                                	var directionsService;
                                	var directionsDisplay;
                                	var rendererOptions = {
                                		map: gMap
                                	};
                                	directionsDisplay = new google.maps.DirectionsRenderer(rendererOptions);

                                	directionsService = new google.maps.DirectionsService();

                                	        //1st stop 25.665225, -80.30050699999998
                                	        var iconBase = 'resources/images/';


                                                    




                              	};
                                //closestStop();
                                maprender();
                                
                               //this.on('activate', function(component){ google.maps.event.trigger(gMap.map, 'resize');});
           

    }

});
