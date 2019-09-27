/*
 * File: app/view/FeedBackView.js
 */

Ext.define('PeopleMover.view.FeedBackView', {
    extend: 'Ext.form.Panel',
    alias: 'widget.feedback',

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
                        xtype: 'textareafield',
                        label: 'Your Feedback',
                        labelWidth: '35%',
                        labelWrap: true,
                        name: 'infoBox',
                        required: true
                    }
                ]
            },
            {
                xtype: 'button',
                 itemId: 'bFeedBSubmit',
                ui: 'confirm',
                text: 'Submit'
            }
        ]
    }

});