/*!
 *  build: admin-pro 
 *  copyright: sxdl 
 *  time: 2022-7-20 10:25:38
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1fd715a4"],{"185e":function(t,e,i){"use strict";i("2832")},2832:function(t,e,i){},"73d2":function(t,e,i){"use strict";i.r(e),i.d(e,"getCipher",(function(){return a}));var r=i("b775");function a(t){return Object(r["default"])({url:"/verify/getCipher",method:"get",params:t})}},"81a5":function(t,e,i){t.exports=i.p+"static/img/logo.7885f0fa.png"},"83ca":function(t,e,i){t.exports=i.p+"static/img/ewm.561e35b3.png"},d5c2:function(t,e,i){"use strict";i.r(e);var r=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"login-container"},[r("div",{staticClass:"main"},[r("div",{staticClass:"title-tips"},[t._v(t._s(t.title))]),r("div",{staticClass:"tel"},[r("div",{staticStyle:{height:"40px"}},[r("img",{staticStyle:{float:"left",width:"40px",height:"40px"},attrs:{src:i("81a5")}}),r("span",{staticStyle:{float:"left","font-size":"24px","line-height":"40px"}})]),r("div",[t._v("TEL： 0351 - 2526449")]),r("div",[t._v("推荐IE10以上或者谷歌浏览器")])]),r("img",{staticClass:"ewm",attrs:{src:i("83ca"),alt:""}}),r("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:t.form,"auto-complete":"off","label-position":"left"}},[r("div",{staticClass:"title"},[t._v("注册")]),r("el-form-item",{attrs:{prop:"key",label:"授权KEY"}},[r("el-input",{directives:[{name:"focus",rawName:"v-focus"}],attrs:{type:"textarea",readonly:"",rows:5},model:{value:t.form.key,callback:function(e){t.$set(t.form,"key","string"===typeof e?e.trim():e)},expression:"form.key"}},[r("vab-icon",{attrs:{slot:"prefix",icon:"key-fill"},slot:"prefix"})],1)],1),r("el-form-item",{attrs:{label:"系统授权注册文件"}},[r("el-upload",{ref:"upload",staticClass:"upload-demo",attrs:{accept:".lisp","file-list":t.fileList,"on-change":t.handleChange,action:t.uploadUrl,"show-file-list":!0,"on-success":t.onSuccess,"on-error":t.onError,"auto-upload":!1}},[r("el-button",{attrs:{slot:"trigger",type:"primary"},slot:"trigger"},[t._v("选取文件")])],1),r("div",{staticClass:"el-upload__tip",staticStyle:{"margin-top":"0px",color:"red"}},[t._v(" 授权注册文件名为：longlicenses.lisp ")])],1),r("el-form-item",[r("el-button",{staticClass:"login-btn",attrs:{type:"primary"},on:{click:t.submit}},[t._v(" 注 册 ")])],1)],1)],1)])},a=[],s=i("febe"),n=(i("e186"),i("10dd"),i("73d2")),o=i("f121"),l={name:"Login",data:function(){return{title:this.$baseTitle,form:{key:""},fileList:[],uploadUrl:""}},watch:{$route:{handler:function(t){this.redirect=t.query&&t.query.redirect||"/"},immediate:!0}},mounted:function(){var t=localStorage.getItem("userName")&&localStorage.getItem("userName").length>0;t&&(this.loginForm.name=localStorage.getItem("userName"),this.rememberMe=!0)},created:function(){this.getKey()},methods:{getKey:function(){var t=this;return Object(s["a"])(regeneratorRuntime.mark((function e(){var i,r;return regeneratorRuntime.wrap((function(e){while(1)switch(e.prev=e.next){case 0:return e.next=2,Object(n["getCipher"])();case 2:i=e.sent,r=i.msg,t.form.key=r;case 5:case"end":return e.stop()}}),e)})))()},onSuccess:function(t){var e=this;this.$alert(t.msg,"提示",{confirmButtonText:"确定",callback:function(){e.fileList=[],"error"!=t.state&&e.$router.push("/login")}})},onError:function(t){var e=this;this.$alert(t.msg,"提示",{confirmButtonText:"确定",callback:function(){e.fileList=[]}})},handleChange:function(t,e){e.length>0&&(this.fileList=[e[e.length-1]])},submit:function(){var t=this;this.uploadUrl="".concat(o["baseURL"],"/verify/upload"),this.$nextTick((function(){t.$refs.upload.submit()}))}}},c=l,u=(i("185e"),i("cba8")),f=Object(u["a"])(c,r,a,!1,null,"c01e8800",null);e["default"]=f.exports}}]);