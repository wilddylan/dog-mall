<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
text, p, span {
  font-weight: 200;
}

.container {
  padding: 0;
}

.product-swiper {
  width: 100vw;
  height: 100vw;
}

.product-swiper-item {
  width: 100vw;
  height: 100vw;
}

.product-slide-image {
  width: 100vw;
  height: 100vw;
}

.product-info {
  display: flex;
  flex-direction: column;
  padding-top: 15px;
  align-items: center;
  justify-content: center;
}

.product-info-name {
  font-size: 22px;
  color: #986801;
  margin-bottom: 5px;
}

.product-info-description {
  font-size: 14px;
  color: #646464;
  margin-bottom: 5px;
}

.product-info-express {
  font-size: 14px;
  color: #646464;
  margin-bottom: 15px;
}

.line {
  height: 10px;
  background-color: #f3f3f3;
  width: 100vw;
}

.product-extra-info {
  display: flex;
  flex-direction: column;
  padding-top: 15px;
  padding-left: 12px;
  align-items: flex-start;
  justify-content: start;
}

.product-extra-info-time {
  font-size: 15px;
  color: #333333;
  margin-bottom: 15px;
}

.product-extra-info-time .title {
    color: #a1a1a1;
}

.line-thin {
  height: 1px;
  background-color: #f3f3f3;
  width: 100vw;
}

.product-extra-info-special {
  margin-bottom: 15px;
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}

.product-extra-info-special img {
  width: 6px;
  height: 12px;
  margin-right: 12px;
}

.product-extra-info-special-text {
  font-size: 15px;
  color: #333333;
  flex-grow: 1;
}

.product-extra-info-special-text .title {
    color: #a1a1a1;
}

.product-other-infos {
  display: flex;
  flex-direction: column;
  padding-top: 15px;
  padding-bottom: 10px;
  padding-left: 12px;
  padding-right: 12px;
  width: 100vw;
  align-items: flex-start;
  justify-content: start;
}

.product-other-title {
  font-size: 18px;
  color: #986801;
  margin-bottom: 5px;
}

.product-other-item {
  height: 25px;
  font-size: 15px;
  width: 100%;
  margin-top: 5px;
  display: flex;
  align-items: center;
  justify-content: flex-start;
  padding-left: 12px;
  margin-right: 12px;
}

.product-other-item p {
  color: #333333;
}

.product-other-item span {
  color: #646464;
  display: inline-block;
  width: 40px;
}

.product-qa {
  display: flex;
  flex-direction: column;
  width: 100vw;
  margin-top: 10px;
  margin-bottom: 20px;
  padding: 0 12px 0 12px;
  box-sizing: border-box;
}

.product-qa-title {
  display: flex;
  width: 100%;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  margin-bottom: 10px;
}

.product-qa-title div {
  width: 40px;
  background-color: #f1f1f1;
  height: 1px;
}

.product-qa-title .left {
  margin-right: 15px;
}

.product-qa-title .right {
  margin-left: 15px;
}

.product-qa-title p {
  color: #986801;
  font-size: 14px;
}

.product-qa-list {
  width: 100%;
  display: flex;
  box-sizing: border-box;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
  margin-bottom: 10px;
}

.product-qa-list .question {
  width: 100%;
  font-size: 14px;
  color: #000;
  display: flex;
  box-sizing: border-box;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
}

.product-qa-list .question .dot {
  font-size: 8px;
  color: #986801;
}

.product-qa-list .question .text {
  margin-left: 5px;
}

.product-qa-list .anwser {
  margin-top: 5px;
  font-size: 14px;
  color: #333333;
  padding-left: 12px;
}

.product-detail {
  width: 100vw;
  box-sizing: border-box;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: flex-start;
  margin-top: 15px;
}

.product-detail-title {
  margin-left: 12px;
  font-size: 18px;
  color: #986801;
  margin-bottom: 10px;
}

.product-detail-image-wrapper {
  width: 100vw;
}

.product-detail-image {
  width: 100%;
  animation: fadeIn 1s both;
}

.product-detail-text {
  width: 100%;
  box-sizing: border-box;
  padding-left: 12px;
  padding-right: 12px;
}

