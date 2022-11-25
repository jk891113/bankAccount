import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accountList = new ArrayList<>();
    TransInfoList transInfoList = new TransInfoList();
    TransInfo transInfo;

    // 계좌정보 리스트 생성

    public void addAccount(String name, String bankName, String accountName, String password, int amount, String date) {
        int index = accountList.size();
        accountList.add(new Account(index, name, bankName, accountName, password, amount, date));
    }  // 계좌정보 리스트에 저장

    public void showAllAccount() {
        for (Account accountItem : accountList) {
            System.out.println("No. : " + accountItem.getIndex());
            System.out.println("생성일자 : " + accountItem.getDate());
            System.out.println("이름 : " + accountItem.getName());
            System.out.println("은행명 : " + accountItem.getBankName());
            System.out.println("계좌번호 : " + accountItem.getAccountNum());
            System.out.println("잔고 : " + accountItem.getAmount());
        }
    }

    public int getIndexByAccountNum(String accountNum) {
        for (Account account : this.accountList) {
            if (account.getAccountNum().equals(accountNum)) {
                return account.getIndex();
            }
        }
        return -1;
    }

    public int getIndexByName(String name) {
        for (Account account : this.accountList) {
            if (account.getName().equals(name)) {
                return account.getIndex();
            }
        }
        return -1;
    }

    public void getAccount(int accountListIndex) {
        System.out.println("------------------------------");
        System.out.println("이름 : " + accountList.get(accountListIndex).getName());
        System.out.println("은행명 : " + accountList.get(accountListIndex).getBankName());
        System.out.println("계좌번호 : " + accountList.get(accountListIndex).getAccountNum());
        System.out.println("------------------------------");
    }

    public void editAccountList(int index, String replaceName, String replaceBankName, String replacePassword) {
        for (Account account : this.accountList) {
            if (index == account.getIndex()) {
            account.setName(replaceName);
            account.setBankName(replaceBankName);
            account.setPassword(replacePassword);
            System.out.println(account.getAccountNum() + "의 계좌를 수정합니다.");
            break;
            }
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        System.out.println(date + "에 수정됨.");
    }

//    public void updateAccount(int index, String newName,String newBankname,String newPassword) {
//        //현재 입력된 값들 변수 , 처음부터 다시 입력한다고 생각하고 변수 전부 새로 선언
//        String replaceName ;
//        String replaceBankName ;
//        String replaceAccountNum ;
//        String replacePassword ;
//        int replaceAmount ;
//        String replaceDate ;
//
//        //계좌번호,비밀번호 일치여부 체크
//        boolean bfindCheck =false;
//
//
//        //리스트 돌면서 계좌번호 , 비밀번호 일치하는 계좌 검사
//        for (Account account : this.accountList) {
//            if (index == account.getIndex())
//            {
//                //계좌번호, 비밀번호 일치지 수정할 부분들은 대체하고 , (계좌번호,잔고)는 계속유지
//                //값 입력
//                replaceName = newName; //변경값 적용
//                replaceBankName = newBankname;//변경값 적용
//                replaceAccountNum = account.getAccountNum(); //계좌번호는 변경안함
//                replacePassword = newPassword;//변경값 적용
//                replaceAmount = account.getAmount();
//
//                //수정시간 업데이트
//                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//                String date = dateTimeFormatter.format(LocalDateTime.now());
//                replaceDate = date ;
//
//                //수정내용 Account리스트로 구성
//                Account replaceAccount = new Account(index,replaceName, replaceBankName, replaceAccountNum, replacePassword, replaceAmount, replaceDate);
//
//                accountList.set(index,replaceAccount);
//
//                System.out.println(replaceAccount.getAccountNum() +" : 계좌를 수정합니다.");
//                bfindCheck = true;
//                return;
//            }
//        }
//        if (bfindCheck ==false)
//        {
//            System.out.println("계좌를 찾지못했습니다.");
//            return;
//        }


//    }

    public boolean delectAccount(int index){
        for (Account account : this.accountList) {
            if (index == account.getIndex()) {
                System.out.println(account.getAccountNum() + " : 계좌를 삭제합니다.");
                accountList.remove(index);
                return true;
            }
        }
        return false;
    }


    public int passwordCorrection(int index, String password) {
        if(password.equals(accountList.get(index).getPassword())) {
            return 1;
        }
        return 0;
    }

    public void getAmount(int index) {
        System.out.println("------------------------------");
        System.out.println("       잔고 : " + accountList.get(index).getAmount());
        System.out.println("------------------------------");
    }


    public boolean getAccountNum(String accountNum) {
        for (Account account : accountList) {
            if (accountNum.equals(account.getAccountNum())) {
                System.out.println("------------------------------");
                System.out.println("  소유자명 : " + account.getName());
                System.out.println("  계좌번호 : " + account.getAccountNum());
                System.out.println("  잔고 : " + account.getAmount());
                System.out.println("------------------------------");
                break;
            }
        }
        return false;
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
                break;
            }
        }
        return false;
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
            System.out.println("  거래일자 : ");
            System.out.println("  거래시간 : ");
            System.out.println("  입금금액 : ");
            System.out.println("  출금금액: ");
            System.out.println("------------------------------");
        }
    }

    public void deposit(int index, int money) {
        for (Account account: this.accountList) {
            if (index == account.getIndex()) {
                account.setAmount((account.getAmount() + money));

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
                String date = dateTimeFormatter.format(LocalDateTime.now());
                String depositWithdrawal = "Deposit";
                transInfoList.addTransInfoList(index, date, depositWithdrawal, money, account.amount);

                System.out.println(date + "에 " + money + "원 입금되어" + " 잔액 " + account.amount + "원 입니다.");
            }
        }
    }

    public void withdrawal(int index, int money) {
        for (Account account: this.accountList) {
            if (index == account.getIndex()) {
                account.setAmount((account.getAmount() - money));

                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
                String date = dateTimeFormatter.format(LocalDateTime.now());
                String depositWithdrawal = "Withdrawal";
                transInfoList.addTransInfoList(index, date, depositWithdrawal, money, account.amount);

                System.out.println(date + "에 " + money + "원 입금되어" + " 잔액 " + account.amount + "원 입니다.");
            }
        }
    }
}

