Ext.define('Onlineshopapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Onlineshopapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Onlineshopapp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
