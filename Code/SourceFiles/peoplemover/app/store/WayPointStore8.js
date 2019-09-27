Ext.define('PeopleMover.store.WayPointStore8', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints8',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints8',
        storeId: 'WayPointStore8'
    }
});