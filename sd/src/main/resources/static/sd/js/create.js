/* eslint-disable no-unused-vars */
/* eslint-disable no-undef */
// create构造函数中可以调用页面引用的其它js中的方法
;(function () {
  // 全局变量
  var CREATE_PUBLIC = {
    overTimer: null, // 未操作超时定时器
    overTimeCount: 0, // 超时计时器
  }
  var Create = (window.create = function () {
    const sid = GetUrlParam('sid')
    const patientCode = GetUrlParam('patientCode')
    const cysj = GetUrlParam('cysj')
    const permissions = GetUrlParam('permissions')
    const sdPatientInfo = localStorage.getItem('sdPatientInfo')
    Create.prototype.createRender = function createRender(type, callback) {
      // 监听页面长时间无操作->向父页面发送消息
      listenPageOperation(function () {
        window.top.postMessage(
            { name: 'drgTemplate', message: 'isOverTime' },
            '/'
        )
      }, 1800)
      var self = this,
          version = GetUrlParam('version')
      $.getJSON(
          '../js/json/' + (sid < 10 ? '0' + sid : sid) + '.json',
          (data) => {
        self.doCreate(type, data.object, callback)
      }
    )
    }
    Create.prototype.doCreate = function doCreate(type, jsonStr, callback) {
      $('body').append('<input type="hidden" id="diseaseType"/>')
      $('#diseaseType').val(type)
      createPage(jsonStr, function (element, json) {
        $('input_remark' + json.no).addClass('form-title')
        $(element).addClass('form-' + json.type)
        switch (json.type) {
          case 'span': {
            $('input_remark' + json.no).removeClass('form-title')
            $('input_remark' + json.no).addClass('form' + json.type)
            break
          }
          case 'radio':
          case 'checkbox': {
            var classStr = 'form-1'
            // 横排竖排
            if (json.pointsort == 2) {
              classStr = 'form-2'
              $('#create_' + json.no)
                  .prev()
                  .remove()
            }
            var inputs = $('input[name=' + json.submitName + ']')
            for (var i = 0; i < inputs.length; i++) {
              // 文字在右
              if (json.textsort == 1) {
                $(inputs[i])
                    .prev()
                    .addClass(classStr + '-1')
                $(inputs[i]).addClass(classStr + '-3')
              } else {
                $(inputs[i])
                    .next()
                    .addClass(classStr + '-2')
                $(inputs[i]).addClass(classStr + '-4')
              }
              $(inputs[i]).addClass('form-' + json.type)
            }
            break
          }
          case 'box':
          case 'box1': {
            $(element).prev().addClass('box-remark')
            $(element).css('border', '0px')
            // 去除模板边线
            if (json.line) {
              $(element).parent('.slot-item').css('border', '0')
              try {
                var bg = $(element)
                    .parent('.slot-item')
                    .parent('.slot-item')
                    .css('background')
                if (!bg) {
                  bg = '#FFFFFF'
                }
                // 判断是否存在边线
                if (json.line) {
                  // 加边线
                  // 调节颜色
                  bg = bg.replace('#', '0x')
                  bg = bg - 0x111111
                  bg = bg > 0 ? bg : 0x000001
                  bg = bg.toString(16)
                  bg = 'fff' //隐藏模块颜色
                }
                $(element)
                    .parent('.slot-item')
                    .css('background', '#' + bg)
                $(element)
                    .parent('.slot-item')
                    .find('.form-box')
                    .find('.slot-item')
                    .css('background', '#' + bg)
              } catch (error) {
                console.log(error)
              }
            } else {
              $(element).parent('.slot-item').css('border', '0px')
            }
            break
          }
        }
        if (json.disabled) {
          $(element)
              .parent('.slot-item')
              .children('input')
              .attr('disabled', true)
        }
        $('.form-2-2')
            .parent('.slot-item')
            .css({ 'padding-left': 'calc(30% + 20px)' })
        $('.form-2-4')
            .parent('.slot-item')
            .find('span[class^="input_remark"]')
            .css({
              'margin-left': 'calc(-43% - 20px)',
              display: 'block',
              background: 'none',
              width: '100%',
              'border-right': '0',
            })
        //只读与隐藏
        if (json.hide) {
          $('#item' + json.no).addClass('block-show')
          $('#item' + json.no).css({
            display: 'none',
          })
          $('#item' + json.no).css({
            background: 'none',
          })
          $('#item' + json.no).css({
            background: '#' + bg,
          })
        } else {
          $('#item' + json.no).css({
            display: 'block',
            position: 'relative',
          })
          $('.block-show').css({
            margin: '0px 0px 0px',
            width: '100%',
            'text-align': 'left',
            position: 'relative',
            'z-index': '0',
          })
          $('.block-show .slot-containers div').css({
            'text-align': 'left',
            'margin-top': '-5px',
          })
        }
      })
      // 第一个模块显示其他模块隐藏
      // for(var i = 0 ; i < $('.form-title').length ; i ++) {
      // 	$($('.form-title')[i + 1]).find('.pull-right').find('.complete').text('').css("background","none");
      // 	$($('.form-title')[i + 1]).find('.pull-right').children('#hospitalInfo').addClass("arrow-down").removeClass("arrow-up")
      // 	$($('.form-title')[i + 1]).next('div').hide();
      // }
      // 初始化赋值后隐藏单选框/复选框默认样式
      $("input[type ='radio']").css('display', 'none')
      $("input[type ='checkbox']").css('display', 'none')
      // 填报员跟医院管理员增加填报权限
      var check = GetUrlParam('check'),
          diseaseId = GetUrlParam('diseaseId'),
          back = GetUrlParam('back'),
          type = GetUrlParam('type')
      var btnStr = ''
      if (
          (permissions === '超级管理员' || permissions === '医生组') &&
          (JSON.parse(sdPatientInfo).status == 1 ||
              JSON.parse(sdPatientInfo).status == 3 ||
              JSON.parse(sdPatientInfo).status == 5)
      ) {
        // 提交 驳回 作废 终审 审核
        btnStr =
            '<button id="submit" type="button" data-name=' +
            type +
            ' class="btn-info" style="margin: 10px">提 交</button>' +
            '<button type="button" id="save" class="btn-info">取 消</button>'
      } else {
        btnStr =
            '<button type="button" id="save" class="btn-info">取 消</button>'
      }

      $('.submit-button').append(btnStr)
      // 草稿箱渲染
      draftRender(diseaseId, sid, patientCode, cysj, permissions, sdPatientInfo)
      // 数据管理渲染
      if (diseaseId && diseaseId !== 'undefined' && check === 'true') {
        $('select').attr('disabled', true)
        $('input').attr('disabled', true)
        dataManageCheck(diseaseId)
      }
      // 退回渲染
      if (diseaseId && diseaseId !== 'undefined' && back === 'true') {
        dataManageCheck(diseaseId)
      }
      // 动态创建费用提示
      var tipCostStr =
          '<div id="OverfulfillTip" class="modal fade bs-example-modal-sm" tabindex="-1" data-backdrop="static" role="dialog" aria-labelledby="提示" style="top: 30% !important;">' +
          '<div class="modal-dialog modal-sm" role="document" style="width: 400px;">' +
          '<div class="modal-content">' +
          '<div class="scoreHeader">提示</div>' +
          '<div class="resultScore">总费用已超过20万,请确认费用填写是否正确!</div>' +
          '<div class="scoreFooter">' +
          '<button class="calculate btn btn-primary">确定</button>' +
          '</div>' +
          '</div>' +
          '</div>' +
          '</div>'
      $('#form-content').after(tipCostStr)
      window.scrollTo(0, 0)
      //判断费用大于20万 做超额提示
      tipCost($('#create_CM_98'))
      //判断住院天数是否大于等于90 大于等于90终止上报
      daysGreater90($('#create_CM_77'))
      // 是否出院后31天终止上报
      stopReport('.create_CM_11')
      // 亚目编码与名称：主要诊断ICD-10六位临床扩展编码与名称
      var diseaseType = GetUrlParam('diseaseType')

      // ICD-10为多选的情况
      var mutiSelectDiseaseTypes = ['HBIPS', 'SEP', 'SEPT', 'RD', 'DDH', 'PACG']
      // ICD-10为单选走这里
      if (mutiSelectDiseaseTypes.indexOf(diseaseType) === -1) {
        selectChange('.create_CM_7')
        selectChange('.create_CM_8')
      }
      // 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称
      var singleSelectICD_9 = ['DVT'] // 部分病种选项包含了范围，在tools.js中单独判断
      if (singleSelectICD_9.indexOf(diseaseType) === -1) {
        selectMChange('CM_9')
        selectMChange('CM_10')
      }

      // HF  ICD-10联动
      HFselectChange('.create_HF_236')
      HFselectChange_2('.create_HF_237')

      // HBIPS特殊处理
      if (diseaseType == 'HBIPS') {
        // selectMChange('HBIPS_251')
        HFselectChange('.create_CM_7')
        HFselectChange_2('.create_CM_8')
      }

      // ICD-10 四位与六位 通常类型的多选判断
      var mutiSelectDiseaseTypesNormal = ['SEP', 'SEPT', 'RD', 'DDH', 'PACG']
      if (mutiSelectDiseaseTypesNormal.indexOf(diseaseType) > -1) {
        selectMChange('CM_7')
        selectMChange('CM_8')
      }
      // 页面渲染完执行单独页面回调
      callback()
      // 去掉评分表
      if (diseaseId && diseaseId !== 'undefined' && check === 'true') {
        $('.score-table').remove()
      }
      // 根据身份证号设置出生日期
      $('#create_CM_6').on('blur', function () {
        var idVal = $(this).val()
        if (check === 'true') {
          return
        }
        setBirthdayByIDNumber(idVal)
        // 模拟日期选择器对象 触发ageTips方法里面的判断
        if (!$('#create_CM_13').val()) {
          return
        }
        var datePickObj = {
          cal: {
            getNewDateStr: function () {
              return (
                  $('#create_CM_13').attr('data-value') ||
                  $('#create_CM_13').val()
              )
            },
          },
          el: '#create_CM_13',
        }
        ageTips(datePickObj, 'CM_13')
      })
      // DPD、HD切换身份证类型时清空身份证号和出生日期
      $('#create_DPD_813').on('change', function () {
        $('#create_CM_6').val('')
        $('#create_CM_13').val('')
        $('#create_CM_13').attr('disabled', false)
      })
    }
    // 整合后的初始化页面方法
    Create.prototype.createPage = function (result, type) {
      var data = {}
      // 是否是草稿箱数据
      if (type !== 'drgsbox') {
        data = result.reportContent.data
        var roleId = JSON.parse(sessionStorage['userInfo']).roleId,
            examineObj = {}
        switch (roleId) {
          case '1004':
            examineObj = exmainHandle(result.hosAdminAuditStatus, result.reason)
            break
          case '1005':
            examineObj = exmainHandle(result.reportAuditStatus, result.reason)
            break
            // 1001 1002 1003 1006 100101 100301 100302
          default:
            examineObj = exmainHandle(result.sysAdminAuditStatus, result.reason)
        }
        var examineStr =
            '<div id="examine" style="display:flex;align-items:center;justify-content:space-between;margin:0 15px 10px;border-radius:2px;' +
            examineObj.color +
            'height:40px;line-height:40px;">' +
            '<div><img style="width:16px;height:16px;margin: 0 7px 3px 16px;" src=' +
            examineObj.img +
            '>' +
            '<span>' +
            examineObj.value +
            '</span></div>' +
            '<img class="examine-img" style="width:12px;height:12px;margin-right:16px;cursor:pointer;" onclick="closeHandle" src="../img/close.png"/>' +
            '</div>'
        if (examineObj.color) {
          $('#form-content').before(examineStr)
        }
        // 关闭审核提示
        $('.examine-img').click(function () {
          $('#examine').remove()
        })
      } else {
        data = result
      }
      // 首次加载，触发联动
      this.innerRender(data, function (ele) {
        $(ele).change()
        $(ele).blur()
      })
    }
    //渲染数据，补填数据
    Create.prototype.innerRender = function (data, callback) {
      var check = GetUrlParam('check')
      for (var key in data) {
        var ele = $('input[name=' + key + ']')
        var val = data[key]
        if (!ele.get(0)) {
          ele = $('select[name=' + key + ']')
          if (!ele.get(0)) {
            continue
          }
        }
        if (ele.attr('type') == 'radio') {
          for (var i = 0; i < ele.length; i++) {
            if ($(ele[i]).get(0).value == val) {
              $(ele[i]).get(0).checked = true
              break
            }
          }
        } else if (ele.attr('type') == 'checkbox') {
          var val = val == null || val == '' ? [] : val.split(',')
          for (var i = 0; i < ele.length; i++) {
            for (var j = 0; j < val.length; j++) {
              if ($(ele[i]).get(0).value == val[j]) {
                $(ele[i]).get(0).checked = true
              }
            }
          }
        } else {
          if ($(ele).attr('data-type') == 'listMultiple') {
            //下拉多选  填报赋值
            var list = $(ele).parent().next().children()
            var val_arr = val == null ? [] : val.split(',')
            var show_list = []
            if (check == 'false') {
              for (var k = 0; k < list.length; k++) {
                for (var m = 0; m < val_arr.length; m++) {
                  if (
                      $(list[k]).children('input').attr('value') == val_arr[m]
                  ) {
                    $(list[k]).children('input').get(0).checked = true
                    show_list.push($(list[k]).children('span').text())
                    var eleId = $(list[k]).children('span').attr('date-id')
                    var linkSpan = $(list[k]).children('span')
                    selectMcheck(linkSpan, eleId, true)
                  }
                }
              }
              $(ele).get(0).value = show_list.join(',')
            } else {
              var eles = ''
              for (var k = 0; k < list.length; k++) {
                for (var m = 0; m < val_arr.length; m++) {
                  if (
                      $(list[k]).children('input').attr('value') == val_arr[m]
                  ) {
                    $(list[k]).children('input').get(0).checked = true
                    /*eles +=
                        '<div style="padding-left: 314px;line-height:40px;">' +
                        $(list[k]).children('span').text() +
                        '</div>'*/
                    var eleId = $(list[k]).children('span').attr('date-id')
                    var linkSpan = $(list[k]).children('span')
                    selectMcheck(linkSpan, eleId, true)
                  }
                }
              }
              $(ele)
                  .parent()
                  .parent()
                  .prev('span')
                  .css({ background: 'none', 'border-right': 'none' })
              $(ele).parent().parent().after(eles)
              // $(ele).hide()
            }
          } else {
            $(ele).get(0).value = val
            setCityAndArea(key, ele, val)
          }
          // 显示数据过多加title移上显示
          if (ele.is('select')) {
            var selectSize = ele.find('option:selected').text().length
            if (selectSize > 20) {
              ele.attr('title', ele.find('option:selected').text())
            }
          }
          if (ele.is('input')) {
            var inputSize = ele.val().length
            if (inputSize > 20) {
              ele.attr('title', ele.val())
            }
          }
        }
        if (callback) {
          // 有些指标不需要触发联动
          var noneedKey = [
            'HD-0-1-4-1',
            'HD-0-1-4-4',
            'HD-0-1-4-5',
            'DPD-0-1-4-4',
            'DPD-0-1-4-5',
            'DPD-0-1-4-6',
          ]
          if (noneedKey.indexOf(key) === -1) {
            callback($(ele))
          }
        }
        // 删除错误提示
        if (check === 'true') {
          $('.error').remove()
        }
      }

      // 判断出院日期是否为2021
      hospitalization2021('CM_17')
      // clearIDNumber();
      setCitySelectorValue()
      setAreaSelectorValue()
    }
    // 获取数据，获取提交JSON
    Create.prototype.getData = function () {
      var age = $('#contend').find('input[name=age]').get(0).value
      var json = {}
      var parentDivs = $('#contend').children('.slot-item:visible')
      parentDivs.find('input').addClass('submitText')
      parentDivs.find('select').addClass('submitText')
      var divs = parentDivs.find('.form-box1 div')
      for (var i = 0; i < divs.length; i++) {
        if (
            $(divs[i]).get(0).style.display == 'none' &&
            !$(divs[i]).hasClass('form-box1')
        ) {
          $(divs[i]).find('input').removeClass('submitText')
          $(divs[i]).find('select').removeClass('submitText')
        }
      }
      var elems = parentDivs.find('.submitText')
      for (var i = 0; i < elems.length; i++) {
        if (elems[i].name) {
          if ($(elems[i]).get(0).tagName == 'INPUT') {
            var name = $(elems[i]).attr('name')
            if ($(elems[i]).attr('type') == 'radio') {
              json[name] = $('input[name=' + name + ']:checked').val()
              continue
            } else if ($(elems[i]).attr('type') == 'checkbox') {
              var vals = $('input[name=' + name + ']:checked')
              var values = []
              for (var j = 0; j < vals.length; j++) {
                values.push($(vals[j]).val())
              }
              json[name] = values
              continue
            } else if ($(elems[i]).attr('data-type') == 'listMultiple') {
              // 下拉多选
              var pEle = $(elems[i])
                  .parent()
                  .next()
                  .children()
                  .children('input')
              var listArr = []
              for (var k = 0; k < pEle.length; k++) {
                if ($(pEle[k]).get(0).checked) {
                  listArr.push($(pEle[k]).attr('value'))
                }
              }
              json[name] = listArr
              continue
            }
          }
          if ($(elems[i]).get(0).tagName == 'SELECT') {
            var name = $(elems[i]).attr('name')
            if ($(elems[i]).get(0).value == 'def') {
              continue
            }
          }
          var val = $(elems[i]).get(0).value
          if ($(elems[i]).attr('type') == 'number') {
            if (val === '') {
              continue
            }
            val = val * 1
            if (isNaN(val)) {
              val = null
            }
          }
          json[$(elems[i]).attr('name')] = val
        }
      }
      $(elems).removeClass('submitText')
      var board = $('.board')
      for (var i = 0; i < board.length; i++) {
        var val = $(board[i]).val()
        if ($(board[i]).attr('type') == 'number') {
          if (val === '') {
            continue
          }
          val = val * 1
          if (isNaN(val)) {
            continue
          }
        }
        if ($(board[i]).get(0).tagName == 'SELECT') {
          val = $(board[i]).get(0).value
        }
        json[$(board[i]).attr('name')] = val
      }
      // 特殊病种的年龄计算
      // 完全没有入院日期
      var noInHospitalDateDiseases = ['OIT']
      // 在某些条件下没有入院日期
      var noInHosDateSpecialDiseases = ['APL', 'ALL']
      // 特殊儿童病种 需要在提交的时候判断年龄
      var specialChildDiseases = ['APL', 'ALL']
      var diseaseType = $('#diseaseType').val()
      var finalAge = 0
      var timeNow = new Date().getTime()
      var birthDayTimeStemp = new Date($('#create_CM_13').val()).getTime()
      // APL和ALL选择日间化疗时没有入院日期
      var specialChildModeVal = $(
          'select[name=' + diseaseType + '-0-1-1]'
      ).val()
      if (
          specialChildDiseases.indexOf(diseaseType) > -1 &&
          specialChildModeVal === 'a'
      ) {
        finalAge = getAge(birthDayTimeStemp, timeNow)
        var eleHtml =
            '<div id="electrocar" class="end-report-content">' +
            '<img class="end-img" src="../img/report-warn.png"/>' +
            '<span class="end-title">该病例不符合上报要求</span>' +
            '<p class="end-content">仅限于2至18岁人群上报</p></div>'
        var factor = age < 2 || age > 18
        if (factor) {
          reportConfirm(eleHtml, function () {
            $('#create_CM_13').val('')
          })
          return false
        }
      }
      if (
          noInHospitalDateDiseases.indexOf(diseaseType) > -1 ||
          (noInHosDateSpecialDiseases.indexOf(diseaseType) > -1 &&
              specialChildModeVal === 'a')
      ) {
        finalAge = getAge(birthDayTimeStemp, timeNow)
      } else {
        finalAge = age
      }
      //请求字段
      var disease = {}
      disease.diseaseType = diseaseType
      disease.age = Number(finalAge) || 0
      disease.caseId = json['caseId']
      disease.data = json
      return disease
    }
    // 检查页面提交数据
    Create.prototype.checkSubmit = function checkSubmit() {
      $('.complete').parent().click()
      var formData = $('.slot-item').find('p')
      for (var i = 0; i < formData.length; i++) {
        if (
            $(formData[i]).parent().css('display') == 'none' ||
            ($(formData[i]).parent().parent().parent().css('display') == 'none' &&
                $(formData[i]).parent().parent().parent().hasClass('slot-item'))
        ) {
          continue
        }
        if ($(formData[i]).get(0).style.color == 'red') {
          return false
        }
      }
      return true
    }
  })
  /**
   * @description: 监听页面无操作超时(vue父页面无法直接监听到iframe内容)
   * @param {function} callback 超时后执行的回调
   * @param {number} second     超时时间 单位：秒
   * @param {object|null} timer 定时器timer
   * @return {*}
   */
  function listenPageOperation(callback, second) {
    clearInterval(CREATE_PUBLIC.overTimer)
    CREATE_PUBLIC.overTimeCount = 0
    var resSetCount = function () {
      CREATE_PUBLIC.overTimeCount = 0
      window.top.postMessage(
          { name: 'drgTemplate', message: 'isNotOverTime' },
          '/'
      )
    }
    var countTime = function () {
      CREATE_PUBLIC.overTimeCount++
      if (CREATE_PUBLIC.overTimeCount >= second) {
        callback()
        CREATE_PUBLIC.overTimeCount = 0
        // clearInterval(timer);
      }
    }
    // 监听鼠标移动
    window.addEventListener('mousemove', resSetCount)
    // 监听鼠标滚轮
    window.addEventListener('mousewheel', resSetCount)
    // 监听鼠标点击
    window.addEventListener('click', resSetCount)
    // 监听键盘
    window.addEventListener('keydown', resSetCount)

    CREATE_PUBLIC.overTimer = setInterval(countTime, 1000)
  }
})()
// 终止上报弹框
function reportConfirm(content, close) {
  var check = GetUrlParam('check')
  // 不是查看的时候在弹框提示
  if (check !== 'true') {
    layer.open({
      type: 1, //Page层类型
      area: ['424px', '192px'],
      offset: '150px',
      move: false,
      title: false,
      shade: 0.6, //遮罩透明度
      skin: 'end-report',
      id: 'layerId',
      closeBtn: 0,
      maxmin: false, //允许全屏最小化
      btn: ['取消', '确定'],
      btnAlign: 'r',
      content,
      yes: function (index) {
        close()
        layer.close(index)
      },
      btn2: function (index) {
        window.history.go(-1)
        layer.close(index)
      },
      end: function () {
        close()
      },
    })
  }
}
// 费用提示
function tipCost(ele) {
  ele.keyup(function () {
    if ($(this).val() > 200000) {
      $('#OverfulfillTip').modal()
    }
  })
  $('#OverfulfillTip .calculate').click(function () {
    $('#OverfulfillTip').modal('hide')
    ele.focus()
  })
}
// 住院天数 大于等于90
function daysGreater90(ele) {
  var diseaseType = GetUrlParam('diseaseType')

  ele.change(function () {
    if ($(this).val() > 90 && diseaseType != 'HBIPS') {
      var unsureHtml =
          '<div id="unsure" class="end-report-content">' +
          '<img class="end-img" src="../img/report-warn.png"/>' +
          '<span class="end-title">该病例不符合上报要求</span>' +
          '<p class="end-content">住院时间超过90天，终止上报。</p></div>'
      reportConfirm(unsureHtml, unsureClose)
    } else if ($(this).val() > 365 && diseaseType == 'HBIPS') {
      var unsureHtml =
          '<div id="unsure" class="end-report-content">' +
          '<img class="end-img" src="../img/report-warn.png"/>' +
          '<span class="end-title">该病例不符合上报要求</span>' +
          '<p class="end-content">住院时间超过365天，终止上报。</p></div>'
      reportConfirm(unsureHtml, unsureClose)
    }
  })
}
function unsureClose() {
  $('#create_CM_16').val('')
  $('#create_CM_17').val('')
}
// 权限
function hasPerm(permissiion) {
  var btns = JSON.parse(sessionStorage.getItem('userInfo')).authority.ids || []
  return btns.indexOf(permissiion) > -1
}
// 审核处理
function exmainHandle(state, reason) {
  // 审核理由
  var examineObj = {}
  if (state === '审核通过') {
    examineObj.img = '../img/adopt.png'
    examineObj.value = reason ? reason : '恭喜！你所上报的单病种已经审核通过。'
    examineObj.color = 'background: #F6FFED;border: 1px solid #B7EB8F;'
  }
  if (state === '作废') {
    examineObj.img = '../img/nullify.png'
    examineObj.value = '作废理由：' + (reason ? reason : '无')
    examineObj.color = 'background: #FFF1F0;border: 1px solid #FFA39E;'
  }
  if (state === '退回' || state === '上级退回' || state === '退回至填报员') {
    examineObj.img = '../img/return.png'
    examineObj.value = '退回理由：' + (reason ? reason : '无')
    examineObj.color = 'background: #FFFBE6;border: 1px solid #FFE58F;'
  }
  return examineObj
}