.product-options {
  width: 100%;
  height: 49px;
  z-index: 1;
  background-color: rgba(255, 255, 255, 0.9);
  position: fixed;
  bottom: 0;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  font-size: 17px;
  font-weight: 300;
  height: 49px;
  line-height: 49px;
  box-sizing: border-box;
}

.product-options .price {
  flex-grow: 1;
  text-align: center;
  vertical-align: middle;
  color: rgb(98, 68, 1);
  box-sizing: border-box;
  min-width: 120px;
}

.product-options .share {
  flex-grow: 1;
  text-align: center;
  vertical-align: middle;
  color: white;
  background-color: rgba(98, 68, 1, 0.5);
  box-sizing: border-box;
  border-radius: 0px;
  border: 0;
  line-height: 49px;
  font-size: 17px;
}

.product-options .bind {
  flex-grow: 1;
  text-align: center;
  vertical-align: middle;
  color: white;
  background-color: rgba(98, 68, 1, 0.3);
  box-sizing: border-box;
  border-radius: 0px;
  border: 0;
  line-height: 49px;
  font-size: 17px;
}

.product-options .buy {
  flex-grow: 1;
  text-align: center;
  vertical-align: middle;
  color: white;
  background-color: rgb(98, 68, 1);
  box-sizing: border-box;
}

.product-special-screen {
  width: 100%;
  height: 100%;
  position: fixed;
  top: 0;
  left: 0;
  background: #000;
  opacity: 0.2;
  overflow: hidden;
  z-index: 1000;
  color: #fff;
}

.product-special {
  height: 580rpx;
  width: 100%;
  position: fixed;
  overflow-y: scroll;
  bottom: 0;
  left: 0;
  z-index: 2000;
  background: rgba(255, 255, 255, 1);
  padding-top: 15px;

  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  box-sizing: border-box;
  padding-left: 12px;
  padding-right: 12px;
}

.product-special-title {
  font-size: 18px;
  color: #986801;
  align-self: flex-start;
}

.product-special-item {
  margin-top: 15px;
  width: 100%;
}

.product-special-item-title span {
  font-size: 14px;
  color: #333333;
}

.product-special-item-value-wrapper {
  width: 100%;
  margin-top: 15px;
  display: flex;
  flex-direction: row;
}

.product-special-item-value {
  margin-left: 10px;
  font-size: 14px;
  padding: 5px 10px 5px 10px;
  border: 1px solid #bbbbbb;
  color: #bbbbbb;
  border-radius: 2px;
}

.product-special-item-value-select {
  margin-left: 10px;
  font-size: 14px;
  padding: 5px 10px 5px 10px;
  border: 1px solid #986801;
  color: #986801;
  border-radius: 2px;
}

.product-special-item-piece {
  width: 100%;
  margin-top: 30px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}

.product-special-item-piece-title span {
  font-size: 14px;
  color: #333333;
}

@import url("~mpvue-wxparse/src/wxParse.css");
</style>

