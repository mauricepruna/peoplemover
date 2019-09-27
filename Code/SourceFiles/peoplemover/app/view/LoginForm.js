/*
 * File: app/view/LoginForm.js
 */

Ext.define('PeopleMover.view.LoginForm', {
    extend: 'Ext.form.Panel',
    alias: 'widget.loginform',

    requires: [
        'Ext.form.FieldSet',
        'Ext.field.Email',
        'Ext.Button'
    ],

    config: {
        items: [
            {
                xtype: 'fieldset',
                title: 'Login',
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
                    }
                ]
            },
            {
                xtype: 'button',
                itemId: 'loginButton',
                margin: 20,
                padding: 8,
                ui: 'confirm',
                text: 'Login'
            }
        ]
    }

});