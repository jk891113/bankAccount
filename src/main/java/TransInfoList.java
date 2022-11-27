import java.util.ArrayList;
import java.util.List;

public class TransInfoList {
    private List<TransInfo> transInfoList = new ArrayList<>();

    public void addTransInfoList(int index, String transDate, String depositWithdrawal, int money, int amount) {
        int transIndex = transInfoList.size();
        transInfoList.add(new TransInfo(index, transIndex, transDate, depositWithdrawal, money, amount));
    }


    public void getTransInfoList() {
        int i = transInfoList.size() - 1;
        System.out.println("    거래일자 : " + transInfoList.get(i).transDate);
        System.out.println("    거래형태 : " + transInfoList.get(i).depositWithdrawal);
        System.out.println("    거래금액 : " + transInfoList.get(i).money);
        System.out.println("    잔고 : " + transInfoList.get(i).amount);
    }

    public void showAllTransInfoList(int index) {
        for (TransInfo transInfo : transInfoList) {
            System.out.println("No." + transInfo.getTransIndex());
            System.out.println("    거래일자 : " + transInfo.getTransDate());
            System.out.println("    거래형태 : " + transInfo.getDepositWithdrawal());
            System.out.println("    거래금액 : " + transInfo.getMoney());
            System.out.println("    잔고 : " + transInfo.getAmount());
        }
    }
}
