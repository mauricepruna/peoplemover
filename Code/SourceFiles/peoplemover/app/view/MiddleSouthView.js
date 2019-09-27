/*
 * File: app/view/MiddleSouthView.js
 */

Ext.define('PeopleMover.view.MiddleSouthView', {
    extend: 'Ext.dataview.List',
    alias: 'widget.middlesouthview',

    requires: [
        'Ext.XTemplate'
    ],

    config: {
        //store: 'MiddleSouthStore',
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
                 
                var store = Ext.create('PeopleMover.store.MiddleSouthStore',{});
                store.load();
                this.setStore(store);
                this.refresh();
            }
            else{//(currentTime >= 9 || currentTime <= 19  )
                var store = Ext.create('PeopleMover.store.MiddleSouthStorePM',{});
                store.load();
                 this.setStore(store);
                this.refresh();
             }

                    
    }

});
