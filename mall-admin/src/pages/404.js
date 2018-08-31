import React from 'react'
import { Icon } from 'antd'
import { Page } from 'components'
import styles from './404.less'

const Error = () => (<Page inner>
  <div className={styles.error}>
    <Icon type="frown-o" />
    <h1>界面没有找到，请联系客服或者管理员</h1>
    <a href="mailto:dylan@china.com">发送邮件</a>
  </div>
</Page>)

export default Error
