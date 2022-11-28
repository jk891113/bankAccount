package presentation;

public class CheckAccountUI {

    public void checkAccount() {
        System.out.println("------------------------------");
        System.out.println("       1. 계좌번호로 조회");
        System.out.println("       2. 예금주명으로 조회");
        System.out.println("       3. 계좌목록 조회");
        System.out.println("       4. 거래내역 조회");
        System.out.println("------------------------------");
    }

    public void checkAccountByAccountNum() {
        System.out.println("------------------------------");
        System.out.println("         계좌번호 입력");
        System.out.println("------------------------------");
    }

    public void checkAccountByName() {
        System.out.println("------------------------------");
        System.out.println("          예금주명 입력");
        System.out.println("------------------------------");
    }

    public void checkAllAccounts() {
        System.out.println("------------------------------");
        System.out.println("           계좌목록");
        System.out.println("------------------------------");
    }

    public void checkTransInfo() {
        System.out.println("------------------------------");
        System.out.println("           거래내역");
        System.out.println("------------------------------");
    }
}
