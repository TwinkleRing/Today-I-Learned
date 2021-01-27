# Nodemon


## 1. nodemon이란?

Node 서버에서 코드에 수정이 생기면 서버를 내리고 다시 구동해야 바뀐 소스 코드가 반영된다.
Nodemon을 사용하면 서버 내리고 올리지 않아도 변화된 부분을 감지하여 반영시켜준다.
즉, 프로젝트 폴더의 파일들을 모니터링 하고 있다가 파일이 수정되면 서버를 자동으로 restart 시켜주는 패키지이다.

## 2. 설치하기

```
npm install nodemon --save-dev
```

* -dev 붙이면 로컬에서만 사용하겠다는 의미이다.


## 3. 실행하기

서버를 실행할 때 **nodemon** 으로 시작하기 위해 package.json - scripts 수정하기 => "backend" : "nodemon index.js"
서버 실행 => npm run backend

