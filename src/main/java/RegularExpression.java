import java.util.regex.Pattern;

public class RegularExpression {
    public void accountNum(String accountNum) {
        boolean checkNum = Pattern.matches("^\\d{3}-\\d{4}-\\d{4}$", accountNum);
        if (checkNum) {
            break;
        } else {
            System.out.println("***계좌번호 형식이 올바르지 않습니다.***");
            continue;
        }
    }
}
