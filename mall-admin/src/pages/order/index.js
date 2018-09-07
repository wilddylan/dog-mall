import React from 'react'
import PropTypes from 'prop-types'
import { connect } from 'dva'
import { Tabs, Modal } from 'antd'
import List from './components/List'
import { Page } from 'components'

const { TabPane } = Tabs

const OrderList = ({ order, dispatch, loading }) => {
  const { orderState, datas, pagination, visible, modalData } = order

  const handleTabClick = (key) => {
    dispatch({
      type: `order/updateState`,
      payload: {
        orderState: key,
      },
    })

    dispatch({
      type: `order/query`,
      payload: {
        orderState: key,
        pageNo: pagination.current,
        pageSize: pagination.pageSize,
      },
    })
  }

  const showModelWithObject = (object) => {

    dispatch({
      type: `order/updateState`,
      payload: {
        modalData: object,
      },
    })

    dispatch({
      type: `order/updateState`,
      payload: {
        visible: true,
      },
    })
  }

  const handleModalHide = () => {
    dispatch({
      type: `order/updateState`,
      payload: {
        visible: false,
      },
    })
  }

  const listProps = {
    dataSource: datas,
    loading: loading.effects['order/query'],
    pagination,
    onSpecial (record) {
      showModelWithObject(record.specials)
    },
    onUserInfo (record) {
      showModelWithObject(record.userInfo)
    },
    onExpress (record) {
      showModelWithObject(record.expressInfo)
    },
    onStateChange (record, state) {
      console.log(record, state)
      // 修改订单状态
      dispatch({
        type: `order/updateOrderState`,
        payload: {
          orderId: record.orderId,
          orderState: state,
        },
      }).then(() => {
        dispatch({
          type: `order/query`,
          payload: {
            orderState: orderState,
            pageNo: pagination.current,
            pageSize: pagination.pageSize,
          },
        })
      })
    },
    onChange (page) {
      dispatch({
        type: `order/query`,
        payload: {
          pageNo: page.current,
          pageSize: page.pageSize,
          orderState: orderState,
        },
      })
    },
  }

  return (
    <Page inner>
      <Tabs activeKey={orderState} onTabClick={handleTabClick}>
        <TabPane tab="等待支付" key={"0"} />
        <TabPane tab="等待发货" key={"1"} />
        <TabPane tab="等待收货" key={"2"} />
        <TabPane tab="订单完成" key={"3"} />
      </Tabs>
      <List {...listProps} />
      <Modal
        title="Basic Modal"
        visible={visible}
        onOk={handleModalHide}
        onCancel={handleModalHide}
      >
        {JSON.stringify(modalData)}
      </Modal>
    </Page>
  )
}

OrderList.propTypes = {
  order: PropTypes.object,
  loading: PropTypes.object,
  location: PropTypes.object,
  dispatch: PropTypes.func,
}

export default connect(({ order, loading }) => ({ order, loading }))(OrderList)
