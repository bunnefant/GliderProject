import Plane.Constants;
import Plane.Glider;

public class Main implements Constants, Configuration{
    static Aery32 aery32 = new Aery32();
    static Glider glider = new Glider();
    static Glider bestGlider = new Glider();
    static double increment = 0.1;
    public static void main(String[] args) {
        sleep(5);
        while (!glider.isAtMax()) {
            aery32.createFile("glider.txt", glider);
            Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
            Robot.leftClick();
            Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
            Robot.leftClick();
            Robot.type("glider");
            Robot.enter();
            Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
            Robot.goToPoint(Configuration.INFO_BUTTON);
        }
    }
    static void sleep(double x) {
        try {
            Thread.sleep((int) x * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
