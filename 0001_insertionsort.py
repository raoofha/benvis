def insertionsort(A):
    for i in range(1,len(A)):
        key = A[i]
        j = i - 1
        while j >= 0 and A[j] > key :
            A[j+1] = A[j]
            j = j - 1
        A[j+1] = key


A = [ 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 ]
insertionsort(A)
for i in range(0,len(A)):
    print(A[i])
