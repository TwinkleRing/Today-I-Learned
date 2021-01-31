# React js
> **2013년에 페이스북에서 발표한 javascript 프론트엔드 라이브러리**
https://www.google.co.kr/url?sa=i&url=https%3A%2F%2Fjeonghwan-kim.github.io%2F2018%2F07%2F16%2Freact-app-overview.html&psig=AOvVaw335Bd8qpiNKP1TCu6N07qJ&ust=1612163925759000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCNjzqOLQxe4CFQAAAAAdAAAAABAO

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