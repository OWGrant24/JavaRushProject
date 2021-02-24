package JavaRush.Java_Multithreading.Multithreading3;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Level23Task04_MockDB {
    private static final List<Level23Task04.Task> FAKE_TASKS = new ArrayList<>();
    private static final List<String> FAKE_NAMES = new ArrayList<>();

    public static List<Level23Task04.Task> getFakeTasks(Map criteria) {
        return Level23Task04_MockView.getFakeTaskCriteria().equals(criteria) ? FAKE_TASKS : null;
    }

    public static List<String> getFakeNames(Map criteria) {
        return Level23Task04_MockView.getFakeNameCriteria().equals(criteria) ? FAKE_NAMES : null;
    }
}

