import Vue from 'vue'
import './plugins/axios'
import App from './App.vue'
//import App from './views/main/Main.vue'
import vuetify from './plugins/vuetify';
// import colors from 'vuetify/lib/util/colors';
import router from './router'

Vue.config.productionTip = false

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')



var mysql = require('mysql');
// Connection 객체 생성 
var connection = mysql.createConnection({
  host: '54.180.145.129',
  port: 3306,
  user: 'admin',   
  password: '',
  database: 'weedy'  
});  
// Connect
connection.connect(function (err) {   
  if (err) {     
    console.error('mysql connection error');     
    console.error(err);     
    throw err;   
  } 
});
