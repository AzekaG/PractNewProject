package itstep.learning.oop;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  //работа с анотациями Source - ничего не делает в програме , рантайм - входит в сборку и работает
@Target(ElementType.METHOD)  //значит то , что эту анотации можем ставить только на метод. Без таргета - универсально
public @interface Works {
    String value() default "";
}
