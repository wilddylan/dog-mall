# dog-mall
微信小程序开源小玩物

#### 展示图

![展示1](https://github.com/WildDylan/dog-mall/edit/master/images/IMG_3664.PNG)

![展示2](https://github.com/WildDylan/dog-mall/edit/master/images/IMG_3665.PNG)

![展示3](https://github.com/WildDylan/dog-mall/edit/master/images/IMG_3666.PNG)

![展示4](https://github.com/WildDylan/dog-mall/edit/master/images/IMG_3667.PNG)



#### 简单构思

> 下单，邀请好友购买成功，即可减免费用

商品规格分为 `multip` 以及`single`；

商品金额计算：multip 计费外层price，single 计费每个value的price，最后乘以数量。



#### 功能点

- [x] 商品展示，订单列表
- [x] 邀请好友免单金额计算

#### 注意点

学习所写，完全是为了熟悉一下小程序开发，以便更好的跟其他朋友沟通

纯学习小程序开发所写，大概用了24小时，各位不喜勿喷，只适合新手看看玩玩。



#### 技术点

mall-wx：小程序源码，使用 mpvue 框架

mall-admin：管理后台源码，使用 antd-admin 修改，半成品 ...

其他都是java的模块，最简单的maven多模块项目，直连数据库。。。



#### 部分接口数据

1. 商品详情 JSON

```json
{
    "code": 0,
    "data": null,
    "datas": [
        {
            "delete": 0,
            "description": "内蒙科尔沁牛肉干包邮 | 纯天然零添加",
            "detail": {
                "images": [
                    {
                        "height": 5,
                        "key": "1",
                        "url": "http://r.devdylan.cn/IMG_3651.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "2",
                        "url": "http://r.devdylan.cn/IMG_3652.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "3",
                        "url": "http://r.devdylan.cn/IMG_3653.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "4",
                        "url": "http://r.devdylan.cn/IMG_3654.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "5",
                        "url": "http://r.devdylan.cn/IMG_3655.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "6",
                        "url": "http://r.devdylan.cn/IMG_3656.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "7",
                        "url": "http://r.devdylan.cn/IMG_3657.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "8",
                        "url": "http://r.devdylan.cn/IMG_3658.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "9",
                        "url": "http://r.devdylan.cn/IMG_3659.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "10",
                        "url": "http://r.devdylan.cn/IMG_3660.JPG",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "11",
                        "url": "http://r.devdylan.cn/IMG_3661.JPG",
                        "width": 5
                    }
                ],
                "rich": "<h5>现在预约购买，享受价格绝对优惠！而且可以邀请好友来帮你减少付款金额哦！您有 3 天时间邀请好友购买！邀请成功，立减 88 元！</h5>"
            },
            "express": "顺丰速运、中通、圆通、EMS",
            "id": 4,
            "images": [
                {
                    "height": 5,
                    "key": "0",
                    "url": "http://r.devdylan.cn/Fl3fa6rNuZhtnxdr1IQ6QrXINIWh.jpg",
                    "width": 5
                },
                {
                    "height": 5,
                    "key": "1",
                    "url": "http://r.devdylan.cn/FsE54COQopIEkL08CTUxSaBc93ES.jpg",
                    "width": 5
                },
                {
                    "height": 5,
                    "key": "2",
                    "url": "http://r.devdylan.cn/FuxdC4Kc8HM0TJnXHUITg5OC0EA9.jpg",
                    "width": 5
                }
            ],
            "infos": [
                {
                    "key": "重量",
                    "value": "5两、1斤、2斤、5斤、10斤"
                },
                {
                    "key": "包装",
                    "value": "统一无菌真空包装"
                },
                {
                    "key": "储藏",
                    "value": "推荐冷藏，开封后请尽快食用"
                },
                {
                    "key": "用量",
                    "value": "老人、小孩请控制食量，过多对肠胃不好"
                }
            ],
            "invitePrice": 88,
            "left": 399,
            "name": "成吉思汗军粮（精选）",
            "questions": [
                {
                    "anwser": "单笔订单金额满188免邮费，不满188元按照正常标准收取邮费。",
                    "key": "0",
                    "question": "购买运费如何收取?"
                },
                {
                    "anwser": "默认使用顺丰速递，部分城市使用圆通、中通、EMS等快递，有加急需求的宝宝们请联系客服（全球可达）。",
                    "key": "1",
                    "question": "使用什么快递发货?"
                },
                {
                    "anwser": "订单生成后会弹出客服微信，请添加客服然后进行下单。",
                    "key": "2",
                    "question": "如何付款?"
                }
            ],
            "sendTime": "9月15号全国统一发货",
            "specials": [
                {
                    "extra": "多种口味选择，自动组合发货",
                    "key": "口味",
                    "price": 88,
                    "type": "multip",
                    "value": [
                        {
                            "name": "香辣",
                            "price": 0,
                            "select": false
                        },
                        {
                            "name": "原味",
                            "price": 0,
                            "select": false
                        }
                    ]
                },
                {
                    "extra": "1斤重，今日8.5折，5斤重，今日7折",
                    "key": "重量",
                    "price": 100,
                    "type": "single",
                    "value": [
                        {
                            "name": "1斤",
                            "price": 218,
                            "select": false
                        },
                        {
                            "name": "2斤",
                            "price": 388,
                            "select": false
                        },
                        {
                            "name": "5斤",
                            "price": 998,
                            "select": false
                        },
                        {
                            "name": "10斤",
                            "price": 1688,
                            "select": false
                        }
                    ]
                }
            ],
            "specialsExtra": "快来选择规格吧!"
        }
    ],
    "message": "成功 !",
    "total": 1
}
```

2. 订单 JSON

```json
{
    "code": 0,
    "data": null,
    "datas": [
        {
            "expressInfo": {
                "address": "内蒙古自治区巴彦淖尔市临河区临河一中[015000]",
                "contact": "薛雨仑",
                "current": "",
                "expect": "",
                "expressNumber": "",
                "name": "",
                "phone": "18947488610",
                "postCode": "015000"
            },
            "expressState": "NONE",
            "invite": 0,
            "inviteInfo": [],
            "openId": "o-Phr5ZqGJBGx9lPKbPZAN9HJjHY",
            "orderId": "201808311932444",
            "orderState": "WAIT_PAY",
            "originPrice": 1776,
            "piece": 1,
            "price": 1776,
            "productId": 4,
            "productInfo": {
                "delete": 0,
                "description": "内蒙科尔沁牛肉干包邮 | 纯天然零添加",
                "detail": {
                    "images": [
                        {
                            "height": 5,
                            "key": "1",
                            "url": "http://r.devdylan.cn/IMG_3651.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "2",
                            "url": "http://r.devdylan.cn/IMG_3652.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "3",
                            "url": "http://r.devdylan.cn/IMG_3653.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "4",
                            "url": "http://r.devdylan.cn/IMG_3654.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "5",
                            "url": "http://r.devdylan.cn/IMG_3655.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "6",
                            "url": "http://r.devdylan.cn/IMG_3656.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "7",
                            "url": "http://r.devdylan.cn/IMG_3657.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "8",
                            "url": "http://r.devdylan.cn/IMG_3658.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "9",
                            "url": "http://r.devdylan.cn/IMG_3659.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "10",
                            "url": "http://r.devdylan.cn/IMG_3660.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "11",
                            "url": "http://r.devdylan.cn/IMG_3661.JPG",
                            "width": 5
                        }
                    ],
                    "rich": "<h5>现在预约购买，享受价格绝对优惠！而且可以邀请好友来帮你减少付款金额哦！您有 3 天时间邀请好友购买！邀请成功，立减 88 元！</h5>"
                },
                "express": "顺丰速运、中通、圆通、EMS",
                "id": 4,
                "images": [
                    {
                        "height": 5,
                        "key": "0",
                        "url": "http://r.devdylan.cn/Fl3fa6rNuZhtnxdr1IQ6QrXINIWh.jpg",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "1",
                        "url": "http://r.devdylan.cn/FsE54COQopIEkL08CTUxSaBc93ES.jpg",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "2",
                        "url": "http://r.devdylan.cn/FuxdC4Kc8HM0TJnXHUITg5OC0EA9.jpg",
                        "width": 5
                    }
                ],
                "infos": [
                    {
                        "key": "重量",
                        "value": "5两、1斤、2斤、5斤、10斤"
                    },
                    {
                        "key": "包装",
                        "value": "统一无菌真空包装"
                    },
                    {
                        "key": "储藏",
                        "value": "推荐冷藏，开封后请尽快食用"
                    },
                    {
                        "key": "用量",
                        "value": "老人、小孩请控制食量，过多对肠胃不好"
                    }
                ],
                "invitePrice": 88,
                "left": 399,
                "name": "成吉思汗军粮（精选）",
                "questions": [
                    {
                        "anwser": "单笔订单金额满188免邮费，不满188元按照正常标准收取邮费。",
                        "key": "0",
                        "question": "购买运费如何收取?"
                    },
                    {
                        "anwser": "默认使用顺丰速递，部分城市使用圆通、中通、EMS等快递，有加急需求的宝宝们请联系客服（全球可达）。",
                        "key": "1",
                        "question": "使用什么快递发货?"
                    },
                    {
                        "anwser": "订单生成后会弹出客服微信，请添加客服然后进行下单。",
                        "key": "2",
                        "question": "如何付款?"
                    }
                ],
                "sendTime": "9月15号全国统一发货",
                "specials": [
                    {
                        "extra": "多种口味选择，自动组合发货",
                        "key": "口味",
                        "price": 88,
                        "type": "multip",
                        "value": [
                            {
                                "name": "香辣",
                                "price": 0,
                                "select": false
                            },
                            {
                                "name": "原味",
                                "price": 0,
                                "select": false
                            }
                        ]
                    },
                    {
                        "extra": "1斤重，今日8.5折，5斤重，今日7折",
                        "key": "重量",
                        "price": 100,
                        "type": "single",
                        "value": [
                            {
                                "name": "1斤",
                                "price": 218,
                                "select": false
                            },
                            {
                                "name": "2斤",
                                "price": 388,
                                "select": false
                            },
                            {
                                "name": "5斤",
                                "price": 998,
                                "select": false
                            },
                            {
                                "name": "10斤",
                                "price": 1688,
                                "select": false
                            }
                        ]
                    }
                ],
                "specialsExtra": "快来选择规格吧!"
            },
            "shareId": "",
            "specialJsonString": "[\"口味：原味、\",\"重量：10斤、\"]",
            "specials": [
                "口味：原味、",
                "重量：10斤、"
            ],
            "userInfo": {
                "avatarUrl": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKZ2fnNqAUVhFBxY15KcCHOk93zsefiaqMqrfwC2dO3iamlJzcR6ibyTpoGFia0WhAuWSDtqdazia2tiaEw/132",
                "city": "Hohhot",
                "country": "China",
                "gender": "1",
                "language": "zh_CN",
                "nickName": "dylan",
                "openId": "o-Phr5ZqGJBGx9lPKbPZAN9HJjHY",
                "province": "Inner Mongolia",
                "unionId": ""
            }
        },
        {
            "expressInfo": {
                "address": "xxx",
                "contact": "xxx",
                "current": "",
                "expect": "",
                "expressNumber": "",
                "name": "",
                "phone": "xxx",
                "postCode": "010022"
            },
            "expressState": "NONE",
            "invite": 0,
            "inviteInfo": [],
            "openId": "o-Phr5ZqGJBGx9lPKbPZAN9HJjHY",
            "orderId": "201808310152044",
            "orderState": "WAIT_PAY",
            "originPrice": 218,
            "piece": 1,
            "price": 218,
            "productId": 4,
            "productInfo": {
                "delete": 0,
                "description": "内蒙科尔沁牛肉干包邮 | 纯天然零添加",
                "detail": {
                    "images": [
                        {
                            "height": 5,
                            "key": "1",
                            "url": "http://r.devdylan.cn/IMG_3651.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "2",
                            "url": "http://r.devdylan.cn/IMG_3652.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "3",
                            "url": "http://r.devdylan.cn/IMG_3653.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "4",
                            "url": "http://r.devdylan.cn/IMG_3654.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "5",
                            "url": "http://r.devdylan.cn/IMG_3655.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "6",
                            "url": "http://r.devdylan.cn/IMG_3656.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "7",
                            "url": "http://r.devdylan.cn/IMG_3657.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "8",
                            "url": "http://r.devdylan.cn/IMG_3658.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "9",
                            "url": "http://r.devdylan.cn/IMG_3659.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "10",
                            "url": "http://r.devdylan.cn/IMG_3660.JPG",
                            "width": 5
                        },
                        {
                            "height": 5,
                            "key": "11",
                            "url": "http://r.devdylan.cn/IMG_3661.JPG",
                            "width": 5
                        }
                    ],
                    "rich": "<h5>现在预约购买，享受价格绝对优惠！而且可以邀请好友来帮你减少付款金额哦！您有 3 天时间邀请好友购买！邀请成功，立减 88 元！</h5>"
                },
                "express": "顺丰速运、中通、圆通、EMS",
                "id": 4,
                "images": [
                    {
                        "height": 5,
                        "key": "0",
                        "url": "http://r.devdylan.cn/Fl3fa6rNuZhtnxdr1IQ6QrXINIWh.jpg",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "1",
                        "url": "http://r.devdylan.cn/FsE54COQopIEkL08CTUxSaBc93ES.jpg",
                        "width": 5
                    },
                    {
                        "height": 5,
                        "key": "2",
                        "url": "http://r.devdylan.cn/FuxdC4Kc8HM0TJnXHUITg5OC0EA9.jpg",
                        "width": 5
                    }
                ],
                "infos": [
                    {
                        "key": "重量",
                        "value": "5两、1斤、2斤、5斤、10斤"
                    },
                    {
                        "key": "包装",
                        "value": "统一无菌真空包装"
                    },
                    {
                        "key": "储藏",
                        "value": "推荐冷藏，开封后请尽快食用"
                    },
                    {
                        "key": "用量",
                        "value": "老人、小孩请控制食量，过多对肠胃不好"
                    }
                ],
                "invitePrice": 88,
                "left": 399,
                "name": "成吉思汗军粮（精选）",
                "questions": [
                    {
                        "anwser": "单笔订单金额满188免邮费，不满188元按照正常标准收取邮费。",
                        "key": "0",
                        "question": "购买运费如何收取?"
                    },
                    {
                        "anwser": "默认使用顺丰速递，部分城市使用圆通、中通、EMS等快递，有加急需求的宝宝们请联系客服（全球可达）。",
                        "key": "1",
                        "question": "使用什么快递发货?"
                    },
                    {
                        "anwser": "订单生成后会弹出客服微信，请添加客服然后进行下单。",
                        "key": "2",
                        "question": "如何付款?"
                    }
                ],
                "sendTime": "9月15号全国统一发货",
                "specials": [
                    {
                        "extra": "多种口味选择，自动组合发货",
                        "key": "口味",
                        "price": 88,
                        "type": "multip",
                        "value": [
                            {
                                "name": "香辣",
                                "price": 0,
                                "select": false
                            },
                            {
                                "name": "原味",
                                "price": 0,
                                "select": false
                            }
                        ]
                    },
                    {
                        "extra": "1斤重，今日8.5折，5斤重，今日7折",
                        "key": "重量",
                        "price": 100,
                        "type": "single",
                        "value": [
                            {
                                "name": "1斤",
                                "price": 218,
                                "select": false
                            },
                            {
                                "name": "2斤",
                                "price": 388,
                                "select": false
                            },
                            {
                                "name": "5斤",
                                "price": 998,
                                "select": false
                            },
                            {
                                "name": "10斤",
                                "price": 1688,
                                "select": false
                            }
                        ]
                    }
                ],
                "specialsExtra": "快来选择规格吧!"
            },
            "shareId": "",
            "specialJsonString": "[\"口味：原味、\",\"重量：1斤、\"]",
            "specials": [
                "口味：原味、",
                "重量：1斤、"
            ],
            "userInfo": {
                "avatarUrl": "https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTKZ2fnNqAUVhFBxY15KcCHOk93zsefiaqMqrfwC2dO3iamlJzcR6ibyTpoGFia0WhAuWSDtqdazia2tiaEw/132",
                "city": "Hohhot",
                "country": "China",
                "gender": "1",
                "language": "zh_CN",
                "nickName": "dylan",
                "openId": "o-Phr5ZqGJBGx9lPKbPZAN9HJjHY",
                "province": "Inner Mongolia",
                "unionId": ""
            }
        }
    ],
    "message": "成功 !",
    "total": 2
}
```

