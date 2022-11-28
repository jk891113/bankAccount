package presentation;

import service.MainProcess;

import java.util.Scanner;

public class CheckAccountUI {
    Scanner scanner = new Scanner(System.in);
    MainProcess mainProcess = new MainProcess();

    public void checkAccount() {
        System.out.println("------------------------------");
        System.out.println("       1. 계좌번호로 조회");
        System.out.println("       2. 예금주명으로 조회");
        System.out.println("       3. 계좌목록 조회");
        System.out.println("       4. 거래내역 조회");
        System.out.println("------------------------------");
        System.out.print("번호 입력 : ");
        int chooseLookup = scanner.nextInt();
        switch (chooseLookup) {
            case 1:
                System.out.println("------------------------------");
                System.out.println("         계좌번호 입력");
                System.out.println("------------------------------");
                mainProcess.checkByAccountNumProcess();
                System.out.println("------------------------------");
                break;
            case 2:
                System.out.println("------------------------------");
                System.out.println("          예금주명 입력");
                System.out.println("------------------------------");
                mainProcess.checkByNameProcess();
                System.out.println("------------------------------");
                break;
            case 3:
                System.out.println("------------------------------");
                System.out.println("           계좌목록");
                System.out.println("------------------------------");
                mainProcess.accountListProcess();
                System.out.println("------------------------------");
                break;
            case 4:
                System.out.println("------------------------------");
                System.out.println("           거래내역");
                System.out.println("------------------------------");
                mainProcess.historyProcess();
                System.out.println("------------------------------");
                break;
            default:
                System.out.println("목록에 해당하는 숫자를 눌러주세요.");
        }
    }
}
