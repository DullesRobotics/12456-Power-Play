package org.firstinspires.ftc.teamcode.Tyre;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.ComponentArea;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Servo;
import org.firstinspires.ftc.teamcode.Libraries.RoadRunner.Drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.RobotManager.MechanumDriveTrain;

import java.lang.reflect.Field;
import java.text.FieldPosition;

@Config
public class AutonFunctions {
    private static volatile MechanumDriveTrain mainFrame;
    private static volatile SampleMecanumDrive roadRunner;
    public static int timeToPark = 5000;
    public static int sameSidePark = 2000;
    public static int oppositeSidePark = 4000;

    public static void start(LinearOpMode op, TeamColor t, FieldPosition position){
        mainFrame = new MechanumDriveTrain(op);
        mainFrame.addHardware(Configurator.getHardware(mainFrame));
        op.waitForStart();
        if(op.isStopRequested()) return;
        long timeToDrive = position == FieldPosition.SAME ? timeToPark : timeToPark;
        timeToDrive += System.currentTimeMillis();
        while(System.currentTimeMillis() < timeToDrive && op.opModeIsActive())
            mainFrame.setIndividualDrivePower(0,0,-0.3,-0.3);
        mainFrame.setSidedDrivePower(0,0);
        op.requestOpModeStop();
    }

    public static void startNew(LinearOpMode op, TeamColor t, FieldPosition position){
        roadRunner = new SampleMecanumDrive(op);
        mainFrame = roadRunner.getDriveTrain();
        op.waitForStart();

        if(op.isStopRequested()) return;

        if(position == FieldPosition.SAME){
            boolean isRed = t == TeamColor.RED;
            mainFrame.setIndividualDrivePower(0,isRed ? 1.2 : -1.2,3.3,3.3);
            mainFrame.autonWait(sameSidePark);
            mainFrame.setIndividualDrivePower(1,1,0,0);
            mainFrame.autonWait(500);
            mainFrame.setIndividualDrivePower(0,0,3.3,3.3);
        }
    }

    public enum TeamColor{
        RED, BLUE
    }

    public enum Direction {
        RIGHT, LEFT;
    }
    public enum FieldPosition{
        SAME, DIFFERENT
    }


}
