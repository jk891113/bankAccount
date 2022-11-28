package presentation;

import service.MainProcess;

public class CheckAmountUI {
    MainProcess mainProcess = new MainProcess();

    public void checkAmount() {
        System.out.println("------------------------------");
        System.out.println("       계좌번호를 입력하세요.");
        System.out.println("------------------------------");
        System.out.println("------------------------------");
        mainProcess.getAmountProcess();
        System.out.println("------------------------------");
    }
}
