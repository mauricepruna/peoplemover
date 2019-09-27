/*
 * File: app/view/EstTimeView.js
 */

Ext.define('PeopleMover.view.EstTimeView', {
    extend: 'Ext.Container',
    alias: 'widget.esttimeview',

    requires: [
        'Ext.form.FieldSet',
        'Ext.Button',
        'Ext.Spacer',
        'Ext.XTemplate'
    ],

    config: {
        id: 'esttimeview',
        itemId: "esttimeview",
        scrollable: 'vertical',
        items: [
            {
                xtype: 'fieldset',
                tpl: [
                    '<tpl for="."><br>',
                    '<h3><b>Stop Name:</b></h3><h3>{street}</h3>',
                    '    <h3><b>Scheduled Time:</b></h3><h3>{scheduledTime}</h3>',
                    '<h3><b>Estimated Time:</b></h3><h3>{estimated}</h3></tpl>'
                ],
                title: 'Stop Description ',
                items: [
                    {
                        xtype: 'button',
                        border: 1,
                        centered: false,
                        disabled: false,
                        height: '50px',
                        hidden: false,
                        id: 'bfavorite',
                        itemId: 'bfavorite',
                        ui: 'action-round',
                        width: '100%',
                        iconAlign: 'center',
                        iconCls: 'favorites',
                        text: 'Save as Favorite<br>You Have To Log In'
                    },
                    {
                        xtype: 'spacer',
                        height: 30
                    }
                ]
            }
        ]
    },

    initialize: function() {
        this.callParent();
            if(localStorage.getItem("ppmtoken")!==null)
            {
                 var mybutton = this.down('#bfavorite');
                mybutton.setText('Save as Favorite');
                mybutton.enable();
            }
    }

});
