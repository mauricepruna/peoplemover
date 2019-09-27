Ext.define('PeopleMover.store.WayPointStore7', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints7',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints7',
        storeId: 'WayPointStore7'
    }
});