/**
 * @description: 计算年龄
 * @param {number} birthStemp 出生日期(时间戳)
 * @param {number} standardStemp 入院/上报日期(时间戳)
 * @param {string} unit 返回值单位，默认为年
 * @return {number | string}
 */
function getAge(birthStemp, standardStemp, unit) {
  if (birthStemp && standardStemp) {
    var diff = standardStemp - birthStemp
    if (unit && unit === 'm') {
      // 返回月份
      return Math.floor((diff / (24 * 3600 * 1000 * 365)) * 12)
    } else {
      return Math.floor(diff / (24 * 3600 * 1000 * 365))
    }
  } else {
    return 'unknown'
  }
}

// 年龄提示
function ageTips(obj, ele) {
  // DDH 18月-8岁可上报
  // 仅限2-18岁上报
  var childrenArr = ['Cap', 'CACC', 'APL', 'ALL']
  // 无年龄限制
  var noAge = ['EAR', 'VSD', 'ASD', 'OIT', 'PIP', 'HD', 'DPD']
  // 其余病种仅限18岁以上上报
  var factor,
      age,
      eleHtml = '',
      diseaseType = GetUrlParam('diseaseType'),
      timeValue = obj.cal.getNewDateStr()
  // 无年龄限制
  if (noAge.indexOf(diseaseType) != -1) {
    return false
  }
  var birthDayTimeStemp, standardTimeStemp
  // 选中入院日期时，出生日期从DOM取值
  if (ele === 'CM_16') {
    // data-value是日期选择器选择时生成的，没有走日期选择器时直接取value
    var birthDay =
        $('#create_CM_13').attr('data-value') || $('#create_CM_13').val()
    birthDayTimeStemp = new Date(birthDay).getTime()
    standardTimeStemp = new Date(timeValue).getTime()
  } else {
    if (!$('#create_CM_16').val()) {
      return
    }
    var standardTime =
        $('#create_CM_16').attr('data-value') || $('#create_CM_16').val()
    birthDayTimeStemp = new Date(timeValue).getTime()
    standardTimeStemp = new Date(standardTime).getTime()
  }
  age = getAge(birthDayTimeStemp, standardTimeStemp)
  if (diseaseType == 'DDH') {
    // 18月-----8岁
    eleHtml =
        '<div id="electrocar" class="end-report-content">' +
        '<img class="end-img" src="../img/report-warn.png"/>' +
        '<span class="end-title">该病例不符合上报要求</span>' +
        '<p class="end-content">仅限于18月至8岁人群上报</p></div>'
    age = getAge(birthDayTimeStemp, standardTimeStemp, 'm')
    factor = age < 18 || age > 96
    if (factor) {
      reportConfirm(eleHtml, function () {
        $(obj.el).val('')
      })
    }
  } else if (childrenArr.indexOf(diseaseType) != -1) {
    eleHtml =
        '<div id="electrocar" class="end-report-content">' +
        '<img class="end-img" src="../img/report-warn.png"/>' +
        '<span class="end-title">该病例不符合上报要求</span>' +
        '<p class="end-content">仅限于2至18岁人群上报</p></div>'
    factor = age < 2 || age > 18
    if (factor) {
      reportConfirm(eleHtml, function () {
        $(obj.el).val('')
      })
    }
  } else {
    eleHtml =
        '<div id="electrocar" class="end-report-content">' +
        '<img class="end-img" src="../img/report-warn.png"/>' +
        '<span class="end-title">该病例不符合上报要求</span>' +
        '<p class="end-content">仅限18岁以上人群上报</p></div>'
    factor = age < 18
    if (factor) {
      reportConfirm(eleHtml, function () {
        $(obj.el).val('')
      })
    }
  }
}
// 出院日期大于等于2021年或者未填时则显示身份证号，否则隐藏
function hospitalization2021(obj, ele) {
  var timeValue
  if (obj == 'CM_17') {
    // fix:修复未获取到值而阻碍后续代码执行的bug
    timeValue = $('#create_' + obj).val() || '-'
  } else {
    timeValue = obj.cal.getNewDateStr()
  }
  var birArr = timeValue.split('-')
  var birYear = birArr[0]
  if (birYear >= 2021 || birYear == '') {
    $('#itemCM_6').show()
  } else {
    $('#itemCM_6').hide()
  }
}
function stopReport(ele) {
  var eleHtml =
      '<div id="electrocar" class="end-report-content">' +
      '<img class="end-img" src="../img/report-warn.png"/>' +
      '<span class="end-title">该病例不符合上报要求</span>' +
      '<p class="end-content">请重新填报</p></div>'
  //终止上报
  $($(ele)[0])
      .next('span')
      .click(function () {
        reportConfirm(eleHtml, function () {
          $(ele).get(0).checked = false
        })
      })
}
// 主要诊断ICD-10四位亚目编码与名称：  与  主要诊断ICD-10六位临床扩展编码与名称进行联动隐藏
function selectChange(ele) {
  var diseaseType = GetUrlParam('diseaseType')
  $(ele).on('change', function () {
    var a = $(ele).find('option:selected').text()
    if (
        a.indexOf('.') != -1 &&
        diseaseType != 'HBIPS' &&
        ele == '.create_CM_7'
    ) {
      // 含有小数点
      var str_sub = a.substring(0, a.indexOf('.') + 2)
    } else if (
        a.indexOf('.') == -1 &&
        diseaseType != 'HBIPS' &&
        ele == '.create_CM_7'
    ) {
      var str_sub = a.substring(0, 3)
    } else {
      var a_key = $(ele).find('option:selected').val()
      var str_index = escape(a).indexOf('%u')
      var str_sub = unescape(escape(a).substring(0, str_index)).trim()
    }
    if (ele == '.create_CM_8') {
      var a_key = $(ele).find('option:selected').val()
      var b = $('.create_CM_7').find('option')
      if (a == '请选择' || a_key == 'oth') {
        $('.create_CM_7').find('option').show()
        return false
      }
    } else {
      var b = $('.create_CM_8').find('option')
      if (a == '请选择') {
        $('.create_CM_7').find('option').show()
        $('.create_CM_8').find('option').show()
        return false
      } else {
        // 判断联动项是否一个模块
        var Link_option = $('.create_CM_8').find('option:selected').text()
        var link_index = escape(Link_option).indexOf('%u')
        var link_sub = unescape(
            escape(Link_option).substring(0, link_index)
        ).trim()
        if (
            (link_sub.indexOf(str_sub) == -1 && link_sub != '') ||
            a_key == 'oth'
        ) {
          $('#create_CM_8').val('def')
        }
      }
    }
    for (var i = 0; i < b.length; i++) {
      var b_text = $(b[i]).text()
      var b_key = $(b[i]).val()
      if (ele == '.create_CM_8') {
        var str_index_2 = escape(b_text).indexOf('%u')
        var str_sub_2 = unescape(
            escape(b_text).substring(0, str_index_2)
        ).trim()

        if (
            b_text.indexOf('.') != -1 &&
            diseaseType != 'HBIPS' &&
            ele == '.create_CM_8'
        ) {
          // 含有小数点
          var str_sub_2 = b_text.substring(0, b_text.indexOf('.') + 2)
        } else if (
            b_text.indexOf('.') == -1 &&
            diseaseType != 'HBIPS' &&
            ele == '.create_CM_8'
        ) {
          var str_sub_2 = b_text.substring(0, 3)
        } else {
          var str_index_2 = escape(b_text).indexOf('%u')
          var str_sub_2 = unescape(
              escape(b_text).substring(0, str_index_2)
          ).trim()
        }
        if (
            str_sub.indexOf(str_sub_2) == -1 &&
            !(b_text == '请选择' || b_text == '无' || b_key == 'oth' || a == '无')
        ) {
          $(b[i]).hide()
        } else {
          $(b[i]).show()
        }
      } else {
        if (a_key == 'oth') {
          if (str_sub_2 != '') {
            $(b[i]).hide()
          } else {
            $(b[i]).show()
          }
        } else {
          if (
              b_text.indexOf(str_sub) == -1 &&
              !(b_text == '请选择' || b_text == '无' || b_key == 'oth')
          ) {
            $(b[i]).hide()
          } else {
            $(b[i]).show()
          }
        }
      }
    }
  })
}

