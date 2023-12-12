import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Random rd = new Random();
        Set<Integer> randomNumbers = new HashSet<>();

        // 중복이 없는 3개의 랜덤 값 생성
        while (randomNumbers.size() < 3) {
            int randomNumber = rd.nextInt(10);
            randomNumbers.add(randomNumber);
        }

        // Set을 배열로 변환
        Integer[] randomNumberArray = randomNumbers.toArray(new Integer[0]);

        System.out.println("게임을 시작합니다. 중복 없는 3개의 숫자를 맞춰보세요!");

        Scanner scanner = new Scanner(System.in);
        boolean guessedCorrectly = false;
        int attempts = 0;

        // 무제한으로 기회 부여 //while 반복문을 통해  사용자가 무제한 입력
        while (!guessedCorrectly) {
            // 사용자로부터 입력 받기
            System.out.print("세 개의 숫자를 입력하세요: ");
            int userNumber = scanner.nextInt();

            // 입력 받은 숫자의 각 자리 추출
            int userDigit1 = userNumber / 100;
            int userDigit2 = (userNumber / 10) % 10;
            int userDigit3 = userNumber % 10;

            // 스트라이크, 볼 계산
            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < 3; i++) {
                if (userDigit1 == randomNumberArray[i]) {
                    strikes++;
                } else if (userDigit1 == randomNumberArray[(i + 1)] || userDigit1 == randomNumberArray[(i + 2) % 3]) {
                    balls++;
                }

                if (userDigit2 == randomNumberArray[i]) {
                    strikes++;
                } else if (userDigit2 == randomNumberArray[(i + 1)] || userDigit2 == randomNumberArray[(i + 2) % 3]) {
                    balls++;
                }

                if (userDigit3 == randomNumberArray[i]) {
                    strikes++;
                } else if (userDigit3 == randomNumberArray[(i + 1) % 3] || userDigit3 == randomNumberArray[(i + 2) % 3]) {
                    balls++;
                }
            }

            // 결과 출력
            if (strikes == 3) {
                guessedCorrectly = true;
                System.out.println("축하합니다! " + attempts + "번째 시도에 정답을 맞추셨습니다!");
            } else {
                System.out.println("스트라이크: " + strikes + ", 볼: " + balls + ". 다시 시도하세요.");
                attempts++;
            }
        }

        // Scanner 사용이 끝났으므로 닫아줍니다.
        scanner.close();
    }
}
