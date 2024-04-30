package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class MemoryMemberRepositoryTest { // 클래스를 실행시 내부의 테스트 코드를 모두 작동 가능

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() { // 콜백 메서드 (테스트가 하나 종료될 때마다 실행되는 메서드)
        repository.clearStore(); // MemoryMemberRepository에 있는 clearStore 참조
    }

    @Test
    public void save() { // 실무에서는 build툴과 엮어서 테스트케이스를 통과하지 못하면 다음 단계로 넘어가는 것을 막음

        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    public void findByName() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // 같은 테스트 ctrl c/v시 shift + f6을 통해 빠른 이름 변경 가능
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member2);

    }

    @Test
    public void findAll() {

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll(); // 멤버 리스트를 전부 조회함

        assertThat(result.size()).isEqualTo(2); // 조회한 리스트의 크기가 2이므로(2명) 테스트 통과 ex) ~.isEqualTo(3)시 통과x

    }

}
