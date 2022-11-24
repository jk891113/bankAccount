import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class AccountList {
    Scanner scanner = new Scanner(System.in);
    Scanner nameScanner = new Scanner(System.in);
    Scanner bankNameScanner = new Scanner(System.in);
    Scanner accountNumScanner = new Scanner(System.in);
    Scanner passwordScanner = new Scanner(System.in);
    private List<Account> accountList = new ArrayList<>();

    // 계좌생성 메소드
    public void makeAccount() {

        System.out.print("이름 : ");
        String name = nameScanner.nextLine();

        System.out.print("은행명 : ");
        String bankName = bankNameScanner.nextLine();

        String accountNum;
        while (true) {
            System.out.println("계좌번호 형식에 맞춰 작성해주세요. (ex.000-0000-0000)");
            System.out.print("계좌번호 : ");
            accountNum = accountNumScanner.nextLine();
            boolean checkNum = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", accountNum);
            if (checkNum) {
                break;
            } else {
                System.out.println("***계좌번호 형식이 올바르지 않습니다.***");
                continue;
            }
        }
        String password;
        while (true) {
            System.out.println("4자리 숫자로 작성해주세요.");
            System.out.print("비밀번호 : ");
            password = passwordScanner.nextLine();
            boolean checkPassword = Pattern.matches("\\d{4}", password);
            if (checkPassword) {
                break;
            } else {
                System.out.println("***비밀번호가 올바르지 않습니다.***");
                continue;
            }
        }

        System.out.print("잔고 : ");
        int amount = scanner.nextInt();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        Account account = new Account(name, bankName, accountNum, password, amount, date);

//        int num = accountList.size() + 1;

        for (Account acc : accountList) {
            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
        }
    }

    public void addAccount(Account account) {
        accountList.add(account);
        System.out.println(accountList);
    }
}
