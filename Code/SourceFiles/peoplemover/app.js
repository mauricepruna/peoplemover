/*
 * File: app.js
 */

// @require @packageOverrides
Ext.Loader.setConfig({

});


Ext.application({

    requires: [
        'Ext.device.Camera',
        'Ext.util.Geolocation' 
    ],
    models: [
        'routeInfo',
        'UnitList',
        'WayPoints1',
        'WayPoints2',
        'WayPoints3',
        'WayPoints4',
        'WayPoints5',
        'WayPoints6',
        'WayPoints7',
        'WayPoints8',
        'MapLocations',
        'MiddleNorthModel',
        'MiddleNorthModelPM',
        'MiddleSouthModel',
        'MiddleSouthModelPM',
        'HighNorthModel',
        'HighNorthModelPM',
        'HighSouthModel',
        'HighSouthModelPM',
        'FavoriteList'
    ],
    stores: [
        'listRoutes',
        'WayPointStore1',
        'WayPointStore2',
        'WayPointStore3',
        'WayPointStore4',
        'WayPointStore5',
        'WayPointStore6',
        'WayPointStore7',
        'WayPointStore8',
        'UnitListStore',
        'MapStore',
        'MiddleSouthStore',
        'MiddleSouthStorePM',
        'MiddleNorthStore',
        'MiddleNorthStorePM',
        'HighNorthStore',
        'HighNorthStorePM',
        'HighSouthStore',
        'HighSouthStorePM',
        'FavoriteListStore'
    ],
    views: [
        'RouteDetailsList',
        'FeedBackView',
        'Problem',
        'requestStop',
        'MyNavigationView',
        'UnitListView',
        'MyMap',
        'LoginForm',
        'RegisterForm',
        'MainView',
        'MiddleNorthView',
        'MiddleSouthView',
        'HighNorthView',
        'HighSouthView',
        'AboutUs',
        'EstTimeView',
        'ServiceTimes',
        'TrolleyAlerts',
        'FavoriteView'
    ],
    controllers: [
        'MyController',
        'UnitListController',
        'UserController',
        'MapController',
        'StopController',
        'AlertsController',
        'FavoritesController'
    ],
    name: 'PeopleMover',

    launch: function() {
        Ext.fly('appLoadingImage').destroy();
              Ext.fly('appLoadingIndicator').destroy();
        Ext.create('PeopleMover.view.MainView', {fullscreen: true});
    }

});
