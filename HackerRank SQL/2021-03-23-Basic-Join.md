## Basic Join (Easy)

### Asian Population

```mysql
SELECT SUM(C.POPULATION)
FROM CITY C LEFT JOIN COUNTRY T ON C.COUNTRYCODE = T.CODE
WHERE T.CONTINENT = 'ASIA';
```


### African Cities

```mysql
SELECT C.NAME
FROM CITY C LEFT JOIN COUNTRY T ON C.COUNTRYCODE = T.CODE
WHERE T.CONTINENT = 'AFRICA';
```

### Average Population of Each Continent

```mysql
SELECT T.CONTINENT, FLOOR(AVG(C.POPULATION))
FROM COUNTRY T JOIN CITY C ON C.COUNTRYCODE = T.CODE
GROUP BY T.CONTINENT
```
