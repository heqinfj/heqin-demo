package annotations.repeatingannotations;

/**
 * @Author heqin
 * @Date 2021/12/4 19:42
 */
public class Task {

    @Schedule(dayOfWeek = "Fri", hour = 23)
    public void doPeriodicCleanup() {

    }

    @Schedule(dayOfMonth = "last")
    @Schedule(dayOfWeek = "Fri", hour = 23)
    public void doPeriodicCleanup1() {

    }

    @Schedules({@Schedule(dayOfMonth = "last"), @Schedule(dayOfWeek = "Fri", hour = 23)})
    public void doPeriodicCleanup2() {

    }
}
