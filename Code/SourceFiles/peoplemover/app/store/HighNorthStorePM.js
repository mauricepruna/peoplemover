/*
 * File: app/store/HighNorthStore.js
 */

Ext.define('PeopleMover.store.HighNorthStorePM', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.HighNorthModelPM'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.HighNorthModelPM',
        remoteSort: true,
        storeId: 'HighNorthStorePM'
    }
});