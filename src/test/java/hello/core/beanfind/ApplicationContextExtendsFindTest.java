package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextExtendsFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

  @Test
  @DisplayName("Duplication error occurs when two or more child discovered by parents type")
  void findBeanByParentTypeDuplicate() {
    assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
  }

  @Test
  @DisplayName("use bean name when search parents type that has many child")
  void findBeanByParentTypeBeanName() {
    final DiscountPolicy rateDisCountPolicy = ac.getBean("rateDiscountPolicy",
        DiscountPolicy.class);
    assertThat(rateDisCountPolicy).isInstanceOf(RateDiscountPolicy.class);
  }

  @Test
  @DisplayName("find by sub type")
  void findBeanBySubType() {
    final RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
    assertThat(bean).isInstanceOf(RateDiscountPolicy.class);

  }

  @Test
  @DisplayName("find by parent type")
  void findAllByParentType() {
    final Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
    assertThat(beansOfType.size()).isEqualTo(2);
    for (String key : beansOfType.keySet()) {
      System.out.println("key = " + key + " value = " + beansOfType.get(key));
    }

  }
  @Test
  @DisplayName("find by parent type - Object")
  void findAllByParentTypeObject() {
    final Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("key = " + key + " value = " + beansOfType.get(key));
    }

  }

  static class TestConfig {

    @Bean
    public DiscountPolicy rateDiscountPolicy() {
      return new RateDiscountPolicy();
    }

    @Bean
    public DiscountPolicy fixDiscountPolicy() {
      return new FixDiscountPolicy();
    }
  }


}
