import java.util.Scanner;

class InvalidPasswordException extends Exception {
    public InvalidPasswordException(String message) {
        super(message);
    }
}

public class PasswordCheck {

    static void validatePassword(String password)
            throws InvalidPasswordException {

        if (password.length() < 8) {
            throw new InvalidPasswordException(
                "Password must be at least 8 characters long.");
        }

        boolean hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isDigit(ch)) {
                hasDigit = true;
                break;
            }
        }

        if (!hasDigit) {
            throw new InvalidPasswordException(
                "Password must contain at least one digit.");
        }

        System.out.println("Password is valid.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            validatePassword(password);
        }
        catch (InvalidPasswordException e) {
            System.out.println("Invalid Password: " + e.getMessage());
        }

        sc.close();
    }
}
