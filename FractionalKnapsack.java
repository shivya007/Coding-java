import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void FKSol(int[] wt, int[] price, int maxWt){
        double ratio[][] = new double[price.length][2];

        for(int i = 0; i < ratio.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = price[i] / (double) wt[i];
        }
        // Sort the ratio array
        Arrays.sort(ratio, Comparator.comparingDouble((double[] o) -> o[1]).reversed());

        int maxPrice = 0;
        for(int i = 0; i < ratio.length; i++){
            if (maxWt >= wt[i]){
                maxPrice += price[i];
                maxWt -= wt[i];
            }
            else {
                // unit quantity can't be taken, so take the proportional quantity
                maxPrice += (ratio[i][1] * maxWt);
                maxWt = 0;
            }
        }
        System.out.println("Final price is: " + maxPrice);
    }
    public static void main(String[] args) {
        int wt[] = {10, 20, 30};
        int price[] = {60, 100, 120};
        int maxWt = 50;
        FKSol(wt, price, maxWt);

    }
}
