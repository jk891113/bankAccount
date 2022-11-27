public class TransInfo {
    // 이름, 거래일시, 계좌번호, 입금/출금 여부, 거래금액, 은행명, 잔고
    String accountNum;
    int transIndex;
    String transDate;
    String depositWithdrawal;
    int money;
    int amount;

    public TransInfo(String accountNum, int transIndex, String transDate, String depositWithdrawal, int money, int amount) {
        this.accountNum = accountNum;
        this.transIndex = transIndex;
        this.transDate = transDate;
        this.depositWithdrawal = depositWithdrawal;
        this.money = money;
        this.amount = amount;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setTransIndex(int transIndex) {
        this.transIndex = transIndex;
    }
    public int getTransIndex() {
        return transIndex;
    }

    public void setTransDate(String date) {
        this.transDate = date;
    }
    public String getTransDate() {
        return transDate;
    }
    public void setDepositWithdrawal(String depositWithdrawal) {
        this.depositWithdrawal = depositWithdrawal;
    }
    public String getDepositWithdrawal() {
        return depositWithdrawal;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }


}
