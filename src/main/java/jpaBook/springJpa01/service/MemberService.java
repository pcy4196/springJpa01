package jpaBook.springJpa01.service;

import jpaBook.springJpa01.domain.Member;
import jpaBook.springJpa01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor // final 변수만 생성자 자동 Make
public class MemberService {

    private final MemberRepository memberRepository;

//    @Autowired -- 최신 버전에서는 생략 가능
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    /*
    * 회원가입
    */
    @Transactional
    private Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 중복 회원 검증
    private void validateDuplicateMember(Member member) {
        // Exception
        List<Member> findMembers = memberRepository.findByMember(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 회원 단건 조회
    public Member findOne(Long id) {
        return memberRepository.findMember(id);
    }
}
