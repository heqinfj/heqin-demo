package annotations.repeatingannotations;

import org.junit.Test;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @Author heqin
 * @Date 2021/12/4 19:52
 */
public class RetrievingAnnotations {

    @Test
    public void testGetAnnotation() throws NoSuchMethodException {
        Class<Task> taskClass = Task.class;
        Method doPeriodicCleanup = taskClass.getMethod("doPeriodicCleanup");
        System.out.println(doPeriodicCleanup);
        System.out.println("是否存在Schedule注解：" + doPeriodicCleanup.isAnnotationPresent(Schedule.class));
        Schedule schedule = doPeriodicCleanup.getAnnotation(Schedule.class);
        System.out.println(schedule);

        Method doPeriodicCleanup1 = taskClass.getMethod("doPeriodicCleanup1");
        System.out.println(doPeriodicCleanup1);
        System.out.println("是否存在Schedule注解：" + doPeriodicCleanup1.isAnnotationPresent(Schedule.class));
        System.out.println("是否存在Schedules注解：" + doPeriodicCleanup1.isAnnotationPresent(Schedules.class));

        Method doPeriodicCleanup2 = taskClass.getMethod("doPeriodicCleanup2");
        System.out.println(doPeriodicCleanup2);
        System.out.println("是否存在Schedules注解：" + doPeriodicCleanup2.isAnnotationPresent(Schedules.class));
    }
}
