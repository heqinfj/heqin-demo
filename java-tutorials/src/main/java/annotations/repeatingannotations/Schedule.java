package annotations.repeatingannotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Author heqin
 * @Date 2021/12/4 19:40
 */

@Repeatable(Schedules.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Schedule {

    String dayOfMonth() default "first";

    String dayOfWeek() default "Mon";

    int hour() default 12;
}
