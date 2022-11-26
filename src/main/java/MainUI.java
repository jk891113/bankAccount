import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainUI {
    MainProcess mainProcess = new MainProcess();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("------------------------------");
        System.out.println("         1. 계좌 등록"); // 이름(name), 계좌번호(accountNum), 비밀번호(password), 은행명(bankName), 등록일자(date), 잔고(amount), 리스트(accountList)
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
            mainProcess.editProcess();
//            break;
        } else if (chooseMenu == 2) {
            mainProcess.deleteProcess();
        }
    }

    public void checkAccount() {
        System.out.println("------------------------------");
        System.out.println("       1. 계좌번호로 조회");
        System.out.println("       2. 소유자명으로 조회");
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
                System.out.println("          소유자명 입력");
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

    public void depositWithdrawal() {
        System.out.println("------------------------------");
        System.out.println("           1. 입금");
        System.out.println("           2. 출금");
        System.out.println("------------------------------");
        System.out.print("번호 입력 : ");
        int chooseMenu = scanner.nextInt();
        if (chooseMenu == 1) {
            mainProcess.depositProcess();
        } else if (chooseMenu == 2) {
            mainProcess.withdrawalProcess();
        }else {
            System.out.println("잘못된 명령어입니다.");
        }

    }

    public void checkAmount() {
        System.out.println("------------------------------");
        System.out.println("       계좌번호를 입력하세요.");
        System.out.println("------------------------------");
        mainProcess.getAmountProcess();
    }
}
