package JavaRush.Java_Multithreading.Multithreading3;
import java.util.List;
import java.util.Map;

/*
Inner 3 Отправить
*/

public class Level23Task04 {
    private List<Task> tasks;
    private List<String> names;

    private DbDataProvider taskDataProvider = new TaskDataProvider();
    private DbDataProvider nameDataProvider = new NameDataProvider();

    public void refresh() {
        Map taskCriteria = Level23Task04_MockView.getFakeTaskCriteria();
        taskDataProvider.refreshAllData(taskCriteria);

        Map nameCriteria = Level23Task04_MockView.getFakeNameCriteria();
        nameDataProvider.refreshAllData(nameCriteria);
    }

    private interface DbDataProvider<T> {
        void refreshAllData(Map criteria);
    }

    class Task {
    }

    private class TaskDataProvider implements DbDataProvider{
        @Override
        public void refreshAllData(Map criteria) {
            tasks = Level23Task04_MockDB.getFakeTasks(criteria);
        }
    }

    private class NameDataProvider implements DbDataProvider{
        @Override
        public void refreshAllData(Map criteria) {
            names = Level23Task04_MockDB.getFakeNames(criteria);
        }
    }

    public static void main(String[] args) {

    }
}
