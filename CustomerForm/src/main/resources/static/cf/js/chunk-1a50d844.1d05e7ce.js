(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1a50d844"],{"29e7":function(e,t,i){"use strict";i("b573")},"53ad":function(e,t,i){"use strict";i.r(t);var a=function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("el-container",{staticClass:"field-props-container"},[e.showingInDialog?e._e():i("el-header",{staticClass:"field-props-header"},[e._v(" [单选项]字段属性设置 ")]),i("el-main",{staticClass:"field-props-pane"},[i("el-form",{ref:"editorForm",attrs:{model:e.fieldProps,rules:e.rules,"label-position":"left","label-width":"220px",size:"mini"},nativeOn:{submit:function(e){e.preventDefault()}}},[i("el-form-item",{attrs:{label:"字段名称",prop:"name"}},[i("el-input",{attrs:{disabled:1!==e.fieldState},model:{value:e.fieldProps.name,callback:function(t){e.$set(e.fieldProps,"name",t)},expression:"fieldProps.name"}})],1),i("el-form-item",{attrs:{label:"显示名称",prop:"label"}},[i("el-input",{model:{value:e.fieldProps.label,callback:function(t){e.$set(e.fieldProps,"label",t)},expression:"fieldProps.label"}})],1),i("el-form-item",{attrs:{label:"字段长度（不超过6位）"}},[i("el-input-number",{staticStyle:{width:"100%"},attrs:{min:1},model:{value:e.fieldProps.field_length,callback:function(t){e.$set(e.fieldProps,"field_length",t)},expression:"fieldProps.field_length"}})],1),i("el-form-item",{attrs:{label:"下拉选项"}},[i("el-radio-group",{on:{change:function(t){1==e.fieldProps.dictortsql?e.fieldProps.field_sql="":e.fieldProps.data_code=""}},model:{value:e.fieldProps.dictortsql,callback:function(t){e.$set(e.fieldProps,"dictortsql",t)},expression:"fieldProps.dictortsql"}},[i("el-radio",{attrs:{label:1}},[e._v("字典")]),i("el-radio",{attrs:{label:2}},[e._v("自定义SQL")])],1)],1),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:1==e.fieldProps.dictortsql,expression:"fieldProps.dictortsql == 1"}],attrs:{label:"字典"}},[i("el-select",{staticStyle:{width:"100%"},attrs:{filterable:"",remote:"","reserve-keyword":"",placeholder:"请输入关键词","remote-method":e.getDtList,loading:e.loading},model:{value:e.fieldProps.data_code,callback:function(t){e.$set(e.fieldProps,"data_code",t)},expression:"fieldProps.data_code"}},e._l(e.dtList,(function(e){return i("el-option",{key:e.id,attrs:{label:e.name_zh,value:e.id}})})),1)],1),i("el-form-item",{directives:[{name:"show",rawName:"v-show",value:2==e.fieldProps.dictortsql,expression:"fieldProps.dictortsql == 2"}],attrs:{label:"自定义SQL"}},[i("el-input",{staticStyle:{width:"100%"},attrs:{placeholder:"请输入SQL",type:"textarea"},model:{value:e.fieldProps.field_sql,callback:function(t){e.$set(e.fieldProps,"field_sql",t)},expression:"fieldProps.field_sql"}})],1),i("el-form-item",{attrs:{label:"字段校验函数(可多选)"}},[i("el-select",{staticStyle:{width:"100%"},attrs:{multiple:"","allow-create":"",filterable:"","default-first-option":"","popper-append-to-body":!1},model:{value:e.validators,callback:function(t){e.validators=t},expression:"validators"}},e._l(e.validators,(function(e,t){return i("el-option",{key:t,attrs:{label:e.label,value:e.value}})})),1)],1),i("el-form-item",{attrs:{label:"是否主键"}},[i("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_mainfield,callback:function(t){e.$set(e.fieldProps,"is_mainfield",t)},expression:"fieldProps.is_mainfield"}},[i("el-radio",{attrs:{label:1}},[e._v("是")]),i("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),i("el-form-item",{attrs:{label:"是否允许空值"}},[i("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_null,callback:function(t){e.$set(e.fieldProps,"is_null",t)},expression:"fieldProps.is_null"}},[i("el-radio",{attrs:{label:1}},[e._v("是")]),i("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),i("el-form-item",{attrs:{label:"允许修改字段"}},[i("el-radio-group",{staticStyle:{float:"right"},model:{value:e.fieldProps.is_edit,callback:function(t){e.$set(e.fieldProps,"is_edit",t)},expression:"fieldProps.is_edit"}},[i("el-radio",{attrs:{label:1}},[e._v("是")]),i("el-radio",{attrs:{label:0}},[e._v("否")])],1)],1),i("hr",{staticStyle:{border:"0","border-top":"1px dotted #cccccc"}}),i("el-form-item",[i("el-button",{staticStyle:{width:"120px"},attrs:{type:"primary",size:"medium"},on:{click:e.saveField}},[e._v(" 保存字段 ")]),e.showingInDialog?i("el-button",{attrs:{size:"medium"},on:{click:e.cancelSave}},[e._v(" 取消 ")]):e._e()],1)],1)],1)],1)},l=[],n=i("1da1"),o=(i("96cf"),i("a9e3"),i("498a"),i("b0c0"),i("a15b"),i("d3b7"),i("159b"),i("a434"),i("b705")),s=i("ca00"),r=i("d364"),d=i("365c"),c=i("9eab"),u={name:"OptionWidgetEditor",props:{entity:Object,fieldName:String,showingInDialog:Boolean,fieldState:{type:Number,default:r["a"].NEW}},data:function(){return{loading:!1,dtList:[],fieldProps:{data_code:"",default_show:0,facttable_id:"",field_length:255,field_sql:"",file_path:"",file_size:0,image_path:"",is_edit:0,is_mainfield:0,is_null:0,is_system:0,label:"",name:"",num_length:0,order_number:0,table_name:"",type:5,verifiable:"",dictortsql:1},optionItems:[],hoverIdx:-1,validators:[],rules:{name:{required:!0,message:"请输入字段名",trigger:"blur"},label:{required:!0,message:"请输入字段显示名称",trigger:"blur"}}}},mixins:[c["a"]],mounted:function(){this.fieldState===r["a"].EDIT&&this.getFieldProps()},methods:{getDtList:function(e){var t=this;return Object(n["a"])(regeneratorRuntime.mark((function i(){var a,l;return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:return t.loading=!0,i.next=3,Object(d["i"])({name:e.trim()});case 3:a=i.sent,l=a.t,t.dtList=l,t.loading=!1;case 7:case"end":return i.stop()}}),i)})))()},getFieldProps:function(){},readFieldProps:function(e){Object(s["c"])(this.fieldProps,e),e.entityCode&&(this.fieldProps.entityCode=e.entityCode)},saveField:function(){var e=this;return Object(n["a"])(regeneratorRuntime.mark((function t(){var i;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(i=!0,e.fieldProps.table_name=e.entity.name,e.fieldProps.facttable_id=e.entity.id,e.fieldProps.verifiable=e.validators.join(","),e.$refs["editorForm"].validate((function(e){if(!e)return i=!1,!1})),i){t.next=7;break}return t.abrupt("return");case 7:e.modifyOldField(e.fieldProps);case 8:case"end":return t.stop()}}),t)})))()},cancelSave:function(){this.$emit("cancelSave")},validateOption:function(e,t){var i=!0;return this.optionItems.forEach((function(a,l){a.label===e&&l!==t&&(i=!1)})),i},getOptionMaxValue:function(){var e=0;return this.optionItems.forEach((function(t){t.value>e&&(e=t.value)})),e},addOption:function(){var e=this;this.$prompt("请输入选项名称","提示",{confirmButtonText:"确定",cancelButtonText:"取消",inputPattern:/^[A-Za-z\u4e00-\u9fa5\d]+$/,inputErrorMessage:"输入不正确"}).then((function(t){var i=t.value;if(e.validateOption(i,-1)){var a=e.getOptionMaxValue()+1,l={label:i,value:a,saved:!1};e.optionItems.push(l),e.$nextTick((function(){console.log("Updated!")}))}else e.$message.warning("选项已存在")})).catch((function(){o["Message"].info("已取消")}))},insertOption:function(e){var t=this;this.$prompt("请输入选项名称","提示",{confirmButtonText:"确定",cancelButtonText:"取消",inputPattern:/^[A-Za-z\u4e00-\u9fa5\d]+$/,inputErrorMessage:"输入不正确"}).then((function(i){var a=i.value;if(t.validateOption(a,-1)){var l=t.getOptionMaxValue()+1,n={label:a,value:l,saved:!1};t.optionItems.splice(e+1,0,n),t.$nextTick((function(){console.log("Updated!")}))}else t.$message.warning("选项已存在")})).catch((function(){o["Message"].info("已取消")}))},upOption:function(e){if(0!==e){var t=this.optionItems[e];this.$set(this.optionItems,e,this.optionItems[e-1]),this.$set(this.optionItems,e-1,t)}else this.$message.info("已到最上")},downOption:function(e){if(console.log("length: "+this.optionItems.length+", current idx: "+e),e!==this.optionItems.length-1){var t=this.optionItems[e];this.$set(this.optionItems,e,this.optionItems[e+1]),this.$set(this.optionItems,e+1,t)}else this.$message.info("已到最下")},editOption:function(e){var t=this,i=this.optionItems[e].label;this.$prompt("请修改选项名称","提示",{confirmButtonText:"确定",cancelButtonText:"取消",inputValue:i,inputPattern:/^[A-Za-z\u4e00-\u9fa5\d]+$/,inputErrorMessage:"输入不正确"}).then((function(i){var a=i.value;t.validateOption(a,e)?(t.optionItems[e].label=a,t.$nextTick((function(){console.log("Updated!")}))):t.$message.warning("选项已存在")})).catch((function(){o["Message"].info("已取消")}))},deleteOption:function(e){var t=this;console.log(e),this.$confirm("确定删除该选项?","提示").then((function(){t.optionItems.splice(e,1),t.$message.info("选项已删除")})).catch((function(){t.$message.info("取消删除")}))}}},f=u,p=(i("29e7"),i("2877")),m=Object(p["a"])(f,a,l,!1,null,"4486e35f",null);t["default"]=m.exports},"9eab":function(e,t,i){"use strict";i.d(t,"a",(function(){return o}));var a=i("1da1"),l=(i("96cf"),i("d364")),n=i("365c"),o={data:function(){return{rules:{name:[{required:!0,message:"请输入字段名称",trigger:"blur"},{pattern:/^[a-z]+[A-Za-z\d]*$/,message:"请以小写英文字母开头，中间可输入字母或数字，禁止中文",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}],label:[{required:!0,message:"请输入显示名称",trigger:"blur"},{pattern:/^[A-Za-z\d\u4e00-\u9fa5]+[_-]*/,message:"请以中文、英文字母、数字开头，中间可输入下划线或横杠",trigger:"blur"},{min:2,max:30,message:"请输入至少两个字符",trigger:"blur"}]}}},mounted:function(){this.fieldState===l["a"].EDIT&&this.loadFieldProps()},methods:{createNewField:function(){},modifyOldField:function(e){var t=this;return Object(a["a"])(regeneratorRuntime.mark((function i(){var a,l,o;return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:return console.log(e),i.next=3,Object(n["z"])(e);case 3:a=i.sent,l=a.state,o=a.msg,t.$message({message:o,type:l}),t.$emit("fieldSaved");case 8:case"end":return i.stop()}}),i)})))()},cancelSave:function(){this.$emit("cancelSave")},loadFieldProps:function(){this.fieldState,l["a"].EDIT}}}},b573:function(e,t,i){},d364:function(e,t,i){"use strict";var a=1,l=2;t["a"]={NEW:a,EDIT:l}}}]);
//# sourceMappingURL=chunk-1a50d844.1d05e7ce.js.map