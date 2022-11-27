import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainProcess {
    Scanner scanner = new Scanner(System.in);
    AccountList accountList = new AccountList();
    TransInfoList transInfo = new TransInfoList();

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
            }
        }
        // 잔고 입력
        System.out.print("잔고 : ");
        String amount = scanner.nextLine();
        System.out.println();

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        accountList.addAccount(name, bankName, accountNum, password, Integer.parseInt(amount), date);





//        accountList.showAllAccount();

//        System.out.println("------------------------------");
//        System.out.println("     이름 : " + accout.getName());
//        System.out.println("     은행명 : " + account.getBankName());
//        System.out.println("     계좌번호 : " + account.getAccountNum());
//        System.out.println("     잔고 : " + account.getAmount());
//        System.out.println("------------------------------");
//        System.out.println(date + "에 생성이 완료 되었습니다.");


//            //임시로 한꺼번에 입력
//            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//            String date = dateTimeFormatter.format(LocalDateTime.now());
//            //임시로 전부 입력
//            accountList.addAccount("임시1", "임시은행1", "111-1111-1111", "1111", Integer.parseInt("1000"), date);
//
//            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//            date = dateTimeFormatter.format(LocalDateTime.now());
//            accountList.addAccount("임시2", "임시은행2", "222-2222-2222", "2222", Integer.parseInt("2000"), date);
//
//            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//            date = dateTimeFormatter.format(LocalDateTime.now());
//            accountList.addAccount("임시3", "임시은행3", "333-3333-3333", "3333", Integer.parseInt("3000"), date);
//
//            dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
//            date = dateTimeFormatter.format(LocalDateTime.now());
//            accountList.addAccount("임시4", "임시은행4", "444-4444-4444", "4444", Integer.parseInt("4000"), date);


//            accountList.showAllAccount();



//        for (Account acc : accountList) {
//            System.out.println(acc.getName() + ", " + acc.getBankName() + ", " + acc.getAccountNum() + ", " + acc.getDate());
//        }
//        for (int i = 0; i < accountList.size(); i++) {
//            System.out.println(accountList.get(i));
//        }
    }

    public void editProcess() {
        int index;
        // 계좌번호 입력 후 AccountList에서 입력한 계좌번호의 계좌정보 리스트의 인덱스를 받는다.
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
        // 위에서 받은 인덱스로 해당 인덱스 값의 비밀번호가 입력한 비밀번호와 일치하면 수정 페이지를 출력.
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                System.out.print("수정 이름 : ");
                String replaceName = scanner.nextLine();
                System.out.print("수정 은행: ");
                String replaceBankName = scanner.nextLine();
                System.out.print("수정 비밀번호: ");
                String replacePassword = scanner.nextLine();
                accountList.editAccountList(index, replaceName, replaceBankName, replacePassword);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }



//        if ((accountList.passwordCorrection(index,password)==1)) {
//            accountList.updateAccount(index, replacename, replacebankname, replacepassword);
//            return;
//        }
    }

    public void deleteProcess() {
        String accountNum;
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            accountNum = scanner.nextLine();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                accountList.deleteAccount(index);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

    public void checkByAccountNumProcess() {
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
    }

    public void checkByNameProcess() {
        int index;
        while (true) {
            System.out.print("소유자명 : ");
            String name = scanner.nextLine();
            index = accountList.getIndexByName(name);
            if (index == -1) {
                System.out.println("존재하는 소유자명이 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
    }

    public void accountListProcess() {
        accountList.showAllAccount();
    }

    public void historyProcess() {
        String accountNum;
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            accountNum = scanner.nextLine();
            System.out.println();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                accountList.getHistory(accountNum);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

    public void depositProcess() {
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            System.out.println();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }

        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                System.out.println("입금할 금액을 입력하세요");
                System.out.print("금액 : ");
                String money = scanner.nextLine();
                accountList.deposit(index, Integer.parseInt(money));
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

    public void withdrawalProcess() {
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            System.out.println();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }

        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                System.out.println("출금할 금액을 입력하세요");
                System.out.print("금액 : ");
                String money = scanner.nextLine();
                accountList.withdrawal(index, Integer.parseInt(money));
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }


    public void getAmountProcess() {
        int index;
        // 계좌번호 입력 후 AccountList에서 입력한 계좌번호의 계좌정보 리스트의 인덱스를 받는다.
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            System.out.println();
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
        // 위에서 받은 인덱스로 해당 인덱스 값의 비밀번호가 입력한 비밀번호와 일치하면 잔고를 반환
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                accountList.getAmount(index);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

}

