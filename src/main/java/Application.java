import presentation.*;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
        CreateAccountUI createAccountUI = new CreateAccountUI();
        ManageAccountUI manageAccountUI = new ManageAccountUI();
        CheckAccountUI checkAccountUI = new CheckAccountUI();
        CheckAmountUI checkAmountUI = new CheckAmountUI();
        DepositWithdrawalUI depositWithdrawalUI = new DepositWithdrawalUI();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            mainUI.run();
            try {
                System.out.print("번호 입력 : ");
                String sChooseMain = scanner.nextLine();
                int chooseMain = Integer.parseInt(sChooseMain);
                if (chooseMain == 1) {
                    createAccountUI.createAccount();
                } else if (chooseMain == 2) {
                    manageAccountUI.manageAccount();
                } else if (chooseMain == 3) {
                    checkAccountUI.checkAccount();
                } else if (chooseMain == 4) {
                    checkAmountUI.checkAmount();
                } else if (chooseMain == 5) {
                    depositWithdrawalUI.depositWithdrawal();
                } else if (chooseMain == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                } else {
                    System.out.println("잘못된 명령어입니다.");
                }
            } catch (NumberFormatException e) {
                System.out.println("입력이 올바르지 않습니다.");
            }
        }
    }
}
