package hello.core.singleton;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService instance1 = ac.getBean(StatefulService.class);
        StatefulService instance2 = ac.getBean(StatefulService.class);

        instance1.order("A", 10000);
        instance2.order("B", 20000);

        // 10000이 나오기를 기대했으나, 결과는 20000
        int price = instance1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(price).isNotEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}