package chap_02;

public class _02_Operator2 {
    public static void main(String[] args) {
        int num = 10;
        num = num + 2;
        System.out.println(num); // 12

        num = num - 2;
        System.out.println(num); // 10

        num = num * 2;
        System.out.println(num); // 20

        num = num / 2;
        System.out.println(num); // 10

        num = num % 2;
        System.out.println(num); // 0

        // 복합 대입 연산자
        num = 10;
        num += 2; // num = num + 2
        System.out.println(num);

        num -= 2;
        System.out.println(num);

        num *= 2;
        System.out.println(num);

        num /= 2;
        System.out.println(num);

        num %= 2;
        System.out.println(num);
    }
}
