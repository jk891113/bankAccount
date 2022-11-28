package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accountList = new ArrayList<>();
    TransInfoList transInfoList = new TransInfoList();  // 계좌정보 리스트 생성

    public void addAccount(String name, String bankName, String accountName, String password, int amount, String date) {
        int index = accountList.size();
        accountList.add(new Account(index, name, bankName, accountName, password, amount, date));
    }  // 계좌정보 리스트에 저장

    public void showAllAccount() {
        for (Account account : accountList) {
            System.out.println("No. : " + account.getIndex());
            System.out.println("생성일자 : " + account.getDate());
            System.out.println("예금주 : " + account.getName());
            System.out.println("은행명 : " + account.getBankName());
            System.out.println("계좌번호 : " + account.getAccountNum());
            System.out.println("잔고 : " + account.getAmount());
            System.out.println();
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

    public void getAccount(int index) {
        System.out.println("------------------------------");
        System.out.println("    예금주 : " + accountList.get(index).getName());
        System.out.println("    은행명 : " + accountList.get(index).getBankName());
        System.out.println("    계좌번호 : " + accountList.get(index).getAccountNum());
        System.out.println("------------------------------");
    }

    public void editAccountList(int index, String replaceName, String replaceBankName, String replacePassword) {
        accountList.get(index).editName(replaceName);
        accountList.get(index).editBankName(replaceBankName);
        accountList.get(index).editPassword(replacePassword);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        System.out.println(date + "에 수정됨.");
    }

    public void deleteAccount(int index) {
        transInfoList.deleteTransInfo((accountList.get(index).getAccountNum()));
        accountList.remove(index);
        System.out.println("해당 계좌를 삭제합니다.");


        // 삭제 후 인덱스 번호 재정렬
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            account.arrangeIndex(i);
        }
    }

    public int passwordCorrection(int index, String password) {
        if (password.equals(accountList.get(index).getPassword())) {
            return 1;
        }
        return 0;
    }

    public void getAmount(int index) {
        System.out.println("       잔고 : " + accountList.get(index).getAmount());
    }

    public void getHistory(String accountNum) {
        transInfoList.showAllTransInfoList(accountNum);
    }

    public void deposit(int index, int money) {
        Account target = accountList.get(index);
        if (money >= 0) {
            if (index == target.getIndex()) {
                target.setAmount(target.getAmount() + money);
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
                String date = dateTimeFormatter.format(LocalDateTime.now());
                String depositWithdrawal = "입금";
                transInfoList.addTransInfoList(target.getAccountNum(), date, depositWithdrawal, money, target.amount);
                System.out.println(date + "에 " + money + "원 입금되어" + " 잔액 " + target.amount + "원 입니다.");
            }
        } else {
            System.out.println("잘못된 요청입니다.");
        }
        transInfoList.getTransInfoList();
    }

    public void withdrawal(int index, int money) {
        Account target = accountList.get(index);
        if (money >= 0 && money < target.getAmount()) {
            target.setAmount((target.getAmount() - money));

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
            String date = dateTimeFormatter.format(LocalDateTime.now());
            String depositWithdrawal = "출금";
            transInfoList.addTransInfoList(target.getAccountNum(), date, depositWithdrawal, money, target.amount);

            System.out.println(date + "에 " + money + "원 출금되어" + " 잔액 " + target.amount + "원 입니다.");
        } else {
            System.out.println("잘못된 요청입니다.");
        }
        transInfoList.getTransInfoList();
    }
}