## MongoDB Model & Schema

Mongoose는 MongoDB ODM(Object Document Mapping)로 Schema 객체를 사용하여 MongoDB에 Model을 정의합니다. <br>
Schema는 테이블의 구조를 뜻하는데 Mongoose를 사용하면 SQL처럼 컬렉션의 구조를 정할 수 있습니다. <br>
Model은 스키마를 통해서 만드는 Instance로 이를 통하여, 데이터베이스에 실제 작업을 할 수 있게 됩니다. <br>

예를 들어 어떤 웹사이트에서 회원가입을 해는데 이때 유저 아이디나 사는 곳, 나이를 입력한다. <br>
입력한 값들이 유저 데이터베이스에 들어가야하는데 이런 유저와 관련된 데이터들을 보관하기 위해 User Model이 필요하다.

### 사용법

1. User.js 생성

2. User.js에 mongoose 모듈 가져오기
```js
const mongoose = require('mongoose');
```

3. User의 모델과 스키마 설정
```js

const userSchema = mongoose.Schema({
    name : {
        type : String,
        maxlength : 50
    },
    email :{
        type : String,
        trim :true, // 공백 제거해주는 trim
        unique : 1 // 똑같은 이메일은 쓰지 못하도록.
    },
    password : {
        type : String,
        minlength : 5
    },
    lastanme : {
        type : String,
        maxlength : 50
    },
    role : { // 어떤 유저가 관리자일수도 있고, 일반 유저일수도 있다.
        type : Number, // Number로 role을 구분
        default : 0
    },
    image : String,

    token :{
        type : String // 유효성 관리
    },
    tokenExp : { // 토큰 사용할수 있는 유효 기간
        type : Number
    }
})

// 유저 모델의 정보를 저장하기 전에(index.js에서 save 하기 전에) function을 준다.
const User = mongoose.model('User',userSchema)
// 이 유저를 다른 파일에서 사용할 수 있게 exports 해준다.
module.exports = { User }


```
