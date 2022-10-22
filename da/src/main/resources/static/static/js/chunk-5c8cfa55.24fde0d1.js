/*!
 *  build:  
 *  time: 2021-7-22 17:56:01
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5c8cfa55"],{8352:function(e,t,r){},"9ed6":function(e,t,r){"use strict";r.r(t);var o=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"login-container"},[r("el-row",[r("el-col",{staticStyle:{float:"right"},attrs:{xs:24,sm:24,md:12,lg:8,xl:8}},[r("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.loginForm,rules:e.loginRules,"auto-complete":"off","label-position":"left"}},[r("div",{staticClass:"title"},[e._v("山西雕龙")]),r("div",{staticClass:"title-tips"},[e._v(e._s(e.title))]),r("el-form-item",{staticStyle:{"margin-top":"40px"},attrs:{prop:"userName"}},[r("span",{staticClass:"svg-container svg-container-admin"},[r("vab-icon",{attrs:{icon:["fas","user"]}})],1),r("el-input",{directives:[{name:"focus",rawName:"v-focus"}],attrs:{"auto-complete":"off",placeholder:"请输入用户名",tabindex:"1",type:"text"},on:{change:e.nameChange},model:{value:e.loginForm.name,callback:function(t){e.$set(e.loginForm,"name","string"===typeof t?t.trim():t)},expression:"loginForm.name"}})],1),r("el-form-item",{attrs:{prop:"password"}},[r("span",{staticClass:"svg-container svg-container-pass"},[r("vab-icon",{attrs:{icon:["fas","lock"]}})],1),r("el-input",{key:e.passwordType,ref:"password",attrs:{type:e.passwordType,"auto-complete":"off",placeholder:"请输入密码",tabindex:"2"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleLogin(t)}},model:{value:e.loginForm.pwd,callback:function(t){e.$set(e.loginForm,"pwd","string"===typeof t?t.trim():t)},expression:"loginForm.pwd"}}),"password"===e.passwordType?r("span",{staticClass:"show-pwd",on:{click:e.showPwd}},[r("vab-icon",{attrs:{icon:["fas","eye-slash"]}})],1):r("span",{staticClass:"show-pwd",on:{click:e.showPwd}},[r("vab-icon",{attrs:{icon:["fas","eye"]}})],1)],1),r("el-form-item",[r("el-checkbox",{model:{value:e.rememberMe,callback:function(t){e.rememberMe=t},expression:"rememberMe"}},[e._v("记住用户名")])],1),r("el-button",{staticClass:"login-btn",attrs:{type:"primary"},on:{click:e.handleLogin}},[e._v(" 登录 ")])],1)],1)],1)],1)},n=[],a=(r("5c4c"),r("6a61"),r("2e91")),s=r("61f7"),i=(r("8587"),{name:"Login",directives:{focus:{inserted:function(e){e.querySelector("input").focus()}}},data:function(){var e=function(e,t,r){""==t?r(new Error("用户名不能为空")):r()},t=function(e,t,r){Object(s["isPassword"])(t)?r():r(new Error("密码不能少于6位"))};return{rememberMe:!1,nodeEnv:"production",title:this.$baseTitle,loginForm:{name:"",pwd:""},loginRules:{name:[{required:!0,trigger:"blur",validator:e}],pwd:[{required:!0,trigger:"blur",validator:t}]},loading:!1,passwordType:"password",redirect:void 0}},watch:{$route:{handler:function(e){this.redirect=e.query&&e.query.redirect||"/"},immediate:!0}},mounted:function(){var e=localStorage.getItem("userName")&&localStorage.getItem("userName").length>0;e&&(this.loginForm.name=localStorage.getItem("userName"),this.rememberMe=!0)},methods:{nameChange:function(){this.loading&&(this.loading=!this.loading)},showPwd:function(){var e=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){e.$refs.password.focus()}))},handleLogin:function(){var e=this;this.$refs.loginForm.validate(function(){var t=Object(a["a"])(regeneratorRuntime.mark((function t(r){var o,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!r){t.next=11;break}return e.loading=!0,t.next=4,e.$store.dispatch("user/login",e.loginForm);case 4:return o="/404"===e.redirect||"/401"===e.redirect?"/":e.redirect,t.next=7,e.$router.push(o).catch((function(){}));case 7:e.loading=!1,e.rememberMe?localStorage.setItem("userName",e.loginForm.name):(n=localStorage.getItem("userName")&&localStorage.getItem("userName").length>0,n&&localStorage.removeItem("userName")),t.next=12;break;case 11:return t.abrupt("return",!1);case 12:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())}}}),l=i,c=(r("e6cd"),r("c701")),u=Object(c["a"])(l,o,n,!1,null,"55b8f18d",null);t["default"]=u.exports},e6cd:function(e,t,r){"use strict";r("8352")}}]);