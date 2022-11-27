public class Account {
    private int index;
    private String name;
    private String bankName;
    private String accountNum;
    private String password;
    int amount;
    private String date;

    public Account(int index, String name, String bankName, String accountNum, String password, int amount, String date) {
        this.index = index;
        this.name = name;
        this.bankName = bankName;
        this.accountNum = accountNum;
        this.password = password;
        this.amount = amount;
        this.date = date;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public String getBankName() {
        return bankName;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}


