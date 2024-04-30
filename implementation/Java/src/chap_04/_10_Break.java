package chap_04;

public class _10_Break {
    public static void main(String[] args) {
        // Break
        // 치킨 집에서 매일 20마리만 판매 (1인당 1마리만 구매 가능)
        // 손님이 50명 대기

        // For 문
        final int MAX_CHICKEN = 20;
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + "번 손님, 주문하신 치킨 나왔습니다.");
            if (i == MAX_CHICKEN) {
                System.out.println("금일 재료가 모두 소진되었습니다.");
                break; // 반복문 탈출 (가장 가까운 반복문 현재 for 문)
            }
        }
        System.out.println("영업을 종료합니다.");

        System.out.println("--------------------");

        int waiting = 1;
        while (waiting <= 50) {
            System.out.println(waiting + "번 손님, 주문하신 치킨 나왔습니다.");
            if (waiting == MAX_CHICKEN) {
                System.out.println("금일 재료가 모두 소진되었습니다.");
                break;
            }
            waiting++;
        }
        System.out.println("영업을 종료합니다.");
    }
}
