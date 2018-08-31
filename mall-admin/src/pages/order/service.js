import { request } from 'utils'

export function query (params) {
  return request({
    url: '/admin/order/list',
    method: 'post',
    data: params,
  })
}

export function updateStateQuery (params) {
  return request({
    url: '/admin/order/update/state',
    method: 'post',
    data: params,
  })
}
