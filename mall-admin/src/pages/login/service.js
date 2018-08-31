import { request, config } from 'utils'

const { api } = config
const { userLogin } = api

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
