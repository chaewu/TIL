package chap_04;

public class _01_If {
    public static void main(String[] args) {
        // 조건문 If
        int hour = 15; // 오전 10시

        // if문에서  단 하나의 문장만 실행해야 할땐 중괄호 생략 가능 (근데 하면 조처맞음 ㅈ처맞기 싫으면 생략 x)
        if (hour < 14)
            System.out.println("아이스 아메리카노 +1");

        // if 문 내에서
        if (hour < 14) {
            System.out.println("아이스 아메리카노 +1");
            System.out.println("샷추가");
        }
        System.out.println("커피 주문 완료");


        // 오후 2시 이전, 모닝 커피를 마시지 않은 경우?
        hour = 10;
        boolean morningCoffee = false; // 모닝 커피

        // 모닝커피를 마시지 않았으며, 동시에 시간이 2시 전이면
        if (hour < 14 && !morningCoffee) { //
        // if (hour < 14 && morningCoffee == false) {
            System.out.println("아이스 아메리카노 +1");
        }
        System.out.println("커피 주문 완료");

        // 오후 2시 이후이거나 모닝 커피 true인 경우?
        hour = 12;
        morningCoffee = false;
        if (hour >= 14 || morningCoffee) {
            System.out.println("아이스 아메리카노(디카페인) +1");
        }
        System.out.println("커피 주문 완료!");
    }
}
