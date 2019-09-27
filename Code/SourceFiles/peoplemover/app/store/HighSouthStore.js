/*
 * File: app/store/HighSouthhStore.js
 */

Ext.define('PeopleMover.store.HighSouthStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.HighSouthModel'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.HighSouthModel',
        remoteSort: true,
        storeId: 'HighSouthStore'
    }
});