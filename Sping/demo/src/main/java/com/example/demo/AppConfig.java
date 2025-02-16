package com.example.demo;

import com.example.demo.discount.DiscountPolicy;
import com.example.demo.discount.RateDiscountPolicy;
import com.example.demo.member.MemberRepository;
import com.example.demo.member.MemberService;
import com.example.demo.member.MemberServiceImpl;
import com.example.demo.member.MemoryMemberRepository;
import com.example.demo.order.OrderService;
import com.example.demo.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {


    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); // 이 메서드에서만 호출
    }

    @Primary
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 이 메서드에서도 동일 객체 호출
//        return null;
    }

    @Primary
    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
