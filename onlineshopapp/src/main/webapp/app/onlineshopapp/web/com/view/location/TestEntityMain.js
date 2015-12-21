Ext.define('Onlineshopapp.onlineshopapp.web.com.view.location.TestEntityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestEntityMainController",
     "restURL": "/TestEntity",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopapp.onlineshopapp.shared.com.model.location.TestEntityModel", "Onlineshopapp.onlineshopapp.web.com.controller.location.TestEntityMainController", "Onlineshopapp.onlineshopapp.shared.com.viewmodel.location.TestEntityViewModel"],
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
               "displayName": "TestEntity",
               "name": "TestEntityTreeContainer",
               "itemId": "TestEntityTreeContainer",
               "restURL": "/TestEntity",
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
                    "itemId": "TestEntityTree",
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
                    "viewModel": "TestEntityViewModel",
                    "xtype": "form",
                    "displayName": "TestEntity",
                    "title": "TestEntity",
                    "name": "TestEntity",
                    "itemId": "TestEntity",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testId",
                         "itemId": "testId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testId<font color='red'> *<\/font>",
                         "fieldId": "1FC6963E-2525-4627-B89B-A38452336EF7",
                         "hidden": true,
                         "value": "",
                         "bindable": "testId",
                         "bind": "{testId}"
                    }, {
                         "name": "firstName",
                         "itemId": "firstName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "firstName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "firstName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A0C3B3AA-3844-459E-9C94-EBC3172F8B03",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "firstName",
                         "bind": "{firstName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "lastName",
                         "itemId": "lastName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "lastName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "lastName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "BA01C05E-04E3-46C8-908C-B84A5616EA44",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "lastName",
                         "bind": "{lastName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "middleName",
                         "itemId": "middleName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "middleName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "middleName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "8C24B894-DCA3-43B7-984F-3A0E2CD15168",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "middleName",
                         "bind": "{middleName}",
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
                         "fieldId": "A832AC44-B229-49DA-B218-1048F55D668F",
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
                         "customId": 832,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 832,
                              "customId": 142
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 832,
                              "customId": 143,
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
                              "parentId": 832,
                              "customId": 144,
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
                    "displayName": "TestEntity",
                    "title": "Details Grid",
                    "name": "TestEntityGrid",
                    "itemId": "TestEntityGrid",
                    "restURL": "/TestEntity",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "testId",
                         "dataIndex": "testId",
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
                         "header": "firstName",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "lastName",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "middleName",
                         "dataIndex": "middleName",
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
               "viewModel": "TestEntityViewModel",
               "xtype": "form",
               "displayName": "TestEntity",
               "title": "TestEntity",
               "name": "TestEntity",
               "itemId": "TestEntity",
               "bodyPadding": 10,
               "items": [{
                    "name": "testId",
                    "itemId": "testId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testId<font color='red'> *<\/font>",
                    "fieldId": "1FC6963E-2525-4627-B89B-A38452336EF7",
                    "hidden": true,
                    "value": "",
                    "bindable": "testId",
                    "bind": "{testId}"
               }, {
                    "name": "firstName",
                    "itemId": "firstName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "firstName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "firstName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A0C3B3AA-3844-459E-9C94-EBC3172F8B03",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "firstName",
                    "bind": "{firstName}",
                    "columnWidth": 0.5
               }, {
                    "name": "lastName",
                    "itemId": "lastName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "lastName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "lastName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "BA01C05E-04E3-46C8-908C-B84A5616EA44",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "lastName",
                    "bind": "{lastName}",
                    "columnWidth": 0.5
               }, {
                    "name": "middleName",
                    "itemId": "middleName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "middleName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "middleName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "8C24B894-DCA3-43B7-984F-3A0E2CD15168",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "middleName",
                    "bind": "{middleName}",
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
                    "fieldId": "A832AC44-B229-49DA-B218-1048F55D668F",
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
                    "customId": 832,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 832,
                         "customId": 142
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 832,
                         "customId": 143,
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
                         "parentId": 832,
                         "customId": 144,
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