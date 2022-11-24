import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accountList = new ArrayList<>();
    // 계좌정보 리스트 생성
    public void addAccount(Account account) {
        accountList.add(account);
    }  // 계좌정보 리스트에 저장

    public void showAllAccount() {
//        System.out.println(accountList);
//        for (Account acc : accountList) {
//            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
//        }
//        for (int i = 0; i < accountList.size(); i++) {
//            System.out.println(accountList.get(i));
//        }
    }

    public void updateAccount() {

    }

    public void deleteAccount() {

    }
}
