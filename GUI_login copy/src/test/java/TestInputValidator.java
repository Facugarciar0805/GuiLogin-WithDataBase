import org.example.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestInputValidator {
    InputValidator inputValidator;
    @BeforeEach
    public void setup(){
        inputValidator = new InputValidator();
    }
    @Test
    public void testUsername(){

        assertTrue(inputValidator.validateUsername("Facugarciar0805"));
        assertTrue(inputValidator.validateUsername("Facugarciar0805!"));
        assertTrue(inputValidator.validateUsername("Facu_garciar"));
        assertFalse(inputValidator.validateUsername("Facu garciar"));
    }
}
