import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainUI {
    MainProcess mainProcess = new MainProcess();

    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("------------------------------");
        System.out.println("         1. 계좌 등록"); // 이름(name), 계좌번호(accountNum), 비밀번호(password), 은행명(bankName), 등록일자(date), 잔고(amount), 해시맵(accountItemList), 리스트(accountList)
        System.out.println("         2. 계좌 관리"); // 삭제, 수정 (수정일자)
        System.out.println("         3. 계좌 조회"); // 번호(accountNum)로, 이름(name)으로 조회 | 거래내역( 거래일자, 시간, 계좌번호, 입출금여부, 거래금액, 은행명), 계좌목록
        System.out.println("         4. 잔고 확인"); // 소유주만 가능하게
        System.out.println("         5. 입출금하기"); // 입금, 출금 (입출금 일자)
        System.out.println("         0. 시스템종료");
        System.out.println("------------------------------");
    }

    public void createAccount() {
        System.out.println("------------------------------");
        System.out.println("      계좌 정보를 입력하세요");
        System.out.println("------------------------------");
        mainProcess.createProcess();
    }

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
            System.out.println("       계좌번호를 입력하세요.");
            System.out.println("------------------------------");
            mainProcess.editProcess();
//            break;
        } else if (chooseMenu == 2) {
            System.out.println("------------------------------");
            System.out.println("       계좌번호를 입력하세요.");
            System.out.println("------------------------------");
        }
    }

    public void checkAccount() {
        System.out.println("------------------------------");
        System.out.println("       1. 계좌번호로 조회");
        System.out.println("       2. 이름으로 조회");
        System.out.println("       3. 거래내역 조회");
        System.out.println("       4. 계좌 목록 조회");
        System.out.println("------------------------------");
    }

    public void checkAmount() {
        System.out.println("------------------------------");
        System.out.println("       계좌번호를 입력하세요.");
        System.out.println("------------------------------");
    }

    public void depositWithdrawal() {
        System.out.println("------------------------------");
        System.out.println("           1. 입금");
        System.out.println("           2. 출금");
        System.out.println("------------------------------");
    }
}
