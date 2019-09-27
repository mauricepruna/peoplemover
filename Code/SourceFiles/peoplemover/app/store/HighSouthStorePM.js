/*
 * File: app/store/HighSouthhStore.js
 */

Ext.define('PeopleMover.store.HighSouthStorePM', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.HighSouthModelPM'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.HighSouthModelPM',
        remoteSort: true,
        storeId: 'HighSouthStorePM'
    }
});