// 主要手术操作栏中提取ICD-9-CM-3四位亚目编码与名称 联动 主要手术操作栏中提取ICD-9-CM-3六位临床扩展编码与名称
function selectMChange(no) {
  var diseaseType = GetUrlParam('diseaseType')
  var inputs = $('#selectMup_' + no)
      .children('div')
      .children('span')
  if (no == 'CM_10') {
    var inputs_link = $('#selectMup_CM_9').children('div').children('span')
  } else if (no == 'CM_9') {
    var inputs_link = $('#selectMup_CM_10').children('div').children('span')
  } else if (no == 'CM_7') {
    var inputs_link = $('#selectMup_CM_8').children('div').children('span')
  } else if (no == 'CM_8') {
    var inputs_link = $('#selectMup_CM_7').children('div').children('span')
  }
  if ($('#create_' + no).get(0)) {
    if ($('#create_' + no).get(0).tagName == 'SELECT') {
      // 下拉
      $('#create_' + no).on('change', function () {
        var a = $('#create_' + no)
            .find('option:selected')
            .text()
        if (a.indexOf('.') != -1 && no != 'CM_10') {
          // 含有小数点
          var str_sub_t = a.substring(0, a.indexOf('.') + 3).trim()
          var str_index_t = escape(str_sub_t).indexOf('%u')
          var str_sub
          if (str_index_t == -1) {
            str_sub = str_sub_t
          } else {
            str_sub = unescape(
                escape(str_sub_t).substring(0, str_index_t)
            ).trim()
          }
        } else if (
            a.indexOf('.') != -1 &&
            no == 'CM_10' &&
            a.indexOf('x') == 5
        ) {
          var str_sub = a.substring(0, 4).trim()
        } else {
          var str_index = escape(a).indexOf('%u')
          var str_sub = unescape(escape(a).substring(0, str_index)).trim()
        }
        var a_key = $('#create_' + no)
            .find('option:selected')
            .val()
        if (no == 'CM_10') {
          var b = $('.create_CM_9').find('option')
        } else {
          var b = $('.create_CM_10').find('option')
          $('.create_CM_9').find('option:selected').siblings().show()
          // 判断联动项是否一个模块
          var Link_option = $('.create_CM_10').find('option:selected').text()
          var link_index = escape(Link_option).indexOf('%u')
          var link_sub = unescape(
              escape(Link_option).substring(0, link_index)
          ).trim()
          if (
              (link_sub.indexOf(str_sub) == -1 && link_sub != '') ||
              a_key == 'oth'
          ) {
            $('.create_CM_10').val('def')
          }
        }
        // if(diseaseType == 'HBIPS' && no == 'CM_9'){
        // 	var  b = $("#create_HBIPS_251").find('option')
        // }
        for (var i = 0; i < b.length; i++) {
          // 联动
          var b_text = $(b[i]).text()
          var b_key = $(b[i]).val()
          // var str_index_2 = escape(b_text).indexOf( "%u" )
          // var str_sub_2 = unescape(escape(b_text).substring(0,str_index_2)).trim()
          if (b_text.indexOf('.') != -1 && no != 'CM_10') {
            // 含有小数点
            var str_sub_t2 = b_text.substring(0, b_text.indexOf('.') + 3)
            var str_index_t = escape(str_sub_t2).indexOf('%u')
            var str_sub_2
            if (str_index_t == -1) {
              str_sub_2 = str_sub_t2
            } else {
              str_sub_2 = unescape(
                  escape(str_sub_t2).substring(0, str_index_t)
              ).trim()
            }
          } else if (
              b_text.indexOf('.') != -1 &&
              no == 'CM_10' &&
              b_text.indexOf('x') == 5
          ) {
            var str_sub_2 = b_text.substring(0, 4).trim()
          } else {
            var str_index_2 = escape(b_text).indexOf('%u')
            var str_sub_2 = unescape(
                escape(b_text).substring(0, str_index_2)
            ).trim()
          }

          if (no == 'CM_10') {
            if (a != '请选择') {
              if (
                  str_sub.indexOf(str_sub_2) == -1 &&
                  !(a == '无' || a_key == 'oth')
              ) {
                $(b[i]).hide()
              } else {
                $(b[i]).show()
              }
            } else {
              if (a == '请选择' && a_key != 'oth') {
                $('.create_CM_9').find('option:selected').siblings().show()
              }
            }
          } else {
            if (a_key == 'oth') {
              // 亚目为其他
              if (b_text != '请选择' && b_text != '无' && b_key != 'oth') {
                $(b[i]).hide()
              } else {
                $(b[i]).show()
              }
            } else {
              if (
                  b_text.indexOf(str_sub) == -1 &&
                  !(b_text == '请选择' || b_text == '无' || b_key == 'oth')
              ) {
                $(b[i]).hide()
              } else {
                $(b[i]).show()
              }
            }
          }
        }
      })
    } else {
      // 多选
      for (var i = 0; i < inputs.length; i++) {
        $(inputs[i]).on('click', function () {
          if (no == 'CM_10') {
            $('#selectMup_CM_9').children('div').hide()
            var select_val = $('#create_CM_10').val().split(',')
          } else if (no == 'CM_8') {
            $('#selectMup_CM_7').children('div').hide()
            var select_val = $('#create_CM_8').val().split(',')
          } else if (no == 'CM_9') {
            $('#selectMup_CM_10').children('div').hide()
            var select_val = $('#create_CM_9').val().split(',') //联动下拉值
            // $("#create_CM_10").val('')
            var change_ele = $('#selectMup_CM_9').children('div')
            for (var k = 0; k < change_ele.length; k++) {
              $(change_ele[k]).show()
            }
          } else if (no == 'CM_7') {
            $('#selectMup_CM_8').children('div').hide()
            var select_val = $('#create_CM_7').val().split(',') //联动下拉值
            // $("#create_CM_8").val('')
            var change_ele = $('#selectMup_CM_7').children('div')
            for (var k = 0; k < change_ele.length; k++) {
              $(change_ele[k]).show()
            }
          }

          for (var m = 0; m < inputs_link.length; m++) {
            var test_link = $(inputs_link[m]).text()

            if (test_link.indexOf('.') != -1 && no != 'CM_10' && no != 'CM_8') {
              // 含有小数点
              var str_sub_t1 = test_link
                  .substring(0, test_link.indexOf('.') + 3)
                  .trim()
              var str_index_t = escape(str_sub_t1).indexOf('%u')
              if (str_index_t == -1) {
                var str_sub_1 = str_sub_t1
              } else {
                var str_sub_1 = unescape(
                    escape(str_sub_t1).substring(0, str_index_t)
                ).trim()
              }
            } else if (
                test_link.indexOf('.') != -1 &&
                (no == 'CM_10' || no == 'CM_8') &&
                test_link.indexOf('x') == 5
            ) {
              var str_sub_1 = test_link.substring(0, 4).trim()
            } else {
              var str_index_1 = escape(test_link).indexOf('%u')
              var str_sub_1 = unescape(
                  escape(test_link).substring(0, str_index_1)
              ).trim()
            }
            // 联动元素
            for (var n = 0; n < select_val.length; n++) {
              var test = select_val[n]
              var nowEle = $('#selectMup_' + no).children('div')
              if (select_val.indexOf('无') != -1) {
                $(inputs_link[m]).parent().show()
                // 选择无时  其他选项无法进行选择  并且清空其他项
                for (var p = 0; p < nowEle.length; p++) {
                  if ($(nowEle[p]).children('span').text() == '无') {
                  } else {
                    if ($(nowEle[p]).css('display') != 'none') {
                      $(nowEle[p]).attr('data-show', 'true')
                      $(nowEle[p]).hide()
                    }
                    $(nowEle[p]).children('input').get(0).checked = false

                    if ($(nowEle[p]).children('input').get(0).value == 'oth') {
                      selectMcheck(
                          $(nowEle[p]).children('span')[0],
                          'CM_10',
                          true
                      )
                    }
                  }
                }
                $('#create_' + no).val('无')
              } else {
                for (var p = 0; p < nowEle.length; p++) {
                  if ($(nowEle[p]).attr('data-show') == 'true') {
                    $(nowEle[p]).attr('data-show', 'false')
                    $(nowEle[p]).show()
                  }
                }
                if (select_val.length == 1 && select_val[0] == '') {
                  if (no == 'CM_10') {
                    $('#selectMup_CM_9').children('div').show()
                  }
                  if (no == 'CM_8') {
                    $('#selectMup_CM_7').children('div').show()
                  }
                }
              }
              if (
                  select_val[n].indexOf('其他') != -1 &&
                  (no == 'CM_10' || no == 'CM_8')
              ) {
                $(inputs_link[m]).parent().siblings().show()
                return false
              }

              if (test.indexOf('.') != -1 && no != 'CM_10' && no != 'CM_8') {
                // 含有小数点
                var str_sub_t1 = test.substring(0, test.indexOf('.') + 3).trim()
                var str_index_t = escape(str_sub_t1).indexOf('%u')
                if (str_index_t == -1) {
                  var str_sub = str_sub_t1
                } else {
                  var str_sub = unescape(
                      escape(str_sub_t1).substring(0, str_index_t)
                  ).trim()
                }
              } else if (
                  test.indexOf('.') != -1 &&
                  (no == 'CM_10' || no == 'CM_8') &&
                  test.indexOf('x') == 5
              ) {
                var str_sub = test.substring(0, 4).trim()
              } else {
                var str_index = escape(test).indexOf('%u')
                var str_sub = unescape(
                    escape(test).substring(0, str_index)
                ).trim()
              }

              if (no == 'CM_10' || no == 'CM_8') {
                if (select_val[n] == '无') {
                  $(inputs_link[m]).parent().show()
                }
                if (
                    str_sub.indexOf(str_sub_1) != -1 &&
                    (test_link != '无' || test_link != '其他')
                ) {
                  $(inputs_link[m]).parent().show()
                }

                if ($(inputs_link[m]).prev().get(0).checked) {
                  $(inputs_link[m]).parent().show()
                }
              } else {
                $(inputs_link[m]).prev().get(0).checked = false
                if (str_sub_1.indexOf(str_sub) != -1 && str_sub != '') {
                  $(inputs_link[m]).parent().show()
                }
                if (test.indexOf('其他') != -1) {
                  if (test_link == '无' || str_sub_1 == '') {
                    $(inputs_link[m]).parent().show()
                  }
                } else {
                  if (test_link == '无' || str_sub_1 == '') {
                    $(inputs_link[m]).parent().show()
                  }
                  if (
                      (test_link == '其他' || str_sub == '') &&
                      select_val.length == 1
                  ) {
                    $(inputs_link[m]).parent().show()
                    // $(inputs_link[m]).parent().siblings().show()
                  }
                }
              }
            }
          }
          if (select_val.length == 0) {
            $('#selectMup_CM_10').children('div').show()
            $('#selectMup_CM_8').children('div').show()
          }

          // 判断细目选中项是否含在列表中  CM_9
          if (no == 'CM_9') {
            var change_ele = $('#selectMup_CM_10').children('div')
            var change_text = $('#create_CM_10').val().split(',')
            var change_ele_arr = []
            for (var n = 0; n < change_ele.length; n++) {
              var otherText = $(change_ele[n]).children('span').text()
              if ($(change_ele[n]).css('display') != 'none') {
                change_ele_arr.push(otherText)
              }
            }
            // 删除没有在联动模块内的值
            for (var h = 0; h < change_ele_arr.length; h++) {
              for (var j = 0; j < change_text.length; j++) {
                if (change_ele_arr.indexOf(change_text[j]) == -1) {
                  change_text.splice(j, 1)
                }
              }
            }
            $('#create_CM_10').val(change_text.join(','))
            // 重复项 勾选
            for (var n = 0; n < change_ele.length; n++) {
              var otherText = $(change_ele[n]).children('span').text()
              for (var m = 0; m < change_text.length; m++) {
                if (otherText == change_text[m]) {
                  $(change_ele[n]).children('input').get(0).checked = true
                }
              }
            }
          }
          // 判断细目选中项是否含在列表中  CM_7
          if (no == 'CM_7') {
            var change_ele = $('#selectMup_CM_8').children('div')
            var change_text = $('#create_CM_8').val().split(',')
            var change_ele_arr = []
            for (var n = 0; n < change_ele.length; n++) {
              var otherText = $(change_ele[n]).children('span').text()
              if ($(change_ele[n]).css('display') != 'none') {
                change_ele_arr.push(otherText)
              }
            }
            // 删除没有在联动模块内的值
            for (var h = 0; h < change_ele_arr.length; h++) {
              for (var j = 0; j < change_text.length; j++) {
                if (change_ele_arr.indexOf(change_text[j]) == -1) {
                  console.log('dfghjk', j)
                  change_text.splice(j, 1)
                }
              }
            }
            $('#create_CM_8').val(change_text.join(','))
            // 重复项 勾选
            for (var n = 0; n < change_ele.length; n++) {
              var otherText = $(change_ele[n]).children('span').text()
              for (var m = 0; m < change_text.length; m++) {
                if (otherText == change_text[m]) {
                  $(change_ele[n]).children('input').get(0).checked = true
                }
              }
            }
          }
        })
      }
    }
  }
}

