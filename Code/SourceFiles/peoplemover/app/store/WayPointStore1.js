Ext.define('PeopleMover.store.WayPointStore1', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints1',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints1',
        storeId: 'WayPointStore1'
    }
});