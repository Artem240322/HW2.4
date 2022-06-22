package ru.skypro;

import java.util.Objects;

public class Validator {

    private static final String VALID_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789_";

    private Validator() {
    }

    public static boolean check(String login,
                                String password,
                                String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private static void validate(String login,
                                 String password,
                                 String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (Objects.isNull(login) || login.length() > 20 ) {
            throw new WrongLoginException("Длинна логина должна быть <= 20");
        }
        if (!containsValidSymbols(login)){
            throw new WrongLoginException("Логин содержит невалидные сымволы");
        }
        if (isNotValidPassword(password) || isNotValidPassword(confirmPassword)) {
            throw new WrongPasswordException("Длинна пароля должна быть < 20");
        }
        if (!containsValidSymbols(password)) {
            throw new WrongPasswordException("Пароль содержит невалидные символы");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
    }
    private static boolean isNotValidPassword(String password) {
        return Objects.isNull(password) || password.length() >= 20;
    }

    private static boolean containsValidSymbols(String s) {
        char[] symbols = s.toCharArray();
        for (char symbol : symbols) {
            if (!VALID_SYMBOLS.contains(String.valueOf(symbol))) {
                return false;

                }
            }
     return true;
    }
}



