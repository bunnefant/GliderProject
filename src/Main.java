import Plane.Constants;
import Plane.Glider;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Main implements Constants, Configuration{
    private static Aery32 aery32 = new Aery32();
    private static Glider glider = new Glider();
    private static String fileName = "glider.txt";
    static String bestCdOutput, bestAngleOutput, bestEvalOutput;
    static Glider bestCd = new Glider();
    static Glider bestAngle = new Glider();
    static Glider bestEval = new Glider();
    static double incrementPercent = 0.1;
    static int designNumber = 0;
    static boolean max = false;
    public static void main(String[] args) {
        sleep(5);
        while (designNumber < 10) {
            aery32.createFile(fileName, glider);
            String output = getGliderOutput(fileName);
            getBestDesigns(output);
            addToDocs(output);
            increment();
            update(max);
            max = glider.isAtMax();
        }
        printBest();
    }

    private static void addToDocs (String output) {
        designNumber = designNumber + 1;
        System.out.println("Design: " + designNumber);
        for (String s: glider.string()) {
            System.out.println(s);
        }
        System.out.println(output);
    }

    private static void printBest () {
        System.out.println("Best CD Design");
        for (String s : bestCd.string()) {
            System.out.println(s);
        }
        System.out.println(bestCdOutput);
        System.out.println("Best Angle Design");
        for (String s : bestAngle.string()) {
            System.out.println(s);
        }
        System.out.println(bestAngleOutput);
        System.out.println("Best Eval Design");
        for (String s : bestEval.string()) {
            System.out.println(s);
        }
        System.out.println(bestEvalOutput);
    }

    private static void sleep(double x) {
        try {
            Thread.sleep((int) x * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void getBestDesigns (String output) {
        assert output != null;
        if (output.contains("fly!")) {
            int evalIndex = output.indexOf("Aery Evaluation Number:   ");
            int cdIndex = output.indexOf("ESTIMATED CDo:     ");
            int angleIndex = output.indexOf("ESTIMATED Glide Angle:   ");
            glider.setEval(Integer.parseInt(output.substring(evalIndex, evalIndex + 3)));
            glider.setAngle(Double.parseDouble(output.substring(angleIndex, angleIndex + 3)));
            glider.setCd(Double.parseDouble(output.substring(cdIndex, cdIndex + 4)));
        }
        if (bestCd.getCd() > glider.getCd()) {
            bestCd = glider;
            bestCdOutput = output;
        }
        if (bestAngle.getAngle() > glider.getAngle()) {
            bestAngle = glider;
            bestAngleOutput = output;
        }
        if (bestEval.getEval() < glider.getEval()) {
            bestEval = glider;
            bestEvalOutput = output;
        }
    }

    private static void increment () {
        glider.setNoseMass(glider.getNoseMass() + (Constants.NOSE_MASS_MAX * incrementPercent));
        if (glider.getNoseMass() == Constants.NOSE_MASS_MAX) {
            glider.setFuesalgeLength(glider.getFuesalgeLength() + (Constants.FUESALAGE_LENGTH_MAX * incrementPercent));
            glider.setNoseMass(Constants.NOSE_MASS_MIN);
        }
        if (glider.getFuesalgeLength() == Constants.FUESALAGE_LENGTH_MAX) {
            glider.setWingLocation(glider.getWingLocation() + (Constants.WING_LOCATION_MAX * incrementPercent));
            glider.setFuesalgeLength(Constants.FUESALAGE_LENGTH_MIN);
        }
        if (glider.getWingLocation() == Constants.WING_LOCATION_MAX) {
            glider.setStabalizerLocation(glider.getStabalizerLocation() + (Constants.STABALIZER_LOCATION_MAX * incrementPercent));
            glider.setWingLocation(Constants.WING_LOCATION_MIN);
        }
        if (glider.getStabalizerLocation() == Constants.STABALIZER_LOCATION_MAX) {
            glider.setVerticalStabalizerLocation(glider.getVerticalStabalizerLocation() + (Constants.VERTICAL_STABALIZER_LOCATION_MAX * incrementPercent));
            glider.setStabalizerLocation(Constants.STABALIZER_LOCATION_MIN);
        }
        if (glider.getVerticalStabalizerLocation() == Constants.VERTICAL_STABALIZER_LOCATION_MAX) {
            glider.getWings().setSpan(glider.getWings().getSpan() + (Constants.WING_SPAN_MAX * incrementPercent));
            glider.setVerticalStabalizerLocation(Constants.VERTICAL_STABALIZER_LOCATION_MIN);
        }
        if (glider.getWings().getSpan() == Constants.WING_SPAN_MAX) {
            glider.getWings().setTaperRatio(glider.getWings().getTaperRatio() + (Constants.WING_TAPER_RATIO_MAX * incrementPercent));
            glider.getWings().setSpan(Constants.WING_SPAN_MIN);
        }
        if (glider.getWings().getTaperRatio() == Constants.WING_TAPER_RATIO_MAX) {
            glider.getWings().setLeadingEdgeSweepAngle(glider.getWings().getLeadingEdgeSweepAngle() + (Constants.WING_LSEA_MAX * incrementPercent));
            glider.getWings().setTaperRatio(Constants.WING_TAPER_RATION_MIN);
        }
        if (glider.getWings().getLeadingEdgeSweepAngle() == Constants.WING_LSEA_MAX) {
            glider.getWings().setRootChord(glider.getWings().getRootChord() + (Constants.WING_ROOT_CHORD_MAX* incrementPercent));
            glider.getWings().setLeadingEdgeSweepAngle(Constants.WING_LSEA_MIN);
        }
        if (glider.getWings().getRootChord() == Constants.WING_ROOT_CHORD_MAX) {
            glider.getStabalizer().setSpan(glider.getStabalizer().getSpan() + (Constants.STABALIZER_SPAN_MAX * incrementPercent));
            glider.getWings().setRootChord(Constants.WING_ROOT_CHORD_MIN);
        }
        if (glider.getStabalizer().getSpan() == Constants.STABALIZER_SPAN_MAX) {
            glider.getStabalizer().setTaperRatio(glider.getStabalizer().getTaperRatio() + (Constants.STABALIZER_TAPER_RATIO_MAX * incrementPercent));
            glider.getStabalizer().setSpan(Constants.STABALIZER_SPAN_MIN);
        }
        if (glider.getStabalizer().getTaperRatio() == Constants.STABALIZER_TAPER_RATIO_MAX) {
            glider.getStabalizer().setLeadingEdgeSweepAngle(glider.getStabalizer().getLeadingEdgeSweepAngle() + (Constants.STABALIZER_LSEA_MAX * incrementPercent));
            glider.getStabalizer().setTaperRatio(Constants.STABALIZER_TAPER_RATION_MIN);
        }
        if (glider.getStabalizer().getLeadingEdgeSweepAngle() == Constants.STABALIZER_LSEA_MAX) {
            glider.getStabalizer().setRootChord(glider.getStabalizer().getRootChord() + (Constants.STABALIZER_ROOT_CHORD_MAX* incrementPercent));
            glider.getStabalizer().setLeadingEdgeSweepAngle(Constants.STABALIZER_LSEA_MIN);
        }
        if (glider.getStabalizer().getRootChord() == Constants.STABALIZER_ROOT_CHORD_MAX) {
            glider.getVerticalStabilizer().setHeight(glider.getVerticalStabilizer().getHeight() + (Constants.VSTABALIZER_HEIGHT_MAX * incrementPercent));
            glider.getStabalizer().setRootChord(Constants.STABALIZER_ROOT_CHORD_MIN);
        }
        if (glider.getVerticalStabilizer().getHeight() == Constants.VSTABALIZER_HEIGHT_MAX) {
            glider.getVerticalStabilizer().setTaperRatio(glider.getVerticalStabilizer().getTaperRatio() + (Constants.VSTABALIZER_TAPER_RATIO_MAX * incrementPercent));
            glider.getVerticalStabilizer().setHeight(Constants.VSTABALIZER_HEIGHT_MIN);
        }
        if (glider.getVerticalStabilizer().getTaperRatio() == Constants.VSTABALIZER_TAPER_RATIO_MAX) {
            glider.getVerticalStabilizer().setLeadingEdgeSweepAngle(glider.getVerticalStabilizer().getLeadingEdgeSweepAngle() + (Constants.VSTABALIZER_LSEA_MAX * incrementPercent));
            glider.getVerticalStabilizer().setTaperRatio(Constants.VSTABALIZER_TAPER_RATION_MIN);
        }
        if (glider.getVerticalStabilizer().getLeadingEdgeSweepAngle() == Constants.VSTABALIZER_LSEA_MAX) {
            glider.getVerticalStabilizer().setRootChord(glider.getVerticalStabilizer().getRootChord() + (Constants.VSTABALIZER_ROOT_CHORD_MAX * incrementPercent));
            glider.getVerticalStabilizer().setLeadingEdgeSweepAngle(Constants.VSTABALIZER_LSEA_MIN);
        }
    }

    private static String getGliderOutput (String fileName) {
        Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
        Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
        Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
        Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
        Robot.goToPoint(Configuration.FILE_BUTTON_LOCATION);
        sleep(1);
        Robot.leftClick();
        sleep(1);
        Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
        Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
        Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
        Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
        Robot.goToPoint(Configuration.OPEN_BUTTON_UNDER_FILE);
        sleep(1);
        Robot.leftClick();
        sleep(1);
        Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
        Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
        Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
        Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
        Robot.goToPoint(Configuration.OK_ERROR_MESSAGE);
        sleep(1);
        Robot.leftClick();
        sleep(1);
        Robot.leftClick();
        sleep(1);
        Robot.type(fileName);
        sleep(1);
        Robot.enter();
        sleep(1);
        Robot.fly();
        Robot.goToPoint(Configuration.INFO_BUTTON);
        Robot.goToPoint(Configuration.INFO_BUTTON);
        Robot.goToPoint(Configuration.INFO_BUTTON);
        Robot.goToPoint(Configuration.INFO_BUTTON);
        Robot.goToPoint(Configuration.INFO_BUTTON);
        sleep(1);
        Robot.leftClick();
        sleep(1);
        Robot.goToPoint(Configuration.COPYSTART_FOR_INFO);
        Robot.goToPoint(Configuration.COPYSTART_FOR_INFO);
        Robot.goToPoint(Configuration.COPYSTART_FOR_INFO);
        Robot.goToPoint(Configuration.COPYSTART_FOR_INFO);
        Robot.goToPoint(Configuration.COPYSTART_FOR_INFO);
        sleep(1);

        Robot.leftPress();
        Robot.scroll();
        sleep(2);
        Robot.goToPoint(Configuration.COPY_END_1);
        sleep(1);
        Robot.goToPoint(Configuration.COPY_END_2);
        sleep(1);
        Robot.goToPoint(Configuration.COPY_END_3);
        sleep(1);

        Robot.leftRelease();
        Robot.cntrlC();
        try {
            return (String) Toolkit.getDefaultToolkit()
                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
        return "";
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