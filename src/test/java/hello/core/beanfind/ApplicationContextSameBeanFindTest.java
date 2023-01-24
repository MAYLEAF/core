package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class ApplicationContextSameBeanFindTest {

  AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
      SameBeanConfig.class);

  @Test
  @DisplayName("Duplication error occurs when same type exists with type search")
  void findBeanByTypeDuplicate() {
    assertThrows(NoUniqueBeanDefinitionException.class,
        () -> ac.getBean(MemoryMemberRepository.class));
  }

  @Test
  @DisplayName("use bean search with name, when the bean type is not unique")
  void findBeanByName() {
    final MemberRepository memberRepository = ac.getBean("memberRepository1",
        MemberRepository.class);
    assertThat(memberRepository).isInstanceOf(MemberRepository.class);
  }

  @Test
  @DisplayName("use bean search with name, when the bean type is not unique")
  void findAllBeanByTypes() {
    final Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
    for (String key : beansOfType.keySet()) {
      System.out.println("beansOfType = " + key);
    }
    System.out.println("beansOfType = " + beansOfType);
    assertThat(beansOfType.size()).isEqualTo(2);
  }


  static class SameBeanConfig {

    @Bean
    public MemberRepository memberRepository1() {
      return new MemoryMemberRepository();
    }

    @Bean
    public MemberRepository memberRepository2() {
      return new MemoryMemberRepository();
    }
  }

}
