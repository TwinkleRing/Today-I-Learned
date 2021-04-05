# 2021-04-05 Advanced Select

## [Type of Triangle](https://www.hackerrank.com/challenges/what-type-of-triangle/problem)

### CASE 문 사용법
```mysql
CASE 
  WHEN 조건1 THEN 결과값1 
  WHEN 조건2 THEN 결과값2 
  WHEN 조건N THEN 결과값N 
  ELSE 결과값 
END


```
### 정답 
```mysql
SELECT 
    CASE
        WHEN A + B > C AND A + C > B AND B + C > A THEN 
            CASE
                WHEN A = B AND B = C THEN 'Equilateral'
                WHEN A = B OR A = C OR B = C THEN 'Isosceles'
                ELSE 'Scalene' 
            END
        ELSE 'Not A Triangle' 
     END
FROM TRIANGLES
        
```
