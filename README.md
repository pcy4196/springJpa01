## springBasic01
  + 1st Example of Spring JPA
  + Ch01. PROJECT 환경설정
    1. 프로젝트 생성
    2. Thymeleaf 기초생성 및 확인(hello.html)
    3. JPA, DB(H2) 설정 및 동작 확인(MemberRepositoryTest.java)    
  + Ch02. Domain
    1. 도메인(엔티티) 클래스 개발
    2. 도메인(엔티티) 클래스 개발시 주의점
       1. 연관관계 메서드(양방향 편의 메서드)
       2. FetchType(XToOne) 추가, CascadeType(OneToOne) 추가
    3. 회원 도메인(Domain) 개발
       1. 회원 서비스(MemberService) 개발
       2. 기능(MemberServiceTest) 테스트
       3. h2 메모리 DB 설정
    4. 상품 도메인(Domain) 개발
       1. 상품 엔티티(Entity) 개발(비즈니스 로직) 추가 
       2. 상품(Item) 리포지터리 개발
       3. 상품 서비스 및 TEST 개발
    5. 주문 도메인(Domain) 개발
       1. 주문, 주문상품(Order,OrderItem) 엔티티 개발
       2. 주문 Repository 개발
       3. 주문 Service 개발
       4. 주문 기능 테스트(OrderServiceTest) 개발
       5. 주문 검색 기능 개발 (JPA Criteria, JPQL append String)
  + Ch03. Web 계층 개발
       1. 홈화면과 레이아웃
