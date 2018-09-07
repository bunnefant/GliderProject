package Plane;

public class VerticalStablizer {
    private double height;
    private double rootChord;
    private double taperRatio;
    private double leadingEdgeSweepAngle;

    public VerticalStablizer(double height, double rootChord, double taperRatio, double leadingEdgeSweepAngle) {
        this.height = height;
        this.rootChord = rootChord;
        this.taperRatio = taperRatio;
        this.leadingEdgeSweepAngle = leadingEdgeSweepAngle;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getRootChord() {
        return rootChord;
    }

    public void setRootChord(double rootChord) {
        this.rootChord = rootChord;
    }

    public double getTaperRatio() {
        return taperRatio;
    }

    public void setTaperRatio(double taperRatio) {
        this.taperRatio = taperRatio;
    }

    public double getLeadingEdgeSweepAngle() {
        return leadingEdgeSweepAngle;
    }

    public void setLeadingEdgeSweepAngle(double leadingEdgeSweepAngle) {
        this.leadingEdgeSweepAngle = leadingEdgeSweepAngle;
    }
}
