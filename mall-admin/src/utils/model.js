import modelExtend from 'dva-model-extend'

export const model = {
  reducers: {
    updateState (state, { payload }) {
      return {
        ...state,
        ...payload,
      }
    },
  },
}

export const pageModel = modelExtend(model, {

  state: {
    datas: [],
    pagination: {
      showSizeChanger: true,
      showQuickJumper: true,
      showTotal: total => `Total ${total} Items`,
      current: 1,
      total: 0,
      pageSize: 10,
    },
  },

  reducers: {
    querySuccess (state, { payload }) {
      const { datas, pagination } = payload
      return {
        ...state,
        datas,
        pagination: {
          ...state.pagination,
          ...pagination,
        },
      }
    },
  },

})
