Ext.define('PeopleMover.store.WayPointStore4', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.WayPoints4',
        'Ext.data.Store'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.WayPoints4',
        storeId: 'WayPointStore4'
    }
});