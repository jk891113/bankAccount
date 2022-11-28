package entity;

public class Account {
    private int index; //인덱스
    private String name; //예금주 이름
    private String bankName; // 은행이름
    private final String accountNum; // 계좌 번호
    private String password; // 계좌 비밀번호
    int amount; //잔고 금액
    private final String date; // 날짜 

    public Account(int index, String name, String bankName, String accountNum, String password, int amount, String date) {
        this.index = index;
        this.name = name;
        this.bankName = bankName;
        this.accountNum = accountNum;
        this.password = password;
        this.amount = amount;
        this.date = date;
    }

    // index값 입력
    public void arrangeIndex(int index) {
        this.index = index;
    }

    // index값 반환
    public int getIndex() {
        return index;
    }

    // 예금주 이름 입력
    public void editName(String name) {
        this.name = name;
    }

    // 예금주 이름 반환
    public String getName() {
        return name;
    }

    // 은행명 이름 입력
    public void editBankName(String bankName) {
        this.bankName = bankName;
    }

    //은행명 이름 반환
    public String getBankName() {
        return bankName;
    }

    // 계좌 번호 반환
    public String getAccountNum() {
        return accountNum;
    }

    // 계좌 비밀번호 입력
    public void editPassword(String password) {
        this.password = password;
    }

    // 계좌 비밀번호 반환
    public String getPassword() {
        return password;
    }

    // 잔고 금액 입력
    public void setAmount(int amount) {
        this.amount = amount;
    }

    // 잔고 금액 반환
    public int getAmount() {
        return amount;
    }

    // 날짜 반환
    public String getDate() {
        return date;
    }
}


