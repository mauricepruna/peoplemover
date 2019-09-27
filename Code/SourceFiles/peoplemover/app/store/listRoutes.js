/*
 * File: app/store/listRoutes.js
 */

Ext.define('PeopleMover.store.listRoutes', {
    extend: 'Ext.data.Store',

    requires: [
        'PeopleMover.model.routeInfo'
    ],

    config: {
        data: [
            {
                route: 'Palmetto High School North Route'
            },
            {
                route: 'Palmetto High School South Route'
            },
            {
                route: 'Palmetto Middle School North Route'
            },
            {
                route: 'Palmetto Middle School South Route'
            }
        ],
        model: 'PeopleMover.model.routeInfo',
        storeId: 'listRoutes'
    }
});