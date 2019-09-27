/*
 * File: app/controller/UserController.js
 */

Ext.define('PeopleMover.controller.UserController', {
    extend: 'Ext.app.Controller',

    requires: [
        'Ext.JSON',
        'Ext.MessageBox'
    ],

    config: {
        refs: {
            mainView: 'mainview'
        },

        control: {
            "mainview #showLoginButton": {
                tap: 'showLogin'
            },
            "mainview #showRegisterButton": {
                tap: 'showRegister'
            },
            "mainview #aboutUs": {
                tap: 'showAboutUs'
            },
            "mainview #reportProblem": {
                tap: 'showReportProblem'
            },
            "mainview #requestStop": {
                tap: 'showRequestStop'
            },
            "mainview #feedback": {
                tap: 'showRequestFeedback'
            },
            "mainview #serviceTimes": {
                tap: 'showServiceTimes'
            },
            "loginform #loginButton": {
                tap: 'login'
            },
            "registerform #registerButton": {
                tap: 'register'
            },
            "problem #itemPictureBox": {
                tap: 'onImageTap'
            },
            "problem #bProbSubmit": {
                tap: 'submitProb'
            },
            "requestStop #bRequestSubmit": {
                tap: 'submitReq'
            },
            "feedback #bFeedBSubmit": {
                tap: 'submitFeedBack'
            }
        }
    },

    showLogin: function(button, e, eOpts) {

                var loginForm = Ext.create('widget.loginform'),	// Login form
                    mainView = this.getMainView();				// Main view

                // Navigate to login
                mainView.push({
                    xtype: "loginform",
                    title: "Login"
                });

    },

    showRegister: function(button, e, eOpts) {

                var loginForm = Ext.create('widget.registerform'),	// Login form
                    mainView = this.getMainView();				// Main view

                // Navigate to login
                mainView.push({
                    xtype: "registerform",
                    title: "Register"
                });

    },

    showAboutUs: function(button, e, eOpts) {

                        var reportProblem = Ext.create('widget.aboutus'),	// Login form
                            mainView = this.getMainView();				// Main view

                        // Navigate to login
                        mainView.push({
                            xtype: "aboutus",
                            title: "About Us"
                        });

    },

    showReportProblem: function(button, e, eOpts) {

                var reportProblem = Ext.create('widget.problem'),	// Login form
                    mainView = this.getMainView();				// Main view

                // Navigate to login
                mainView.push({
                    xtype: "problem",
                    title: "Report a Problem"
                });

    },

    showRequestStop: function(button, e, eOpts) {

                var reportProblem = Ext.create('widget.requestStop'),	// Login form
                    mainView = this.getMainView();				// Main view

                // Navigate to login
                mainView.push({
                    xtype: "requestStop",
                    title: "Request Stop"
                });

    },

    showRequestFeedback: function(button, e, eOpts) {

                var reportProblem = Ext.create('widget.feedback'),	// Login form
                    mainView = this.getMainView();				// Main view

                // Navigate to login
                mainView.push({
                    xtype: "feedback",
                    title: "Enter Feedback"
                });

    },

    showServiceTimes: function(button, e, eOpts) {

                var reportProblem = Ext.create('widget.servicetimes'),	// Login form
                    mainView = this.getMainView();				// Main view

                // Navigate to login
                mainView.push({
                    xtype: "servicetimes",
                    title: "Service Times"
                });

    },

    login: function(button, e, eOpts) {
            var form = button.up('formpanel'),			// Login form
                        	values = form.getValues(),				// Form values
                            mainView = this.getMainView();			// Main view
                        	//loginPanel = this.getLoginPanel(),		// Login and register buttons
                        	//welcomePanel = this.getWelcomePanel();	// Welcome panel

                        // Success
                        var successCallback = function(resp, ops) {
						Ext.Viewport.unmask(); 
                        //     // Go back
                        //     mainView.pop();

                        //     // Hide login panel
                        //     loginPanel.hide();

                        //     // Show welcome panel
                        //     welcomePanel.show();



                            var jsonResp = Ext.JSON.decode(resp.responseText);

                                 if(jsonResp.message!=="No Match" && jsonResp.message!=="Insertion Error" && jsonResp.message!=="Not valid email"){
                                     var alert = Ext.getCmp("alertfield");
                                     if(jsonResp.code==="admin")
                                      {

                                          alert.setReadOnly(false);
                                      }
                                     else
                                      {
                                          alert.setReadOnly(true);
                                      }
                                      Ext.Msg.alert("Info","Login Successful");

                                     localStorage.setItem('ppmtoken',jsonResp.message);

                                     var mybutton = Ext.create('widget.esttimeview').down('#bfavorite');
                                        mybutton.setText('Save as Favorite');
                                        mybutton.enable();

                                       //get back
                                        mainView.pop();

                                //     // Hide login panel
                                        form.hide();
                             }
                             else
                                 {
                                    var token  = localStorage.getItem("ppmtoken");
                                    if(token!==null){
                                        localStorage.removeItem("ppmtoken");
                                    }

                                     Ext.Msg.alert("Info",jsonResp.message);
                                 }






                        };

                        // Failure
                        var failureCallback = function(resp, ops) {
						Ext.Viewport.unmask(); 


                           var jsonResp = Ext.JSON.decode(resp.responseText);

                            Ext.Msg.alert("Info","message: "+jsonResp.message);
                           //button.setDisabled(false);
                        };

						if(values.email!=="" && values.password!=="" )
                        {
											Ext.Viewport.mask({ xtype: 'loadmask',
														message: "Login..." });
                        //button.setText('Please wait ...');
                        //button.setDisabled(true);
                        var enctext = CryptoJS.MD5(values.password);

                        // TODO: Login using server-side authentication service
                        Ext.Ajax.request({
                        		url: "http://pm-dev.cs.fiu.edu:8080/ppmws/userauth",
                                method: 'POST',
                                /*headers: { 'Content-Type': 'application/json' },*/
                            params: {"islogin":true,
                                     "email":values.email,
                                     "pass":String(enctext)
                                    },
                        		success: successCallback,
                        		failure: failureCallback
                         });
                      }
                      else{Ext.Msg.alert("WARNING","Missing Info Required");}

    },

    register: function(button, e, eOpts) {
          var form = button.up('formpanel'),			// Login form
                        	values = form.getValues(),				// Form values
                            mainView = this.getMainView();			// Main view
                        	//loginPanel = this.getLoginPanel(),		// Login and register buttons
                        	//welcomePanel = this.getWelcomePanel();	// Welcome panel

                        // Success
                        var successCallback = function(resp, ops) {
						Ext.Viewport.unmask(); 
                        //     // Go back
                        //     mainView.pop();

                        //     // Hide login panel
                        //     loginPanel.hide();

                        //     // Show welcome panel
                        //     welcomePanel.show();


                            var jsonResp = Ext.JSON.decode(resp.responseText);
                            if(jsonResp.message!=="No Match" && jsonResp.message!=="Insertion Error" && jsonResp.message!=="Not valid email")
                            {
                               Ext.Msg.alert("Info","Registration Successful");

                             localStorage.setItem('ppmtoken',jsonResp.message);
                              //get back
                                 mainView.pop();

                        //     // Hide login panel
                             form.hide();
							}
							else 
							{
								Ext.Msg.alert("Info",jsonResp.message);
							}

                           


                        };

                        // Failure
                        var failureCallback = function(resp, ops) {
						Ext.Viewport.unmask(); 
                           var jsonResp = Ext.JSON.decode(resp.responseText);
                                      Ext.Msg.alert("Info","message:"+jsonResp.message);



                        };
                        //TODO: Registration using server-side authentication service

                             var pass1 = values.password;
                             var pass2 = values.confirmation;

								if(values.email!=="" && values.password!=="" && values.confirmation!=="")
                                        {
											Ext.Viewport.mask({ xtype: 'loadmask',
														message: "Registering..." });
                                 if (pass1 != pass2)
                                     return Ext.Msg.alert("Info","errorMessage: "+"Passwords do not match!");

                                 else
                                     {
                                     var enctext = CryptoJS.MD5(values.password);


                                            Ext.Ajax.request({
                                                url: "http://pm-dev.cs.fiu.edu:8080/ppmws/userauth",
                                                method: 'POST',
                                                /*headers: { 'Content-Type': 'application/json' },*/
                                                params: {
                                                    "islogin":false,
                                                     "email":values.email,
                                                     "pass": String(enctext)
                                                    },
                                                success: successCallback,
                                                failure: failureCallback
                                            });
                                     }
								 }
								 else{Ext.Msg.alert("WARNING","Missing Info Required");}
    },

    onImageTap: function(image, e, eOpts) {
          Ext.device.Camera.capture({
                            source: 'camera',
                            destination: 'data',

                            success: function(imagedata) {

                                var img = Ext.getCmp('pictureBox');
                                var attach = 'data:image/jpeg;base64,'+imagedata;
                                sessionStorage.setItem('image',attach);
                                img.setSrc(attach);

                            },

                            failure: function() {
                                Ext.Msg.alert('Error', 'There was an error when acquiring the picture.');
                            },
                            scope: this
                        });

    },

    submitProb: function(button, e, eOpts) {
        var form = button.up('formpanel'),
                        values = form.getValues(),				// Form values
                        mainView = this.getMainView();
		

                // Success
                                var successCallback = function(resp, ops) {

								Ext.Viewport.unmask(); 


                                    var jsonResp = Ext.JSON.decode(resp.responseText);
                                       Ext.Msg.alert("Info","message:"+jsonResp.message);


                                    //get back
                                         mainView.pop();

                                //     // Hide login panel
                                     form.hide();


                                };

                                // Failure
                                var failureCallback = function(resp, ops) {
									
									Ext.Viewport.unmask(); 
                                   var jsonResp = Ext.JSON.decode(resp.responseText);
                                              Ext.Msg.alert("Info","message:"+jsonResp.message);



                                };
                                //TODO: Registration using server-side authentication service

                                        if(values.nameBox!=="" && values.emailBox!=="" && values.infoBox!=="")
                                        {
											Ext.Viewport.mask({ xtype: 'loadmask',
														message: "Sending Email.." });
        										var attach = sessionStorage.getItem("image");
        										if(attach!==null){

        										var callparams = {
                                                            "name":values.nameBox,
                                                            "type": "PROBLEM",
                                                             "email":values.emailBox,
                                                             "message": values.infoBox,
                                                             "attach":attach

                                                            };
                                                 }
                                                 else
                                                 {
        											 var callparams = {
                                                            "name":values.nameBox,
                                                            "type": "PROBLEM",
                                                             "email":values.emailBox,
                                                             "message": "DESCRIPTION: "+values.infoBox

                                                            };
        										 }

                                                    Ext.Ajax.request({
                                                        url: "http://pm-dev.cs.fiu.edu:8080/ppmws/sendemail",
                                                        /*url: "http://192.168.0.101/sendemail",*/
                                                        method: 'POST',
                                                        /*headers: { 'Content-Type': 'application/json' },*/
                                                        params: callparams,
                                                        success: successCallback,
                                                        failure: failureCallback
                                                    });
                                            }
                                            else
                                                Ext.Msg.alert("WARNING","Missing Info Required");
    },
    submitReq: function(button, e, eOpts) {
        var form = button.up('formpanel'),
                        values = form.getValues(),              // Form values
                        mainView = this.getMainView();
		

                // Success
                                var successCallback = function(resp, ops) {



									Ext.Viewport.unmask(); 
                                    var jsonResp = Ext.JSON.decode(resp.responseText);
                                       Ext.Msg.alert("Info","message:"+jsonResp.message);


                                    //get back
                                         mainView.pop();

                                //     // Hide login panel
                                     form.hide();


                                };

                                // Failure
                                var failureCallback = function(resp, ops) {
									
									Ext.Viewport.unmask(); 
                                   var jsonResp = Ext.JSON.decode(resp.responseText);
                                              Ext.Msg.alert("Info","message:"+jsonResp.message);



                                };
                                //TODO: Registration using server-side authentication service

                                        if(values.nameBox!=="" && values.emailBox!=="" && values.addressBox!=="")
                                        {
											Ext.Viewport.mask({ xtype: 'loadmask',
													message: "Sending Email.." });
                                             
                                                     var callparams = {
                                                            "name":values.nameBox,
                                                            "type": "REQUEST STOP",
                                                             "email":values.emailBox,
                                                             "message": "LOCATION: "+values.addressBox+" :: REASON: "+values.infoBox

                                                            };
                                                 

                                                    Ext.Ajax.request({
                                                        url: "http://pm-dev.cs.fiu.edu:8080/ppmws/sendemail",
                                                        /*url: "http://192.168.0.101/sendemail",*/
                                                        method: 'POST',
                                                        /*headers: { 'Content-Type': 'application/json' },*/
                                                        params: callparams,
                                                        success: successCallback,
                                                        failure: failureCallback
                                                    });
                                            }
                                            else
                                                Ext.Msg.alert("WARNING","Missing Info Required");
    },
    submitFeedBack: function(button, e, eOpts) {
        var form = button.up('formpanel'),
                        values = form.getValues(),              // Form values
                        mainView = this.getMainView();
		

                // Success
                                var successCallback = function(resp, ops) {
									
									
									Ext.Viewport.unmask(); 


                                    var jsonResp = Ext.JSON.decode(resp.responseText);
                                       Ext.Msg.alert("Info","message:"+jsonResp.message);


                                    //get back
                                         mainView.pop();

                                //     // Hide login panel
                                     form.hide();


                                };

                                // Failure
                                var failureCallback = function(resp, ops) {
								
								Ext.Viewport.unmask(); 
                                   var jsonResp = Ext.JSON.decode(resp.responseText);
                                              Ext.Msg.alert("Info","message:"+jsonResp.message);



                                };
                                //TODO: Registration using server-side authentication service

                                        if(values.nameBox!=="" && values.emailBox!=="" && values.infoBox!=="")
                                        {
                                             Ext.Viewport.mask({ xtype: 'loadmask',
													message: "Sending Email.." });
                                                     var callparams = {
                                                            "name":values.nameBox,
                                                            "type": "FeedBack",
                                                             "email":values.emailBox,
                                                             "message": "FEEDBACK: "+values.infoBox

                                                            };
                                                 

                                                    Ext.Ajax.request({
                                                        url: "http://pm-dev.cs.fiu.edu:8080/ppmws/sendemail",
                                                        /*url: "http://192.168.0.101/sendemail",*/
                                                        method: 'POST',
                                                        /*headers: { 'Content-Type': 'application/json' },*/
                                                        params: callparams,
                                                        success: successCallback,
                                                        failure: failureCallback
                                                    });
                                            }
                                            else
                                                Ext.Msg.alert("WARNING","Missing Info Required");
    }

});
