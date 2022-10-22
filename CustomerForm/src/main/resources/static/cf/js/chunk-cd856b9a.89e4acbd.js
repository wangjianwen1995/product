(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-cd856b9a"],{"116a":function(e,t,l){},7512:function(e,t,l){"use strict";l("116a")},"9eab":function(e,t,l){"use strict";l.d(t,"a",(function(){return s}));var a=l("1da1"),i=(l("96cf"),l("d364")),r=l("365c"),s={data:function(){return{rules:{name:[{required:!0,message:"请输入字段名称",trigger:"blur"},{pattern:/^[a-z]+[A-Za-z\d]*$/,message:"请以小写英文字母开头，中间可输入字母或数字，禁止中文",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}],label:[{required:!0,message:"请输入显示名称",trigger:"blur"},{pattern:/^[A-Za-z\d\u4e00-\u9fa5]+[_-]*/,message:"请以中文、英文字母、数字开头，中间可输入下划线或横杠",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}]}}},mounted:function(){this.fieldState===i["a"].EDIT&&this.loadFieldProps()},methods:{createNewField:function(){},modifyOldField:function(e,t){var l=this;return Object(a["a"])(regeneratorRuntime.mark((function a(){var i,s,o;return regeneratorRuntime.wrap((function(a){while(1)switch(a.prev=a.next){case 0:if(8==t){a.next=7;break}return a.next=3,Object(r["D"])(e);case 3:i=a.sent,s=i.state,o=i.msg,l.$message({message:o,type:s});case 7:l.$emit("fieldSaved",e);case 8:case"end":return a.stop()}}),a)})))()},cancelSave:function(){this.$emit("cancelSave")},loadFieldProps:function(){this.fieldState,i["a"].EDIT}}}},ae42:function(e,t,l){"use strict";l.r(t);var a=function(){var e=this,t=e.$createElement,l=e._self._c||t;return l("el-container",{staticClass:"field-props-container"},[e.showingInDialog?e._e():l("el-header",{staticClass:"field-props-header"},[e._v(" [百分比]字段属性设置 ")]),l("el-main",{staticClass:"field-props-pane"},[l("el-form",{ref:"editorForm",attrs:{model:e.fieldProps,rules:e.rules,"label-position":"left","label-width":"220px",size:"mini"},nativeOn:{submit:function(e){e.preventDefault()}}},[l("el-form-item",{attrs:{label:"字段名称",prop:"name"}},[l("el-input",{attrs:{disabled:1!==e.fieldState},model:{value:e.fieldProps.name,callback:function(t){e.$set(e.fieldProps,"name",t)},expression:"fieldProps.name"}})],1),l("el-form-item",{attrs:{label:"显示名称",prop:"label"}},[l("el-input",{model:{value:e.fieldProps.label,callback:function(t){e.$set(e.fieldProps,"label",t)},expression:"fieldProps.label"}})],1),l("el-form-item",{attrs:{label:"最小值"}},[l("el-input-number",{staticStyle:{width:"100%"},attrs:{type:"number",min:-1e5,max:1e5},model:{value:e.fieldProps.fieldViewModel.minValue,callback:function(t){e.$set(e.fieldProps.fieldViewModel,"minValue",e._n(t))},expression:"fieldProps.fieldViewModel.minValue"}})],1),l("el-form-item",{attrs:{label:"最大值"}},[l("el-input-number",{staticStyle:{width:"100%"},attrs:{type:"number",min:1,max:1e5},model:{value:e.fieldProps.fieldViewModel.maxValue,callback:function(t){e.$set(e.fieldProps.fieldViewModel,"maxValue",e._n(t))},expression:"fieldProps.fieldViewModel.maxValue"}})],1),l("el-form-item",{attrs:{label:"字段校验函数(可多选)",prop:"fieldViewModel.validators"}},[l("el-select",{staticStyle:{width:"100%"},attrs:{multiple:"","allow-create":"",filterable:"","default-first-option":"","popper-append-to-body":!1},model:{value:e.fieldProps.fieldViewModel.validators,callback:function(t){e.$set(e.fieldProps.fieldViewModel,"validators",t)},expression:"fieldProps.fieldViewModel.validators"}},e._l(e.validators,(function(e,t){return l("el-option",{key:t,attrs:{label:e.label,value:e.value}})})),1)],1),l("el-form-item",{attrs:{label:"是否允许空值"}},[l("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.nullable,callback:function(t){e.$set(e.fieldProps,"nullable",t)},expression:"fieldProps.nullable"}},[l("el-radio",{attrs:{label:!0}},[e._v("是")]),l("el-radio",{attrs:{label:!1}},[e._v("否")])],1)],1),l("el-form-item",{attrs:{label:"新建记录时允许修改字段"}},[l("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.creatable,callback:function(t){e.$set(e.fieldProps,"creatable",t)},expression:"fieldProps.creatable"}},[l("el-radio",{attrs:{label:!0}},[e._v("是")]),l("el-radio",{attrs:{label:!1}},[e._v("否")])],1)],1),l("el-form-item",{attrs:{label:"更新记录时允许修改字段"}},[l("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.updatable,callback:function(t){e.$set(e.fieldProps,"updatable",t)},expression:"fieldProps.updatable"}},[l("el-radio",{attrs:{label:!0}},[e._v("是")]),l("el-radio",{attrs:{label:!1}},[e._v("否")])],1)],1),l("hr",{staticStyle:{border:"0","border-top":"1px dotted #cccccc"}}),l("el-form-item",[l("el-button",{staticStyle:{width:"120px"},attrs:{type:"primary",size:"medium"},on:{click:e.saveField}},[e._v(" 保存字段 ")]),e.showingInDialog?l("el-button",{attrs:{size:"medium"},on:{click:e.cancelSave}},[e._v(" 取消 ")]):e._e()],1)],1)],1)],1)},i=[],r=(l("a9e3"),l("d364")),s=l("9eab"),o={name:"PercentWidgetEditor",props:{entity:String,fieldName:String,showingInDialog:Boolean,fieldState:{type:Number,default:r["a"].NEW}},mixins:[s["a"]],data:function(){return{fieldProps:{name:"",label:"",type:"Percent",defaultMemberOfListFlag:!1,nullable:!1,creatable:!0,updatable:!0,fieldViewModel:{minValue:0,maxValue:100,precision:2,validators:[]}},validators:[]}},mounted:function(){},methods:{saveField:function(){var e=!0;this.$refs["editorForm"].validate((function(t){if(!t)return e=!1,!1})),e&&(this.fieldProps.type="Percent",this.fieldState===r["a"].NEW?this.createNewField():this.fieldState===r["a"].EDIT&&this.modifyOldField())},cancelSave:function(){this.$emit("cancelSave")}}},n=o,d=(l("7512"),l("2877")),u=Object(d["a"])(n,a,i,!1,null,"0f2b3a5b",null);t["default"]=u.exports},d364:function(e,t,l){"use strict";var a=1,i=2;t["a"]={NEW:a,EDIT:i}}}]);
//# sourceMappingURL=chunk-cd856b9a.89e4acbd.js.map