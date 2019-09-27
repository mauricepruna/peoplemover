/*
 * File: app/view/UnitListView.js
 */

Ext.define('PeopleMover.view.UnitListView', {
    extend: 'Ext.dataview.List',
    alias: 'widget.unitlistview',

    requires: [
        'Ext.XTemplate'
    ],

    config: {
        id: 'unitlistview',
        store: 'UnitListStore',
        onItemDisclosure: true,
        itemTpl: [
            '<div>{unitID} | {lastEventDate} <br />',
            '    {lastLatitude} |{lastLongitude}<br />',
            '    {address} | {speed}</div>'
        ]
    }

});
