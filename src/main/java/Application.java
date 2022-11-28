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
            //첫 UI 출력 (0~5의 각기능 표기)
            mainUI.run();
            try {
                System.out.print("번호 입력 : ");
                String sChooseMain = scanner.nextLine();
                //예외처리를 위해서 강제변환
                int chooseMain = Integer.parseInt(sChooseMain);
                if (chooseMain == 1) {
                    //계좌 등록
                    createAccountUI.createAccount();
                } else if (chooseMain == 2) {
                    //계좌 관리 (계좌 수정, 삭제)
                    manageAccountUI.manageAccount();
                } else if (chooseMain == 3) {
                    // 계좌 조회 (계좌조회,계좌목록,거래내역)
                    checkAccountUI.checkAccount();
                } else if (chooseMain == 4) {
                    //잔고확인
                    checkAmountUI.checkAmount();
                } else if (chooseMain == 5) {
                    //입출금, 송금
                    depositWithdrawalUI.depositWithdrawal();
                } else if (chooseMain == 0) {
                    // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                } else {
                    // 0~5 숫자 외의 숫자입력시 알림
                    System.out.println("잘못된 명령어입니다.");
                }
            }
            //문자 입력시 예외처리
            catch (NumberFormatException e) {
                System.out.println("입력이 올바르지 않습니다.");
            }
        }
    }
}
