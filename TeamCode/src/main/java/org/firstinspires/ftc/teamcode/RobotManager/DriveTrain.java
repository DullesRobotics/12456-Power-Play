package org.firstinspires.ftc.teamcode.RobotManager;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.ComponentArea;
import org.firstinspires.ftc.teamcode.Hardware.Motor.DrivetrainMotor;
import org.firstinspires.ftc.teamcode.Hardware.Motor.Motor;
import org.firstinspires.ftc.teamcode.Hardware.Motor.MotorConfiguration;
import org.firstinspires.ftc.teamcode.Hardware.Motor.MotorType;
import org.firstinspires.ftc.teamcode.Libraries.PID;

@Config
public abstract class DriveTrain extends Robot{

    public static double speed = 0.5, percisionSpeed = 0.25, ultrasPSpeed = 0.05;
    protected MotorConfiguration autonMotorConfiguration;
    protected PID pid = null;

    /**
     * Takes in super initiators
     * @param op The op mode this is used for
     */
    public DriveTrain(LinearOpMode op, PID pid){
        super(op);
        this.autonMotorConfiguration = null;
        this.pid = pid;
    }

    /**
     * Takes in super initiators
     * @param op The op mode this is used for
     */
    public DriveTrain(LinearOpMode op){
        super(op);
        this.autonMotorConfiguration = null;
    }

    /**
     * Drives using the joystick with the defined speed <br/>
     * @param c The controller to move the robot with
     */
    public abstract void driveWithController(Controller c);

    /**
     * moves every drive train motor forward/backward
     * @param power The speed to move the motors
     */
    public void setUniformDrivePower(double Power){
        for(DriveTrainMotor motor : getDrivetrainMotor())
            if(motor.get()!=null)
                motor.get().setPower(power);
    }

    /**
     * Sets the power of each individual motor
     * @param leftSidePower Left motors' power
     * @param rightSidePower right motors' power
     */
    public void setSidedDrivePower(double leftSidePower, double rightSidePower){
        DrivetrainMotor flm = getDrivetrainMotor(MotorType.DrivetrainPosition.FLM);
        DrivetrainMotor frm = getDrivetrainMotor(MotorType.DrivetrainPosition.FRM);
        DrivetrainMotor blm = getDrivetrainMotor(MotorType.DrivetrainPosition.BLM);
        DrivetrainMotor brm = getDrivetrainMotor(MotorType.DrivetrainPosition.BLM);
        if(flm != null && flm.get() != null) flm.get().setPower(leftSidePower);
        if(frm != null && frm.get() != null) frm.get().setPower(rightSidePower);
        if(blm != null && blm.get() != null) blm.get().setPower(leftSidePower);
        if(brm != null && brm.get() != null) brm.get().setPower(rightSidePower);
    }

    /**
     * Sets the power of each individual motor
     * @param flmPower Front left motor power
     * @param frmPower Front right motor power
     * @param blmPower Back left motor power
     * @param brmPower Back right motor power
     */
    public void setIndividualDrivePower(double flmPower, double frmPower, double blmPower, double brmPower){
        DrivetrainMotor flm = getDrivetrainMotor(MotorType.DrivetrainPosition.FLM);
        DrivetrainMotor frm = getDrivetrainMotor(MotorType.DrivetrainPosition.FRM);
        DrivetrainMotor blm = getDrivetrainMotor(MotorType.DrivetrainPosition.BLM);
        DrivetrainMotor brm = getDrivetrainMotor(MotorType.DrivetrainPosition.BLM);
        if(flm != null && flm.get() != null) flm.get().setPower(flmPower);
        if(frm != null && frm.get() != null) frm.get().setPower(frmPower);
        if(blm != null && blm.get() != null) blm.get().setPower(blmPower);
        if(brm != null && brm.get() != null) brm.get().setPower(brmPower);
    }

    /**
     * turns each drive train motor
     * @param power The speed to move the motor
     */
    public void setTurningDrivePower(double power){
        
    }
}