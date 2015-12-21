Ext.define('Onlineshopapp.onlineshopapp.shared.com.model.retail.ProductModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "productId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "productName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "productDesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "productUnitPrice",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "productStock",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});