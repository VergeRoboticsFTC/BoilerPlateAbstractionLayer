import VergeTools.*;
public class Main {
    static Util util = new Util();
    static DCMotor motor = new DCMotor(4);
    static Chassis chassis = new Chassis(0, 1, 2, 3);
    public static void main(String[] args) throws InterruptedException {
        motor.moveTo(400, 0.5);
        System.out.println("run teehee");
        Thread.sleep(500);
        motor.move(0.5);
    }
}