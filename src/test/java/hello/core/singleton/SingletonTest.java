package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import javafx.application.Application;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {

  @Test
  public void pureContainer() throws Exception {
    //given
    final AppConfig appConfig = new AppConfig();
    final MemberService memberService1 = appConfig.memberService();
    final MemberService memberService2 = appConfig.memberService();

    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    Assertions.assertThat(memberService1).isNotSameAs(memberService2);

    //when

    //then
  }

  @Test
  public void springContainer() throws Exception {
    //given
//    final AppConfig appConfig = new AppConfig();
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    final MemberService memberService1 = ac.getBean("memberService", MemberService.class);
    final MemberService memberService2 = ac.getBean("memberService", MemberService.class);

    System.out.println("memberService1 = " + memberService1);
    System.out.println("memberService2 = " + memberService2);

    Assertions.assertThat(memberService1).isSameAs(memberService2);

    //when

    //then
  }

}
