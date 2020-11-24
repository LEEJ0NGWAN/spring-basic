package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

//    // DIP 위반
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private MemberRepository memberRepository;

//    // OCP, DIP 위반
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  // DIP 위반(구현 클래스 의존)
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); // OCP 위반(클라이언트의 코드 변경)

    // OCP, DIP를 위한 개선책 -> nullPointerException 극복을 위한 외부로부터 객체 주입이 필요
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);


        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
