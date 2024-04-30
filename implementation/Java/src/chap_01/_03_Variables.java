package chap_01;

public class _03_Variables {
    public static void main(String[] args) {
        String name = "채우"; // 문자열 변수 String 선언
        int hour = 15;  // 정수형 변수 int 선언

        System.out.println(name + "님, 배송이 시작됩니다. " + hour + "시에 방문 예정입니다.");
        System.out.println(name + "님, 배송이 완료되었습니다.");

        double score = 90.5; // 실수형 변수 double 선언
        char grade = 'A'; // 문자(한글자) 변수 char 선언
        name = "김석진";
        System.out.println(name + "님의 평균 점수는 " + score + "점입니다.");
        System.out.println("학점은 " + grade + "입니다.");

        boolean pass = true; // 참과거짓 변수 boolean 선언
        System.out.println("이번 시험에 합격했을가요? " + pass);

        double d = 3.14123456789; // 실수 변수 d(3.14) 선언
        float f = 3.14123456789F; // 같은 실수 자료형인 float 하지만 실수는 double이 default 이기에 값 뒤에 f/F를 붙여줘야함
        System.out.println(d); // [res : 3.14123456789] # 정상출력
        System.out.println(f); // [res : 3.1412346] float 자료형은 깊은 소수점을 다루는 연산에서 정확성이 떨어짐

        // int i = 1000000000000; int 자료형의 범위한계(-21억~21억)을 넘어가는 수는 int 자료형에 담지 못함
        long l = 1000000000000L; // float와 마찬가지로 int가 정수값의 default 자료형이므로 값 뒤에 l/L을 붙혀 long 자료형을 인식시킴
        l = 1_000_000_000_000L; // 밑줄 사용 가능 (가독성 증가)
        System.out.println(l);
    }
}
