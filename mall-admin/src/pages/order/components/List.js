import React from 'react'
import PropTypes from 'prop-types'
import { Table, Button } from 'antd'
import classnames from 'classnames'
import { DropOption } from 'components'
import { Link } from 'react-router-dom'
import AnimTableBody from 'components/DataTable/AnimTableBody'
import styles from './List.less'

// const { confirm } = Modal

const List = ({ onStateChange, onSpecial, onUserInfo, onExpress, onDeleteItem, onEditItem, isMotion, location, ...tableProps }) => {

  const handleMenuClick = (record, e) => {
    if (e.key === '1') {
      onSpecial(record)
    } else if (e.key === '2') {
      onUserInfo(record)
    } else {
      onExpress(record)
    }
  }

  const handleStateMenuClick = (record, e) => {
    onStateChange(record, e.key)
  }

  const columns = [
    {
      title: '订单ID',
      dataIndex: 'orderId',
      key: 'orderId',
      // className: styles.avatar,
      render: (text, record) => <Link to={`order/${record.orderId}`}>{record.orderId}</Link>,
    }, {
      title: '商品图片',
      key: 'productImage',
      className: styles.avatar,
      render: (text, record) => <img alt="主图" width={44} height={44} src={record.productInfo.images[0].url} />,
    }, {
      title: '商品名称',
      key: 'productName',
      render: (text, record) => <Link to={`product/${record.productInfo.id}`}>{record.productInfo.name}</Link>,
    }, {
      title: '订单状态',
      dataIndex: 'orderState',
      key: 'orderState',
      render: (text, record) => {
        return (
          <div>
            <span style={{marginRight: 10}}>{text}</span>
            <DropOption onMenuClick={e => handleStateMenuClick(record, e)} menuOptions={[{ key: '1', name: '等待发货' }, { key: '2', name: '等待收货' }, { key: '3', name: '订单结束' }]} />
          </div>
        )
      },
    },{
      title: '支持好友数',
      dataIndex: 'invite',
      key: 'invite',
      // render: text => (<span>{text === "1"
      //   ? '男'
      //   : '女'}</span>),
    },{
      title: '邀请减免/位',
      dataIndex: 'productInfo.invitePrice',
      key: 'invitePrice',
      // render: text => (<span>{text === "1"
      //   ? '男'
      //   : '女'}</span>),
    }, {
      title: '购买人昵称',
      dataIndex: 'userInfo.nickName',
      key: 'nickName',
    }, {
      title: '原始价格',
      dataIndex: 'originPrice',
      key: 'originPrice',
    }, {
      title: '数量',
      dataIndex: 'piece',
      key: 'piece',
    }, {
      title: '来自分享订单id',
      dataIndex: 'shareId',
      key: 'shareId',
    }, {
      title: '物流状态',
      dataIndex: 'expressState',
      key: 'expressState',
    }, {
      title: '详细信息',
      key: 'expressInfo',
      render: (text, record) => {
         return <DropOption onMenuClick={e => handleMenuClick(record, e)} menuOptions={[{ key: '1', name: '规格信息' }, { key: '2', name: '用户信息' }, { key: '3', name: '物流信息' }]} />
      },
    },

  ]

  const AnimateBody = (props) => {
    return <AnimTableBody {...props} />
  }

  const CommonBody = (props) => {
    return <tbody {...props} />
  }

  return (
    <Table
      {...tableProps}
      className={classnames(styles.table, { [styles.motion]: isMotion })}
      bordered
      scroll={{ x: 1500 }}
      columns={columns}
      simple
      rowKey={record => record.orderId}
      components={{
        body: { wrapper: isMotion ? AnimateBody : CommonBody },
      }}
    />
  )
}

List.propTypes = {
  onDeleteItem: PropTypes.func,
  onEditItem: PropTypes.func,
  isMotion: PropTypes.bool,
  location: PropTypes.object,
}

export default List
