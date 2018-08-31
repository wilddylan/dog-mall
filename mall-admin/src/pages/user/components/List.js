import React from 'react'
import PropTypes from 'prop-types'
import { Table, Modal } from 'antd'
import classnames from 'classnames'
// import { DropOption } from 'components'
// import { Link } from 'react-router-dom'
import AnimTableBody from 'components/DataTable/AnimTableBody'
import styles from './List.less'

// const { confirm } = Modal

const List = ({ onDeleteItem, onEditItem, isMotion, location, ...tableProps }) => {

  // const handleMenuClick = (record, e) => {
  //   if (e.key === '1') {
  //     onEditItem(record)
  //   } else if (e.key === '2') {
  //     confirm({
  //       title: 'Are you sure delete this record?',
  //       onOk () {
  //         onDeleteItem(record.id)
  //       },
  //     })
  //   }
  // }

  const columns = [
    {
      title: '头像',
      dataIndex: 'avatarUrl',
      key: 'avatarUrl',
      width: 64,
      className: styles.avatar,
      render: text => <img alt="avatar" width={44} src={text} />,
    }, {
      title: '昵称',
      dataIndex: 'nickName',
      key: 'nickName',
      // render: (text, record) => <Link to={`user/${record.id}`}>{text}</Link>,
    }, {
      title: '性别',
      dataIndex: 'gender',
      key: 'gender',
      render: text => (<span>{text === "1"
        ? '男'
        : '女'}</span>),
    }, {
      title: 'openId',
      dataIndex: 'openId',
      key: 'openId',
    }, {
      title: '国家',
      dataIndex: 'country',
      key: 'country',
    },
    {
      title: '省份',
      dataIndex: 'province',
      key: 'province',
    }, {
      title: '城市',
      dataIndex: 'city',
      key: 'city',
    }, {
      title: '语言',
      dataIndex: 'language',
      key: 'language',
    },
    // {
    //   title: 'Operation',
    //   key: 'operation',
    //   width: 100,
    //   render: (text, record) => {
    //     return <DropOption onMenuClick={e => handleMenuClick(record, e)} menuOptions={[{ key: '1', name: 'Update' }, { key: '2', name: 'Delete' }]} />
    //   },
    // },
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
      scroll={{ x: 1250 }}
      columns={columns}
      simple
      rowKey={record => record.openId}
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
