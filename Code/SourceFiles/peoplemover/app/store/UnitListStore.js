/*
 * File: app/store/UnitListStore.js
 */

Ext.define('PeopleMover.store.UnitListStore', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.UnitList',
        'Ext.util.Sorter'
    ],

    config: {
        autoLoad: true,
        model: 'PeopleMover.model.UnitList',
        storeId: 'UnitListStore',
        sorters: [
            {
                property: 'id'
            },
            {
                property: 'unitID'
            }
        ]
    }
});