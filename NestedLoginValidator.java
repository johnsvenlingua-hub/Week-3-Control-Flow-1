public class NestedLoginValidator {

    public static void validateLogin(String inputUsername, String inputPassword, boolean isAccountLocked) {
        String correctUsername = "admin";
        String correctPassword = "password123";

        System.out.println("Attempting login with -> Username: \"" + inputUsername + "\", Password: \"" + inputPassword + "\", Locked: " + isAccountLocked);

        if (inputUsername.equals(correctUsername)) {
            if (inputPassword.equals(correctPassword)) {
                if (!isAccountLocked) {
                    System.out.println("Login Status: SUCCESS - Access Granted.\n");
                } else {
                    System.out.println("Login Status: FAILED - Account is locked.\n");
                }
            } else {
                System.out.println("Login Status: FAILED - Incorrect password.\n");
            }
        } else {
            System.out.println("Login Status: FAILED - Username not found.\n");
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Failure at Stage 1 (Invalid Username)
        validateLogin("user123", "password123", false);

        // Test Case 2: Failure at Stage 2 (Invalid Password)
        validateLogin("admin", "wrongPass", false);

        // Test Case 3: Failure at Stage 3 (Account Locked)
        validateLogin("admin", "password123", true);

        // Test Case 4: Success (All checks passed)
        validateLogin("admin", "password123", false);
    }
}
