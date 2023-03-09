package VergeTools;
public class Util {
    public double clamp(double value, double min, double max){
        return value > max ? max : value < min ? min : value;
    }
    public double clamp(double value, double limit){
        return value > Math.abs(limit) ? Math.abs(limit) : value < -Math.abs(limit) ? -Math.abs(limit) : value;
    }
}
