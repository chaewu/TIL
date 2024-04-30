package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {                            // DI(Dependency Injection)
        memberRepository =  new MemoryMemberRepository(); // 외부에서 memberRepository를 넣어줌
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() { // 다른 코드는 메서드명 한글로 적으면 개처맞는데 test 코드는 영미권에서 일하는게 아니라면 한글 써도 된다네요
        // given
        Member member = new Member(); // 회원 객체 생성
        member.setName("spring"); // 생성한 회원 객체의 이름 쓰기

        // when
        Long saveId = memberService.join(member); // 저장된 멤버 객체를 가입처리

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외처리() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring"); // 다른 멤버가 같은 이름을 가짐. 이때 중복 이름을 받지 않기로 했으므로 오류 반환

        // when
        // 1) try-catch

        /*
        memberService.join(member1);
        try {
            memberService.join(member2);
            fail("예외가 발생해야 합니다");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.123123");
        }
         */

        // 2) assertThrows
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}
