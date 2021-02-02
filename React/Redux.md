# Redux

### Redux란?
리덕스는 상태  관리 라이브러리

state container

React에서는
Props vs State

Props는 Property의 줄임말로
부모 컴포넌트가 있고 그 안에 자식 컴포넌트가 들어 있다.
컴포넌트 간의 뭔가 주고 받을때 Props를 이용해야한다
소통하는 방식이 부모에서 자식 컴포넌트로만 보낼수 있다.

Props는 immutable로 변하지 않는다.
부모컴포넌트에서 자식 컴포넌트로 1을 내려주면 1은 바뀔수없다.
1을 바꾸러면 다시 부모컴포넌트에서 내려줘야한다.

State는 부모 컴포넌트에서 자식 컴포넌트로 주는게 아니고
mutable로 컴포넌트 안에서 state 변하게 하는 것이 가능하다.
state가 변하면 re-render 된다.

Redux는 State를 관리해주는 라이브러리
![1](https://user-images.githubusercontent.com/43642411/106621806-4752e400-65b6-11eb-952d-d48a9adae43d.PNG)

Redux Data Flow

한 방향으로만 흐른다.
![2](https://user-images.githubusercontent.com/43642411/106621888-5d60a480-65b6-11eb-9707-5d56d156967f.PNG)

Action -> Reducer -> STORE -(Subscribe)-> React Component -(Dispatch(action)) -> Action

ACTION은 App에서 무엇이 일어났는지 설명하는 객체.
App의 Store, 즉 저장소로 data를 보내는 방법이다. 
ACTION을 호출하면 action creators는 App의 state(상태)를 변경해준다.

```js
function addTodo(text) {
  return {
    type : ADD_TODO,
    text
  }
}
```

Reducer는 ACTION을 통해 어떠한 행동을 정의했다면, 그 결과 App의 상태가 어떻게 바뀌는지 설명해주는 함수이다.
state는 2에서 3으로 변하고 3에서 4로 변하고 하는게 가능하다.
액션을 수행함으로인해 원래 3이였던 state가 액션을 통해 4로 변했다. 이런걸 설명해주는게 리듀서이다.
액션 오브젝트를 받은 후에 nextState를 return하는게 리듀서이다.

스토어는 전체적인 App의 state을 감싸주는 역할을 한다.
스토어안에는 많은 메소드들이 있어서 이를 이용해서 state를 관리할 수 있다.




그림자료 출처 [따라하며 배우는 노드, 리액트 시리즈 - 기본 강의](https://www.inflearn.com/course/%EB%94%B0%EB%9D%BC%ED%95%98%EB%A9%B0-%EB%B0%B0%EC%9A%B0%EB%8A%94-%EB%85%B8%EB%93%9C-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EA%B8%B0%EB%B3%B8/dashboard)
