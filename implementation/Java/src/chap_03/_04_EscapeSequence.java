package chap_03;

public class _04_EscapeSequence {
    public static void main(String[] args) {
        // 특수문자, 이스케이프 문자 (Escape Sequence, Escape Character, Special Character)
        // \n \t \\ \" \' 정도가 있다.
        System.out.println("자바가");
        System.out.println("너무");
        System.out.println("재밌어요");

        // \n : 줄바꿈
        System.out.println("자바가\n너무\n재밌어요");

        // 해물파전     9000원
        // 김치전      8000원
        // 부추전      8000원

        // \t : 탭(글자수가 다를때 탭을 통해 글자를 최대한 정렬 함)
        System.out.println("해물파전\t9000원");
        System.out.println("김치전\t6000원");
        System.out.println("부추전\t6000원");

        // \\ : 문자열에 '\'를 입력하기 위해 이스케이프 문자로 인식되지 않기 위한 방법
        System.out.println("C:\\program Files\\Java");

        // 단비가 "냐옹"이라고 했어요.

        // \" 문자열 내에서 큰따옴표를 쓰면 문자열이 닫혀버리므로 문자열 내에서 따옴표를 쓰기 위해선 \"을 사용해 이스케이프 문자로 전환
        System.out.println("단비가 \"냐옹\"이라고 했어요.");

        // 단비가 '뭘 봐?' 라는 표정을 지었어요

        // \' : 문자열 내에서 작은 따옴표를 사용하기 위한 이스케이프
        System.out.println("단비가 \'뭘 봐?\'라는 표정을 지었어요");
        // 사실 문자열에선 작은 따옴표를 사용하지 않아 이스케이프 문자가 아니라도 정상 출력되지만, 그냥 쓰도록 하자 헷갈리잖아 ㅋ

        // \' : 작은 따옴표 이스케이프 문자 주로 '' <- 안에 작은 따옴표 하나를 입력하기 위해 사용
        char c = 'A';
        c = '\'';
    }
}
