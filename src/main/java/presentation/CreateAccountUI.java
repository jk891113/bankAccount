package presentation;

import service.MainProcess;

public class CreateAccountUI {
    MainProcess mainProcess = new MainProcess();
    public void createAccount() {
        System.out.println("------------------------------");
        System.out.println("      계좌 정보를 입력하세요");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        mainProcess.createProcess();
        System.out.println("------------------------------");
    }
}