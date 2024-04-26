package uz.pdp.online.jayxun.todaytest22s.advice;

public class EmailOrUserNameAlreadyExistsExceptions extends RuntimeException {
    public EmailOrUserNameAlreadyExistsExceptions() {
        super("Email or Username already exists ");
    }
}
