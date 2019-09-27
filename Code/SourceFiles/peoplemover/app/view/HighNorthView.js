/*
 * File: app/view/MiddleNorthView.js
 */

Ext.define('PeopleMover.view.HighNorthView', {
    extend: 'Ext.dataview.List',
    alias: 'widget.highnorthview',

    requires: [
        'Ext.XTemplate'
    ],

    config: {
        //store: 'HighNorthStore',
        onItemDisclosure: true,
        itemTpl: [
            '<div>{street}</div>'
        ]
    },
    initialize : function() {
                    this.callParent();
                     var currentTime = (new Date()).getHours();

            if(currentTime < 8 || currentTime >=19)
            {
                 
                var store = Ext.create('PeopleMover.store.HighNorthStore',{});
                store.load();
                this.setStore(store);
                this.refresh();
            }
            else{//(currentTime>= 9 || currentTime <= 19  )
                var store = Ext.create('PeopleMover.store.HighNorthStorePM',{});
                store.load();
                 this.setStore(store);
                this.refresh();
             }

                    
    }

});
