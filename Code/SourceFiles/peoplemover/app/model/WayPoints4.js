Ext.define('PeopleMover.model.WayPoints4', {
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
            url: 'http://pm-dev.cs.fiu.edu:8080/ppmws/getstopwaypoints?RouteId=4',
            useDefaultXhrHeader: false,
            reader: {
                type: 'json',
                rootProperty: 'listwp'
            }
        }
    }
});
