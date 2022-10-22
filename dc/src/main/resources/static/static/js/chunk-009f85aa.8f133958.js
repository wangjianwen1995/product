/*!
 *  build:  
 *  time: 2022-2-17 10:18:19
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-009f85aa"],{8126:function(e,t,n){"use strict";n.r(t);var a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{staticClass:"webInterface-container"},[n("el-form",{ref:"ser_form",attrs:{model:e.ser_form,inline:"","label-width":"90px"}},[n("el-row",[n("el-col",{staticStyle:{"text-align":"right"},attrs:{span:24}},[n("el-form-item",{attrs:{label:"表名",prop:"name"}},[n("el-input",{model:{value:e.ser_form.name,callback:function(t){e.$set(e.ser_form,"name",t)},expression:"ser_form.name"}})],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:e.handleSer}},[e._v("查询")]),n("el-button",{on:{click:function(t){return e.resetForm("ser_form")}}},[e._v("重置")]),n("el-button",{on:{click:e.addWebsevice}},[e._v("新建")])],1)],1)],1)],1),n("el-table",{staticStyle:{width:"100%"},attrs:{data:e.tableData,border:"","highlight-current-row":""}},[n("el-table-column",{attrs:{prop:"name_zh",label:"表中文名",align:"center"}}),n("el-table-column",{attrs:{prop:"name",label:"表名",align:"center"}}),n("el-table-column",{attrs:{prop:"is_public",label:"是否公用",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-tag",{attrs:{type:1===t.row.is_public?"primary":"success","disable-transitions":""}},[e._v(" "+e._s(2===t.row.is_public?"公用":"非公用")+" ")])]}}])}),n("el-table-column",{attrs:{label:"操作",width:"200",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-button",{attrs:{type:"text",size:"small"},on:{click:function(n){return e.handleUpdate(t.row)}}},[e._v(" 更新数据库 ")]),n("el-button",{attrs:{type:"text",size:"small"},on:{click:function(n){return e.handleClick(t.row)}}},[e._v(" 字段维护 ")]),n("el-button",{attrs:{type:"text",size:"small"},on:{click:function(n){return e.handlDdel(t.row)}}},[e._v(" 删除 ")])]}}])})],1),n("el-pagination",{attrs:{"page-size":e.pageInfo.pageSize,layout:"total, prev, pager, next",total:e.pageInfo.total},on:{"current-change":e.handleCurrentChange}}),n("el-dialog",{attrs:{title:"编辑",visible:e.dialogVisible,width:"50%","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[n("el-form",{ref:"edit_from",attrs:{"label-width":"95px",rules:e.rules,model:e.edit_from}},[n("el-form-item",{attrs:{label:"表名",prop:"name"}},[n("el-input",{attrs:{placeholder:"表名前缀必须为 W_",disabled:!!e.edit_from.id},model:{value:e.edit_from.name,callback:function(t){e.$set(e.edit_from,"name",t)},expression:"edit_from.name"}})],1),n("el-form-item",{attrs:{label:"表中文名",prop:"name_zh"}},[n("el-input",{attrs:{disabled:!!e.edit_from.id},model:{value:e.edit_from.name_zh,callback:function(t){e.$set(e.edit_from,"name_zh",t)},expression:"edit_from.name_zh"}})],1)],1),n("el-table",{attrs:{data:e.dcColumnList,"highlight-current-row":""}},[n("el-table-column",{attrs:{prop:"column_name",label:"字段名"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.$index>=3?n("el-input",{model:{value:t.row.column_name,callback:function(n){e.$set(t.row,"column_name",n)},expression:"scope.row.column_name"}}):e._e(),t.$index<3?n("span",[e._v(e._s(t.row.column_name))]):e._e()]}}])}),n("el-table-column",{attrs:{prop:"column_name_zh",label:"字段中文名"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.$index>=3?n("el-input",{model:{value:t.row.column_name_zh,callback:function(n){e.$set(t.row,"column_name_zh",n)},expression:"scope.row.column_name_zh"}}):e._e(),t.$index<3?n("span",[e._v(e._s(t.row.column_name_zh))]):e._e()]}}])}),n("el-table-column",{attrs:{prop:"type_id",label:"类型"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-select",{model:{value:t.row.type_id,callback:function(n){e.$set(t.row,"type_id",n)},expression:"scope.row.type_id"}},e._l(e.typeList,(function(a,r){return n("el-option",{key:r,attrs:{label:a.name,value:a.val},nativeOn:{click:function(n){return e.setColumn(t.$index,a)}}})})),1)]}}])}),n("el-table-column",{attrs:{prop:"size",label:"长度"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-input-number",{attrs:{"controls-position":"right",size:"mini"},model:{value:t.row.size,callback:function(n){e.$set(t.row,"size",n)},expression:"scope.row.size"}})]}}])}),n("el-table-column",{attrs:{prop:"scale",label:"小数位数"},scopedSlots:e._u([{key:"default",fn:function(t){return[n("el-input-number",{attrs:{"controls-position":"right",size:"mini"},model:{value:t.row.scale,callback:function(n){e.$set(t.row,"scale",n)},expression:"scope.row.scale"}})]}}])}),n("el-table-column",{attrs:{width:"70px"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.$index==e.dcColumnList.length-1?n("el-button",{attrs:{type:"text",icon:"el-icon-plus"},on:{click:e.addRow}}):e._e(),t.$index>=3?n("el-button",{attrs:{type:"text",icon:"el-icon-minus"},on:{click:function(n){return e.delRow(t.$index)}}}):e._e()]}}])})],1),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.handleSave}},[e._v("确 定")])],1)],1)],1)},r=[],i=(n("422c"),n("90d4"),n("5c4c"),n("1f90"),n("6a61"),n("2e91")),o=n("ad8f"),u=n("c3ec"),l=(n("c4c8"),n("1cfa"),n("f59e"),{components:{},data:function(){return{pageInfo:{pageSize:2,pageNum:1,total:0},dialogVisible:!1,bzdvisible:!1,id:"",ser_form:{name:""},rules:{name_zh:[{required:!0,message:"请输入表中文名",trigger:"blur"}],name:[{required:!0,message:"请输入表名",trigger:"blur"}]},tableData:[],cpData:[],tableTypeList:[{id:1,name:"源生表"},{id:2,name:"标准表"},{id:3,name:"产品表"}],edit_from:{name:"",name_zh:"",type_id:4,is_public:1},dcColumnList:[],typeList:[{name:"字符串",val:1},{name:"整数",val:2}]}},created:function(){this.fetchData(this.pageInfo)},methods:{resetForm:function(e){this.$refs[e].resetFields(),this.fetchData()},addWebsevice:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:e.dialogVisible=!0,e.edit_from={name:"",name_zh:"",type_id:4,is_public:1},e.dcColumnList=[{vsColumn_Id:"",vsTable_Id:"",id:"",table_id:"",table_name:"",column_name:"id",column_name_zh:"序号",type_id:"",type:"",size:255,scale:0},{vsColumn_Id:"",vsTable_Id:"",id:"",table_id:"",table_name:"",column_name:"code",column_name_zh:"代码",type_id:"",type:"",size:255,scale:0},{vsColumn_Id:"",vsTable_Id:"",id:"",table_id:"",table_name:"",column_name:"name",column_name_zh:"名称",type_id:"",type:"",size:255,scale:0}];case 3:case"end":return t.stop()}}),t)})))()},handleCurrentChange:function(e){this.pageInfo.pageNum=e,this.fetchData()},fetchData:function(e){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function e(){var n,a,r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return n={},n["pageSize"]=t.pageInfo.pageSize,n["pageNum"]=t.pageInfo.pageNum,n["name"]=t.ser_form.name,e.next=6,Object(u["findWB"])(n);case 6:a=e.sent,r=a.t,t.tableData=r.list,t.pageInfo.total=r.total;case 10:case"end":return e.stop()}}),e)})))()},addRow:function(){this.dcColumnList.push({vsColumn_Id:"",vsTable_Id:"",id:"",table_id:"",table_name:"",column_name:"",column_name_zh:"",type_id:"",type:"",size:255,scale:0})},delRow:function(e){this.dcColumnList.splice(e,1)},setColumn:function(e,t){this.dcColumnList[e].type=t.name},handleSer:function(){var e=JSON.parse(JSON.stringify(this.pageInfo));this.fetchData(_.assign(e,this.ser_form))},handlDdel:function(e){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function n(){var a,r,i;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,Object(o["doDelete"])({id:e.id,type_id:e.type_id,name:e.name});case 2:a=n.sent,a.t,r=a.msg,i=a.state,t.$message({message:r,type:i}),t.fetchData(t.pageInfo);case 8:case"end":return n.stop()}}),n)})))()},handleClick:function(e){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function n(){var a,r;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,Object(o["findWBBytableId"])({tableId:e.id});case 2:a=n.sent,r=a.t,t.dcColumnList=r.dcColumnList,delete r["dcColumnList"],t.edit_from=r,t.dialogVisible=!0;case 8:case"end":return n.stop()}}),n)})))()},handleSave:function(){var e=this;this.$refs["edit_from"].validate((function(t){if(!t)return!1;e.edit_from.id?e.unpdate():e.insert()}))},unpdate:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function t(){var n,a,r,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n=JSON.parse(JSON.stringify(e.edit_from)),n["dcColumnList"]=e.dcColumnList,_(e.dcColumnList).forEach((function(t){t.table_name=e.edit_from.name})),t.next=5,Object(o["doEdit"])(n);case 5:a=t.sent,a.t,r=a.msg,i=a.state,e.$message({message:r,type:i}),e.dialogVisible=!1,e.fetchData(e.pageInfo);case 12:case"end":return t.stop()}}),t)})))()},insert:function(){var e=this;return Object(i["a"])(regeneratorRuntime.mark((function t(){var n,a,r,i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return n=JSON.parse(JSON.stringify(e.edit_from)),n["dcColumnList"]=e.dcColumnList,_(e.dcColumnList).forEach((function(t){t.table_name=e.edit_from.name})),t.next=5,Object(o["doSave"])(n);case 5:a=t.sent,a.t,r=a.msg,i=a.state,e.$message({message:r,type:i}),e.dialogVisible=!1,e.fetchData(e.pageInfo);case 12:case"end":return t.stop()}}),t)})))()},badwh:function(e){this.bzdvisible=e},show:function(e){this.bzdvisible=!0,this.id=e},handleClose:function(e){this.$confirm("确认关闭？").then((function(t){e()})).catch((function(e){}))},handleUpdate:function(e){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function n(){var a,r,i;return regeneratorRuntime.wrap((function(n){while(1)switch(n.prev=n.next){case 0:return n.next=2,Object(o["renewDatabase"])({id:e.id});case 2:a=n.sent,a.t,r=a.msg,i=a.state,t.$message({type:i,message:r});case 7:case"end":return n.stop()}}),n)})))()}}}),c=l,s=n("c701"),d=Object(s["a"])(c,a,r,!1,null,null,null);t["default"]=d.exports},ad8f:function(e,t,n){"use strict";n.r(t),n.d(t,"getList",(function(){return r})),n.d(t,"renewDatabase",(function(){return i})),n.d(t,"findWBBytableId",(function(){return o})),n.d(t,"getTable",(function(){return u})),n.d(t,"doEdit",(function(){return l})),n.d(t,"doSave",(function(){return c})),n.d(t,"saveByDB",(function(){return s})),n.d(t,"doDelete",(function(){return d})),n.d(t,"deleteTable",(function(){return f})),n.d(t,"getByProductId",(function(){return m})),n.d(t,"updateByDB",(function(){return p}));var a=n("b775");function r(e){return Object(a["default"])({url:"/table/findAll",method:"get",params:e})}function i(e){return Object(a["default"])({url:"/table/renewDatabase",method:"get",params:e})}function o(e){return Object(a["default"])({url:"/table/findWBBytableId",method:"get",params:e})}function u(e){return Object(a["default"])({url:"/table/findByType",method:"get",params:e})}function l(e){return Object(a["default"])({url:"/table/update",method:"put",data:e})}function c(e){return Object(a["default"])({url:"/table/save",method:"post",data:e})}function s(e){return Object(a["default"])({url:"/table/saveByDB",method:"post",data:e})}function d(e){return Object(a["default"])({url:"/table/del",method:"delete",data:e})}function f(e){return Object(a["default"])({url:"/table/deleteTable",method:"delete",data:e})}function m(e){return Object(a["default"])({url:"/table/findByProductId",method:"get",params:e})}function p(e){return Object(a["default"])({url:"/table/updateByDB",method:"post",data:e})}},c3ec:function(e,t,n){"use strict";n.r(t),n.d(t,"findWB",(function(){return r})),n.d(t,"findWBById",(function(){return i})),n.d(t,"insertDv",(function(){return o})),n.d(t,"updateDv",(function(){return u}));var a=n("b775");function r(e){return Object(a["default"])({url:"/table/findWB",method:"get",params:e})}function i(e){return Object(a["default"])({url:"/tableVsTable/findWBById",method:"get",params:e})}function o(e){return Object(a["default"])({url:"/dv/insert",method:"post",data:e})}function u(e){return Object(a["default"])({url:"/dv/update",method:"put",data:e})}},c4c8:function(e,t,n){"use strict";n.r(t),n.d(t,"getProduct",(function(){return r})),n.d(t,"selectAll",(function(){return i})),n.d(t,"deleteRow",(function(){return o})),n.d(t,"getName",(function(){return u})),n.d(t,"insert",(function(){return l})),n.d(t,"update",(function(){return c})),n.d(t,"findByProductId",(function(){return s})),n.d(t,"findByLikeName",(function(){return d})),n.d(t,"findIdByProductId",(function(){return f}));var a=n("b775");function r(){return Object(a["default"])({url:"/product/findAll",method:"get"})}function i(){return Object(a["default"])({url:"/product/selectAll",method:"get"})}function o(e){return Object(a["default"])({url:"/product/delete",method:"delete",data:e})}function u(e){return Object(a["default"])({url:"/product/findByName",method:"get",params:e})}function l(e){return Object(a["default"])({url:"/product/insert",method:"post",data:e})}function c(e){return Object(a["default"])({url:"/product/update",method:"put",data:e})}function s(e){return Object(a["default"])({url:"/product/findByProductId",method:"get",params:e})}function d(e){return Object(a["default"])({url:"/product/findByLikeName",method:"get",params:e})}function f(e){return Object(a["default"])({url:"/product/findIdByProductId",method:"get",params:e})}},f59e:function(e,t,n){"use strict";n.r(t),n.d(t,"findByFactor",(function(){return r})),n.d(t,"insertDv",(function(){return i})),n.d(t,"updateDv",(function(){return o}));var a=n("b775");function r(e){return Object(a["default"])({url:"/dv/findByFactor",method:"get",params:e})}function i(e){return Object(a["default"])({url:"/dv/insert",method:"post",data:e})}function o(e){return Object(a["default"])({url:"/dv/update",method:"put",data:e})}}}]);