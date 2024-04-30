package chap_05;

public class _Quiz_05 {
    public static void main(String[] args) {
        int[] sizeArr = new int[10];
        int minSize = 250;

        for (int i = 0; i < 10; i++) {
            sizeArr[i] = minSize;
            minSize += 5; // 이지랄로 안하고 최소 사이즈 250 + (5 * i)하면 됨.. i가 0일땐 250 1일땐 255 ... ~
        }

        for (int size : sizeArr) { // 파이썬으로 따지면 for 변수명 in 리스트: 느낌인듯? ㅇㅇ
            System.out.println("사이즈 " + size + " (재고 있음)");
        }
    }
}
