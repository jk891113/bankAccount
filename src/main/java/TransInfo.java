public class TransInfo {
    // 거래일시, 계좌번호, 입금/출금 여부, 거래금액, 은행명
    String bankName;
    String accountNum;
    String date;
    String depositWithdrawal;
    int money;

    public TransInfo(String bankName, String accountNum, String date, String depositWithdrawal, int money) {
        this.bankName = bankName;
        this.accountNum = accountNum;
        this.date = date;
        this.depositWithdrawal = depositWithdrawal;
        this.money = money;
    }
}
