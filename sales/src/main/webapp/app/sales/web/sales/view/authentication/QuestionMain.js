Ext.define('Sales.sales.web.sales.view.authentication.QuestionMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "QuestionMainController",
     "restURL": "/Question",
     "defaults": {
          "split": true
     },
     "requires": ["Sales.sales.shared.sales.model.authentication.QuestionModel", "Sales.sales.web.sales.controller.authentication.QuestionMainController", "Sales.sales.shared.sales.viewmodel.authentication.QuestionViewModel"],
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
               "displayName": "Question",
               "name": "QuestionTreeContainer",
               "itemId": "QuestionTreeContainer",
               "restURL": "/Question",
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
                    "itemId": "QuestionTree",
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
                    "viewModel": "QuestionViewModel",
                    "xtype": "form",
                    "displayName": "Question",
                    "title": "Question",
                    "name": "Question",
                    "itemId": "Question",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "questionId",
                         "itemId": "questionId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Question Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Question Id<font color='red'> *<\/font>",
                         "fieldId": "6121EEBD-B0F9-4C8D-9D86-F3C271F63C90",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "questionId",
                         "bind": "{questionId}"
                    }, {
                         "name": "levelid",
                         "itemId": "levelid",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Level Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Level Id<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F52621C2-D470-4B22-B13C-3F2C361A9286",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "levelid",
                         "bind": "{levelid}",
                         "columnWidth": 0.5
                    }, {
                         "name": "question",
                         "itemId": "question",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Question",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Question<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F9366B1D-FDC5-488F-AA7C-6B310D1B0391",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "question",
                         "bind": "{question}",
                         "columnWidth": 0.5
                    }, {
                         "name": "questionDetails",
                         "itemId": "questionDetails",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Details",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Details",
                         "fieldId": "0D649037-7F78-4ECD-A893-B7D689F50685",
                         "bindable": "questionDetails",
                         "bind": "{questionDetails}",
                         "columnWidth": 0.5
                    }, {
                         "name": "questionIcon",
                         "itemId": "questionIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "1C490419-F64D-4D1C-B182-A963BCFEC571",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "questionIcon",
                         "bind": "{questionIcon}",
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
                         "fieldId": "3DB0C155-E6EB-48E2-85A6-FB64BDAD375B",
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
                         "customId": 889,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 889,
                              "customId": 745
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 889,
                              "customId": 746,
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
                              "parentId": 889,
                              "customId": 747,
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
                    "displayName": "Question",
                    "title": "Details Grid",
                    "name": "QuestionGrid",
                    "itemId": "QuestionGrid",
                    "restURL": "/Question",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Question Id",
                         "dataIndex": "questionId",
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
                         "header": "Level Id",
                         "dataIndex": "levelid",
                         "flex": 1
                    }, {
                         "header": "Question",
                         "dataIndex": "question",
                         "flex": 1
                    }, {
                         "header": "Details",
                         "dataIndex": "questionDetails",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "questionIcon",
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
               "viewModel": "QuestionViewModel",
               "xtype": "form",
               "displayName": "Question",
               "title": "Question",
               "name": "Question",
               "itemId": "Question",
               "bodyPadding": 10,
               "items": [{
                    "name": "questionId",
                    "itemId": "questionId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Question Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Question Id<font color='red'> *<\/font>",
                    "fieldId": "6121EEBD-B0F9-4C8D-9D86-F3C271F63C90",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "questionId",
                    "bind": "{questionId}"
               }, {
                    "name": "levelid",
                    "itemId": "levelid",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Level Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Level Id<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F52621C2-D470-4B22-B13C-3F2C361A9286",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "levelid",
                    "bind": "{levelid}",
                    "columnWidth": 0.5
               }, {
                    "name": "question",
                    "itemId": "question",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Question",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Question<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F9366B1D-FDC5-488F-AA7C-6B310D1B0391",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "question",
                    "bind": "{question}",
                    "columnWidth": 0.5
               }, {
                    "name": "questionDetails",
                    "itemId": "questionDetails",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Details",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Details",
                    "fieldId": "0D649037-7F78-4ECD-A893-B7D689F50685",
                    "bindable": "questionDetails",
                    "bind": "{questionDetails}",
                    "columnWidth": 0.5
               }, {
                    "name": "questionIcon",
                    "itemId": "questionIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "1C490419-F64D-4D1C-B182-A963BCFEC571",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "questionIcon",
                    "bind": "{questionIcon}",
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
                    "fieldId": "3DB0C155-E6EB-48E2-85A6-FB64BDAD375B",
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
                    "customId": 889,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 889,
                         "customId": 745
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 889,
                         "customId": 746,
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
                         "parentId": 889,
                         "customId": 747,
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