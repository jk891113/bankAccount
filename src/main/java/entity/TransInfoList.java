package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TransInfoList {
    private List<TransInfo> transInfoList = new ArrayList<>();

    // TransInfo형식의 리스트를 추가
    public void addTransInfoList(String accountNum, String transDate, String depositWithdrawal, int money, int amount) {
        int transIndex = transInfoList.size();
        transInfoList.add(new TransInfo(accountNum, transIndex, transDate, depositWithdrawal, money, amount));
    }

    // 거래시 내역 조회
    public void getTransInfoList() {
        int i = transInfoList.size() - 1;
        System.out.println("    거래일자 : " + transInfoList.get(i).transDate);
        System.out.println("    거래형태 : " + transInfoList.get(i).depositWithdrawal);
        System.out.println("    거래금액 : " + transInfoList.get(i).money);
        System.out.println("    잔고 : " + transInfoList.get(i).amount);
    }
    // 전체 계좌 내역 조회
    public void showAllTransInfoList(String accountNum) {
        for (TransInfo transInfo : transInfoList) {
            if (accountNum.equals(transInfo.getAccountNum())) {
                System.out.println("계좌번호 : " + transInfo.getAccountNum());
                System.out.println("No." + transInfo.getTransIndex());
                System.out.println("    거래일자 : " + transInfo.getTransDate());
                System.out.println("    거래형태 : " + transInfo.getDepositWithdrawal());
                System.out.println("    거래금액 : " + transInfo.getMoney());
                System.out.println("    잔고 : " + transInfo.getAmount());
            }
        }
    }
    // 계좌 내역 삭제
    public void deleteTransInfo(String accountNum) {
        // 삭제하는 계좌번호와 비교해서 거래내역 삭제
        for (int i = transInfoList.size() - 1; i >= 0; i--) {
            TransInfo target = transInfoList.get(i);
            if (accountNum.equals(target.getAccountNum())) {
                transInfoList.remove(target);
            }
        }
        System.out.println("해당 계좌의 거래내역을 삭제합니다.");
        // 삭제후 index 재정렬
        for (int i = 0; i < transInfoList.size(); i++) {
            TransInfo transInfo = transInfoList.get(i);
            transInfo.arrangeTransIndex(i);
        }
    }
}
