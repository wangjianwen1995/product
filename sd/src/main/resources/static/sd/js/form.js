var diseaseId = GetUrlParam('diseaseId'),
    formVersion = GetUrlParam('num'),
    sid = null
let baseUrl = ''
//取消
$(document).on('click', '#save', function () {
    window.parent.handelMessage({
        msg: 1,
    })
})
// 提交数据
$(document).on('click', '#submit', function () {
    // 整模块校验
    if (!create.checkSubmit('submit')) {
        layer.msg('请逐条核对信息', {
            offset: '150px',
        })
        return
    } else {
        submitDaTA(1)
    }
})
/**
 * 表单保存
 */
$(document).on('click', '#save', function () {
    submitDaTA(1) //保存草稿
})

//flag 提交 1 保存 2 草稿箱提交 3 重新提交  4
function submitDaTA(flag, mb) {
    let sdPatientInfo = JSON.parse(localStorage.getItem('sdPatientInfo'))
    if (flag == 1) {
        sdPatientInfo.status = 2
    }
    var disease = create.getData()
    const keys = Object.keys(disease.data)
    const valus = Object.values(disease.data)
    let id = listId
    let diseaseObj = {
        id,
    }
    valus.forEach((item, index) => {
        if (item instanceof Array) {
        const k = item.join(',')
        diseaseObj[keys[index]] = k
    } else {
        diseaseObj[keys[index]] = item
    }
})
    var data = {
        sdinfo: diseaseObj,
        sdPatientInfo: sdPatientInfo,
        id: sdPatientInfo.sd_info_id,
        log: flag == 2 || flag == 3 ? flag : '',
    }
    if (flag == 1 || flag == 2) {
        $.ajax({
            url: baseUrl + '/sdi/update',
            type: 'put',
            headers: {
                'Content-Type': 'application/json;charset=utf8',
            },
            data: JSON.stringify(data),
            mask: true, //是否有loading,
        }).then(
            function (res) {
                if (res.state === 'success') {
                    $('#submit,#save').attr('disabled', true)
                    $('#submit,#save').css('cursor', 'not-allowed')
                    // window.parent.postMessage({
                    //   msg: 3,
                    // })
                    window.parent.handelMessage({ msg: 3 })
                } else {
                    window.parent.handelMessage({
                        msg: 5,
                    })
                }
            },
            function (err) {
                layer.msg(err, function () {
                    $('#submit,#save').attr('disabled', false)
                    $('#submit,#save').css('cursor', 'pointer')
                })
            }
        )
    } else if (flag == 3) {
        data['tempname'] = mb
        $.ajax({
            url: baseUrl + '/sdi/updateTp',
            type: 'put',
            headers: {
                'Content-Type': 'application/json;charset=utf8',
            },
            data: JSON.stringify(data),
            mask: true, //是否有loading,
        }).then(
            function (res) {
                if (res.state === 'success') {
                    $('#submit,#save').attr('disabled', true)
                    $('#submit,#save').css('cursor', 'not-allowed')
                    // window.parent.postMessage({
                    //   msg: 3,
                    // })
                    window.parent.handelMessage({ msg: 3 })
                } else {
                    window.parent.handelMessage({
                        msg: 5,
                    })
                }
            },
            function (err) {
                layer.msg(err, function () {
                    $('#submit,#save').attr('disabled', false)
                    $('#submit,#save').css('cursor', 'pointer')
                })
            }
        )
    }
}

//草稿箱渲染
var draftRender = function (
    diseaseId,
    sid,
    patientCode,
    cysj,
    permissions,
    sdPatientInfo
) {
    sid = sid
    let status = JSON.parse(sdPatientInfo).status
    let time = status == 1 ? cysj : cysj.substr(0, cysj.length - 3)
    $.ajax({
        url: baseUrl + `/sdi/findByID`,
        data: {
            sid,
            patientCode,
            cysj: time,
        },
        type: 'get',
        json: false,
        mask: true, //是否有loading,
    }).then(function (res) {
        if (res.state === 'success') {
            if (res.t) {
                if (res.t.list.length > 0) {
                    var result = res.t.list[0]
                    // console.log(result.id)
                    listId = result.id
                    // for (var key in res.t) {
                    //   if (!Array.isArray(res.t[key])) {
                    //     result[key] = res.t[key]
                    //   }
                    // }
                    console.log(result['CM-0-2-4-1'])
                    console.log(result['CM-0-1-4-1'])
                    if (result['CM-0-2-4-1']) {
                        result['CM-0-2-4-1'] = result['CM-0-2-4-1'].slice(0, 16)
                        result['CM-0-2-4-2'] = result['CM-0-2-4-2'].slice(0, 16)
                    }
                    if (result['CM-0-1-4-1'] && result['CM-0-1-4-1'] == null) {
                        result['CM-0-1-4-1'] = 'def'
                    }
                    localStorage.setItem('other_jbcode', res.t.other_jbcode)
                    localStorage.setItem('second_code', res.t.second_code)
                    localStorage.setItem('other_sscode', res.t.other_sscode)
                    localStorage.setItem('main_sscode', res.t.main_sscode)
                    localStorage.setItem('main_jbcode', res.t.main_jbcode)
                }

                setTimeout(function () {
                    // window.parent.postMessage({
                    //   msg: 2,
                    // })
                    window.parent.handelMessage({
                        msg: 2,
                    })
                })
                // console.log(result)
                create.createPage(result, 'drgsbox')
                return
            }
        }
    })
}

