import React from 'react'
import PropTypes from 'prop-types'
import { connect } from 'dva'
import { Row, Col, Card } from 'antd'
import { Link } from 'react-router-dom'
import { Page } from 'components'
import styles from './index.less'

function Dashboard ({ dashboard, loading }) {
  const { data } = dashboard

  const openServiceWindow =  () => {
    window.open('https://mpkf.weixin.qq.com/cgi-bin/kfloginpage')
  }

  return (
    <Page loading={loading.models.dashboard} className={styles.dashboard}>
      统计数据
      <Row gutter={24} type="flex" align="middle" justify="space-around">
        <Card title="订单数据" style={{height: 200, width: 220}}>
          <p>昨日创建 { data.orderAnalysis.orderCreateNumberYesterday }</p>
          <p>今日创建 { data.orderAnalysis.orderCreateNumberToday }</p>
          <p>总数 { data.orderAnalysis.orderCreateNumberAll }</p>
        </Card>
        <Card title="交易数据" style={{height: 200, width: 220}}>
          <p>昨日总额 ￥{data.orderAnalysis.orderPriceYesterday}</p>
          <p>今日总额 ￥{data.orderAnalysis.orderPriceToday}</p>
          <p>总额 ￥{data.orderAnalysis.orderPriceAll}</p>
        </Card>
        <Card title="用户数据" style={{height: 200, width: 220}}>
          <p>昨日新增 {data.userAnalysis.signUpNumberYesterday}</p>
          <p>今日新增 {data.userAnalysis.signUpNumberToday}</p>
          <p>总数 {data.userAnalysis.signUpNumberAll}</p>
        </Card>
        <Card title="商品数据" style={{height: 200, width: 220}}>
          <p>商品总数 {data.productAnalysis.productNum}</p>
        </Card>
      </Row>
      快捷菜单
      <Row gutter={24} type="flex" align="middle" justify="space-around">
        <Col className={styles.link}>
          <Link className={styles.item} to='/dashboard' onClick={openServiceWindow}>客服登录</Link>
        </Col>
        <Col className={styles.link}>
          <Link className={styles.item} to='/order'>订单列表</Link>
        </Col>
        <Col className={styles.link}>
          <Link className={styles.item} to='/product'>商品列表</Link>
        </Col>
        <Col className={styles.link}>
          <Link className={styles.item} to='/user'>用户列表</Link>
        </Col>
      </Row>
    </Page>
  )
}

Dashboard.propTypes = {
  dashboard: PropTypes.object,
  loading: PropTypes.object,
}

export default connect(({ dashboard, loading }) => ({ dashboard, loading }))(Dashboard)
