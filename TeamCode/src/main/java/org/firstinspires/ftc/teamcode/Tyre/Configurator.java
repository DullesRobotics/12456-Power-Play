package org.firstinspires.ftc.teamcode.Tyre;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.HardwareComponent;
import org.firstinspires.ftc.teamcode.Hardware.Motor.DrivetrainMotor;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Motor.MotorConfiguration;
import org.firstinspires.ftc.teamcode.Hardware.Motor.MotorType;
import org.firstinspires.ftc.teamcode.Hardware.Servo;
import org.firstinspires.ftc.teamcode.Libraries.IMU;
import org.firstinspires.ftc.teamcode.RobotManager.Robot;

import static org.firstinspires.ftc.teamcode.Hardware.ComponentArea.*;

public class Configurator {
    public static HardwareComponent[] getHardware(Robot robot){
        HardwareComponent[] driveTrainMotors = getDriveTrainMotors(robot);

        return(new HardwareComponent[]{
                driveTrainMotors[0],
                driveTrainMotors[1],
                driveTrainMotors[2],
                driveTrainMotors[3]
        });

    }
    public static HardwareComponent[] getDriveTrainMotors(Robot robot) {
        MotorConfiguration MC = new MotorConfiguration(
                MotorType.GO_BUILD_A_YELLOW_JACKET,
                true,
                2.9528,
                1);

        DrivetrainMotor motorFrontLeft = new DrivetrainMotor(robot, "FLM", MC, false, MotorType.DrivetrainPosition.FLM);
        DrivetrainMotor motorFrontRight = new DrivetrainMotor(robot, "FRM", MC, false, MotorType.DrivetrainPosition.FRM);
        DrivetrainMotor motorBackLeft = new DrivetrainMotor(robot, "BLM", MC, false, MotorType.DrivetrainPosition.BLM);
        DrivetrainMotor motorBackRight = new DrivetrainMotor(robot, "BRM", MC, false, MotorType.DrivetrainPosition.BRM);

        return(new HardwareComponent[]{
                motorFrontLeft,
                motorFrontRight,
                motorBackLeft,
                motorBackRight
        });

    }
}