package chap_06;

public class _05_Overloading {
    public static int getPower(int number) {
        int result = number * number;
        return result;
    }

    public static int getPower(String strNumber) {
        int number = Integer.parseInt(strNumber);
        return number * number;
    }

    public static int getPower(int number, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= number;
        }
        return result;
    }

    public static void main(String[] args) {
        // 메소드 오버로딩 (같은 이름의 메서드라도 던지는 값의 형태가 다르므로 메서드를 구분함) ex) 4를 매개변수로 받는 메서드와 "4"를 매개변수로 받는 메서드의 이름이 같으면 오버로딩 가능
        // 조건 : 메서드 매개변수의 자료형이 다르거나, 매개변수를 받는 개수가 다를때

        System.out.println(getPower(3)); // 3 * 3 = 9
        System.out.println(getPower("4")); // 4 * 4 = 16
        System.out.println(getPower(3, 3));
    }
}
