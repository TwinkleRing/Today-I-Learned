# Auth(HOC)

HOC는 higher-order component
다른 컴포넌트를 받은 다음에 새로운 컴포넌트를 return하는 function이다.

```js
const EnhancedComponent = higherOrderComponent(WrappedComponent);
```

Auth(HOC) 컴포넌트에 다른 컴포넌트(Landing, Login, Register)를 넣어주면

Auth라는 HOC 컴포넌트가 BackEnd에 Request를 날린다.
현재 랜딩페이지에 들어와있는 유저의 상태 정보를 가져온다.
이 유저가 로그인되어있는지, admin이 있는 유저인지 자격을 체크한다.
자격이 있는지 체크하고 권한이 없는 유저면 못들어오게 다른 페이지로 보낸다.


hoc - auth.js
```js
import React, {useEffect} from 'react';
import Axios from 'axios';
import { useDispatch } from 'react-redux';
import { auth } from '../_actions/user_action';

export default function (SpecificComponent,  option, adminRoute = null) { 

    // option의 종류
    // null : 아무나 출입이 가능한 페이지
    // true : 로그인한 유저만 출입이 가능한 페이지
    // false : 로그인한 유저는 출입 불가능한 페이지.

    // adminRoute는 어드민 유저만 접근 가능하게 할거면 true를 넣어준다.
    
    function AuthenticationCheck(props) {
        const dispatch = useDispatch();
        // 1. Backend의 auth Api에 요청을 날려서 현재 User의 상태를 가져온다.
        useEffect(() => {
                
            dispatch(auth()).then(response => { // Redux 사용. , ACTION은 auth()
                console.log(response)
                //로그인 하지 않은 상태 
                if (!response.payload.isAuth) {
                    if (option) {
                        props.history.push('/login')
                    }
                } else {
                    //로그인 한 상태 
                    if (adminRoute && !response.payload.isAdmin) {
                        props.history.push('/')
                    } else {
                        if (option === false)
                            props.history.push('/')
                    }
                }
            })
        }, [])

        return (
            <SpecificComponent />
        ) 
    }
    return AuthenticationCheck
}


```
_action - user_action.js
```js
export function auth() {
    const request = axios.get('/api/users/auth')
        .then(response => response.data)

    return {
        type: AUTH_USER,
        payload: request
    }    
}
```


App.js
```js
import Auth from './hoc/auth'

function App() {
  return (
    <Router>
      <div>
        <Switch>
          <Route exact path="/" component={Auth(LandingPage, null )  } /> // hoc로 감싸주기.
          <Route exact path="/login" component={Auth(LoginPage, false) } />
          <Route exact path="/register" component={Auth(RegisterPage, false)} />
        </Switch>
      </div>
    </Router>
  );
}
```

_reducers - user_reducer.js
```js
import {
    LOGIN_USER,
    REGISTER_USER,
    AUTH_USER
} from '../_actions/types';

export default function (state = {}, action) { // 이전 State와 ACTION 조합하기.
    switch (action.type) {  
        case AUTH_USER :
            return { ...state, userData : action.payload } // backend의 auth api에서 유저의 모든 정보를 보내준다.
            break;    

        default :
            return state;
    }
}
```
