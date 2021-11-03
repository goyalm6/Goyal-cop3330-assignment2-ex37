package ex37;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void generatePasswordBasedOnLength() {
        String pass = ex37.Main.generatePassword(8, 2, 2);
        assertEquals(8, pass.length());
    }

    @Test
    void generatedPasswordShouldContainSpecialCharacterAsRequested() {
        String pass = ex37.Main.generatePassword(8, 2, 2);
        String specialChars = "!@#&()–[{}]:;'?/*$^+=<>";
        boolean check = false;
        int Ct = 1;

        for (int i = 0; i < pass.length(); i++) {
            String strChar = Character.toString(pass.charAt(i));
            if (specialChars.contains(strChar)) {
                System.out.println("test - " + strChar);
                check = true;
                Ct =  Ct + 1;
                break;
            }
        }
        System.out.println("pass - " + pass);
        assertEquals(true, check);
        assertEquals(2, Ct);
    }

    @Test
    void generatedPasswordShouldContainNumbersAsRequested() {
        String pass = ex37.Main.generatePassword(8, 2, 2);
        String numbers = "0123456789";
        boolean check = false;
        int Ct = 1;

        for (int i = 0; i < pass.length(); i++) {
            String strChar = Character.toString(pass.charAt(i));
            if (numbers.contains(strChar)) {
                System.out.println("test - " + strChar);
                check = true;
                Ct =  Ct + 1;
                break;
            }
        }
        System.out.println("pass - " + pass);
        assertEquals(true, check);
        assertEquals(2, Ct);
    }
}