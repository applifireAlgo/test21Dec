Ext.define('Onlineshopapp.onlineshopapp.web.com.view.portal.UserCart', {
     "xtype": "userCart",
     "name": "addToCart",
     "items": [{
          "xtype": "fieldset",
          "items": [{
               "xtype": "combo",
               "name": "productId",
               "margin": 5,
               "bindable": "productId",
               "typeAhead": true,
               "queryMode": "local",
               "minChars": 1,
               "fieldLabel": "Product",
               "displayField": "productName",
               "valueField": "productId",
               "itemId": "jbcdoli",
               "store": {
                    "model": "Onlineshopapp.onlineshopapp.shared.com.model.retail.ProductModel",
                    "autoLoad": true,
                    "autoSync": true,
                    "sorters": [{
                         "property": "productName",
                         "direction": "ASC"
                    }],
                    "proxy": {
                         "type": "ajax",
                         "url": "secure/Product/findAll",
                         "actionMethods": {
                              "read": "GET"
                         },
                         "headers": {
                              "Content-Type": "application/json"
                         },
                         "extraParams": {},
                         "reader": {
                              "type": "json",
                              "rootProperty": "response.data"
                         }
                    }
               },
               "bind": "{productId}"
          }, {
               "xtype": "numberfield",
               "fieldLabel": "Purchase qty",
               "name": "productStock",
               "margin": 5,
               "bindable": "productStock",
               "itemId": "mpicjbi",
               "bind": "{productStock}"
          }],
          "margin": 5,
          "autoScroll": true,
          "toggleOnTitleClick": true,
          "itemId": "cnjenpi",
          "dockedItems": []
     }, {
          "xtype": "button",
          "text": "save",
          "isSubmitBtn": true,
          "margin": 5,
          "name": "save",
          "itemId": "afldehi",
          "listeners": {
               "click": "onsaveclick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Add to cart",
     "margin": 5,
     "itemId": "pajjobi",
     "dockedItems": [],
     "requires": ["Onlineshopapp.onlineshopapp.shared.com.model.retail.ProductModel", "Onlineshopapp.onlineshopapp.web.com.controller.portal.UserCartController", "Onlineshopapp.onlineshopapp.shared.com.viewmodel.portal.UserCartViewModel", "Onlineshopapp.onlineshopapp.shared.com.model.portal.UserCartModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "UserCartViewModel",
     "controller": "UserCartController"
});