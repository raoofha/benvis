#include <stdio.h>

int partition(int* A ,int p, int r){
    int temp,i,j;
    j = p-1;
    for(i=p;i<r;i++){
        if( A[i] <= A[r] ){
            j += 1;
            temp = A[j];
            A[j] = A[i];
            A[i] = temp;
        }
    }
    temp = A[j+1];
    A[j+1] = A[r];
    A[r] = temp;
    return j+1;
}

void quicksort(int* A,int p ,int r){
    int q;
    if( p < r ){
        q = partition(A, p, r);
        quicksort(A,p,q-1);
        quicksort(A,q+1,r);
    }
}

int main(){
    int A[10] = { 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 };
    int i;
    quicksort(A,0, 9);
    for(i=0;i<10;i++){
        printf("%d\n",A[i]);
    }
}
