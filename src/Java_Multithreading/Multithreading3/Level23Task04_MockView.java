package Java_Multithreading.Multithreading3;

import java.util.HashMap;
import java.util.Map;

public class Level23Task04_MockView {
    private static final Map FAKE_TASK_CRITERIA = new HashMap();

    public static Map getFakeNameCriteria() {
        return FAKE_NAME_CRITERIA;
    }

    private static final Map FAKE_NAME_CRITERIA = new HashMap();

    public static Map getFakeTaskCriteria(){
        return FAKE_TASK_CRITERIA;
    }

}
