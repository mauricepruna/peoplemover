/*
 * File: app/view/MiddleNorthView.js
 */

Ext.define('PeopleMover.view.MiddleNorthView', {
    extend: 'Ext.dataview.List',
    alias: 'widget.middlenorthview',

    requires: [
        'Ext.XTemplate'
    ],

    config: {
        //store: 'MiddleNorthStore',
        onItemDisclosure: true,
        itemTpl: [
            '<div>{street}</div>'
        ]
    },
    initialize : function() {
                    this.callParent();
                     var currentTime = (new Date()).getHours();
			
            if(currentTime < 9 || currentTime >= 5)
            {
                 
                var store = Ext.create('PeopleMover.store.MiddleNorthStore',{});
                store.load();
                this.setStore(store);
                this.refresh();
            }
            else{//(currentTime >= 9 || currentTime <= 19  )
                var store = Ext.create('PeopleMover.store.MiddleNorthStorePM',{});
                store.load();
                 this.setStore(store);
                this.refresh();
             }

                    
    }

});
