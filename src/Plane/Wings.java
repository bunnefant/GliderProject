package Plane;

public class Wings {
    private double span;
    private double rootChord;
    private double taperRatio;
    private double leadingEdgeSweepAngle;

    public Wings(double span, double rootChord, double taperRatio, double leadingEdgeSweepAngle) {
        this.span = span;
        this.rootChord = rootChord;
        this.taperRatio = taperRatio;
        this.leadingEdgeSweepAngle = leadingEdgeSweepAngle;
    }

    public double getSpan() {
        return span;
    }

    public void setSpan(double span) {
        this.span = span;
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
