# Concurrently
>Concurrently 라이브러리를 이용해서 프론트, 백엔드 서버 한번에 켜기


### 설치
* root - npm install concurrently --save

### 사용법
root - package.json 

```json
"scripts": {
    "start": "node index.js",
    "backend": "nodemon server/index.js",
    "test": "echo \"Error: no test specified\" && exit 1",
    "dev" : "concurrently \"npm run backend\" \"npm run start --prefix client\""
  },
```
