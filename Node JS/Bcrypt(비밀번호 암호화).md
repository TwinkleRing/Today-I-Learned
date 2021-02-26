# Bcrypt로 비밀번호 암호화 하기

회원가입 페이지에서 정보를 입력하고 회원가입을 클릭하면 입력한 데이터가 데이터베이스에 저장된다.<br>
그러나 비밀번호를 평문으로 저장하면 보안성이 약하기 때문에 암호화를 하고 그 다음에 데이터베이스에 저장해야 한다.

## Bcrypt 사용하기

* 설치 : "npm install bcrypt --save"
* index.js의 register 라우터에서 save 하기전에 salt를 이용하여 비밀번호를 암호화 시켜야한다.


#### User.js 

```js

const bcrypt = require('bcrypt');
const saltRounds = 10; // 10자리 salt 

// 정보들을 유저 모델을 저장하기 전에 실행해줌.
userSchema.pre('save', function( next ) {
    var user = this; // userSchema를 가리키게 됨.
    // 모델의 필드 중에 비밀번호를 바꿀때만 다시 암호화 해야 하므로 조건을 걸어준다.

    if(user.isModified('password')) {
        // 비밀번호를 암호화 시킨다.
        bcrypt.genSalt(saltRounds, function (err, salt) { // salt 만들기 , 콜백펑션으로 에러가 나면 err 반환,  
            if (err) return next(err) ;
            
            // salt 제대로 생성하면
            bcrypt.hash( user.password , salt, function(err, hash)  { // 원래의 평문 비밀번호 가져오기 , hash가 암호화된 비밀번호.
                if(err) return next(err) ;
                user.password = hash // 평문 비밀번호를 hash된 비밀번호로 교체해주기.
                next();
                
            });
        });
    } else {
        next();
    }
    
});


```
