package Lesson5;

public class RecDegree {
    public static void main(String[] args) {

        System.out.println(recDegree(2, 5));

    }

    private static int recDegree(int x, int n){
        if (n<0){
            throw new IllegalArgumentException();
        }
        if(n == 0){
            return 1;
        }else if (n ==1){
            return x;
        }else {
        return  recDegree(x, n-1)*x;
        }
    }
}
