# Auth 

### 개요

어떤 사이트에서 페이지가 여러 개가 있을 때 로그인된 유저만 접근 가능한 페이지와 누구나 접근 가능한 페이지가 있다.<br>
또는 관리자만 접근이 가능한 페이지를 구축하기 위해 **Authentication 기능**이 필요하다.

이전에 Token을 만들고 유저 정보에 넣고, 또 Client에는 쿠키, Server에는 데이터베이스에 넣어줬다.<br>
이 두가지 Token을 이용해서 서로 같은 Token인지 계속 체크해서 Authentication을 만든다.<br>
만약 어떤 사람이 A 페이지에서 B 페이지로 이동한다고 하면,<br>
이 유저가 B 페이지에 접근 권한이 있는지 체크하기 위해 Client에서 Server에 쿠키에 담겨져 있는 Token을 전달한다.<br>
Server 쪽에서 Token을 전달할 때 암호화된 Token을 복호화해서 user id를 얻고,<br>
그 유저 데이터베이스에 이 Token이 있다면 인증이 맞다고 한다.<br>
없거나 다르면 이 유저가 아니니까 접근하지 못하게 한다.<br>

1. 쿠키에 저장된 Token을 Server에 가져와서 복호화한다.
2. 복호화를 하면 User ID가 나오는데 그 User ID를 이용해서 데이터베이스의 User Collection에서 유저를 찾은 후, <br>
쿠키에서 받아온 Token이 유저도 가지고 있는지 확인한다.
3. - 쿠키가 일치하지 않으면 인증 실패! 
   - 쿠키가 일치한다면 인증 성공!
4. 해당하는 유저의 정보들을 선별해서(아이디, 이미지 등등)을 프론트 단에 보내준다.

#### index.js - Auth route

```js

const { auth } = require("./middleware/auth");

// auth Router
// auth 미들웨어: request를 받아서 콜백펑션을 실행하기전에 중간에서 처리하는것. -> middleware 폴더 - auth.js 에서 구현
// auth.js에서 user와 id를 request로 가져서 바로 저렇게 밑에서 사용할 수 있는 것이다.
// 이렇게 라우터를 만들어 놓으면 어느 페이지에서 user 정보와 id를 가지고있어서 사용할 수가 있음.
 
app.get('/api/users/auth', auth , (req, res) => { // auth 미들웨어 사용
    // 여기까지 미들웨어를 통과해 왔다는 얘기는 Authentication이 True라는 의미이다.
    res.status(200).json({
        
        _id: req.user._id, // auth 미들웨어에서 request로 가져왔기 때문에 사용 가능
        isAdmin: req.user.role === 0 ? false : true, // role : 0 -> 일반유저
        isAuth: true,
        email: req.user.email,
        name: req.user.name,
        lastname: req.user.lastname,
        role: req.user.role,
        image: req.user.image
        
    });
});
```


#### middleware / auth.js
```js
const { User } = require("../models/User");

let auth = (req, res, next) => {

    // 인증처리 하는 곳

    // 클라이언트의 쿠키에서 토큰을 가져온다. => cookieparser 사용
    let token = req.cookies.x_auth;

    // 토큰을 복호화한 다음에  user을 찾는다.
    User.findByToken(token, (err, user) => {
        if(err) throw err;
        if(!user) return res.json({ isAuth: false, error : true }) // 맞는 유저가 없다면 인증 실패!
        
        // 유저가 있으면 인증 ok!
        req.token = token;
        req.user = user;
        next(); // 미들웨어에서 나갈수 있게 next를 넣어준다.

    })
    // 유저가 없으면 인증 No!
}
module.exports = { auth };
```

#### user.js
```js
// auth의 미들웨어
userSchema.statics.findByToken = function(token , cb) {
    var user = this; // user 스키마

    // 가져온 토큰을 복호화한다.
    jwt.verify(token, 'secretToken', function(err, decoded){
        // 유저 id를 이용해서 유저를 찾은 다음에,
        // 클라이언트에서 가져온 token과 DB에 보관된 token이 일치하는지 확인한다.

        user.findOne({ "_id" : decoded, "token" : token}, function(err, user){
            if (err) return cb(err);
            console.log('user',user); // 인증에 성공했다면 유저 정보 전달.
            cb(null, user)
        })
    })
}
```
