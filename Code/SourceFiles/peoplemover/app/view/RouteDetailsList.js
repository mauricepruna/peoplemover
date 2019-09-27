/*
 * File: app/view/RouteDetailsList.js
 */

Ext.define('PeopleMover.view.RouteDetailsList', {
    extend: 'Ext.dataview.List',
    alias: 'widget.DetailList',

    requires: [
        'Ext.XTemplate',
        'Ext.TitleBar',
        'Ext.Button',
        'Ext.Panel'
    ],

    config: {
        id: 'titeList',
        itemTpl: [
            '<div>List Item {string}</div>'
        ],
        items: [
            {
                xtype: 'titlebar',
                docked: 'top',
                id: 'titleList',
                items: [
                    {
                        xtype: 'button',
                        docked: 'top',
                        itemId: 'mybutton',
                        ui: 'back',
                        text: 'Back'
                    }
                ]
            },
            {
                xtype: 'panel',
                docked: 'top'
            }
        ],
        listeners: [
            {
                fn: 'onBackButtonTap',
                event: 'tap',
                order: 'before',
                delegate: '#mybutton'
            }
        ]
    },

    onBackButtonTap: function(button, e, eOpts) {
        var sample = Ext.create('widget.main');
        Ext.getCmp('myTabPanel').setActiveItem(0);
        Ext.Viewport.remove(Ext.Viewport.getActiveItem(), true);
            Ext.Viewport.setActiveItem(sample);

    }

});