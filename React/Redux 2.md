# Redux 2

## Redux Middleware 설치
1. cd client
2. npm install redux react-redux redux-promise redux-thunk --save

### Redux 연결하기

Redux의 Store에서는 언제나 객체 형식의 액션을 받는 것이 아니라 Promise이나 Function 형식으로 받을 수도 있다.<br>
위에 설치한 2개의 미들웨어가 function과 promise가 왔을 때 디스패치한테 받는 방법, 대처 방법을 알려주는 것이다.<br>
이 미들웨어를 사용하여 리덕스를 더 잘 사용할 수 있게한다.

index.js
```js
import { Provider } from 'react-redux';
import { applyMiddleware, createStore } from 'redux';

import promiseMiddleware from 'redux-promise;
import ReduxThunk from 'redux-thunk;
import Reducer from './_reducers';

const createStoreWithMiddleware = applyMiddleware(promiseMiddleware, ReduxThunk)(createStore)

ReactDOM.render(
  
    <Provider
      store={createStoreWithMiddleware(Reducer,
         window.__REDUX_DEVTOOLS_eXTENSION__ && // chrome web store에서 Redux extensions 설치
         window.__REDUX_DEVTOOLS_eXTENSION__()
        )}
    >
      <App />
    </Provider>
    
  , document.getElementById('root')
);

```

_reducers - index.js
Store와 함께 Reducer가 여러 가지 있고,<br>
Reducer는 어떻게 State가 변하는지 보여주고 변경된 State의 마지막 값을 return 해주는게 Reducer이다.<br>
어플리케이션에서 회원이나 댓글 등 여러 기능마다 각 State가 있으므로 Reducer도 다수 존재한다.<br>
이 Reducer들을 **combineReducers**를 사용하여 ROOT REDUCER에서 하나로 합쳐준다.
```js
import { combineReducers } from 'redux';

const rootReducer = combineReducers({
 
})

export default rootReducer;

```
