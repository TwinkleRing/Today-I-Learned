def solution(N, stages):
    fail = {}
    clear = len(stages)
    
    for stage in range(1, N + 1) :
        if clear != 0 :
            count = stages.count(stage)
            fail[stage] = count / clear
            clear -= count
        else :
            fail[stage] = 0


    return sorted(fail, key = lambda x : fail[x], reverse = True)


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
