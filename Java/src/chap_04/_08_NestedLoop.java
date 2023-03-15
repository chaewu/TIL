package chap_04;

public class _08_NestedLoop {
    public static void main(String[] args) {
        // 이중 반복문

        // 별 정사각형 만들기 (5*5)
/*
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
*/

        // 별 좌측면 직각삼각형 만들기
/*
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
*/

//        // 별 우측면 직각삼각형 만들기
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 4 - i; j++) {
//                System.out.print(" ");
//            }
//
//            for (int k = 0; k < i + 1; k++) {
//                System.out.print("*");
//            }
//            System.out.println();
//        }

        // 별 우측면 븅신같은거 어쩌구
        /*
        *****
         ****            <- 이거
          ***
           **
            *
        */
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 5; k > i; k--) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
