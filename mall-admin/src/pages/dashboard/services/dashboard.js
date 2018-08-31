import { request } from 'utils'

export function query (params) {
  return request({
    url: '/admin/data',
    method: 'post',
    data: params,
  })
}
