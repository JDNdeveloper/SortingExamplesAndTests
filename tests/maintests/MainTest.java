package maintests;

import main.Main;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jayden Navarro on 3/15/2015.
 */
public class MainTest {

    @Test
    public void mainTest() {
        assertEquals("Test failed", Main.returnThreeHundred(), 300);
    }
}
