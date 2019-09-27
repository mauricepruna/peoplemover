/*
 * File: app/view/MyNavigationView.js
 */

Ext.define('PeopleMover.view.MyNavigationView', {
    extend: 'Ext.navigation.View',

    requires: [
        'Ext.dataview.List',
        'Ext.XTemplate'
    ],

    config: {
        itemId: 'routeView',
        items: [
            {
                xtype: 'list',
                itemId: 'myroutelist',
                itemTpl: [
                    '<div>{route}</div>'
                ],
                store: 'listRoutes'
            }
        ]
    }

});