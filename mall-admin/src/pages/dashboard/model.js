import { parse } from 'qs'
import modelExtend from 'dva-model-extend'
import { query } from './services/dashboard'
import { model } from 'utils/model'

export default modelExtend(model, {
  namespace: 'dashboard',
  state: {
    data: {
      orderAnalysis: {
        orderCreateNumberAll: 0,
        orderCreateNumberToday: 0,
        orderCreateNumberYesterday: 0,
        orderPriceAll: 0,
        orderPriceToday: 0,
        orderPriceYesterday: 0,
      },
      productAnalysis: {
        productNum: 0,
      },
      userAnalysis: {
        signUpNumberAll: 0,
        signUpNumberToday: 0,
        signUpNumberYesterday: 0,
      },
    },
  },
  subscriptions: {
    setup ({ dispatch, history }) {
      history.listen(({ pathname }) => {
        if (pathname === '/dashboard' || pathname === '/') {
          dispatch({ type: 'query' })
        }
      })
    },
  },
  effects: {
    * query ({ payload }, { call, put }) {
      const { data } = yield call(query, parse(payload))
      yield put({
        type: 'updateState',
        payload: {data},
      })
    },
  },
})
