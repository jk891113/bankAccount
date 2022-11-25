public class TransInfo {
    // 이름, 거래일시, 계좌번호, 입금/출금 여부, 거래금액, 은행명
    String name;
    String bankName;
    String password;
    String accountNum;
    String transDate;
    String depositWithdrawal;
    int money;
    int amount;


    public TransInfo(String name, String bankName, String password, String accountNum, String date, String depositWithdrawal, int money, int amount) {
        this.name = name;
        this.bankName = bankName;
        this.password = password;
        this.accountNum = accountNum;
        this.transDate = date;
        this.depositWithdrawal = depositWithdrawal;
        this.money = money;
        this.amount = amount;
    }
}
