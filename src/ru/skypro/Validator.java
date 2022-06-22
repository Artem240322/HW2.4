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
        if (Objects.isNull(login) || login.length() > 20) {
            throw new WrongLoginException("Длинна логина должна быть < 20");
        }

    }

    private static boolean containsValidSymbols(String s) {
        char[] symbols = s.toCharArray();
        char[] validSymbols = VALID_SYMBOLS.toCharArray();
        for (char symbol : symbols) {
            for (char validSymbol : validSymbols) {
                if (symbol != validSymbol) {
                    return false;
                }
            }
        }
     return true;
    }
}



