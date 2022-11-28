package presentation;

import service.MainProcess;

import java.util.Scanner;

public class DepositWithdrawalUI {
    Scanner scanner = new Scanner(System.in);
    MainProcess mainProcess = new MainProcess();

    public void depositWithdrawal() {
        System.out.println("------------------------------");
        System.out.println("           1. 입금");
        System.out.println("           2. 출금");
        System.out.println("           3. 송금");
        System.out.println("------------------------------");
        System.out.print("번호 입력 : ");
        int chooseMenu = scanner.nextInt();
        if (chooseMenu == 1) {
            System.out.println("------------------------------");
            mainProcess.depositProcess();
            System.out.println("------------------------------");
        } else if (chooseMenu == 2) {
            System.out.println("------------------------------");
            mainProcess.withdrawalProcess();
            System.out.println("------------------------------");
        } else if (chooseMenu == 3) {
            System.out.println("------------------------------");
            mainProcess.remittanceProcess();
            System.out.println("------------------------------");
        } else {
            System.out.println("잘못된 명령어입니다.");
        }
    }
}
