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



