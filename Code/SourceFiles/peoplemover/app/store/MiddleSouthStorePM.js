/*
 * File: app/store/MiddleSouthhStore.js
 */

Ext.define('PeopleMover.store.MiddleSouthStorePM', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.MiddleSouthModelPM'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.MiddleSouthModelPM',
        remoteSort: true,
        storeId: 'MiddleSouthStorePM'
    }
});