import java.util.ArrayList;
import java.util.List;

public class TransInfoList {
    private List<TransInfo> transInfoList = new ArrayList<>();

    public void addTransInfoList(int index, String transDate, String depositWithdrawal, int money, int amount) {
        int transIndex = transInfoList.size();
        transInfoList.add(new TransInfo(index, transIndex, transDate, depositWithdrawal, money, amount));
    }


    public void getTransInfoList(int index) {

    }

    public void showAllTransInfoList() {
        for (TransInfo transInfo : transInfoList) {
            System.out.print("No. : " + transInfo.getTransIndex());
            System.out.print(" 일자 : " + transInfo.getTransDate());
            System.out.print(" 입금/출금 : " + transInfo.getDepositWithdrawal());
            System.out.print(" 거래금액 : " + transInfo.getMoney());
            System.out.print(" 잔고 : " + transInfo.getAmount());
        }
    }
}
