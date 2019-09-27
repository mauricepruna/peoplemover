/*
 * File: app/view/MainView.js
 */

Ext.define('PeopleMover.view.MainView', {
    extend: 'Ext.navigation.View',
    alias: 'widget.mainview',

    requires: [
        'PeopleMover.view.UnitListView',
        'PeopleMover.view.MyMap',
        'PeopleMover.view.TrolleyAlerts',
        'Ext.tab.Panel',
        'Ext.tab.Bar',
        'Ext.Button',
        'Ext.dataview.List',
        'Ext.Map',
        'Ext.navigation.Bar',
        'Ext.Img'
    ],

    config: {
        items: [
            {
                xtype: 'tabpanel',
                activeItem: 2,
                id: 'myTabPanel',
                itemId: 'myTabPanel',
                tabBar: {
                    docked: 'bottom',
                    layout: {
                        type: 'hbox',
                        pack: 'center'
                    }
                },
                            listeners: {
        activeitemchange : function() {
            //console.log('hey!!!');
            //var items = this.getActiveItem();
            var activeItem = this.getActiveItem(); //The currently selected item
            var innerItems = this.getInnerItems();
            var idx = Ext.Array.indexOf(innerItems, activeItem);
            //alert("items is: " + idx);
            if(idx == 2 /*&& Ext.getCmp('hideButton').hide() == false*/)
            {
                Ext.getCmp('nearme').show();
            }else{
                Ext.getCmp('nearme').hide();
            }

            //button[action]();
        }
    },
                items: [
                    {
                        xtype: 'container',
                        title: 'Routes',
                        iconCls: 'info',
                        items: [
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'bhighnorth',
                                style: 'background: white',
                                text: 'Palmetto High North Route'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'bhighsouth',
                                style: 'background: white',
                                text: 'Palmetto High South Route'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'bmiddlenorth',
                                style: 'background: white',
                                text: 'Palmetto Middle North Route'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'bmiddlesouth',
                                style: 'background: white',
                                text: 'Palmetto Middle South Route'
                            }
                        ]
                    },
                    {
                         xtype: 'favoriteStops',
                        id: 'favoriteStops',
                        itemId: 'favoriteStops2',
                        title: 'Favorites',
                        iconCls: 'star'
                    },
                    {
                        xtype: 'mymap',
                        title: 'Map',
                        iconCls: 'maps'
                    },
                    {
                        xtype: 'trolleyalerts',
                        id: 'btrolleyalerts',
                        itemId: 'btrolleyalerts',
                        title: 'Trolley Alerts',
                        iconCls: 'info'
                    },
                    {
                        xtype: 'container',
                        title: 'More',
                        iconCls: 'more',
                        padding: '',
                        items: [
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'aboutUs',
                                style: 'background: white',
                                iconCls: 'team',
                                text: 'About Us'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'reportProblem',
                                style: 'background:white',
                                iconCls: 'info',
                                text: 'Report a Problem'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'requestStop',
                                style: 'background:white',
                                iconCls: 'add',
                                text: 'Request A Stop'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'feedback',
                                style: 'background:white',
                                iconCls: 'reply',
                                text: 'Enter Feedback'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'serviceTimes',
                                style: 'background:white',
                                iconCls: 'info',
                                text: 'Service Times'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                id: 'showLoginButton',
                                itemId: 'showLoginButton',
                                style: 'background:white',
                                iconCls: 'user',
                                text: 'Login'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                id: 'showRegisterButton',
                                itemId: 'showRegisterButton',
                                style: 'background:white',
                                iconCls: 'user',
                                text: 'Registration'
                            }
                        ]
                    }
                ]
            }
        ],
        navigationBar: {
            docked: 'top',
            items: [
                {
                    xtype: 'titlebar',
                    align: 'right',
                    docked: 'top',
                    items: [
                        {
                            xtype: 'image',
                            height: 50,
                            width: 150,
                            src: 'resources/images/word_pvlogo.png'
                        }
                    ]
                },                 
                {
                text: 'Near Me',
                hidden: false,
                    id: 'nearme',
                    itemId: 'nearme',
                handler: function() {
                    if (!this.overlay) {
                        this.overlay = Ext.Viewport.add({
                            xtype: 'panel',
                            modal: true,
                            id: 'overlay',
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
                                    title: 'Choose Route'
                                },
                                {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                itemId: 'bhighnorthRoute',
                                id: 'bhighnorthRoute',
                                style: 'background: white',
                                text: 'Palmetto High North Route'
                                },
                                {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                id: 'bhighsouthRoute',
                                itemId: 'bhighsouthRoute',
                                style: 'background: white',
                                text: 'Palmetto High South Route'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                id: 'bmiddlenorthRoute',
                                itemId: 'bmiddlenorthRoute',
                                style: 'background: white',
                                text: 'Palmetto Middle North Route'
                            },
                            {
                                xtype: 'button',
                                border: 1,
                                height: '50px',
                                id: 'bmiddlesouthRoute',
                                itemId: 'bmiddlesouthRoute',
                                style: 'background: white',
                                text: 'Palmetto Middle South Route'
                            }
                                
                            ],
                            scrollable: true
                        });
                    }

                    this.overlay.show();
                }
            }
            ]
        }
    }

});
