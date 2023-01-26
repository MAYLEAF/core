package hello.core.autowired;

import hello.core.member.Member;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

public class AutowiredTest {

  @Test
  public void AutowiredOption() {
    //given
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(
        TestBean.class);

    //when

    //then
  }
  static class TestBean {
    @Autowired(required = false)
    public void setNoBean(Member noBean1) {
      System.out.println("noBean1 = " + noBean1);
    }
    @Autowired
    public void setNoBean1(@Nullable Member noBean2) {
      System.out.println("noBean2 = " + noBean2);
    }
    @Autowired
    public void setNoBean2(Optional<Member> noBean3) {
      System.out.println("noBean3 = " + noBean3);
    }


  }
}
