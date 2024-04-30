package chap_04;

public class _Quiz_04 {
    public static void main(String[] args) {
        int parkingTime = 100; // 주차 시간
        String carType = "Normal"; // 차종(일반, 경차, 장애인 차량 등)
        final int MAX_PARKING_FEE = 30_000; // 최대 주차요금 (30,000원)
        int yourFee = 0; // 님 요금 ㅋㅋ

        while (yourFee <= MAX_PARKING_FEE) {
            if (parkingTime == 0) {
                break;
            }

            parkingTime--;
            yourFee += 4000;
        }

        if (yourFee >= 30000) {
            yourFee = 30000;
        }

        if (carType == "Disabled" || carType == "lightCar") {
            yourFee /= 2;
        }

        System.out.println("주차 요금은 " + yourFee + " 원 입니다.");
    }
}
