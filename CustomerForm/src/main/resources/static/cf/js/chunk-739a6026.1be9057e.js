(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-739a6026"],{7889:function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticClass:"field-props-container"},[e.showingInDialog?e._e():a("el-header",{staticClass:"field-props-header"},[e._v(" [日期/时间]字段属性设置 ")]),a("el-main",{staticClass:"field-props-pane"},[a("el-form",{ref:"editorForm",attrs:{model:e.fieldProps,rules:e.rules,"label-position":"left","label-width":"220px",size:"mini"},nativeOn:{submit:function(e){e.preventDefault()}}},[a("el-form-item",{attrs:{label:"字段名称",prop:"name"}},[a("el-input",{attrs:{disabled:1!==e.fieldState},model:{value:e.fieldProps.name,callback:function(t){e.$set(e.fieldProps,"name",t)},expression:"fieldProps.name"}})],1),a("el-form-item",{attrs:{label:"显示名称",prop:"label"}},[a("el-input",{model:{value:e.fieldProps.label,callback:function(t){e.$set(e.fieldProps,"label",t)},expression:"fieldProps.label"}})],1),a("el-form-item",{attrs:{label:"是否允许空值"}},[a("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_null,callback:function(t){e.$set(e.fieldProps,"is_null",t)},expression:"fieldProps.is_null"}},[a("el-radio",{attrs:{label:1}},[e._v("是")]),a("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),a("el-form-item",{attrs:{label:"允许修改字段"}},[a("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_edit,callback:function(t){e.$set(e.fieldProps,"is_edit",t)},expression:"fieldProps.is_edit"}},[a("el-radio",{attrs:{label:1}},[e._v("是")]),a("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),a("hr",{staticStyle:{border:"0","border-top":"1px dotted #cccccc"}}),a("el-form-item",[a("el-button",{staticStyle:{width:"120px"},attrs:{type:"primary",size:"medium"},on:{click:e.saveField}},[e._v(" 保存字段 ")]),e.showingInDialog?a("el-button",{attrs:{size:"medium"},on:{click:e.cancelSave}},[e._v(" 取消 ")]):e._e()],1)],1)],1)],1)},r=[],l=a("1da1"),n=(a("96cf"),a("a9e3"),a("b0c0"),a("d364")),s=a("9eab"),o=(a("365c"),{name:"DateWidgetEditor",mixins:[s["a"]],props:{entity:Object,fieldName:String,showingInDialog:Boolean,fieldState:{type:Number,default:n["a"].NEW}},data:function(){return{fieldProps:{data_code:"",default_show:0,facttable_id:"",field_length:8,field_sql:"",file_path:"",file_size:0,image_path:"",is_edit:1,is_mainfield:0,is_null:1,is_system:0,label:"",name:"",num_length:0,order_number:0,table_name:"",type:11,verifiable:""},validators:[]}},mounted:function(){},methods:{saveField:function(){var e=this;return Object(l["a"])(regeneratorRuntime.mark((function t(){var a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(a=!0,e.fieldProps.table_name=e.entity.name,e.fieldProps.facttable_id=e.entity.id,e.$refs["editorForm"].validate((function(e){if(!e)return a=!1,!1})),a){t.next=6;break}return t.abrupt("return");case 6:e.modifyOldField(e.fieldProps,e.fieldState);case 7:case"end":return t.stop()}}),t)})))()},cancelSave:function(){this.$emit("cancelSave")}}}),d=o,c=(a("abcd"),a("2877")),u=Object(c["a"])(d,i,r,!1,null,"31d1d35e",null);t["default"]=u.exports},9846:function(e,t,a){},"9eab":function(e,t,a){"use strict";a.d(t,"a",(function(){return n}));var i=a("1da1"),r=(a("96cf"),a("d364")),l=a("365c"),n={data:function(){return{rules:{name:[{required:!0,message:"请输入字段名称",trigger:"blur"},{pattern:/^[a-z]+[A-Za-z\d]*$/,message:"请以小写英文字母开头，中间可输入字母或数字，禁止中文",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}],label:[{required:!0,message:"请输入显示名称",trigger:"blur"},{pattern:/^[A-Za-z\d\u4e00-\u9fa5]+[_-]*/,message:"请以中文、英文字母、数字开头，中间可输入下划线或横杠",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}]}}},mounted:function(){this.fieldState===r["a"].EDIT&&this.loadFieldProps()},methods:{createNewField:function(){},modifyOldField:function(e,t){var a=this;return Object(i["a"])(regeneratorRuntime.mark((function i(){var r,n,s;return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:if(8==t){i.next=7;break}return i.next=3,Object(l["D"])(e);case 3:r=i.sent,n=r.state,s=r.msg,a.$message({message:s,type:n});case 7:a.$emit("fieldSaved",e);case 8:case"end":return i.stop()}}),i)})))()},cancelSave:function(){this.$emit("cancelSave")},loadFieldProps:function(){this.fieldState,r["a"].EDIT}}}},abcd:function(e,t,a){"use strict";a("9846")},d364:function(e,t,a){"use strict";var i=1,r=2;t["a"]={NEW:i,EDIT:r}}}]);
//# sourceMappingURL=chunk-739a6026.1be9057e.js.map