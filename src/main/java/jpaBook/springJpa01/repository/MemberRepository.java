package jpaBook.springJpa01.repository;

import jpaBook.springJpa01.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

// spring Bean으로 등록
@Repository
@RequiredArgsConstructor // springBoot 최신버전에서만 가능 PersistenceContext 대신에 autowired 사용가능
public class MemberRepository {

//    // EntityManger 등록
//    @PersistenceContext
//    private EntityManager em;
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        // entity 객체에 관하여 쿼리 조회
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByMember(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}

