Ext.define('PeopleMover.store.WayPointStore5', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints5',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints5',
        storeId: 'WayPointStore5'
    }
});