Ext.define('PeopleMover.model.WayPoints2', {
    extend: 'Ext.data.Model',

    requires: [
        'Ext.data.Field',
        'Ext.data.proxy.Rest'
    ],

    config: {
        fields: [
            {
                name: 'listwp'//,
            }
        ],

        proxy: {
            type: 'rest',
            url: 'http://pm-dev.cs.fiu.edu:8080/ppmws/getstopwaypoints?RouteId=2',
            useDefaultXhrHeader: false,
            reader: {
                type: 'json',
                rootProperty: 'listwp'
            }
        }
    }
});
