/*
 * File: app/model/routeInfo.js
 */

Ext.define('PeopleMover.model.routeInfo', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field'
    ],

    config: {
        fields: [
            {
                name: 'route'
            }
        ]
    }
});