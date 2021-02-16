# Solution

## SELECT 문
### 1. 모든 레코드 조회하기
```mysql
SELECT * FROM ANIMAL_INS;
```
### 2. 역순 정렬하기
```mysql
SELECT NAME, DATETIME FROM ANIMAL_INS ORDER BY ANIMAL_ID DESC
```
### 3. 아픈 동물 찾기
```mysql
SELECT ANIMAL_ID, NAME 
from ANIMAL_INS 
where INTAKE_CONDITION = "SICK";
```
### 4. 어린 동물 찾기
```mysql
SELECT ANIMAL_ID, NAME 
from ANIMAL_INS 
WHERE INTAKE_CONDITION != 'aged'
```
### 5. 동물의 아이디와 이름
```mysql
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS ORDER BY ANIMAL_ID;
```
### 6. 여러 기준으로 정렬하기.
```mysql
SELECT ANIMAL_ID, NAME, DATETIME
FROM ANIMAL_INS 
ORDER BY NAME ASC, DATETIME DESC;
```

### 7. 상위 N개 레코드
```mysql
SELECT NAME 
FROM ANIMAL_INS 
ORDER BY DATETIME 
LIMIT 1;
```

## SUM, MAX, MIN

### 2. 최댓값 구하기
```mysql
SELECT MAX(DATETIME) FROM ANIMAL_INS;
```


## IS NULL

### 1. 이름이 없는 동물의 아이디
```mysql
SELECT ANIMAL_ID 
FROM ANIMAL_INS 
WHERE NAME IS NULL;
```

### 2. 이름이 있는 동물의 아이디
```mysql
SELECT ANIMAL_ID 
FROM ANIMAL_INS 
WHERE NAME IS NOT NULL;
```
