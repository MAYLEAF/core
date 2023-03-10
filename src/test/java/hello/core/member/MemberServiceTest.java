package hello.core.member;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

  MemberService memberService;

  @BeforeEach
  public void beforeEach() {
    final AppConfig appConfig = new AppConfig();
    memberService = appConfig.memberService();

  }


  @Test
  public void join() throws Exception {
    //given
    final Member member = new Member(1L, "memberA", Grade.VIP);
    //when
    memberService.join(member);
    final Member findMember = memberService.findMember(1L);

    //then
    assertThat(member).isEqualTo(findMember);

  }

}
