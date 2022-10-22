/* eslint-disable no-redeclare */
/* eslint-disable no-undef */
/* eslint-disable no-unused-vars */
// 初始化拖动和最大容器框
$('#dragslot').dragslot({
  dropCallback: function(element) {
    //			console.log(element);
  },
});
var isModify = false;
function doRefresh(id) {
  $('#dragslot').doRefresh();
}

// X按钮
function doClose(thisObj) {
  console.log(7);
  $(thisObj)
      .parent()
      .remove();
}
// 修改按钮
function doReset(thisObj) {
  var no = $(thisObj)
      .parent()
      .attr('idNum');
  var jsonStr = $('#jsonVal' + no).get(0).value;
  var json = JSON.parse(jsonStr);
  isModify = true;
  attrPageInit();
  modifyCreate(json.type, json);
  clickp();
}

/** 增加时间框事件 */
function addDateTimeListener(type, index) {
  var formatStr;
  if (type == 'date') {
    formatStr = 'yyyy-MM-dd';
  } else if (type == 'time') {
    formatStr = 'HH:mm:ss';
  } else if (type == 'datetime') {
    formatStr = 'yyyy-MM-dd HH:mm:ss';
  } else if (type == 'datehour') {
    formatStr = 'yyyy-MM-dd HH';
  } else if (type == 'datehourtime') {
    formatStr = 'yyyy-MM-dd HH:mm';
  }
  // 特殊日期走页面自定义配置
  var indexSpecial = ['EAR_455'];
  if (formatStr && indexSpecial.indexOf(index) === -1) {
    //选中后的回调
    // jeDate("#create_"+index, {
    // 	format: formatStr,
    // 	onClose:true,
    // 	isToday:false,
    // 	theme:{bgcolor:"#5883e6",pnColor:"#5883e6"},
    // 	donefun:function (obj) {
    // 		$(obj.elem).change();
    // 		$(obj.elem).blur();
    // 	}
    // });

    // 日期选择器设置
    WdatePicker({
      el: $dp.$('create_' + index), //设置后不管是点谁触发的弹框都认为是stime绑定者弹出的，值赋给绑定者
      dateFmt: formatStr, //格式设置相对应界面可选择也变化
      qsEnabled: false,
      enableInputMask: false,
      errDealMode: -1,
      skin: 'twoer',
      maxDate: '%y-%M-%d 23:59:59',
      onpicking: function(obj) {
        // console.log(obj.cal.getNewDateStr());
        // 如果要在页面上拿到日期选择器change值，则从自定义属性里面取
        var needChangeNames = ['HD_334', 'HD_434', 'HD_534', 'HD_634', 'HBV_244', 'CM_16', 'CM_24', 'CM_13'];
        if (needChangeNames.indexOf(index) !== -1) {
          var date = obj.cal.getNewDateStr();
          $(obj.el).attr('data-value', date);
        }
        $(obj.el).change();
        $(obj.el).blur();
        //年龄弹框提示
        if (index === 'CM_13' || index === 'CM_16') {
          ageTips(obj, index);
        }
        // 出院时间为2021
        if (index == 'CM_17') {
          hospitalization2021(obj);
        }
      },
    });
  }
}

var indexNum = 0;
function createBox(contend, idNum, jsonObj, boxObj) {
  var htm = '<div id="item' + idNum + '" class="slot-item" idNum="' + idNum + '">';
  var htmContend = '<input id="jsonVal' + idNum + '" type="hidden"/>';
  htmContend += '<a class="move"></a>';
  htmContend += '<a class="close" onclick="doClose(this)"></a>';
  htmContend += '<a class="reset" onclick="doReset(this)"></a>';
  htmContend += contend;
  var htmEnd = '</div>';
  if (boxObj) {
    // 要添加的对象本身是移动控件，则改为修改
    if ($(boxObj).hasClass('slot-item')) {
      if (jsonObj.type == 'box' || jsonObj.type == 'box1') {
        var sonList = $('#create_' + idNum).children();
        $(boxObj)
            .children()
            .remove();
        $(boxObj).append(htmContend);
        $('#create_' + idNum).append(sonList);
      } else {
        $(boxObj)
            .children()
            .remove();
        $(boxObj).append(htmContend);
      }
    } else {
      $(boxObj).append(htm + htmContend + htmEnd);
    }
  } else {
    $('.tempbox').append(htm + htmContend + htmEnd);
  }
  doRefresh('item' + idNum);
  // 图片预览需要动态追加
  if (jsonObj.type === 'img') {
    upload(jsonObj);
  }
  $('#jsonVal' + idNum).val(JSON.stringify(jsonObj));
}

var createJson = {};
$(window).on('keydown', function(e) {
  if (e.keyCode == 27 && $('.layui-layer-close').get(0)) {
    $('.layui-layer-close')
        .get(0)
        .click();
  }
});

