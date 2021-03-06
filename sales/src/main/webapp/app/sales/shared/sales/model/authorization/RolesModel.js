Ext.define('Sales.sales.shared.sales.model.authorization.RolesModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "RoleMenuBridge",
          "reference": "RoleMenuBridgeModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});