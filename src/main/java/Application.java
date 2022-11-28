import presentation.*;
import service.MainProcess;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MainUI mainUI = new MainUI();
        CreateAccountUI createAccountUI = new CreateAccountUI();
        ManageAccountUI manageAccountUI = new ManageAccountUI();
        CheckAccountUI checkAccountUI = new CheckAccountUI();
        CheckAmountUI checkAmountUI = new CheckAmountUI();
        DepositWithdrawalUI depositWithdrawalUI = new DepositWithdrawalUI();
        MainProcess mainProcess = new MainProcess();
        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            mainUI.run();
//            try {
//                System.out.print("번호 입력 : ");
//                String sChooseMain = scanner.nextLine();
//                int chooseMain = Integer.parseInt(sChooseMain);
//                if (chooseMain == 1) {
//                    mainUI.createAccount();
//                } else if (chooseMain == 2) {
//                    mainUI.manageAccount();
//                } else if (chooseMain == 3) {
//                    mainUI.checkAccount();
//                } else if (chooseMain == 4) {
//                    mainUI.checkAmount();
//                } else if (chooseMain == 5) {
//                    mainUI.depositWithdrawal();
//                } else if (chooseMain == 0) {
//                    System.out.println("프로그램을 종료합니다.");
//                    System.exit(0);
//                } else {
//                    System.out.println("잘못된 명령어입니다.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("입력이 올바르지 않습니다.");
//            }
//        }
        while (true) {
            //첫 UI 출력 (0~5의 각기능 표기)
            mainUI.run();
            System.out.print("번호 입력 : ");
            String chooseMain = scanner.nextLine();
            //계좌 등록
            if (chooseMain.equals("1")) {
                createAccountUI.createAccount();
                mainProcess.createProcess();
                //계좌 관리 (계좌 수정, 삭제)
            } else if (chooseMain.equals("2")) {
                manageAccountUI.manageAccount();
                System.out.print("번호 입력 : ");
                String chooseMenu = scanner.nextLine();
                System.out.println();
                if (chooseMenu.equals("1")) {
                    System.out.println("------------------------------");
                    mainProcess.editProcess();
                    System.out.println("------------------------------");
                } else if (chooseMenu.equals("2")) {
                    System.out.println("------------------------------");
                    mainProcess.deleteProcess();
                    System.out.println("------------------------------");
                } else {
                    // 0~5 숫자 외의 숫자입력시 알림
                    System.out.println("잘못된 명령어입니다.");
                }
                    // 계좌 조회 (계좌조회,계좌목록,거래내역)
            } else if (chooseMain.equals("3")) {
                checkAccountUI.checkAccount();
                System.out.print("번호 입력 : ");
                String chooseLookup = scanner.nextLine();
                switch (chooseLookup) {
                    case "1":
                        checkAccountUI.checkAccountByAccountNum();
                        mainProcess.checkByAccountNumProcess();
                        break;
                    case "2":
                        checkAccountUI.checkAccountByName();
                        mainProcess.checkByNameProcess();
                        break;
                    case "3":
                        checkAccountUI.checkAllAccounts();
                        mainProcess.accountListProcess();
                        break;
                    case "4":
                        checkAccountUI.checkTransInfo();
                        mainProcess.historyProcess();
                        break;
                    default:
                        System.out.println("목록에 해당하는 숫자를 눌러주세요.");
                }
                    //잔고확인
            } else if (chooseMain.equals("4")) {
                checkAmountUI.checkAmount();
                mainProcess.getAmountProcess();
                    //입출금, 송금
            } else if (chooseMain.equals("5")) {
                depositWithdrawalUI.depositWithdrawal();
                System.out.print("번호 입력 : ");
                String chooseMenu = scanner.nextLine();
                if (chooseMenu.equals("1")) {
                    System.out.println("------------------------------");
                    mainProcess.depositProcess();
                    System.out.println("------------------------------");
                } else if (chooseMenu.equals("2")) {
                    System.out.println("------------------------------");
                    mainProcess.withdrawalProcess();
                    System.out.println("------------------------------");
                } else if (chooseMenu.equals("3")) {
                    System.out.println("------------------------------");
                    mainProcess.remittanceProcess();
                    System.out.println("------------------------------");
                } else {
                    System.out.println("잘못된 명령어입니다.");
                }
                    // 프로그램 종료
            } else if (chooseMain.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
            } else {
                System.out.println("잘못된 명령어입니다.");
            }
        }
    }
}
