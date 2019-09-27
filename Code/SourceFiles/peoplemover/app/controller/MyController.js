/*
 * File: app/controller/MyController.js
 */

Ext.define('PeopleMover.controller.MyController', {
    extend: 'Ext.app.Controller',

    config: {
        stores: [
            'listRoutes'
        ],

        refs: {
            list: 'main #myroutelist',
            listDetail: 'widget.DetailList',
            titleList: '#titleList',
            back: '#backButton',
            aboutus: 'main #aboutUs',
            signIn: 'widget.signIn'
        },

        control: {
            "list": {
                itemtap: 'onActivityListItemTap'
            }
        }
    },

    onActivityListItemTap: function(dataview, index, target, record, e, eOpts) {
        var sample = Ext.create('widget.DetailList');

        //Ext.getCmp('titleList').setTitle(MyApp.view.MyContainer.itemTpl);
        var view = Ext.getCmp('titleList');
        view.setTitle('Stops');
        //view.titlebar.setTitle('{route}');
        Ext.Viewport.remove(Ext.Viewport.getActiveItem(), true);
        Ext.Viewport.setActiveItem(sample);

        //            var sample = Ext.create('MyApp.view.RouteDetailsList');

    },

    showSignInForm: function() {
        var popup = Ext.create('Ext.Panel', {
                    html: 'popup',
                    hideOnMaskTap: true,
                    modal: true
                });
    }

});