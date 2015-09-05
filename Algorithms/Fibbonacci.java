/*
 * fibonacci(0) = 0
 * fibonacci(1) = 1
 * For all n >= 2
 * fibonacci(n) = fibonacci(n - 1) + fibonacci(n - 2)
 */
 
class Fibbonacci{
    //recursive   time: O(2^n)
        public static int fib(int n){
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        return fib(n-1)+ fib(n-2);
    }

    //Iterative   time: O(n)  space: O(n)
    public static int iterativefib(int n){
        int[] res = new int[n+1];
        res[0]=0;
        res[1]=1;

        for(int i = 2; i<=n; i++){
            res[i]=res[i-1]+ res[i-2];
        }
        return res[n];
    }

    //Iterative   time: O(n)  space: O(1)
    public static int betterIterativeFib(int n){
        int a=0, b=1, c=0;
        if(n==0) return a;
        if(n==1) return b;

        for(int i = 2; i<=n; i++){
            c = a+b;
            a = b;
            b = c;
        }
        return c;
    }
}
 
 
