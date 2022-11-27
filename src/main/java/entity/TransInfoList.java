package entity;

import java.util.ArrayList;
import java.util.List;

public class TransInfoList {
    private List<TransInfo> transInfoList = new ArrayList<>();

    public void addTransInfoList(String accountNum, String transDate, String depositWithdrawal, int money, int amount) {
        int transIndex = transInfoList.size();
        transInfoList.add(new TransInfo(accountNum, transIndex, transDate, depositWithdrawal, money, amount));
    }


    public void getTransInfoList() {
        int i = transInfoList.size() - 1;
        System.out.println("    거래일자 : " + transInfoList.get(i).transDate);
        System.out.println("    거래형태 : " + transInfoList.get(i).depositWithdrawal);
        System.out.println("    거래금액 : " + transInfoList.get(i).money);
        System.out.println("    잔고 : " + transInfoList.get(i).amount);
    }

    public void showAllTransInfoList(String accountNum) {
        System.out.println("계좌번호 : " + accountNum);
        for (TransInfo transInfo : transInfoList) {
            if (accountNum.equals(transInfo.getAccountNum())) {
                System.out.println("No." + transInfo.getTransIndex());
                System.out.println("    거래일자 : " + transInfo.getTransDate());
                System.out.println("    거래형태 : " + transInfo.getDepositWithdrawal());
                System.out.println("    거래금액 : " + transInfo.getMoney());
                System.out.println("    잔고 : " + transInfo.getAmount());
            }
        }
    }

    public void deleteTransInfo(String accountNum) {
        for (int i = transInfoList.size() - 1; i >= 0; i--) {
            if (accountNum.equals((transInfoList.get(i).getAccountNum()))) {
                transInfoList.remove(transInfoList.get(i).getTransIndex());
            }
        }
        System.out.println("해당 계좌의 거래내역을 삭제합니다.");

        for (int i = 0; i < transInfoList.size(); i++) {
            TransInfo transInfo = transInfoList.get(i);
            transInfo.arrangeTransIndex(i);
        }
    }
}
