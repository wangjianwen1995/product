(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-user-userdetail"],{1061:function(t,s,e){"use strict";var a=e("4ea4");Object.defineProperty(s,"__esModule",{value:!0}),s.default=void 0;var i=a(e("b85c")),n=a(e("5422")),o={data:function(){return{personalMsg:{avatar:"",realname:"",username:"",sex:1,birthday:new Date,orgCode:"",workNo:"",status:1,phone:"",telephone:"",email:"",post:"",departIds:"",identity:""},userUrl:"/sys/user/queryById",positionUrl:"/sys/position/list",departUrl:"/sys/user/userDepartList"}},onLoad:function(){this.loadinfo()},methods:{getSubStringText:function(t,s){return t&&0!=t.length?t.length<s?t:t.substr(0,s)+"...":""},loadinfo:function(){var t=this;this.$http.get(this.userUrl,{params:{id:this.$store.getters.userid}}).then((function(s){if(console.log("用户",s),s.data.success){var e=s.data.result;e.avatar&&e.avatar.length>0&&(t.personalMsg.avatar=n.default.getFileAccessHttpUrl(e.avatar)),t.personalMsg.realname=e.realname,t.personalMsg.username=e.username,t.personalMsg.post=e.post,t.personalMsg.sex=1===e.sex?"男":"女",t.personalMsg.birthday=null==e.birthday?"无":e.birthday,t.personalMsg.departIds=e.departIds,t.personalMsg.workNo=e.workNo,t.personalMsg.phone=e.phone,t.personalMsg.telephone=null==e.telephone?"无":e.telephone,t.personalMsg.email=e.email,t.personalMsg.post=e.post,t.personalMsg.identity=1===e.identity?"普通成员":"上级",t.personalMsg.status=1===e.status?"正常":"冻结",t.personalMsg.orgCode=e.orgCode}})).catch((function(t){console.log("请求错误",t)})),this.$http.get(this.departUrl,{params:{userId:this.$store.getters.userid}}).then((function(s){if(s.success){var e,a=(0,i.default)(s.result);try{for(a.s();!(e=a.n()).done;){var n=e.value;t.personalMsg.orgCode=n.title,t.personalMsg.departIds=n.title}}catch(o){a.e(o)}finally{a.f()}}})).catch((function(t){console.log("请求错误",t)})),this.$http.get(this.positionUrl).then((function(s){if(s.success){var e,a=s.result.records,n=(0,i.default)(a);try{for(n.s();!(e=n.n()).done;){var o=e.value;t.personalMsg.post==o.code&&(t.personalMsg.post=o.name)}}catch(l){n.e(l)}finally{n.f()}}})).catch((function(t){console.log("请求错误",t)}))}}};s.default=o},2420:function(t,s,e){var a=e("24fb");s=a(!1),s.push([t.i,'.page[data-v-33f6c567]{height:100Vh;width:100vw}.page.show[data-v-33f6c567]{overflow:hidden}.switch-sex[data-v-33f6c567]::after{content:"\\e716"}.switch-sex[data-v-33f6c567]::before{content:"\\e7a9"}.switch-music[data-v-33f6c567]::after{content:"\\e66a"}.switch-music[data-v-33f6c567]::before{content:"\\e6db"}',""]),t.exports=s},"7e4c":function(t,s,e){var a=e("2420");"string"===typeof a&&(a=[[t.i,a,""]]),a.locals&&(t.exports=a.locals);var i=e("4f06").default;i("4cbc44a1",a,!0,{sourceMap:!1,shadowMode:!1})},"8e98":function(t,s,e){"use strict";e.r(s);var a=e("d7ae"),i=e("c07b");for(var n in i)"default"!==n&&function(t){e.d(s,t,(function(){return i[t]}))}(n);e("d1fa");var o,l=e("f0c5"),c=Object(l["a"])(i["default"],a["b"],a["c"],!1,null,"33f6c567",null,!1,a["a"],o);s["default"]=c.exports},c07b:function(t,s,e){"use strict";e.r(s);var a=e("1061"),i=e.n(a);for(var n in a)"default"!==n&&function(t){e.d(s,t,(function(){return a[t]}))}(n);s["default"]=i.a},d1fa:function(t,s,e){"use strict";var a=e("7e4c"),i=e.n(a);i.a},d7ae:function(t,s,e){"use strict";var a;e.d(s,"b",(function(){return i})),e.d(s,"c",(function(){return n})),e.d(s,"a",(function(){return a}));var i=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("v-uni-view",[e("v-uni-scroll-view",{staticClass:"page",attrs:{"scroll-y":!0}},[e("cu-custom",{attrs:{bgColor:"bg-gradual-pink",isBack:!0}},[e("template",{attrs:{slot:"backText"},slot:"backText"},[t._v("返回")]),e("template",{attrs:{slot:"content"},slot:"content"},[t._v("修改密码")])],2),e("v-uni-view",{staticClass:"cu-list menu"},[e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.1s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("头像")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-view",{staticClass:"cu-avatar round sm",style:{backgroundImage:"url("+t.personalMsg.avatar+")"}})],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.2s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("姓名")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.realname))])],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.3s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("性别")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.sex))])],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.4s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("生日")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.birthday))])],1)],1)],1),e("v-uni-view",{staticClass:"cu-list menu"},[e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.5s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("对外信息展示")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.getSubStringText(t.personalMsg.realname+"@"+t.personalMsg.orgCode,11)))])],1)],1)],1),e("v-uni-view",{staticClass:"cu-list menu"},[e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.6s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("所在部门")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.orgCode))])],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.7s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("工号")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.workNo))])],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.8s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("状态")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.status))])],1)],1)],1),e("v-uni-view",{staticClass:"cu-list menu"},[e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"0.9s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("手机")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.phone))])],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"1s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("邮箱")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.email))])],1)],1)],1),e("v-uni-view",{staticClass:"cu-list menu"},[e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"1.1s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("职务")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.post))])],1)],1),e("v-uni-view",{staticClass:"cu-item animation-slide-bottom",style:[{animationDelay:"1.2s"}]},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("身份")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.identity))])],1)],1),"上级"==t.personalMsg.identity?e("v-uni-view",{staticClass:"cu-item animation-slide-bottom"},[e("v-uni-view",{staticClass:"content"},[e("v-uni-text",{staticClass:"text-grey"},[t._v("负责部门")])],1),e("v-uni-view",{staticClass:"action"},[e("v-uni-text",{staticClass:"text-grey"},[t._v(t._s(t.personalMsg.departIds))])],1)],1):t._e()],1)],1)],1)},n=[]}}]);