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
}
