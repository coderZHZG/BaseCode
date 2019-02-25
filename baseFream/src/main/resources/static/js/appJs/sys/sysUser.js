/* DO NOT REMOVE : GLOBAL FUNCTIONS!
     *
     * pageSetUp(); WILL CALL THE FOLLOWING FUNCTIONS
     *
     * // activate tooltips
     * $("[rel=tooltip]").tooltip();
     *
     * // activate popovers
     * $("[rel=popover]").popover();
     *
     * // activate popovers with hover states
     * $("[rel=popover-hover]").popover({ trigger: "hover" });
     *
     * // activate inline charts
     * runAllCharts();
     *
     * // setup widgets
     * setup_widgets_desktop();
     *
     * // run form elements
     * runAllForms();
     *
     ********************************
     *
     * pageSetUp() is needed whenever you load a page.
     * It initializes and checks for all basic elements of the page
     * and makes rendering easier.
     *
     */

pageSetUp();

/*
 * ALL PAGE RELATED SCRIPTS CAN GO BELOW HERE
 * eg alert("my home function");
 *
 * var pagefunction = function() {
 *   ...
 * }
 * loadScript("js/plugin/_PLUGIN_NAME_.js", pagefunction);
 *
 */

var pagefunction = function() {
    loadScript("js/plugin/jqgrid/jquery.jqGrid.min.js", run_jqgrid_function);

    function run_jqgrid_function() {


        var jqgrid_data = [{
            id : "1",
            date : "2007-10-01",
            name : "test",
            note : "note",
            amount : "200.00",
            tax : "10.00",
            total : "210.00"
        }, {
            id : "2",
            date : "2007-10-02",
            name : "test2",
            note : "note2",
            amount : "300.00",
            tax : "20.00",
            total : "320.00"
        }, {
            id : "3",
            date : "2007-09-01",
            name : "test3",
            note : "note3",
            amount : "400.00",
            tax : "30.00",
            total : "430.00"
        }, {
            id : "4",
            date : "2007-10-04",
            name : "test",
            note : "note",
            amount : "200.00",
            tax : "10.00",
            total : "210.00"
        }, {
            id : "5",
            date : "2007-10-05",
            name : "test2",
            note : "note2",
            amount : "300.00",
            tax : "20.00",
            total : "320.00"
        }, {
            id : "6",
            date : "2007-09-06",
            name : "test3",
            note : "note3",
            amount : "400.00",
            tax : "30.00",
            total : "430.00"
        }, {
            id : "7",
            date : "2007-10-04",
            name : "test",
            note : "note",
            amount : "200.00",
            tax : "10.00",
            total : "210.00"
        }, {
            id : "8",
            date : "2007-10-03",
            name : "test2",
            note : "note2",
            amount : "300.00",
            tax : "20.00",
            total : "320.00"
        }, {
            id : "9",
            date : "2007-09-01",
            name : "test3",
            note : "note3",
            amount : "400.00",
            tax : "30.00",
            total : "430.00"
        }, {
            id : "10",
            date : "2007-10-01",
            name : "test",
            note : "note",
            amount : "200.00",
            tax : "10.00",
            total : "210.00"
        }, {
            id : "11",
            date : "2007-10-02",
            name : "test2",
            note : "note2",
            amount : "300.00",
            tax : "20.00",
            total : "320.00"
        }, {
            id : "12",
            date : "2007-09-01",
            name : "test3",
            note : "note3",
            amount : "400.00",
            tax : "30.00",
            total : "430.00"
        }, {
            id : "13",
            date : "2007-10-04",
            name : "test",
            note : "note",
            amount : "200.00",
            tax : "10.00",
            total : "210.00"
        }, {
            id : "14",
            date : "2007-10-05",
            name : "test2",
            note : "note2",
            amount : "300.00",
            tax : "20.00",
            total : "320.00"
        }, {
            id : "15",
            date : "2007-09-06",
            name : "test3",
            note : "note3",
            amount : "400.00",
            tax : "30.00",
            total : "430.00"
        }, {
            id : "16",
            date : "2007-10-04",
            name : "test",
            note : "note",
            amount : "200.00",
            tax : "10.00",
            total : "210.00"
        }, {
            id : "17",
            date : "2007-10-03",
            name : "test2",
            note : "note2",
            amount : "300.00",
            tax : "20.00",
            total : "320.00"
        }, {
            id : "18",
            date : "2007-09-01",
            name : "test3",
            note : "note3",
            amount : "400.00",
            tax : "30.00",
            total : "430.00"
        }];

        jQuery("#sysUser_jqgrid").jqGrid({
           // data : jqgrid_data,
            datatype : "json",
            url:'/user/list',
            mtype: "post",
            height : 'auto',
            colNames : [ '用户ID', '用户账号', '用户名称', '用户状态'],
            colModel : [
                { name : 'id', index : 'id' },
                { name : 'username', index : 'username', editable : true },
                { name : 'name', index : 'name', editable : true },
                { name : 'state', index : 'state', editable : true ,formatter:dateConvert}
               /* ,{ name : 'name', index : 'name', editable : true },
                { name : 'amount', index : 'amount', align : "right", editable : true },
                { name : 'tax', index : 'tax', align : "right", editable : true },
                { name : 'total', index : 'total', align : "right", editable : true },
                { name : 'note', index : 'note', sortable : false, editable : true }*/],
            rowNum : 10,
            rowList : [10, 20, 30],
            pager : '#sysUser_pjqgrid',
            sortname : 'id',
            toolbarfilter: true,
            viewrecords : true,
            sortorder : "asc",
            gridComplete: function(){
               /* var ids = jQuery("#sysUser_jqgrid").jqGrid('getDataIDs');
                for(var i=0;i < ids.length;i++){
                    var cl = ids[i];
                    be = "<button class='btn btn-xs btn-default' data-original-title='Edit Row' onclick=\"jQuery('#sysUser_jqgrid').editRow('"+cl+"');\"><i class='fa fa-pencil'></i></button>";
                    se = "<button class='btn btn-xs btn-default' data-original-title='Save Row' onclick=\"jQuery('#sysUser_jqgrid').saveRow('"+cl+"');\"><i class='fa fa-save'></i></button>";
                    ca = "<button class='btn btn-xs btn-default' data-original-title='Cancel' onclick=\"jQuery('#sysUser_jqgrid').restoreRow('"+cl+"');\"><i class='fa fa-times'></i></button>";
                    //ce = "<button class='btn btn-xs btn-default' onclick=\"jQuery('#sysUser_jqgrid').restoreRow('"+cl+"');\"><i class='fa fa-times'></i></button>";
                    //jQuery("#sysUser_jqgrid").jqGrid('setRowData',ids[i],{act:be+se+ce});
                    jQuery("#sysUser_jqgrid").jqGrid('setRowData',ids[i],{act:be+se+ca});
                }*/
            },
            editurl : "dummy.html",
            caption : "用户管理",//设置表title
            multiselect : true,
            autowidth : true,

        });
        jQuery("#sysUser_jqgrid").jqGrid('navGrid', "#sysUser_pjqgrid", {
            edit : false,
            add : false,
            del : true
        });
        jQuery("#sysUser_jqgrid").jqGrid('inlineNav', "#sysUser_pjqgrid");
        /* Add tooltips */
        $('.navtable .ui-pg-button').tooltip({
            container : 'body'
        });
/*

        jQuery("#m1").click(function() {
            var s;
            s = jQuery("#sysUser_jqgrid").jqGrid('getGridParam', 'selarrrow');
            alert(s);
        });
        jQuery("#m1s").click(function() {
            jQuery("#sysUser_jqgrid").jqGrid('setSelection', "13");
        });
*/

        //设置表格样式
        jqgridClass();
        //classjs();

       /* $(window).on('resize.jqGrid', function () {
            jQuery("#sysUser_jqgrid").jqGrid( 'setGridWidth', $("#content").width() );
        })*/


    } // end function


}

function dateConvert(cellvalue){
    if(cellvalue=="0"){
        return "可用";
    }else{
        return "禁用";
    }
}
loadScript("js/plugin/jqgrid/grid.locale-en.min.js", pagefunction);
