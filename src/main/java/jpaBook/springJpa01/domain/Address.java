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
}
