//import java.util.Scanner;
//
//public class FrequentlyUsed {
//    Scanner scanner = new Scanner(System.in);
//    AccountList accountList = new AccountList();
//
//    // 계좌번호 입력 후 AccountList에서 입력한 계좌번호의 계좌정보 리스트의 인덱스를 받는다.
//    public void getIndexByAccountNum(String accountNum) {
//        String accountNum;
//        int index;
//        while (true) {
//            System.out.print("계좌번호 : ");
//            accountNum = scanner.nextLine();
//            System.out.println();
//            index = accountList.getIndexByAccountNum(accountNum);
//            if (index == -1) {
//                System.out.println("계좌번호를 찾을 수 없습니다.");
//            } else {
//                accountList.getAccount(index);
//                break;
//            }
//        }
//    }
//}
