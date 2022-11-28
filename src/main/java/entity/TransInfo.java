package entity;

public class TransInfo {
    // 이름, 거래일시, 계좌번호, 입금/출금 여부, 거래금액, 은행명, 잔고
    String accountNum; // 계좌 번호
    int transIndex; // 인덱스
    String transDate; // 거래 날짜
    String depositWithdrawal; // 입출금 여부
    int money; //거래 금액
    int amount; //잔고 금액

    public TransInfo(String accountNum, int transIndex, String transDate, String depositWithdrawal, int money, int amount) {
        this.accountNum = accountNum;
        this.transIndex = transIndex;
        this.transDate = transDate;
        this.depositWithdrawal = depositWithdrawal;
        this.money = money;
        this.amount = amount;
    }
    // 계좌번호 반환
    public String getAccountNum() {
        return accountNum;
    }
    // 사용 index 설정 (Account의 index를 이용하기 위해)
    public void arrangeTransIndex(int transIndex) {
        this.transIndex = transIndex;
    }
    //transindex 반환
    public int getTransIndex() {
        return transIndex;
    }
    //날짜 반환
    public String getTransDate() {
        return transDate;
    }
    //입출금 여부 반환
    public String getDepositWithdrawal() {
        return depositWithdrawal;
    }
    //거래 금액 반환
    public int getMoney() {
        return money;
    }
    //잔고 금액 반환
    public int getAmount() {
        return amount;
    }


}
