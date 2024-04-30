package chap_03;

public class _02_String2 {
    public static void main(String[] args) {
        String s = "I like Java and Python and C.";

        // 문자열 변환
        System.out.println(s.replace(" and", ",")); // " and"를 ","로 변환
        System.out.println(s.substring(7)); // 입력한 인덱스 위치 7부터 반환 (이전 내용 출력 안함)
        System.out.println(s.substring(s.indexOf("Java"))); // s.indexOf()함수 내에 적은 문자열의 시작 인덱스값 부터 반환
        // s.substring(인덱스값, 인덱스값)을 입력하면 앞 인덱스 ~ 종료 인덱스 전까지 반환
        System.out.println(s.substring(s.indexOf("Java"), s.indexOf("Python")));


        // 공백 제거
        s = "               I love Java.          ";
        System.out.println(s);
        System.out.println(s.trim()); // 앞 뒤 공백 제거(문자열 사이 사이의 공백은 제거하지 않음)

        // 문자열 결합
        String s1 = "Java";
        String s2 = "Python";
        System.out.println(s1 + s2); // 문자열 병합
        System.out.println(s1 + ", " + s2);
        // s1에 concat()을 이용해 ", " 문자열을 병합하고 거기에 또 다른 .concat()을 사용해 연결
        System.out.println(s1.concat(", ").concat(s2));
        System.out.println();
    }
}
