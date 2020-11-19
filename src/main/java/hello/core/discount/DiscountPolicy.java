package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * return 대상의 할인 금액
     */
    int discount(Member member, int price);
}
