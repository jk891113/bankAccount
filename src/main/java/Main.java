import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
        mainUI.run();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            mainUI.run();
            int chooseMain = scanner.nextInt();
            if (chooseMain == 1) {

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
