import { request } from 'utils'

export function query (params) {
  return request({
    url: '/admin/product/list',
    method: 'post',
    data: params,
  })
}

export function create (params) {
  return request({
    url: '/admin/product/create',
    method: 'post',
    data: params,
  })
}

export function remove (params) {
  return request({
    url: '/admin/product/delete',
    method: 'post',
    data: params,
  })
}

export function update (params) {
  return request({
    url: '/admin/product/update',
    method: 'post',
    data: params,
  })
}

export function fileToken (params) {
  return request({
    url: '/admin/file/token',
    method: 'post',
    data: params,
  })
}
