## 괄호 변환

def solution(p):
    answer = '' 
    if p == ''  : # 1.
        return ''
    
    u, v = p[ : divide(p)+1], p[divide(p)+1 : ] # 2.
    
    if check(u) : # 3. u가 "올바른 괄호 문자열" 이면?
        # v를 1단계부터 수행
        string = solution(v)
        return u + string

    else : # 4. 문자열 u가 "올바른 괄호 문자열" 이 아니라면?
        tmp = '(' # 4-1 
        tmp += solution(v)
        tmp += ')'
        u = list(u[1 : -1])
        for i in range(len(u)) :
            if u[i] == '(' :
                u[i] = ')'
            elif u[i] == ')' :
                u[i] = '('
        tmp += ''.join(u)

    return tmp

    
def divide(w) : # 두 "균형잡힌 괄호 문자열" u, v로 분리
        num = 0
        temp = []
        for idx , value in enumerate(w) :
            if value == ')' :
                num -= 1
            if value == '(' :
                num += 1
            if num == 0 :
                return idx  
    

def check(ss) : # 올바른 괄호인지 체크
        stack = []
        for s in ss :
            if s == '('  :
                stack.append(s)
            elif s == ')' and stack :
                if stack[-1] == '(' :
                    stack.pop()
                else :
                    stack.append(s)
            else :
                stack.append(s)
    
        if stack :
            return False
        else :
            return True
