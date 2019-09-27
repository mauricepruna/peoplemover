/*
 * File: app/store/MiddleNorthStore.js
 */

Ext.define('PeopleMover.store.MiddleNorthStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.MiddleNorthModel'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.MiddleNorthModel',
        remoteSort: true,
        storeId: 'MiddleNorthStore'
    }
});