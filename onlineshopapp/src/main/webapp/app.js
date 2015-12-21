/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Onlineshopapp',

    extend: 'Onlineshopapp.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Onlineshopapp.view.mainleftmenutree.MainPanel':'Onlineshopapp.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Onlineshopapp.view.login.LoginPage':'Onlineshopapp.view.mobileview.login.LoginPage',//'Onlineshopapp.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Onlineshopapp.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
