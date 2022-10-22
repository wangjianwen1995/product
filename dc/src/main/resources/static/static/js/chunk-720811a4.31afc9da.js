/*!
 *  build: vue-admin-beautiful 
 *  copyright: chuzhixin 1204505056@qq.com 
 *  time: 2021-3-25 09:05:49
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-720811a4"],{"0f58":function(e,t,r){"use strict";r.r(t),r.d(t,"getList",(function(){return a})),r.d(t,"insert",(function(){return n})),r.d(t,"update",(function(){return l})),r.d(t,"del",(function(){return i}));var o=r("b775");function a(e){return Object(o["default"])({url:"/logError/findAll",method:"get",params:e})}function n(e){return Object(o["default"])({url:"/logError/insert",method:"post",data:e})}function l(e){return Object(o["default"])({url:"/logError/update",method:"put",data:e})}function i(e){return Object(o["default"])({url:"/logError/delete",method:"delete",data:e})}},"74db":function(e,t,r){"use strict";r.r(t);var o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"goods-list-container"},[r("vab-query-form",[r("vab-query-form-right-panel",{attrs:{span:24}},[r("el-form",{ref:"form",attrs:{model:e.queryForm,inline:!0},nativeOn:{submit:function(e){e.preventDefault()}}},[r("el-form-item",[r("el-input",{attrs:{placeholder:"错误标题"},model:{value:e.queryForm.title,callback:function(t){e.$set(e.queryForm,"title",t)},expression:"queryForm.title"}})],1),r("el-form-item",[r("el-button",{attrs:{icon:"el-icon-search",type:"primary","native-type":"submit"},on:{click:e.handleQuery}},[e._v(" 查询 ")]),r("el-button",{attrs:{icon:"el-icon-plus","native-type":"submit"},on:{click:e.handleAdd}},[e._v(" 新增 ")])],1)],1)],1)],1),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],ref:"tableSort",attrs:{data:e.list,"element-loading-text":e.elementLoadingText}},[r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"序号",width:"95"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v(" "+e._s(t.$index+1)+" ")]}}])}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",prop:"productName",label:"产品名称"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"错误标题",prop:"title"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"提交",prop:"name"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"修改",prop:"name2"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"描述",prop:"describe"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"备注",prop:"comment"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"提交时间",prop:"submitTime"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"更新时间",prop:"updateTime"}}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"错误截图"},scopedSlots:e._u([{key:"default",fn:function(t){return[e.imgShow?r("el-image",{attrs:{"preview-src-list":e.imageList,src:t.row.jpg}}):e._e()]}}])}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"状态"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-tooltip",{staticClass:"item",attrs:{content:t.row.status,effect:"dark",placement:"top-start"}},[r("el-tag",{attrs:{type:e._f("statusFilter")(t.row.status)}},[e._v(" "+e._s(e._f("statusFilter2")(t.row.status))+" ")])],1)]}}])}),r("el-table-column",{attrs:{"show-overflow-tooltip":"",label:"操作",width:"180px",fixed:"right"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"text"},on:{click:function(r){return e.handleEdit(t.row)}}},[e._v("编辑")]),r("el-button",{attrs:{type:"text"},on:{click:function(r){return e.handleDelete(t.row)}}},[e._v(" 删除 ")])]}}])})],1),r("el-pagination",{attrs:{background:"","current-page":e.queryForm.pageNum,layout:e.layout,"page-size":e.queryForm.pageSize,total:e.total},on:{"current-change":e.handleCurrentChange,"size-change":e.handleSizeChange}}),r("el-dialog",{attrs:{title:e.form.id?"修改":"新增",visible:e.dialogFormVisible,width:"400px"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[r("el-form",{attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[r("el-form-item",{attrs:{label:"产品名称",prop:"productName"}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.productName,callback:function(t){e.$set(e.form,"productName",t)},expression:"form.productName"}})],1),r("el-form-item",{attrs:{label:"错误标题",prop:"title"}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.title,callback:function(t){e.$set(e.form,"title",t)},expression:"form.title"}})],1),r("el-form-item",{attrs:{label:"提交人",prop:"name"}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.name,callback:function(t){e.$set(e.form,"name",t)},expression:"form.name"}})],1),r("el-form-item",{attrs:{label:"修改人",prop:"name2"}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.name2,callback:function(t){e.$set(e.form,"name2",t)},expression:"form.name2"}})],1),r("el-form-item",{attrs:{label:"描述",prop:"describe"}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.describe,callback:function(t){e.$set(e.form,"describe",t)},expression:"form.describe"}})],1),r("el-form-item",{attrs:{label:"备注",prop:"comment"}},[r("el-input",{attrs:{"auto-complete":"off"},model:{value:e.form.comment,callback:function(t){e.$set(e.form,"comment",t)},expression:"form.comment"}})],1),r("el-form-item",{attrs:{label:"错误截图"}},[r("el-upload",{ref:"upload",staticClass:"avatar-uploader",attrs:{action:"","show-file-list":!1,"on-success":e.handleAvatarSuccess,"http-request":e.uploadFiles,"before-upload":e.beforeAvatarUpload,"on-change":e.uploadFiles}},[e.form.jpg?r("img",{staticClass:"avatar",attrs:{src:e.form.jpg}}):r("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1)],1),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[r("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取 消")]),r("el-button",{attrs:{type:"primary"},on:{click:e.handleSave}},[e._v("确 定")])],1)],1)],1)},a=[],n=(r("422c"),r("845c"),r("9151"),r("1f90"),r("066a"),r("84e6"),r("6a61"),r("2e91")),l=r("0f58"),i={name:"LogError",components:{},filters:{statusFilter:function(e){return 1==e?"":"info"},statusFilter2:function(e){return 1==e?"已修改":"未修改"}},data:function(){return{imgShow:!0,imageUrl:"",queryForm:{pageNum:1,pageSize:10,title:""},list:null,listLoading:!0,layout:"total, sizes, prev, pager, next, jumper",total:0,elementLoadingText:"正在加载...",dialogFormVisible:!1,popover5:!1,form:{name:"",name2:"",productName:"",title:"",describe:"",comment:"",jpg:""},imageList:[],rules:{productName:[{required:!0,message:"请输入产品名称",trigger:"blur"}],title:[{required:!0,message:"请输入错误标题",trigger:"blur"}],describe:[{required:!0,message:"请输入问题描述",trigger:"blur"}]}}},created:function(){this.fetchData()},methods:{handleSizeChange:function(e){this.queryForm.pageSize=e,this.fetchData()},handleCurrentChange:function(e){this.queryForm.pageNum=e,this.fetchData()},handleQuery:function(){this.queryForm.pageNum=1,this.fetchData()},handleAdd:function(){this.dialogFormVisible=!0,this.form=this.$options.data().form},handleEdit:function(e){this.form=JSON.parse(JSON.stringify(e)),this.dialogFormVisible=!0},handleDelete:function(e){var t=this;this.$confirm("此操作将永久删除该条记录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.handledel(e)})).catch((function(){t.$message({type:"info",message:"已取消删除"})}))},handledel:function(e){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function r(){var o,a,n;return regeneratorRuntime.wrap((function(r){while(1)switch(r.prev=r.next){case 0:return r.next=2,Object(l["del"])(e);case 2:o=r.sent,a=o.state,n=o.msg,t.$message({type:a,message:n}),t.fetchData();case 7:case"end":return r.stop()}}),r)})))()},handleSave:function(){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function t(){return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:e.form.id?e.toUpdate():e.toSave();case 1:case"end":return t.stop()}}),t)})))()},toSave:function(){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function t(){var r,o,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(l["insert"])(e.form);case 2:r=t.sent,o=r.msg,a=r.state,e.$message({type:a,message:o}),e.form=e.$options.data().form,e.dialogFormVisible=!1,e.fetchData();case 9:case"end":return t.stop()}}),t)})))()},toUpdate:function(){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function t(){var r,o,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(l["update"])(e.form);case 2:r=t.sent,o=r.msg,a=r.state,e.$message({type:a,message:o}),e.form=e.$options.data().form,e.dialogFormVisible=!1,e.fetchData();case 9:case"end":return t.stop()}}),t)})))()},fetchData:function(){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function t(){var r,o,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e.listLoading=!0,t.next=3,Object(l["getList"])(e.queryForm);case 3:r=t.sent,o=r.t,e.list=o.list,e.total=o.total,a=[],o.list.forEach((function(e,t){a.push(e.jpg)})),e.imageList=a,e.listLoading=!1;case 11:case"end":return t.stop()}}),t)})))()},handleAvatarSuccess:function(e,t){this.imageUrl=URL.createObjectURL(t.raw)},beforeAvatarUpload:function(e){var t="image/jpeg"===e.type,r="image/png"===e.type,o=e.size/1024/1024<2;return t||r||this.$message.error("上传图片只能是 JPG 或 png 格式!"),o||this.$message.error("上传图片大小不能超过 2MB!"),t&&o},uploadFiles:function(){var e,t=this,r=this.$refs.upload.$refs["upload-inner"].$refs.input,o=r.files,a=new FileReader;a.readAsDataURL(o[0]),a.onload=function(r){e=r.target.result,t.form.jpg=e}}}},s=i,u=(r("a9e8"),r("c701")),c=Object(u["a"])(s,o,a,!1,null,"361bb4fb",null);t["default"]=c.exports},"8ec7":function(e,t,r){},a9e8:function(e,t,r){"use strict";r("8ec7")}}]);