import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainProcess {
    Scanner scanner = new Scanner(System.in);
    AccountList accountList = new AccountList();

    public void createProcess() {
//        // 이름 입력
//        System.out.print("이름 : ");
//        String name = scanner.nextLine();
//        System.out.println();
//        // 은행명 입력
//        System.out.print("은행명 : ");
//        String bankName = scanner.nextLine();
//        System.out.println();
//        // 계좌번호 입력
//        String accountNum;
//        while (true) {
//            System.out.println("계좌번호 형식에 맞춰 작성해주세요. (ex.000-0000-0000)");
//            System.out.print("계좌번호 : ");
//            accountNum = scanner.nextLine();
//            System.out.println();
//            boolean checkNum = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", accountNum);
//            if (checkNum) {
//                break;
//            } else {
//                System.out.println("***계좌번호 형식이 올바르지 않습니다.***");
//                continue;
//            }
//        }
//        // 비밀번호 입력
//        String password;
//        while (true) {
//            System.out.println("4자리 숫자로 작성해주세요.");
//            System.out.print("비밀번호 : ");
//            password = scanner.nextLine();
//            System.out.println();
//            boolean checkPassword = Pattern.matches("\\d{4}", password);
//            if (checkPassword) {
//                break;
//            } else {
//                System.out.println("***비밀번호가 올바르지 않습니다.***");
//                continue;
//            }
//        }
//        // 잔고 입력
//        System.out.print("잔고 : ");
//        String amount = scanner.nextLine();
//        System.out.println();
//
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//        String date = dateTimeFormatter.format(LocalDateTime.now());
//
//        Account account = new Account(name, bankName, accountNum, password, Integer.parseInt(amount), date);
//        accountList.addAccount(account);
//
////        accountList.showAllAccount();
//
//        System.out.println("------------------------------");
//        System.out.println("     이름 : " + account.getName());
//        System.out.println("     은행명 : " + account.getBankName());
//        System.out.println("     계좌번호 : " + account.getAccountNum());
//        System.out.println("     잔고 : " + account.getAmount());
//        System.out.println("------------------------------");
//        System.out.println(date + "에 생성이 완료 되었습니다.");


            //임시로 한꺼번에 입력
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
            String date = dateTimeFormatter.format(LocalDateTime.now());
            //임시로 전부 입력
            Account account = new Account("임시1", "임시은행1", "111-1111-1111", "1111", Integer.parseInt("1000"), date);
            accountList.addAccount(account);

            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
            date = dateTimeFormatter.format(LocalDateTime.now());
            account = new Account("임시2", "임시은행2", "222-2222-2222", "3333", Integer.parseInt("2000"), date);
            accountList.addAccount(account);

            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
            date = dateTimeFormatter.format(LocalDateTime.now());
            account = new Account("임시3", "임시은행3", "333-3333-3333", "3333", Integer.parseInt("3000"), date);
            accountList.addAccount(account);

            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
            date = dateTimeFormatter.format(LocalDateTime.now());
            account = new Account("임시4", "임시은행4", "444-4444-4444", "4444", Integer.parseInt("4000"), date);
            accountList.addAccount(account);


            accountList.showAllAccount();



//        for (Account acc : accountList) {
//            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
//        }
//        for (int i = 0; i < accountList.size(); i++) {
//            System.out.println(accountList.get(i));
//        }
    }

    public void editProcess() {
        System.out.print("계좌번호 : ");
        String accountNum = scanner.nextLine();
        accountList.getAccountByAccountNum(accountNum);
        System.out.println(accountList.getAccountByAccountNum(accountNum));

        System.out.print("비밀번호 : ");
        String password = scanner.nextLine();


        System.out.print("수정 이름 : ");
        String replacename = scanner.nextLine();
        System.out.print("수정 은행: ");
        String replacebankname = scanner.nextLine();
        System.out.print("수정 비밀번호: ");
        String replacepassword = scanner.nextLine();

        accountList.updateAccount(accountNum,password,replacename,replacebankname,replacepassword);
    }


    public void checkByAccountNumProcess() {
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            boolean checkNum = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", accountNum);
            if (checkNum) {
                break;
            } else {
                System.out.println("***계좌번호 형식이 올바르지 않습니다.***");
                continue;
            }
        }
    }
    public void getAccountNumProcess() {
        accountList.showAllAccount();
//        System.out.println(accountList);
//        final HashMap accountItemList = new HashMap();
//        int account = scanner.nextInt();
//        List accountData = (List) accountItemList.get(account);
//        System.out.println("이름 : " + accountData.get(2));
//        System.out.println("은행명 : " + accountData.get(4));
//        System.out.println("계좌번호 : " + accountData.get(3));
//        System.out.println("잔고 : " + accountData.get(1));
//        System.out.println("등록일자 : " + accountData.get(5));
//
//        System.out.println(accountItemList);
    }

    public void deleteProcess()
    {
        System.out.print("계좌번호 : ");
        String accountNum = scanner.nextLine();

        System.out.print("비밀번호 : ");
        String password = scanner.nextLine();
        //계좌번호 삭제
        if (!(accountList.delectAccount(accountNum,password)))
        {
            //계좌번호나 비밀번호가 틀리다면 알림
            System.out.println("계좌를 찾지못했습니다.");
            return;
        }
        return;
    }


    public void showAllProcess(){
        accountList.showAllAccount();
    }

    public void checkByNameProcess() {
        System.out.print("소유자명 : ");
        String name = scanner.nextLine();
    }
    public void getcheckByNameProcess() {

    }


    public void getAccountListProcess() {

    }


    public void getHistoryProcess() {

    }





}

