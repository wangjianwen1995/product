(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-component-modal"],{"31d1":function(t,a,i){var n=i("3634");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var e=i("4f06").default;e("19860cb5",n,!0,{sourceMap:!1,shadowMode:!1})},3634:function(t,a,i){var n=i("24fb");a=n(!1),a.push([t.i,"uni-button .cu-tag[data-v-052c565a]{position:absolute;top:%?8?%;right:%?8?%}",""]),t.exports=a},"5c24":function(t,a,i){"use strict";var n=i("31d1"),e=i.n(n);e.a},6072:function(t,a,i){"use strict";i.r(a);var n=i("bfe0"),e=i("d496");for(var s in e)"default"!==s&&function(t){i.d(a,t,(function(){return e[t]}))}(s);i("5c24");var o,c=i("f0c5"),l=Object(c["a"])(e["default"],n["b"],n["c"],!1,null,"052c565a",null,!1,n["a"],o);a["default"]=l.exports},"70df":function(t,a,i){"use strict";Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0;var n={data:function(){return{CustomBar:this.CustomBar,modalName:null,radio:"radio1",checkbox:[{value:0,name:"10元",checked:!1,hot:!1},{value:1,name:"20元",checked:!0,hot:!1},{value:2,name:"30元",checked:!0,hot:!0},{value:3,name:"60元",checked:!1,hot:!0},{value:4,name:"80元",checked:!1,hot:!1},{value:5,name:"100元",checked:!1,hot:!1}]}},methods:{showModal:function(t){this.modalName=t.currentTarget.dataset.target},hideModal:function(t){this.modalName=null},RadioChange:function(t){this.radio=t.detail.value},ChooseCheckbox:function(t){for(var a=this.checkbox,i=t.currentTarget.dataset.value,n=0,e=a.length;n<e;++n)if(a[n].value==i){a[n].checked=!a[n].checked;break}}}};a.default=n},bfe0:function(t,a,i){"use strict";var n;i.d(a,"b",(function(){return e})),i.d(a,"c",(function(){return s})),i.d(a,"a",(function(){return n}));var e=function(){var t=this,a=t.$createElement,i=t._self._c||a;return i("v-uni-view",[i("cu-custom",{attrs:{bgColor:"bg-gradual-pink",isBack:!0}},[i("template",{attrs:{slot:"backText"},slot:"backText"},[t._v("返回")]),i("template",{attrs:{slot:"content"},slot:"content"},[t._v("模态窗口")])],2),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("普通窗口")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"Modal"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Modal")])],1)],1),i("v-uni-view",{staticClass:"cu-modal",class:"Modal"==t.modalName?"show":""},[i("v-uni-view",{staticClass:"cu-dialog"},[i("v-uni-view",{staticClass:"cu-bar bg-white justify-end"},[i("v-uni-view",{staticClass:"content"},[t._v("Modal标题")]),i("v-uni-view",{staticClass:"action",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-text",{staticClass:"cuIcon-close text-red"})],1)],1),i("v-uni-view",{staticClass:"padding-xl"},[t._v("Modal 内容。")])],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("底部窗口")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"bottomModal"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Bottom")])],1)],1),i("v-uni-view",{staticClass:"cu-modal bottom-modal",class:"bottomModal"==t.modalName?"show":""},[i("v-uni-view",{staticClass:"cu-dialog"},[i("v-uni-view",{staticClass:"cu-bar bg-white"},[i("v-uni-view",{staticClass:"action text-green"},[t._v("确定")]),i("v-uni-view",{staticClass:"action text-blue",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("取消")])],1),i("v-uni-view",{staticClass:"padding-xl"},[t._v("Modal 内容。")])],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("对话窗口")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"DialogModal1"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Dialog")]),i("v-uni-button",{staticClass:"cu-btn bg-blue shadow margin-left",attrs:{"data-target":"DialogModal2"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Dialog")])],1)],1),i("v-uni-view",{staticClass:"cu-modal",class:"DialogModal1"==t.modalName?"show":""},[i("v-uni-view",{staticClass:"cu-dialog"},[i("v-uni-view",{staticClass:"cu-bar bg-white justify-end"},[i("v-uni-view",{staticClass:"content"},[t._v("Modal标题")]),i("v-uni-view",{staticClass:"action",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-text",{staticClass:"cuIcon-close text-red"})],1)],1),i("v-uni-view",{staticClass:"padding-xl"},[t._v("Modal 内容。")]),i("v-uni-view",{staticClass:"cu-bar bg-white justify-end"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn line-green text-green",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("取消")]),i("v-uni-button",{staticClass:"cu-btn bg-green margin-left",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("确定")])],1)],1)],1)],1),i("v-uni-view",{staticClass:"cu-modal",class:"DialogModal2"==t.modalName?"show":""},[i("v-uni-view",{staticClass:"cu-dialog"},[i("v-uni-view",{staticClass:"cu-bar bg-white justify-end"},[i("v-uni-view",{staticClass:"content"},[t._v("Modal标题")]),i("v-uni-view",{staticClass:"action",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-text",{staticClass:"cuIcon-close text-red"})],1)],1),i("v-uni-view",{staticClass:"padding-xl"},[t._v("Modal 内容。")]),i("v-uni-view",{staticClass:"cu-bar bg-white"},[i("v-uni-view",{staticClass:"action margin-0 flex-sub text-green ",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-text",{staticClass:"cuIcon-moneybag"}),t._v("微信支付")],1),i("v-uni-view",{staticClass:"action margin-0 flex-sub text-green solid-left",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("取消")]),i("v-uni-view",{staticClass:"action margin-0 flex-sub  solid-left",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("确定")])],1)],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("图片窗口")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"Image"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Image")])],1)],1),i("v-uni-view",{staticClass:"cu-modal",class:"Image"==t.modalName?"show":""},[i("v-uni-view",{staticClass:"cu-dialog"},[i("v-uni-view",{staticClass:"bg-img",staticStyle:{"background-image":"url('https://ossweb-img.qq.com/images/lol/web201310/skin/big91012.jpg')",height:"200px"}},[i("v-uni-view",{staticClass:"cu-bar justify-end text-white"},[i("v-uni-view",{staticClass:"action",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-text",{staticClass:"cuIcon-close "})],1)],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white"},[i("v-uni-view",{staticClass:"action margin-0 flex-sub  solid-left",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("我知道了")])],1)],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("单选窗口")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"RadioModal"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Radio")])],1)],1),i("v-uni-view",{staticClass:"cu-modal",class:"RadioModal"==t.modalName?"show":"",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"cu-dialog",on:{click:function(a){a.stopPropagation(),arguments[0]=a=t.$handleEvent(a)}}},[i("v-uni-radio-group",{staticClass:"block",on:{change:function(a){arguments[0]=a=t.$handleEvent(a),t.RadioChange.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"cu-list menu text-left"},t._l(5,(function(a,n){return i("v-uni-view",{key:n,staticClass:"cu-item"},[i("v-uni-label",{staticClass:"flex justify-between align-center flex-sub"},[i("v-uni-view",{staticClass:"flex-sub"},[t._v("Item "+t._s(n+1))]),i("v-uni-radio",{staticClass:"round",class:t.radio=="radio"+n?"checked":"",attrs:{checked:t.radio=="radio"+n,value:"radio"+n}})],1)],1)})),1)],1)],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("多选窗口")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"ChooseModal"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Choose")])],1)],1),i("v-uni-view",{staticClass:"cu-modal bottom-modal",class:"ChooseModal"==t.modalName?"show":"",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"cu-dialog",on:{click:function(a){a.stopPropagation(),arguments[0]=a=t.$handleEvent(a)}}},[i("v-uni-view",{staticClass:"cu-bar bg-white"},[i("v-uni-view",{staticClass:"action text-blue",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("取消")]),i("v-uni-view",{staticClass:"action text-green",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[t._v("确定")])],1),i("v-uni-view",{staticClass:"grid col-3 padding-sm"},t._l(t.checkbox,(function(a,n){return i("v-uni-view",{key:n,staticClass:"padding-xs"},[i("v-uni-button",{staticClass:"cu-btn orange lg block",class:a.checked?"bg-orange":"line-orange",attrs:{"data-value":a.value},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.ChooseCheckbox.apply(void 0,arguments)}}},[t._v(t._s(a.name)),a.hot?i("v-uni-view",{staticClass:"cu-tag sm round",class:a.checked?"bg-white text-orange":"bg-orange"},[t._v("HOT")]):t._e()],1)],1)})),1)],1)],1),i("v-uni-view",{staticClass:"cu-bar bg-white margin-top"},[i("v-uni-view",{staticClass:"action"},[i("v-uni-text",{staticClass:"cuIcon-title text-orange "}),t._v("侧边抽屉")],1),i("v-uni-view",{staticClass:"action"},[i("v-uni-button",{staticClass:"cu-btn bg-green shadow",attrs:{"data-target":"DrawerModalL"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Left")]),i("v-uni-button",{staticClass:"cu-btn bg-blue shadow margin-left",attrs:{"data-target":"DrawerModalR"},on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.showModal.apply(void 0,arguments)}}},[t._v("Right")])],1)],1),i("v-uni-view",{staticClass:"cu-modal drawer-modal justify-start",class:"DrawerModalL"==t.modalName?"show":"",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"cu-dialog basis-lg",style:[{top:t.CustomBar+"px",height:"calc(100vh - "+t.CustomBar+"px)"}],on:{click:function(a){a.stopPropagation(),arguments[0]=a=t.$handleEvent(a)}}},[i("v-uni-view",{staticClass:"cu-list menu text-left"},t._l(5,(function(a,n){return i("v-uni-view",{key:n,staticClass:"cu-item arrow"},[i("v-uni-view",{staticClass:"content"},[i("v-uni-view",[t._v("Item "+t._s(n+1))])],1)],1)})),1)],1)],1),i("v-uni-view",{staticClass:"cu-modal drawer-modal justify-end",class:"DrawerModalR"==t.modalName?"show":"",on:{click:function(a){arguments[0]=a=t.$handleEvent(a),t.hideModal.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"cu-dialog basis-lg",style:[{top:t.CustomBar+"px",height:"calc(100vh - "+t.CustomBar+"px)"}],on:{click:function(a){a.stopPropagation(),arguments[0]=a=t.$handleEvent(a)}}},[i("v-uni-view",{staticClass:"cu-list menu text-left"},t._l(5,(function(a,n){return i("v-uni-view",{key:n,staticClass:"cu-item arrow"},[i("v-uni-view",{staticClass:"content"},[i("v-uni-view",[t._v("Item "+t._s(n+1))])],1)],1)})),1)],1)],1)],1)},s=[]},d496:function(t,a,i){"use strict";i.r(a);var n=i("70df"),e=i.n(n);for(var s in n)"default"!==s&&function(t){i.d(a,t,(function(){return n[t]}))}(s);a["default"]=e.a}}]);