// 数据管理查看
var dataManageCheck = function (
    diseaseId,
    sid,
    patientCode,
    cysj,
    permissions,
    sdPatientInfo
) {
    sid = sid
    // console.log('sid,patientCode,cysj,permissions', sid,patientCode,cysj,permissions,sdPatientInfo)
    $.ajax({
        url: `${baseUrl}/sdi/findByID`,
        data: {
            sid,
            patientCode,
            cysj,
        },
        type: 'get',
        json: false,
        mask: true, //是否有loading,
    }).then(function (res) {
        if (res.state === 'success') {
            if (res.t) {
                if (res.t.list.length > 0) {
                    var result = res.t.list[0]
                    // console.log(result.id)
                    listId = result.id
                    // for (var key in res.t) {
                    //   if (!Array.isArray(res.t[key])) {
                    //     result[key] = res.t[key]
                    //   }
                    // }
                    console.log(result['CM-0-2-4-1'])
                    console.log(result['CM-0-1-4-1'])
                    if (result['CM-0-2-4-1']) {
                        result['CM-0-2-4-1'] = result['CM-0-2-4-1'].slice(0, 16)
                        result['CM-0-2-4-2'] = result['CM-0-2-4-2'].slice(0, 16)
                    }
                    if (result['CM-0-1-4-1'] && result['CM-0-1-4-1'] == null) {
                        result['CM-0-1-4-1'] = 'def'
                    }

                    localStorage.setItem('other_jbcode', res.t.other_jbcode)
                    localStorage.setItem('second_code', res.t.second_code)
                    localStorage.setItem('other_sscode', res.t.other_sscode)
                    localStorage.setItem('main_sscode', res.t.main_sscode)
                    localStorage.setItem('main_jbcode', res.t.main_jbcode)
                }

                setTimeout(function () {
                    window.parent.handelMessage({
                        msg: 2,
                    })
                })
                // console.log(result)

                create.createPage(result)
                return
            }
        }
    })
}

//加载模版
var loadTemplate = function (sid, patientCode, cysj, tempname) {
    sid = sid
    // console.log('sid,patientCode,cysj,permissions', sid,patientCode,cysj,permissions,sdPatientInfo)
    $.ajax({
        url: `${baseUrl}/sdi/findByIDTp`,
        data: {
            sid,
            patientCode,
            cysj,
            tempname,
        },
        type: 'get',
        json: false,
        mask: true, //是否有loading,
    }).then(function (res) {
        if (res.state === 'success') {
            if (res.t) {
                if (res.t.list.length > 0) {
                    var result = res.t.list[0]
                    // console.log(result.id)
                    listId = result.id
                    // for (var key in res.t) {
                    //   if (!Array.isArray(res.t[key])) {
                    //     result[key] = res.t[key]
                    //   }
                    // }

                    if (result['CM-0-2-4-1']) {
                        result['CM-0-2-4-1'] = result['CM-0-2-4-1'].slice(0, 16)
                        result['CM-0-2-4-2'] = result['CM-0-2-4-2'].slice(0, 16)
                    }
                    if (result['CM-0-1-4-1'] && result['CM-0-1-4-1'] == null) {
                        result['CM-0-1-4-1'] = 'def'
                    }

                    localStorage.setItem('other_jbcode', res.t.other_jbcode)
                    localStorage.setItem('second_code', res.t.second_code)
                    localStorage.setItem('other_sscode', res.t.other_sscode)
                    localStorage.setItem('main_sscode', res.t.main_sscode)
                    localStorage.setItem('main_jbcode', res.t.main_jbcode)
                }

                setTimeout(function () {
                    window.parent.handelMessage({
                        msg: 2,
                    })
                })

                create.createPage(result, 'drgsbox')
                return
            }
        }
    })
}

function GetUrlParam(key) {
    var reg = new RegExp('(^|&)' + key + '=([^&]*)(&|$)')
    var result = window.location.search.substr(1).match(reg)
    return result ? decodeURIComponent(result[2]) : null
}

/**
 * 评分表事件
 */
$(document).on('click', '.scoreTable .check-item', function () {
    if ($(this).closest('table').hasClass('multiple')) {
        $(this).toggleClass('active')
    } else if ($(this).closest('table').hasClass('Choice')) {
        $(this).toggleClass('active').parent('td')
        $(this)
            .parent()
            .siblings()
            .each(function () {
                $(this).find('.check-item').removeClass('active')
            })
    } else {
        var index = $(this).toggleClass('active').parent('td').index()
        $(this)
            .closest('tr')
            .siblings()
            .each(function () {
                $(this).find('td').eq(index).find('.check-item').removeClass('active')
            })
    }
    var scoreTable = $(this).closest('.scoreTable')
    var total = 0
    scoreTable.find('.check-item.active').each(function () {
        var score = $(this).attr('score')
        total += Number(score)
    })
    var num = scoreTable.siblings('.resultScore').find('.num')
    num.text(num.data('text') ? num.data('text')(total) : total)
    scoreTable.siblings('.scoreFooter').find('.calculate').data('score', total)
})
