package Plane;

public class Stabalizer {
    private double span;
    private double rootChord;
    private double taperRatio;
    private double leadingEdgeSweepAngle;

    public Stabalizer(double span, double rootChord, double taperRatio, double leadingEdgeSweepAngle) {
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

    public void update (boolean max) {
        if (!max) {
            if (getSpan() == Constants.STABALIZER_SPAN_MAX) {
                setSpan(Constants.STABALIZER_SPAN_MIN);
            }
            if (getTaperRatio() == Constants.STABALIZER_TAPER_RATIO_MAX) {
                setTaperRatio(Constants.STABALIZER_TAPER_RATION_MIN);
            }
            if (getLeadingEdgeSweepAngle() == Constants.STABALIZER_LSEA_MAX) {
                setLeadingEdgeSweepAngle(Constants.STABALIZER_LSEA_MIN);
            }
            if (getRootChord() == Constants.STABALIZER_ROOT_CHORD_MAX) {
                setRootChord(Constants.STABALIZER_ROOT_CHORD_MIN);
            }
        }
    }
}
