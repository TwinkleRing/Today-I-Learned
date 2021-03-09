def solution(numbers, hand) :
    answer = ""
    key_pad = { 1 : (0,0), 2 : (0,1), 3 : (0,2),
                4 : (1,0), 5 : (1,1), 6 :(1,2),
                7 : (2,0), 8 : (2,1), 9 : (2,2),
                '*' : (3,0), 0 : (3,1), '#' :(3,2) }

    lhand = "*"
    rhand = "#"

    left = [1, 4, 7]
    right = [3, 6, 9]

    for i in numbers :
        if i in left :
            answer += 'L'
            lhand = i
        elif i in right :
            answer += 'R'
            rhand = i
        else :
            curPos = key_pad[i]
            right_pos = key_pad[rhand]
            left_pos = key_pad[lhand]

            ldist = abs(curPos[0] - left_pos[0]) + abs(curPos[1] - left_pos[1])
            rdist = abs(curPos[0] - right_pos[0]) + abs(curPos[1] - right_pos[1])

            if ldist > rdist :
                answer += 'R'
                rhand = i
            elif rdist > ldist :
                answer += 'L'
                lhand = i
            else :
                if hand == "right" :
                    answer += 'R'
                    rhand = i
                else :
                    answer += 'L'
                    lhand = i

    return answer 

print(solution([1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5], "right"))