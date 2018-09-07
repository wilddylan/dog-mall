/* global window */
import axios from 'axios'
import cloneDeep from 'lodash.clonedeep'
import pathToRegexp from 'path-to-regexp'
import { message } from 'antd'

const fetch = (options) => {
  let {
    method = 'get',
    data,
    url,
  } = options

  let cloneData = cloneDeep(data)

  try {
    let domain = ''
    if (url.match(/[a-zA-z]+:\/\/[^/]*/)) {
      [domain] = url.match(/[a-zA-z]+:\/\/[^/]*/)
      url = url.slice(domain.length)
    }
    const match = pathToRegexp.parse(url)
    url = pathToRegexp.compile(url)(data)
    for (let item of match) {
      if (item instanceof Object && item.name in cloneData) {
        delete cloneData[item.name]
      }
    }
    url = domain + url
  } catch (e) {
    message.error(e.message)
  }

  if (!cloneData) {
    cloneData = {}
  }

  let username = localStorage.getItem("username")
  let password = localStorage.getItem("password")

  console.log("local info: ", username, password)

  // 增加 username password 参数
  if (username && password) {
    cloneData.username = username
    cloneData.password = password
  }

  console.log(method, url, cloneData)

  switch (method.toLowerCase()) {
    case 'get':
      return axios.get(url, {
        params: cloneData,
      })
    case 'delete':
      return axios.delete(url, {
        data: cloneData,
      })
    case 'post':
      return axios.post(url, cloneData)
    case 'put':
      return axios.put(url, cloneData)
    case 'patch':
      return axios.patch(url, cloneData)
    default:
      return axios(options)
  }
}

export default function request (options) {
  return fetch(options).then((response) => {
    const { status, data } = response
    console.log(data)
    let entity = {
      datas: data.datas,
      data: data.data,
      message: data.message,
      code: data.code,
      total: data.total,
    }

    let success = false
    // 返回数据的判断
    if (data.code === 0) {
      success = true
    } else {
      message.error(data.message || response.message)
    }

    return Promise.resolve({
      success: success,
      message: entity.message,
      statusCode: status,
      ...entity,
    })
  }).catch((error) => {
    const { response } = error
    console.log(error)
    let msg
    let statusCode
    if (response && response instanceof Object) {
      const { data, statusText } = response
      statusCode = response.status
      msg = data.message || statusText
    } else {
      statusCode = 600
      msg = error.message || 'Network Error'
    }

    /* eslint-disable */
    return Promise.reject({ success: false, statusCode, message: msg })
  })
}
