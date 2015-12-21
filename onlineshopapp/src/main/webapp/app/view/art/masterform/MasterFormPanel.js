Ext.define('Onlineshopapp.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Onlineshopapp.view.art.masterform.MasterFormModel','Onlineshopapp.view.art.masterform.MasterFormViewModel','Onlineshopapp.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	