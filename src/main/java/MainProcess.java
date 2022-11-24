import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainProcess {
    Scanner scanner = new Scanner(System.in);
    AccountList accountList = new AccountList();

    public void createProcess() {
        // 이름 입력
        System.out.print("이름 : ");
        String name = scanner.nextLine();
        System.out.println();
        // 은행명 입력
        System.out.print("은행명 : ");
        String bankName = scanner.nextLine();
        System.out.println();
        // 계좌번호 입력
        String accountNum;
        while (true) {
            System.out.println("계좌번호 형식에 맞춰 작성해주세요. (ex.000-0000-0000)");
            System.out.print("계좌번호 : ");
            accountNum = scanner.nextLine();
            System.out.println();
            boolean checkNum = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", accountNum);
            if (checkNum) {
                break;
            } else {
                System.out.println("***계좌번호 형식이 올바르지 않습니다.***");
                continue;
            }
        }
        // 비밀번호 입력
        String password;
        while (true) {
            System.out.println("4자리 숫자로 작성해주세요.");
            System.out.print("비밀번호 : ");
            password = scanner.nextLine();
            System.out.println();
            boolean checkPassword = Pattern.matches("\\d{4}", password);
            if (checkPassword) {
                break;
            } else {
                System.out.println("***비밀번호가 올바르지 않습니다.***");
                continue;
            }
        }
        // 잔고 입력
        System.out.print("잔고 : ");
        String amount = scanner.nextLine();
        System.out.println();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        Account account = new Account(name, bankName, accountNum, password, Integer.parseInt(amount), date);
        accountList.addAccount(account);

        accountList.showAllAccount();

        System.out.println("------------------------------");
        System.out.println("     이름 : " + account.getName());
        System.out.println("     은행명 : " + account.getBankName());
        System.out.println("     계좌번호 : " + account.getAccountNum());
        System.out.println("     잔고 : " + account.getAmount());
        System.out.println("------------------------------");
        System.out.println(date + "에 생성이 완료 되었습니다.");

//        for (Account acc : accountList) {
//            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
//        }
//        for (int i = 0; i < accountList.size(); i++) {
//            System.out.println(accountList.get(i));
//        }
    }

    public void editProcess() {

    }
}

