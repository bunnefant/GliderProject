package Plane;

public class Wings implements Constants {
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

    public void update (boolean max) {
        if (!max) {
            if (getSpan() == Constants.WING_SPAN_MAX) {
                setSpan(Constants.WING_SPAN_MIN);
            }
            if (getTaperRatio() == Constants.WING_TAPER_RATIO_MAX) {
                setTaperRatio(Constants.WING_TAPER_RATION_MIN);
            }
            if (getLeadingEdgeSweepAngle() == Constants.WING_LSEA_MAX) {
                setLeadingEdgeSweepAngle(Constants.WING_LSEA_MIN);
            }
            if (getRootChord() == Constants.WING_ROOT_CHORD_MAX) {
                setRootChord(Constants.WING_ROOT_CHORD_MIN);
            }
        }
    }

    public void increment(double i1, double i2, double i3, double i4) {
        setSpan(getSpan() + i1);
        setTaperRatio(getTaperRatio() + i2);
        setRootChord(getRootChord() + i3);
        setLeadingEdgeSweepAngle(getLeadingEdgeSweepAngle() + i4);
    }
}
