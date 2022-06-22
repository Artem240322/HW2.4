package ru.skypro;

public class Validator {

    private Validator() {
    }

    public static boolean check(String login,
                                String password,
                                String confirmPassword){
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e){
            System.out.println(e.getMessage());
            return false;
    }
}

    private static void validate(String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException {

    }
}

