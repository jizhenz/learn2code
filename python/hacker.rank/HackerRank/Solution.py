__author__ = 'jizhen'

def has_dup(mat, d):
    H=len(mat)
    L=len(mat[0])
    for i in range(H):
        for j in range(L):
            dup = []
            for k in range(d):
                if i+k < H:
                    for l in range(d-k):
                        if j+l < L:
                            if mat[i+k][j+l] in dup:
                                return 'YES'
                            else:
                                if mat[i+k][j+l] not in dup:
                                    dup.append(mat[i+k][j+l])
    return 'NO'

mat = [
    [1,2,3],
    [4,5,6],
    [7,8,9],
    [10,11,12],
    [5,8,9]
]
print has_dup(mat, 3)