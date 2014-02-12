import java.util.ArrayList;
import java.util.LinkedList;


public class LongestNDSS
{
    public static int longestNDSS(int [] a) {
        
        int i, j;
        int[] L = new int[a.length];
        ArrayList<LinkedList<Integer>> paths = new ArrayList<LinkedList<Integer>>(a.length);
        
        for(i=0; i<a.length; i++) {
            paths.add (new LinkedList<Integer>());
            paths.get (i).add (a[i]);
        }
        
        for(i=0; i<a.length; i++) {
            L[i] = 1;
            for(j=0; j<i; j++) {
                if (a[j] <= a[i] && L[j]+1 > L[i]) {
                    L[i] = L[j] + 1;
                    paths.set (i, (LinkedList<Integer>)(paths.get (j).clone ()));
                    paths.get (i).add (a[i]);
                       
                }
            }
        }
        
        int max = 0, max_index = 0;
        
        for(i=0; i<L.length; i++) {
            if (L[i] > max) {
                max = L[i];
                max_index = i;
            }
        }
        System.out.println("Subsequence is "+paths.get (max_index) +".");
        return max;
    }
    
    
    public static void main(String[] args) {
        int[] a = {8, 1, 3, 1, 5};
        System.out.println("Max Length is " + longestNDSS(a) + ".");
    }
}