<template>
  <div>
    <scroll-view scroll-y class="container">
      <!-- 商品图片 -->
      <swiper
        :indicator-dots="indicatorDots"
        :enable-back-to-top="enableBackToTop"
        :autoplay="autoplay"
        :interval="interval"
        :duration="duration"
        :circular="circular"
        class="product-swiper">
        <div v-for="item in productInfo.images" :key="item.key">
          <swiper-item
            class="product-swiper-item">
            <image
              :src="item.url"
              class="product-slide-image"
              mode="aspectFill"/>
          </swiper-item>
        </div>
      </swiper>
      <!-- 商品名称 -->
      <div class="product-info">
        <text
          class="product-info-name">
          {{productInfo.name}}
        </text>
        <text
          class="product-info-description">
          {{productInfo.description}}
        </text>
        <text
          class="product-info-express">
          {{productInfo.express}}
        </text>
      </div>

      <div class="line"></div>

      <!-- 商品其他信息 -->
      <div class="product-extra-info">
        <p
          class="product-extra-info-time">
          <span class="title">发货时间：</span> {{productInfo.sendTime}}
        </p>
        <div class="product-extra-info-special">
           <!-- TODO：点击弹出选择规格界面，或者在点击立即购买时，如果没选择规格则弹出 -->
          <p class="product-extra-info-special-text" @click="showProductSpecial">
            <span class="title">产品规格：</span> {{productInfo.specialsExtra}}
          </p>
          <img src="http://r.devdylan.cn/more@3x.png"></img>
        </div>
      </div>

      <div class="line"></div>

      <!-- 商品参数 -->
      <div class="product-other-infos">
        <text
          class="product-other-title">
          商品参数
        </text>

        <div v-for="item in productInfo.infos" :key="item.keg" class="product-other-item">
          <p><span>{{item.key}}</span>{{item.value}}</p>
        </div>
      </div>

      <!-- 常见问题 -->
      <div class="product-qa">
        <div class="product-qa-title">
          <div class="left"></div>
          <p>常见问题<p>
          <div class="right"></div>
        </div>
        <!-- 问题列表 -->
        <div v-for="item in productInfo.questions" :key="item.key" class="product-qa-list">
          <div class="question">
            <p class="dot">●</p>
            <p class="text">{{item.question}}</p>
          </div>
          <p class="anwser">{{item.anwser}}</p>
        </div>
      </div>

      <div class="line"></div>

      <!-- 商品简介 -->
      <div class="product-detail">
        <text
          class="product-detail-title">
          商品简介
        </text>

        <!-- 富文本 -->
        <div v-if="productInfo.detail.rich" class="product-detail-text">
          <wxParse :content="productInfo.detail.rich" @preview="preview" @navigate="navigate"/>
        </div>

        <!-- 图片列表 -->
        <img v-for="item in productInfo.detail.images" :key="item.key" lazy-load="true" :src="item.url" class="product-detail-image" mode="widthFix"/>
        <img-load ref="imgLoad"></img-load>
      </div>
    </scroll-view>

    <!-- 购买按钮 -->
    <div class="product-options">
      <p class="price">{{price}}</p>
      <button v-if="needBind" class="bind" open-type="getUserInfo" plain="true" @getuserinfo="btnGetUserInfo">绑定</button>
      <button class="share" open-type="share" plain="true">分享</button>
      <p class="buy" @click="buyProduct">立即购买</p>
    </div>

    <!--屏幕背景变暗的背景  -->
    <view class="product-special-screen" @click="hideModal" v-if="showModalStatus"></view>
    <!--弹出框  -->
    <view class="product-special" :animation="animationData" v-if="showModalStatus">
      <text
        class="product-special-title">
        商品规格
      </text>

      <!-- 规格 -->
      <div v-for="(f, findex) in productInfo.specials" :key="findex" class="product-special-item">
        <p class="product-special-item-title">{{f.key}} <span>({{f.extra}})</span></p>
        <div class="product-special-item-value-wrapper">
          <div
            v-for="(i, index) in f.value"
            :key="index"
            :class="i.select ? 'product-special-item-value-select': 'product-special-item-value'"
            @click="selectSpecial(f.key, i)">
            {{i.name}}
          </div>
        </div>
      </div>

      <div class="product-special-item-piece">
        <p class="product-special-item-piece-title">购买件数 <span>(剩余 {{productInfo.left}} 件)</span></p>
        <i-input-number :value="piece" min="1" max="100" @ichange="pieceChange" />
      </div>

    </view>
  </div>
</template>

