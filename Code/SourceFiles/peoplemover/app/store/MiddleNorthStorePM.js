/*
 * File: app/store/MiddleNorthStore.js
 *
 */

Ext.define('PeopleMover.store.MiddleNorthStorePM', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.MiddleNorthModelPM'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.MiddleNorthModelPM',
        remoteSort: true,
        storeId: 'MiddleNorthStorePM'
    }
});
