package service;

import entity.AccountList;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MainProcess {
    Scanner scanner = new Scanner(System.in);
    //계좌 정보를 가지고있는 리스트
    AccountList accountList = new AccountList();

    //계좌 생성 기능
    public void createProcess() {
        // 이름 입력
        System.out.print("예금주 : ");
        String name = scanner.nextLine();
        // 은행명 입력
        System.out.print("은행명 : ");
        String bankName = scanner.nextLine();
        // 계좌번호 입력
        String accountNum;
        while (true) {
            System.out.println("계좌번호 형식에 맞게 작성하세요. (ex.000-0000-0000)");
            System.out.print("계좌번호 : ");
            accountNum = scanner.nextLine();
            // 000-0000-0000 형식에 맞게 입력시 checkNum = true, 아닐시 재입력
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
            // 0000 형식에 맞게 입력시 다음 진행, 아닐시 재입력
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
                nAmount = Integer.parseInt(amount); //예외처리 기능을 사용하기 위해 미리 강제 형태변환
                break;
            } catch (NumberFormatException e) {
                System.out.println("잔고 입력이 올바르지 않습니다.");
            }
        }
        //현재 날짜,시간 입력
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm");
        String date = dateTimeFormatter.format(LocalDateTime.now());
        //계좌 생성정보 저장
        accountList.addAccount(name, bankName, accountNum, password, nAmount, date);
        accountList.showAllAccount();
    }

    //계좌 수정 기능
    public void editProcess() {
        int index;
        // 계좌번호 입력 후 AccountList에서 입력한 계좌번호의 계좌정보 리스트의 인덱스를 받는다.
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            // 저장된 계좌에 맞게 입력시 true , 없을시 재입력
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
                // 선택한 계좌의 수정할 이름,은행명,비밀번호 입력
                System.out.print("수정 이름 : ");
                String replaceName = scanner.nextLine();
                System.out.print("수정 은행: ");
                String replaceBankName = scanner.nextLine();
                String replacePassword;
                while (true) {
                    System.out.print("수정 비밀번호: ");
                    replacePassword = scanner.nextLine();
                    // 0000 형식에 맞게 입력시 다음 진행, 아닐시 재입력
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

    //계좌 삭제 기능
    public void deleteProcess() {
        String accountNum;
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            accountNum = scanner.nextLine();
            // 저장된 계좌에 맞게 계좌번호 입력시 true , 없을시 재입력
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
            // 저장된 계좌의 비밀번호에 맞게 입력시 true , 없을시 재입력
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                //선택한 계좌 삭제
                accountList.deleteAccount(index);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

    //계좌 조회 기능(계좌번호를 이용한 계좌조회)
    public void checkByAccountNumProcess() {
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            // 저장된 계좌에 맞게 계좌번호 입력시 true , 없을시 재입력
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                //계좌 조회
                accountList.getAccount(index);
                break;
            }
        }
    }

    //계좌 조회 기능(예금주 이름을 이용한 계좌조회)
    public void checkByNameProcess() {
        int index;
        while (true) {
            System.out.print("예금주 : ");
            String name = scanner.nextLine();
            // 저장된 예금주 이름에 맞게 입력시 true , 없을시 재입력
            index = accountList.getIndexByName(name);
            if (index == -1) {
                System.out.println("존재하는 예금주가 없습니다.");
            } else {
                //계좌 조회
                accountList.getAccount(index);
                break;
            }
        }
    }

    //계좌 전체 조회
    public void accountListProcess() {
        //계좌 조회
        accountList.showAllAccount();
    }

    //계좌 거래내역 조회
    public void historyProcess() {
        String accountNum;
        int index;
        while (true) {
            System.out.println("거래내역을 조회할 계좌번호를 입력하세요.");
            System.out.print("계좌번호 : ");
            accountNum = scanner.nextLine();
            System.out.println();
            // 저장된 계좌에 맞게 계좌번호 입력시 true , 없을시 재입력
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
            // 저장된 계좌의 비밀번호에 맞게 입력시 true , 없을시 재입력
            int exact = accountList.passwordCorrection(index, password);
            if (exact == 1) {
                //선택한 계좌 , 거래내역 조회
                accountList.getHistory(accountNum);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }

    //계좌 입금 기능
    public void depositProcess() {
        int index;
        while (true) {
            System.out.println("입금할 계좌번호를 입력하세요.");
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            System.out.println();
            // 저장된 계좌에 맞게 계좌번호 입력시 true , 없을시 재입력
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
        int nAmount; // 입금 금액 변수
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            // 저장된 계좌의 비밀번호 맞게 입력시 true , 없을시 재입력
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
                    //선택한 계좌 입금 기능
                    accountList.deposit(index, nAmount);
                    break;
                } 
                // 금액에 문자입력시 예외처리
                catch (NumberFormatException e) {
                    System.out.println("금액 입력이 올바르지 않습니다.");
                }
            }
            break;
        }
    }

    //계좌 출금 기능
    public void withdrawalProcess() {
        int index;
        while (true) {
            System.out.println("출금할 계좌번호를 입력하세요.");
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            System.out.println();
            // 저장된 계좌에 맞게 계좌번호 입력시 true , 없을시 재입력
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
            // 저장된 계좌의 비밀번호로 맞게 입력시 true , 없을시 재입력
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
                    // 출금 기능
                    accountList.withdrawal(index, nAmount);
                    break;
                }
                // 금액에 문자입력시 예외처리
                catch (NumberFormatException e) {
                    System.out.println("금액 입력이 올바르지 않습니다.");
                }
            }
            break;
        }
    }

    // 계좌 송금 기능
    public void remittanceProcess() {
        int index;
        while (true) {
            System.out.print("계좌번호 : ");
            String accountNum = scanner.nextLine();
            System.out.println();
            // 저장된 계좌에 맞게 계좌번호 입력시 true , 없을시 재입력
            index = accountList.getIndexByAccountNum(accountNum);
            if (index == -1) {
                System.out.println("계좌번호를 찾을 수 없습니다.");
            } else {
                accountList.getAccount(index);
                break;
            }
        }
        int nAmount;
        String receiveAccountNum;
        while (true) {
            System.out.print("비밀번호 : ");
            String password = scanner.nextLine();
            System.out.println();
            // 저장된 계좌에 맞게 비밀번호 입력시 true , 없을시 재입력
            int exact = accountList.passwordCorrection(index, password);
            if (exact !=1) {
                System.out.println("비밀번호가 일치하지 않습니다.");
                continue;
            }
            int receiveIndex;
            while (true){
                System.out.println("받으실 분의 계좌번호를 입력하세요.");
                System.out.print("계좌번호 : ");
                receiveAccountNum = scanner.nextLine();
                // 송금할 계좌가 있는 계좌라면 true , 없을시 재입력
                receiveIndex = accountList.getIndexByAccountNum(receiveAccountNum);
                if (receiveIndex == -1) {
                    System.out.println("계좌번호를 찾을 수 없습니다.");
                } else {
                    accountList.getAccount(receiveIndex);
                }
                System.out.println("송금할 금액을 입력하세요.");
                System.out.print("금액 : ");
                try {
                    String money = scanner.nextLine();
                    nAmount = Integer.parseInt(money);
                    accountList.withdrawal(index, nAmount);
                    accountList.deposit(receiveIndex, nAmount);
                    break;
                } 
                // 금액입력에 문자입력시 예외처리
                catch (NumberFormatException e) {
                    System.out.println("금액 입력이 올바르지 않습니다.");
                }
            }
            break;
        }
    }

    //계좌 잔고 확인 기능
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
                //선택한 계좌 잔고 확인
                accountList.getAmount(index);
                break;
            } else {
                System.out.println("비밀번호가 일치하지 않습니다.");
            }
        }
    }
}