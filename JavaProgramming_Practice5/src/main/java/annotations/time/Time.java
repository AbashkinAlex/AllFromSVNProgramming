package annotations.time; /**
 * Created by Abashkin Aleksandr on 22.03.2016.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Time {
    public enum TimeInterval { MILLISECOND, NANOSECOND };
    annotations.time.Time.TimeInterval interval() default annotations.time.Time.TimeInterval.MILLISECOND;
    String format() default "Elapsed %s";
}
