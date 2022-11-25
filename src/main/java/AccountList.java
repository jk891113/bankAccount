import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accountList = new ArrayList<>();
    // 계좌정보 리스트 생성
    public void addAccount(Account account) {
        accountList.add(account);
    }  // 계좌정보 리스트에 저장

    public void showAllAccount() {
        for (Account accountItem : accountList) {
            System.out.println("No. : " + accountItem);
            System.out.println("생성일자 : " + accountItem.getDate());
            System.out.println("이름 : " + accountItem.getName());
            System.out.println("은행명 : " + accountItem.getBankName());
            System.out.println("계좌번호 : " + accountItem.getAccountNum());
            System.out.println("잔고 : " + accountItem.getAmount());
        }
//        for (int i = 0; i < accountList.size(); i++) {
//            System.out.println(accountList.get(i));
//        }
    }

    public void getAccount() {

    }

    public void updateAccount() {

    }

    public void deleteAccount() {

    }
}
