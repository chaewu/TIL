package chap_04;

public class _05_For {
    public static void main(String[] args) {
        // 반복문 For

        // 나코 매장
        System.out.println("어서오세요. 나코입니다.");

        // 또다른 손님이 들어오면?
        System.out.println("어서오세요. 나코입니다.");
        System.out.println("어서오세요. 나코입니다.");
        System.out.println("어서오세요. 나코입니다.");
        System.out.println("어서오세요. 나코입니다.");
        System.out.println("어서오세요. 나코입니다.");
        System.out.println("어서오세요. 나코입니다.");

        // 만약에 인사 법이 바뀌면?
        System.out.println("환영합니다. 나코입니다.");
        System.out.println("환영합니다. 나코입니다.");
        System.out.println("환영합니다. 나코입니다.");

        // 매장 이름이 바뀌면?
        System.out.println("환영합니다. 코나입니다.");

        // 반복문 사용 For

        // 짝수만 출력
        for (int i = 0; i < 10; i += 2) {
            System.out.print(i);
        }

        System.out.println();

        // 홀수만 출력
        for (int i = 1; i < 10; i += 2){
            System.out.print(i);
        }

        System.out.println();

        // 거꾸로 숫자
        for (int i = 5; i > 0; i--) {
            System.out.print(i);
        }

        System.out.println();

        // 1부터 10까지의 수들의 합
        // 1 + 2 + ... + 10 = 55
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            if (i == 10) {
                System.out.println(sum);
            }
        }
    }
}
