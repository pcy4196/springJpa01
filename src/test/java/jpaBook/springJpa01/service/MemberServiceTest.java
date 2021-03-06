package jpaBook.springJpa01.service;

import jpaBook.springJpa01.domain.Member;
import jpaBook.springJpa01.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
//    @Rollback(false) // 롤백을 시키지 않겠다는 어노테이션
    public void 회원가입() throws Exception {
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long saveId = memberService.join(member);

        // then
        em.flush(); // DB에 쿼리로그가 찍히는 것을 확인가능하다.
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class) // IllegalStateException 발생해야지만 true
    public void 중복_회원_예외() throws Exception {
        // given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");

        // when
        memberService.join(member1);
//        try {
//            memberService.join(member2);    // 예외가 발생해야 한다.
//        } catch (IllegalStateException e) {
//            return;
//        }
        memberService.join(member2);    // 예외가 발생해야 한다.

        // then
        fail("예외가 발생해야 한다.");
    }
}