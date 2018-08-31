import React from 'react'
import PropTypes from 'prop-types'
import { connect } from 'dva'
import {Row, Col, Modal, Form, Input, Button, Icon, Upload, message} from 'antd'
import List from './components/List'
import { Page } from 'components'
import BraftEditor from 'braft-editor'
import 'braft-editor/dist/braft.css'
import * as qiniu from 'qiniu-js'
import styles from './index.less'

const FormItem = Form.Item
const { TextArea } = Input
const Dragger = Upload.Dragger
const InputGroup = Input.Group


const Product = ({ product, dispatch, loading, form: { getFieldDecorator, validateFieldsAndScroll } }) => {
  const { datas, pagination, modalData, visible, token, productDetailImageList, productImageList } = product

  const handleCreate = () => {
    validateFieldsAndScroll((errors, values) => {
      if (errors) {
        return
      }
      dispatch({ type: 'login/login', payload: values })
    })
  }

  const hideModal = () => {
    dispatch({ type: 'product/updateState', payload: { visible: false } })
  }

  const handleUpdateAction = (e) => {
    dispatch({
      type: `product/update`,
      payload: {

      },
    })
  }

  const handleCreateAction = (e) => {
    dispatch({
      type: `product/create`,
      payload: {

      },
    })
  }

  const handleDeleteAction = (e) => {
    dispatch({
      type: `product/remove`,
      payload: {
        productId: modalData.id,
        delete: 1,
      },
    }).then(() => {
      refresh()
    })
  }

  const handleRecoveryAction = (e) => {
    dispatch({
      type: `product/remove`,
      payload: {
        productId: modalData.id,
        delete: 0,
      },
    }).then(() => {
      refresh()
    })
  }

  const refresh = () => {
    dispatch({
      type: `product/query`,
      payload: {
        pageNo: pagination.current,
        pageSize: pagination.pageSize,
      },
    })
  }

  const listProps = {
    dataSource: datas,
    loading: loading.effects['product/query'],
    pagination,
    onChange (page) {
      dispatch({
        type: `product/query`,
        payload: {
          pageNo: page.current,
          pageSize: page.pageSize,
        },
      })
    },
    onDetailClick (record, e) {
      // 查看商品详情，顺便展示商品的操作功能，并放置一个新建商品的按钮，就是通过这个商品可以直接创建其他商品
      dispatch({ type: 'product/updateState', payload: { modalData: record } })
      dispatch({ type: 'product/updateState', payload: { visible: true } })
    },
  }

  const formItemLayout = {
    labelCol: {
      xs: { span: 24 },
      sm: { span: 6 },
    },
    wrapperCol: {
      xs: { span: 24 },
      sm: { span: 14 },
    },
  }

  const onHTMLChange = (content) => {
    dispatch({
      type: `product/updateState`,
      payload: {
        [modalData.detail.rich]: content,
      },
    })
  }

  const editorProps = {
    height: 300,
    contentFormat: 'html',
    initialContent: modalData.detail.rich,
    contentId: modalData.id,
    onHTMLChange: onHTMLChange,
    media: {
      allowPasteImage: true, // 是否允许直接粘贴剪贴板图片（例如QQ截图等）到编辑器
      image: true, // 开启图片插入功能
      video: false, // 开启视频插入功能
      audio: false, // 开启音频插入功能
      validateFn (file) {
        return file.size < 1024 * 1000
      }, // 指定本地校验函数，说明见下文
      uploadFn (param) {
        // 上传文件到七牛
        const observable = qiniu.upload(param.file, param.libraryId, token, {}, {region: null})

        // next, error, complete
        observable.subscribe(
          (res) => {
            param.progress(res.total.percent)
          },
          () => {
            param.error({msg: '上传失败，请重试'})
          },
          (res) => {
            console.log(res)
            param.success({
              url: 'http://r.devdylan.cn/' + param.libraryId,
              meta: {
                id: param.libraryId,
                title: '图片',
                alt: '图片',
              },
            })
          }
        )
        // 这样传参形式也可以

        // subscription.unsubscribe() // 上传取消

      }, // 指定上传函数，说明见下文
      removeConfirmFn: null, // 指定删除前的确认函数，说明见下文
      onRemove: null, // 指定媒体库文件被删除时的回调，参数为被删除的媒体文件列表(数组)
      onChange: null, // 指定媒体库文件列表发生变化时的回调，参数为媒体库文件列表(数组)
      onInsert: null, // 指定从媒体库插入文件到编辑器时的回调，参数为被插入的媒体文件列表(数组)
    },
  }

  const props = {
    name: 'file',
    multiple: true,
    action: 'http://upload.qiniup.com/',
    data: {
      token: token,
    },
    onChange (info) {
      dispatch({
        type: `product/updateState`,
        payload: {
          productDetailImageList: info.fileList,
        },
      })
    },
  }

  const productImageProps = {
    name: 'file',
    multiple: true,
    action: 'http://upload.qiniup.com/',
    data: {
      token: token,
    },
    onChange (info) {
      dispatch({
        type: `product/updateState`,
        payload: {
          productImageList: info.fileList,
        },
      })
    },
  }

  const infoInputChange = (e) => {
    e.persist()
    console.log(e)
    console.log(e.target.value)

    console.log(e.target.dataset.index)
    console.log(e.target.dataset.name)
  }

  const inputInfos = []
  for (let i=0; i<modalData.infos.length; i ++) {
    let info = modalData.infos[i]
    inputInfos.push((
      <Row key={i + ""} type="flex" align="center" justify="space-around" style={{width: '100%'}}>
        <Col span={10}>
          <Input defaultValue={info.key} data-index={i + ""} data-name="key" onChange={infoInputChange}/>
        </Col>
        <Col span={10}>
          <Input defaultValue={info.value} data-index={i + ""} data-name="value" onChange={infoInputChange}/>
        </Col>
      </Row>
    ))
  }

  return (
    <Page inner>
      <List {...listProps} />

       {/*商品详情 Modal*/}
      <Modal
        title="商品详情"
        destroyOnClose={true}
        footer={null}
        closable={true}
        maskClosable={false}
        onCancel={hideModal}
        visible={visible}
        width={1024}>
        <form>
          <FormItem label="商品名称" hasFeedback {...formItemLayout}>
            {getFieldDecorator('name', {
              initialValue: modalData.name,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="商品名称" />)}
          </FormItem>

          <FormItem label="商品库存" hasFeedback {...formItemLayout}>
            {getFieldDecorator('left', {
              initialValue: modalData.left,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="商品库存" />)}
          </FormItem>

          {/*商品信息*/}
          <FormItem label="商品属性" hasFeedback {...formItemLayout}>
            {inputInfos}
          </FormItem>

          <FormItem label="邀请减免" hasFeedback {...formItemLayout}>
            {getFieldDecorator('invitePrice', {
              initialValue: modalData.invitePrice,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="邀请减免" />)}
          </FormItem>

          <FormItem label="商品简述" hasFeedback {...formItemLayout}>
            {getFieldDecorator('description', {
              initialValue: modalData.description,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="商品简述"/>)}
          </FormItem>

          <FormItem label="可用快递" hasFeedback {...formItemLayout}>
            {getFieldDecorator('express', {
              initialValue: modalData.express,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="可用快递"/>)}
          </FormItem>

          <FormItem label="发货时间" hasFeedback {...formItemLayout}>
            {getFieldDecorator('sendTime', {
              initialValue: modalData.sendTime,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="发货时间 " />)}
          </FormItem>

          <FormItem label="商品详情-展示图上传" hasFeedback {...formItemLayout}>
            {getFieldDecorator('productImage', {
              rules: [
                {
                  required: true,
                },
              ],
              getValueFromEvent (e) {
                if (!e || !e.fileList) {
                  return e
                }

                const { fileList } = e
                return fileList
              },
            })(
              <Dragger {...productImageProps}>
                <p className="ant-upload-drag-icon">
                  <Icon type="inbox" />
                </p>
                <p className="ant-upload-text">上传商品轮播图</p>
                <p className="ant-upload-hint">上传商品轮播图，可以一次性选择多张</p>
              </Dragger>
            )}
          </FormItem>

          <FormItem label="商品详情-富文本介绍" hasFeedback {...formItemLayout}>
            <BraftEditor style={{border: '1px solid #646464'}} {...editorProps}/>
          </FormItem>

          <FormItem label="商品详情-主图上传" hasFeedback {...formItemLayout}>
            {getFieldDecorator('productDetailImage', {
              rules: [
                {
                  required: true,
                },
              ],
              getValueFromEvent (e) {
                if (!e || !e.fileList) {
                  return e
                }

                const { fileList } = e
                return fileList
              },
            })(
              <Dragger {...props}>
                <p className="ant-upload-drag-icon">
                <Icon type="inbox" />
                </p>
                <p className="ant-upload-text">上传商品详情图</p>
                <p className="ant-upload-hint">上传商品详情图，可以一次性选择多张</p>
              </Dragger>
            )}
          </FormItem>

          <FormItem label="选择规格提示语句" hasFeedback {...formItemLayout}>
            {getFieldDecorator('specialsExtra', {
              initialValue: modalData.specialsExtra,
              rules: [
                {
                  required: true,
                },
              ],
            })(<Input placeholder="选择规格提示语句 " />)}
          </FormItem>

          <Row type="flex" align="center" justify="space-around" style={{width: '100%'}}>
            <Button type="primary" onClick={e => handleUpdateAction(e)}>保存当前修改</Button>
            <Button onClick={e => handleCreateAction(e)}>新建修改后商品</Button>
            <Button onClick={e => handleRecoveryAction(e)} type="ghost">恢复当前商品</Button>
            <Button onClick={e => handleDeleteAction(e)} type="danger">删除当前商品</Button>
            <Button onClick={hideModal} type="danger">关闭当前窗口</Button>
          </Row>
        </form>
      </Modal>

    </Page>
  )
}

Product.propTypes = {
  product: PropTypes.object,
  loading: PropTypes.object,
  location: PropTypes.object,
  dispatch: PropTypes.func,
}

export default connect(({ product, loading }) => ({ product, loading }))(Form.create()(Product))
