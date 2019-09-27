/*
 * File: app/model/FavoriteList.js
 */

Ext.define('PeopleMover.model.FavoriteList', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field',
        'Ext.data.proxy.Rest'
    ],

    config: {
        fields: [
            {
                name: 'userToken'
            },
            {
                name: 'stopId'
            },
            {
                name: 'routeId'
            },
            {
                name: 'emailFlag'
            },
            {
                name: 'time'
            },
            {
                name: 'streetName'
            },
            {
                name: 'routeName'
            },
            {
                name: 'stopId'
            },
            {
                name: 'estimateTime'
            }
        ],
        proxy: {
            type: 'rest',
            url: 'http://pm-dev.cs.fiu.edu:8080/ppmws/getfavoritelist',
            extraParams:{
                'token' : localStorage.getItem("ppmtoken")
            },
            useDefaultXhrHeader: false
        }
    },
    test: function()
    {
        console.log("wah");
    }
});
