import VergeTools.*;
public class Main {
    static DCMotor motor = new DCMotor(4);
    static Chassis chassis = new Chassis(0, 1, 2, 3);
    public static void main(String[] args) throws InterruptedException {
        motor.limit(0.5);
        motor.limit(false);
        motor.move(-1);
    }
}