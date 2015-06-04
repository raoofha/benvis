public class insertionsort {
    public static void insertionsort(int[] A){
        int i,j,key;
        for(i=1;i<A.length;i++){
            key = A[i];
            j = i-1;
            while( j >= 0 && A[j] > key ){
                A[j+1] = A[j];
                j = j - 1;
            }
            A[j+1] = key;
        }
    }
    public static void main(String[] args){
        int[] A = new int[]{ 23, 24, 52, 69, 1, 193, 34, 95, 3, 910 };
        int i;
        insertionsort(A);
        for(i=0;i<A.length;i++){
            System.out.println(A[i]);
        }
    }
}
