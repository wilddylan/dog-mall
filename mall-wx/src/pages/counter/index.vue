<style scoped>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

text, p, span {
  font-weight: 300;
}

.list-container {
  width: 100vw;
  box-sizing: border-box;
  padding-left: 12px;
  padding-right: 12px;
  background-color: #fff;
  padding-bottom: 12px;
}

.order {
  box-sizing: border-box;
  margin-top: 10px;
  width: 100%;
  background-color: #fff;
  border: 1px solid #f3f3f3;
  box-shadow: #f3f3f3 8px 1px 5px 3px;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
}

.order-basic {
  width: 100%;
  height: 44px;
  display: flex;
  flex-direction: row;
  align-items: center;
  padding-left: 12px;
  box-sizing: border-box;
  /* margin-bottom: 3px; */
}

.order-basic p {
  font-size: 17px;
}

.order-basic-id {
  /* padding-top: 3px; */
  margin-left: 5px;
  flex-grow: 1;
  color: #333333;
}

.order-basic-state {
  /* padding-top: 3px; */
  margin-right: 12px;
  color: #986801;
}

.order-line {
  height: 1px;
  width: 100%;
  background-color: #f3f3f3;
}

.order-info {
  width: 100%;
  box-sizing: border-box;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  padding-left: 12px;
  padding-top: 12px;
  margin-bottom: 12px;
}

.order-info-avatar {
  width: 64px;
  height: 64px;
  border-radius: 3px;
}

.order-info-detail {
  margin-left: 10px;
  flex-grow: 1;
}

.order-info-detail-title {
  font-size: 17px;
  color: #333333;
}

.order-info-detail-special {
  font-size: 14px;
  color: #646464;
}

.order-info-detail-piece {
  font-size: 20px;
  color: #986801;
  margin-right: 12px;
}

.order-info-detail-piece span {
  font-size: 14px;
  color: #333333;
}

.order-price {
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-end;
  padding-left: 12px;
  box-sizing: border-box;
}

.order-price-origin {
  font-size: 14px;
  margin-right: 10px;
  color: #986801;
  text-decoration: line-through;
  text-decoration-color: #986801;
}

.order-price-real {
  font-size: 14px;
  color: #986801;
  margin-right: 12px;
}

.order-line-friend {
  height: 1px;
  width: 100%;
  background-color: #f3f3f3;
}

.order-info-friend {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-start;
  padding-left: 12px;
  box-sizing: border-box;
  margin-bottom: 10px;
}

.order-info-friend-invite {
  margin-top: 10px;
  width: 100%;
  box-sizing: border-box;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
}

.order-info-friend-invite-title {
  font-size: 17px;
  color: #646464;
  align-self: flex-start;
  flex-grow: 1;
  box-sizing: border-box;
}

.order-info-friend-invite-title .extra {
  font-size: 12px;
  color: #333333;
}

.order-info-friend-invite-friend-item {
  margin-right: 12px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  flex-shrink: 0;
}

.order-info-friend-invite-friend-item .avatar {
  margin-left: 5px;
  color: #986801;
}

.order-express {
  width: 100%;
  display: flex;
  flex-direction: column;
}

.order-line-express {
  height: 1px;
  width: 100%;
  background-color: #f3f3f3;
}

.order-express .title {
  margin-top: 10px;
  margin-left: 12px;
  color: #646464;
  font-size: 17px;
}

.order-express .name {
  font-size: 14px;
  color: #333333;
  margin-left: 12px;
  margin-top: 5px;
}

.order-express .name span {
  font-size: 14px;
  color: #986801;
  margin-left: 5px;
}

.order-express .detail {
  font-size: 14px;
  color: #646464;
  margin-left: 12px;
}

.order-express .contact-phone {
  margin-top: 5px;
  width: 100%;
  box-sizing: border-box;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: flex-start;
  padding-left: 12px;
  padding-right: 12px;
}

.order-express .contact-phone .contact {
  font-size: 14px;
  color: #646464;
}

.order-express .contact-phone .phone {
  font-size: 14px;
  color: #986801;
  margin-left: 12px;
}

.order-express .address {
  font-size: 14px;
  color: #646464;
  margin-left: 12px;
}

.order-options {
  width: 100%;
  display: flex;
  flex-direction: row;
  align-items: center;
}

.order-options .contact {
  flex-grow: 1;
}

.order-options .share {

}

.order-options .share-container {
  background-color: rgba(0, 0, 0, 0) !important;
  margin: 0 !important;
  padding: 0 !important;
  flex-grow: 1;
  box-sizing: border-box;
  border-radius: 0;
  border: 0;
}

.order-options .share-container::after {
  border: none;
}

</style>

