def solution(citations):
    answer = 0
    paper_count = len(citations)
    citations.sort(reverse=True)
    print(citations)
    for i in range(paper_count):
        if citations[i] >= i+1:
            answer += 1
    return answer