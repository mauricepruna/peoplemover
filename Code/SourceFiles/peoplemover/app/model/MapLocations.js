/*
 * File: app/model/MapLocations.js
 */

Ext.define('PeopleMover.model.MapLocations', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field',
        'Ext.data.proxy.Rest'
    ],

    config: {
        fields: [
            {
                name: 'lastLatitude'
            },
            {
                name: 'lastLongitude'
            },
            {
                name: 'unitID'
            },
            {
                name: 'address'
            }
        ],
        proxy: {
            type: 'rest',
            url: 'http://pm-dev.cs.fiu.edu:8080/ppmws/getunitlist',
            useDefaultXhrHeader: false
        }
    }
});