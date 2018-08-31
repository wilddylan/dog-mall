import { request, config } from 'utils'

const { api } = config
const { user, userLogout, userLogin } = api

export function login (params) {
  // 登录时候，把用户名和密码存起来
  localStorage.setItem("username", params.username)
  localStorage.setItem("password", params.password)

  return request({
    url: userLogin,
    method: 'post',
    data: params,
  })
}

export function validate () {
  return request({
    url: userLogin,
    method: 'post',
    data: {},
  })
}

export function logout (params) {
  return request({
    url: userLogout,
    method: 'get',
    data: params,
  })
}

export function query (params) {
  return request({
    url: user.replace('/:id', ''),
    method: 'get',
    data: params,
  })
}
