package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); // NULL이 반환 될 가능성이 있을때 그대로 반환하기 보다는 Optional로 감싸서 반환
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
