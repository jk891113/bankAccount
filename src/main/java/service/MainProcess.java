import entities.AccountList;

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
        int nAmount;
        while (true) {
            try {
                System.out.print("잔고 : ");
                String amount = scanner.nextLine();
                System.out.println();
                nAmount = Integer.parseInt(amount);
                break;
            } catch (NumberFormatException e) {
                System.out.println("잔고 입력이 올바르지 않습니다.");
            }
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd h:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());

        accountList.addAccount(name, bankName, accountNum, password, nAmount, date);
        accountList.showAllAccount();
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
                String replacePassword;
                while (true) {
                    System.out.print("수정 비밀번호: ");
                    replacePassword = scanner.nextLine();
                    if (!(Pattern.matches("\\d{4}", replacePassword))) {
                        System.out.println("***비밀번호가 입력방식이 올바르지 않습니다.***");
                        continue;
                    }
                    break;
                }
                accountList.editAccountList(index, replaceName, replaceBankName, replacePassword);
                break;

            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
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
        int nAmount =0;
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact !=1) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }

            while (true) {
                System.out.println("입금할 금액을 입력하세요");
                System.out.print("금액 : ");
                try {
                    String money = scanner.nextLine();
                    nAmount = Integer.parseInt(money);
                    accountList.deposit(index, nAmount);
                } catch (NumberFormatException e) {
                    System.out.println("금액 입력이 올바르지 않습니다.");
                }
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

        int nAmount;
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            int exact = accountList.passwordCorrection(index, password);
            if (exact !=1) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }
            while (true){
                System.out.println("출금할 금액을 입력하세요");
                System.out.print("금액 : ");
                try {
                    String money = scanner.nextLine();
                    nAmount = Integer.parseInt(money);
                    accountList.withdrawal(index, nAmount);
                } catch (NumberFormatException e) {
                    System.out.println("금액 입력이 올바르지 않습니다.");
                }
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