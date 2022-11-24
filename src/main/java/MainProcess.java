import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainProcess {
//    Scanner scanner = new Scanner(System.in);
//    Scanner nameScanner = new Scanner(System.in);
//    Scanner bankNameScanner = new Scanner(System.in);
//    Scanner accountNumScanner = new Scanner(System.in);
//    Scanner passwordScanner = new Scanner(System.in);

        public void createProcess() {
            AccountList accountList1 = new AccountList();
            accountList1.makeAccount();
//            final HashMap accountItemList = new HashMap();
//
//            System.out.print("이름 : ");
//            String name = nameScanner.nextLine();
//
//            System.out.print("은행명 : ");
//            String bankName = bankNameScanner.nextLine();
//
//            String accountNum;
//            while (true) {
//                System.out.println("계좌번호 형식에 맞춰 작성해주세요. (ex.000-0000-0000)");
//                System.out.print("계좌번호 : ");
//                accountNum = accountNumScanner.nextLine();
//                boolean checkNum = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", accountNum);
//                if (checkNum) {
//                    break;
//                } else {
//                    System.out.println("***계좌번호 형식이 올바르지 않습니다.***");
//                    continue;
//                }
//            }
//            String password;
//            while (true) {
//                System.out.println("4자리 숫자로 작성해주세요.");
//                System.out.print("비밀번호 : ");
//                password = passwordScanner.nextLine();
//                boolean checkPassword = Pattern.matches("\\d{4}", password);
//                if (checkPassword) {
//                    break;
//                } else {
//                    System.out.println("***비밀번호가 올바르지 않습니다.***");
//                    continue;
//                }
//            }
//
//            System.out.print("잔고 : ");
//            int amount = scanner.nextInt();
//
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//            String date = dateTimeFormatter.format(LocalDateTime.now());
//
//            Account account = new Account(name, bankName, accountNum, password, amount, date);

//            accountItemList.put("등록일자", date);
//            accountItemList.put("이름", name);
//            accountItemList.put("은행명", bankName);
//            accountItemList.put("계좌번호", accountNum);
//            accountItemList.put("비밀번호", password);
//            accountItemList.put("잔고", amount);

//            System.out.println(Account.getAccountNum());
////            accountList.add(accountItemList);
//
//            System.out.println(accountList);
//            System.out.println(accountItemList);
        }





}
