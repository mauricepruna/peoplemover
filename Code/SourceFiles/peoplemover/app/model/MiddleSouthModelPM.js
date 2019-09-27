Ext.define('PeopleMover.model.MiddleSouthModelPM', {
    extend: 'Ext.data.Model',
 requires: [
        'Ext.data.Field',
        'Ext.data.proxy.Rest'
    ],

    config: {
        fields: [
            {
                name: 'stopId',
                type: 'int'
            },
            {
                name: 'routeId'
            },
            {
                name: 'street'
            },
            {
                name: 'latitude'
            },
            {
                name: 'longitude'
            },
            {
                name: 'scheduledTime'
            }
        ],
        proxy: {
            type: 'rest',
            url: 'http://pm-dev.cs.fiu.edu:8080/ppmws/getstops?RouteId=5',
            useDefaultXhrHeader: false
        }
    }
});