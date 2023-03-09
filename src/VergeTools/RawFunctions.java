package VergeTools;


/*package org.firstinspires.ftc.robot.utilities;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.RobotLog;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;*/

public class RawFunctions {
    //Hardware declorations;
    /*private Blinker controlHub;
    private Blinker expansionHub;
    public BNO055IMU imu;
    public DcMotor frontLeft;
    public DcMotor frontRight;
    public DcMotor backLeft;
    public DcMotor backRight;*/

    static final double COUNTS_PER_MOTOR_REV = 1000;
    static final double DRIVE_GEAR_REDUCTION = 0.5;
    static final double WHEEL_DIAMETER_INCHES = 3.75;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_INCHES * 3.1415);

    public void setDCMotorSpeed(int portNumber, double speed){
        System.out.println("Running motor from port " + portNumber + " at a speed of " + speed);
    }
    public void RunDCMotorToPosition(int portNumber, int targetPosition, double speed) throws InterruptedException {
        Thread.sleep(Math.abs(targetPosition));
        System.out.println("Motor on port " + portNumber + " reached target position of " + targetPosition + " at a speed of " + speed);
    }
}