/**
 * HF / HBIPS  联动项  上联动下
 * 第一诊断或第二诊断对应的原发疾病ICD-10的三位类亚目编码与名称：
 * 第一诊断或第二诊断对应的原发疾病ICD-10的三位类目编码与名称：
 */

function HFselectChange(ele) {
  $(ele).on('change', function () {
    var text = $(ele).find('option:selected').text()
    var str_index = escape(text).indexOf('%u')
    var str_sub = unescape(escape(text).substring(0, str_index)).trim()
    var second = 0
    var first = 0
    if (str_sub.indexOf('-') != -1) {
      var textArr = str_sub.split('-')
      first = parseInt(textArr[0].substring(1, 3))
      if (ele == '.create_CM_7') {
        second = parseInt(textArr[1].substring(1, 3)) + 1
      } else {
        second = parseInt(textArr[1].substring(1, 3)) + 1
      }
    } else {
      first = parseInt(str_sub.substring(1, 3))
      second = 0
    }

    // 判断是否联动的是一个模块
    if (ele == '.create_HF_236') {
      var link = $('.create_HF_237').find('option:selected').text()
      var str_index_2 = escape(link).indexOf('%u')
      var str_sub_2 = unescape(escape(link).substring(0, str_index_2)).trim()
      var str_text = parseFloat(str_sub_2.substring(1, str_sub_2.length))
      if (second == 0) {
        if (!(first <= str_text)) {
          $('#create_HF_237').val('def')
        }
      } else {
        if (!(first <= str_text && str_text <= second)) {
          $('#create_HF_237').val('def')
        }
      }

      if (link == '请选择') {
        $('.create_HF_237').find('option:selected').siblings().show()
      }
    }
    // 判断是否联动的是一个模块
    if (ele == '.create_CM_7') {
      var link = $('.create_CM_8').find('option:selected').text()
      var str_index_2 = escape(link).indexOf('%u')
      var str_sub_2 = unescape(escape(link).substring(0, str_index_2)).trim()
      if (str_sub_2.indexOf('.') != -1) {
        var str_text = parseFloat(
            str_sub_2.substring(1, str_sub_2.indexOf('.'))
        )
      } else {
        var str_text = parseFloat(
            str_sub_2.substring(1, str_sub_2.indexOf('x'))
        )
      }
      if (str_sub_2 != '' && str_sub != '') {
        if (second == 0) {
          if (!(first <= str_text)) {
            $('#create_CM_8').val('def')
          }
        } else {
          if (!(first <= str_text && str_text <= second)) {
            $('#create_CM_8').val('def')
          }
        }
      }

      if (link == '请选择' || text == '请选择') {
        $('.create_CM_8').find('option:selected').siblings().show()
        $('.create_CM_7').find('option:selected').siblings().show()
      }
    }
    if (ele == '.create_CM_7') {
      var b = $('.create_CM_8').find('option')
    } else {
      var b = $('.create_HF_237').find('option')
    }
    for (var i = 0; i < b.length; i++) {
      var b_text = $(b[i]).text()
      var b_key = $(b[i]).val()
      var str_index_2 = escape(b_text).indexOf('%u')
      var str_sub_2 = unescape(escape(b_text).substring(0, str_index_2)).trim()
      if (ele == '.create_CM_7') {
        if (str_sub_2.indexOf('.') == -1) {
          var str_text = str_sub_2.substr(1, str_sub_2.indexOf('x') - 1)
        } else {
          var str_text = str_sub_2.substr(1, str_sub_2.indexOf('.') - 1)
        }
      } else {
        var str_text = parseFloat(str_sub_2.substring(1, str_sub_2.length))
      }
      if (text != '请选择') {
        if (second == 0) {
          if (first <= str_text) {
            $(b[i]).show()
          } else if (str_sub_2 == '' || b_key == 'oth') {
            $(b[i]).show()
          } else {
            if (str_text < first && first == 5) {
              $(b[i]).show()
            } else {
              $(b[i]).hide()
            }
          }
        } else {
          if (first <= str_text && str_text < second) {
            $(b[i]).show()
          } else if (str_sub_2 == '' || b_key == 'oth') {
            $(b[i]).show()
          } else {
            if (str_text < first && first == 5) {
              $(b[i]).show()
            } else {
              $(b[i]).hide()
            }
          }
        }
      } else {
        $(ele).find('option:selected').siblings().show()
      }
    }
  })
}

