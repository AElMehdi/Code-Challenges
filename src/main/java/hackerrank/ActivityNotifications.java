package hackerrank;

import java.util.List;

import static java.util.Collections.sort;
/*
* Slow solution of a sorting problem "Fraudulent Activity Notifications"
* Using a brut force algorithm with List as the underlying DS
* N.B: Accessing elements in a list
 * */
public class ActivityNotifications {


    public static int process(List<Integer> expenditure, int d) {
        int notification = 0;
        int n = expenditure.size();
        int steps = n - d;

        for (int i = 0; i < steps; i++) {
            int currentDaysExpenditure = expenditure.get(d);
            List<Integer> trailingDays = expenditure.subList(i, d + i);

            if (currentDaysExpenditure >= getMedian(trailingDays) * 2) {
                notification++;
            }
        }

        return notification;
    }

    static int getMedian(List<Integer> trailingDays) {
        sort(trailingDays);
        return trailingDays.get(trailingDays.size()/ 2);
    }

}
