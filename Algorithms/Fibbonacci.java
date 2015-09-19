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


    //log n
    //We all know the Fibonacci recurrence as F(n+1) = F(n) + F(n-1) 
    // but we can represent this in the form a matrix as shown below:
    //   | 1 1| |f(n)  |    | f(n+1)|
    //   |    | |      | =  |       | 
    //   | 1 0| |f(n-1)|    | f(n)  |

    // Look at the matrix A = [ [ 1 1 ] [ 1 0 ] ] . 
    //Multiplying A with [ F(n) F(n-1) ] gives us [ F(n+1) F(n) ] , 
    // so we say that

    // A* [ F(n) F(n-1) ] = [ F(n+1) F(n) ]

    //start with [ F(1) F(0) ] , multiplying it with A gives us [ F(2) F(1) ]; 
    //again multiplying [ F(2) F(1) ] with A gives us [ F(3) F(2) ] and so on...

    // A* [ F(1) F(0) ] = [ F(2) F(1) ]
    // A* [ F(2) F(1) ] = [ F(3) F(2) ] = A^2 * [ F(1) F(0) ]
    // A* [ F(3) F(2) ] = [ F(4) F(3) ] = A^3 * [ F(1) F(0) ]
    // ..
    // ..
    // ..
    // ..
    // A* [ F(n) F(n-1) ] = [ F(n+1) F(n) ] = A^n * [ F(1) F(0) ]

    // So all that is left is finding the nth power of the matrix A. 
    // Well, this can be computed in O(log n) time, by recursive doubling. 
    // The idea is, to find A^n , we can do R = A^(n/2) * A^(n/2) and if n is odd, 
    // we need do multiply with an A at the end. 

    public static int getNthfibo(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The fibo value cannot be negative");
        }

        if (n <= 1) return n;

        int[][] result = {{1, 0}, {0, 1}}; // identity matrix.
        int[][] fiboM = {{1, 1}, {1, 0}};

        while (n > 0) {
            if (n%2 == 1) {
                multMatrix(result, fiboM);
            }
            n = n / 2;
            multMatrix(fiboM, fiboM);
        }

        return result[1][0];
    }

    private static void multMatrix(int[][] m, int [][] n) {
        int a = m[0][0] * n[0][0] +  m[0][1] * n[1][0];
        int b = m[0][0] * n[0][1] +  m[0][1] * n[1][1];
        int c = m[1][0] * n[0][0] +  m[1][1] * n[0][1];
        int d = m[1][0] * n[0][1] +  m[1][1] * n[1][1];

        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c;
        m[1][1] = d;
    }
}
 
 
