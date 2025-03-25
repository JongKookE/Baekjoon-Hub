def solution(id_list, report, k):
    s1 = [s.split()[1] for s in set(report)]
    s2 = [s for s in set(s1) if s1.count(s) >= k]
    s3 = [s.split()[0] for s in set(report) if s.split()[1] in s2]
    return [s3.count(i) for i in id_list]