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
               mainUI.manageAccount();
            } else if (chooseMain == 3) {
                mainUI.checkAccount();
            } else if (chooseMain == 4) {
                mainUI.checkAmount();
            } else if (chooseMain == 5) {
                mainUI.depositWithdrawal();
            } else if (chooseMain == 0) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("잘못된 명령어입니다.");
            }
        }
    }
}
