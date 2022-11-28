package presentation;

import service.MainProcess;

import java.util.Scanner;

public class ManageAccountUI {
    Scanner scanner = new Scanner(System.in);
    MainProcess mainProcess = new MainProcess();

    public void manageAccount() {
        System.out.println("------------------------------");
        System.out.println("         1. 계좌 수정");
        System.out.println("         2. 계좌 삭제");
        System.out.println("------------------------------");
        System.out.print("번호 입력 : ");
        int chooseMenu = scanner.nextInt();
        System.out.println();
        if (chooseMenu == 1) {
            System.out.println("------------------------------");
            mainProcess.editProcess();
            System.out.println("------------------------------");
        } else if (chooseMenu == 2) {
            System.out.println("------------------------------");
            mainProcess.deleteProcess();
            System.out.println("------------------------------");
        } else {
            System.out.println("잘못된 명령어입니다.");
        }
    }
}
