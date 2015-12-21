Ext.define('Onlineshopapp.view.databrowsercalendar.DBCalendar', {
	extend : 'Onlineshopapp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Onlineshopapp.view.databrowsercalendar.DBCalendarController',
	             'Onlineshopapp.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
