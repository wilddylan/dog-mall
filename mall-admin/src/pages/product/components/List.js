import React from 'react'
import PropTypes from 'prop-types'
import { Table, Button } from 'antd'
import classnames from 'classnames'
import { Link } from 'react-router-dom'
import AnimTableBody from 'components/DataTable/AnimTableBody'
import styles from './List.less'

// const { confirm } = Modal

const List = ({ onDetailClick, ...tableProps }) => {

  const handleDetailClick = (record, e) => {
    onDetailClick(record, e)
  }

  const columns = [
    {
      title: '删除状态',
      dataIndex: 'delete',
      key: 'delete',
      // className: styles.avatar,
      render: (text, record) => {
        let color = "#34a3ff"
        if (text === 1) {
          color = "#ff34ac"
        }
        return <div style={{backgroundColor: color, width: '100%', height: '100%'}}/>
      },
    }, {
      title: '商品ID',
      dataIndex: 'id',
      key: 'id',
      // className: styles.avatar,
      render: (text, record) => <Link to={`product/${record.id}`}>{record.id}</Link>,
    }, {
      title: '商品图片',
      key: 'productImage',
      className: styles.avatar,
      render: (text, record) => <img alt="主图" width={44} height={44} src={record.images[0].url} />,
    }, {
      title: '商品名称',
      dataIndex: 'name',
      key: 'name',
    }, {
      title: '库存',
      dataIndex: 'left',
      key: 'left',
    }, {
      title: '邀请减免/位',
      dataIndex: 'invitePrice',
      key: 'invitePrice',
    }, {
      title: '支持快递',
      dataIndex: 'express',
      key: 'express',
    }, {
      title: '发货时间',
      dataIndex: 'sendTime',
      key: 'sendTime',
    },
    {
      title: '操作',
      key: 'option',
      render: (text, record) => {
        return <Button onClick={e => handleDetailClick(record, e)}>查看详情</Button>
      },
    },
  ]

  const CommonBody = (props) => {
    return <tbody {...props} />
  }

  return (
    <Table
      {...tableProps}
      className={styles.table}
      bordered
      scroll={{ x: 1200 }}
      columns={columns}
      simple
      rowKey={record => record.id}
      components={{
        body: { wrapper: CommonBody },
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
