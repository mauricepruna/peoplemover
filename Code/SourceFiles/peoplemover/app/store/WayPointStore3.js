Ext.define('PeopleMover.store.WayPointStore3', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints3',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints3',
        storeId: 'WayPointStore3'
    }
});