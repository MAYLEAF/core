package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApplication {

  public static void main(String[] args) {
//    final MemberServiceImpl memberService = new MemberServiceImpl(null);
//    final OrderServiceImpl orderService = new OrderServiceImpl(null,null);

    final AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
        AppConfig.class);

    final MemberService memberService = annotationConfigApplicationContext.getBean("memberService",
        MemberService.class);
    final OrderService orderService = annotationConfigApplicationContext.getBean("orderService",
        OrderService.class);

    final long memberId = 1L;
    final Member member = new Member(memberId, "memberA", Grade.VIP);
    memberService.join(member);

    final Order order = orderService.createOrder(memberId, "itemA", 10000);

    System.out.println("order = " + order);
    System.out.println("order.caculatedPrice = " + order.calculatePrice());


  }

}
