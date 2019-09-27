Ext.define('PeopleMover.view.FavoriteView', {
    extend: 'Ext.dataview.List',
    alias: 'widget.favoriteStops',

    requires: [
        'Ext.form.FieldSet',
        'Ext.field.Text',
        'Ext.XTemplate',
        'Ext.Button'
    ],

    config: {
        id: 'favoriteStops',
        autoLoad: true,
        itemId: 'favoriteStops',
        store: 'FavoriteListStore',
        //title: "test",

        //scrollable: vertical,
        onItemDisclosure: true,
        itemTpl: [
            '<div>Address: {streetName} <br/>Route: {routeName} <br />',
            'Stop ID: {stopId} <br/> Estimated Time: {estimateTime}<br />',
            'Alert Time: {time}</div>'
        ]
        

 }

});



