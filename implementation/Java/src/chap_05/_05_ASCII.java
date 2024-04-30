package chap_05;

public class _05_ASCII {
    public static void main(String[] args) {
        // 아스키 코드 (ANSI) : 미국 표준 코드
        char c = 'A';
        System.out.println(c);
        System.out.println((int)c); // 대문자 A는 아스키 코드로 65, 소문자(a)는 68부터, 숫자 0은 48부터

        c = 'B';
        System.out.println(c);
        System.out.println((int)c);

        c++;
        System.out.println(c);
        System.out.println((int)c);



        String[][] seats3 = new String[10][15];
        char ch = 'A';
        for (int i = 0; i < seats3.length; i++) {
            for (int j = 0; j < seats3[i].length; j++) {
                seats3[i][j] = String.valueOf(ch) + (j + 1);
            }
            ch++;
        }

        for (int i = 0; i < seats3.length; i++) { // 세로 기준
            for (int j = 0; j < seats3[i].length; j++) { // 가로 기준
                System.out.print(seats3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
