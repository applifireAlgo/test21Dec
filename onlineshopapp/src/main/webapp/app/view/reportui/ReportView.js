Ext.define('Onlineshopapp.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Onlineshopapp.view.reportui.querycriteria.QueryCriteriaView',
			'Onlineshopapp.view.reportui.datachart.DataChartViewTab',
			'Onlineshopapp.view.reportui.datachart.DataChartViewPanel',
			'Onlineshopapp.view.reportui.ReportViewController' ,
			'Onlineshopapp.view.fw.MainDataPointPanel',
			'Onlineshopapp.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
