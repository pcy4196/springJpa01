package jpaBook.springJpa01.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

// 밸류 클래스 선언
@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // 생성자 선언(일반적으로 NEW 선언으로 금지)
    public Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
