package entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AccountList {
    private List<Account> accountList = new ArrayList<>();
    TransInfoList transInfoList = new TransInfoList();  // 계좌정보 리스트 생성

    // 계좌정보 리스트에 저장
    public void addAccount(String name, String bankName, String accountName, String password, int amount, String date) {
        int index = accountList.size();
        accountList.add(new Account(index, name, bankName, accountName, password, amount, date));
    }  
    // 전체 계좌 정보 조회
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
    // 계좌 번호를 이용한 Index값 찾기
    public int getIndexByAccountNum(String accountNum) {
        for (Account account : this.accountList) {
            if (account.getAccountNum().equals(accountNum)) //입력한 계좌와 찾은 계좌가 일치하면 Index값 반환
            {
                return account.getIndex();
            }
        }
        return -1;
    }
    // 계좌 예금주 이름을 이용한 Index값 찾기
    public int getIndexByName(String name) {
        for (Account account : this.accountList) {
            if (account.getName().equals(name))  //입력한 계좌의 예금주와 찾은 예금주가 일치하면 Index값 반환
            {
                return account.getIndex();
            }
        }
        return -1;
    }

    // 받은 index의 계좌 정보 출력
    public void getAccount(int index) {
        System.out.println("------------------------------");
        System.out.println("    예금주 : " + accountList.get(index).getName());
        System.out.println("    은행명 : " + accountList.get(index).getBankName());
        System.out.println("    계좌번호 : " + accountList.get(index).getAccountNum());
        System.out.println("------------------------------");
    }
    //계좌 수정기능 (수정할 영역만 따로 이용해서 수정)
    public void editAccountList(int index, String replaceName, String replaceBankName, String replacePassword) {
        accountList.get(index).editName(replaceName); 
        accountList.get(index).editBankName(replaceBankName);
        accountList.get(index).editPassword(replacePassword);
        //수정 날짜 입력
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        System.out.println(date + "에 수정됨.");
    }
    //계좌 삭제기능
    public void deleteAccount(int index) {
        //계좌 거래내역 엔티티에서 먼저 삭제후 계좌 엔티티에서 삭제
        transInfoList.deleteTransInfo((accountList.get(index).getAccountNum())); //계좌 거래내역에서 먼저 삭제
        accountList.remove(index); //계좌 리스트에서 삭제
        System.out.println("해당 계좌를 삭제합니다.");
        
        // 삭제 후 인덱스 번호 재정렬
        for (int i = 0; i < accountList.size(); i++) {
            Account account = accountList.get(i);
            account.arrangeIndex(i);
        }
    }
    //비밀번호 확인, (index에 맞는 비밀번호인지 확인)
    public int passwordCorrection(int index, String password) {
        if (password.equals(accountList.get(index).getPassword())) {
            return 1;
        }
        return 0;
    }
    // 잔고 확인
    public void getAmount(int index) {
        System.out.println("       잔고 : " + accountList.get(index).getAmount());
    }
    // 계좌 거래내역 조회
    public void getHistory(String accountNum) {
        transInfoList.showAllTransInfoList(accountNum);
    }
    // 계좌 입금
    public void deposit(int index, int money) {
        Account target = accountList.get(index);
        if (money >= 0) {
            if (index == target.getIndex()) {
                target.setAmount(target.getAmount() + money);
                //거래 날짜,시간 기록
                DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
                String date = dateTimeFormatter.format(LocalDateTime.now());
                String depositWithdrawal = "입금"; //거래 형태 입력
                //계좌 입금
                transInfoList.addTransInfoList(target.getAccountNum(), date, depositWithdrawal, money, target.amount);
                System.out.println(date + "에 " + money + "원 입금되어" + " 잔액 " + target.amount + "원 입니다.");
            }
        } else {
            System.out.println("잘못된 요청입니다.");
        }
        transInfoList.getTransInfoList();
    }
    // 계좌 출금
    public void withdrawal(int index, int money) {
        Account target = accountList.get(index);
        if (money >= 0 && money < target.getAmount()) {
            target.setAmount((target.getAmount() - money));
            //거래 날짜,시간 기록
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
            String date = dateTimeFormatter.format(LocalDateTime.now());
            String depositWithdrawal = "출금";//거래 형태 입력
            //계좌 출금
            transInfoList.addTransInfoList(target.getAccountNum(), date, depositWithdrawal, money, target.amount);

            System.out.println(date + "에 " + money + "원 출금되어" + " 잔액 " + target.amount + "원 입니다.");
        } else {
            System.out.println("잘못된 요청입니다.");
        }
        transInfoList.getTransInfoList();
    }
}