<template>
  <div class="list-container">
    <div class="order" v-for="item in orderList" :key="item.orderId">

      <!-- 订单号 + 订单状态 -->
      <div class="order-basic">
        <i-icon type="barrage" size="17" color="#646464" />
        <p class="order-basic-id">{{item.orderId}}</p>
        <p class="order-basic-state">{{item.orderState}}</p>
      </div>

      <div class="order-line"></div>

      <!-- 商品信息，规格，数量 -->
      <div class="order-info">
        <!-- 图片 -->
        <img class="order-info-avatar" :src="item.productInfo.images[0].url"></img>
        <!-- 标题,规格 -->
        <div class="order-info-detail">
          <p class="order-info-detail-title">{{item.productInfo.name}}</p>
          <p class="order-info-detail-special" v-for="(sp, sd) in item.specials" :key="sd">
            {{sp}}
          </p>
        </div>
        <!-- 数量 -->
        <p class="order-info-detail-piece">x{{item.piece}}<span>件</span></p>
      </div>

      <div class="order-line-friend"></div>

      <!-- 好友邀请信息 -->
      <div class="order-info-friend">
        <!-- 已经邀请成功下单的好友 -->
        <div class="order-info-friend-invite">
          <div class="order-info-friend-invite-title">
            <p>邀请下单可减免费用</p>
            <p class="extra">{{item.invite}}</p>
          </div>
          <!-- <div class="order-info-friend-invite-friend-item">
            <i-avatar class="avatar" v-for="(friend, fd) in item.inviteInfo" :key="fd" :src="friend.avatarUrl" size="default"></i-avatar>
          </div> -->
        </div>
      </div>

      <!-- 快递信息 -->
      <div class="order-express">
        <div class="order-line-express"></div>
        <p class="title">{{item.expressState}}</p>

        <p v-if="item.expressInfo.name" class="name">[{{item.expressInfo.name}}] <span v-if="item.expressInfo.expect">({{item.expressInfo.expect}})</span></p>
        <p v-if="item.expressInfo.current" class="detail">{{item.expressInfo.current}}</p>
        <!-- 收货人信息  -->
        <div v-if="item.expressState != '暂无快递信息'" class="contact-phone">
          <p class="contact">{{item.expressInfo.contact}}</p>
          <p class="phone">{{item.expressInfo.phone}}</p>
        </div>
        <p v-if="item.expressState != '暂无快递信息'" class="address">{{item.expressInfo.address}}</p>
      </div>

      <!-- 小计 -->
      <div class="order-price">
        <span class="order-price-origin">原价：￥{{item.originPrice}}</span><p class="order-price-real">{{item.price}}</p>
      </div>

      <!-- 联系客服按钮 -->
      <div class="order-options">
        <button
          class="share-container"
          open-type="contact">
          <i-button class="contact"  @click="contact(item, item.orderId)" type="ghost" shape="circle" size="small">联系客服</i-button>
        </button>
        <button
          class="share-container"
          :data-id="item.orderId"
          :data-price="item.productInfo.invitePrice"
          :data-name="item.productInfo.name"
          plain="true"
          open-type="share">
          <i-button class="share" type="primary" shape="circle" size="small">我要免单</i-button>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  // Copyright (c) 2018 Copyright Holder All Rights Reserved.
  data () {
    return {
      token: '',
      userInfo: {},
      orderList: []
    }
  },
  methods: {
    contact (order, orderId) {
      console.log(order)
      console.log(orderId)
    },
    setData (data) {
      Object.keys(data).forEach(key => {
        this[key] = data[key]
      })
    },
    getUserInfo () {
      // 调用登录接口
      var that = this
      wx.login({
        success: (loginResponse) => {
          wx.request({
            url: 'https://jitsi.devdylan.cn:9443/user/login',
            method: 'POST',
            data: {
              // encryptedData: res.encryptedData,
              // errMsg: res.errMsg,
              // iv: res.iv,
              // rawData: res.rawData,
              // signature: res.signature,
              // userInfo: res.userInfo,
              code: loginResponse.code
            },
            dataType: 'json',
            header: {
              'content-type': 'application/json'
            },
            success: function (res) {
              console.log(res.data)
              if (res.data.code === 0) {
                that.token = res.data.data.token
                // 获取订单列表开始
                wx.request({
                  url: 'https://jitsi.devdylan.cn:9443/order/query',
                  method: 'POST',
                  data: {
                    token: that.token
                  },
                  dataType: 'json',
                  header: {
                    'content-type': 'application/json',
                    token: that.token
                  },
                  success: function (res) {
                    console.log(res)
                    wx.stopPullDownRefresh()
                    if (res.data.code === 0) {
                      // 获取订单成功
                      that.orderList = res.data.datas
                    } else {
                      that.orderList = []
                    }
                  },
                  fail: function (e) {
                    wx.stopPullDownRefresh()
                    that.orderList = []
                  }
                })
                // 获取订单列表结束
              } else {
                that.token = ''
              }
            },
            fail: function (e) {
              that.token = ''
            }
          })
        }
      })
    }
  },

  onShareAppMessage (req) {
    var orderId = req.target.dataset.id
    var invitePrice = req.target.dataset.price
    var name = req.target.dataset.name
    return {
      title: '您的好友邀您购买' + name,
      desc: '您下单成功即可帮助他减免 ￥' + invitePrice + ' 元',
      path: 'pages/index/main?shareOrderId=' + orderId
    }
  },

  onPullDownRefresh () {
    this.getUserInfo()
  },

  onShow () {
    this.getUserInfo()
  },

  created () {
    this.getUserInfo()
  }
}
</script>
