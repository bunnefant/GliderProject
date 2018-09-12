import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Robot {

    private static java.awt.Robot robot;

    static {
        try {
            robot = new java.awt.Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void goToPoint(Point point) {
        robot.mouseMove(point.getX(), point.getY());
    }
    public static java.awt.Robot getInstance () {
        return robot;
    }
    public static void leftClick () {
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void leftPress () {
        robot.mousePress(InputEvent.BUTTON1_MASK);
    }
    public static void leftRelease () {
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public static void rightClick () {
        robot.mousePress(InputEvent.BUTTON2_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_MASK);
    }
    public static void enter () {
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
    public static void type (String text) {
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException(
                        "Key code not found for character '" + c + "'");
            }
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }
    public static void cntrlC () {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_C);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_C);
    }


}
