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

            } else if (chooseMain == 6) {

            } else if (chooseMain == 7) {

            } else if (chooseMain == 8) {

            } else if (chooseMain == 9) {

            } else if (chooseMain == 0) {

            }
        }
    }
}
