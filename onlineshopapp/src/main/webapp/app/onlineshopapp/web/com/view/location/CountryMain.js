Ext.define('Onlineshopapp.onlineshopapp.web.com.view.location.CountryMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CountryMainController",
     "restURL": "/Country",
     "defaults": {
          "split": true
     },
     "requires": ["Onlineshopapp.onlineshopapp.shared.com.model.location.CountryModel", "Onlineshopapp.onlineshopapp.web.com.controller.location.CountryMainController", "Onlineshopapp.onlineshopapp.shared.com.viewmodel.location.CountryViewModel"],
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
               "displayName": "Country",
               "name": "CountryTreeContainer",
               "itemId": "CountryTreeContainer",
               "restURL": "/Country",
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
                    "itemId": "CountryTree",
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
                    "items": [{
                         "name": "countryName",
                         "itemId": "countryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "C374F907-92C7-4DDD-A036-ADBF09CFEB91",
                         "minLength": "0",
                         "maxLength": "128"
                    }, {
                         "name": "countryCode1",
                         "itemId": "countryCode1",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 1",
                         "fieldId": "908C46B2-46A7-4527-8E59-1D865B56280C",
                         "minLength": "0",
                         "maxLength": "3"
                    }]
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
                    "viewModel": "CountryViewModel",
                    "xtype": "form",
                    "displayName": "Country",
                    "title": "Country",
                    "name": "Country",
                    "itemId": "Country",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "fieldId": "9065EABF-A664-4EC0-957E-F18F84AF4DED",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "countryId",
                         "bind": "{countryId}"
                    }, {
                         "name": "countryName",
                         "itemId": "countryName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C374F907-92C7-4DDD-A036-ADBF09CFEB91",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "countryName",
                         "bind": "{countryName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryCode1",
                         "itemId": "countryCode1",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 1",
                         "fieldId": "908C46B2-46A7-4527-8E59-1D865B56280C",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode1",
                         "bind": "{countryCode1}",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryCode2",
                         "itemId": "countryCode2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Code 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Code 2",
                         "fieldId": "8FCB04B5-F6B7-4D3F-A192-72A42D8ADEFD",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "countryCode2",
                         "bind": "{countryCode2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "countryFlag",
                         "itemId": "countryFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "F76CF244-4024-4514-96BE-37DE3E7B8617",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "countryFlag",
                         "bind": "{countryFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "capital",
                         "itemId": "capital",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Capital",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital",
                         "fieldId": "235D1FCF-54DD-4695-9F81-79AC46B03BDF",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "capital",
                         "bind": "{capital}",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyCode",
                         "itemId": "currencyCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Code",
                         "fieldId": "8E4B26D4-708F-4E92-BF5F-6269FF1B8FE8",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "currencyCode",
                         "bind": "{currencyCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyName",
                         "itemId": "currencyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Name",
                         "fieldId": "0B6EBE0C-175D-439C-B233-CFE9CA167283",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "currencyName",
                         "bind": "{currencyName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencySymbol",
                         "itemId": "currencySymbol",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Symbol",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Symbol",
                         "fieldId": "AC915C41-88E6-48A1-800F-DE92E0631C7A",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "currencySymbol",
                         "bind": "{currencySymbol}",
                         "columnWidth": 0.5
                    }, {
                         "name": "capitalLatitude",
                         "itemId": "capitalLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capital Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital Latitude",
                         "fieldId": "0CC8C992-82F1-4EFB-B349-60C43164772B",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "capitalLatitude",
                         "bind": "{capitalLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "capitalLongitude",
                         "itemId": "capitalLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Capital Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Capital Longitude",
                         "fieldId": "587A4CC1-2E0A-473D-BBB1-5612DB16CEB1",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "capitalLongitude",
                         "bind": "{capitalLongitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "isoNumeric",
                         "itemId": "isoNumeric",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "ISO Numeric",
                         "margin": "5 5 5 5",
                         "fieldLabel": "ISO Numeric",
                         "fieldId": "00ABB47F-DE5B-4CAB-8886-28949F9EBE38",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "isoNumeric",
                         "bind": "{isoNumeric}",
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
                         "fieldId": "BD9FA676-BFA1-48B9-A306-9A0EE6D38E0D",
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
                         "customId": 785,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 785,
                              "customId": 731
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 785,
                              "customId": 732,
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
                              "parentId": 785,
                              "customId": 733,
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
                    "displayName": "Country",
                    "title": "Details Grid",
                    "name": "CountryGrid",
                    "itemId": "CountryGrid",
                    "restURL": "/Country",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Country Code",
                         "dataIndex": "countryId",
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
                         "header": "Name",
                         "dataIndex": "countryName",
                         "flex": 1
                    }, {
                         "header": "Code 1",
                         "dataIndex": "countryCode1",
                         "flex": 1
                    }, {
                         "header": "Code 2",
                         "dataIndex": "countryCode2",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "countryFlag",
                         "flex": 1
                    }, {
                         "header": "Capital",
                         "dataIndex": "capital",
                         "flex": 1
                    }, {
                         "header": "Currency Code",
                         "dataIndex": "currencyCode",
                         "flex": 1
                    }, {
                         "header": "Currency Name",
                         "dataIndex": "currencyName",
                         "flex": 1
                    }, {
                         "header": "Currency Symbol",
                         "dataIndex": "currencySymbol",
                         "flex": 1
                    }, {
                         "header": "Capital Latitude",
                         "dataIndex": "capitalLatitude",
                         "flex": 1
                    }, {
                         "header": "Capital Longitude",
                         "dataIndex": "capitalLongitude",
                         "flex": 1
                    }, {
                         "header": "ISO Numeric",
                         "dataIndex": "isoNumeric",
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
               "viewModel": "CountryViewModel",
               "xtype": "form",
               "displayName": "Country",
               "title": "Country",
               "name": "Country",
               "itemId": "Country",
               "bodyPadding": 10,
               "items": [{
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "fieldId": "9065EABF-A664-4EC0-957E-F18F84AF4DED",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "countryId",
                    "bind": "{countryId}"
               }, {
                    "name": "countryName",
                    "itemId": "countryName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C374F907-92C7-4DDD-A036-ADBF09CFEB91",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "countryName",
                    "bind": "{countryName}",
                    "columnWidth": 0.5
               }, {
                    "name": "countryCode1",
                    "itemId": "countryCode1",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Code 1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Code 1",
                    "fieldId": "908C46B2-46A7-4527-8E59-1D865B56280C",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "countryCode1",
                    "bind": "{countryCode1}",
                    "columnWidth": 0.5
               }, {
                    "name": "countryCode2",
                    "itemId": "countryCode2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Code 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Code 2",
                    "fieldId": "8FCB04B5-F6B7-4D3F-A192-72A42D8ADEFD",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "countryCode2",
                    "bind": "{countryCode2}",
                    "columnWidth": 0.5
               }, {
                    "name": "countryFlag",
                    "itemId": "countryFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "F76CF244-4024-4514-96BE-37DE3E7B8617",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "countryFlag",
                    "bind": "{countryFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "capital",
                    "itemId": "capital",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Capital",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital",
                    "fieldId": "235D1FCF-54DD-4695-9F81-79AC46B03BDF",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "capital",
                    "bind": "{capital}",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyCode",
                    "itemId": "currencyCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Code",
                    "fieldId": "8E4B26D4-708F-4E92-BF5F-6269FF1B8FE8",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "currencyCode",
                    "bind": "{currencyCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyName",
                    "itemId": "currencyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Name",
                    "fieldId": "0B6EBE0C-175D-439C-B233-CFE9CA167283",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "currencyName",
                    "bind": "{currencyName}",
                    "columnWidth": 0.5
               }, {
                    "name": "currencySymbol",
                    "itemId": "currencySymbol",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Symbol",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Symbol",
                    "fieldId": "AC915C41-88E6-48A1-800F-DE92E0631C7A",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "currencySymbol",
                    "bind": "{currencySymbol}",
                    "columnWidth": 0.5
               }, {
                    "name": "capitalLatitude",
                    "itemId": "capitalLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capital Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital Latitude",
                    "fieldId": "0CC8C992-82F1-4EFB-B349-60C43164772B",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "capitalLatitude",
                    "bind": "{capitalLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "capitalLongitude",
                    "itemId": "capitalLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Capital Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Capital Longitude",
                    "fieldId": "587A4CC1-2E0A-473D-BBB1-5612DB16CEB1",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "capitalLongitude",
                    "bind": "{capitalLongitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "isoNumeric",
                    "itemId": "isoNumeric",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "ISO Numeric",
                    "margin": "5 5 5 5",
                    "fieldLabel": "ISO Numeric",
                    "fieldId": "00ABB47F-DE5B-4CAB-8886-28949F9EBE38",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "isoNumeric",
                    "bind": "{isoNumeric}",
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
                    "fieldId": "BD9FA676-BFA1-48B9-A306-9A0EE6D38E0D",
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
                    "customId": 785,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 785,
                         "customId": 731
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 785,
                         "customId": 732,
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
                         "parentId": 785,
                         "customId": 733,
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