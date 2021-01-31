# React Router Dom


React에서는 페이지간 이동을 할때 React Router Dom이라는 것을 사용한다.

### 설치

**root에서 cd client**

```
npm install react-router-dom --save
```

#### App.js
```js

import LandingPage from './components/views/LandingPage/LandingPage'
import LoginPage from './components/views/LoginPage/LoginPage'
import RegisterPage from './components/views/RegisterPage/RegisterPage'

function App() {
  return (
    <Router>
      <div>
   
        {/*
          A <Switch> looks through all its children <Route>
          elements and renders the first one whose path
          matches the current URL. Use a <Switch> any time
          you have multiple routes, but you want only one
          of them to render at a time
        */}
        <Switch>
        
          <Route exact path="/" component={LandingPage} />
          <Route exact path="/login" component={LoginPage} />
          <Route exact path="/register" component={RegisterPage} />
 
        </Switch>
      </div>
    </Router>
  );
}
    
export default App;
  
```
