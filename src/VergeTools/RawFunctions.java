package VergeTools;

public class RawFunctions {
    public void setDCMotorSpeed(int portNumber, double speed){
        System.out.println("Running motor from port " + portNumber + " at a speed of " + speed);
    }
    public void RunDCMotorToPosition(int portNumber, int targetPosition, double speed) throws InterruptedException {
        Thread.sleep(Math.abs(targetPosition));
        System.out.println("Motor on port " + portNumber + " reached target position of " + targetPosition + " at a speed of " + speed);
    }
}
