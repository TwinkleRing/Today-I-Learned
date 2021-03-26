## Aggregation


### Revising Aggregations - The Count Function

```mysql
SELECT COUNT(ID)
FROM CITY
WHERE Population > 100000;
```

### Revising Aggregations - The Sum Function

```mysql
SELECT SUM(population)
FROM CITY
WHERE DISTRICT = 'California'
```

### Revising Aggregations - Averages

```mysql
SELECT AVG(population)
FROM CITY
WHERE DISTRICT = 'California'
```

### Average Population

```mysql
SELECT ROUND(AVG(POPULATION))
FROM CITY
```


### Japan Population

```mysql
SELECT SUM(POPULATION)
FROM CITY
WHERE COUNTRYCODE = 'JPN'
```

### Population Density Difference

```mysql
SELECT MAX(POPULATION) - MIN(POPULATION)
FROM CITY
```

### The Blunder

```mysql
SELECT CEILING(AVG(SALARY) - AVG(REPLACE(SALARY,'0','') )) 
FROM EMPLOYEES;
```
