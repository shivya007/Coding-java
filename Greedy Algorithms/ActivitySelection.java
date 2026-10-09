import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {

    /*
     * Activity Selection using Greedy Approach
     *
     * Approach:
     * 1. Sort activities according to their end time.
     * 2. Select the activity whose start time is greater than
     *    or equal to the end time of the previously selected activity.
     */

    // Approach 1:
    // Works when activities are already sorted according to end time.
    public static void ASSol(int[] start, int[] end) {

        int result = 1;
        int prevActEnd = end[0];

        for (int i = 1; i < start.length; i++) {

            int currActStart = start[i];
            int currActEnd = end[i];

            // Select the activity if it starts after the
            // previously selected activity has ended.
            if (currActStart >= prevActEnd) {
                result++;
                prevActEnd = currActEnd;
            }
        }

        System.out.println("Maximum activities: " + result);
    }


    // Approach 2:
    // Works even when activities are NOT sorted according to end time.
    public static void ASSol2(int[] start, int[] end) {

        // Store:
        // [0] -> Activity index
        // [1] -> Start time
        // [2] -> End time
        int activities[][] = new int[start.length][3];

        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // Sort activities according to their end time.
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // Apply the same greedy logic after sorting.
        int result = 1;
        int prevActEnd = activities[0][2];

        for (int i = 1; i < activities.length; i++) {

            int currActStart = activities[i][1];
            int currActEnd = activities[i][2];

            // Select the activity if it starts after the
            // previously selected activity has ended.
            if (currActStart >= prevActEnd) {
                result++;
                prevActEnd = currActEnd;
            }
        }

        System.out.println("Maximum activities: " + result);
    }


    public static void main(String[] args) {

        // Activities are already sorted according to end time.
        int start[] = {10, 12, 20};
        int end[] = {20, 25, 30};

        ASSol(start, end);

        // Activities are not necessarily sorted according to end time.
        ASSol2(
            new int[]{1, 3, 0, 5, 8, 5},
            new int[]{2, 4, 6, 7, 9, 9}
        );
    }
}

/*
 * Complexity:
 *
 * ASSol():
 * Time Complexity  -> O(n)
 * Space Complexity -> O(1)
 *
 * ASSol2():
 * Sorting          -> O(n log n)
 * Selection        -> O(n)
 * Overall          -> O(n log n)
 * Space Complexity -> O(n)
 *
 *
 * Remember:
 *
 * Activity Selection
 * → Sort by increasing finish time
 * → Select activity whose start time >=
 *   previously selected activity's finish time.
 *
 * Greedy Choice:
 * Always select the activity that finishes earliest.
 */