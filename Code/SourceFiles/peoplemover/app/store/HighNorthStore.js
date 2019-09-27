/*
 * File: app/store/HighNorthStore.js
 */

Ext.define('PeopleMover.store.HighNorthStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.HighNorthModel'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.HighNorthModel',
        remoteSort: true,
        storeId: 'HighNorthStore'
    }
});