/*
 * File: app/view/RegisterForm.js
 */

Ext.define('PeopleMover.view.RegisterForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.registerform',

    requires: [
        'Ext.form.FieldSet',
        'Ext.field.Email',
        'Ext.Button'
    ],

    config: {
        items: [
            {
                xtype: 'fieldset',
                title: 'Register',
                items: [
                    {
                        xtype: 'emailfield',
                        label: 'Email',
                        labelWidth: '40%',
                        name: 'email',
                        placeHolder: 'email@example.com'
                    },
                    {
                        xtype: 'textfield',
                        label: 'Password',
                        labelWidth: '40%',
                        name: 'password'
                    },
                    {
                        xtype: 'textfield',
                        label: 'Confirmation',
                        labelWidth: '40%',
                        name: 'confirmation'
                    }
                ]
            },
            {
                xtype: 'button',
                itemId: 'registerButton',
                margin: 20,
                padding: 8,
                ui: 'confirm',
                text: 'Register'
            }
        ]
    }

});