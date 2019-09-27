/*
 * File: app/model/UnitList.js
 */

Ext.define('PeopleMover.model.UnitList', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field',
        'Ext.data.proxy.Rest'
    ],

    config: {
        fields: [
            {
                name: 'shortName'
            },
            {
                name: 'city'
            },
            {
                name: 'postalCode'
            },
            {
                name: 'countryCode'
            },
            {
                name: 'lastEventDate'
            },
            {
                name: 'unitID'
            },
            {
                name: 'lastLatitude'
            },
            {
                name: 'lastLongitude'
            },
            {
                name: 'licencePlate'
            },
            {
                name: 'serialNumber'
            },
            {
                name: 'imei'
            },
            {
                name: 'lastEventCode'
            },
            {
                name: 'eventName'
            },
            {
                name: 'speed'
            },
            {
                name: 'direction'
            },
            {
                name: 'dealerID'
            },
            {
                name: 'companyID'
            },
            {
                name: 'contactName'
            },
            {
                name: 'iconPath'
            },
            {
                name: 'assignedDriver'
            },
            {
                name: 'driverID'
            },
            {
                name: 'localLastEventDatetxt'
            },
            {
                name: 'id'
            },
            {
                name: 'description'
            },
            {
                name: 'address'
            },
            {
                name: 'state'
            }
        ],
        proxy: {
            type: 'rest',
            url: 'http://pm-dev.cs.fiu.edu:8080/ppmws/getunitlist',
            useDefaultXhrHeader: false
        }
    }
});