(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1295500c"],{3615:function(e,t,a){},"90da":function(e,t,a){"use strict";a.r(t);var i=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-container",{staticClass:"field-props-container"},[e.showingInDialog?e._e():a("el-header",{staticClass:"field-props-header"},[e._v(" [日期/时间]字段属性设置 ")]),a("el-main",{staticClass:"field-props-pane"},[a("el-form",{ref:"editorForm",attrs:{model:e.fieldProps,rules:e.rules,"label-position":"left","label-width":"220px",size:"mini"},nativeOn:{submit:function(e){e.preventDefault()}}},[a("el-form-item",{attrs:{label:"字段名称",prop:"name"}},[a("el-input",{attrs:{disabled:1!==e.fieldState},model:{value:e.fieldProps.name,callback:function(t){e.$set(e.fieldProps,"name",t)},expression:"fieldProps.name"}})],1),a("el-form-item",{attrs:{label:"显示名称",prop:"label"}},[a("el-input",{model:{value:e.fieldProps.label,callback:function(t){e.$set(e.fieldProps,"label",t)},expression:"fieldProps.label"}})],1),a("el-form-item",{attrs:{label:"字段校验函数(可多选)",prop:"fieldViewModel.validators"}},[a("el-select",{staticStyle:{width:"100%"},attrs:{multiple:"","allow-create":"",filterable:"","default-first-option":"","popper-append-to-body":!1},model:{value:e.verifiable,callback:function(t){e.verifiable=t},expression:"verifiable"}},e._l(e.validators,(function(e,t){return a("el-option",{key:t,attrs:{label:e.label,value:e.value}})})),1)],1),a("el-form-item",{attrs:{label:"是否主键"}},[a("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_mainfield,callback:function(t){e.$set(e.fieldProps,"is_mainfield",t)},expression:"fieldProps.is_mainfield"}},[a("el-radio",{attrs:{label:1}},[e._v("是")]),a("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),a("el-form-item",{attrs:{label:"是否允许空值"}},[a("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_null,callback:function(t){e.$set(e.fieldProps,"is_null",t)},expression:"fieldProps.is_null"}},[a("el-radio",{attrs:{label:1}},[e._v("是")]),a("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),a("el-form-item",{attrs:{label:"允许修改字段"}},[a("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_edit,callback:function(t){e.$set(e.fieldProps,"is_edit",t)},expression:"fieldProps.is_edit"}},[a("el-radio",{attrs:{label:1}},[e._v("是")]),a("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),a("hr",{staticStyle:{border:"0","border-top":"1px dotted #cccccc"}}),a("el-form-item",[a("el-button",{staticStyle:{width:"120px"},attrs:{type:"primary",size:"medium"},on:{click:e.saveField}},[e._v(" 保存字段 ")]),e.showingInDialog?a("el-button",{attrs:{size:"medium"},on:{click:e.cancelSave}},[e._v(" 取消 ")]):e._e()],1)],1)],1)],1)},l=[],r=a("1da1"),s=(a("96cf"),a("a9e3"),a("b0c0"),a("a15b"),a("d364")),n=a("9eab"),o=a("365c"),d={name:"DateWidgetEditor",mixins:[n["a"]],props:{entity:Object,fieldName:String,showingInDialog:Boolean,fieldState:{type:Number,default:s["a"].NEW}},data:function(){return{fieldProps:{data_code:"",default_show:0,facttable_id:"",field_length:19,field_sql:"",file_path:"",file_size:0,image_path:"",is_edit:0,is_mainfield:0,is_null:0,is_system:0,label:"",name:"",num_length:0,order_number:0,table_name:"",type:8,verifiable:""},validators:[]}},mounted:function(){},methods:{saveField:function(){var e=this;return Object(r["a"])(regeneratorRuntime.mark((function t(){var a,i,l,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(a=!0,e.fieldProps.table_name=e.entity.name,e.fieldProps.facttable_id=e.entity.id,e.fieldProps.verifiable=e.verifiable.join(","),e.$refs["editorForm"].validate((function(e){if(!e)return a=!1,!1})),a){t.next=7;break}return t.abrupt("return");case 7:return t.next=9,Object(o["z"])(e.fieldProps);case 9:i=t.sent,l=i.state,r=i.msg,e.$message({message:r,type:l}),e.$emit("fieldSaved");case 14:case"end":return t.stop()}}),t)})))()},cancelSave:function(){this.$emit("cancelSave")}}},c=d,f=(a("c454"),a("2877")),u=Object(f["a"])(c,i,l,!1,null,"183299d5",null);t["default"]=u.exports},"9eab":function(e,t,a){"use strict";a.d(t,"a",(function(){return s}));var i=a("1da1"),l=(a("96cf"),a("d364")),r=a("365c"),s={data:function(){return{rules:{name:[{required:!0,message:"请输入字段名称",trigger:"blur"},{pattern:/^[a-z]+[A-Za-z\d]*$/,message:"请以小写英文字母开头，中间可输入字母或数字，禁止中文",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}],label:[{required:!0,message:"请输入显示名称",trigger:"blur"},{pattern:/^[A-Za-z\d\u4e00-\u9fa5]+[_-]*/,message:"请以中文、英文字母、数字开头，中间可输入下划线或横杠",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}]}}},mounted:function(){this.fieldState===l["a"].EDIT&&this.loadFieldProps()},methods:{createNewField:function(){},modifyOldField:function(e){var t=this;return Object(i["a"])(regeneratorRuntime.mark((function a(){var i,l,s;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:return console.log(e),a.next=3,Object(r["z"])(e);case 3:i=a.sent,l=i.state,s=i.msg,t.$message({message:s,type:l}),t.$emit("fieldSaved");case 8:case"end":return a.stop()}}),a)})))()},cancelSave:function(){this.$emit("cancelSave")},loadFieldProps:function(){this.fieldState,l["a"].EDIT}}}},c454:function(e,t,a){"use strict";a("3615")},d364:function(e,t,a){"use strict";var i=1,l=2;t["a"]={NEW:i,EDIT:l}}}]);
//# sourceMappingURL=chunk-1295500c.0b9a6f51.js.map