# Redux

### Redux란?
* 리덕스는 State를 더 효율적으로 관리하는 데 사용하는 상태 관리 라이브러리이다.
* 상태 관리의 로직을 컴포넌트 밖에서 처리한다.
* 리덕스를 사용하면 스토어라는 개체 내부에 상태를 담고 사용하게 된다.

state container


### Props vs State
Props와 State는 React에서 데이터를 사용할 때 다루는 개념이다.

#### Props
* Props는 부모 컴포넌트가 자식 컴포넌트에게 주는 값이다.
* Props는 immutable로 변하지 않는다.
* 읽기 전용으로 만약 부모 컴포넌트에서 자식 컴포넌트로 1을 내려주면 1은 바뀔수 없는 값이다.
* 1을 바꾸려면 다시 부모 컴포넌트에서 값을 내려줘야한다.

#### State
* State는 mutable로 컴포넌트 안에서 State를 변하게 하는 것이 가능하다.
* 또한 State가 변하면 Re-render 된다.

그래서 Redux는 이 State를 관리해주는 라이브러리이다.

![1](https://user-images.githubusercontent.com/43642411/106621806-4752e400-65b6-11eb-952d-d48a9adae43d.PNG)


Redux Data Flow

한 방향으로만 흐른다.

![2](https://user-images.githubusercontent.com/43642411/106621888-5d60a480-65b6-11eb-9707-5d56d156967f.PNG)



ACTION은 App에서 무엇이 일어났는지 설명하는 객체이다.<br>
App의 Store, 즉 저장소로 data를 보내는 방법이다. <br>
ACTION을 호출하면 action Creators는 App의 state(상태)를 변경해준다.

```js
function addTodo(text) {
  return {
    type : ADD_TODO,
    text
  }
}
```
![1](https://user-images.githubusercontent.com/43642411/106702349-9129e180-662b-11eb-8778-5594ab2e8550.PNG)

Reducer는 ACTION을 통해 어떠한 행동을 정의했다면, 그 결과 App의 상태가 어떻게 바뀌는지 그 로직이 있는 함수이다.<br>
state는 2에서 3으로 변하고 3에서 4로 변하고 하는게 가능하다.<br>
액션을 수행함으로인해 원래 3이였던 state가 액션을 통해 4로 변했다. 이런걸 설명해주는게 Reducer이다.<br>
액션 오브젝트를 받은 후에 nextState를 return하는게 Reducer이다.

Store는 전체적인 애플리케이션의 state 값들을 내장하는 역할을 한다.<br>
Store 안에는 많은 메소드들이 있어서 이를 이용해서 State를 관리할 수 있다.<br>
Reducer에 의해서만 State 값이 변경된다.

Dispatch(디스패치)는 액션을 스토어에 전달하는 것을 의미한다.<br>

Subscribe(구독)은 Store 값이 필요한 컴포넌트는 Store를 구독한다.




>그림자료 출처 [따라하며 배우는 노드, 리액트 시리즈 - 기본 강의](https://www.inflearn.com/course/%EB%94%B0%EB%9D%BC%ED%95%98%EB%A9%B0-%EB%B0%B0%EC%9A%B0%EB%8A%94-%EB%85%B8%EB%93%9C-%EB%A6%AC%EC%95%A1%ED%8A%B8-%EA%B8%B0%EB%B3%B8/dashboard)