/**
 * HF / HBIPS  联动项  下联动上
 * 第一诊断或第二诊断对应的原发疾病ICD-10的三位类亚目编码与名称：
 * 第一诊断或第二诊断对应的原发疾病ICD-10的三位类目编码与名称：
 */

function HFselectChange_2(ele) {
  $(ele).on('change', function () {
    var text = $(ele).find('option:selected').text()
    var str_index = escape(text).indexOf('%u')
    var str_sub = unescape(escape(text).substring(0, str_index)).trim()
    if (ele == '.create_CM_8') {
      var b = $('.create_CM_7').find('option')
      if (str_sub.indexOf('.') != -1) {
        var str_text = parseInt(str_sub.substring(1, str_sub.indexOf('.')))
      } else {
        var str_text = parseInt(str_sub.substring(1, str_sub.indexOf('x')))
      }
    } else {
      var str_text = parseFloat(str_sub.substring(1, str_sub.length))
      var b = $('.create_HF_236').find('option')
    }

    for (var i = 0; i < b.length; i++) {
      var b_text = $(b[i]).text()
      var b_key = $(b[i]).val()
      var str_index_2 = escape(b_text).indexOf('%u')
      var str_sub_2 = unescape(escape(b_text).substring(0, str_index_2)).trim()
      if (text == '无') {
        return false
      }
      if (text != '请选择') {
        if (str_sub_2.indexOf('-') != -1) {
          var textArr = str_sub_2.split('-')
          var first = parseInt(textArr[0].substring(1, 3))
          if (ele == '.create_CM_8') {
            var second = parseInt(textArr[1].substring(1, 3))
            if (
                first <= str_text &&
                str_text <= second &&
                !(str_sub == '' || b_key == 'oth')
            ) {
              $(b[i]).show()
            } else if (str_sub_2 == '' || b_key == 'oth') {
              $(b[i]).show()
            } else {
              if (str_text < first && first == 5) {
                $(b[i]).show()
              } else {
                $(b[i]).hide()
              }
            }
          } else {
            var second = parseInt(textArr[1].substring(1, 3)) + 1
            if (
                first <= str_text &&
                str_text < second &&
                !(str_sub == '' || b_key == 'oth')
            ) {
              $(b[i]).show()
            } else if (str_sub_2 == '' || b_key == 'oth') {
              $(b[i]).show()
            } else {
              if (str_text < first && first == 5) {
                $(b[i]).show()
              } else {
                $(b[i]).hide()
              }
            }
          }
        } else {
          var first = parseInt(str_sub_2.substring(1, 3))
          if (first <= str_text) {
            $(b[i]).show()
          } else if (str_sub_2 == '' || b_key == 'oth') {
            $(b[i]).show()
          } else {
            if (str_text < first && first == 5) {
              $(b[i]).show()
            } else {
              $(b[i]).hide()
            }
          }
        }
      } else {
        $(b[i]).show()
      }
    }
  })
}

