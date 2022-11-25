public class TransInfo {
    // 이름, 거래일시, 계좌번호, 입금/출금 여부, 거래금액, 은행명, 잔고
    int index;
    int transIndex;
    String name;
    String bankName;
    String password;
    String accountNum;
    String transDate;
    String depositWithdrawal;
    int money;
    int amount;


    public TransInfo(int index, int transIndex, String name, String bankName, String password, String accountNum, String date, String depositWithdrawal, int money, int amount) {
        this.index = index;
        this.transIndex = transIndex;
        this.name = name;
        this.bankName = bankName;
        this.password = password;
        this.accountNum = accountNum;
        this.transDate = date;
        this.depositWithdrawal = depositWithdrawal;
        this.money = money;
        this.amount = amount;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }

    public void setTransIndex(int transIndex) {
        this.transIndex = transIndex;
    }
    public int getTransIndex() {
        return transIndex;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBankName(String bankName) {
        this.name = bankName;
    }
    public String getBankName() {
        return bankName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    public String getAccountNum() {
        return accountNum;
    }
    public void setDate(String date) {
        this.transDate = date;
    }
    public String getDate() {
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
