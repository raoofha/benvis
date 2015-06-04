import sys

def merge(A, p, q, r):
    n1 = q-p+1
    n2 = r-q
    L = []
    R = []
    for i in range(0,n1):
        L.append(A[p+i])
    for i in range(0,n2):
        R.append(A[q+1+i])
    L.append(sys.maxsize)
    R.append(sys.maxsize)
    i = j = 0
    for k in range(p,r+1):
        if L[i] < R[j] :
            A[k] = L[i]
            i += 1
        else:
            A[k] = R[j]
            j += 1

def mergesort(A, p, r):
    if p < r :
        q = (p+r)/2
        mergesort(A, p, q)
        mergesort(A, q+1, r)
        merge(A, p, q, r)


A = [ 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 ]
mergesort(A, 0 , len(A)-1)
for i in range(0,len(A)):
    print(A[i])
