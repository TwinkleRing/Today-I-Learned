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

### 1. 최댓값 구하기
```mysql
SELECT MAX(DATETIME) 
FROM ANIMAL_INS;
```

### 2. 최솟값 구하기
```mysql
SELECT MIN(DATETIME) 
FROM ANIMAL_INS;
```

### 3. 동물 수 구하기
```mysql
SELECT COUNT(*)
FROM ANIMAL_INS;
```

### 4. 중복 제거하기
```mysql
SELECT COUNT(DISTINCT NAME) AS 'COUNT'
FROM ANIMAL_INS
WHERE NAME IS NOT NULL;

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

### 3. NULL 처리하기
```mysql
SELECT ANIMAL_TYPE,IFNULL(NAME, "No name"), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;
```


## GROUP BY

### 1. 동명 동물 수 찾기
```mysql
SELECT NAME, COUNT(NAME) AS 'COUNT'
FROM ANIMAL_INS
GROUP BY NAME
HAVING COUNT(NAME) > 1
ORDER BY NAME

```
### 2. 고양이와 개는 몇마리 있을까
```mysql
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) AS 'COUNT'
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;
```

### 3. 입양 시각 구하기 1
```mysql
SELECT HOUR(DATETIME) AS 'HOUR', COUNT(DATETIME) AS 'COUNT'
FROM ANIMAL_OUTS
GROUP BY HOUR(DATETIME)
HAVING HOUR >= 9 AND HOUR <= 19
ORDER BY HOUR(DATETIME);
```

## STRING, DATE

### 1. 루시와 엘라 찾기
```mysql
SELECT ANIMAL_ID, NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
#WHERE NAME = "LUCY" OR NAME = "ELLA" OR NAME = "PICKLE" OR NAME = "ROGAN" OR NAME = "SABRINA" OR NAME = "MITTY"
WHERE NAME IN ('LUCY','ELLA','PICKLE','ROGAN','SABRINA','MITTY')
ORDER BY ANIMAL_ID;

```

### 2. 이름에 EL이 들어가는 동물 찾기
```mysql
SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS
WHERE ANIMAL_TYPE = "DOG" AND NAME LIKE "%EL%"
ORDER BY NAME
```

### 3. 중성화 여부 파악하기

```mysql
SELECT ANIMAL_ID, NAME, IF ((SEX_UPON_INTAKE LIKE '%Neutered%') OR (SEX_UPON_INTAKE LIKE '%Spayed%'), 'O','X') as "중성화"
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC

```
