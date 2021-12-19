package jpaBook.springJpa01.service;

import jpaBook.springJpa01.domain.Delivery;
import jpaBook.springJpa01.domain.Member;
import jpaBook.springJpa01.domain.Order;
import jpaBook.springJpa01.domain.OrderItem;
import jpaBook.springJpa01.domain.item.Item;
import jpaBook.springJpa01.repository.ItemRepository;
import jpaBook.springJpa01.repository.MemberRepository;
import jpaBook.springJpa01.repository.OrderRepository;
import jpaBook.springJpa01.repository.OrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    // 도메인 모델 패턴        --> 엔티티에 비즈니스 로직 존재 및 대부분 처리
    // 트랜잭션 스크립트 패턴  --> 서비스 계층에서 대부분의 비즈니스 로직 처리

    /**
     * 주문
     */
    @Transactional
    public Long order(Long memberId, Long itemId, int count) {
        // 엔티티 조회(회원, 상품)
        Member member = memberRepository.findOne(memberId);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성(중요한 부분!!)
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);
        return order.getId();
    }



    /**
     * 주문 취소
     */
    @Transactional
    public void cancelOrder(Long orderId) {
        // 주문 엔티티 조회
        Order order = orderRepository.findOne(orderId);
        // 주문 취소
        order.cancel();
    }

    // 검색
    public List<Order> findOrders(OrderSearch orderSearch) {
        return orderRepository.findAllByString(orderSearch);
    }

}