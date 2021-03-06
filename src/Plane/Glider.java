package Plane;


public class Glider implements Constants {
    private double velocity;
    private double fuesalgeLength;
    private double wingLocation;
    private double stabalizerLocation;
    private double verticalStabalizerLocation;
    private double noseMass;
    private Wings wings;
    private Stabalizer stabalizer;
    private double eval, cd, angle;
    private boolean flyable = true;
    private VerticalStabilizer verticalStabilizer;

    public Glider(double velocity, double fuesalgeLength, double wingLocation, double stabalizerLocation,
                  double verticalStabalizerLocation, double noseMass, Wings wings, Stabalizer stabalizer,
                  VerticalStabilizer verticalStabilizer) {
        this.velocity = velocity;
        this.fuesalgeLength = fuesalgeLength;
        this.wingLocation = wingLocation;
        this.stabalizerLocation = stabalizerLocation;
        this.verticalStabalizerLocation = verticalStabalizerLocation;
        this.noseMass = noseMass;
        this.wings = wings;
        this.stabalizer = stabalizer;
        this.verticalStabilizer = verticalStabilizer;
    }

    public Glider () {
        this.velocity = 20;
        this.fuesalgeLength = Constants.FUESALAGE_LENGTH_MIN;
        this.wingLocation = Constants.WING_LOCATION_MIN;
        this.stabalizerLocation = Constants.STABALIZER_LOCATION_MIN;
        this.verticalStabalizerLocation = Constants.VERTICAL_STABALIZER_LOCATION_MIN;
        this.noseMass =  Constants.NOSE_MASS_MIN;
        this.wings = new Wings(Constants.WING_SPAN_MIN, Constants.WING_ROOT_CHORD_MIN, Constants.WING_TAPER_RATION_MIN, Constants.WING_LSEA_MIN);
        this.stabalizer = new Stabalizer(Constants.STABALIZER_SPAN_MIN, Constants.STABALIZER_ROOT_CHORD_MIN, Constants.STABALIZER_TAPER_RATION_MIN, Constants.STABALIZER_LSEA_MIN);
        this.verticalStabilizer = new VerticalStabilizer(Constants.VSTABALIZER_HEIGHT_MIN, Constants.VSTABALIZER_ROOT_CHORD_MIN, Constants.VSTABALIZER_TAPER_RATION_MIN, Constants.VSTABALIZER_LSEA_MIN);
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public double getFuesalgeLength() {
        return fuesalgeLength;
    }

    public void setFuesalgeLength(double fuesalgeLength) {
        this.fuesalgeLength = fuesalgeLength;
    }

    public double getWingLocation() {
        return wingLocation;
    }

    public void setWingLocation(double wingLocation) {
        this.wingLocation = wingLocation;
    }

    public double getStabalizerLocation() {
        return stabalizerLocation;
    }

    public void setStabalizerLocation(double stabalizerLocation) {
        this.stabalizerLocation = stabalizerLocation;
    }

    public double getVerticalStabalizerLocation() {
        return verticalStabalizerLocation;
    }

    public void setVerticalStabalizerLocation(double verticalStabalizerLocation) {
        this.verticalStabalizerLocation = verticalStabalizerLocation;
    }

    public double getNoseMass() {
        return noseMass;
    }

    public void setNoseMass(double noseMass) {
        this.noseMass = noseMass;
    }

    public Wings getWings() {
        return wings;
    }

    public void setWings(Wings wings) {
        this.wings = wings;
    }

    public Stabalizer getStabalizer() {
        return stabalizer;
    }

    public void setStabalizer(Stabalizer stabalizer) {
        this.stabalizer = stabalizer;
    }

    public VerticalStabilizer getVerticalStabilizer() {
        return verticalStabilizer;
    }

    public void setVerticalStabilizer(VerticalStabilizer verticalStabilizer) {
        this.verticalStabilizer = verticalStabilizer;
    }

    public double getEval() {
        return eval;
    }

    public void setEval(double eval) {
        this.eval = eval;
    }

    public double getCd() {
        return cd;
    }

    public void setCd(double cd) {
        this.cd = cd;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean isFlyable() {
        return flyable;
    }

    public void setFlyable(boolean flyable) {
        this.flyable = flyable;
    }

    public boolean isAtMax () {
        return
                fuesalgeLength == Constants.FUESALAGE_LENGTH_MAX &&
                wingLocation == Constants.WING_LOCATION_MAX &&
                stabalizerLocation == Constants.STABALIZER_LOCATION_MIN &&
                verticalStabalizerLocation == Constants.VERTICAL_STABALIZER_LOCATION_MIN &&
                noseMass == Constants.NOSE_MASS_MIN &&

                wings.getSpan() == Constants.WING_SPAN_MAX &&
                wings.getRootChord() == Constants.WING_ROOT_CHORD_MAX &&
                wings.getLeadingEdgeSweepAngle() == Constants.WING_LSEA_MAX &&
                wings.getTaperRatio() == Constants.WING_TAPER_RATIO_MAX &&

                stabalizer.getSpan() == Constants.STABALIZER_SPAN_MAX &&
                stabalizer.getRootChord() == Constants.STABALIZER_ROOT_CHORD_MAX &&
                stabalizer.getLeadingEdgeSweepAngle() == Constants.STABALIZER_LSEA_MAX &&
                stabalizer.getTaperRatio() == Constants.STABALIZER_TAPER_RATIO_MAX &&

                verticalStabilizer.getHeight() == Constants.VSTABALIZER_HEIGHT_MAX &&
                verticalStabilizer.getRootChord() == Constants.VSTABALIZER_ROOT_CHORD_MAX &&
                verticalStabilizer.getLeadingEdgeSweepAngle() == Constants.VSTABALIZER_LSEA_MAX &&
                verticalStabilizer.getTaperRatio() == Constants.VSTABALIZER_TAPER_RATIO_MAX;
    }

    public boolean isAtMax2 () {
        return getVerticalStabilizer().getRootChord() == Constants.VSTABALIZER_ROOT_CHORD_MAX;
    }

    public String[] string () {
        return new String[] {
                "Nose Mass: " + Double.toString(noseMass),
                "Fuesalge Length: " + Double.toString(fuesalgeLength),
                "Wing Location: " + Double.toString(wingLocation),
                "Stabalizer Location: " + Double.toString(stabalizerLocation),
                "VStabalizer Location: " + Double.toString(verticalStabalizerLocation),
                "Wing Span: " + Double.toString(getWings().getSpan()),
                "Wing Taper Ratio: " + Double.toString(getWings().getTaperRatio()),
                "Wing LESA: " + Double.toString(getWings().getLeadingEdgeSweepAngle()),
                "Wing Root Chord: " + Double.toString(getWings().getRootChord()),
                "Stabliazer Span: " + Double.toString(getStabalizer().getSpan()),
                "Stabliazer Taper Ratio: " + Double.toString(getStabalizer().getTaperRatio()),
                "Stabliazer LESA: " + Double.toString(getStabalizer().getLeadingEdgeSweepAngle()),
                "Stabliazer Root Chord: " + Double.toString(getStabalizer().getRootChord()),
                "Vertical Tail Height:" + Double.toString(getVerticalStabilizer().getHeight()),
                "Vertical Tail Root Chord:" + Double.toString(getVerticalStabilizer().getRootChord()),
                "Vertical Tail Taper Ratio:" + Double.toString(getVerticalStabilizer().getTaperRatio()),
                "Vertical Tail Leading Edge Sweep Angle:" + Double.toString(getVerticalStabilizer().getLeadingEdgeSweepAngle())
        };
    }
}
