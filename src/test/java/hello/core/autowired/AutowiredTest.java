package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    public void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        //required = false 옵션으로 인해, 주입될 빈이 없으면 메서드 자체가 호출되지 않음
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println(noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println(noBean2); // null
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println(noBean3); // Java 8 Optional.empty
        }
    }
}
