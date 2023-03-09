package VergeTools;

public class DCMotor {
    Util util = new Util();
    RawFunctions rawFunctions = new RawFunctions();
    int portNumber;
    double limitSpeedMin = -1;
    double limitSpeedmax = 1;
    boolean limitSpeedEnable;
    double mapLimitSpeed = 1;
    boolean mapLimitSpeedEnable;
    double holdingPower = 0.2;
    boolean holdEnable = false;
    public volatile boolean running = false;
    public DCMotor(int motorPortNumber){
        portNumber = motorPortNumber;
    }
    public void move(double speed){
        speed = util.clamp(speed, 1);
        speed = limitSpeedEnable ? util.clamp(speed, limitSpeedMin, limitSpeedmax) : speed;
        speed = mapLimitSpeedEnable ? speed * mapLimitSpeed : speed;
        while (running){}
        rawFunctions.setDCMotorSpeed(portNumber, speed);
    }
    public void moveTo(int pos, double speed){
        speed = util.clamp(speed, 1);
        speed = Math.abs(speed);
        speed = limitSpeedEnable ? util.clamp(speed, limitSpeedMin, limitSpeedmax) : speed;
        speed = mapLimitSpeedEnable ? speed * mapLimitSpeed : speed;
        while (running){}
        running = true;
        MotorThread motorThread = new MotorThread(pos, speed);
        motorThread.start();
        motorThread.setName("MotorThread");
    }
    public void stop(){
        if(holdEnable){
            move(holdingPower);
        }else{
            move(0);
        }
    }

    public void finish(){
        while (running){}
    }
    public void hold(double amount){
        holdEnable = true;
        holdingPower = amount;
        move(amount);
    }
    public void hold(boolean enable){
        holdEnable = enable;
        if(enable){
            move(holdingPower);
        }else{
            move(0);
        }
    }
    public void limit(double limit){
        limitSpeedMin = -Math.abs(util.clamp(limit, 1));
        limitSpeedmax = Math.abs(util.clamp(limit, 1));
        limitSpeedEnable = true;
    }
    public void limit(double min, double max){
        limitSpeedMin = -Math.abs(util.clamp(min, 1));
        limitSpeedmax = Math.abs(util.clamp(max, 1));
        limitSpeedEnable = true;
    }
    public void limit(boolean limit){
        limitSpeedEnable = limit;
    }

    public void mapLimit(double speed){
        mapLimitSpeedEnable = true;
        speed = Math.abs(util.clamp(speed, 1));
        mapLimitSpeed = speed;
    }
    public void mapLimit(boolean enable){
        mapLimitSpeedEnable = enable;
    }
    private class MotorThread extends Thread {
        int targetPosition;
        double speed;
        MotorThread(int pos, double s){
            targetPosition = pos;
            speed = s;
        }
        public void run() {
            try {
                rawFunctions.RunDCMotorToPosition(portNumber, targetPosition, speed);
                if(holdEnable){
                    rawFunctions.setDCMotorSpeed(portNumber, holdingPower);
                }
                running = false;

            } catch (Exception e) {
                // Throwing an exception
                System.out.println(e);
            }
        }
    }
}