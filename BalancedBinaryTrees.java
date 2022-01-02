package DynamicProgramming;

public class BalancedBinaryTrees {

    public static long countBalancedBTs(int h){
        if(h == 0 || h == 1){
            return 1;
        }
        long x = countBalancedBTs(h - 1);
        long y = countBalancedBTs(h - 2);

        return (x*x) + (2*x*y);
    }

    public static void main(String [] args){
        int h = 7;
        System.out.println(countBalancedBTs(h));
    }
}
