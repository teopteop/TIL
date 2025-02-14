package com.example.demo.order;

public interface OrderService {

    //주문생성 메서드
    Order createOrder(Long memberId, String itemName, int itemPrice);

}