// 编辑时进入页面清空身份证号(由后端完成)
function clearIDNumber() {
  var isCheck = getQueryVariable('check')
  if (isCheck !== 'true') {
    $('input[name="IDCard"]').val('')
    $('input[name="IDCard"]').blur()
  }
}

// 将城市和区县下拉框的值放入自定义属性以便页面上获取
function setCityAndArea(key, ele, value) {
  // var arr = ["HD-0-1-4-4", "HD-0-1-4-5", "DPD-0-1-4-5", "DPD-0-1-4-6"];
  var arr = ['areaId', 'cityId']
  if (arr.indexOf(key) > -1) {
    $(ele).attr('data-value', value)
  }
}

// 给市级下拉框赋值（血液透析和腹膜透析）
function setCitySelectorValue() {
  var pageType = getQueryVariable('type')
  var diseaseType = getQueryVariable('diseaseType')
  var isCheck = getQueryVariable('check')
  if ((pageType && pageType !== '1') || isCheck === 'true') {
    var provinceOldCode, provinceRealCode
    if (diseaseType === 'HD') {
      provinceOldCode = $('#create_HD_294').val()
      provinceRealCode = getRealProvinceCode(provinceOldCode) // 依赖handleProvinceSelect.js
      // 获取市级下拉框
      setCityOptions(provinceRealCode, '#create_HD_295')
    } else if (diseaseType === 'DPD') {
      provinceOldCode = $('#create_DPD_264').val()
      provinceRealCode = getRealProvinceCode(provinceOldCode)
      // 获取市级下拉框
      setCityOptions(provinceRealCode, '#create_DPD_265')
    }
  }
}

