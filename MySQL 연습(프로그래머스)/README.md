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


## SUM, MAX, MIN

### 2. 최댓값 구하기
```mysql
SELECT MAX(DATETIME) FROM ANIMAL_INS;
```
