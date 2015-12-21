Ext.define('Onlineshopapp.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Onlineshopapp.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Onlineshopapp.view.mobileview.reportui.datachart.DataChartViewTab',
			'Onlineshopapp.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Onlineshopapp.view.mobileview.reportui.ReportViewController' ,
			'Onlineshopapp.view.mobileview.fw.DataPointPanel',
			'Onlineshopapp.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
