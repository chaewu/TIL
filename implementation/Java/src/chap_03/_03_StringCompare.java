package chap_03;

public class _03_StringCompare {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Python";
        System.out.println(s1.equals(s2)); // 필드.equals(필드) 함수는 앞에서 호출한 변수와 equals내에 적은 필드의 값이 같으면 true or false

        System.out.println(s1.equals("Java")); // .equals() 내에는 꼭 필드가 아닌 그냥 생 문자열을 작성해도 된다
        System.out.println(s2.equals("python")); // 대소문자를 구분해 false 반환

        System.out.println(s2.equalsIgnoreCase("python")); // 대소문자 구분 없이 내용이 같으면 true 반환 (공백은 안씹어줌)

        // 문자열 비교 심화
        s1 = "1234";
        s2 = "1234"; // 위와 같은 값이기에 문자열 "1234"는 하나만 생성되어 s1, s2 모두 하나의 문자열을 참조한다.

        System.out.println(s1.equals(s2)); //true
        System.out.println(s1 == s2); // true

        s1 = new String("1234");
        s2 = new String("1234"); // 기존과 같은 값을 참조하는게 아닌 모두 새로운 "1234"를 생성해 == 연산자를 사용했을때 서로 다른 값으로 반환
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1 == s2); // false
    }
}
