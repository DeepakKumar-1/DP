package DynamicProgramming;

public class MinSteps {
    // Subtract 1 from n
    // Divide by 2
    // Divide by 3
    public static int countSteps(int n){
        if(n == 1)
            return 0;
        int op1 = countSteps(n - 1);
        int minSteps = op1;
        if(n % 3 == 0){
            int op2 = countSteps(n / 3);
            if(minSteps > op2)
                minSteps = op2;
        }
        if(n % 2 == 0){
            int op3 = countSteps(n / 2);
            if(minSteps > op3)
                minSteps = op3;
        }
        return 1 + minSteps;
    }
    
    public static int minSteps(int n){
        int count = 0;
        return minSteps(n, count);
    }

    public static int minSteps(int n, int count){
        if(n == 1)
            return count;
        if(n % 3 == 0){
            count++;
            n /= 3;
        } else if(n % 2 == 0){
            count++;
            n /= 2;
        } else {
            count ++;
            n -= 1;
        }
        return minSteps(n, count);
    }

    public static int countStepsM(int n){
        // Storage Array of Unique n Calls
        int []storage = new int[n + 1];
        return countStepsM(n, storage);
    }

    public static int countStepsM(int n, int [] storage) {
        // Base Case
        if (n == 1) {
            storage[n] = 0;
            return storage[n];
        }
        if (storage[n] != 0) {
            return storage[n];
        }

        int op1 = countStepsM(n - 1, storage);
        int minSteps = op1;
        if (n % 3 == 0) {
            int op2 = countStepsM(n / 3, storage);
            if (minSteps > op2)
                minSteps = op2;
        }
        if (n % 2 == 0) {
            int op3 = countStepsM(n / 2, storage);
            if (minSteps > op3)
                minSteps = op3;
        }
        storage[n] = 1 + minSteps;
        return storage[n];
    }


    public static int countStepsDP(int n){
        int []storage = new int[n+1];
        storage[1] = 0;
        for(int i=2; i<=n; i++){
            int min = storage[i-1];
            if(i % 3 == 0){
                if(min > storage[i/3]);{
                    min = storage[i/3];
                }
            }
            if(i % 2 == 0){
                if(min > storage[i/2]);{
                    min = storage[i/2];
                }
            }
            storage[i] = 1 + min;
        }
        return storage[n];
    }

    public static void main(String [] args){
        System.out.println(minSteps(5));
        System.out.println(minSteps(30));
        System.out.println(countSteps(5));
        System.out.println(countSteps(30));
        System.out.println(countSteps(10));
        System.out.println(countStepsM(10));
        System.out.println(countStepsDP(10));
        System.out.println(countStepsDP(100));
    }
}
