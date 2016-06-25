jQuery.browser = {};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        jQuery.browser.version = RegExp.$1;
    }
})();


jQuery(document).ready(function() {
    jQuery("#jqGrid").jqGrid({
    	type : 'GET',
        url:'/reuniones/' + 1,
        editurl:'/reuniones/' + 1,
        datatype: "json",
        colNames:['ID'], //,'Tipo','Integrantes', 'Temas Tratados'],
        colModel: [
            { label: 'id',name: 'ID',width: 75,key: true,editable: true,editrules : { required: true}} //,
            //{ label: 'tipo',name: 'Tipo',width: 140,editable: true},
            //{ label: 'integrantes',name: 'Integrantes',width: 140,editable: true},
            //{ label : 'temasTratados',name: 'Temas Tratados',width: 100,editable: true}
            ],
		sortname: 'CustomID',
		sortorder : 'asc',
		caption:"Reuniones",
		loadonce: true,
		viewrecords: true,
		gridview: true,
        width: 1100,
        height: 350,
        rowNum: 10,
        //rowList: [3],
        //height: '100%'
        pager: "#jqGridPager"
    });

    $('#jqGrid').navGrid('#jqGridPager',
        // the buttons to appear on the toolbar of the grid
        { edit: true, add: true, del: true, search: false, refresh: false, view: false, position: "left", cloneToTop: false },
        // options for the Edit Dialog
        {
            editCaption: "The Edit Dialog",
            recreateForm: true,
			checkOnUpdate : true,
			checkOnSubmit : true,
            closeAfterEdit: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Add Dialog
        {
            closeAfterAdd: true,
            recreateForm: true,
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        },
        // options for the Delete Dailog
        {
            errorTextFormat: function (data) {
                return 'Error: ' + data.responseText
            }
        });
});
