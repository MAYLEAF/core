package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class AutowiredTest {
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
