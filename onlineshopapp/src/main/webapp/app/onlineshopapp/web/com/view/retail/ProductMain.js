Ext.define('Onlineshopapp.onlineshopapp.web.com.view.retail.ProductMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ProductMainController",
     "restURL": "/Product",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopapp.onlineshopapp.shared.com.model.retail.ProductModel", "Onlineshopapp.onlineshopapp.web.com.controller.retail.ProductMainController", "Onlineshopapp.onlineshopapp.shared.com.viewmodel.retail.ProductViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Product",
               "name": "ProductTreeContainer",
               "itemId": "ProductTreeContainer",
               "restURL": "/Product",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "ProductTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "ProductViewModel",
                    "xtype": "form",
                    "displayName": "Product",
                    "title": "Product",
                    "name": "Product",
                    "itemId": "Product",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "productId",
                         "itemId": "productId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "productId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "productId<font color='red'> *<\/font>",
                         "fieldId": "47AF24B7-27A0-4383-8740-965E244EE644",
                         "hidden": true,
                         "value": "",
                         "bindable": "productId",
                         "bind": "{productId}"
                    }, {
                         "name": "productName",
                         "itemId": "productName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Product",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A11B29D3-9A12-4A38-BB11-E030C9C678A1",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "productName",
                         "bind": "{productName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "productDesc",
                         "itemId": "productDesc",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Product Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Product Description<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B21DE5D7-FB44-4582-899C-A5CF9F57FDD0",
                         "bindable": "productDesc",
                         "bind": "{productDesc}",
                         "columnWidth": 0.5
                    }, {
                         "name": "productUnitPrice",
                         "itemId": "productUnitPrice",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Unit price",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Unit price<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BA21D12F-6E90-43D3-8705-5BE9B0DBFC42",
                         "minValue": "-9223372000000000000",
                         "maxValue": "9223372000000000000",
                         "bindable": "productUnitPrice",
                         "bind": "{productUnitPrice}",
                         "columnWidth": 0.5
                    }, {
                         "name": "productStock",
                         "itemId": "productStock",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Present stock",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Present stock<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "007B0B3C-37EB-4646-8789-8D2D821B57A9",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "productStock",
                         "bind": "{productStock}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "225250D3-72EF-4A1F-B0CA-F2B4D1035D29",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 329,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 329,
                              "customId": 931
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 329,
                              "customId": 932,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 329,
                              "customId": 933,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Product",
                    "title": "Details Grid",
                    "name": "ProductGrid",
                    "itemId": "ProductGrid",
                    "restURL": "/Product",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "productId",
                         "dataIndex": "productId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Product",
                         "dataIndex": "productName",
                         "flex": 1
                    }, {
                         "header": "Product Description",
                         "dataIndex": "productDesc",
                         "flex": 1
                    }, {
                         "header": "Unit price",
                         "dataIndex": "productUnitPrice",
                         "flex": 1
                    }, {
                         "header": "Present stock",
                         "dataIndex": "productStock",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "ProductViewModel",
               "xtype": "form",
               "displayName": "Product",
               "title": "Product",
               "name": "Product",
               "itemId": "Product",
               "bodyPadding": 10,
               "items": [{
                    "name": "productId",
                    "itemId": "productId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "productId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "productId<font color='red'> *<\/font>",
                    "fieldId": "47AF24B7-27A0-4383-8740-965E244EE644",
                    "hidden": true,
                    "value": "",
                    "bindable": "productId",
                    "bind": "{productId}"
               }, {
                    "name": "productName",
                    "itemId": "productName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Product",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A11B29D3-9A12-4A38-BB11-E030C9C678A1",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "productName",
                    "bind": "{productName}",
                    "columnWidth": 0.5
               }, {
                    "name": "productDesc",
                    "itemId": "productDesc",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Product Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Product Description<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B21DE5D7-FB44-4582-899C-A5CF9F57FDD0",
                    "bindable": "productDesc",
                    "bind": "{productDesc}",
                    "columnWidth": 0.5
               }, {
                    "name": "productUnitPrice",
                    "itemId": "productUnitPrice",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Unit price",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Unit price<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BA21D12F-6E90-43D3-8705-5BE9B0DBFC42",
                    "minValue": "-9223372000000000000",
                    "maxValue": "9223372000000000000",
                    "bindable": "productUnitPrice",
                    "bind": "{productUnitPrice}",
                    "columnWidth": 0.5
               }, {
                    "name": "productStock",
                    "itemId": "productStock",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Present stock",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Present stock<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "007B0B3C-37EB-4646-8789-8D2D821B57A9",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "productStock",
                    "bind": "{productStock}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "225250D3-72EF-4A1F-B0CA-F2B4D1035D29",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 329,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 329,
                         "customId": 931
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 329,
                         "customId": 932,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 329,
                         "customId": 933,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});