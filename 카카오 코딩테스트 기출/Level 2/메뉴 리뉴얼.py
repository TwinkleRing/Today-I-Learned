from collections import Counter
from itertools import combinations as cb

def solution(orders, course) :
    answer = []
    
    for c in course :
        array = []

        for order in orders :
            combi = list(cb(sorted(order), c))
            array += combi
        
        count_list = Counter(array)
        if len(count_list) > 1 and max(count_list.values()) > 1 :
            for count in count_list :
                if count_list[count] == max(count_list.values()) :
                    answer.append("".join(count))

    return sorted(answer)

print(solution(["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"],[2,3,4]))
# print(solution(["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"],[2,3,5]))