// 获取市级下拉框的option以及赋值
function setCityOptions(provinceRealCode, idSelector) {
  var optionDefault = '<option value="def">请选择</option>'
  if (provinceRealCode === 'def') {
    $(idSelector).html(optionDefault)
  } else {
    var cityDef = getCitys(provinceRealCode) // 依赖handleProvinceSelect.js
    cityDef.done(function (data) {
      var options = optionDefault
      data.forEach(function (val) {
        options += '<option value="' + val.code + '">' + val.name + '</option>'
      })
      $(idSelector).html(options)
      // 给所在市赋值
      var cityCode = $(idSelector).attr('data-value') || $(idSelector).val()
      $(idSelector).val(cityCode)
    })
  }
}

// 给区级下拉框赋值（血液透析和腹膜透析）
function setAreaSelectorValue() {
  var pageType = getQueryVariable('type')
  var diseaseType = getQueryVariable('diseaseType')
  var isCheck = getQueryVariable('check')
  // 不是新增都走这个方法
  if ((pageType && pageType !== '1') || isCheck === 'true') {
    var cityCode
    if (diseaseType === 'HD') {
      cityCode =
          $('#create_HD_295').attr('data-value') || $('#create_HD_295').val()
      setAreaOptions(cityCode, '#create_HD_296')
    } else if (diseaseType === 'DPD') {
      cityCode =
          $('#create_DPD_265').attr('data-value') || $('#create_DPD_265').val()
      setAreaOptions(cityCode, '#create_DPD_266')
    }
  }
}

