import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainUI mainUI = new MainUI();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mainUI.run();
            System.out.print("번호 입력 : ");
            int chooseMain = scanner.nextInt();
            if (chooseMain == 1) {
                mainUI.createAccount();
            } else if (chooseMain == 2) {

            } else if (chooseMain == 3) {

            } else if (chooseMain == 4) {

            } else if (chooseMain == 5) {

            } else if (chooseMain == 0) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            }
        }
    }
}
