package jpaBook.springJpa01.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    // 밸류 클래스를 사용하겠다는 선언
    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member") // 읽기전용이라는 설정(보통 FK값이 없는 곳에 설정)
    private List<Order> orders = new ArrayList<>();

}
