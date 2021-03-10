def solution(new_id) :
    answer = ""
    new_id = new_id.lower()
    for word in new_id :
        if word.isalnum() or word in '-_.' :
            answer += word

    while True :
        if '..' in answer :
            answer = answer.replace(".." , ".")
        else :
            break

    if answer[0] == "." and len(answer) > 1 :
        answer = answer[1:]
    
    if answer[-1] == "." :
        answer = answer[:-1]

    if len(answer) == 0 :
        answer = "a"
    
    if len(answer) >= 16 :
        answer = answer[:15]
        if answer[-1] == "." :
            answer = answer[:-1]

    if len(answer) <= 2 :
        temp = answer[-1]
        while len(answer) < 3 :
            answer += temp

    return answer
print(solution("=.="))
