package utils;



public class PasswordUtils {

    public static String hashPassword(String plainTextPassword) {
        return "hash"+plainTextPassword;
    }

    public static boolean checkPassword(String plainTextPassword, String hashedPassword) {
        return plainTextPassword.equals("hash"+plainTextPassword);
    }
}
