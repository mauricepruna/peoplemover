/*
 * File: app/controller/UnitListController.js
 */

Ext.define('PeopleMover.controller.UnitListController', {
    extend: 'Ext.app.Controller',

    requires: [
        'Ext.util.DelayedTask'
    ],

    config: {
        models: [
            'UnitList'
        ],
        stores: [
            'UnitListStore'
        ],
        views: [
            'UnitListView'
        ]
    },

    launch: function() {
         //~ var autocallFunction = function() {
                    //~ var task = Ext.create('Ext.util.DelayedTask', function() {
                        //~ var list = Ext.getCmp('unitlistview');
                        //~ list.getStore().load();
                        //~ list.refresh();
                        //~ //console.log('callback!');
                        //~ autocallFunction.call(this);
                    //~ }, this);
//~ 
                    //~ task.delay(10000);
                //~ };
//~ 
//~ 
                //~ autocallFunction();
    }

});
