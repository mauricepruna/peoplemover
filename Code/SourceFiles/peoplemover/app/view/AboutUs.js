/*
 * File: app/view/AboutUs.js
 */

Ext.define('PeopleMover.view.AboutUs', {
    extend: 'Ext.Container',
    alias: 'widget.aboutus',

    requires: [
        'Ext.field.TextArea'
    ],

    config: {
        items: [
            {
                xtype: 'textareafield',
                height: '100%',
                //grow:true,
                //maxHeight: '500',         
                label: 'What is the Pinecrest People Mover?',
                labelAlign: 'top',
                labelWrap: true,
                html: 	' <p>The Pinecrest People Mover is your '+
						'connection to schools and more in the Village of Pinecrest.'+
						' This FREE public transportation service operates weekdays.'+
						' The service can accommodate conventional and motorized wheelchairs.'+
						'</p></br><p>'+
						'For more information on the Pinecrest People Mover,'+
						 'call (305) 234-2121 or visit us online at www.pinecrest-fl.gov/PPM.</p>',
                readOnly: true
            }
        ]
    }

});
