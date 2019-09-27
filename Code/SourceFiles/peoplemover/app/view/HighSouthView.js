/*
 * File: app/view/MiddleSouthView.js
 */

Ext.define('PeopleMover.view.HighSouthView', {
    extend: 'Ext.dataview.List',
    alias: 'widget.highsouthview',

    requires: [
        'Ext.XTemplate'
    ],

    config: {
        //store: 'HighSouthStore',
        onItemDisclosure: true,
        itemTpl: [
            '<div>{street}</div>'
        ]
    },
    initialize : function() {
                    this.callParent();
                     var currentTime = (new Date()).getHours();
			
            if(currentTime < 8 || currentTime >= 19)
            {
                 
                var store = Ext.create('PeopleMover.store.HighSouthStore',{});
                store.load();
                this.setStore(store);
                this.refresh();
            }
            else{//(currentTime>= 9 || currentTime <=19  )
                var store = Ext.create('PeopleMover.store.HighSouthStorePM',{});
                store.load();
                 this.setStore(store);
                this.refresh();
             }

                    
    }

});
