package presentation;

import service.MainProcess;

public class createUI {
    MainProcess mainProcess = new MainProcess();
    public void createAccount() {
        System.out.println("------------------------------");
        System.out.println("      계좌 정보를 입력하세요");
        System.out.println("------------------------------");
    }

    public void createdAccount() {
        System.out.println("------------------------------");
        System.out.println("         계좌 등록 완료");
        System.out.println("------------------------------");
    }

    public void accountNumRegularExpression() {
        System.out.println("*** 계좌번호 형식이 올바르지 않습니다. ***");
    }

    public void passwordRegularExpression() {
        System.out.println("*** 비밀번호가 올바르지 않습니다. ***");
    }
}