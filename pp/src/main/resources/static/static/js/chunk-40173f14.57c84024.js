/*!
 *  build: vue-admin-beautiful 
 *  vue-admin-beautiful author: chuzhixin 1204505056@qq.com 
 *  vue-admin-beautiful QQ Group(QQ群): 972435319、1139183756 
 *  time: 2021-11-18 16:04:55
 */
(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-40173f14"],{5289:function(e,t,n){"use strict";n.r(t),n.d(t,"getUser",(function(){return i})),n.d(t,"getInfos",(function(){return o})),n.d(t,"findProduct",(function(){return u})),n.d(t,"findBySysUserId",(function(){return c})),n.d(t,"findByStaffId",(function(){return d})),n.d(t,"findAllRoles",(function(){return l})),n.d(t,"findByKsId",(function(){return f})),n.d(t,"insertUserList",(function(){return g})),n.d(t,"updatePwd",(function(){return p})),n.d(t,"deleteUser",(function(){return m})),n.d(t,"deleteRole",(function(){return h})),n.d(t,"deleteKs",(function(){return v})),n.d(t,"saveUser",(function(){return y})),n.d(t,"updateFmuser",(function(){return b})),n.d(t,"saveRole",(function(){return w})),n.d(t,"saveKs",(function(){return O})),n.d(t,"isVerify",(function(){return x}));var r=n("b775"),a=n("4360"),s=a["default"].getters["user/ip"].dc,i=function(e){return Object(r["default"])({url:"/sysUser/findAll",method:"get",params:e})},o=function(e){return Object(r["default"])({url:"/fmuser/getInfos",method:"get",params:e})},u=function(e){return Object(r["default"])({url:"/sysUser/findProduct",method:"get",params:e})},c=function(e){return Object(r["default"])({url:"/sysUser/findBySysUserId",method:"get",params:e})},d=function(e){return Object(r["default"])({url:"/sysStaff/findByStaffId",method:"get",params:e})},l=function(e){return Object(r["default"])({url:"/sysRole/findAllRoles",method:"get",params:e})},f=function(e){return Object(r["default"])({url:s+"/sysKs/findByKsId",method:"get",params:e})},g=function(e){return Object(r["default"])({url:"/sysUser/insertUserList",method:"get",params:e})},p=function(e){return Object(r["default"])({url:"/sysUser/updatePwd",method:"get",params:e})},m=function(e){return Object(r["default"])({url:"/sysUser/delete",method:"delete",data:e})},h=function(e){return Object(r["default"])({url:"/sysUserVsRole/delete",method:"delete",data:e})},v=function(e){return Object(r["default"])({url:"/sysUserVsKs/delete",method:"delete",data:e})},y=function(e){return Object(r["default"])({url:"/sysUser/saveBa",method:"post",data:e})},b=function(e){return Object(r["default"])({url:"/fmuser/updateFmuser",method:"get",params:e})},w=function(e){return Object(r["default"])({url:"/sysUserVsRole/save",method:"post",data:e})},O=function(e){return Object(r["default"])({url:"/sysUserVsKs/save",method:"post",data:e})},x=function(e){return Object(r["default"])({url:"/verify/isVerify",method:"get",params:e})}},"7f7f":function(e,t,n){"use strict";n("c197")},"81a5":function(e,t,n){e.exports=n.p+"static/img/logo.7885f0fa.png"},"83ca":function(e,t,n){e.exports=n.p+"static/img/ewm.561e35b3.png"},"9ed6":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"login-container"},[r("div",{staticClass:"main"},[r("div",{staticClass:"title-tips"},[e._v(e._s(e.title))]),r("div",{staticClass:"tel"},[r("div",{staticStyle:{height:"40px"}},[r("img",{staticStyle:{width:"40px",height:"40px",float:"left"},attrs:{src:n("81a5")}}),r("span",{staticStyle:{float:"left","line-height":"40px","font-size":"24px"}},[e._v(" 雕龙科技 ")])]),r("div",[e._v("TEL： 0351 - 2526449")]),r("div",[e._v("推荐IE10以上或者谷歌浏览器")])]),r("img",{staticClass:"ewm",attrs:{src:n("83ca"),alt:""}}),r("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.loginForm,rules:e.loginRules,"auto-complete":"off","label-position":"left"}},[r("div",{staticClass:"title"},[e._v("登录")]),r("el-form-item",{staticStyle:{"margin-top":"40px"},attrs:{prop:"userName"}},[r("span",{staticClass:"svg-container svg-container-admin"},[r("vab-icon",{attrs:{icon:["fas","user"]}})],1),r("el-input",{directives:[{name:"focus",rawName:"v-focus"}],attrs:{"auto-complete":"off",placeholder:"请输入用户名",tabindex:"1",type:"text"},on:{change:e.nameChange},model:{value:e.loginForm.name,callback:function(t){e.$set(e.loginForm,"name","string"===typeof t?t.trim():t)},expression:"loginForm.name"}})],1),r("el-form-item",{attrs:{prop:"password"}},[r("span",{staticClass:"svg-container svg-container-pass"},[r("vab-icon",{attrs:{icon:["fas","lock"]}})],1),r("el-input",{key:e.passwordType,ref:"password",attrs:{type:e.passwordType,"auto-complete":"off",placeholder:"请输入密码",tabindex:"2"},nativeOn:{keyup:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.handleLogin.apply(null,arguments)}},model:{value:e.loginForm.pwd,callback:function(t){e.$set(e.loginForm,"pwd","string"===typeof t?t.trim():t)},expression:"loginForm.pwd"}}),"password"===e.passwordType?r("span",{staticClass:"show-pwd",on:{click:e.showPwd}},[r("vab-icon",{attrs:{icon:["fas","eye-slash"]}})],1):r("span",{staticClass:"show-pwd",on:{click:e.showPwd}},[r("vab-icon",{attrs:{icon:["fas","eye"]}})],1)],1),r("el-form-item",[r("el-checkbox",{model:{value:e.rememberMe,callback:function(t){e.rememberMe=t},expression:"rememberMe"}},[e._v("记住用户名")])],1),r("el-form-item",[r("el-button",{staticClass:"login-btn",attrs:{type:"primary"},on:{click:e.handleLogin}},[e._v(" 登 录 ")]),r("p",{staticStyle:{"padding-top":"10px","text-align":"center","font-size":"16px"}},[r("span",{staticStyle:{color:"#ff0000"}},[e._v(" 当前为:["+e._s(1==e.verify.scopeType?"天数限制版":"永久版")+"] "),1==e.verify.scopeType?r("span",[e._v("还有"+e._s(e.day)+"天过期!")]):e._e()]),r("el-button",{staticStyle:{"font-size":"16px"},attrs:{type:"text"}},[r("router-link",{staticStyle:{display:"inline-block"},attrs:{to:"/register"}},[r("div",[e._v("[点击注册]")])])],1)],1)],1)],1)],1)])},a=[],s=n("dc45"),i=(n("e186"),n("f5bd"),n("61f7")),o=n("ed08"),u=n("5289"),c=(n("73ef"),{name:"Login",directives:{focus:{inserted:function(e){e.querySelector("input").focus()}}},data:function(){var e=function(e,t,n){""==t?n(new Error("用户名不能为空")):n()},t=function(e,t,n){Object(i["isPassword"])(t)?n():n(new Error("密码不能少于6位"))};return{rememberMe:!1,nodeEnv:"production",title:this.$baseTitle,loginForm:{name:"",pwd:""},loginRules:{name:[{required:!0,trigger:"blur",validator:e}],pwd:[{required:!0,trigger:"blur",validator:t}]},loading:!1,passwordType:"password",redirect:void 0,verify:{},day:0}},watch:{$route:{handler:function(e){this.redirect=e.query&&e.query.redirect||"/"},immediate:!0}},mounted:function(){var e=sessionStorage.getItem("userName")&&sessionStorage.getItem("userName").length>0;e&&(this.loginForm.name=sessionStorage.getItem("userName"),this.rememberMe=!0)},created:function(){this.isRegister()},methods:{isRegister:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var n,r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,Object(u["isVerify"])();case 2:n=t.sent,r=n.t,a=n.state,"success"==a?(e.verify=r,e.day=Object(o["getAge"])(r.scope).age):e.$router.push("/register");case 6:case"end":return t.stop()}}),t)})))()},toRegister:function(){this.$router.push("/register")},nameChange:function(){this.loading&&(this.loading=!this.loading)},showPwd:function(){var e=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){e.$refs.password.focus()}))},handleLogin:function(){var e=this;this.$refs.loginForm.validate(function(){var t=Object(s["a"])(regeneratorRuntime.mark((function t(n){var r,a;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!n){t.next=11;break}return e.loading=!0,t.next=4,e.$store.dispatch("user/login",e.loginForm);case 4:return r="/404"===e.redirect||"/401"===e.redirect?"/":e.redirect,t.next=7,e.$router.push(r).catch((function(){}));case 7:e.loading=!1,e.rememberMe?sessionStorage.setItem("userName",e.loginForm.name):(a=sessionStorage.getItem("userName")&&sessionStorage.getItem("userName").length>0,a&&sessionStorage.removeItem("userName")),t.next=12;break;case 11:return t.abrupt("return",!1);case 12:case"end":return t.stop()}}),t)})));return function(e){return t.apply(this,arguments)}}())}}}),d=c,l=(n("7f7f"),n("5d22")),f=Object(l["a"])(d,r,a,!1,null,"06dfb4aa",null);t["default"]=f.exports},c197:function(e,t,n){},ed08:function(e,t,n){"use strict";n.r(t),n.d(t,"getAge",(function(){return a})),n.d(t,"timeFrame",(function(){return s})),n.d(t,"fuzzyQuery",(function(){return i})),n.d(t,"parseTime",(function(){return o})),n.d(t,"formatTime",(function(){return u})),n.d(t,"paramObj",(function(){return c})),n.d(t,"translateDataToTree",(function(){return d})),n.d(t,"translateTreeToData",(function(){return l})),n.d(t,"tenBitTimestamp",(function(){return f})),n.d(t,"thirteenBitTimestamp",(function(){return g})),n.d(t,"uuid",(function(){return p})),n.d(t,"random",(function(){return m})),n.d(t,"on",(function(){return h})),n.d(t,"off",(function(){return v}));var r=n("206e");n("b1fa"),n("c5ce"),n("2769"),n("0756"),n("8639"),n("3f7e"),n("6afd"),n("23db"),n("f5bd");function a(e){var t=new Date(e),n=t.getFullYear(),r=t.getMonth()+1,a=t.getDate(),s={age:0,unit:""};if(t){var i=new Date,o=i.getFullYear(),u=i.getMonth()+1,c=i.getDate(),d=[1,3,5,7,8,10,12],l=u-1>0?u-1:12,f=!1,g=0;(o%4===0&&o%100!==0||o%400===0)&&(f=!0),g=d.indexOf(l)>-1?31:2===l?f?29:28:30;var p=o-parseInt(n),m=u-parseInt(r),h=c-parseInt(a);h<0&&(h+=g,m--),m<0&&(p--,m+=12),p<0?"出生日期有误！":0===p?0===m?(s.age=h,s.unit="D"):(s.age=m,s.unit="M"):(s.age=p,s.unit="Y")}return s}function s(e,t,n){var a,s=t||"{y}-{m}-{d} {h}:{i}:{s}";"object"===Object(r["a"])(n)?a=n:("string"===typeof n&&/^[0-9]+$/.test(n)&&(n=parseInt(n)),"number"===typeof n&&10===n.toString().length&&(n*=1e3),void 0==n?(n="",a=new Date):a=new Date(n));var i=new Date,o=a,u=o.getTime()-864e5*e;i.setTime(u);var c={y:i.getFullYear(),m:i.getMonth()+1,d:i.getDate(),h:i.getHours(),i:i.getMinutes(),s:i.getSeconds(),a:i.getDay()},d={y:o.getFullYear(),m:o.getMonth()+1,d:o.getDate(),h:o.getHours(),i:o.getMinutes(),s:o.getSeconds(),a:o.getDay()},l=s.replace(/{(y|m|d|h|i|s|a)+}/g,(function(e,t){var n=c[t];return"a"===t?["日","一","二","三","四","五","六"][n]:(e.length>0&&n<10&&(n="0"+n),n||0)})),f=s.replace(/{(y|m|d|h|i|s|a)+}/g,(function(e,t){var n=d[t];return"a"===t?["日","一","二","三","四","五","六"][n]:(e.length>0&&n<10&&(n="0"+n),n||0)}));return{stime:l,etime:f}}function i(e,t){for(var n=[],r=0;r<e.length;r++)e[r].name_zh.split(t).length>1&&n.push(e[r]);return n}function o(e,t){if(0===arguments.length)return null;var n,a=t||"{y}-{m}-{d} {h}:{i}:{s}";"object"===Object(r["a"])(e)?n=e:("string"===typeof e&&/^[0-9]+$/.test(e)&&(e=parseInt(e)),"number"===typeof e&&10===e.toString().length&&(e*=1e3),n=new Date(e));var s={y:n.getFullYear(),m:n.getMonth()+1,d:n.getDate(),h:n.getHours(),i:n.getMinutes(),s:n.getSeconds(),a:n.getDay()},i=a.replace(/{(y|m|d|h|i|s|a)+}/g,(function(e,t){var n=s[t];return"a"===t?["日","一","二","三","四","五","六"][n]:(e.length>0&&n<10&&(n="0"+n),n||0)}));return i}function u(e,t){e=10===(""+e).length?1e3*parseInt(e):+e;var n=new Date(e),r=Date.now(),a=(r-n)/1e3;return a<30?"刚刚":a<3600?Math.ceil(a/60)+"分钟前":a<86400?Math.ceil(a/3600)+"小时前":a<172800?"1天前":t?o(e,t):n.getMonth()+1+"月"+n.getDate()+"日"+n.getHours()+"时"+n.getMinutes()+"分"}function c(e){var t=e.split("?")[1];return t?JSON.parse('{"'+decodeURIComponent(t).replace(/"/g,'\\"').replace(/&/g,'","').replace(/=/g,'":"').replace(/\+/g," ")+'"}'):{}}function d(e){var t=e.filter((function(e){return"undefined"===e.parentId||null==e.parentId})),n=e.filter((function(e){return"undefined"!==e.parentId&&null!=e.parentId})),r=function e(t,n){t.forEach((function(t){n.forEach((function(r,a){if(r.parentId===t.id){var s=JSON.parse(JSON.stringify(n));s.splice(a,1),e([r],s),"undefined"!==typeof t.children?t.children.push(r):t.children=[r]}}))}))};return r(t,n),t}function l(e){var t=[];return e.forEach((function(e){var n=function e(n){t.push({id:n.id,name:n.name,parentId:n.parentId});var r=n.children;if(r)for(var a=0;a<r.length;a++)e(r[a])};n(e)})),t}function f(e){var t=new Date(1e3*e),n=t.getFullYear(),r=t.getMonth()+1;r=r<10?""+r:r;var a=t.getDate();a=a<10?""+a:a;var s=t.getHours();s=s<10?"0"+s:s;var i=t.getMinutes(),o=t.getSeconds();return i=i<10?"0"+i:i,o=o<10?"0"+o:o,n+"年"+r+"月"+a+"日 "+s+":"+i+":"+o}function g(e){var t=new Date(e/1),n=t.getFullYear(),r=t.getMonth()+1;r=r<10?""+r:r;var a=t.getDate();a=a<10?""+a:a;var s=t.getHours();s=s<10?"0"+s:s;var i=t.getMinutes(),o=t.getSeconds();return i=i<10?"0"+i:i,o=o<10?"0"+o:o,n+"年"+r+"月"+a+"日 "+s+":"+i+":"+o}function p(){for(var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:32,t="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890",n="",r=0;r<e;r++)n+=t.charAt(Math.floor(Math.random()*t.length));return n}function m(e,t){return Math.floor(Math.random()*(e-t)+t)}var h=function(){return function(e,t,n){var r=arguments.length>3&&void 0!==arguments[3]&&arguments[3];e&&t&&n&&e.addEventListener(t,n,r)}}(),v=function(){return function(e,t,n){var r=arguments.length>3&&void 0!==arguments[3]&&arguments[3];e&&t&&e.removeEventListener(t,n,r)}}()}}]);