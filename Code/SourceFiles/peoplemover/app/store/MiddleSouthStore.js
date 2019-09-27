/*
 * File: app/store/MiddleSouthhStore.js
 */

Ext.define('PeopleMover.store.MiddleSouthStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.MiddleSouthModel'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.MiddleSouthModel',
        remoteSort: true,
        storeId: 'MiddleSouthStore'
    }
});