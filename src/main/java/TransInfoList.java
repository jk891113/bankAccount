import java.util.ArrayList;
import java.util.List;

public class TransInfoList {
    private List<TransInfo> transInfoList = new ArrayList<>();

    public void addTransInfoList(TransInfo transInfo) {
        transInfoList.add(transInfo);
    }


    public void getTransInfoList(int index) {

    }

    public void showAllTransInfoList() {
        for (TransInfo transInfo : transInfoList) {
            System.out.print("No. : " + transInfo.getTransIndex());
            System.out.print(" 이름 : " + transInfo.getName());
            System.out.print(" 은행명 : " + transInfo.getBankName());
            System.out.print(" 계좌번호 : " + transInfo.getAccountNum());
            System.out.print(" 일자 : " + transInfo.getDate());
            System.out.print(" 입금/출금 : " + transInfo.getDepositWithdrawal());
            System.out.print(" 거래금액 : " + transInfo.getMoney());
            System.out.print(" 잔고 : " + transInfo.getAmount());
        }
    }
}
