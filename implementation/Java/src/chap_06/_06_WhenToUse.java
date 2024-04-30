package chap_06;

public class _06_WhenToUse {
    public static int getPower(int number) { // 딱 2승을 구하고 싶으면 한개의 값만 넣어 해당 값의 제곱을 구함
        return getPower(number, 2);
    }

    public static int getPower(int number, int exponent) { // 2승 이상을 구하고 싶을땐 해당 값, 몇승인지 적어서 구함
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }


    public static void main(String[] args) {
        // 메소드가 필요한 이유

        System.out.println(getPower(2, 2));

        System.out.println(getPower(3, 3));

        // 4의 2승을 구하기
        System.out.println(getPower(4, 2));
    }
}
