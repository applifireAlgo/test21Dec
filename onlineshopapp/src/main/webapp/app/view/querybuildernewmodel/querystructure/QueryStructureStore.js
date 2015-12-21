Ext.define('Onlineshopapp.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Onlineshopapp.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Onlineshopapp.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
