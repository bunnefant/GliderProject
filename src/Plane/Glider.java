package Plane;

public class Glider {
    private double velocity;
    private double fuesalgeLength;
    private double wingLocation;
    private double stabalizerLocation;
    private double verticalStabalizerLocation;
    private double noseMass;
    private Wings wings;
    private Stabalizer stabalizer;
    private VerticalStablizer verticalStablizer;

    public Glider(double velocity, double fuesalgeLength, double wingLocation, double stabalizerLocation,
                  double verticalStabalizerLocation, double noseMass, Wings wings, Stabalizer stabalizer,
                  VerticalStablizer verticalStablizer) {
        this.velocity = velocity;
        this.fuesalgeLength = fuesalgeLength;
        this.wingLocation = wingLocation;
        this.stabalizerLocation = stabalizerLocation;
        this.verticalStabalizerLocation = verticalStabalizerLocation;
        this.noseMass = noseMass;
        this.wings = wings;
        this.stabalizer = stabalizer;
        this.verticalStablizer = verticalStablizer;
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

    public VerticalStablizer getVerticalStablizer() {
        return verticalStablizer;
    }

    public void setVerticalStablizer(VerticalStablizer verticalStablizer) {
        this.verticalStablizer = verticalStablizer;
    }
}
