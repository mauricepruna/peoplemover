/*
 * File: app/view/TrolleyAlerts.js
 */

Ext.define('PeopleMover.view.TrolleyAlerts', {
    extend: 'Ext.Container',
    alias: 'widget.trolleyalerts',

    requires: [
        'Ext.form.FieldSet',
        'Ext.Button',
        'Ext.field.TextArea'
    ],

    config: {
        items: [
            {
                xtype: 'fieldset',
                title: 'Trolley Alerts',
                items: [
                    {
                        xtype: 'button',
                        itemId: 'bAlert',
                        ui: 'decline',
                        width: '100%',
                        text: 'ALERTS'
                    },
                    {
                        xtype: 'textareafield',
                        height: 259,
                        id: 'alertfield',
                        label: '',
                        labelAlign: 'top',
                        readOnly: true
                    }
                ]
            }
        ]
    }

});