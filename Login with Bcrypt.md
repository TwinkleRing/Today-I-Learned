# Login 

## Login Route 만들기


### 1. 데이터베이스에서 요청된 E-mail 찾기
### 2. 데이터베이스에 요청한 E-mail이 있다면 비밀번호가 같은지 확인하기.

### 3. 비밀번호까지 같다면 Token 생성하기.
 * Token 생성을 위해 **JSONWEBTOKEN** 라이브러리 다운로드 하기 <br>
    -> **npm install jsonwebtoken --save**

### 4. Token을 쿠키에 저장한다.
 * express에서 제공하는 Cookie Parser를 사용하자! 
 * 설치 -> **npm install cookie-parser --save**

index.js

```js
const cookieParser = require("cookie-parser");

app.use(cookieParser());

app.post('/api/users/login', (req, res) => {
    // 로그인 시에 요청된 이메일을 데이터베이스에 있는지 찾는다.
    User.findOne({ email : req.body.email }, (err, user) => {
        if( !user ) {
            return res.json ({
                loginSuccess: false ,
                message : "제공된 이메일에 해당하는 유저가 없습니다."
            });
        }

        // 요청된 이메일이 데이터베이스에 있다면, 비밀번호가 맞는지 확인하기.
        user.comparePassword( req.body.password, (err, isMatch) => {
            if( !isMatch )
                return res.json({ loginSuccess : false , message : "비밀번호가 틀렸습니다."})

             // 비밀번호까지 맞다면 유저를 위한 토큰을 생성하기.    
            user.generateToken((err, user) => {
                if(err) return res.status(400).send(err)
                
                // 토큰을 저장한다. 어디에? 쿠키..? , 로컬 스토리지...? 일단은 쿠키에 저장하자!
                res.cookie("x_auth", user.token)
                .status(200) // 성공!
                .json({ loginSuccess : true , userId : user._id }) // json으로 데이터 보내주자.
 
            });
        });

    });
});

```


User.js

```js
const { JsonWebTokenError } = require('jsonwebtoken');
const jwt = require('jsonwebtoken');

userSchema.methods.comparePassword = function(plainPassword, cb) {
    // plainPassword : 1234567 암호화된 비밀번호 : $2b$10$ka0 ~~~
    // 평문을 암호화해서 db에 있는 비밀번호와 같은지 비교한다.
    
    bcrypt.compare(plainPassword, this.password , function(err, isMatch) {
        if(err) return cb(err);
        cb(null, isMatch); // 에러는 없고 비밀번호는 같다. isMatch는 True
    })
}



userSchema.methods.generateToken = function(cb) {
    var user = this;

    // jsonwebtoken을 이용해서 token을 생성하기
    var token = jwt.sign(user._id.toHexString(), 'secretToken')

    user.token = token 
    user.save(function(err, user) {
        if(err) return cb(err)
        cb(null, user) // save가 잘 됬으면 user 정보만 다시 전달해준다.
    })
}
```
