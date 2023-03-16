package hello.hellospring.controller;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // 컨트롤러 내에서 리턴값으로 문자를 반환하면 뷰 리졸버(여기선 Thymeleaf 엔진)이 처리
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
                return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // 응답 Body부에 데이터를 직접 넣음
    public String helloString(@RequestParam("name") String name)  {
        return "hello " + name; // "hello spring"
    }

    @GetMapping("hello-api")
    @ResponseBody // 객체를 반환했을때 json 형식으로 반환
    public Hello helloApi(@RequestParam("name") String name) { // json 방식으로 반환 됨
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name; // 키 값

        public String getName() {
            return name; // return 값이 객체라면 json 형태로 반환
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}


