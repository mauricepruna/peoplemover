/*
*	File: app/controller/FavoritesController.js
c925b617-0d79-4193-81b2-20f9b4f22356
*/

Ext.define('PeopleMover.controller.FavoritesController', {
	extend: 'Ext.app.Controller',

    requires: [
        'Ext.MessageBox',
        'Ext.picker.Picker'
    ],

	config: {
        models: [
            'FavoriteList'
        ],
        stores: [
            'FavoriteListStore'
        ],
        views: [
            'FavoriteView',
            'MainView'
        ],

        refs: {
            favView: 'favoriteStops'
        },

        control: {
            "favoriteStops": {
                itemtap: 'onListItemTap'
             },
             "#addAlert":{
				 tap: 'addAlert' 
			},
            "mainview #favoriteStops2":
            {
                tap: 'activeitemchange'
            }

			// "#deleteAlert":{
			// 	 tap: 'deleteAlert' 
			// }
        }
    },

    activeitemchange: function(){
        console.log("testing");
    },


    launch: function() {
         var autocallFunction = function() {
                    var task = Ext.create('Ext.util.DelayedTask', function() {
                        var favStop = Ext.getCmp('favoriteStops');
                        view = Ext.getStore('FavoriteListStore');
                        view.getProxy().setExtraParams({
							'token': localStorage.getItem('ppmtoken')
							});
                        view.load();
                        //console.log('callback!');
                        autocallFunction.call(this);
                    }, this);

                    task.delay(10000);
                };
                autocallFunction();

              


    },

    onListItemTap: function(dataview, index, target, record, e, eOpts) {
        var overlay;
        if (!overlay) {

                        overlay = Ext.Viewport.add({
                            xtype: 'panel',
                            modal: true,
                            //id: 'overlay',
                            itemId: 'overlay',
                            hideOnMaskTap: true,
                            showAnimation: {
                                type: 'popIn',
                                duration: 250,
                                easing: 'ease-out'
                            },
                            hideAnimation: {
                                type: 'popOut',
                                duration: 250,
                                easing: 'ease-out'
                            },
                            centered: true,
                            width:400,
                            height:400,
                            styleHtmlContent: true,
                            //html: '<p style="text-align:center">Find Nearest Stop per Route</p>',
                            items: [
                                {
                                    docked: 'top',
                                    xtype: 'toolbar',
                                    title: 'Choose Action for Stop ID: ' + record.data.stopId
                                },
                                {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'addAlert',
                                //id: 'addAlert',
                                style: 'background: white',
                                text: 'Add Alert Time',
                                handler: function() {
                                if (!this.picker) {
                                    this.picker = Ext.Viewport.add({
                                        xtype: 'picker',
                                        slots: [
                                            {
                                                name : 'alert_time',
                                                title: 'Alert',
                                                data : [
                                                    {text: '5 minutes', value: 5},
                                                    {text: '10 minutes', value: 10},
                                                    {text: '15 minutes', value: 15}
                                                ]
                                            }
                                        ],
                                        listeners : {
                                            change : function (picker, value) {
                                                //console.log(value.alert_time);
                                                var successCallback = function(resp, ops) {

                                                            // Ext.Msg.alert("Favorite Stop removed");
                                                            var jsonResp = Ext.JSON.decode(resp.responseText);
                                       Ext.Msg.alert("Info","message:"+jsonResp.message);
                                                            view = Ext.getStore('FavoriteListStore');
                                                            view.load();
                                                           //button.setDisabled(false);
                                                           overlay.hide()
                                                        };

                                            var failureCallback = function(resp, ops) {

                                                            Ext.Msg.alert("Something went wrong");
                                                           //button.setDisabled(false);
                                                           overlay.hide();
                                                        };

                                                var temp = Ext.Ajax.request({  
                                                url: "http://pm-dev.cs.fiu.edu:8080/ppmws/setalarm",
                                                        method: 'POST', 
                                                params: {
                                                    "token": record.data.userToken,
                                                    "routeid": record.data.routeId,
                                                    "stopid": record.data.stopId,
                                                    "emailflag" : "true",
                                                    "time" : value.alert_time,
                                                    "remove": "false"
                                                    },
                                                disableCaching: false,
                                                useDefaultXhrHeader: false, 
                                                success: successCallback,
                                                failure: failureCallback 
                                        });


                                            }
                                        }
                                    });
                                }

                                this.picker.show();
                            }

                                },
                                {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                //id: 'deleteAlert',
                                itemId: 'deleteAlert',
                                style: 'background: white',
                                text: 'Delete',
                                handler : function(){
                                    var successCallback = function(resp, ops) {

                                                            // Ext.Msg.alert("Favorite Stop removed");
                                                            var jsonResp = Ext.JSON.decode(resp.responseText);
                                       Ext.Msg.alert("Info","message:"+jsonResp.message);
                                                            view = Ext.getStore('FavoriteListStore');
                                                            view.load();
                                                           //button.setDisabled(false);
                                                           overlay.hide()
                                                        };

                                            var failureCallback = function(resp, ops) {

                                                            Ext.Msg.alert("Something went wrong");
                                                           //button.setDisabled(false);
                                                           overlay.hide();
                                                        };


                                            Ext.Msg.confirm('Delete Stop', 'Do you want to remove this from your favorite stops?', 
                                    function(btn) {
                                        //console.log("overlay is " + update(record.data.stopId));
                                        if(btn === 'yes'){
                                            //console.log(record.data);
                                            var temp = Ext.Ajax.request({  
                                                url: "http://pm-dev.cs.fiu.edu:8080/ppmws/setalarm",
                                                        method: 'POST', 
                                                params: {
                                                    "token": record.data.userToken,
                                                    "routeid": record.data.routeId,
                                                    "stopid": record.data.stopId,
                                                    "remove": "true"
                                                    },
                                                disableCaching: false,
                                                useDefaultXhrHeader: false, 
                                                success: successCallback,
                                                failure: failureCallback 
                                        });
                                        }
                                    });
                                }
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                //id: 'deleteAlert',
                                itemId: 'deactiveAlert',
                                style: 'background: white',
                                text: 'Deactivate Alert',
                                handler : function(){
                                    var successCallback = function(resp, ops) {

                                                            // Ext.Msg.alert("Favorite Stop removed");
                                                            var jsonResp = Ext.JSON.decode(resp.responseText);
                                       Ext.Msg.alert("Info","message:"+jsonResp.message);
                                                            view = Ext.getStore('FavoriteListStore');
                                                            view.load();
                                                           //button.setDisabled(false);
                                                           overlay.hide()
                                                        };

                                            var failureCallback = function(resp, ops) {

                                                            Ext.Msg.alert("Something went wrong");
                                                           //button.setDisabled(false);
                                                           overlay.hide();
                                                        };


                                            Ext.Msg.confirm('Deactivate Alert', 'Do you want to remove alerts for this stop?', 
                                    function(btn) {
                                        //console.log("overlay is " + update(record.data.stopId));
                                        if(btn === 'yes'){
                                            //console.log(record.data);
                                            var temp = Ext.Ajax.request({  
                                                url: "http://pm-dev.cs.fiu.edu:8080/ppmws/setalarm",
                                                        method: 'POST', 
                                                params: {
                                                    "token": record.data.userToken,
                                                    "routeid": record.data.routeId,
                                                    "stopid": record.data.stopId,
                                                    "emailflag" : "false",
                                                    //"time" : value.alert_time,
                                                    "remove": "false"
                                                    },
                                                disableCaching: false,
                                                useDefaultXhrHeader: false, 
                                                success: successCallback,
                                                failure: failureCallback 
                                        });
                                        }
                                    });
                                }
                            }                              
                            ],
                            scrollable: true
                        });
                    }
                    overlay.show();
    }

	});
