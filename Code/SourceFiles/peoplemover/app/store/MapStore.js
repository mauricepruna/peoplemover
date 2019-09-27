/*
 * File: app/store/MapStore.js
 */

Ext.define('PeopleMover.store.MapStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.MapLocations',
        'Ext.util.Sorter'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.MapLocations',
        storeId: 'MapStore'
    }
});