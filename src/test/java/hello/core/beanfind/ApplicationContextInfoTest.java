package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

  @Test
  @DisplayName("print all beans")
  void findAllBean() {
    final String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      final Object bean = ac.getBean(beanDefinitionName);
      System.out.println("name = " + beanDefinitionName + " object = " + bean);
    }

  }
  @Test
  @DisplayName("print application beans")
  void findApplicationBean() {
    final String[] beanDefinitionNames = ac.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      final BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
      if( beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
        final Object bean = ac.getBean(beanDefinitionName);
        System.out.println("name = " + beanDefinitionName + " object = " + bean);
      }
    }
  }

}
