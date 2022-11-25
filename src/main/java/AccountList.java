import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accountList = new ArrayList<>();

    // 계좌정보 리스트 생성
    public void addAccount(Account account) {
        accountList.add(account);
    }  // 계좌정보 리스트에 저장

    public void showAllAccount() {
        for (Account acc : accountList) {
            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
        }
    }

    public void updateAccount(String accountNum, String password, String name, String bankname, String newPassword) {
        //현재 입력된 값들 변수 , 처음부터 다시 입력한다고 생각하고 변수 전부 새로 선언
        String replaceName;
        String replaceBankName;
        String replaceAccountNum;
        String replacePassword;
        int replaceAmount;
        String replaceDate;

        //계좌번호,비밀번호 일치여부 체크
        boolean bfindCheck = false;

        //리스트 돌면서 계좌번호 , 비밀번호 일치하는 계좌 검사
        for (Account acc : accountList) {
            if (accountNum.equals(acc.getAccountNum()) && password.equals(acc.getPassword())) {
                //계좌번호, 비밀번호 일치지 수정할 부분들은 대체하고 , (계좌번호,잔고)는 계속유지
                //값 입력
                replaceName = name; //변경값 적용
                replaceBankName = bankname;//변경값 적용
                replaceAccountNum = acc.getAccountNum(); //계좌번호는 변경안함
                replacePassword = newPassword;//변경값 적용

                //수정시간 업데이트
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
                String date = dateTimeFormatter.format(LocalDateTime.now());
                replaceDate = date;

                //수정내용 Account리스트로 구성
                Account replaceAccount = new Account(replaceName, replaceBankName, replaceAccountNum, replacePassword, acc.getAmount(), replaceDate);

//                삭제후 재생성... 이부분근데 좀 불안하다.
                accountList.remove(acc); //
                accountList.add(replaceAccount);

                System.out.print(replaceAccount.getAccountNum() + " : 계좌를 수정합니다.");
                bfindCheck = true;
                return;
            }
        }
        if (bfindCheck == false) {
            System.out.println("계좌를 찾지못했습니다.");
            return;
        }

    }

    public boolean delectAccount(String accountNum, String passWord) {
        //가진 리스트를 전부 검사하면서 일치하는 리스트 찾음
        for (Account acc : accountList) {
            if (accountNum.equals(acc.getAccountNum()) && passWord.equals(acc.getPassword())) {
                System.out.print(acc.getAccountNum() + " : 계좌를 삭제합니다.");
                accountList.remove(acc); //
                return true;
            }
        }
        return false;
    }

    public boolean getAccountNum(String accountNum) {
        for (Account account : accountList) {
            if (accountNum.equals(account.getAccountNum())) {
                System.out.println("------------------------------");
                System.out.println("  소유자명 : " + account.getName());
                System.out.println("  계좌번호 : " + account.getAccountNum());
                System.out.println("  잔고 : " + account.getAmount());
                System.out.println("------------------------------");
            }
        }
        return true;
    }

    public boolean getCheckByName(String name) {
        for (Account account : accountList) {
            if (name.equals(account.getName())) {
                System.out.println("------------------------------");
                System.out.println("  은행명 : " + account.getBankName());
                System.out.println("  계좌번호 : " + account.getAccountNum());
                System.out.println("  잔고 : " + account.getAmount());
                System.out.println("  거래일자 : " + account.getDate());
                System.out.println("------------------------------");
            }
        }
        return true;
    }

    public void getAccountList() {
        for (Account account : accountList) {
            System.out.println("------------------------------");
            System.out.println("  소유자명 : " + account.getBankName());
            System.out.println("  은행명 : " + account.getBankName());
            System.out.println("  계좌번호 : " + account.getAccountNum());
            System.out.println("  잔고 : " + account.getAmount());
            System.out.println("  입금내역 : " + account.getDate());
            System.out.println("  입출금내역 : " + account.getDate());
            System.out.println("  거래일자 : " + account.getDate());
            System.out.println("------------------------------");
        }
    }

    public void getHistory() {
        for (Account account : accountList) {
            System.out.println("------------------------------");
            System.out.println("  계좌번호 : " + account.getAccountNum());
            System.out.println("  은행명 : " + account.getBankName());
            System.out.println("  거래일자 : " );
            System.out.println("  거래시간 : " );
            System.out.println("  입금금액 : " );
            System.out.println("  출금금액: " );
            System.out.println("------------------------------");
        }
    }
}