// 弹出创建框
function clickp() {
  //	$("#create_type").attr("disabled", isModify);
  // 新增
  if (!isModify) {
    var diseaseType = sessionStorage.getItem('type');
    var modelNo = '';
    var indexNumStr = indexNum + '';
    if (indexNumStr.indexOf('_') == -1) {
      modelNo = diseaseType + '_' + indexNum;
    }
    $('#create_no').text(modelNo);
    // 提交名置为空
    // $("#create_submitName").val("")
  }
  layer.ready(function() {
    layer.open({
      type: 1,
      title: '模版控件',
      area: ['800px', '500px'],
      content: $('#pop-content-02'),
      //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
      btn: ['确认', '取消'],
      cancel: function(index, layero) {
        layer.close(index);
        $('#pop-content-02').hide();
        isModify = false;
        return false;
      },
      yes: function(index, layero) {
        var flagName = false;
        try {
          var submitName = $('#create_submitName').val();
          if ($('#create_submitName').is(':hidden')) {
            submitName = '';
          }
          var diseaseType = sessionStorage.getItem('type');
          var create_no = $('#create_no').text();
          if (!isModify) {
            // 新增
            if (create_no.indexOf('_') != -1) {
              var no = $('#create_no').text();
            } else {
              var no = diseaseType + '_' + $('#create_no').text();
            }
          } else {
            // 修改
            var no = $('#create_no').text();
          }

          if (submitName.trim() != '') {
            var checkDouble = $('[name=' + submitName + ']');
            for (var i = 0; i < checkDouble.length; i++) {
              var temp = $(checkDouble[i]).parent();
              if (temp.hasClass('layui-upload')) {
                if (temp.parent('div').attr('idnum') == no) {
                  continue;
                } else {
                  flagName = true;
                  var tempRemark = $(temp.parent('div').children('span')[0]).text();
                  alert('控件 [ ' + tempRemark.substring(0, tempRemark.length - 1) + ' ] 与本控件的提交名相同');
                  return;
                }
              } else {
                var idnum;
                if ($(checkDouble[i]).attr('data-type') == 'listMultiple') {
                  idnum = $(checkDouble[i])
                      .parent()
                      .parent()
                      .attr('idnum');
                } else {
                  idnum = temp.attr('idnum');
                }
                if (idnum == no) {
                  continue;
                } else {
                  flagName = true;
                  var tempRemark = $(temp.children('span')[0]).text();
                  alert('控件 [ ' + tempRemark.substring(0, tempRemark.length - 1) + ' ] 与本控件的提交名相同');
                  return;
                }
              }
            }
          }
          // 判断隐藏/显示控件是否存在
          var createLinkHide = $('#create_link_hide')
              .val()
              .trim()
              .split(',');
          var createLinkShow = $('#create_link_show')
              .val()
              .trim()
              .split(',');
          createLinkHide.forEach(item => {
            if ($('#item' + item).length <= 0 && item !== '') {
            flagName = true;
            alert('没有找到控件编码' + item + '的控件');
            return;
          }
        });
          createLinkShow.forEach(item => {
            if ($('#item' + item).length <= 0 && item !== '') {
            flagName = true;
            alert('没有找到控件编码' + item + '的控件');
            return;
          }
        });
          if (flagName === true) {
            return;
          }
          var createJson = {};
          createJson.type = $('#create_type').val();
          if (!createJson.type || createJson.type == '') {
            return;
          }
          createJson.title = $('#create_title').val();
          var titleMsg = $('#create_titleMsg').val();
          if ($('#create_submitName').is(':visible') && submitName && submitName.trim() != '') {
            createJson.submitName = submitName;
          }
          var saveAddress = $('#create_saveAddress').val();
          if ($('#create_saveAddress').is(':visible') && saveAddress && saveAddress.trim() != '') {
            createJson.saveAddress = base64.encode(saveAddress);
          }
          // 图片数量
          var imgNumber = $('#create_imgNumber').val();
          if ($('#create_imgNumber').is(':visible') && imgNumber && imgNumber.trim() !== '') {
            createJson.imgNumber = $('#create_imgNumber').val();
          }
          // 图片大小
          var imgSize = $('#create_imgSize').val();
          if ($('#create_imgSize').is(':visible') && imgSize && imgSize.trim() !== '') {
            createJson.imgSize = $('#create_imgSize').val();
          }
          // 图片最大数量
          var imgMaxNum = $('#create_imgMaxNum').val();
          if ($('#create_imgMaxNum').is(':visible') && imgMaxNum && imgMaxNum.trim() !== '') {
            createJson.imgMaxNum = $('#create_imgMaxNum').val();
          }
          // 图片提交名
          var submitImg = $('#create_submitImg').val();
          if ($('#create_submitImg').is(':visible') && submitImg && submitImg.trim() !== '') {
            createJson.submitImg = $('#create_submitImg').val();
          }
          // 图片返回字段
          var field = $('#create_field').val();
          if ($('#create_field').is(':visible') && field && field.trim() !== '') {
            createJson.field = $('#create_field').val();
          }
          // 日期格式
          var format = $('#create_format').val();
          if ($('#create_format').is(':visible') && format && format.trim() !== '') {
            createJson.format = format;
          }
          if ($('#create_titleMsg').is(':visible') && titleMsg && titleMsg.trim() != '') {
            createJson.titleMsg = base64.encode(titleMsg);
          }
          if ($('#create_disabled').is(':visible')) {
            createJson.disabled = $('#create_disabled').is(':checked');
          }
          if ($('#create_hide').is(':visible')) {
            createJson.hide = $('#create_hide').is(':checked');
          }
          if ($('#create_board') && $('#create_board').is(':visible') && $('#create_board').get(0).checked) {
            createJson.board = true;
          }
          if ($('#create_api_remark') && $('#create_api_remark').is(':visible')) {
            var apiRemark = $('#create_api_remark').val();
            if (apiRemark) {
              createJson.apiRemark = base64.encode(apiRemark);
            }
          }
          // 处理检查验证
          if ($('#tr_check').is(':visible')) {
            createJson.check = {
              notnull: document.getElementById('create_check_notnull').checked,
              type: $('#create_check_type').val(),
              list: [],
            };
            if (createJson.check.type != 'normal') {
              var checkList = $('#create_check_list').children();
              for (var i = 0; i < checkList.length; i++) {
                var checkOnce = {
                  rule: $(checkList[i]).attr('value'),
                  type: $(checkList[i]).attr('type'),
                  msg: $(checkList[i]).attr('msg'),
                };
                createJson.check.list.push(checkOnce);
              }
            }
          }
          // 处理添加的控件
          switch (createJson.type) {
            case 'checkbox':
            case 'radio': {
              createJson.pointsort = $("input[name='create_pointsort']:checked").val();
              createJson.textsort = $("input[name='create_textsort']:checked").val();
              createJson.selectMultiple = $('#create_select_multiple').get(0).checked;
              break;
            }
            case 'select': {
              var sonList = $('#create_select_list').children();
              if (sonList && sonList.length > 0) {
                var selectVal = [];
                for (var i = 0; i < sonList.length; i++) {
                  var selectOnce = {};
                  selectOnce.val = $(sonList[i]).val();
                  selectOnce.remark = $(sonList[i]).text();
                  selectVal.push(selectOnce);
                }
                createJson.values = selectVal;
              }
              break;
            }
            case 'box':
            case 'box1': {
              createJson.line = document.getElementById('create_box_line').checked;
              break;
            }

            case 'span': {
              delete createJson.submitName;
              break;
            }
          }
          var linkType = $('#create_link_type').val();
          if (linkType && linkType != 'normal') {
            var link = {
              type: linkType,
              values: [],
            };
            var list = $('#create_link_list').children();
            for (var i = 0; i < list.length; i++) {
              var maxOper = $(list[i]).attr('maxOper')
                  ? $(list[i])
                      .attr('maxOper')
                      .trim()
                      .replace(/[\r\n]/g, '')
                  : '';
              var maxValue = $(list[i]).attr('maxValue')
                  ? $(list[i])
                      .attr('maxValue')
                      .trim()
                      .replace(/[\r\n]/g, '')
                  : '';
              var value = {
                oper: $(list[i])
                    .attr('oper')
                    .trim()
                    .replace(/[\r\n]/g, ''),
                type: $(list[i])
                    .attr('type')
                    .trim()
                    .replace(/[\r\n]/g, ''),
                rule: $(list[i])
                    .val()
                    .trim()
                    .replace(/[\r\n]/g, ''),
                maxOper: maxOper,
                maxRule: maxValue,
              };
              if (value.type == 'reset') {
                value.val = $(list[i])
                    .attr('val')
                    .trim()
                    .replace(/[\r\n]/g, '');
                value.no = $(list[i])
                    .attr('no')
                    .trim()
                    .replace(/[\r\n]/g, '');
              } else {
                value.hide = $(list[i])
                    .attr('hide')
                    .trim()
                    .replace(/[\r\n]/g, '');
                value.show = $(list[i])
                    .attr('show')
                    .trim()
                    .replace(/[\r\n]/g, '');
              }
              link.values.push(value);
            }
            createJson.link = link;
          }
          // 初始化
          if ($('#tr_init').is(':visible') && $('#create_init_type') != 'normal') {
            var ruleStr = '';
            var r1 = $('#create_init_1').val();
            ruleStr = r1 ? r1 : '';
            var r2 = $('#create_init_oper').val();
            ruleStr += r2 ? '::' + r2 : '';
            var r3 = $('#create_init_2').val();
            ruleStr += r3 ? '::' + r3 : '';
            var rule = base64.encode(ruleStr);
            var init = {
              type: $('#create_init_type').val(),
              rule: rule,
            };
            if ($('#create_init_unit').is(':visible')) {
              init.unit = $('#create_init_unit').val();
            }
            if (init.unit == 'double') {
              init.decimal = $('#create_init_3').val();
            }
            createJson.init = init;
          }
          // 修改或新增
          if (isModify) {
            // 修改
            createJson.no = $('#modify_no').val();
            // createJson.no = parseInt($('#modify_no').val());
            createElement(createJson, $('#item' + createJson.no));
          } else {
            // 新增
            createJson.no = $('#create_no').text();
            var indexNumTemp = Number(indexNum);
            console.log(createJson, 'createJson');
            createElement(createJson);
            indexNum = indexNum == indexNumTemp ? Number(indexNum) + 1 : indexNum;
          }
        } catch (err) {
          console.error(err);
        } finally {
          // 相同提交名不关闭(控件不存在不关闭)
          if (!flagName) {
            isModify = false;
            layer.close(index); //如果设定了yes回调，需进行手工关闭
            $('#pop-content-02').hide();
          }
          if (flagName && isModify) {
            isModify = true;
          }
        }
      },
      btn2: function(index, layero) {
        layer.close(index); //如果设定了yes回调，需进行手工关闭
        $('#pop-content-02').hide();
        isModify = false;
      },
    });
  });
}
var linkAndCheckList = [];
var numberMaxNumbur = []; //indexNum  所有json.no 值
//鼠标是否在【多选下拉框div】上面（如果在div上面，需要控制鼠标的点击事件，不让div隐藏；否则要让该div隐藏）
var indiv = false;
/** 依据容器json向容器对象内添加元素(容器对象为null，则新增在临时容器里) */
function createElement(json, boxObj, callback) {
  if (!json) {
    return;
  }
  var type = json.type;
  var doc = '<span class="input_remark' + json.no + '">' + (json.title ? json.title + '：' : json.title) + '</span>';
  switch (type) {
    case 'span': {
      doc = '<span class="input_remark' + json.no + '">' + json.title + '</span>';
      break;
    }
    case 'text': {
      doc += '<input id="create_' + json.no + '" placeholder="请输入" class="create_' + json.no + '" ';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'number': {
      doc +=
          '<input id="create_' +
          json.no +
          '" placeholder="请输入" class="create_' +
          json.no +
          '" type="number" onkeyup="this.value=this.value.replace(/[^d.]/g,"")" onafterpaste="this.value=this.value.replace(/[^d.]/g,"")" ';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'date': {
      doc +=
          '<input id="create_' +
          json.no +
          '" readonly="true" type="text" placeholder="请选择日期" class="create_' +
          json.no +
          ' dateicon jedate my97" onClick=addDateTimeListener("date",&quot;' +
          json.no +
          '&quot;)';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'time': {
      doc +=
          '<input id="create_' +
          json.no +
          '" type="text" readonly="true" placeholder="请选择日期" class="create_' +
          json.no +
          ' dateicon jedate my97" onClick=addDateTimeListener("time",&quot;' +
          json.no +
          '&quot;)';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'datetime': {
      doc +=
          '<input id="create_' +
          json.no +
          '" type="text" readonly="true" placeholder="请选择日期" class="create_' +
          json.no +
          ' dateicon jedate my97" onClick=addDateTimeListener("datetime",&quot;' +
          json.no +
          '&quot;)';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'datehour': {
      doc +=
          '<input id="create_' +
          json.no +
          '" readonly="true" placeholder="请选择日期" type="text" class="create_' +
          json.no +
          ' dateicon jedate my97" onClick=addDateTimeListener("datehour",&quot;' +
          json.no +
          '&quot;)';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'datehourtime': {
      doc +=
          '<input id="create_' +
          json.no +
          '" type="text" readonly="true" placeholder="请选择日期" class="create_' +
          json.no +
          ' dateicon jedate my97" onClick=addDateTimeListener("datehourtime",&quot;' +
          json.no +
          '&quot;)';
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '"';
      if (json.titleMsg) {
        doc += ' placeholder="' + base64.decode(json.titleMsg) + '" ';
      }
      doc += '>';
      break;
    }
    case 'select': {
      doc += '<select class="create_' + json.no + '" id="create_' + json.no + '" name=' + json.submitName;
      doc += ' onchange="';
      if (json.link && json.link.type != 'normal') {
        doc += 'doLink(this,&quot;' + json.no + '&quot;);';
      }
      if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
        doc += 'doCheck(this,&quot;' + json.no + '&quot;);';
        doc += '" onblur="$(this).change();';
      }
      doc += '">';
      for (var i = 0; i < json.values.length; i++) {
        // 对于选项过长处理
        var titleLength = json.values[i].remark.length;
        if (titleLength > 20) {
          doc +=
              '<option title="' +
              json.values[i].remark +
              '" value="' +
              json.values[i].val +
              '">' +
              json.values[i].remark +
              '</option>';
        } else {
          doc += '<option value="' + json.values[i].val + '">' + json.values[i].remark + '</option>';
        }
      }
      doc += '</select>';
      break;
    }
    case 'checkbox':
    case 'radio': {
      if (!json.selectMultiple) {
        for (var i = 0; i < json.values.length; i++) {
          if (json.pointsort == '2') {
            doc += '<br key="' + json.values[i].val + '" />';
          }
          var temp =
              '<input class="create_' +
              json.no +
              '" id="create_' +
              json.no +
              '" name="' +
              json.submitName +
              '" type="' +
              type +
              '" value="' +
              json.values[i].val +
              '" ';
          if (json.link && json.link.type != 'normal') {
            temp += ' onchange=doLink(this,&quot;' + json.no + '&quot;) ';
          }
          if (json.check && (json.check.type != 'normal' || json.check.notnull)) {
            temp += ' onblur=doCheck(this,&quot;' + json.no + '&quot;); onclick="$(this).blur();" ';
          }
          temp += '/>';
          if (json.textsort == '1') {
            doc +=
                '<span key="' +
                json.values[i].val +
                '" onclick="choose($(this).next());">' +
                json.values[i].remark +
                '</span>';
            doc += temp;
          } else {
            doc += temp;
            doc +=
                '<span key="' +
                json.values[i].val +
                '" onclick="choose($(this).prev());">' +
                json.values[i].remark +
                '</span>';
          }
        }
      } else {
        doc +=
            '<div idnum=' +
            json.no +
            ' style="display: inline-block;position: relative;width:37%;"><span style="height:20px;">';
        doc +=
            '<input type="text" name="' +
            json.submitName +
            '" placeholder="请选择" data-type="listMultiple"  id="create_' +
            json.no +
            '" onchange="hideEle(&quot;' +
            json.no +
            '&quot;)" onclick="selectMclick(&quot;' +
            json.no +
            '&quot;);" readonly="true" style="margin-left:14px;width:100%;height:20px;font-size:14px;overflow: hidden;text-overflow: ellipsis; white-space: nowrap;"></input>';
        doc += '</span>';
        doc +=
            '<span  id="selectMup_' +
            json.no +
            '" style="display:none;padding:0 10px;position: absolute;z-index:99;border:1px solid #A9A9A9;width:400px;overflow-y :scroll;height:165px;background-color:white;font-size:12px;" onMouseOver="mousein(this)" onMouseOut="mouseout(this,&quot;' +
            json.no +
            '&quot;)">';
        var initlist = json.values;
        for (var k = 0; k < initlist.length; k++) {
          doc +=
              '<div><input type="checkbox" value=' +
              initlist[k].val +
              '><span onclick="selectMcheck(this,&quot;' +
              json.no +
              '&quot;)" date-id="' +
              json.no +
              '">' +
              initlist[k].remark +
              '</span></div>';
        }
        doc += '</span><div>';
      }
      break;
    }
    case 'box': {
      doc +=
          '<div id="create_' +
          json.no +
          '" class="slot-list create_' +
          json.no +
          '" style="min-height: 44px; min-width: 300px">';
      doc += '</div>';
      if (json.submitName) {
        json.submitName = '';
      }
      break;
    }
    case 'box1': {
      doc = '<p class="form-title form-cursor" onclick="box1Action(this)">';
      doc += '<span class="circle"></span>' + json.title;
      doc += '<span class="pull-right" onclick="box1FinishAction(this, &quot;' + json.no + '&quot;)">';
      doc += '<span class="complete">完成</span>';
      doc += '<span class="arrow-up" id="hospitalInfo"></span></span></p>';
      doc += '<div class="slot-list create_' + json.no + '" id="create_' + json.no + '">';
      doc += '</div>';
      if (json.submitName) {
        json.submitName = '';
      }
      break;
    }
    default: {
      console.log('暂不支持[' + type + ']类别');
      return;
    }
  }
  createBox(doc, json.no, json, boxObj);
  var thisObj = $('#create_' + json.no);
  var board = json.board ? 'board' : '';
  thisObj.addClass(board);
  // if(thisObj.hasClass('my97')) {
  // 	addDateTimeListener(type, json.no);
  // }
  thisObj.attr('name', json.submitName);
  // json.no = parseInt(json.no);
  var jsonNo = json.no + '';
  if (jsonNo.indexOf('_') != -1) {
    jsonNo = Number(jsonNo.split('_')[1]);
  }
  indexNum = jsonNo >= indexNum ? Number(jsonNo) + 1 : indexNum;
  if (json.sonList) {
    for (var i = 0; i < json.sonList.length; i++) {
      createElement(json.sonList[i], thisObj, callback);
    }
  }

  // 补充初始化处理
  if (json.init && json.init.type && json.init.type != 'normal') {
    addInitListener(json);
    $(thisObj).focus();
  }

  // 只读、隐藏与边线
  if (type == 'box' || type == 'box1') {
    if (json.disabled) {
      $('#item' + json.no + ' *').attr('disabled', json.disabled);
    }
    if (json.line) {
      $('#create_' + json.no).css('border', '2px solid #0abebf');
    } else {
      $('#create_' + json.no).css('border', '2px dashed #F00');
    }
  } else {
    $('#item' + json.no + ' *').attr('disabled', json.disabled);
  }
  if (json.hide) {
    $('#item' + json.no).css('background-color', 'red');
  } else {
    $('#item' + json.no).css('background-color', 'white');
  }

  // 增加校验的联动触发效果
  if (json.check && json.check.list && json.check.list.length > 0) {
    // 使校验可以联动执行
    var linkAndCheck = function(no) {
      if (no == json.no) {
        return;
      }
      var fun = $('#create_' + no).attr('onblur');
      if (!fun) {
        fun = '';
      } else {
        fun = fun.charAt(fun.length - 1) == ';' ? fun : fun + ';';
      }
      var blurStr = "doCheck($('#create_" + json.no + "').get(0), '" + json.no + "');";
      if (fun.indexOf(blurStr) == -1) {
        fun += blurStr;
      }
      $('.create_' + no).attr('onblur', fun);
    };
    for (var i = 0; i < json.check.list.length; i++) {
      linkAndCheckList.push({
        rule: json.check.list[i].rule,
        fun: linkAndCheck,
      });
    }
    if (!isImport) {
      checkInit();
    }
  }

  // 调用填报页或者展示页的回调
  if (callback) {
    callback(thisObj, json);
  }
  return thisObj;
}

// 下拉多选单击事件
function selectMclick(id) {
  var Mask =
      '<div class="Mask" style="position: fixed;height:100%;width:100%;z-index:10;top:0;left:0" onclick="hideEle(&quot;' +
      id +
      '&quot;)"></div>';
  $('body').append(Mask);
  $('#jsonVal' + id)
      .parent()
      .css('position', 'inherit');
  document.getElementById('selectMup_' + id).style.display = 'block';
}
function hideEle(id) {
  $('.Mask').remove();
  document.getElementById('selectMup_' + id).style.display = 'none';
  // 为空校验
  var JsonVal = JSON.parse($('#jsonVal' + id).attr('value'));
  if (JsonVal.check.notnull) {
    var selectEle = $('#create_' + id).val();
    if (
        !selectEle &&
        $('#create_' + id)
            .parent()
            .parent()
            .next()
            .attr('class') != 'error'
    ) {
      $('#create_' + id)
          .parent()
          .parent()
          .parent()
          .append('<span class="error"><font size=-1 color=red>该项为必填项</font></span>');
    } else if (
        selectEle&&$('#create_' + id)
            .parent()
            .parent()
            .next()
            .attr('class') == 'error'
    ) {
      $('#create_' + id)
          .parent()
          .parent()
          .next()
          .remove();
    }
  }
}

//鼠标进入多选框的div【selectdiv】
function mousein(obj) {
  indiv = true;
  obj.style.display = 'block';
}

//鼠标离开多选框的div【selectdiv】
function mouseout(obj, id) {
  $('.Mask').remove();
  hideEle(id);
  obj.style.display = 'none';
}

// 下拉多选选中  input 赋值
// 对下拉多选框进行联动赋值等操作
function selectMcheck(obj, id, check) {
  // check  为编辑状态
  if (!check) {
    if ($(obj).attr('type')) {
      choose($(obj));
    } else {
      choose($(obj).prev());
    }
  }
  var selectedlist = [];
  var selectednamelist = [];
  var jsonStr = JSON.parse($('#jsonVal' + id).get(0).value);
  var activeSilbings = $(obj)
      .parent()
      .siblings();
  var texts = $(obj).text();
  for (var k = 0; k < activeSilbings.length; k++) {
    if (
        $(activeSilbings[k])
            .children('input')
            .get(0).checked
    ) {
      var texts2 = $(activeSilbings[k])
          .children('span')
          .text();
      selectednamelist.push(texts2);
      selectedlist.push(
          $(activeSilbings[k])
              .children('input')
              .get(0).value
      );
    }
  }
  if (
      $(obj)
          .prev()
          .get(0).checked
  ) {
    // 选中
    var objVal = $(obj)
        .prev()
        .attr('value');
    selectedlist.push(objVal);
    selectednamelist.push(texts);
    // 关联触发
    if (jsonStr.link) {
      var valueLink = jsonStr.link.values;
    } else {
      var valueLink = [];
    }
    for (var n = 0; n < valueLink.length; n++) {
      // 联动
      if (valueLink[n].type == 'reset') {
        var linkCalc = valueLink[n].oper;
        var nowVals = valueLink[n].rule.split('::')[1];
        if (valueLink[n].no.indexOf('#{') == -1) {
          var linkNo_1 = valueLink[n].no;
        } else {
          var linkNo_1 = valueLink[n].no.split('#{')[1].split('}')[0];
        }
        if (linkCalc == '==') {
          if (objVal == nowVals) {
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (inputs_val == nowVals) {
                  $(linkChangeSelect[j])
                      .children('input')
                      .get(0).checked = true;
                  selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  showVal.push(
                      $(linkChangeSelect[j])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if ($('#create_' + linkNo_1).attr('type') == 'checkbox') {
                var inputs_box = $('.create_' + linkNo_1);
                for (var y = 0; y < inputs_box.length; y++) {
                  if ($(inputs_box[y]).attr('value') == valueLink[n].val) {
                    $(inputs_box[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              } else {
                $('#create_' + linkNo_1).val(valueLink[n].val);
                $('#create_' + linkNo_1).change();
                $('#create_' + linkNo_1).blur();
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              for (var y = 0; y < inputs_radio.length; y++) {
                if ($(inputs_radio[y]).attr('value') == valueLink[n].val) {
                  $(inputs_radio[y]).get(0).checked = true;
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            }
          }
        } else if (linkCalc == '<' || linkCalc == '<=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            // 不含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '<') {
                  if (inputs_val == objVal && inputs_val < nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .attr('checked', true);
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val <= nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .attr('checked', true);
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '<') {
                if (inputs_val < nowVals) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              } else {
                if (inputs_val <= nowVals) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              for (var y = 0; y < inputs_radio.length; y++) {
                if (linkCalc == '<') {
                  if (objVal < nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).attr('checked', true);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                } else {
                  if (objVal <= nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).attr('checked', true);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              }
            }
          } else {
            // 含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '<') {
                  if (inputs_val == objVal && inputs_val < nowVals && inputs_val > maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = true;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val <= nowVals && inputs_val >= maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = true;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }

              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '<') {
                if (objVal < nowVals && objVal > maxVal) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              } else {
                if (objVal <= nowVals && objVal >= maxVal) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              for (var y = 0; y < inputs_radio.length; y++) {
                if (linkCalc == '<') {
                  if (objVal < nowVals && objVal > maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                } else {
                  if (objVal <= nowVals && objVal >= maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              }
            }
          }
        } else if (linkCalc == '>' || linkCalc == '>=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            // 不含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '>') {
                  if (inputs_val == objVal && inputs_val > nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = true;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val >= nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = true;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '>') {
                if (inputs_val > nowVals) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              } else {
                if (inputs_val >= nowVals) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              for (var y = 0; y < inputs_radio.length; y++) {
                if (linkCalc == '>') {
                  if (inputs_val > nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                } else {
                  if (inputs_val >= nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              }
            }
          } else {
            // 含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '>') {
                  if (inputs_val == objVal && inputs_val > nowVals && inputs_val < maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = true;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val >= nowVals && inputs_val <= maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = true;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }

              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '>') {
                if (objVal > nowVals && objVal < maxVal) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              } else {
                if (objVal >= nowVals && objVal <= maxVal) {
                  $('#create_' + linkNo_1).val(valueLink[n].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              for (var y = 0; y < inputs_radio.length; y++) {
                if (linkCalc == '>') {
                  if (objVal < nowVals && objVal > maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                } else {
                  if (objVal >= nowVals && objVal <= maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = true;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              }
            }
          }
        }
      } else if (valueLink[n].type == 'hide' || valueLink[n].type == 'disabled') {
        var linkCalc = valueLink[n].oper;
        var nowVals = valueLink[n].rule.split('::')[1];
        if (valueLink[n].hide.indexOf('#{') == -1) {
          if (valueLink[n].hide || valueLink[n].type == 'disabled') {
            var linkNo_1 = valueLink[n].hide;
          } else {
            var linkNo_1 = valueLink[n].show;
          }
        } else {
          if (valueLink[n].hide || valueLink[n].type == 'disabled') {
            var linkNo_1 = valueLink[n].hide.split('#{')[1].split('}')[0];
          } else {
            var linkNo_1 = valueLink[n].show.split('#{')[1].split('}')[0];
          }
        }
        if (linkCalc == '==') {
          if (objVal == nowVals) {
            if (valueLink[n].hide) {
              $('#item' + linkNo_1).hide();
            } else if (valueLink[n].show) {
              $('#item' + linkNo_1).show();
            } else {
              $('#item' + linkNo_1).attr('disabled', true);
            }
          }
        } else if (linkCalc == '<' || linkCalc == '<=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            // 不含有最大值
            if (linkCalc == '<') {
              if (objVal < nowVals) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            } else {
              if (objVal <= nowVals) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          } else {
            // 不含有最大值
            if (linkCalc == '<') {
              if (objVal < nowVals && objVal > maxVal) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            } else {
              if (objVal <= nowVals && objVal >= maxVal) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          }
        } else if (linkCalc == '>' || linkCalc == '>=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            // 不含有最大值
            if (linkCalc == '>') {
              if (objVal > nowVals) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            } else {
              if (objVal >= nowVals) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          } else {
            // 不含有最大值
            if (linkCalc == '>') {
              if (objVal > nowVals && objVal < maxVal) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            } else {
              if (objVal >= nowVals && objVal <= maxVal) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          }
        }
      }
    }
  } else {
    // 关联触发取消选中
    if (jsonStr.link) {
      var valueLink = jsonStr.link.values;
    } else {
      var valueLink = [];
    }
    var objVal = $(obj)
        .prev()
        .attr('value');
    for (var n = 0; n < valueLink.length; n++) {
      // 联动
      if (valueLink[n].type == 'reset') {
        var linkCalc = valueLink[n].oper;
        var nowVals = valueLink[n].rule.split('::')[1];
        if (valueLink[n].no.indexOf('#{') == -1) {
          var linkNo_1 = valueLink[n].no;
        } else {
          var linkNo_1 = valueLink[n].no.split('#{')[1].split('}')[0];
        }
        if (linkCalc == '==') {
          if (objVal == nowVals) {
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = $('#create_' + linkNo_1)
                  .val()
                  .split(','); //获取显示的显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (inputs_val == nowVals) {
                  $(linkChangeSelect[j])
                      .children('input')
                      .get(0).checked = false;
                  selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  showVal.splice(showVal.indexOf(objVal), 1);
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if ($('#create_' + linkNo_1).attr('type') == 'checkbox') {
                var inputs_box = $('.create_' + linkNo_1);
                for (var y = 0; y < inputs_box.length; y++) {
                  if ($(inputs_box[y]).attr('value') == valueLink[n].val) {
                    $(inputs_box[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              } else {
                $('#create_' + linkNo_1).val('');
                $('#create_' + linkNo_1).change();
                $('#create_' + linkNo_1).blur();
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              for (var y = 0; y < inputs_radio.length; y++) {
                if ($(inputs_radio[y]).attr('value') == valueLink[n].val) {
                  $(inputs_radio[y]).get(0).checked = false;
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            }
          }
        } else if (linkCalc == '<' || linkCalc == '<=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            // 不含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '<') {
                  if (inputs_val == objVal && inputs_val < nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val <= nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '<') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (valueLink[m].rule.split('::')[1] < inputs_val) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
              } else {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (valueLink[m].rule.split('::')[1] <= inputs_val) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
              }
              if (chackArr.length == 0) {
                $('#create_' + linkNo_1).val('');
                $('#create_' + linkNo_1).change();
                $('#create_' + linkNo_1).blur();
              } else {
                // 去重
                var result = [];
                var obj = {};
                for (var l = 0; l < chackArr.length; l++) {
                  if (!obj[chackArr[l].val]) {
                    result.push(chackArr[l]);
                    obj[chackArr[l].val] = true;
                  }
                }
                chackArr = result;
                // 判断选中的是否还有符合条件的
                for (var p = 0; p < chackArr.length; p++) {
                  $('#create_' + chackArr[p].no).val(chackArr[p].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              if (linkCalc == '<') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (valueLink[m].rule.split('::')[1] > inputs_val) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }

                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal < nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).get(0).checked = true;
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              } else {
                // <=
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (valueLink[m].rule.split('::')[1] >= inputs_val) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal <= nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).get(0).checked = true;
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              }
              // }
            }
          } else {
            // 含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '<') {
                  if (inputs_val == objVal && inputs_val < nowVals && inputs_val > maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val <= nowVals && inputs_val >= maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '<') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].rule.split('::')[1] < inputs_val &&
                          inputs_val > valueLink[m].maxRule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                if (chackArr.length == 0) {
                  $('#create_' + linkNo_1).val('');
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                } else {
                  // 去重
                  var result = [];
                  var obj = {};
                  for (var l = 0; l < chackArr.length; l++) {
                    if (!obj[chackArr[l].val]) {
                      result.push(chackArr[l]);
                      obj[chackArr[l].val] = true;
                    }
                  }
                  chackArr = result;
                  // 判断选中的是否还有符合条件的
                  for (var p = 0; p < chackArr.length; p++) {
                    $('#create_' + chackArr[p].no).val(chackArr[p].val);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              } else {
                if (objVal <= nowVals && objVal >= maxVal) {
                  $('#create_' + linkNo_1).val('');
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              if (linkCalc == '<') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].maxRule.split('::')[1] < inputs_val &&
                          inputs_val < valueLink[m].rule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }

                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal < nowVals && objVal > maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).get(0).checked = true;
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              } else {
                // <=
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].maxRule.split('::')[1] <= inputs_val &&
                          inputs_val <= valueLink[m].rule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal <= nowVals && objVal >= maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).get(0).checked = true;
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              }
              // }
            }
          }
        } else if (linkCalc == '>' || linkCalc == '>=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            // 不含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '>') {
                  if (inputs_val == objVal && inputs_val > nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val >= nowVals) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '>') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (valueLink[m].rule.split('::')[1] < inputs_val) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
              } else {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (valueLink[m].rule.split('::')[1] <= inputs_val) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
              }

              if (chackArr.length == 0) {
                $('#create_' + linkNo_1).val('');
                $('#create_' + linkNo_1).change();
                $('#create_' + linkNo_1).blur();
              } else {
                // 去重
                var result = [];
                var obj = {};
                for (var l = 0; l < chackArr.length; l++) {
                  if (!obj[chackArr[l].val]) {
                    result.push(chackArr[l]);
                    obj[chackArr[l].val] = true;
                  }
                }
                chackArr = result;
                // 判断选中的是否还有符合条件的
                for (var p = 0; p < chackArr.length; p++) {
                  $('#create_' + chackArr[p].no).val(chackArr[p].val);
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              if (linkCalc == '>') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (inputs_val > valueLink[m].rule.split('::')[1]) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }

                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal > nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).get(0).checked = true;
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              } else {
                // <=
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (inputs_val >= valueLink[m].rule.split('::')[1]) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal >= nowVals && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).attr('checked', false);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).attr('checked', true);
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              }
              // }
            }
          } else {
            // 含有最大值
            if ($('#selectMup_' + linkNo_1).prop('tagName') == 'SPAN') {
              // 下拉多选类型
              var linkChangeSelect = $('#selectMup_' + linkNo_1).children('div'); //联动元素
              var showVal = []; //显示值
              for (var j = 0; j < linkChangeSelect.length; j++) {
                var inputs_val = $(linkChangeSelect[j])
                    .children('input')
                    .val();
                if (linkCalc == '>') {
                  if (inputs_val == objVal && inputs_val > nowVals && inputs_val < maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                } else {
                  if (inputs_val == objVal && inputs_val >= nowVals && inputs_val <= maxVal) {
                    $(linkChangeSelect[j])
                        .children('input')
                        .get(0).checked = false;
                    selectMcheck($(linkChangeSelect[j]).children('span'), linkNo_1, true);
                  }
                }
              }
              for (var w = 0; w < linkChangeSelect.length; w++) {
                if (
                    $(linkChangeSelect[w])
                        .children('input')
                        .get(0).checked
                ) {
                  showVal.push(
                      $(linkChangeSelect[w])
                          .children('span')
                          .text()
                  );
                }
              }
              var targetSelectVal = showVal.join(',');
              $('#create_' + linkNo_1).val(targetSelectVal);
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'SELECT' ||
                ($('#create_' + linkNo_1).prop('tagName') == 'INPUT' && $('#create_' + linkNo_1).attr('type') != 'radio')
            ) {
              if (linkCalc == '>') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].rule.split('::')[1] < inputs_val &&
                          inputs_val < valueLink[m].maxRule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                if (chackArr.length == 0) {
                  $('#create_' + linkNo_1).val('');
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                } else {
                  // 去重
                  var result = [];
                  var obj = {};
                  for (var l = 0; l < chackArr.length; l++) {
                    if (!obj[chackArr[l].val]) {
                      result.push(chackArr[l]);
                      obj[chackArr[l].val] = true;
                    }
                  }
                  chackArr = result;
                  // 判断选中的是否还有符合条件的
                  for (var p = 0; p < chackArr.length; p++) {
                    $('#create_' + chackArr[p].no).val(chackArr[p].val);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              } else {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                // 判断是否还有其他校验同时联动条件
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].rule.split('::')[1] <= inputs_val &&
                          inputs_val <= valueLink[m].maxRule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                if (chackArr.length == 0) {
                  $('#create_' + linkNo_1).val('');
                  $('#create_' + linkNo_1).change();
                  $('#create_' + linkNo_1).blur();
                } else {
                  // 去重
                  var result = [];
                  var obj = {};
                  for (var l = 0; l < chackArr.length; l++) {
                    if (!obj[chackArr[l].val]) {
                      result.push(chackArr[l]);
                      obj[chackArr[l].val] = true;
                    }
                  }
                  chackArr = result;
                  // 判断选中的是否还有符合条件的
                  for (var p = 0; p < chackArr.length; p++) {
                    $('#create_' + chackArr[p].no).val(chackArr[p].val);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                }
              }
            } else if (
                $('#create_' + linkNo_1).prop('tagName') == 'INPUT' &&
                $('#create_' + linkNo_1).attr('type') == 'radio'
            ) {
              var inputs_radio = $('.create_' + linkNo_1);
              if (linkCalc == '>') {
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].maxRule.split('::')[1] > inputs_val &&
                          inputs_val > valueLink[m].rule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }

                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal > nowVals && objVal < maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).get(0).checked = false;
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).get(0).checked = true;
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              } else {
                // <=
                var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
                var chackArr = [];
                for (var u = 0; u < linkChangeSelect.length; u++) {
                  var inputs_val = $(linkChangeSelect[u])
                      .children('input')
                      .val();
                  if (
                      $(linkChangeSelect[u])
                          .children('input')
                          .get(0).checked
                  ) {
                    for (var m = 0; m < valueLink.length; m++) {
                      if (
                          valueLink[m].maxRule.split('::')[1] >= inputs_val &&
                          inputs_val >= valueLink[m].rule.split('::')[1]
                      ) {
                        chackArr.push({
                          val: valueLink[m].val,
                          no: valueLink[m].no,
                        });
                      }
                    }
                  }
                }
                // 判断条件是否有其他选中关联
                for (var y = 0; y < inputs_radio.length; y++) {
                  if (objVal >= nowVals && objVal <= maxVal && $(inputs_radio[y]).attr('value') == valueLink[n].val) {
                    $(inputs_radio[y]).attr('checked', false);
                    $('#create_' + linkNo_1).change();
                    $('#create_' + linkNo_1).blur();
                  }
                  for (var l = 0; l < chackArr.length; l++) {
                    if (chackArr[l].no == linkNo_1 && $(inputs_radio[y]).attr('value') == chackArr[l].val) {
                      $(inputs_radio[y]).attr('checked', true);
                      $('#create_' + linkNo_1).change();
                      $('#create_' + linkNo_1).blur();
                    }
                  }
                }
              }
              // }
            }
          }
        }
      } else if (valueLink[n].type == 'hide' || valueLink[n].type == 'disabled') {
        // 隐藏，显示，不可用
        var linkCalc = valueLink[n].oper;
        var nowVals = valueLink[n].rule.split('::')[1];
        if (valueLink[n].hide.indexOf('#{') == -1) {
          if (valueLink[n].hide || valueLink[n].type == 'disabled') {
            var linkNo_1 = valueLink[n].hide;
          } else {
            var linkNo_1 = valueLink[n].show;
          }
        } else {
          if (valueLink[n].hide || valueLink[n].type == 'disabled') {
            var linkNo_1 = valueLink[n].hide.split('#{')[1].split('}')[0];
          } else {
            var linkNo_1 = valueLink[n].show.split('#{')[1].split('}')[0];
          }
        }
        if (linkCalc == '==') {
          if (objVal == nowVals) {
            if (valueLink[n].hide) {
              $('#item' + linkNo_1).show();
            } else if (valueLink[n].show) {
              $('#item' + linkNo_1).hide();
            } else {
              $('#item' + linkNo_1).attr('disabled', false);
            }
          }
        } else if (linkCalc == '<' || linkCalc == '<=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
            var chackArr = [];
            // 判断是否还有其他校验同时联动条件
            for (var u = 0; u < linkChangeSelect.length; u++) {
              var inputs_val = $(linkChangeSelect[u])
                  .children('input')
                  .val();
              if (
                  $(linkChangeSelect[u])
                      .children('input')
                      .get(0).checked
              ) {
                for (var m = 0; m < valueLink.length; m++) {
                  if (linkCalc == '<') {
                    if (valueLink[m].rule.split('::')[1] > inputs_val) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  } else {
                    if (valueLink[m].rule.split('::')[1] >= inputs_val) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  }
                }
              }
            }
            if (chackArr.length == 0) {
              if (valueLink[n].hide) {
                $('#item' + linkNo_1).show();
              } else if (valueLink[n].show) {
                $('#item' + linkNo_1).hide();
              } else {
                $('#item' + linkNo_1).attr('disabled', false);
              }
            } else {
              // 去重
              var result = [];
              var obj = {};
              for (var l = 0; l < chackArr.length; l++) {
                if (!obj[chackArr[l].val]) {
                  result.push(chackArr[l]);
                  obj[chackArr[l].val] = true;
                }
              }
              chackArr = result;
              // 判断选中的是否还有符合条件的
              for (var p = 0; p < chackArr.length; p++) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          } else {
            // 含有最大值
            var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
            var chackArr = [];
            // 判断是否还有其他校验同时联动条件
            for (var u = 0; u < linkChangeSelect.length; u++) {
              var inputs_val = $(linkChangeSelect[u])
                  .children('input')
                  .val();
              if (
                  $(linkChangeSelect[u])
                      .children('input')
                      .get(0).checked
              ) {
                for (var m = 0; m < valueLink.length; m++) {
                  if (linkCalc == '<') {
                    if (
                        valueLink[m].rule.split('::')[1] > inputs_val &&
                        inputs_val < valueLink[m].maxRule.split('::')[1]
                    ) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  } else {
                    if (
                        valueLink[m].rule.split('::')[1] >= inputs_val &&
                        inputs_val <= valueLink[m].maxRule.split('::')[1]
                    ) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  }
                }
              }
            }
            if (chackArr.length == 0) {
              if (valueLink[n].hide) {
                $('#item' + linkNo_1).show();
              } else if (valueLink[n].show) {
                $('#item' + linkNo_1).hide();
              } else {
                $('#item' + linkNo_1).attr('disabled', false);
              }
            } else {
              // 去重
              var result = [];
              var obj = {};
              for (var l = 0; l < chackArr.length; l++) {
                if (!obj[chackArr[l].val]) {
                  result.push(chackArr[l]);
                  obj[chackArr[l].val] = true;
                }
              }
              chackArr = result;
              // 判断选中的是否还有符合条件的
              for (var p = 0; p < chackArr.length; p++) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          }
        } else if (linkCalc == '>' || linkCalc == '>=') {
          var maxOper = valueLink[n].maxOper;
          var maxVal = valueLink[n].maxRule.split('::')[1];
          if (!maxOper) {
            var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
            var chackArr = [];
            // 判断是否还有其他校验同时联动条件
            for (var u = 0; u < linkChangeSelect.length; u++) {
              var inputs_val = $(linkChangeSelect[u])
                  .children('input')
                  .val();
              if (
                  $(linkChangeSelect[u])
                      .children('input')
                      .get(0).checked
              ) {
                for (var m = 0; m < valueLink.length; m++) {
                  if (linkCalc == '>') {
                    if (valueLink[m].rule.split('::')[1] < inputs_val) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  } else {
                    if (valueLink[m].rule.split('::')[1] <= inputs_val) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  }
                }
              }
            }
            if (chackArr.length == 0) {
              if (valueLink[n].hide) {
                $('#item' + linkNo_1).show();
              } else if (valueLink[n].show) {
                $('#item' + linkNo_1).hide();
              } else {
                $('#item' + linkNo_1).attr('disabled', false);
              }
            } else {
              // 去重
              var result = [];
              var obj = {};
              for (var l = 0; l < chackArr.length; l++) {
                if (!obj[chackArr[l].val]) {
                  result.push(chackArr[l]);
                  obj[chackArr[l].val] = true;
                }
              }
              chackArr = result;
              // 判断选中的是否还有符合条件的
              for (var p = 0; p < chackArr.length; p++) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          } else {
            // 含有最大值
            var linkChangeSelect = $('#selectMup_' + id).children('div'); //联动元素
            var chackArr = [];
            // 判断是否还有其他校验同时联动条件
            for (var u = 0; u < linkChangeSelect.length; u++) {
              var inputs_val = $(linkChangeSelect[u])
                  .children('input')
                  .val();
              if (
                  $(linkChangeSelect[u])
                      .children('input')
                      .get(0).checked
              ) {
                for (var m = 0; m < valueLink.length; m++) {
                  if (linkCalc == '>') {
                    if (
                        valueLink[m].rule.split('::')[1] < inputs_val &&
                        inputs_val < valueLink[m].maxRule.split('::')[1]
                    ) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  } else {
                    if (
                        valueLink[m].rule.split('::')[1] <= inputs_val &&
                        inputs_val <= valueLink[m].maxRule.split('::')[1]
                    ) {
                      chackArr.push({
                        val: valueLink[m].val,
                        no: valueLink[m].no,
                      });
                    }
                  }
                }
              }
            }
            if (chackArr.length == 0) {
              if (valueLink[n].hide) {
                $('#item' + linkNo_1).show();
              } else if (valueLink[n].show) {
                $('#item' + linkNo_1).hide();
              } else {
                $('#item' + linkNo_1).attr('disabled', false);
              }
            } else {
              // 去重
              var result = [];
              var obj = {};
              for (var l = 0; l < chackArr.length; l++) {
                if (!obj[chackArr[l].val]) {
                  result.push(chackArr[l]);
                  obj[chackArr[l].val] = true;
                }
              }
              chackArr = result;
              // 判断选中的是否还有符合条件的
              for (var p = 0; p < chackArr.length; p++) {
                if (valueLink[n].hide) {
                  $('#item' + linkNo_1).hide();
                } else if (valueLink[n].show) {
                  $('#item' + linkNo_1).show();
                } else {
                  $('#item' + linkNo_1).attr('disabled', true);
                }
              }
            }
          }
        }
      }
    }
    for (var i = 0; i < selectedlist.length; i++) {
      if (selectedlist[i] == objVal) {
        selectedlist.splice(i, 1);
        selectednamelist.splice(i, 1);
      }
    }
  }
  var selectVal = selectednamelist.join(',');
  $('#create_' + id).val(selectVal);
}

// 点文字选择单选或复选框
function choose(inputObj) {
  if ($(inputObj).attr('disabled')) {
    return;
  }
  var type = $(inputObj)
      .attr('type')
      .toLowerCase();
  var checked = $(inputObj).get(0).checked;
  if (type == 'radio') {
    $(inputObj).get(0).checked = true;
  } else if (type == 'checkbox') {
    $(inputObj).get(0).checked = !checked;
    var boxs = $('input[name=' + $(inputObj).attr('name') + ']:checked');
    // console.log(boxs);
    var flag = false;
    for (var k = 0; k < boxs.length; k++) {
      if (boxs[k].value === 'UTD' && boxs.length > 1) {
        flag = true;
        break;
      }
    }
    if (flag) {
      // 多选时选择了冲突选项则弹出提示
      handleCheckboxWidthUTD(inputObj);
    }
  }
  $(inputObj).change();
  $(inputObj).blur();
}

// 标识当前执行是否是导入数据
var isImport = false;
// 初始化联动校验
function checkInit() {
  for (var i = 0; i < linkAndCheckList.length; i++) {
    getRuleVal(linkAndCheckList[i].rule, linkAndCheckList[i].fun);
  }
  linkAndCheckList = [];
}

// 添加初始化的监听器
function addInitListener(json) {
  var init = json.init;
  var rule = base64.decode(init.rule);
  // var rules = rule.split('::');
  var rules = rule.split(/[\+\-\*\/\&\|\~\>>\<<\%::]/);
  for (var i = 0; i < rules.length; i++) {
    var index = rules[i].indexOf('#{');
    if (index != -1) {
      no1 = rules[i].substring(index + 2, rules[i].indexOf('}'));
      var fun = $('#create_' + no1).attr('onblur');
      var newFun =
          'doInitVal("' +
          json.no +
          '", "' +
          init.type +
          '", "' +
          init.rule +
          '", "' +
          init.unit +
          '", "' +
          init.decimal +
          '");';
      if (!fun) {
        fun = '';
      } else {
        fun = fun.charAt(fun.length - 1) == ';' ? fun : fun + ';';
      }
      if (fun.indexOf(newFun) == -1) {
        fun += newFun;
      }
      // 处理单选框id相同问题
      if ($('.create_' + no1).length > 1) {
        for (var j = 0; j < $('.create_' + no1).length; j++) {
          $($('.create_' + no1)[j]).attr('onblur', fun);
        }
      } else {
        $('#create_' + no1).attr('onblur', fun);
      }
    }
  }

  $('.create_' + json.no).focus(function() {
    try {
      doInitVal(json.no, init.type, init.rule, init.unit, init.decimal);
    } catch (err) {
      console.log('编号：' + json.no + '执行focus初始化值时发生错误，可能由于初始化操作过早，开启延迟初始化\n', err);
      setTimeout(function() {
        try {
          doInitVal(json.no, init.type, init.rule, init.unit, init.decimal);
          console.log('编号：' + json.no + '延迟初始化执行成功');
        } catch (err) {
          console.log('编号：' + json.no + '执行focus初始化值时发生错误，延迟初始化也发生错误，终止初始化操作\n', err);
        }
      }, 1500);
    }
  });
}

// 执行初始化
function doInitVal(no, type, rule, unit, decimal) {
  rule = base64.decode(rule);
  var rules = rule.split('::');
  var result = execCalc(rules[0], rules[2], rules[1], unit, type, decimal);
  var ele = $('.create_' + no);
  if (ele.is('input[type=radio]')) {
    var obj = ele.filter('input[value=' + result + ']').get(0);
    if (obj) {
      obj.checked = true;
      $(obj).change();
      $(obj).blur();
    }
  } else if (ele.is('input[type=checkbox]')) {
    var vals = result.split(',');
    for (var i = 0; i < vals; i++) {
      var obj = ele.filter('input[value=' + result + ']').get(0);
      if (obj) {
        obj.checked = true;
        $(obj).change();
        $(obj).blur();
      }
    }
  } else {
    $('#create_' + no).val(result);
    $('#create_' + no).change();
    $('#create_' + no).blur();
  }
}

/** 规则计算 */
function execCalc(val1, val2, oper, unit, type, decimal) {
  var val1 = getRuleVal(val1);
  var val2 = getRuleVal(val2);
  var result;
  if (!val1) {
    return val2;
  }
  if (!val2) {
    return val1;
  }
  var date1, date2;
  if (!type) {
    type = 'text';
    if (!isNaN(val1 * 1) && !isNaN(val2 * 1)) {
      type = 'num';
    } else if (val1.trim() == '' || val2.trim() == '') {
      type = 'text';
    } else {
      date1 = new Date(parseDateStr(val1));
      date2 = new Date(parseDateStr(val2));
      if (date1 && date2) {
        if (!isNaN(date1.getTime()) && !isNaN(date2.getTime())) {
          type = 'date';
        }
      }
    }
  }
  if (type == 'num') {
    try {
      result = eval(val1 + oper + val2);
    } catch (err) {
      return;
    }
  } else if (type == 'text') {
    result = val1 + val2;
  } else if (type == 'date') {
    if (!date1 || !date2) {
      date1 = new Date(parseDateStr(val1));
      date2 = new Date(parseDateStr(val2));
    }
    var time1 = date1.getTime();
    var time2 = date2.getTime();
    result = time1 - time2;
    switch (unit) {
      case 'y': {
        result = date1.getYear() - date2.getYear();
        break;
      }
      case 'm': {
        result = parseInt((date1.getYear() - date2.getYear()) * 12) + parseInt(date1.getMonth() - date2.getMonth());
        break;
      }
      case 'd': {
        if (result < 1) {
          result = 1;
        } else {
          result = Math.round(result / (24 * 3600 * 1000));
        }
        // result =
        //   parseInt((time1 + 8 * 1000 * 3600) / (1000 * 3600 * 24)) -
        //   parseInt((time2 + 8 * 1000 * 3600) / (1000 * 3600 * 24));
        break;
      }
      case 'h': {
        result = parseInt(time1 / (1000 * 3600)) - parseInt(time2 / (1000 * 3600));
        break;
      }
      case 'min': {
        result = parseInt(time1 / (1000 * 60)) - parseInt(time2 / (1000 * 60));
        break;
      }
      case 's': {
        result = parseInt(time1 / 1000) - parseInt(time2 / 1000);
        break;
      }
      case 'ms': {
        result = time1 - time2;
        break;
      }
    }
    result = parseInt(result);
  }
  if (unit == 'integer') {
    result = parseInt(result);
  }
  if (isNaN(decimal * 1)) {
    decimal = 0;
    var reg = /^[A-Za-z]*$/;
    var reg_1 = /^[0-9]+\.?[0-9]+?$/;
    // 校验是否为小数
    if (!reg.test(result) && reg_1.test(result)) {
      result = result.toFixed(2);
    }
  } else {
    result = result.toFixed(decimal);
  }
  return result;
}
// :出现的次数
function colonAppearFrequency(val) {
  var vals = val.split('');
  var num = 0;
  for (var i = 0; i < vals.length; i++) {
    if (vals[i] == ':') {
      num++;
    }
  }
  return num;
}
// 补填时间格式
function parseDateStr(val1, str) {
  if (str) {
    // 补填时分秒
    var val2;
    var date = new Date();
    var m = date.getMinutes(); //获取当前分钟数(0-59)
    if (m < 10) {
      m = '0' + m;
    }
    var s = date.getSeconds(); //获取当前秒数(0-59)
    if (s < 10) {
      s = '0' + s;
    }
    if (val1.indexOf('-') == -1) {
      val2 = getNowFormatDate('date') + ' ' + val1;
    } else if (val1.indexOf(':') == -1 && val1.indexOf(' ') == -1) {
      val2 = val1 + ' 00:00:00';
    } else if (colonAppearFrequency(val1) == 0) {
      val2 = val1 + ':' + m + ':' + s;
    } else if (colonAppearFrequency(val1) == 1) {
      val2 = val1 + ':' + s;
    } else {
      val2 = val1;
    }
    val2 = val2.replace(new RegExp('-', 'gm'), '/');
    return val2;
  }
  if (val1.indexOf('-') == -1) {
    val1 = getNowFormatDate('date') + ' ' + val1;
  } else if (val1.indexOf(':') == -1 && val1.indexOf(' ') == -1) {
    val1 = val1 + ' 00:00:00';
  } else if (colonAppearFrequency(val1) == 0) {
    val1 = val1 + ':00:00';
  } else if (colonAppearFrequency(val1) == 1) {
    val1 = val1 + ':00';
  }
  val1 = val1.replace(new RegExp('-', 'gm'), '/');
  var date1 = new Date(val1);
  return date1;
}

// 根据规则编码获取对应元素的值，例如：#{编号}#{date}
function getRuleVal(rule, linkAndCheckCallback) {
  if (!rule) {
    return rule;
  }
  var index;
  rule = rule.replace('#{date}', getNowFormatDate('date'));
  rule = rule.replace('#{time}', getNowFormatDate('time'));
  rule = rule.replace('#{datetime}', getNowFormatDate('datetime'));
  rule = rule.replace('#{datehourtime}', getNowFormatDate('datetime'));
  rule = rule.replace('#{datehour}', getNowFormatDate('datetime'));
  while ((index = rule.indexOf('#{')) != -1) {
    var no = rule.substring(index + 2, rule.indexOf('}'));
    if (document.getElementById('create_' + no)) {
      var tagName = document.getElementById('create_' + no).tagName.toLowerCase();
      if (
          tagName == 'input' &&
          ($('#create_' + no).attr('type') == 'radio' || $('#create_' + no).attr('type') == 'checkbox')
      ) {
        var objs = $('input[name=' + $('#create_' + no).attr('name') + ']:checked');
        if (objs.length > 0 || objs.val() === undefined) {
          rule = rule.replace('#{' + no + '}', objs.val() ? objs.val() : '');
        }
      } else {
        rule = rule.replace('#{' + no + '}', $('#create_' + no).get(0).value);
      }
      if (linkAndCheckCallback) {
        linkAndCheckCallback(no);
      }
    } else {
      console.log('校验规则为:', rule, '编号为：', no);
      return null;
    }
  }
  return rule;
}

// 生成模版数据
function doSubmit() {
  var jsonObj = getJsonObj();
  var jsonStr = JSON.stringify(jsonObj);
  console.log(jsonStr);
  return jsonStr;
}

/** 获取模版页中模版数据 */
function getJsonObj() {
  var json = getSlotItem($('#contend'));
  return json;
}

/** 遍历生成模版数据 */
function getSlotItem(obj) {
  var json = {};

  // 遍历数据
  var vals = [];
  var sonList = $(obj).children('.slot-item');
  if (sonList.length == 0) {
    if ($(obj).hasClass('slot-item')) {
      sonList.push($(obj));
    } else {
      return vals;
    }
  }
  for (var i = 0; i < sonList.length; i++) {
    var once = $(sonList[i]);
    // 处理每个控件json
    if (once.hasClass('slot-item')) {
      var idNum = once.attr('idNum');
      var jsonStr = $('#jsonVal' + idNum).get(0).value;
      if (jsonStr) {
        var json = JSON.parse(jsonStr);
      }
      // 遍历可能在item下存在的容器
      var result = getSlotItem(once.children('.slot-list'));
      if (result && result.length > 0) {
        while (result[0].constructor == Array && result.length == 1) {
          console.log('迭代一层');
          result = result[0];
        }
        json.sonList = result;
      }
      vals.push(json);
    }
    // 处理每个可能存在的容器
    else {
      var result = getSlotItem(once);
      if (result && result.length > 0) {
        vals.push(result);
      }
    }
  }
  return vals;
}

/** 依据json创建页面 */
function createPage(jsonStr, callback) {
  isImport = true;
  var json = jsonStr;
  if (typeof jsonStr == 'string') {
    json = JSON.parse(jsonStr);
  }
  // return false
  $('#contend')
      .children()
      .remove();
  for (var i = 0; i < json.length; i++) {
    createElement(json[i], $('#contend'), callback);
  }
  isImport = false;
  checkInit();
}
// 初始化属性框中的显示
function attrInit() {
  $('#pop-content-02 tr').hide();
  $('#tr_select').show();
  $('#tr_check').show();
  //	$("#create_type").attr("disabled", false);
  $('#tr_no').show();
  $('#tr_box_line').hide();
}
// 页面初始化时的属性框显示
function attrPageInit() {
  attrInit();
  $('#tr_title').show();
  $('#tr_submitName').show();
  $('#tr_titleMsg').show();
  $('#tr_link').show();
  $('#tr_init').show();
}
attrPageInit();

// 处理新增/修改的弹出窗
function modifyCreate(type, json) {
  attrInit();
  if (json) {
    var json_no = json.no;
    $('#create_no').text(json_no);
  }
  var checkType = $('#create_check_type').val();
  // 补填验证数据
  $('#create_check_list')
      .children()
      .remove();
  $('#create_check_type option[value=num]').remove();
  if ($('#create_check_type option[value=calc]').length == 0) {
    $('#create_check_type').append('<option value="calc">计算</option>');
  }
  if (json && json.check) {
    document.getElementById('create_check_notnull').checked = json.check.notnull ? json.check.notnull : false;
    checkType = json.check.type;
    for (var i = 0; i < json.check.list.length; i++) {
      var option = json.check.list[i];
      addCheck(option);
    }
  } else {
    checkType = 'normal';
  }
  modifyLinkView();
  // 按类型处理新增/修改弹出框
  switch (type) {
    case 'text':
    case 'number':
    case 'date':
    case 'time':
    case 'datehour':
    case 'datehourtime':
    case 'datetime': {
      $('#tr_title').show();
      $('#tr_submitName').show();
      $('#tr_link').show();
      $('#tr_init').show();
      $('#tr_titleMsg').show();
      $('#tr_create_api_remark').show();
      if (type === 'text' || type === 'number') {
        $('#tr_create_board').show();
      }
      if (type === 'date' || type === 'time' || type === 'datetime' || type === 'datehour' || type === 'datehourtime') {
        $('#tr_dateFormat').show();
      }
      if (json) {
        $('#create_type').val(json.type);
        $('#create_title').val(json.title);
        $('#create_submitName').val(json.submitName);
        $('create_dateFormat').val(json.format);
        if (json.titleMsg) {
          $('#create_titleMsg').val(base64.decode(json.titleMsg));
        }
        //				$("#create_type").attr("disabled", true);
        $('#modify_no').val(json.no);
      }
      break;
    }
    case 'span':
    case 'box':
    case 'box1': {
      $('#tr_title').show();
      $('#tr_check').hide();
      $('#tr_box_line').show();
      if (json) {
        $('#create_type').val(json.type);
        $('#create_title').val(json.title);
        //				$("#create_type").attr("disabled", true);
        $('#modify_no').val(json.no);
        document.getElementById('create_box_line').checked = json.line ? true : false;
      }
      break;
    }

    case 'checkbox': {
      var doc = '<option value="num">选择数(仅限复选框)</option>';
      $('#create_check_type').append(doc);
      $('#tr_select_multiple').show();
      $('#create_select_multiple').get(0).checked = json ? json.selectMultiple : false;
      break;
    }
    case 'radio': {
      $('#tr_pointsort').show();
      $('#tr_textsort').show();
      if (checkType == 'calc') {
        checkType = 'reg';
      }
      $('#create_check_type option[value=calc]').remove();
      if (json) {
        var textsort = $("input[name='create_textsort']");
        if ($(textsort[1]).val() == json.textsort) {
          $(textsort[1]).attr('checked', 'checked');
        } else {
          $(textsort[0]).attr('checked', 'checked');
        }

        var pointsort = $("input[name='create_pointsort']");
        if ($(pointsort[1]).val() == json.pointsort) {
          $(pointsort[1]).attr('checked', 'checked');
        } else {
          $(pointsort[0]).attr('checked', 'checked');
        }
      }
      break;
    }
    case 'select': {
      $('#tr_select_list').show();
      $('#tr_title').show();
      $('#tr_select_remark').show();
      $('#tr_select_val').show();
      $('#tr_submitName').show();
      $('#tr_select_json').show();
      $('#tr_link').show();
      $('#tr_init').show();
      $('#tr_create_api_remark').show();
      if (type === 'select') {
        $('#tr_create_board').show();
      }
      if (json) {
        $('#create_type').val(json.type);
        $('#create_title').val(json.title);
        $('#create_select_list')
            .children()
            .remove();
        //				$("#create_type").attr("disabled", true);
        $('#modify_no').val(json.no);
        $('#create_submitName').val(json.submitName);
        var values = json.values;
        if (values) {
          $('#create_select_json').val(JSON.stringify(values));
          addSelect(values);
        }
      }
      break;
    }
    case 'img': {
      $('#tr_submitName').show();
      $('#tr_saveAddress').show();
      $('#tr_title').show();
      $('#tr_fileImg').show();
      $('#tr_imgSize').show();
      $('#tr_imgNumber').show();
      $('#tr_imgMaxNum').show();
      $('#tr_submitImg').show();
      $('#tr_field').show();
      if (json) {
        $('#create_type').val(json.type);
        $('#create_title').val(json.title);
        $('#create_submitName').val(json.submitName);
        json.saveAddress && $('#create_saveAddress').val(base64.decode(json.saveAddress));
        $('#create_imgSize').val(json.imgSize);
        $('#create_imgNumber').val(json.imgNumber);
        $('#modify_no').val(json.no);
        $('#create_imgMaxNum').val(json.imgMaxNum);
        $('#create_submitImg').val(json.submitImg);
        $('#create_field').val(json.field);
      }
      break;
    }
  }
  modifyCheckView(checkType);
  $('#create_link_list')
      .children()
      .remove();
  $('#create_api_remark').val('');
  if (json) {
    // 只读与隐藏
    document.getElementById('create_disabled').checked = json.disabled;
    document.getElementById('create_hide').checked = json.hide;
    document.getElementById('create_board').checked = json.board;
    if (json.link) {
      addLink(json.link.type, json.link);
      modifyLinkView(json.link.type);
    }

    if (json.init) {
      decimalChange(json.init.unit); //显示小数位数输入框

      modifyInitView(json.init.type, json.init);
    } else {
      modifyInitView('normal');
    }

    if (json.apiRemark) {
      $('#create_api_remark').val(base64.decode(json.apiRemark));
    }
  }
}

// 添加下拉列表
function addSelect(optionList) {
  if (!optionList) {
    optionList = [];
    var allJson = $('#create_select_json')
        .val()
        .trim();
    if (allJson == '') {
      var option = {
        val: $('#create_select_val').val(),
        remark: $('#create_select_remark').val(),
      };
      optionList.push(option);
    } else {
      optionList = eval(allJson);
    }
  }
  // 循环添加
  for (var a = 0; a < optionList.length; a++) {
    var option = optionList[a];
    var list = $('#create_select_list').children('option');
    // 校验相同进行修改
    if (list && list.length > 0) {
      for (var i = 0; i < list.length; i++) {
        if ($(list[i]).val() == option.val || $(list[i]).text() == option.remark) {
          $(list[i]).attr('value', option.val);
          $(list[i]).text(option.remark);
          $(list[i]).remove();
          $(list[0]).before(list[i]);
          return;
        }
      }
    }
    var doc = '<option value="' + option.val + '" ';
    doc += 'onDblClick="$(this).remove()" ';
    doc += 'onClick="doSelectReview(this)">';
    doc += option.remark;
    doc += '</option>';
    $('#create_select_list').append(doc);
  }
}

/** 重置下拉列表 */
function doSelectReview(obj) {
  var title = $(obj).text();
  $('#create_select_val').val($(obj).val());
  $('#create_select_remark').val($(obj).text());
}
/** 重置联动列表 */
function doLinkReview(obj) {
  $('#create_link_type').val($(obj).attr('type'));
  $('#create_link_operator').val($(obj).attr('oper'));
  $('#create_link_max_operator').val($(obj).attr('maxOper'));
  var values = $(obj)
      .val()
      .split('::');
  $('#create_link_value').val(values[1]);
  var maxValues = $(obj).attr('maxValue')
      ? $(obj)
          .attr('maxValue')
          .split('::')
      : ['', ''];
  $('#create_link_max_value').val(maxValues[1]);
  if ($(obj).attr('type') == 'reset') {
    $('#tr_link_hide').hide();
    $('#tr_link_view').hide();
    $('#tr_link_reset').show();
    $('#create_link_reset_val').val($(obj).attr('val'));
    $('#create_link_reset_no').val($(obj).attr('no'));
  } else {
    $('#tr_link_hide').show();
    $('#tr_link_view').show();
    $('#tr_link_reset').hide();
    $('#create_link_hide').val($(obj).attr('hide'));
    $('#create_link_show').val($(obj).attr('show'));
  }
}

// 折叠框自动校验
function box1FinishAction(obj, no) {
  $('#create_' + no)
      .find('input')
      .addClass('checkElement');
  $('#create_' + no)
      .find('select')
      .addClass('checkElement');
  var divs = $('#create_' + no).find('div');
  for (var i = 0; i < divs.length; i++) {
    if ($(divs[i]).css('display') == 'none') {
      $(divs[i])
          .find('input')
          .removeClass('checkElement');
      $(divs[i])
          .find('select')
          .removeClass('checkElement');
    }
  }

  var checkObjs = $('.checkElement');
  for (var j = 0; j < checkObjs.length; j++) {
    var changeVals = ($(checkObjs[j]).attr('onchange') || '').split(';');
    var blurVals = ($(checkObjs[j]).attr('onblur') || '').split(';');
    var checkVal = '';
    for (var i = 0; i < changeVals.length; i++) {
      if (changeVals[i].trim() && changeVals[i].trim().startsWith('doCheck')) {
        checkVal += changeVals[i] + ';';
      }
      if (changeVals[i].trim() && changeVals[i].trim().startsWith('hideEle')) {
        checkVal += changeVals[i] + ';';
      }
    }
    for (var i = 0; i < blurVals.length; i++) {
      if (blurVals[i].trim() && blurVals[i].trim().startsWith('doCheck')) {
        checkVal += blurVals[i] + ';';
      }
    }
    $(checkObjs[j]).attr('ondblclick', checkVal);
  }
  $('.checkElement').dblclick();
  $('.checkElement').removeAttr('ondblclick');

  for (var i = 0; i < divs.length; i++) {
    if ($(divs[i]).css('display') == 'none') {
      $(divs[i])
          .find('.error')
          .remove();
    }
  }
  var errors = $('#create_' + no).find('.error');
  var errorsItem = $('#create_' + no).find('.sp-error'); //PIP、EAR校验身份证号必填
  if (errors.length > 0 || errorsItem.length > 0) {
    $(obj)
        .parent()
        .css('color', 'red');
  } else {
    $(obj)
        .parent()
        .css('color', 'green');
  }
  $('.checkElement').removeClass('checkElement');
}
function upload(json) {
  layui.use('upload', function() {
    var $ = layui.jquery,
        upload = layui.upload;
    var address = json.saveAddress ? base64.decode(json.saveAddress) : '';
    //多图片上传
    upload.render({
      elem: '#btn_' + json.no,
      url: '/' + address,
      size: json.imgSize,
      number: json.imgNumber,
      multiple: true,
      acceptMime: 'image/jpg',
      field: json.submitImg,
      before: function(obj) {
        // layer.load();
        //预读本地文件示例，不支持ie8
        obj.preview(function(index, file, result) {
          if ($('#upload_' + json.no).find('.layui-upload-img').length >= Number(json.imgMaxNum)) {
            return;
          }
          $('#upload_' + json.no).attr('submitName', json.submitName);
          $('#upload_' + json.no).append(
              `<div class="preview-img"><span class="closeImg close-${index}">x</span>
								<img onclick="previewHandle(this)" src="${result}" alt="${file.name}" class="layui-upload-img">
						</div>`
          );
          // $('#upload_' + json.no).append('<div class="preview-img"><img src="' + result + '" alt="' + file.name + '" class="layui-upload-img"></div>')
        });
      },
      done: function(res, index) {
        //上传成功
        if (getField(res, json.field)) {
          $('.close-' + index + '').attr('data-name', getField(res, json.field));
        } else {
          layer.msg('上传失败,请重新上传');
          $('.close-' + index + '')
              .parent('.preview-img')
              .remove();
        }
      },
      error: function(index) {
        layer.msg('上传失败,请重新上传');
        $('.close-' + index + '')
            .parent('.preview-img')
            .remove();
      },
      //超出限制数据量隐藏上传按钮
      allDone: function() {
        if ($('#upload_' + json.no).find('.layui-upload-img').length >= Number(json.imgMaxNum)) {
          $('#btn_' + json.no).css('display', 'none');
        }
      },
    });
    // 删除图片后显示上传按钮
    $(document).on('click', '.closeImg', function() {
      $(this)
          .parent('div')
          .remove();
      if ($('#upload_' + json.no).find('.layui-upload-img').length < Number(json.imgMaxNum)) {
        $('#btn_' + json.no).css('display', 'block');
      }
    });
  });
}
// 递归获取返回字段
function getField(obj, field) {
  for (var i in obj) {
    if (typeof obj[i] === 'object') {
      getField(obj[i]);
    } else {
      if (i === field) {
        return obj[i];
      }
    }
  }
}
// 预览图片方法
function previewHandle(dom) {
  $('#contend')
      .append(`<div id="outerdiv" style="position:fixed;top:0;left:0;background:rgba(0,0,0,0.7);z-index:9000;width:100%;height:100%;display:none;">
    <div id="innerdiv" style="position:absolute;">
      <img id="bigimg" src="" />
    </div>
  </div>`);
  imgShow('#outerdiv', '#innerdiv', '#bigimg', $(dom));
  $('#outerdiv').click(function() {
    $(this).hide();
  });
}
//图片放大
function imgShow(outerdiv, innerdiv, bigimg, _this) {
  var src = _this.attr('src'); //获取当前点击的pimg元素中的src属性
  $(bigimg).attr('src', src); //设置#bigimg元素的src属性
  /*获取当前点击图片的真实大小，并显示弹出层及大图*/
  $('<img/>')
      .attr('src', src)
      .load(function() {
        var windowW = $(window).width(); //获取当前窗口宽度
        var windowH = $(window).height(); //获取当前窗口高度
        var realWidth = this.width; //获取图片真实宽度
        var realHeight = this.height; //获取图片真实高度
        var imgWidth, imgHeight;
        var scale = 0.8; //缩放尺寸，当图片真实宽度和高度大于窗口宽度和高度时进行缩放

        if (realHeight > windowH * scale) {
          //判断图片高度
          imgHeight = windowH * scale; //如大于窗口高度，图片高度进行缩放
          imgWidth = (imgHeight / realHeight) * realWidth; //等比例缩放宽度
          if (imgWidth > windowW * scale) {
            //如宽度扔大于窗口宽度
            imgWidth = windowW * scale; //再对宽度进行缩放
          }
        } else if (realWidth > windowW * scale) {
          //如图片高度合适，判断图片宽度
          imgWidth = windowW * scale; //如大于窗口宽度，图片宽度进行缩放
          imgHeight = (imgWidth / realWidth) * realHeight; //等比例缩放高度
        } else {
          //如果图片真实高度和宽度都符合要求，高宽不变
          imgWidth = realWidth;
          imgHeight = realHeight;
        }
        $(bigimg).css('width', imgWidth); //以最终的宽度对图片缩放

        var w = (windowW - imgWidth) / 2; //计算图片与窗口左边距
        var h = (windowH - imgHeight) / 2; //计算图片与窗口上边距
        $(innerdiv).css({
          top: h,
          left: w,
        }); //设置#innerdiv的top和left属性
        $(outerdiv).fadeIn('fast'); //淡入显示#outerdiv及.pimg
      });
}
// 折叠框的展开与合并
function box1Action(obj) {
  //	$(obj).find(".pull-right").find('.complete').on('click',function(){

  //	})
  $(obj)
      .next()
      .toggle();
  var text = $(obj)
      .find('.pull-right')
      .find('.complete')
      .text();
  if (text == '完成') {
    $(obj)
        .find('.pull-right')
        .children('#hospitalInfo')
        .addClass('arrow-down')
        .removeClass('arrow-up');
    $(obj)
        .find('.pull-right')
        .find('.complete')
        .text('')
        .css('background', 'none');
    $(obj)
        .next()
        .css('display', 'none');
  } else {
    $(obj)
        .find('.pull-right')
        .children('#hospitalInfo')
        .addClass('arrow-up')
        .removeClass('arrow-down');
    $(obj)
        .find('.pull-right')
        .find('.complete')
        .text('完成')
        .css({ background: '#326BE6' });
    $(obj)
        .next()
        .css('display', 'block');
  }
}

// 修改初始化的修改显示
function modifyInitView(type, init) {
  if (!type) {
    type = 'normal';
  }
  $('#create_init_type').val(type);
  var initType = $('#create_init_type').val();
  $('#create_init_oper')
      .children()
      .remove();
  $('#create_init_unit')
      .children()
      .remove();
  $('#create_init_unit').show();
  if (type == 'normal') {
    $('#tr_init_value').hide();
  } else {
    $('#tr_init_value').show();
  }
  if (initType == 'num') {
    var doc = '<option value="+">+</option>';
    doc += '<option value="-">-</option>';
    doc += '<option value="*">×</option>';
    doc += '<option value="/">÷</option>';
    doc += '<option value="&">与</option>';
    doc += '<option value="|">或</option>';
    doc += '<option value="~">异或</option>';
    doc += '<option value=">>">左移</option>';
    doc += '<option value="<<">右移</option>';
    doc += '<option value="%">取余</option>';
    $('#create_init_oper').append(doc);

    doc = '<option value="integer">整数</option>';
    doc += '<option value="double">小数</option>';
    $('#create_init_unit').append(doc);
  } else if (initType == 'date' || initType == 'time' || initType == 'datetime') {
    var doc = '<option value="-">-</option>';
    $('#create_init_oper').append(doc);
    doc = '<option value="y">年数</option>';
    doc += '<option value="m">月数</option>';
    doc += '<option value="d">天数</option>';
    doc += '<option value="h">小时</option>';
    doc += '<option value="min">分钟</option>';
    doc += '<option value="s">秒数</option>';
    doc += '<option value="ms">毫秒</option>';
    $('#create_init_unit').append(doc);
  } else if (initType == 'text') {
    var doc = '<option value="+">+</option>';
    $('#create_init_oper').append(doc);
    $('#create_init_unit').hide();
  }
  if (initType == 'set') {
    $('#create_init_oper').hide();
    $('#create_init_oper').val('');
    $('#create_init_2').hide();
    $('#create_init_oper').val('');
    $('#create_init_unit').hide();
    $('#create_init_oper').val('');
  } else {
    $('#create_init_oper').show();
    $('#create_init_2').show();
    $('#create_init_unit').show();
  }

  if (init) {
    $('#create_init_unit').val(init.unit);
    var rule = base64.decode(init.rule);
    var rules = rule.split('::');
    $('#create_init_1').val(rules[0] ? rules[0] : '');
    $('#create_init_oper').val(rules[1] ? rules[1] : '');
    $('#create_init_2').val(rules[2] ? rules[2] : '');
    $('#create_init_3').val(init.decimal);
  }
}
// 判断是否选择小数 显示小数输入框
function decimalChange(val) {
  if (val == 'double') {
    $('#create_init_3').show();
  } else {
    $('#create_init_3').hide();
  }
}
// 修改创建框里的关联字段相关的显示
function modifyLinkView(type) {
  if (!type) {
    type = 'normal';
  }
  $('#create_link_type').val(type);
  if (!type || type == 'normal' || $('#tr_link').css('display') == 'none') {
    $('#tr_link_value').hide();
    $('#tr_link_range').hide();
    $('#tr_link_hide').hide();
    $('#tr_link_view').hide();
    $('#tr_link_reset').hide();
    $('#create_link_list')
        .children()
        .remove();
  } else if (type == 'reset') {
    $('#tr_link_value').show();
    $('#tr_link_range').show();
    $('#tr_link_reset').show();
    $('#tr_link_hide').hide();
    $('#tr_link_view').hide();
  } else {
    $('#tr_link_value').show();
    $('#tr_link_range').show();
    $('#tr_link_hide').show();
    $('#tr_link_view').show();
    $('#tr_link_reset').hide();
  }
}

function addLink(type, json) {
  modifyLinkView(type);
  if (!json) {
    json = {
      type: $('#create_link_type').val(),
      values: [],
    };
    var maxRuleVal =
        $('#create_link_max_operator').val() +
        '::' +
        $('#create_link_max_value')
            .val()
            .trim()
            .replace(/[\r\n]/g, '');
    if (!$('#create_link_max_operator').val() || !$('#create_link_max_value').val()) {
      maxRuleVal = '';
    }
    var ruleVal =
        $('#create_link_operator').val() +
        '::' +
        $('#create_link_value')
            .val()
            .trim()
            .replace(/[\r\n]/g, '');
    var linkOnce;
    if (json.type == 'reset') {
      linkOnce = {
        type: json.type,
        oper: $('#create_link_operator')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
        rule: ruleVal,
        maxRule: maxRuleVal,
        maxOper: $('#create_link_max_operator')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
        val: $('#create_link_reset_val')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
        no: $('#create_link_reset_no')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
      };
    } else {
      linkOnce = {
        type: json.type,
        oper: $('#create_link_operator')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
        rule: ruleVal,
        maxRule: maxRuleVal,
        maxOper: ($('#create_link_max_operator').val()
                ? $('#create_link_max_operator')
                    .val()
                    .trim()
                : ''
        ).replace(/[\r\n]/g, ''),
        hide: $('#create_link_hide')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
        show: $('#create_link_show')
            .val()
            .trim()
            .replace(/[\r\n]/g, ''),
      };
    }
    json.values.push(linkOnce);
  }
  if (json && json.type && json.type != 'normal' && json.values) {
    var values = json.values;
    for (var i = 0; i < values.length; i++) {
      var doc = '';
      var maxRule = values[i].maxRule;
      maxRule = maxRule ? maxRule : '';
      var maxOper = values[i].maxOper;
      maxOper = maxOper ? maxOper : '';
      if (values[i].type == 'reset') {
        doc +=
            '<option value="' +
            values[i].rule +
            '" maxValue="' +
            maxRule +
            '" val="' +
            values[i].val +
            '" no="' +
            values[i].no +
            '" oper="' +
            values[i].oper +
            '" maxOper="' +
            maxOper +
            '" type="' +
            values[i].type +
            '" ';
      } else {
        doc +=
            '<option value="' +
            values[i].rule +
            '" maxValue="' +
            maxRule +
            '" hide="' +
            values[i].hide +
            '" show="' +
            values[i].show +
            '" oper="' +
            values[i].oper +
            '" maxOper="' +
            maxOper +
            '" type="' +
            values[i].type +
            '" ';
      }
      doc += 'onDblClick="$(this).remove()" ';
      doc += 'onClick="doLinkReview(this)">';
      doc += values[i].rule + ' ' + (values[i].maxRule ? values[i].maxRule : '');
      doc += '</option>';
      $('#create_link_list').append(doc);
    }
    if (values.length >= 1) {
      var spStr = values[0].rule.split('::');
      $('#create_link_value').val(spStr[1]);
      if (values[0].maxRule) {
        var maxSpStr = values[0].maxRule.split('::');
        $('#create_link_max_value').val(maxSpStr[1]);
      }
      if (values[0].type == 'reset') {
        $('#create_link_reset_val').val(values[0].val);
        $('#create_link_reset_no').val(values[0].no);
      } else {
        if (values[0].hide == 'undefined') {
          $('#create_link_hide').val('');
        } else {
          $('#create_link_hide').val(values[0].hide);
        }
        $('#create_link_show').val(values[0].show);
      }
      $('#create_link_operator').val(values[0].oper);
      $('#create_link_max_operator').val(values[0].maxOper);
      $('#create_link_type').val(values[0].type);
    }
  }
}
/** 关联触发 */
function doLink(thisObj, no) {
  var linkStr = $('#jsonVal' + no).get(0).value;
  var json = JSON.parse(linkStr);
  var link = json.link;
  if (!link || link.type == 'normal') {
    return;
  }
  var tagName = thisObj.tagName.toLowerCase();

  var map = new Map();
  // 遍历联动条目
  for (var i = 0; i < link.values.length; i++) {
    var linkOnce = link.values[i];
    // 是否符合当前联动规则
    var checkVal = false;
    var checkTimeVal = false;
    var ifDateCheck = false; //是否是日期校验
    var nowVal = [];
    // 获取特殊控件的值
    if (tagName == 'input' && (json.type == 'checkbox' || json.type == 'radio')) {
      var name = $(thisObj).attr('name');
      var list = $('input[name=' + name + ']:checked');
      if (json.type == 'radio') {
        for (var k = 0; k < list.length; k++) {
          nowVal.push($(list[k]).get(0).value);
        }
      } else if (linkOnce.type != 'reset' && json.type == 'checkbox') {
        for (var k = 0; k < list.length; k++) {
          nowVal.push($(list[k]).get(0).value);
        }
      } else {
        // 复选款联动赋值给另个复选框编号
        if (link.values[i].no.indexOf('#{') == -1) {
          var linkNo_1 = link.values[i].no;
        } else {
          var linkNo_1 = link.values[i].no.split('#{')[1].split('}')[0];
        }
        var linkCalc = link.values[i].oper;
        var linkNoEle = $('.create_' + linkNo_1);
        var nowVals = link.values[i].rule.split('::')[1];
        if (linkCalc == '==') {
          //  == 等于
          if ($(thisObj).get(0).value == nowVals) {
            for (var ii = 0; ii < linkNoEle.length; ii++) {
              if ($(linkNoEle[ii]).attr('type') != 'checkbox') {
                // 当等于某个值的时候，并且赋值类型不是复选框时，进行联动赋值
                if ($(thisObj).get(0).checked) {
                  $(linkNoEle[ii]).val(linkOnce.val);
                } else {
                  $(linkNoEle[ii]).val('def');
                }
              } else {
                if ($(linkNoEle[ii]).attr('value') == linkOnce.val && $(thisObj).get(0).checked) {
                  $(linkNoEle[ii]).attr('checked', true);
                }
                if (!$(thisObj).get(0).checked && $(linkNoEle[ii]).attr('value') == linkOnce.val) {
                  $(linkNoEle[ii]).attr('checked', false);
                }
              }
              $(linkNoEle[ii]).change();
              $(linkNoEle[ii]).blur();
            }
          }
        } else if (linkCalc == '>' || linkCalc == '>=') {
          if (link.values[i].val.indexOf('#{') == -1) {
            var eles = link.values[i].val;
          } else {
            var eles = link.values[i].val.split('#{')[1].split('}')[0];
          }
          if (link.values[i].no.indexOf('#{') == -1) {
            var linkNo_1 = link.values[i].no;
          } else {
            var linkNo_1 = link.values[i].no.split('#{')[1].split('}')[0];
          }
          var input_ele = $('.create_' + eles);
          var inputs = $('.create_' + linkNo_1);
          var nowVals = link.values[i].rule.split('::')[1];
          var comparison;
          var maxOper = link.values[i].maxOper;
          var maxVal = link.values[i].maxRule.split('::')[1];
          var r = /^\+?[1-9][0-9]*$/;
          if (r.test(maxVal)) {
            maxVal = parseInt(maxVal);
          }
          if (r.test(nowVals)) {
            nowVals = parseInt(nowVals);
          }
          if (!$(thisObj).get(0).checked) {
            // 取消选择，根据条件限制个数 进行联动赋值
            // for(var m = 0; m <input_ele.length ; m++){
            var targetELe = $('.create_' + no);
            var ifBeforeChack = false; //是否有条件成立 默认false 不成立
            var beforeChackVal = [];
            // 判断是否有其他条件成立，进行二次校验；将成立条件放入beforeChackVal数组中
            for (var k1 = 0; k1 < targetELe.length; k1++) {
              var linkValues = link.values;
              for (var y = 0; y < linkValues.length; y++) {
                if ($(targetELe[k1]).get(0).checked) {
                  if (!linkValues[y].maxOper && linkValues[y].type == 'reset') {
                    if (linkValues[y].oper == '>') {
                      if (k1 > linkValues[y].rule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    } else {
                      if (k1 >= linkValues[y].rule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    }
                  } else if (linkValues[y].maxOper && linkValues[y].type == 'reset') {
                    // 含有最大值
                    if (linkValues[y].oper == '>') {
                      if (k1 > linkValues[y].rule.split('::')[1] && k1 < linkValues[y].maxRule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    } else {
                      if (k1 >= linkValues[y].rule.split('::')[1] && k1 <= linkValues[y].maxRule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    }
                  }
                }
              }
            }
            var result = [];
            var obj = {};
            for (var l = 0; l < beforeChackVal.length; l++) {
              if (!obj[beforeChackVal[l].val]) {
                result.push(beforeChackVal[l]);
                obj[beforeChackVal[l].val] = true;
              }
            }
            beforeChackVal = result;
            if (!maxOper) {
              if (linkCalc == '>') {
                if ($(thisObj).get(0).value > nowVals) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              } else {
                if ($(thisObj).get(0).value >= nowVals) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              }
            } else {
              // 含有最大值
              if (linkCalc == '>') {
                if ($(thisObj).get(0).value > nowVals && $(thisObj).get(0).value < maxVal) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              } else {
                if ($(thisObj).get(0).value >= nowVals && $(thisObj).get(0).value <= maxVal) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              }
            }
            if (comparison) {
              for (var k = 0; k < inputs.length; k++) {
                if ($(inputs[k]).attr('type') == 'checkbox') {
                  if ($(thisObj).get(0).value == $(inputs[k]).attr('value')) {
                    $(inputs[k]).get(0).checked = false;
                  }
                  if ($(thisObj).attr('id') != $(inputs[k]).attr('id')) {
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else if ($(inputs[k]).attr('type') == 'radio') {
                  if (beforeChackVal.length > 0) {
                    for (var w = 0; w < beforeChackVal.length; w++) {
                      if (
                          'create_' + beforeChackVal[w].no == $(inputs[k]).attr('id') &&
                          $(inputs[k])
                              .next()
                              .attr('key') == beforeChackVal[w].val
                      ) {
                        $(inputs[k]).attr('checked', true);
                        $(inputs[k]).change();
                        $(inputs[k]).blur();
                      }
                    }
                  } else {
                    $(inputs[k]).attr('checked', false);
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else {
                  if (beforeChackVal.length > 0) {
                    for (var w = 0; w < beforeChackVal.length; w++) {
                      if ('create_' + beforeChackVal[w].no == $(inputs[k]).attr('id')) {
                        $(inputs[k]).val(beforeChackVal[w].val);
                        $(inputs[k]).change();
                        $(inputs[k]).blur();
                      }
                    }
                  } else {
                    $(inputs[k]).val('');
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                }
              }
            }
            // }
          } else {
            // 选中联动
            // for(var m = 0; m <input_ele.length ; m++){
            if (!maxOper) {
              if (linkCalc == '>') {
                if ($(thisObj).get(0).value > nowVals) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              } else {
                if ($(thisObj).get(0).value >= nowVals) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              }
            } else {
              // 含有最大值
              if (linkCalc == '>') {
                if ($(thisObj).get(0).value > nowVals && $(thisObj).get(0).value < maxVal) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              } else {
                if ($(thisObj).get(0).value >= nowVals && $(thisObj).get(0).value <= maxVal) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              }
            }
            if (comparison) {
              for (var k = 0; k < inputs.length; k++) {
                if ($(inputs[k]).attr('type') == 'checkbox') {
                  if ($(thisObj).get(0).value == $(inputs[k]).attr('value')) {
                    $(inputs[k]).get(0).checked = true;
                  }
                  if ($(thisObj).attr('id') != $(inputs[k]).attr('id')) {
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else if ($(inputs[k]).attr('type') == 'radio' && $(inputs[k]).attr('value') == eles) {
                  if (
                      $(inputs[k])
                          .next()
                          .attr('key') == eles
                  ) {
                    $(inputs[k]).attr('checked', true);
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else {
                  $(inputs[k]).val(eles);
                  $(inputs[k]).change();
                  $(inputs[k]).blur();
                }
              }
            }
            // }
          }
        } else if (linkCalc == '<' || linkCalc == '<=') {
          if (link.values[i].val.indexOf('#{') == -1) {
            var eles = link.values[i].val;
          } else {
            var eles = link.values[i].val.split('#{')[1].split('}')[0];
          }
          if (link.values[i].no.indexOf('#{') == -1) {
            var linkNo_1 = link.values[i].no;
          } else {
            var linkNo_1 = link.values[i].no.split('#{')[1].split('}')[0];
          }
          var input_ele = $('.create_' + eles);
          var inputs = $('.create_' + linkNo_1);
          var nowVals = link.values[i].rule.split('::')[1];
          var maxOper = link.values[i].maxOper;
          var maxVal = link.values[i].maxRule.split('::')[1];
          var comparison;
          var r = /^\+?[1-9][0-9]*$/;
          if (r.test(maxVal)) {
            maxVal = parseInt(maxVal);
          }
          if (r.test(nowVals)) {
            nowVals = parseInt(nowVals);
          }
          if (!$(thisObj).get(0).checked) {
            var targetELe = $('.create_' + no);
            var ifBeforeChack = false; //是否有条件成立 默认false 不成立
            var beforeChackVal = [];
            // 判断是否有其他条件成立，进行二次校验；将成立条件放入beforeChackVal数组中
            for (var k1 = 0; k1 < targetELe.length; k1++) {
              var linkValues = link.values;
              for (var y = 0; y < linkValues.length; y++) {
                if ($(targetELe[k1]).get(0).checked) {
                  if (!linkValues[y].maxOper && linkValues[y].type == 'reset') {
                    if (linkValues[y].oper == '<') {
                      if (k1 > linkValues[y].rule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    } else {
                      if (k1 <= linkValues[y].rule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    }
                  } else if (linkValues[y].maxOper && linkValues[y].type == 'reset') {
                    // 含有最大值
                    if (linkValues[y].oper == '<') {
                      if (k1 < linkValues[y].rule.split('::')[1] && k1 > linkValues[y].maxRule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    } else {
                      if (k1 <= linkValues[y].rule.split('::')[1] && k1 >= linkValues[y].maxRule.split('::')[1]) {
                        ifBeforeChack = true;
                        beforeChackVal.push({
                          val: linkValues[y].val,
                          no: linkValues[y].no,
                        });
                      }
                    }
                  }
                }
              }
            }
            // 去重
            var result = [];
            var obj = {};
            for (var l = 0; l < beforeChackVal.length; l++) {
              if (!obj[beforeChackVal[l].val]) {
                result.push(beforeChackVal[l]);
                obj[beforeChackVal[l].val] = true;
              }
            }
            beforeChackVal = result;
            // 取消选择，根据条件限制个数 进行联动赋值
            if (!maxOper) {
              if (linkCalc == '<') {
                if ($(thisObj).get(0).value < nowVals) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              } else {
                if ($(thisObj).get(0).value <= nowVals) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              }
            } else {
              if (linkCalc == '<') {
                if ($(thisObj).get(0).value < nowVals && $(thisObj).get(0).value > maxVal) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              } else {
                if ($(thisObj).get(0).value <= nowVals && $(thisObj).get(0).value >= maxVal) {
                  comparison = true;
                } else {
                  comparison = false;
                }
              }
            }
            if (comparison) {
              for (var k = 0; k < inputs.length; k++) {
                if ($(inputs[k]).attr('type') == 'checkbox') {
                  if ($(thisObj).get(0).value == $(inputs[k]).attr('value')) {
                    $(inputs[k]).get(0).checked = false;
                  }
                  if ($(thisObj).attr('id') != $(inputs[k]).attr('id')) {
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else if ($(inputs[k]).attr('type') == 'radio') {
                  if (beforeChackVal.length > 0) {
                    for (var w = 0; w < beforeChackVal.length; w++) {
                      if (
                          'create_' + beforeChackVal[w].no == $(inputs[k]).attr('id') &&
                          $(inputs[k])
                              .next()
                              .attr('key') == beforeChackVal[w].val
                      ) {
                        $(inputs[k]).attr('checked', true);
                        $(inputs[k]).change();
                        $(inputs[k]).blur();
                      }
                    }
                  } else {
                    $(inputs[k]).attr('checked', false);
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else {
                  if (beforeChackVal.length > 0) {
                    for (var w = 0; w < beforeChackVal.length; w++) {
                      if ('create_' + beforeChackVal[w].no == $(inputs[k]).attr('id')) {
                        $(inputs[k]).val(beforeChackVal[w].val);
                        $(inputs[k]).change();
                        $(inputs[k]).blur();
                      }
                    }
                  } else {
                    $(inputs[k]).val('');
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                }
              }
            }
          } else {
            // 选中联动
            if (linkCalc == '<') {
              if ($(thisObj).get(0).value < nowVals) {
                comparison = true;
              } else {
                comparison = false;
              }
            } else {
              if ($(thisObj).get(0).value <= nowVals) {
                comparison = true;
              } else {
                comparison = false;
              }
            }
            if (comparison) {
              for (var k = 0; k < inputs.length; k++) {
                if ($(inputs[k]).attr('type') == 'checkbox') {
                  if ($(thisObj).get(0).value == $(inputs[k]).attr('value')) {
                    $(inputs[k]).get(0).checked = true;
                  }
                  if ($(thisObj).attr('id') != $(inputs[k]).attr('id')) {
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else if ($(inputs[k]).attr('type') == 'radio' && $(inputs[k]).attr('value') == eles) {
                  if (
                      $(inputs[k])
                          .next()
                          .attr('key') == eles
                  ) {
                    $(inputs[k]).attr('checked', true);
                    $(inputs[k]).change();
                    $(inputs[k]).blur();
                  }
                } else {
                  $(inputs[k]).val(eles);
                  $(inputs[k]).change();
                  $(inputs[k]).blur();
                }
              }
            }
          }
        }
      }
    } else {
      if (json.type == 'datehourtime' || json.type == 'datehour' || json.type == 'datetime') {
        var val = $(thisObj).get(0).value;
        var new_date = val.split(' ')[0];
        var rule = link.values[i].rule.split(' ')[0];
        var newVal = link.values[i].rule.replace(rule, new_date);
        var time1 = parseDateStr(val).getTime(); //当前值
        var time2 = parseDateStr(newVal).getTime();
        var oper = link.values[i].oper;
        switch (oper) {
          case '>': {
            if (time1 > time2) {
              nowVal.push(val);
              checkVal = true;
              ifDateCheck = true;
            } else {
              checkVal = false;
              ifDateCheck = false;
              checkTimeVal = true;
            }
            break;
          }
          case '<': {
            if (time1 < time2) {
              nowVal.push(val);
              ifDateCheck = true;
              checkVal = true;
            } else {
              ifDateCheck = false;
              checkVal = false;
              checkTimeVal = true;
            }
            break;
          }
          case '==': {
            if (time1 == time2) {
              nowVal.push(val);
              ifDateCheck = true;
              checkVal = true;
            } else {
              checkVal = false;
              ifDateCheck = false;
              checkTimeVal = true;
            }
            break;
          }
          case '<=': {
            if (time1 <= time2) {
              nowVal.push(val);
              ifDateCheck = true;
              checkVal = true;
            } else {
              checkVal = false;
              ifDateCheck = false;
              checkTimeVal = true;
            }
            break;
          }
          case '>=': {
            if (time1 >= time2) {
              nowVal.push(val);
              ifDateCheck = true;
              checkVal = true;
            } else {
              checkVal = false;
              ifDateCheck = false;
              checkTimeVal = true;
            }
            break;
          }
          case '!=': {
            if (time1 != time2) {
              nowVal.push(val);
              ifDateCheck = true;
              checkVal = true;
            } else {
              checkVal = false;
              ifDateCheck = false;
              checkTimeVal = true;
            }

            break;
          }
          default: {
            checkVal = false;
            ifDateCheck = false;
            checkTimeVal = true;
          }
        }
      } else {
        var val = $(thisObj).get(0).value;
        nowVal.push(val);
      }
    }

    // 检查是否符合规则
    for (var j = 0; j < nowVal.length; j++) {
      var ruleEval = execRange(nowVal[j], linkOnce.rule);
      var maxRuleResult = true;
      if (linkOnce.maxRule) {
        var maxRuleEval = execRange(nowVal[j], linkOnce.maxRule);
        maxRuleResult = eval(maxRuleEval);
      }
      if (eval(ruleEval) && maxRuleResult) {
        checkVal = true;
        break;
      }
    }
    // 遍历隐藏
    if (linkOnce.hide) {
      var hides = linkOnce.hide.trim().split(',');
      for (var k = 0; k < hides.length; k++) {
        var no = linkOnce.type + '___' + hides[k].trim();
        if (map.get(no)) {
          if (checkVal) {
            map.set(no, {
              disabled: checkVal,
              type: linkOnce.type,
            });
          }
        } else {
          map.set(no, {
            disabled: checkVal,
            type: linkOnce.type,
          });
        }
      }
    }
    // 遍历显示
    if (linkOnce.show) {
      var shows = linkOnce.show.trim().split(',');
      for (var k = 0; k < shows.length; k++) {
        var no = linkOnce.type + '___' + shows[k].trim();
        if (map.get(no)) {
          if (checkVal) {
            map.set(no, {
              disabled: !checkVal,
              type: linkOnce.type,
            });
          }
        } else {
          map.set(no, {
            disabled: !checkVal,
            type: linkOnce.type,
          });
        }
      }
    }
    // 联动赋值
    if (linkOnce.no && checkVal) {
      var objNos = $('.create_' + linkOnce.no);
      if ($(objNos[0]).attr('type') == 'checkbox' || $(objNos[0]).attr('type') == 'radio') {
        var name = $(objNos[0]).attr('name');
        var inputs = $('input[name=' + name + ']');
        for (var k = 0; k < inputs.length; k++) {
          if ($(objNos[0]).attr('type') == 'radio') {
            if ($(inputs[k]).attr('value') == linkOnce.val) {
              $(inputs[k]).get(0).checked = true;
            } else {
              $(inputs[k]).get(0).checked = false;
            }
          }
          if ($(thisObj).attr('id') != $(inputs[k]).attr('id')) {
            $(inputs[k]).change();
            $(inputs[k]).blur();
          }
        }
      } else {
        objNos.val(getRuleVal(linkOnce.val));
        if (json.no != linkOnce.no) {
          objNos.change();
          objNos.blur();
        }
        if (ifDateCheck) {
          //多个时间校验时 只保留第一个
          break;
        }
      }
    } else {
      // 清空时间校验赋值内容
      if (checkTimeVal) {
        var objNos = $('.create_' + linkOnce.no);
        objNos.val('');
      }
    }
  }
  // 循环处理显示隐藏
  map.forEach(function(value, key) {
    // 去除添加的过滤重复的头
    var index = key.indexOf('___');
    if (index > -1) {
      key = key.substring(index + 3);
    }
    // 拆分如果有处理控件中子项
    index = key.indexOf('.');
    var option;
    if (index > -1) {
      option = key.substring(index + 1);
      key = key.substring(0, index);
    }
    // 修改联动控件选项的值
    if (option != null) {
      var chs = $('#item' + key).children('.create_' + key);
      var tagName = chs[0].tagName.toLowerCase();
      if (tagName == 'select') {
        chs = $(chs[0]).children('option');
      }
      for (var k = 0; k < chs.length; k++) {
        if ($(chs[k]).val() == option) {
          if (value.type == 'hide') {
            if (value.disabled) {
              $(chs[k]).hide();
              $(chs[k])
                  .parent()
                  .children('span[key=' + option + ']')
                  .hide();
              $(chs[k])
                  .parent()
                  .children('br[key=' + option + ']')
                  .hide();
            } else {
              $(chs[k]).show();
              $(chs[k])
                  .parent()
                  .children('span[key=' + option + ']')
                  .show();
              $(chs[k])
                  .parent()
                  .children('br[key=' + option + ']')
                  .show();
            }
          } else if (value.type == 'disabled') {
            $(chs[k]).attr('disabled', value.disabled);
          }
          // 设置选中状态为不选中
          if (value.disabled && tagName == 'input') {
            $(chs[k]).attr('checked', false);
            $(chs[k]).change();
            $(chs[k]).blur();
          }
        }
      }
      // 清空下拉列表的赋值
      if (tagName == 'select') {
        var val = $('.create_' + key).get(0).value;
        var option = $('.create_' + key).children('option[value=' + val + ']');
        // 检查方法（检查选择项是否为不可用）
        var check = function(option) {
          return (
              option.attr('disabled') == true ||
              option.attr('disabled') == 'disabled' ||
              (option.css('display') && option.css('display').toLowerCase() == 'none')
          );
        };
        if (check(option)) {
          var index = 0;
          while (check($(chs[index]))) {
            index++;
          }
          $(chs[index])
              .parent()
              .val(chs[index].value);
          $('.create_' + key).change();
          $('.create_' + key).blur();
        }
      }
    }
    // 修改联动控件
    else if (value.type == 'hide') {
      if (value.disabled) {
        $('#item' + key).hide();
      } else {
        $('#item' + key).show();
      }
    } else if (value.type == 'disabled') {
      $('#item' + key + ' *').attr('disabled', value.disabled);
    }
  });
}
/** 字符串补位(做比较前使用) */
function execRange(str, rule, ifOtherTime) {
  var rules = rule.split('::');
  rule = getRuleVal(rules[1]);
  if (ifOtherTime) {
    // 时间补充
    var regs = new RegExp('/', 'g');
    rule = parseDateStr(rule, true).replace(regs, '-');
  }
  // FIXME: TIA-4添加时间(不是好的解决办法)
  var diseaseType = GetUrlParam('diseaseType');
  if (diseaseType === 'TIA' && rules[1] === '#{CM_17}' && str.split(' ').length === 1) {
    str += ' 00:00';
  }
  // 对比计算
  if (isNaN(rule * 1.0) || isNaN(str * 1.0)) {
    var l1 = str.length;
    var l2 = rule.length;
    if (l1 > l2) {
      for (var i = 0; i < l1 - l2; i++) {
        rule = ' ' + rule;
      }
    } else {
      for (var i = 0; i < l2 - l1; i++) {
        str = ' ' + str;
      }
    }
    console.log('"' + str + '"' + rules[0] + '"' + rule + '"');
    return '"' + str + '"' + rules[0] + '"' + rule + '"';
  } else {
    rule = rule * 1.0;
    str = str * 1.0;
    return str + rules[0] + rule;
  }
}

//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate(type) {
  var date = new Date();
  var year = date.getFullYear();
  var month = date.getMonth() + 1;
  if (month < 10) {
    month = '0' + month;
  }
  var day = date.getDate();
  if (day < 10) {
    day = '0' + day;
  }
  var h = date.getHours(); //获取当前小时数(0-23)
  if (h < 10) {
    h = '0' + h;
  }
  var m = date.getMinutes(); //获取当前分钟数(0-59)
  if (m < 10) {
    m = '0' + m;
  }
  var s = date.getSeconds(); //获取当前秒数(0-59)
  if (s < 10) {
    s = '0' + s;
  }
  if (type == 'date') {
    return year + '-' + month + '-' + day;
  } else if (type == 'time') {
    return h + ':' + m + ':' + s;
  } else if (type == 'datetime') {
    return year + '-' + month + '-' + day + ' ' + h + ':' + m + ':' + s;
  }
  return null;
}

// 新增到规则列表
function addCheck(option) {
  var remark;
  if (!option) {
    var type = $('#create_check_type').val();
    var rule;
    if (type == 'reg') {
      rule = $('#create_check_reg').val();
      // 格式化正则，去除前后的斜杠，或是补填正则前缀标记^
      rule = rule.indexOf('/^') == 0 ? rule.substring(1, rule.length - 1) : rule;
      rule = rule.indexOf('^') == 0 ? rule : '^' + rule;
      rule = base64.encode(rule);
    } else if (type == 'range' || type == 'num') {
      rule = $('#create_check_operator').val() + '::' + $('#create_check_value').val();
    } else if (type == 'calc') {
      rule = $('#create_check_calc_no1').val();
      rule += '::' + $('#create_check_calc_calc').val();
      rule += '::' + $('#create_check_calc_no2').val();
      rule += '::' + $('#create_check_calc_operator').val();
      rule += '::' + $('#create_check_calc_result').val();
      rule += '::' + $('#create_check_calc_unit').val();
    } else {
      alert('请先选择一种规则');
      return;
    }
    var msg = $('#create_check_msg')
        .val()
        .trim();
    option = {
      msg: msg == '' ? msg : base64.encode(msg),
      rule: rule,
      type: type,
    };
  }
  var doc = '<option value="' + option.rule + '" ';
  doc += 'onDblClick="$(this).remove()" ';
  doc += 'onClick="doCheckReview(this)" ';
  doc += 'type="' + option.type + '" ';
  doc += 'msg="' + option.msg + '">';
  doc += option.type == 'reg' ? base64.decode(option.rule) : option.rule;
  doc += '</option>';
  $('#create_check_list').append(doc);
}
// 规则框单击效果
function doCheckReview(thisObj) {
  var rule = $(thisObj).get(0).value;
  var type = $(thisObj).attr('type');
  var msg = $(thisObj).attr('msg');
  var json = {
    type: type,
    rule: rule,
    msg: msg,
  };
  $('#create_check_type').val(type);
  modifyCheckView(type, json);
}
// 选择不同规则类型修改规则框之间的显示
function modifyCheckView(type, json) {
  $('#create_check_type').val(type);
  $('#tr_check_msg').show();
  if (type == 'normal' || $('#tr_check').css('display') == 'none') {
    $('#tr_check_reg').hide();
    $('#tr_check_range').hide();
    $('#tr_check_calc').hide();
    $('#tr_check_list').hide();
    $('#tr_check_msg').hide();
    $('#create_check_list')
        .children()
        .remove();
  } else if (type == 'reg') {
    $('#tr_check_reg').show();
    $('#tr_check_range').hide();
    $('#tr_check_calc').hide();
    $('#tr_check_list').show();
  } else if (type == 'range') {
    $('#tr_check_range').show();
    $('#tr_check_reg').hide();
    $('#tr_check_calc').hide();
    $('#tr_check_list').show();
    $('#create_check_range_tite').text('当前填写值');
  } else if (type == 'num') {
    $('#tr_check_range').show();
    $('#tr_check_reg').hide();
    $('#tr_check_calc').hide();
    $('#tr_check_list').show();
    $('#create_check_range_tite').text('当前选择数');
  } else if (type == 'calc') {
    if ($('#create_check_type option[value=calc]').length == 0) {
      modifyCheckView('normal');
      return;
    }
    $('#tr_check_range').hide();
    $('#tr_check_reg').hide();
    $('#tr_check_calc').show();
    $('#tr_check_list').show();
  }
  if (json) {
    if (json.type == 'reg') {
      $('#create_check_reg').val(base64.decode(json.rule));
    } else if (json.type == 'range' || json.type == 'num') {
      var index = json.rule.indexOf('::');
      var operator = json.rule.substring(0, index);
      var value = json.rule.substring(index + 2, json.rule.length);
      $('#create_check_operator').val(operator);
      $('#create_check_value').val(value);
    } else if (json.type == 'calc') {
      var rules = json.rule.split('::');
      $('#create_check_calc_no1').val(rules[0]);
      $('#create_check_calc_calc').val(rules[1]);
      $('#create_check_calc_no2').val(rules[2]);
      $('#create_check_calc_operator').val(rules[3]);
      $('#create_check_calc_result').val(rules[4]);
      if (rules.length == 6) {
        $('#create_check_calc_unit').val(rules[5]);
      }
    }
    $('#create_check_msg').val(base64.decode(json.msg));
  }
}

var testCallback;
/** 执行验证 */
function doCheck(thisObj, no) {
  // console.log(thisObj);
  var json;
  if (no != undefined && no != null) {
    var jsonStr = $('#jsonVal' + no).get(0).value;
    json = JSON.parse(jsonStr);
  }
  var result = checkValue(thisObj, json);
  $(thisObj)
      .parent()
      .children('.error')
      .remove();
  if (result) {
    if (typeof result === 'string') {
      // 普通错误提示
      $(thisObj)
          .parent()
          .append('<span class="error"><font size=-1 color=red>' + result + '</font></span>');
    } else if (Object.prototype.hasOwnProperty.call(result, 'needReselect')) {
      // 多选时选择了冲突选项则弹出提示
      handleCheckboxWidthUTD(thisObj);
    }
  }
  if (testCallback) {
    testCallback(no);
  }
}

/** 校检用户输入数据(可不传json) */
function checkValue(thisObj, json) {
  // console.log(json);
  if (!json) {
    var idNum = $(thisObj)
        .parent()
        .attr('idNum');
    var jsonStr = $('#jsonVal' + idNum).get(0).value;
    json = JSON.parse(jsonStr);
  }
  var check = json.check;
  // console.log(thisObj);
  // console.log(check);
  if (!check) {
    return null;
  }
  // debugger;
  switch (json.type) {
    case 'radio':
    case 'checkbox': {
      var resultErrorMsg;
      var boxs = $('input[name=' + $(thisObj).attr('name') + ']:checked');
      var allboxs = $('input[name=' + $(thisObj).attr('name') + ']');
      if (check.notnull && boxs.length == 0) {
        resultErrorMsg = '该项为必选项';
      }
      for (var j = 0; j < check.list.length; j++) {
        var errorMsg = check.list[j].msg;
        errorMsg = !errorMsg ? '该项输入不符合规范(' + check.list[j].rule + ')，请检查后输入' : base64.decode(errorMsg);
        var rules = check.list[j].rule.split('::');
        var rule = check.list[j].rule;
        if (check.list[j].type == 'reg') {
          rule = base64.decode(rule);
          for (var i = 0; i < boxs.length; i++) {
            if (!new RegExp(rule).test($(boxs[i]).get(0).value)) {
              resultErrorMsg = errorMsg;
              break;
            }
          }
        } else if (check.list[j].type == 'range') {
          // 必选校验
          if (rules[0] == '==') {
            var hasMust = false;
            for (var i = 0; i < boxs.length; i++) {
              var ruleEval = execRange($(boxs[i]).get(0).value, rule);
              if (eval(ruleEval)) {
                hasMust = true;
                break;
              }
            }
            if (!hasMust) {
              resultErrorMsg = errorMsg;
              continue;
            }
          } else {
            for (var i = 0; i < boxs.length; i++) {
              if (eval(ruleEval)) {
                resultErrorMsg = errorMsg;
                break;
              }
            }
          }
        } else if (check.list[j].type == 'num') {
          // 验证再选中一个会不会超出，如果超出则将其他置为不可用
          $('.' + allboxs[0].id).attr('disabled', false);
          var oper = rule.split('::')[0];
          if (boxs.length + 1 <= allboxs.length) {
            var tempRule = rule;
            if (oper == '==') {
              tempRule = tempRule.replace('==', '<=');
            } else if (oper == '>' || oper == '>=') {
              tempRule = '>=::0';
            }
            var ruleEval = execRange(boxs.length + 1 + '', tempRule);
            if (!eval(ruleEval)) {
              // if(! $(allboxs[k]).is(':checked')) {
              $('.' + allboxs[0].id).attr('disabled', true);
              $('.' + allboxs[0].id + ':checked').attr('disabled', false);
            }
          }
          var ruleEval = execRange(boxs.length + '', rule);
          if (!eval(ruleEval)) {
            resultErrorMsg = errorMsg;
            continue;
          }
        }
      }
      if (resultErrorMsg) {
        return resultErrorMsg;
      }
      // 多选项如果选择了无法确定或无记录加上其它任何选项，则需要弹窗提示
      // console.log(boxs);
      for (var k = 0; k < boxs.length; k++) {
        if (boxs[k].value === 'UTD' && boxs.length > 1) {
          return { needReselect: true };
        }
      }
      break;
    }
    case 'select': {
      var checkVal = $(thisObj).get(0).value;
      if (check.notnull && (checkVal.trim() == '' || checkVal.trim() == 'def')) {
        return '该项为必选项';
      } else {
        // 处理下拉框模板返回的错误信息
        // FIXME: 由于不了解之前的逻辑，可能会有遗漏
        for (var i = 0; i < check.list.length; i++) {
          var rule = check.list[i].rule;
          var errorMsg = check.list[i].msg;
          if (check.list[i].type == 'range') {
            var correctVal = rule.split('::')[1];
            if (correctVal === checkVal) {
              return null;
            } else {
              errorMsg = base64.decode(errorMsg);
              if (!eval(ruleEval)) {
                return errorMsg;
              }
            }
          }
        }
      }
      break;
    }
    default: {
      if (
          json.type === 'date' ||
          json.type === 'time' ||
          json.type === 'datetime' ||
          json.type === 'datehour' ||
          json.type === 'datehourtime'
      ) {
        // 校验是否是日期格式
        var vals = $(thisObj).get(0).value;
        if (vals != '') {
          if (json.type !== 'datehour') {
            if (isNaN(vals) && isNaN(Date.parse(vals.replace(/-/g, '/')))) {
              return '请输入正确的日期格式';
            }
          } else {
            var regs = vals.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2})$/);
            if (regs == null) {
              return '请输入正确的日期格式';
            }
          }

          switch (json.type) {
            case 'date': {
              var time = $(thisObj).get(0).value;
              var r = time.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/);
              if (r == null) {
                return '请输入正确的日期格式，例yyyy-mm-dd';
              }
              break;
            }
            case 'time': {
              var time = $(thisObj).get(0).value;
              var r = time.match(/^(\d{1,2}):(\d{1,2}):(\d{1,2})$/);
              if (r == null) {
                return '请输入正确的时间格式，例hh:mm:ss';
              }
              break;
            }
            case 'datetime': {
              var time = $(thisObj).get(0).value;
              var r = time.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/);
              if (r == null) {
                return '请输入正确的日期时间格式，例yyyy-mm-dd hh:mm:ss';
              }
              break;
            }
            case 'datehour': {
              var time = $(thisObj).get(0).value;
              var r = time.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2})$/);
              if (r == null) {
                return '请输入正确的日期时间格式，例yyyy-mm-dd hh';
              }
              break;
            }
            case 'datehourtime': {
              var time = $(thisObj).get(0).value;
              var r = time.match(/^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2})$/);
              if (r == null) {
                return '请输入正确的日期时间格式，例yyyy-mm-dd hh:mm';
              }
              break;
            }
          }
        }
      }
      if (json.type == 'datetime' || json.type == 'datehourtime' || json.type == 'datehour') {
        var regs = new RegExp('/', 'g');
        if ($(thisObj).get(0).value) {
          var checkVal = parseDateStr($(thisObj).get(0).value, true).replace(regs, '-');
        } else {
          var checkVal = '';
        }
      } else {
        var checkVal = $(thisObj).get(0).value;
      }
      if (checkVal.trim() == '') {
        console.log('必填校验');
        console.log(check);
        if (check.notnull) {
          return '该项为必填项';
        }
        return null;
      }
      for (var i = 0; i < check.list.length; i++) {
        var rule = check.list[i].rule;
        var errorMsg = check.list[i].msg;
        errorMsg = !errorMsg ? '该项输入不符合规范(' + rule + ')，请检查后输入' : base64.decode(errorMsg);
        if (check.list[i].type == 'reg') {
          rule = base64.decode(rule);
          if (!new RegExp(rule).test(checkVal)) {
            return errorMsg;
          }
        } else if (check.list[i].type == 'range') {
          // 拆解通配符
          if (json.type == 'datetime' || json.type == 'datehourtime' || json.type == 'datehour') {
            // 第三个参数为  是否是 datetime，datehourtime，datehour
            var ruleEval = execRange(checkVal, rule, true);
          } else {
            var ruleEval = execRange(checkVal, rule);
          }
          if (!eval(ruleEval)) {
            return errorMsg;
          }
        } else if (check.list[i].type == 'calc') {
          var rules = rule.split('::');
          var type;
          if (rules[5] == 'integer' || rules[5] == 'double') {
            type = 'num';
          }
          var result = execCalc(rules[0], rules[2], rules[1], rules[5], type);
          if (result == undefined || result == null) {
            continue;
          }
          var ruleEval = execRange(result, rules[3] + '::' + rules[4]);
          if (!eval(ruleEval)) {
            return errorMsg;
          }
        }
      }
    }
  }
  return null;
}

// 多选时如果选择了无法确定或无记录，再选择其它项时需要提示
function handleCheckboxWidthUTD(thisObj) {
  var specialContents = ['create_36'];
  var currentId = $(thisObj).attr('id');
  // 某些特殊多选项无需全局提示
  if (specialContents.indexOf(currentId) > -1) {
    return;
  }
  // 由于验证方法会执行多次，需要避免多个弹层展示
  if ($('.layui-layer').length) {
    return;
  }
  // 弹窗加清空选项
  layer.ready(function() {
    var boxes = $('input[name=' + $(thisObj).attr('name') + ']:checked');
    layer.open({
      title: '提示',
      content: '填报内容不符合规范，请重新填报',
      yes: function(index) {
        boxes.each(function() {
          choose($(this));
        });
        layer.close(index);
      },
      cancel: function(index) {
        boxes.each(function() {
          choose($(this));
        });
        layer.close(index);
      },
    });
    // 页面结构过于复杂，直接重设当前层的定位
    layer.style(layer.index, {
      top: '100px',
    });
  });
}

function free() {
  $(window).mouseup();
}

// 给css文件添加版本号避免缓存
setCssVersion();
function setCssVersion() {
  var ol = document.getElementsByTagName('link');
  var oldhref = null;
  var v = '?v= ' + Date.now();
  for (var i = 0; i < ol.length; i++) {
    oldhref = ol[i].getAttribute('href');
    if (oldhref.indexOf('../css/report-style.css') === -1) {
      continue;
    }
    if (oldhref.indexOf('?version') != -1) {
      ol[i].setAttribute('href', oldhref.substring(0, oldhref.indexOf('?version')) + v);
    } else {
      ol[i].setAttribute('href', oldhref + v);
    }
  }
}

function GetUrlParam(key) {
  var reg = new RegExp('(^|&)' + key + '=([^&]*)(&|$)');
  var result = window.location.search.substr(1).match(reg);
  return result ? decodeURIComponent(result[2]) : null;
}
