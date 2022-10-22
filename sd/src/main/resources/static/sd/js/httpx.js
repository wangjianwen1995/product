/* eslint-disable no-undef */
/* eslint-disable no-unused-vars */
var http = {
  config: {
    drgsApi: '/drgsgateway', // 打包后的地址
    eventApi: '/eventgateway',
    // drgsApi: "http://192.168.150.163:8781/drgsgateway", // 开发/测试环境接口
    // eventApi: "http://192.168.150.163:8781/eventgateway",
    token: sessionStorage['Authorization'],
  },
  /** url: 请求接口地址,
        type: 请求类型 POST GET,
        json: 数据请求方式,
        mask: 是否有loading,
        data: 请求参数
     */
  ajax(options) {
    var loading = ''
    let def = $.Deferred()
    if (options.mask) {
      loading = layer.load(1, {
        shade: [0.1, '#fff'], //0.1透明度的白色背景
        id: 'report-loading',
      })
    }
    $.ajax({
      url: this.config.drgsApi + options.url,
      data: options.data,
      type: options.type,
      async: options || true,
      headers: {
        Authorization: this.config.token,
      },
      contentType: options.json
        ? 'application/json;charset=UTF-8'
        : 'application/x-www-form-urlencoded',
    }).then(
      function (rsp) {
        def.resolve(rsp)
        console.log(rsp)
        if (rsp.code !== 1) {
          layer.msg(rsp.message, {
            offset: '150px',
          })
        }
        setTimeout(function () {
          layer.close(loading)
        }, 100)
        if (rsp.code === -1) {
          parent.location.href = '/'
        }
      },
      function (error) {
        console.log(error, 'err')
        if (error.status == 504) {
          layer.msg('请求超时，请重试', {
            offset: '150px',
          })
        } else if (error.responseText) {
          var err = JSON.parse(error.responseText)
          var code = err.code // 错误码
          var emsg = err.message // 错误内容提示（字符串）
          switch (code) {
            case 0: // 错误提示
              layer.msg(emsg, {
                offset: '150px',
              })
              break
            case -1: // 2022 掉线，重新登录
              parent.location.href = '/'
              break
            case 2: //未登录
              layer.msg(
                emsg,
                {
                  offset: '150px',
                },
                function () {
                  parent.location.href = '/'
                }
              )
              break
          }
        }
        def.reject(error)
        setTimeout(function () {
          layer.close(loading)
        }, 100)
      }
    )
    return def
  },
  eventAjax(options) {
    var loading = ''
    let def = $.Deferred()
    if (options.mask) {
      loading = layer.load(1, {
        shade: [0.1, '#fff'], //0.1透明度的白色背景
        id: 'report-loading',
      })
    }
    $.ajax({
      url: this.config.eventApi + options.url,
      data: options.data,
      type: options.type,
      async: options || true,
      headers: {
        Authorization: this.config.token,
      },
      contentType: options.json
        ? 'application/json;charset=UTF-8'
        : 'application/x-www-form-urlencoded',
    }).then(
      function (rsp) {
        def.resolve(rsp)
        console.log(rsp)
        if (rsp.code !== 1) {
          layer.msg(rsp.message, {
            offset: '150px',
          })
        }
        setTimeout(function () {
          layer.close(loading)
        }, 100)
        if (rsp.code === -1) {
          parent.location.href = '/'
        }
      },
      function (error) {
        console.log(error, 'err')
        if (error.status == 504) {
          layer.msg('请求超时，请重试', {
            offset: '150px',
          })
        } else if (error.responseText) {
          var err = JSON.parse(error.responseText)
          var code = err.code // 错误码
          var emsg = err.message // 错误内容提示（字符串）
          switch (code) {
            case 0: // 错误提示
              layer.msg(emsg, {
                offset: '150px',
              })
              break
            case -1: // 2022 掉线，重新登录
              parent.location.href = '/'
              break
            case 2: //未登录
              layer.msg(
                emsg,
                {
                  offset: '150px',
                },
                function () {
                  parent.location.href = '/'
                }
              )
              break
          }
        }
        def.reject(error)
        setTimeout(function () {
          layer.close(loading)
        }, 100)
      }
    )
    return def
  },
  getUrlParam(name) {
    var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)') //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg) //匹配目标参数
    if (r != null) {
      return unescape(r[2])
    }
    return null
  },
}
