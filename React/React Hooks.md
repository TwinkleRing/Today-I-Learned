# Hooks
React Component에는 2가지 타입이 있다.

### 1. class Component
* Provide more features
* Longer Code
* More Complex Code
* Slower Performance

```js
import React, { Component } from 'react'

export default class Hello extends Component {
  render() {
    return (
      <div>
        hello my friends!
      </div>
     )
   }
}
```
### 2. Functional Component
* Provide less features
* Shoter Code
* Simpler Code
* Faster Perfomance


```js
import React from 'react'

export default function Hello() {
  return (
      <div>
        hello my friends!
      </div>
     )    
}
```

함수형 컴포넌트에서는 많은 기능을 사용하지 못한다.
그러나 React에서 Hooks 를 사용하여 함수형에서도 여러 기능을 지원받을 수 있다.

```js
import React, { useEffect, useState } from 'react'
import Axios from 'axios'

export default function Hello() {
  const [Name, setName] = useState("")
  
  useEffect(() => {
    Axios.get('/api/user/name')
      .then(response => {
        setName(response.data.name)
      })
    }, [])
    
    
    return (
      <div>
        My name is {Name}
      </div>
      
    )
}
```
