# BodyParser & PostMan

### BodyParser 


브라우저(클라이언트)에서 회원가입을 할 때 아이디, 비밀번호 등을 입력하고 서버에 보내야한다. <br>
서버는 클라이언트(브라우저)에서 입력한 데이터들을 받아서 처리해야하는데 받을 때 **BodyParser** 를 이용해서 받는다.

```
npm install body-parser --save 
```

### PostMan 

Client에서 Request를 서버에 보냈을 때 제대로 처리되는지 확인해야한다.
API Test Tool인 PostMan을 사용하여 제대로 서버에 요청이 가는지 확인할 수 있다.

1. 회원가입(Register) Route 만들기

#### Server - index.js
```js
기존 코드 ~~
const bodyParser = require("body-parser");
const { User }  = require("./models/User");

// application/x-www-form-urlencoded 가져와서 분석할수 가져올 수 있게
app.use(bodyParser.urlencoded({extended: true})); 
// application/json 가져오기
app.use(bodyParser.json());

// 회원가입을 위한 route
app.post('/api/users/register', (req, res) => {
    
    // 회원 가입 할때 필요한 정보들을 client에서 가져오면 
    // 그것들을 데이터베이스에 넣어준다.
    //bodyparser로 client에서 보내주는 정보를 받는다.

    const user = new User(req.body) // UserModel 사용, body 안에 user 정보들이 들어있다.

    // mongoDB 메서드
    user.save((err, userInfo) => { // save 해주면 받아온 정보들이 user Model에 저장된다.
        if (err) return res.json({ success : false ,  err })
        return res.status(200).json({
            success : true // 성공
        }) 
    })
})

```


#### PostMan 사용하기 


1. POST로 request 보내기. <br>
![request](https://user-images.githubusercontent.com/43642411/106020707-66113080-6107-11eb-9a96-772d6bb990d0.PNG)

2. 결과 확인 <br>
![성공](https://user-images.githubusercontent.com/43642411/106020795-76c1a680-6107-11eb-9456-ea152c6ef731.PNG)
