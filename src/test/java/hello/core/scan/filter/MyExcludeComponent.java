package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // 애노테이션이 붙는 목표 엘리먼트 타입은 Type(클래스)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {

}
