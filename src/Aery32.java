import Plane.Glider;

import java.awt.*;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Aery32 implements Configuration {
    private String path = "";

    public void createFile(String fileName, Glider glider) {
        try {
            FileChannel.open(Paths.get(path + "/" + fileName), StandardOpenOption.WRITE).truncate(0).close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path path = Paths.get(this.path + "/" + fileName);
        try {
            Files.write(path, getConfiguration(glider), Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<String> getConfiguration (Glider glider) {
        System.out.println(glider.getFuesalgeLength() + "THIS IS TEST");
        List<String> list = new ArrayList<String>();
        list.add("\"Glider Name\",\"Sample glider with a canard configuration\"");
        list.add("\"1 Piece of Wood\",-1");
        list.add("\"Fuselage Length (cm)\"" + "," + Double.toString(glider.getFuesalgeLength()));
        list.add("\"Wing X Location (cm)\"" + "," + Double.toString(glider.getWingLocation()));
        list.add("\"Stabilizer X Location (cm)\"" + "," + Double.toString(glider.getStabalizerLocation()));
        list.add("\"Vertical Tail X Location (cm)\"" + "," + Double.toString(glider.getStabalizerLocation()));
        list.add("\"Mass at the nose (g)\"" + "," + Double.toString(glider.getNoseMass()));
        list.add("\"Throwing Velocity (km/hr)\",20");
        list.add("\"Wing Span (cm)\"" + "," + Double.toString(glider.getWings().getSpan()));
        list.add("\"Wing Root Chord (cm)\"" + "," + Double.toString(glider.getWings().getRootChord()));
        list.add("\"Wing Taper Ratio\"" + "," + Double.toString(glider.getWings().getTaperRatio()));
        list.add("\"Wing LE Angle (deg.)\"" + "," + Double.toString(glider.getWings().getLeadingEdgeSweepAngle()));
        list.add("\"Wing Sweep Type\",1");
        list.add("\"Stabilizer Span (cm)\"" + "," + Double.toString(glider.getStabalizer().getSpan()));
        list.add("\"Stabilizer Root Chord (cm)\"" + "," + Double.toString(glider.getStabalizer().getRootChord()));
        list.add("\"Stabilizer LE Angle (deg.)\"" + Double.toString(glider.getStabalizer().getLeadingEdgeSweepAngle()));
        list.add("\"Stabilizer Sweep Type\",2");
        list.add("\"Vertical Tail Height (cm)\"" + "," + Double.toString(glider.getVerticalStabilizer().getHeight()));
        list.add("\"Vertical Tail Root Chord (cm)\"" + "," + Double.toString(glider.getVerticalStabilizer().getRootChord()));
        list.add("\"Vertical Tail Taper Ratio\"" + "," + Double.toString(glider.getVerticalStabilizer().getTaperRatio()));
        list.add("\"Vertical Tail LE Angle (deg.)\"" + Double.toString(glider.getVerticalStabilizer().getLeadingEdgeSweepAngle()));
        list.add("\"Vertical Tail Sweep Type\",2");
        list.add("\"configuration filename\",\"test.cfg\"");
        list.add("\"configuration name\",\"36 inch spruce and 36 inch balsa\"");
        list.add("\"maximum wing span (cm)\"" + "," + Configuration.WING_SPAN);
        list.add("\"maximum wing width (cm)\"" + "," + Configuration.WING_WIDTH);
        list.add("\"wing thickness (cm)\"" + "," + Configuration.WING_THICKNESS);
        list.add("\"wing density (kg/m^3)\"" + "," + Configuration.WING_DENSITY);
        list.add("\"max fuselage length (cm)\"" + "," + Double.toString(60));
        list.add("\"fuselage mass/length (kg/m)\"" + "," + Double.toString(Configuration.FUSELAGE_MASS_OVER_LENGTH));
        list.add("\"fuselage width (top) (cm)\"" + "," + Double.toString(Configuration.FUSELAGE_WIDTH));
        list.add("\"fuselage depth (side) (cm)\"" + "," + Double.toString(Configuration.FUSELAGE_DEPTH));
        list.add("\"max nose mass (grams)\"" + "," + Double.toString(glider.getNoseMass()));
        list.add("\"airfoil section lift coefficient\"" + "," + Double.toString(5.7));
        list.add("\"air density (kg/m^3)\"" + "," + Double.toString(Configuration.AIR_DENSITY));
        return list;
    }
}
