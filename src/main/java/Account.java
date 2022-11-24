import java.util.ArrayList;
import java.util.List;

public class Account {
    private String name;
    private String bankName;
    private String accountNum;
    private String password;
    private int amount;
    private String date;

    public Account(String name, String bankName, String accountNum, String password, int amount, String date) {
        this.name = name;
        this.bankName = bankName;
        this.accountNum = accountNum;
        this.password = password;
        this.amount = amount;
        this.date = date;
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

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
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

    public void setDate(String date) {
        this.date = date;
    }
    public String getDate() {
        return date;
    }
}


