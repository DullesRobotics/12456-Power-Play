package org.firstinspires.ftc.teamcode.Tyre;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Servo;
import org.firstinspires.ftc.teamcode.RobotManager.Robot;

@Config
public class ControlCenterTeleOp {

    public static double clawClosedPos = 0.3, clawGripPos = 0.2, clawOpenPos = 0.5;

    public static void clawRelease(Robot r, Controller ctrl){
        r.addThread(new Thread(() -> {
            Servo outtakeServo = r.getServo("CLAW");
            outtakeServo.get().setPosition(clawOpenPos);
            while(r.op().opModeIsActive()){
                if(ctrl.rightBumper()){
                    outtakeServo.get().setPosition(clawClosedPos);
                }
                else if(ctrl.leftBumper()){
                    outtakeServo.get().setPosition(clawGripPos);
                }
                else{
                    outtakeServo.get().setPosition(clawOpenPos);
                }
            }
        }), true);
    }
}
