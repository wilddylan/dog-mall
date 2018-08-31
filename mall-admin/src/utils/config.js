const AdminApiPrefix = '/admin'

module.exports = {
  name: 'Dog mall 后台管理系统',
  prefix: 'dog-mall',
  footerText: 'dog-mall 后台管理系统 © 2018 dylan',
  logo: '/public/logo.svg',
  iconFontCSS: '/public/iconfont.css',
  iconFontJS: '/public/iconfont.js',
  openPages: ['/login'],
  apiPrefix: AdminApiPrefix,
  api: {
    userLogin: `${AdminApiPrefix}/user/login`,
    userLogout: `${AdminApiPrefix}/user/logout`,
    userInfo: `${AdminApiPrefix}/userInfo`,
    users: `${AdminApiPrefix}/users`,
    posts: `${AdminApiPrefix}/posts`,
    user: `${AdminApiPrefix}/user/:id`,
    dashboard: `${AdminApiPrefix}/dashboard`,
    menus: `${AdminApiPrefix}/menus`,
    weather: `${AdminApiPrefix}/weather`,
    v1test: `${AdminApiPrefix}/test`,
  },
}
