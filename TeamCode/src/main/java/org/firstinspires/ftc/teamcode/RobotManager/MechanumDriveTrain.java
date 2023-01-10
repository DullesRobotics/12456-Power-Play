package org.firstinspires.ftc.teamcode.RobotManager;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Hardware.Motor.DrivetrainMotor;
import org.firstinspires.ftc.teamcode.Hardware.Motor.MotorType;
import org.firstinspires.ftc.teamcode.Libraries.IMU;
import org.firstinspires.ftc.teamcode.Libraries.PID;

import java.util.logging.Level;

public class MechanumDriveTrain extends StandardDriveTrain{

    /**
    * Takes in Super Initiator
    * @param op The Op mode used
    */
    public MechanumDriveTrain(LinearOpMode op, PID pid){
        super(op,pid);
    }

    /**
    * Takes in Super Initiator
    * @param op The Op mode used
    */
    public MechanumDriveTrain(LinearOpMode op){
        super(op);
    }

    /**
     * Driving with the controller, including strafing
     * Hold either bumper for precision mode
     * @param ctrl The controller to move the robot with
     */
    @Override
    public void driveWithController(Controller ctrl){
        getLogger().log(Level.INFO, "Starting Drive with contoller, Mechanum");
        addThread(new Thread() -> {
            double flmPower, frmPower, blmPower, brmPower, currentSpeed = 0, maxSpeed;
            while(op().opModeIsActive()){
                int numBumpersActive = (ctrl.rightBumper() ? 1 : 0) +(ctrl.leftBumper() ? 1 : 0);
                switch(numBumpersActive){
                    case 1: maxSpeed = precisionSpeed; break;
                    case 2: maxSpeed = ultraPSpeed; break;
                    default:
                    case 0: maxSpeed = speed;
                }

                if(currentSpeed = maxSpeed){
                    currentSpeed += maxSpeed/1000;
                }
                if(maxSpeed < currentSpeed){
                    currentSpeed = maxSpeed;
                }
                getLogger().putData("Joystick speed", currentSpeed);

                flmPower = ctrl.leftY() + ctrl.leftTrigger() - ctrl.rightTrigger();
                blmPower = ctrl.leftY() + ctrl.rightTrigger() - ctrl.leftTrigger();
                frmPower = ctrl.rightY() - ctrl.leftTrigger + ctrl.rightTrigger();
                brmPower = ctrl.rightY() - ctrl.rightTrigger() + ctrl.leftTrigger();

                setIndividualDrivePower(currentSpeed * flmPower, currentSpeed * frmPower, currentSpeed * blmPower, currentSpeed * brmPower);
            }
        }), true, () -> getLogger().clearData());
    }

}
