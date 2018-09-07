import modelExtend from 'dva-model-extend'
import { query, create, remove, update, fileToken } from './service'
import { pageModel } from 'utils/model'
import { message } from 'antd'

export default modelExtend(pageModel, {

  namespace: 'product',

  state: {
    productDetailImageList: [], // 商品详情图
    productImageList: [], // 商品5张轮播图

    token: '', // 上传 token
    modalData: {
      detail: {
        rich: '',
      },
      infos: [],
      questions: [],
      specials: [],
    },
    visible: false,
  },

  subscriptions: {
    setup ({ dispatch, history }) {
      history.listen((location) => {
        if (location.pathname === '/product') {
          dispatch({
            type: 'query',
            payload: {
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

      const { data } = yield call(fileToken)
      if (data) {
        yield put({
          type: `updateState`,
          payload: {
            token: data,
          },
        })
      }
    },

    * create ({ payload }, { call }) {
      const { success } = yield call(create, payload)
      if (success) {
        message.success("新增成功")
      }
    },

    * remove ({ payload }, { call }) {
      const { success } = yield call(remove, payload)
      if (success) {
        message.success("操作成功")
      }
    },

    * update ({ payload }, { call }) {
      const { success } = yield call(update, payload)
      if (success) {
        message.success("更新成功")
      }
    },
  },
})
