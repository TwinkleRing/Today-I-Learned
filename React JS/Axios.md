# Axios

Axios는 브라우저, Node.js를 위한 Promise API를 활용하는 HTTP 비동기 통신 클라이언트 라이브러리입니다.

### 특징 
* 운영 환경에 따라 브라우저의 XMLHttpRequest 객체 또는 Node.js의 http api 사용
* Promise(ES6) API 사용
* 요청과 응답 데이터의 변형이 가능하다.
* HTTP 요청 취소가 가능하다.
* HTTP 요청과 응답을 JSON 형태로 자동 변환해준다.

### 설치하기
1. cd client
2. npm install axios --save


#### client - LandingPage.js
```js
import React, { useEffect } from 'react
import axios from 'axios;

function LandingPage() {
  useEffect(() => {
    axios.get('/api/hello') // get request를 서버에 보낸다.
      .then(response => console.log(response.data)) // 서버에서 받아온 response를 console에 출력한다.
  }, [])
  
  return (
    <div>
      LandingPage 랜딩페이지
    </div>
    
  )
 
export default LandingPage
```


#### server - index.js
```
app.get('/api/hello', (req,res) => {

  res.send("안녕하세요 ~ ")
  
})
```


### CORS 이슈, Proxy 설정

서버는 port 번호가 5000이고 클라이언트는 3000번으로 서로 다르다. <br>
그래서 port 번호가 다르므로 따로 설정을 안해주면 서로 요청을 보내는 것이 CORS 정책에 의해 막힌다.<br>
Cross Origin Resource Sharing 정책은 다른 웹사이트에서 나의 서버로 뭔가를 보내면 보안적인 이슈가 생길수 있으므로 만든 정책이다.<br>

Proxy를 설정해서 사용해보자.<br>

참고> https://create-react-app.dev/docs/proxying-api-requests-in-development

### 설치 
* npm install http-proxy-middleware --save


#### client / src / setupProxy.js
```js
const { createProxyMiddleware } = require('http-proxy-middleware');
module.exports = function(app) {
    app.use (
        '/api',
        createProxyMiddleware({
            target: 'http://localhost:5000',
            changeOrigin : true,
        })
    );
};
```

