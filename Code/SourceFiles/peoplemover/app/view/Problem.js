/*
 * File: app/view/Problem.js
 */

Ext.define('PeopleMover.view.Problem', {
    extend: 'Ext.form.Panel',
    alias: 'widget.problem',

    requires: [
        'Ext.form.FieldSet',
        'Ext.field.Email',
        'Ext.field.TextArea',
        'Ext.Img',
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
                        label: 'Report Issue',
                        labelWrap: true,
                        name: 'infoBox',
                        required: true
                    },
                    {
                        xtype: 'container',
                        layout: 'hbox',
                        items: [
                            {
                                xtype: 'image',
                                height: 200,
                                id: 'pictureBox',
                                itemId: 'itemPictureBox',
                                width: 200,
                                src: 'resources/images/camera.png'
                            }
                        ]
                    }
                ]
            },
            {
                xtype: 'button',
                itemId: 'bProbSubmit',
                ui: 'confirm',
                text: 'Submit'
            }
        ]
    }

});