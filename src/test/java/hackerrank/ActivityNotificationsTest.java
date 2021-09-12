package hackerrank;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hackerrank.ActivityNotifications.getMedian;
import static hackerrank.ActivityNotifications.process;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class ActivityNotificationsTest {


    @Test
    void should_return_2_notifications_in_5_trailing_days_given_the_input_below() {
        List<Integer> expenditures = asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
        int days = 5;


        assertThat(process(expenditures, days)).isEqualTo(2);
    }

    @Test
    void get_median_from_odd_list_of_trailing_days() {
        assertThat(getMedian(asList(2, 3, 4, 2, 3))).isEqualTo(3);
    }

    @Test
    @Disabled
    void get_median_from_even_list_of_trailing_days() {
        assertThat(getMedian(asList(8, 7, 9, 1, 3, 2, 5, 6, 4))).isEqualTo(4.5);
    }
}