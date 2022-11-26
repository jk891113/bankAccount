import java.util.ArrayList;
import java.util.List;

public class TransInfoList {
    private List<TransInfo> transInfoList = new ArrayList<>();

    public void addTransInfoList(int index, String transDate, String depositWithdrawal, int money, int amount) {
        int transIndex = transInfoList.size();
        transInfoList.add(new TransInfo(index, transIndex, transDate, depositWithdrawal, money, amount));
    }


    public void getTransInfoList() {
        System.out.println("    거래일자 : " + transInfoList.get(2));
        System.out.println("    거래형태 : " + transInfoList.get(3));
        System.out.println("    거래금액 : " + transInfoList.get(4));
        System.out.println("    잔고 : " + transInfoList.get(5));
    }

    public void showAllTransInfoList(int index) {
        for (TransInfo transInfo : transInfoList) {
            System.out.println("No." + transInfo.getTransIndex() + 1);
            System.out.println("    거래일자 : " + transInfo.getTransDate());
            System.out.println("    거래형태 : " + transInfo.getDepositWithdrawal());
            System.out.println("    거래금액 : " + transInfo.getMoney());
            System.out.println("    잔고 : " + transInfo.getAmount());
        }
    }
}
