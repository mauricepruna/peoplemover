Ext.define('PeopleMover.store.WayPointStore6', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints6',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints6',
        storeId: 'WayPointStore6'
    }
});