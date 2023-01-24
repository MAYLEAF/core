package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

  RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

  @Test
  @DisplayName("Discount should be applied to VIP")
  public void vip_o() throws Exception {
    //given

    final Member member = new Member(1L, "memberVIP", Grade.VIP);

    //when
    final int discount = discountPolicy.discount(member, 10000);
    //then
    assertThat(discount).isEqualTo(1000);
  }

  @Test
  @DisplayName("Discount should not be applied to another of VIP")
  public void vip_x() throws Exception {
    //given
    final Member member = new Member(2L, "memberBASIC", Grade.BASIC);
    //when
    final int discount = discountPolicy.discount(member, 10000);
    //then
    assertThat(discount).isEqualTo(0);
  }


}