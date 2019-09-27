/*
 * File: app/store/FavoriteListStore.js
 */

Ext.define('PeopleMover.store.FavoriteListStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.FavoriteList',
        'Ext.util.Sorter'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.FavoriteList',
        storeId: 'FavoriteListStore'
        // sorters: [
        //     {
        //         property: 'id'
        //     },
        //     {
        //         property: 'unitID'
        //     }
        // ]
    }
});
