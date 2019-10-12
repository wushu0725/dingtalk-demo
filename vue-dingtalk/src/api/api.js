import axios from 'axios'

import {getToken} from '@/api/auth'
import store from '../store'
// 创建axios实例
const service = axios.create({
  baseURL: process.env.BASE_URL, // api的base_url
  timeout: 15000                  // 请求超时时间2
})
// request拦截器
service.interceptors.request.use(config => {
  return config
}, error => {
  // Do something with request error
  console.error(error) // for debug
  Promise.reject(error)
})
// respone拦截器
service.interceptors.response.use(
  response => {
    const res = response.data;
    if (res.returnCode == '1000') {
      return res;
    }
    if (res.returnCode == '100') {
      return res.returnData;
    } else if (res.returnCode == '400') {
      return res.returnData
    } else {
      return Promise.reject(res)
    }
  },
  error => {
    console.error('err' + error)// for debug
    return Promise.reject(error)
  }
)
export default service

