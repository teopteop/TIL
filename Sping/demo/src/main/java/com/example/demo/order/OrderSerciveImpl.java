package com.example.demo.order;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.FixDiscountPolicy;
import com.example.demo.member.Member;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemoryMemberRepository;

public class OrderSerciveImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int disocutPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, disocutPrice);
    }
}
