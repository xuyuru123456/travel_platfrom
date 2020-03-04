import Axios from 'axios'

Axios.defaults.baseURL = 'http://127.0.0.1:8087';
Axios.defaults.headers.post['Content-Type'] = 'application/json;charset=UTF-8';
export default{
//登入
requestLogin(params){
    return Axios.post("/user/login",params).then(res => res.data)
 },
  //添加注册用户
  addUser(params){
    return Axios.post("/user",params).then(res => res.data)
  },
  //用户列表
  userList(params){
    return Axios.post("/user/page",params).then(res => res.data)
  },
  //删除用户
  delete(params){
    return Axios.delete("/user",params).then(res => res.data)
  },
}

