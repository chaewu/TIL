package chap_04;

public class _11_Continue {
    public static void main(String[] args) {
        // Continue

        // 치킨 주문 손님중에 노쇼 손님 있다면?
        // For
        final int MAX_CHICKEN = 20; // 최대 판매 가능 수량
        int soldChicken = 0; // 현재 치킨 판매 수량
        final int NO_SHOW = 17; // 대기번호 17번 손님이 노쇼
        for (int i = 1; i <= 50; i++) {
            System.out.println(i + "번 손님, 주문하신 치킨 나왔습니다.");

            // 손님이 없다며? (noShow)
            if (i == NO_SHOW) {
                System.out.println(i + "번 손님, 노쇼로 인해 다음 손님에게 기회가 넘어갑니다.");
                continue; // 반복문에서 이번 회차를 뛰어넘음
            }

            soldChicken++; // 판매 처리
            if (soldChicken == MAX_CHICKEN) {
                System.out.println("금일 재료가 모두 소진되었습니다.");
                break;
            }
        }
        System.out.println("영업을 종료합니다.");

        System.out.println("-----------------");

        int waiting = 0;
        soldChicken = 0;

        while (waiting <= 50) {
            waiting++;
            System.out.println(waiting + "번 손님, 주문하신 치킨 나왔습니다.");

            if (waiting == NO_SHOW) {
                System.out.println(waiting + "번 손님, 노쇼 시발!");
                continue;
            }

            soldChicken++;
            if (soldChicken == MAX_CHICKEN) {
                System.out.println("금일 준비된 재료가 모두 소진되었습니다.");
                break;
            }
        }
        System.out.println("영업을 종료합니다.");
    }
}