<script>
import wxParse from 'mpvue-wxparse'
import imgLoad from 'mpvue-img-load'
export default {
  data () {
    return {
      needBind: true,
      loginResponse: {},
      shareOrderId: '',
      price: '',
      token: '',
      piece: 1,
      showModalStatus: false,
      animationData: {},
      // 配置项
      indicatorDots: false,
      enableBackToTop: true,
      autoplay: true,
      interval: 5000,
      duration: 300,
      circular: true,

      userInfo: {},
      productInfo: {
        detail: {
          rich: ''
        }
      }
    }
  },

  components: {
    wxParse,
    imgLoad
  },

  methods: {
    setData (data) {
      Object.keys(data).forEach(key => {
        this[key] = data[key]
      })
    },
    selectSpecial (key, i) {
      // 改变选择状态
      var specialList = this.productInfo.specials

      specialList.forEach(item => {
        if (item.key === key) {
          if (item.type === 'multip') {
            // 多选，只改变当前即可
            item.value.forEach(v => {
              if (v.name === i.name) {
                v.select = !v.select
              }
            })
          } else {
            // 全部恢复，再选择
            item.value.forEach(v => {
              v.select = false
            })
            item.value.forEach(v => {
              if (v.name === i.name) {
                v.select = !v.select
              }
            })
          }
        }
      })

      this.productInfo.specials = specialList
      // 查看是否选完了规格，如果是的话，请求价格
      if (!this.notChooseAllSpecial()) {
        this.productInfo.specialsExtra = '已选择'
        this.refreshProductPrice()
      } else {
        this.productInfo.specialsExtra = '请选择规格'
      }
    },
    pieceChange (e) {
      this.setData({
        piece: e.target.value
      })
      this.refreshProductPrice()
    },
    refreshProductPrice () {
      // 计算价格
      // multip 类型要求 price 必须相同
      // single 类型可以不同
      // 价格 = (multip + single ) *piece
      var specialList = this.productInfo.specials
      var tempPrice = 0.0
      // 区分类型
      var tempMultip = []
      var tempSingle = []
      specialList.forEach(special => {
        if (special.type === 'multip') {
          tempMultip.push(special)
        } else {
          tempSingle.push(special)
        }
      })
      // 计算价格
      tempMultip.forEach(item => {
        var select = false
        item.value.forEach(v => {
          if (v.select) {
            select = true
          }
        })
        if (select) {
          tempPrice += item.price
        }
      })

      tempSingle.forEach(item => {
        item.value.forEach(v => {
          if (v.select) {
            tempPrice += v.price
          }
        })
      })

      this.price = '￥' + tempPrice * this.piece
      // 计算价格结束
    },
    buyProduct () {
      if (this.notChooseAllSpecial()) {
        // 弹出选择规格
        this.showProductSpecial()
      } else {
        var that = this
        // 继续购买产品 -> 选择微信地址 -> 选择后自动提交订单即可 -> 弹出客服微信
        wx.chooseAddress({
          success: function (res) {
            // 继续购买操作，提交订单信息
            that.productInfo.addressInfo = res
            // 调用接口，请求下单接口
            wx.showLoading({
              title: '正在下单',
              mask: true
            })
            wx.request({
              url: 'https://jitsi.devdylan.cn:9443/order/create',
              method: 'POST',
              data: {
                productId: that.productInfo.id,
                piece: that.piece,
                specials: that.productInfo.specials,
                address: res,
                token: that.token,
                shareOrderId: that.shareOrderId
              },
              dataType: 'json',
              header: {
                'content-type': 'application/json',
                token: that.token
              },
              success: function (res) {
                console.log(res.data)
                if (res.data.code === 0) {
                  // TODO 下单成功了，弹出成功提示以及客服的微信二维码，请尽快联系
                  // 此时弹出分享按钮，提示用户立即邀请好友可以减免多少钱，或者去查看我的订单
                  wx.switchTab({
                    url: '/pages/counter/main'
                  })
                } else if (res.data.code === -1) {
                  // 其他错误或者异常，弹出错误信息
                  wx.showModal({
                    title: '错误',
                    content: res.data.message,
                    success: function (res) {}
                  })
                } else if (res.data.code === -2) {
                  // 需要登录
                  that.getUserInfo()
                  wx.showModal({
                    title: '错误',
                    content: '需要重新登录后再试~',
                    success: function (res) {
                      that.getUserInfo()
                    }
                  })
                } else {
                  wx.showModal({
                    title: '错误',
                    content: '网络请求出错了，请重试或者联系客服',
                    success: function (res) {}
                  })
                }
              },
              fail: function (e) {
                wx.showModal({
                  title: '错误',
                  content: '网络请求出错了，请重试或者联系客服',
                  success: function (res) {}
                })
              },
              complete: function (e) {
                wx.hideLoading()
              }
            })
          }
        })
      }
    },
    notChooseAllSpecial () {
      // 检查是否有选择过规格
      var specialList = this.productInfo.specials

      var notChooseAllSpecial = false
      specialList.forEach(item => {
        // 检查标准，所有的规格，至少选择一项
        var checkResult = item.value.some(item => {
          return item.select === true
        })
        // 如果有一个符合条件，checkResult将为true
        if (!checkResult) {
          notChooseAllSpecial = true
        }
      })
      return notChooseAllSpecial
    },
    shareProduct () {
    },
    showProductSpecial () {
      // 显示遮罩层
      var animation = wx.createAnimation({
        duration: 200,
        timingFunction: 'linear',
        delay: 0
      })
      this.animation = animation
      animation.translateY(580).step()
      this.animationData = animation.export()
      this.showModalStatus = true
      setTimeout(function () {
        animation.translateY(0).step()
        this.animationData = animation.export()
      }.bind(this), 200)
    },
    hideModal: function () {
      // 隐藏遮罩层
      var animation = wx.createAnimation({
        duration: 200,
        timingFunction: 'linear',
        delay: 0
      })
      this.animation = animation
      animation.translateY(580).step()
      this.animationData = animation.export()
      setTimeout(function () {
        animation.translateY(0).step()
        this.animationData = animation.export()
        this.showModalStatus = false
      }.bind(this), 200)
    },
    btnGetUserInfo (res) {
      this.getUserInfo()
    },
    bindUserInfo () {
      wx.request({
        url: 'https://jitsi.devdylan.cn:9443/user/update',
        method: 'POST',
        data: this.userInfo,
        dataType: 'json',
        header: {
          'content-type': 'application/json',
          token: this.token
        },
        success: function (res) {
          if (res.data.code === 0) {
            console.log('更新信息成功', res)
          } else {
            console.log('更新信息失败', res)
          }
        },
        fail: function (e) {
          console.log('更新信息失败', e)
        }
      })
    },
    getUserInfo () {
      // 调用登录接口
      var that = this
      console.log('调用登录接口')
      wx.login({
        success: (lResponse) => {
          var loginResponse = lResponse
          that.loginResponse = loginResponse
          this.refreshProductInfo()
          wx.getSetting({
            success: function (res) {
              console.log(res)
              if (res.authSetting['scope.userInfo'] === true) {
                // 已经授权，可以直接调用 getUserInfo 获取头像昵称
                that.needBind = false
              } else if (res.authSetting['scope.userInfo'] === false || res.authSetting['scope.address'] === false) {
                that.needBind = true
                wx.openSetting({
                  success: res => {
                    console.log(res)
                  },
                  fail: res => {
                    console.log(res)
                  }
                })
              } else {

              }
            }
          })
        }
      })
    },
    getAddressAuth () {
      wx.authorize({scope: 'scope.address'})
    },
    preview (src, e) {
      // do something
    },
    navigate (href, e) {
      // do something
    },
    refreshProductInfo () {
      var that = this
      console.log('获取用户信息')
      wx.request({
        url: 'https://jitsi.devdylan.cn:9443/user/login',
        method: 'POST',
        data: {
          code: that.loginResponse.code
        },
        dataType: 'json',
        header: {
          'content-type': 'application/json'
        },
        success: function (res) {
          console.log('登录成功')
          console.log(res.data)
          if (res.data.code === 0) {
            that.token = res.data.data.token
            if (!that.needBind) {
              wx.getUserInfo({
                success: function (res) {
                  console.log(res.userInfo)
                  that.userInfo = res.userInfo
                  that.userInfo.openId = that.token
                  that.bindUserInfo()
                }
              })
            }
            // 获取商品开始
            wx.request({
              url: 'https://jitsi.devdylan.cn:9443/product/hot',
              method: 'POST',
              data: {},
              dataType: 'json',
              header: {
                'content-type': 'application/json',
                token: that.token
              },
              success: function (res) {
                if (res.data.code === 0) {
                  // 获取热门商品成功
                  that.productInfo = res.data.data
                  that.refreshProductPrice()
                  wx.stopPullDownRefresh()
                } else {
                  that.productInfo = {
                    detail: {
                      rich: ''
                    }
                  }
                }
              },
              fail: function (e) {
                that.productInfo = {
                  detail: {
                    rich: ''
                  }
                }
              }
            })
            // 获取商品结束
          } else {
            that.token = ''
          }
        },
        fail: function (e) {
          that.token = ''
          console.log('获取信息失败')
        }
      })
    }
  },

  onShareAppMessage () {

  },

  onPullDownRefresh () {
    this.getUserInfo()
  },

  onLoad (options) {
    if (options && options.shareOrderId !== '') {
      this.shareOrderId = options.shareOrderId
    } else {
      this.shareOrderId = ''
    }
  },

  created () {
    // 调用应用实例的方法获取全局数据
    this.getUserInfo()
    this.getAddressAuth()
  }
}
</script>
