# React js
> **2013년에 페이스북에서 발표한 javascript 프론트엔드 라이브러리**

## 특징 
* 컴포넌트 
컴포넌트 기반으로 컴포넌트화, 모듈화를 통해 재사용성과 유지 보수성이 굉장히 뛰어나다. <br>
(컴포넌트는 UI를 구성하는 개별적인 뷰 단위)

* Virtual DOM 
Real DOM에서 만약 10개의 아이템이 있다면 어떤 한 아이템에만 변화가 일어났을 때,<br>
Real DOM은 전체 10개를 전부 다시 Load 해야한다.<br>
그런데 Virtual DOM에서는 하나가 업데이트 됬으니 이 변경된 아이템만 Real DOM에서 바꿔준다.<br>
따라서 훨씬 빠르고 부하가 적은 방식으로 업데이트가 가능하다.

#### 어떻게 변경된 부분만 변경이 가능하지?
Virtual DOM과 Real DOM은 갖고 있는 Property는 같다!<br>
어떻게 변경된 아이템만 찾아서 바꿀수 있지?<br>

Virtual DOM에서 10개의 아이템의 스냅샷을 먼저 찍어 놓는다. <br>
그리고 하나의 아이템가 업데이트되면 Virtual DO에서 하나 하나 다 살펴보고<br>
스냅샷 찍어둔 부분과의 차이를 분석해서 변경된 부분만 Real DOM에서 업데이트 시켜준다.


### Babel 
* ##### 최신 javascript 문법을 지원하지않는 브라우저를 위해 최신 javascript 문법을 구형 브라우저에서도 동작할 수 있게 변환시켜주는 도구


### 설치 방법

```
npx create-react-app .
```

### react 기본 구조 설명

client - index.js
```js
ReactDOM.render(<App />, document.getElementById('root));
```

public - index.html

```html
<div id="root"></div>
```



### CRA To Our Boiler Plate  ( Boiler Plate를 위한 구조 설정하기 )

src 
  * _actions -> Redux를 위한 폴더들
  * _reducers -> Redux를 위한 폴더들
  * components 
        * views -> 이 안에는 Page들을 넣는다.
          * Sections -> 이 안에는 해당 페이지에 관련된 css 파일이나, component 들을 넣는다.
        App.js -> Routing 관련 일을 처리한다.
        Config.js -> 환경 변수 설정하는 곳
  * hoc -> Higher Order Component
  * utils -> 여러 군데에서 쓰일 수 있는 것들을 넣어둬서 어디서든 쓸수 있게 해둔다.
