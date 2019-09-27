Ext.define('PeopleMover.store.WayPointStore2', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints2',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints2',
        storeId: 'WayPointStore2'
    }
});