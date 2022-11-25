import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountList {
    List<Account> accountList = new ArrayList<>();
    // 계좌정보 리스트 생성
    public void addAccount(Account account) {
        accountList.add(account);
    }  // 계좌정보 리스트에 저장

    public void showAllAccount() {
        for (Account acc : accountList) {
            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
        }
    }

    public void updateAccount(String accountNum,String password,String name,String bankname,String newPassword) {
        //현재 입력된 값들 변수 , 처음부터 다시 입력한다고 생각하고 변수 전부 새로 선언
        String replaceName ;
        String replaceBankName ;
        String replaceAccountNum ;
        String replacePassword ;
        int replaceAmount ;
        String replaceDate ;

        //계좌번호,비밀번호 일치여부 체크
        boolean bfindCheck =false;

        //리스트 돌면서 계좌번호 , 비밀번호 일치하는 계좌 검사
        for (int i =0 ; i< accountList.size(); i++) {
            if (accountNum.equals(accountList.get(i).accountNum) && password.equals(accountList.get(i).password))
            {
                //계좌번호, 비밀번호 일치지 수정할 부분들은 대체하고 , (계좌번호,잔고)는 계속유지
                //값 입력
                replaceName = name; //변경값 적용
                replaceBankName = bankname;//변경값 적용
                replaceAccountNum = accountList.get(i).accountNum; //계좌번호는 변경안함
                replacePassword = newPassword;//변경값 적용

                //수정시간 업데이트
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
                String date = dateTimeFormatter.format(LocalDateTime.now());
                replaceDate = date ;

                //수정내용 Account리스트로 구성
                Account replaceAccount = new Account(replaceName, replaceBankName, replaceAccountNum, replacePassword, accountList.get(i).amount, replaceDate);

                accountList.set(i,replaceAccount);

                System.out.print(replaceAccount.getAccountNum() +" : 계좌를 수정합니다.");
                bfindCheck = true;
                return;
            }
        }
        if (bfindCheck ==false)
        {
            System.out.println("계좌를 찾지못했습니다.");
            return;
        }

    }

    public boolean delectAccount(String accountNum , String passWord){
        //가진 리스트를 전부 검사하면서 일치하는 리스트 찾음
        for (int i =0 ; i<accountList.size(); i++) {
            if (accountNum.equals(accountList.get(i).accountNum) && passWord.equals(accountList.get(i).password))
            {
                System.out.print(accountList.get(i).accountNum +" : 계좌를 삭제합니다.");
                System.out.println(i);
                accountList.remove(accountList.remove(i)); //
                return true;
            }
        }
        return false;
    }
}
