# Axios

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
