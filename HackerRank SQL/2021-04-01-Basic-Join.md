## Basic Join

### [Top Competitors](https://www.hackerrank.com/challenges/full-score/problem?isFullScreen=true)

### Table 설명
* Hackers : 전체 hacker들의 정보
* Difficulty : 문제의 난이도 별 Full score 정보
* Challenges : 문제와, 문제를 제작한 Hacker 정보, 문제의 난이도 정보
* Submissions : 문제를 제출한 사람의 정보와 제출 시 score 

### 문제 설명
* 코딩테스트 제출자 중 full score를 맞은 문제가 한개보다 많은 (2개 이상)인 참가자의 hacker_id와, name을 뽑아라.

### 문제 풀이

1. Submissions table를 기준으로 필요한 정보를 담고 있는 다른 테이블들을 Join한다.
    * 제출한 문제의 ful score를 알기 위해 Difficulty 테이블의 score 정보가 필요하다.
    * Difficulty level 정보가 있어야 full score를 연결 할 수 있고, 그 정보는 Challenges 테이블에 있다.
    * Hacker의 이름을 출력하기 위해 Hackers 테이블이 필요.

2. full score인 컬럼만 뽑아내기
    * Difficulty 테이블이 fullscore 정보를 가지는데, 제출한 score가 동일하다면 Full score이다.

3. hacker_id 별 full score 맞은 문제 개수를 count하고, 2개 이상 푼 사람만 추출하기
    * group by로 hacker_id, name으로 묶어준 뒤, count(challenge_id) > 1 인 컬럼만 뽑아낸다.



### 정답 SQL

```mysql
SELECT s.hacker_id, h.name
FROM Submissions s
    INNER JOIN Challenges c ON s.challenge_id = c.challenge_id
    INNER JOIN Difficulty d ON c.difficulty_level = d.difficulty_level
    INNER JOIN Hackers h ON s.hacker_id = h.hacker_id
WHERE d.score = s.score 
GROUP BY s.hacker_id, h.name
HAVING count(s.hacker_id) > 1
ORDER BY count(s.hacker_id) DESC, s.hacker_id
```