// 获取区级下拉框option以及赋值
function setAreaOptions(cityCode, idSelector) {
  var optionDefault = '<option value="def">请选择</option>'
  if (cityCode === 'def') {
    $(idSelector).html(optionDefault)
  } else {
    var areaDef = getArea(cityCode) // 依赖handleProvinceSelect.js
    areaDef.done(function (data) {
      var options = optionDefault
      data.forEach(function (val) {
        options += '<option value="' + val.code + '">' + val.name + '</option>'
      })
      $(idSelector).html(options)
      // 给所在区赋值
      var areaCode = $(idSelector).attr('data-value') || $(idSelector).val()
      $(idSelector).val(areaCode)
    })
  }
}

// 根据身份证号获取出生日期
function setBirthdayByIDNumber(idNum) {
  // 身份证号填写完整且无加密时才获取出生日期
  if (idNum.length === 18 && idNum.indexOf('*') === -1) {
    var birthStr = idNum.slice(6, 14)
    var year = birthStr.slice(0, 4)
    var month = birthStr.slice(4, 6)
    var day = birthStr.slice(6, 8)
    var value = year + '-' + month + '-' + day
    $('#create_CM_13').val(value)
    $('#create_CM_13').attr('data-value', value)
    $('#create_CM_13').attr('disabled', true)
  } else {
    //存在香港身份证 如:H60176059 会把已经填写好的出生日期重置掉
    //$('#create_CM_13').val('');
    //$('#create_CM_13').attr('data-value', '');
    //$('#create_CM_13').attr('disabled', false);
  }
}

// 获取页面url中的参数
function getQueryVariable(variable) {
  var query = window.location.search.substring(1)
  var vars = query.split('&')
  for (var i = 0; i < vars.length; i++) {
    var pair = vars[i].split('=')
    if (pair[0] == variable) {
      return pair[1]
    }
  }
}
