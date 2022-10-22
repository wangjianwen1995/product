/*!
 *  build: vue-admin-beautiful 
 *  copyright: chuzhixin 1204505056@qq.com 
 *  time: 2021-3-25 09:05:49
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-34658da4"],{4340:function(e,t,a){"use strict";a("53a7")},"53a7":function(e,t,a){},7632:function(e,t,a){"use strict";a.r(t),a.d(t,"getColumnList",(function(){return l})),a.d(t,"getColumns",(function(){return r})),a.d(t,"findByTableIds",(function(){return o})),a.d(t,"doEdit",(function(){return i})),a.d(t,"doSave",(function(){return s})),a.d(t,"doDelete",(function(){return c})),a.d(t,"deleteColumn",(function(){return u})),a.d(t,"renewBatabase",(function(){return d})),a.d(t,"findzdTable",(function(){return m}));var n=a("b775");function l(e){return Object(n["default"])({url:"/tableVsTable/findByTableId",method:"get",params:e})}function r(e){return Object(n["default"])({url:"/column/findByTableId",method:"get",params:e})}function o(e){return Object(n["default"])({url:"/tableVsTable/findByTableIds/"+e,method:"get"})}function i(e){return Object(n["default"])({url:"/column/update",method:"put",data:e})}function s(e){return Object(n["default"])({url:"/column/save",method:"post",data:e})}function c(e){return Object(n["default"])({url:"/column/del",method:"delete",data:e})}function u(e){return Object(n["default"])({url:"/column/deleteColumn",method:"delete",data:e})}function d(e){return Object(n["default"])({url:"/table/renewDatabase",method:"get",params:e})}function m(){return Object(n["default"])({url:"/tableVsTable/findzdTable",method:"get"})}},"7f5f":function(e,t,a){"use strict";a.r(t);var n=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"relationMapping-container"},[a("el-form",{ref:"ser_form",attrs:{model:e.ser_form,"label-width":"80px"}},[a("el-row",[a("el-col",{attrs:{lg:6}},[a("el-form-item",{attrs:{label:"存储名",prop:"name"}},[a("el-input",{model:{value:e.ser_form.name,callback:function(t){e.$set(e.ser_form,"name",t)},expression:"ser_form.name"}})],1)],1),a("el-col",{staticStyle:{"text-align":"center"},attrs:{lg:8}},[a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.fetchData}},[e._v("查询")]),a("el-button",{on:{click:function(t){return e.resetForm("ser_form")}}},[e._v("重置")]),a("el-button",{on:{click:e.addGx}},[e._v(" 新建映射关系 ")])],1)],1)],1)],1),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,"highlight-current-row":"",border:""}},[a("el-table-column",{attrs:{fixed:"",prop:"name",label:"存储名",width:"250"}}),a("el-table-column",{attrs:{prop:"name_zh",label:"存储中文名",width:"300"}}),a("el-table-column",{attrs:{label:"操作",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return e.edit(t.row.id)}}},[e._v(" 修改 ")]),a("el-button",{attrs:{type:"text",size:"small"},on:{click:function(a){return e.cqsj(t.row)}}},[e._v(" 抽取数据 ")])]}}])})],1),a("el-pagination",{attrs:{"page-size":e.pageInfo2.pageSize,layout:"total, prev, pager, next",total:e.pageInfo2.total},on:{"current-change":e.handleCurrentChange2}}),a("el-dialog",{attrs:{title:"提示",visible:e.timeVisible,width:"30%","before-close":e.handleClose},on:{"update:visible":function(t){e.timeVisible=t}}},[a("el-form",{ref:"time",attrs:{model:e.time}},[a("el-form-item",{attrs:{label:"开始时间"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.time.stime,callback:function(t){e.$set(e.time,"stime",t)},expression:"time.stime"}})],1),a("el-form-item",{attrs:{label:"结束时间"}},[a("el-date-picker",{attrs:{type:"date",placeholder:"选择日期","value-format":"yyyy-MM-dd"},model:{value:e.time.etime,callback:function(t){e.$set(e.time,"etime",t)},expression:"time.etime"}})],1)],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.timeVisible=!1}}},[e._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.extract(2)}}},[e._v(" 确 定 ")])],1)],1),a("el-dialog",{attrs:{title:"对照映射",visible:e.dialogVisible,width:"60%","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("el-form",{ref:"ysForm",attrs:{model:e.ysForm,"label-width":"60px"}},[a("el-row",[a("el-col",{attrs:{lg:8}},[a("el-form-item",{attrs:{label:"产品"}},[a("el-input",{attrs:{value:"源",disabled:!0}})],1)],1),a("el-col",{attrs:{lg:8}},[a("el-form-item",{attrs:{label:"产品"}},[a("el-input",{attrs:{value:"dc",disabled:!0}})],1)],1)],1),a("el-row",[a("el-col",{attrs:{lg:8}},[a("el-form-item",{attrs:{label:"源表"}},[a("el-select",{attrs:{multiple:"","collapse-tags":"",filterable:"",clearable:""},model:{value:e.ysForm.bzb,callback:function(t){e.$set(e.ysForm,"bzb",t)},expression:"ysForm.bzb"}},e._l(e.source,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name_zh,value:e.id}})})),1)],1)],1),a("el-col",{attrs:{lg:8}},[a("el-form-item",{attrs:{label:"标准表"}},[a("el-select",{attrs:{filterable:"",clearable:""},on:{change:e.getStandardList},model:{value:e.ysForm.cpb,callback:function(t){e.$set(e.ysForm,"cpb",t)},expression:"ysForm.cpb"}},e._l(e.standard,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name_zh,value:e.id}})})),1)],1)],1)],1)],1),a("el-table",{staticStyle:{width:"100%"},attrs:{data:e.gridData,border:""}},[a("el-table-column",{attrs:{type:"index"}}),a("el-table-column",{attrs:{prop:"from_table_column_id",label:"源表字段",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-select",{attrs:{size:"mini",filterable:"",clearable:""},on:{change:function(a){e.selectFrom(a,t.$index)}},model:{value:t.row.from_table_column_id,callback:function(a){e.$set(t.row,"from_table_column_id",a)},expression:"scope.row.from_table_column_id"}},e._l(e.options,(function(e,t){return a("el-option",{key:t,attrs:{label:e.from_table_column_zh,value:e.from_table_column_id}})})),1)]}}])}),a("el-table-column",{attrs:{prop:"to_table_column_zh",label:"标准表字段",width:"180"}}),a("el-table-column",{attrs:{prop:"relation_replace_table_id",label:"SQL",width:"350"},scopedSlots:e._u([{key:"default",fn:function(t){return[4==t.row.dc_relation_replace_type_id?a("span",[a("el-select",{attrs:{placeholder:"请选择维表",filterable:"",clearable:""},model:{value:t.row.relation_replace_table_id,callback:function(a){e.$set(t.row,"relation_replace_table_id",a)},expression:"scope.row.relation_replace_table_id"}},e._l(e.wb,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name_zh,value:e.id}})})),1)],1):e._e(),5==t.row.dc_relation_replace_type_id?a("span",[a("el-select",{attrs:{placeholder:"请选择字典类型",filterable:"",clearable:""},model:{value:t.row.relation_replace_table_id,callback:function(a){e.$set(t.row,"relation_replace_table_id",a)},expression:"scope.row.relation_replace_table_id"}},e._l(e.zd,(function(e,t){return a("el-option",{key:t,attrs:{label:e.name_zh,value:e.id}})})),1)],1):e._e(),0==t.row.dc_relation_replace_type_id?a("span"):e._e()]}}])}),a("el-table-column",{attrs:{prop:"dc_relation_replace_type_id",label:"类型",width:"250"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-radio-group",{model:{value:t.row.dc_relation_replace_type_id,callback:function(a){e.$set(t.row,"dc_relation_replace_type_id",a)},expression:"scope.row.dc_relation_replace_type_id"}},[a("el-radio",{attrs:{label:5}},[e._v("字典")]),a("el-radio",{attrs:{label:4}},[e._v("维表")]),a("el-radio",{attrs:{label:0}},[e._v("无")])],1)]}}])})],1),a("el-pagination",{attrs:{"hide-on-single-page":!0,"page-size":e.pageInfo.pageSize,layout:"total, prev, pager, next",total:e.pageInfo.total},on:{"current-change":e.handleCurrentChange}}),a("el-card",{attrs:{shadow:"never"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",{staticStyle:{"margin-right":"20px"}},[e._v("SQL")])]),a("el-input",{attrs:{type:"textarea",autosize:"",resize:"none",readonly:""},model:{value:e.sqlList.insert,callback:function(t){e.$set(e.sqlList,"insert",t)},expression:"sqlList.insert"}})],1),e.masterSlaveList.length>0?a("el-table",{attrs:{data:e.masterSlaveList}},[a("el-table-column",{attrs:{label:"关联表",prop:"relation_talbe_id"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-select",{attrs:{filterable:"",clearable:"",placeholder:0==t.$index?"第一个关系表为主表":"请选择"},model:{value:t.row.relation_talbe_id,callback:function(a){e.$set(t.row,"relation_talbe_id",a)},expression:"scope.row.relation_talbe_id"}},e._l(e.masterSlave,(function(n,l){return a("el-option",{key:l,attrs:{label:n.name_zh,value:n.id},nativeOn:{click:function(a){return e.get(t.$index,"relation_talbe_name",n)}}})})),1)]}}],null,!1,4101087395)}),a("el-table-column",{attrs:{label:"从表",prop:"son_table_id"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-select",{attrs:{filterable:"",clearable:""},model:{value:t.row.son_table_id,callback:function(a){e.$set(t.row,"son_table_id",a)},expression:"scope.row.son_table_id"}},e._l(e.masterSlave,(function(n,l){return a("el-option",{key:l,attrs:{label:n.name_zh,value:n.id},nativeOn:{click:function(a){return e.get(t.$index,"son_table_name",n)}}})})),1)]}}],null,!1,3088288613)}),a("el-table-column",{attrs:{label:"关联表字段",prop:"relation_column_id"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-select",{attrs:{filterable:"",clearable:""},model:{value:t.row.relation_column_id,callback:function(a){e.$set(t.row,"relation_column_id",a)},expression:"scope.row.relation_column_id"}},e._l(t.row.relations,(function(n,l){return a("el-option",{key:l,attrs:{label:n.from_table_column_zh,value:n.from_table_column_id},nativeOn:{click:function(a){return e.selectRelationColumn(n,t.$index,"relation_column_name")}}})})),1)]}}],null,!1,1672870103)}),a("el-table-column",{attrs:{label:"从表字段",prop:"son_column_id"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-select",{attrs:{filterable:"",clearable:""},model:{value:t.row.son_column_id,callback:function(a){e.$set(t.row,"son_column_id",a)},expression:"scope.row.son_column_id"}},e._l(t.row.sons,(function(n,l){return a("el-option",{key:l,attrs:{label:n.from_table_column_zh,value:n.from_table_column_id},nativeOn:{click:function(a){return e.selectRelationColumn(n,t.$index,"son_column_name")}}})})),1)]}}],null,!1,2931681635)}),a("el-table-column",{attrs:{label:"补充SQL",prop:"supplement_sql"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-input",{model:{value:t.row.supplement_sql,callback:function(a){e.$set(t.row,"supplement_sql",a)},expression:"scope.row.supplement_sql"}})]}}],null,!1,947009349)})],1):e._e(),a("el-card",{attrs:{shadow:"never"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("SQL")])]),a("el-input",{attrs:{type:"textarea",autosize:"",resize:"none",readonly:""},model:{value:e.sqlList.leftsql,callback:function(t){e.$set(e.sqlList,"leftsql",t)},expression:"sqlList.leftsql"}})],1),a("el-card",{staticClass:"where",attrs:{shadow:"never"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("筛选条件(运算符优先级:AND > OR)")])]),a("el-row",[a("span",[e._v("定义时间字段")]),a("el-select",{attrs:{filterable:"",clearable:""},model:{value:e.time_colunmn.time_colunmn_id,callback:function(t){e.$set(e.time_colunmn,"time_colunmn_id",t)},expression:"time_colunmn.time_colunmn_id"}},e._l(e.options,(function(t,n){return a("el-option",{key:n,attrs:{label:t.from_table_column_zh,value:t.from_table_column_id},nativeOn:{click:function(a){return e.selectTime_colunmn(t)}}})})),1)],1),e._l(e.whereTable,(function(t,n){return a("el-row",{key:n},["自定义"!=t.gx?a("el-col",{attrs:{span:6}},[a("el-select",{attrs:{size:"small",filterable:"",clearable:""},model:{value:t.zd,callback:function(a){e.$set(t,"zd",a)},expression:"item.zd"}},e._l(e.options,(function(e,t){return a("el-option",{key:t,attrs:{label:e.from_table_column_zh,value:e.from_table_column}})})),1)],1):e._e(),a("el-col",{attrs:{span:3}},[a("el-select",{staticStyle:{width:"85px"},attrs:{size:"small",filterable:"",clearable:""},model:{value:t.gx,callback:function(a){e.$set(t,"gx",a)},expression:"item.gx"}},e._l(e.gxList,(function(t,n){return a("el-option",{key:n,attrs:{label:t.label,value:t.label},on:{change:e.selectGx}})})),1)],1),a("el-col",{attrs:{span:"自定义"==t.gx?18:10}},[a("el-input",{model:{value:t.value,callback:function(a){e.$set(t,"value",a)},expression:"item.value"}})],1),a("el-col",{attrs:{span:3}},[n===e.whereTable.length-1?a("el-button",{attrs:{type:"text",icon:"el-icon-plus",circle:""},on:{click:function(a){return e.addRow(t)}}}):e._e(),n===e.whereTable.length-1&&0!=n?a("el-button",{attrs:{type:"text",icon:"el-icon-minus",circle:""},on:{click:function(t){return e.delRow(n)}}}):e._e(),n!=e.whereTable.length-1?a("el-button",{attrs:{type:"text"},on:{click:function(a){return e.changeAo(t)}}},[e._v(" "+e._s(t.ao)+" ")]):e._e()],1)],1)}))],2),a("el-card",{attrs:{shadow:"never"}},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[e._v("SQL")])]),a("el-input",{attrs:{type:"textarea",autosize:"",resize:"none",readonly:""},model:{value:e.sqlList.wheresql,callback:function(t){e.$set(e.sqlList,"wheresql",t)},expression:"sqlList.wheresql"}})],1),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),a("el-button",{on:{click:e.cs}},[e._v(" 测 试 ")]),a("el-button",{attrs:{type:"primary"},on:{click:e.save}},[e._v(" 保 存 ")])],1)],1)],1)},l=[],r=(a("9953"),a("422c"),a("233a"),a("5c4c"),a("845c"),a("d8f4"),a("72fb"),a("2083"),a("1f90"),a("6a61"),a("2e91")),o=a("ad8f"),i=a("d434"),s=a("7632"),c=a("9d1a"),u=(a("1cfa"),{data:function(){return{value2:"",dialogVisible:!1,timeVisible:!1,ser_form:{name:""},wb:[],zd:[],pageInfo:{pageNum:1,pageSize:8,total:0},pageInfo2:{pageNum:1,pageSize:8,total:0},ysForm:{bzb:"",cpb:""},whereTable:[{zd:"",gx:"",value:"",ao:"and"}],id:"",aoFlag:!1,tableData:[],gridData:[],standard:[],source:[],options:[],masterSlave:[],masterSlaveList:[],sqlList:{insert:"",leftsql:"",wheresql:""},gxList:[{label:"="},{label:"!="},{label:"<"},{label:"<="},{label:">"},{label:">="},{label:"like"},{label:"自定义"}],time_colunmn:{time_colunmn_id:"",time_column_name:""},str:!0,content:"",row:"",time:{stime:"",etime:""}}},watch:{masterSlave:function(e){var t=this;this.masterSlaveList=[],_(e).forEach((function(a,n){0!=n?t.masterSlaveList.push({relation_column_id:"",relation_talbe_id:"",relation_talbe_name:"",son_table_name:"",son_table_id:"",relation_column_name:"",son_column_id:"",son_column_name:"",supplement_sql:"",procedure_id:"",relations:[],sons:[]}):t.sqlList.leftsql="From "+e[0].name}))},masterSlaveList:{handler:function(e,t){if(e.length>0){var a="";_(e).forEach((function(e,t){a+="Left join "+e.son_table_name+" on "+e.son_column_name+" = "+e.relation_column_name+" "+e.supplement_sql+" \r\n"})),this.sqlList.leftsql="From "+e[0].relation_talbe_name+" \r\n"+a}},deep:!0},whereTable:{handler:function(e,t){var a="";_(e).forEach((function(t,n){"自定义"!=t.gx?a+=t.zd+" "+t.gx+(t.value?" ''":"")+t.value+(t.value?"'' ":"")+(n==e.length-1?"":t.ao)+" \r\n":a+=t.value+""+(n==e.length-1?"":t.ao)+" \r\n"})),this.sqlList.wheresql=a},deep:!0},gridData:{handler:function(e,t){var a=this,n=this.wb,l=this.zd,r="",o="";_(e).forEach((function(e){if(e.to_table_column&&(r+=e.to_table_column+","),5==e.dc_relation_replace_type_id){var t=l[_.findIndex(l,(function(t){return t.id==e.relation_replace_table_id}))].name;o+="(select name from dc_dict_val where val = "+e.from_table_column+" and dic_name = ''"+t+"''),"}else if(4==e.dc_relation_replace_type_id){if(!e.relation_replace_table_id)return a.$message({type:"warning",message:"请选择维表！！！"}),!1;t=n[_.findIndex(n,(function(t){return t.id==e.relation_replace_table_id}))].name;o+="(select name from "+t+" where "+e.from_table_column+" = code),"}else o+=(null==e.from_table_column?"null":e.from_table_column)+","})),setTimeout((function(){a.sqlList.insert="Insert into "+a.gridData[0].to_table_name+" ("+r.substr(0,r.length-1)+") \r\nselect "+o.substr(0,o.length-1)}))},deep:!0},"ysForm.bzb":function(e){this.getSourceList(e)}},created:function(){this.getStandard(),this.getSource(),this.fetchData(),this.getWb(),this.getZd()},methods:{handleClose:function(e){this.$confirm("确认关闭？").then((function(t){e()})).catch((function(e){}))},selectFrom:function(e,t){var a=this.options[_.findIndex(this.options,(function(t){return t.from_table_column_id==e}))];this.gridData[t].from_table_column=a.from_table_column,this.gridData[t].from_table_column_zh=a.from_table_column_zh,this.gridData[t].from_table_id=a.from_table_id},addRow:function(e){""!=e.zd&&""!=e.gx&&""!=e.value&&this.whereTable.push({zd:"",gx:"",value:"",ao:"and"})},delRow:function(e){this.whereTable=this.whereTable.slice(0,e)},cqsj:function(e){this.row=JSON.parse(JSON.stringify(e)),1==e.isparam?this.timeVisible=!0:this.extract(1)},extract:function(e){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function a(){var n,l,r,o,s,c,u;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:if(1!=e){a.next=10;break}return a.next=3,Object(i["extractDate"])(t.row);case 3:n=a.sent,n.t,l=n.state,r=n.msg,t.$message({type:l,message:r}),a.next=19;break;case 10:return o=JSON.parse(JSON.stringify(t.row)),a.next=13,Object(i["extractDate"])(_.assign(o,t.time));case 13:s=a.sent,s.t,c=s.state,u=s.msg,t.$message({type:c,message:u}),t.timeVisible=!1;case 19:case"end":return a.stop()}}),a)})))()},selectTime_colunmn:function(e){this.time_colunmn.time_column_name=e.from_table_column},resetForm:function(e){this.$refs[e].resetFields(),this.fetchData()},handleCurrentChange:function(e){this.pageInfo.pageNum=e},handleCurrentChange2:function(e){this.pageInfo2.pageNum=e},selectGx:function(e){},changeAo:function(e){"and"==e.ao?e.ao="or":e.ao="and"},getStandard:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(o["getTable"])({type:2});case 2:a=t.sent,n=a.t,e.standard=n.list;case 5:case"end":return t.stop()}}),t)})))()},getSource:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(o["getTable"])({type:1});case 2:a=t.sent,n=a.t,e.source=n.list;case 5:case"end":return t.stop()}}),t)})))()},getWb:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(o["getTable"])({type:4});case 2:a=t.sent,n=a.t,e.wb=n.list;case 5:case"end":return t.stop()}}),t)})))()},getZd:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(s["findzdTable"])();case 2:a=t.sent,n=a.t,e.zd=n;case 5:case"end":return t.stop()}}),t)})))()},get:function(e,t,a){var n=this;return Object(r["a"])(regeneratorRuntime.mark((function l(){var r,o;return regeneratorRuntime.wrap((function(l){while(1)switch(l.prev=l.next){case 0:return l.next=2,Object(s["findByTableIds"])(a.id);case 2:r=l.sent,o=r.t,n.masterSlaveList[e][t.split("_")[0]+"s"]=o,n.masterSlaveList[e][t]=a.name;case 6:case"end":return l.stop()}}),l)})))()},selectRelationColumn:function(e,t,a){this.masterSlaveList[t][a]=e.from_table_column},getSourceList:function(e){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function a(){var n,l,r;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:if(!(e.length>0)){a.next=10;break}return a.next=3,Object(s["findByTableIds"])(_.toString(e));case 3:n=a.sent,l=n.t,t.options=l,r=t.source,t.$nextTick((function(){var t=[];_(e).forEach((function(e){t.push(r[_.findIndex(r,{id:e})])})),this.masterSlave=t})),a.next=11;break;case 10:t.sqlList.leftsql="";case 11:case"end":return a.stop()}}),a)})))()},getStandardList:function(e){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function a(){var n,l,r;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return n=JSON.parse(JSON.stringify(t.pageInfo)),n["tableid"]=e,a.next=4,Object(s["getColumnList"])(n);case 4:l=a.sent,r=l.t,t.gridData=r.list;case 7:case"end":return a.stop()}}),a)})))()},save:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n,l,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a={},a["dcTableVsTables"]=e.gridData,a["dcvirtualTables"]=e.masterSlaveList,a["map_sql"]=e.sqlList.insert,a["join_sql"]=e.sqlList.leftsql,a["where_sql"]=e.sqlList.wheresql,a["to_table_id"]=e.gridData[0].to_table_id,a["table_main_id"]=e.masterSlaveList.length>0?e.masterSlaveList[0].relation_talbe_id:e.masterSlave[0].id,a["table_mian_name"]=e.masterSlaveList.length>0?e.masterSlaveList[0].relation_talbe_name:e.masterSlave[0].name,a["name"]="ETL_Dc_ots_"+(e.str?e.masterSlave[0].name:e.masterSlaveList[0].relation_talbe_name)+"_to_"+e.gridData[0].to_table_name,a["name_zh"]="从源表"+(e.str?e.masterSlave[0].name:e.masterSlaveList[0].relation_talbe_name)+"中抽取数据到"+e.gridData[0].to_table_name+"的标准表中",a["time_column_id"]=e.time_colunmn.time_colunmn_id,a["time_column_name"]=e.time_colunmn.time_column_name,a["from_product_id"]=21,a["to_product_id"]=20,a["type_id"]=2,a["id"]=e.id,a["content"]=e.content,t.next=20,Object(c["saveVs"])(a);case 20:n=t.sent,n.t,l=n.msg,r=n.state,e.$message({type:r,message:l}),e.dialogVisible=!1,e.fetchData(),"success"==r&&(e.gridData="",e.masterSlaveList="",e.time_colunmn.time_colunmn_id="",e.time_colunmn.time_column_name="",e.id="",e.ysForm.bzb="",e.ysForm.cpb="",e.whereTable=[{zd:"",gx:"",value:"",ao:"and"}]);case 28:case"end":return t.stop()}}),t)})))()},cs:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n,l,r,o;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a={},a["dcTableVsTables"]=e.gridData,a["dcvirtualTables"]=e.masterSlaveList,a["map_sql"]=e.sqlList.insert,a["to_table_id"]=e.gridData[0].to_table_id,a["join_sql"]=e.sqlList.leftsql,a["where_sql"]=e.sqlList.wheresql,a["table_main_id"]=e.masterSlaveList.length>0?e.masterSlaveList[0].relation_talbe_id:e.masterSlave[0].id,a["table_mian_name"]=e.masterSlaveList.length>0?e.masterSlaveList[0].relation_talbe_name:e.masterSlave[0].name,a["name"]="ETL_Dc_ots_"+(e.str?e.masterSlave[0].name:e.masterSlaveList[0].relation_talbe_name)+"_to_"+e.gridData[0].to_table_name,a["name_zh"]="从源表"+(e.str?e.masterSlave[0].name:e.masterSlaveList[0].relation_talbe_name)+"中抽取数据到"+e.gridData[0].to_table_name+"的标准表中",a["time_column_id"]=e.time_colunmn.time_colunmn_id,a["time_column_name"]=e.time_colunmn.time_column_name,a["from_product_id"]=21,a["to_product_id"]=20,a["type_id"]=2,a["id"]=e.id,a["content"]="",t.next=20,Object(c["testProc"])(a);case 20:n=t.sent,l=n.t,r=n.msg,o=n.state,e.$message({type:o,message:r}),e.content=l;case 26:case"end":return t.stop()}}),t)})))()},fetchData:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,n,l;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return a=JSON.parse(JSON.stringify(e.pageInfo2)),t.next=3,Object(i["findAllOts"])(_.assign(a,{type_id:2},{name:e.ser_form.name}));case 3:n=t.sent,l=n.t,e.tableData=l.list,e.pageInfo2.total=l.total;case 7:case"end":return t.stop()}}),t)})))()},edit:function(e){var t=this;return Object(r["a"])(regeneratorRuntime.mark((function a(){var n,l;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return t.str=!1,a.next=3,Object(c["getTableVsTableList"])({id:e});case 3:n=a.sent,l=n.t,t.dialogVisible=!0,t.gridData=l.dcTableVsTables,setTimeout((function(){t.masterSlaveList=l.dcvirtualTables}),1e3),t.time_colunmn.time_colunmn_id=l.time_column_id,t.time_colunmn.time_column_name=l.time_column_name,t.id=l.id,t.whereTable=[{zd:"",gx:"自定义",value:l.where_sql,ao:"and"}],t.ysForm.bzb=l.ytable,t.ysForm.cpb=l.bztable;case 14:case"end":return a.stop()}}),a)})))()},addGx:function(){this.dialogVisible=!0,this.str=!0,this.ysForm.bzb="",this.ysForm.cpb="",this.gridData=[],this.masterSlaveList=[],this.id=null,this.sqlList.insert="",this.sqlList.wheresql="",this.sqlList.leftsql="",this.time_colunmn.time_colunmn_id="",this.time_colunmn.time_column_name="",this.whereTable=[{zd:"",gx:"",value:"",ao:"and"}]}}}),d=u,m=(a("4340"),a("c701")),f=Object(m["a"])(d,n,l,!1,null,null,null);t["default"]=f.exports},9953:function(e,t,a){"use strict";var n=a("47c2"),l=a("8555").findIndex,r=a("3592"),o=a("4686"),i="findIndex",s=!0,c=o(i);i in[]&&Array(1)[i]((function(){s=!1})),n({target:"Array",proto:!0,forced:s||!c},{findIndex:function(e){return l(this,e,arguments.length>1?arguments[1]:void 0)}}),r(i)},"9d1a":function(e,t,a){"use strict";a.r(t),a.d(t,"getList",(function(){return l})),a.d(t,"getTableVsTableList",(function(){return r})),a.d(t,"testProc",(function(){return o})),a.d(t,"tesWBtProc",(function(){return i})),a.d(t,"saveWB",(function(){return s})),a.d(t,"getTable",(function(){return c})),a.d(t,"doEdit",(function(){return u})),a.d(t,"saveVs",(function(){return d})),a.d(t,"doDelete",(function(){return m}));var n=a("b775");function l(e){return Object(n["default"])({url:"/table/findAll",method:"get",params:e})}function r(e){return Object(n["default"])({url:"/tableVsTable/findById",method:"get",params:e})}function o(e){return Object(n["default"])({url:"/tableVsTable/testProc",method:"put",data:e})}function i(e){return Object(n["default"])({url:"/tableVsTable/tesWBtProc",method:"put",data:e})}function s(e){return Object(n["default"])({url:"/tableVsTable/saveWB",method:"post",data:e})}function c(e){return Object(n["default"])({url:"/table/findByType",method:"get",params:e})}function u(e){return Object(n["default"])({url:"/table/update",method:"put",data:e})}function d(e){return Object(n["default"])({url:"/tableVsTable/save",method:"post",data:e})}function m(e){return Object(n["default"])({url:"/table/del",method:"delete",data:e})}},ad8f:function(e,t,a){"use strict";a.r(t),a.d(t,"getList",(function(){return l})),a.d(t,"renewDatabase",(function(){return r})),a.d(t,"findWBBytableId",(function(){return o})),a.d(t,"getTable",(function(){return i})),a.d(t,"doEdit",(function(){return s})),a.d(t,"doSave",(function(){return c})),a.d(t,"doDelete",(function(){return u})),a.d(t,"deleteTable",(function(){return d})),a.d(t,"getByProductId",(function(){return m}));var n=a("b775");function l(e){return Object(n["default"])({url:"/table/findAll",method:"get",params:e})}function r(e){return Object(n["default"])({url:"/table/renewDatabase",method:"get",params:e})}function o(e){return Object(n["default"])({url:"/table/findWBBytableId",method:"get",params:e})}function i(e){return Object(n["default"])({url:"/table/findByType",method:"get",params:e})}function s(e){return Object(n["default"])({url:"/table/update",method:"put",data:e})}function c(e){return Object(n["default"])({url:"/table/save",method:"post",data:e})}function u(e){return Object(n["default"])({url:"/table/del",method:"delete",data:e})}function d(e){return Object(n["default"])({url:"/table/deleteTable",method:"delete",data:e})}function m(e){return Object(n["default"])({url:"/table/findByProductId",method:"get",params:e})}},d434:function(e,t,a){"use strict";a.r(t),a.d(t,"testProc",(function(){return l})),a.d(t,"findAllOts",(function(){return r})),a.d(t,"findDcProcedure",(function(){return o})),a.d(t,"saveProc",(function(){return i})),a.d(t,"findAllProc",(function(){return s})),a.d(t,"updateProc",(function(){return c})),a.d(t,"getExtract",(function(){return u})),a.d(t,"extractDate",(function(){return d})),a.d(t,"extractDateWb",(function(){return m}));var n=a("b775");function l(e){return Object(n["default"])({url:"/dcProcedure/testProc",method:"put",data:e})}function r(e){return Object(n["default"])({url:"/dcProcedure/findAllOts",method:"get",params:e})}function o(e){return Object(n["default"])({url:"/dcProcedure/findByName",method:"get",params:e})}function i(e){return Object(n["default"])({url:"/dcProcedure/save",method:"post",data:e})}function s(e){return Object(n["default"])({url:"/dcProcedure/findAll",method:"get",data:e})}function c(e){return Object(n["default"])({url:"/dcProcedure/update",method:"get",data:e})}function u(e){return Object(n["default"])({url:"/dcProcedure/getExtract",method:"post",data:e})}function d(e){return Object(n["default"])({url:"/dcProcedure/extractDate",method:"post",data:e})}function m(e){return Object(n["default"])({url:"/dcProcedure/extractDateWb",method:"post",data:e})}}}]);