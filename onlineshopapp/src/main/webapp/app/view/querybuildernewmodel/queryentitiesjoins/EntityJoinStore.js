Ext.define('Onlineshopapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Onlineshopapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Onlineshopapp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
