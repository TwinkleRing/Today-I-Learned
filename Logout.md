# Logout

## 로그아웃 Route 만들기

로그아웃 하려는 유저를 데이터베이스에서 찾아서 그 유저의 토큰을 지워준다. <br>
토큰이 데이터베이스에 없으면 클라이언트에 가져온 토큰이 맞지 않아서 인증이 안된다. <br>
로그아웃할때 토큰을 지워주면 로그인 기능이 풀려버린다. <br>
그래서 데이터베이스에서 유저의 토큰을 지워주면 된다. 

index.js
```js
app.get('/api/users/logout', auth, (req, res) => {

    User.findOneAndUpdate({ _id : req.user._id }, { token : "" }, (err, user) => {
        if (err) return res.json({ success : false , err });
        return res.status(200).send({
            success : true
        })
    })
})

````
