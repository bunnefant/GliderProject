import Plane.Glider;
import sun.rmi.rmic.Constants;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Aery32 implements Configuration {
    private Robot robot;
    private String path = "";
    private BufferedWriter writer;
    public Aery32() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void createFile(String fileName) {
        File file = new File(path + "/" + fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("File is created!");
            }
            else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter(file);
            this.writer = new BufferedWriter(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List getConfiguration (Glider glider) {
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
        "Wing Span (cm)",50
        "Wing Root Chord (cm)",10
        "Wing Taper Ratio",.8
        "Wing LE Angle (deg.)",2.29061
        "Wing Sweep Type",1
        "Stabilizer Span (cm)",22
        "Stabilizer Root Chord (cm)",8
        "Stabilizer Taper Ratio",.75
        "Stabilizer LE Angle (deg.)",10.30484
        "Stabilizer Sweep Type",2
        "Vertical Tail Height (cm)",12
        "Vertical Tail Root Chord (cm)",8
        "Vertical Tail Taper Ratio",.75
        "Vertical Tail LE Angle (deg.)",9.462321
        "Vertical Tail Sweep Type",2
        "configuration filename","36-36.cfg"
        "configuration name","36 inch spruce and 36 inch balsa"
        "maximum wing span (cm)",91.44
        "maximum wing width (cm)",10.16
        "wing thickness (cm)",.3175
        "wing density (kg/m^3)",104.76
        "max fuselage length (cm)",91.44
        "fuselage mass/length (kg/m)",.02221
        "fuselage width (top) (cm)",.635
        "fuselage depth (side) (cm)",.9525
        "max nose mass (grams)",30
        "airfoil section lift coefficient",5.7
        "air density (kg/m^3)",1.22
    }
}
