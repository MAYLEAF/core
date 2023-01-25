package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

  @Test
  void configurationTest() {
    final AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        AppConfig.class);

    final MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    final OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    final MemberRepository memberRepository2 = ac.getBean("memberRepository", MemberRepository.class);

    final MemberRepository memberRepository = memberService.getMemberRepository();
    final MemberRepository memberRepository1 = orderService.getMemberRepository();

    System.out.println("memberRepository = " + memberRepository);
    System.out.println("memberRepository1 = " + memberRepository1);
    System.out.println("memberRepository2 = " + memberRepository2);

  }


}
