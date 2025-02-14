package com.example.demo.discount;

import com.example.demo.member.Grade;
import com.example.demo.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            //enum 타입 값은 메모리에서 하나만 존재 == 으로 비교 가능
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
