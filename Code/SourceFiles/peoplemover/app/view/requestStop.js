/*
 * File: app/view/requestStop.js
 */

Ext.define('PeopleMover.view.requestStop', {
    extend: 'Ext.form.Panel',
    alias: 'widget.requestStop',

    requires: [
        'Ext.form.FieldSet',
        'Ext.field.Email',
        'Ext.field.TextArea',
        'Ext.Button'
    ],

    config: {
        fullscreen: true,
        items: [
            {
                xtype: 'fieldset',
                items: [
                    {
                        xtype: 'textfield',
                        label: 'Name',
                        labelWrap: true,
                        name: 'nameBox',
                        required: true
                    },
                    {
                        xtype: 'emailfield',
                        label: 'Email',
                        labelWrap: true,
                        name: 'emailBox',
                        required: true,
                        placeHolder: 'email@example.com'
                    },
                    {
                        xtype: 'textfield',
                        label: 'Address of Stop',
                        name: 'addressBox',
                        labelWrap: true,
                        required: true
                    },
                    {
                        xtype: 'textareafield',
                        label: 'Reason for Stop',
                        labelWidth: '35%',
                        labelWrap: true,
                        name: 'infoBox'
                    }
                ]
            },
            {
                xtype: 'button',
                itemId: 'bRequestSubmit',
                ui: 'confirm',
                text: 'Submit'
            }
        ]
    }

});