import modelExtend from 'dva-model-extend'
import { query, updateStateQuery } from './service'
import { pageModel } from 'utils/model'
import { message } from 'antd'

export default modelExtend(pageModel, {

  namespace: 'order',

  state: {
    // 订单状态筛选
    orderState: "0",
    // 订单 ID 筛选
    orderId: '',

    visible: false,

    modalData: {},
  },

  subscriptions: {
    setup ({ dispatch, history }) {
      history.listen((location) => {
        if (location.pathname === '/order') {
          dispatch({
            type: 'query',
            payload: {
              orderState: "0",
              pageNo: 1,
              pageSize: 10,
            },
          })
        }
      })
    },
  },

  effects: {
    * query ({ payload }, { call, put }) {

      payload.orderId = ''

      const { datas, success, total } = yield call(query, payload)
      if (success) {
        yield put({
          type: 'querySuccess',
          payload: {
            datas: datas,
            pagination: {
              current: Number(payload.pageNo) || 1,
              pageSize: Number(payload.pageSize) || 10,
              total: total,
            },
          },
        })
      }
    },

    * updateOrderState ({payload}, {call}) {
      const { success } = yield call(updateStateQuery, payload)
      if (success) {
        message.success("修改订单状态成功")
      }
    },
  },
})
