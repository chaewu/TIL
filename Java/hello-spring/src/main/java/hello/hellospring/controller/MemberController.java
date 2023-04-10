package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller // Spring container에 클래스 명 객체를 생성해서 보관
public class MemberController {

    private final MemberService memberService;

    @Autowired // member 컨트롤러가 생성 될때 spring bean에 등록되어 있는 멤서 서비스 객체를 넣어줌 (의존성 주입)
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
