package Plane;

public class VerticalStabilizer implements Constants{
    private double height;
    private double rootChord;
    private double taperRatio;
    private double leadingEdgeSweepAngle;

    public VerticalStabilizer(double height, double rootChord, double taperRatio, double leadingEdgeSweepAngle) {
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

    public void update (boolean max) {
        if (!max) {
            if (getHeight() == Constants.VSTABALIZER_HEIGHT_MAX) {
                setHeight(Constants.VSTABALIZER_HEIGHT_MIN);
            }
            if (getTaperRatio() == Constants.VSTABALIZER_TAPER_RATIO_MAX) {
                setTaperRatio(Constants.VSTABALIZER_TAPER_RATION_MIN);
            }
            if (getLeadingEdgeSweepAngle() == Constants.VSTABALIZER_LSEA_MAX) {
                setLeadingEdgeSweepAngle(Constants.VSTABALIZER_LSEA_MIN);
            }
            if (getRootChord() == Constants.VSTABALIZER_ROOT_CHORD_MAX) {
                setRootChord(Constants.VSTABALIZER_ROOT_CHORD_MIN);
            }
        }
    }

    public void increment(double i1, double i2, double i3, double i4) {
        setHeight(getHeight() + i1);
        setTaperRatio(getTaperRatio() + i2);
        setRootChord(getRootChord() + i3);
        setLeadingEdgeSweepAngle(getLeadingEdgeSweepAngle() + i4);
    }
}
