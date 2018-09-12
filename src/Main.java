import Plane.Constants;
import Plane.Glider;

public class Main implements Constants, Configuration{
    private static Aery32 aery32 = new Aery32();
    private static Glider glider = new Glider();
    static Glider bestGlider = new Glider();
    static double increment = 0.1;
    static boolean max = false;
    public static void main(String[] args) {
        sleep(5);
        while (!max) {
            max = glider.isAtMax();
            aery32.createFile("glider.txt", glider);
            Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
            Robot.leftClick();
            Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
            Robot.leftClick();
            Robot.type("glider");
            Robot.enter();
            Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
            Robot.goToPoint(Configuration.INFO_BUTTON);
            Robot.goToPoint(Configuration.COPYSTART_FOR_INFO);
            Robot.leftPress();
            Robot.goToPoint(Configuration.COPY_END);
            sleep(500);
            Robot.leftRelease();

            glider.setNoseMass(glider.getNoseMass() + increment);
            glider.setFuesalgeLength(glider.getFuesalgeLength() + increment);
            glider.setWingLocation(glider.getWingLocation() + increment);
            glider.setStabalizerLocation(glider.getStabalizerLocation() + increment);
            glider.setVerticalStabalizerLocation(glider.getVerticalStabalizerLocation() + increment);
            glider.getWings().increment(increment, increment, increment, increment);
            glider.getVerticalStabilizer().increment(increment, increment, increment, increment);
            glider.getStabalizer().increment(increment, increment, increment, increment);
            update(max);
        }
    }
    private static void sleep(double x) {
        try {
            Thread.sleep((int) x * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void update(boolean max) {
        if (!max) {
            if (glider.getFuesalgeLength() == Constants.FUESALAGE_LENGTH_MAX) {
                glider.setFuesalgeLength(Constants.FUESALAGE_LENGTH_MIN);
            }
            if (glider.getWingLocation() == Constants.WING_LOCATION_MAX) {
                glider.setWingLocation(Constants.WING_LOCATION_MIN);
            }
            if (glider.getStabalizerLocation() == Constants.STABALIZER_LOCATION_MAX) {
                glider.setStabalizerLocation(Constants.STABALIZER_LOCATION_MIN);
            }
            if (glider.getVerticalStabalizerLocation() == Constants.VERTICAL_STABALIZER_LOCATION_MAX) {
                glider.setVerticalStabalizerLocation(Constants.VERTICAL_STABALIZER_LOCATION_MIN);
            }
            if (glider.getNoseMass() == Constants.NOSE_MASS_MAX) {
                glider.setNoseMass(Constants.NOSE_MASS_MIN);
            }
        }
        glider.getWings().update(max);
        glider.getStabalizer().update(max);
        glider.getVerticalStabilizer().update(max);
    }

}
