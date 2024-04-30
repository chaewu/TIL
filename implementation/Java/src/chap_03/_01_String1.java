package chap_03;

public class _01_String1 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C."; // 강의에 나와서 따라한거지만 사실 and를 두번 사용하는 것 보단 마지막 한번만 쓰는게 문법상 좋다.
        System.out.println(s);

        // 문자열의 길이
        System.out.println(s.length()); // 29

        // 대소문자 변환
        System.out.println(s.toUpperCase());
        System.out.println(s.toLowerCase());

        // 포함 관계
        System.out.println(s.contains("Java")); // 위에서 선언한 변수 s내에 입력한 문자열 "Java"가 포함된다면 True 아니라면 False 반환
        System.out.println(s.contains("C#")); // "C#"이라는 문자열은 없기에 false 출력.
        System.out.println(s.indexOf("Java")); // 문자열이 변수 내에 포함되어 있다면 문자열 시작 위치 출력
        System.out.println(s.indexOf("C#")); // 포함되지 않으므로 -1 출력
        System.out.println(s.indexOf("and")); // 처음 일치하는 위치 정보 (12)
        System.out.println(s.lastIndexOf("and")); // 마지막에 일치하는 위치 정보 (23)
        System.out.println(s.startsWith("I like")); // 입력한 문자열로 변수의 값이 시작한다면 true, 아니라면 false 반환
        System.out.println(s.endsWith(".")); // 입력한 문자열로 변수 내의 값이 끝난다면 true, 아니라면 false
    }
}
