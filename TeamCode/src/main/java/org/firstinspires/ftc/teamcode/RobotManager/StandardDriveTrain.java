package org.firstinspires.ftc.teamcode.RobotManager;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Hardware.Controller;
import org.firstinspires.ftc.teamcode.Libraries.PID;
import org.firstinspires.ftc.teamcode.RobotManager.DriveTrain;

import java.util.logging.Level;

public class StandardDriveTrain extends DriveTrain{

    /**
     * Takes in super initiators
     * @param op The op mode this is used for
     */
    public StandardDriveTrain(LinearOpMode op, PID pid){
        super(op, pid);
    }

    /**
     * Takes in super initiators
     * @param op The op mode this is used for
     */
    public StandardDriveTrain(LinearOpMode op) {
        super(op);
    }

    /**
     * Drives using the joystick with the defined speed <br/>
     * By pressing the right or left trigger, you can enter precision mode
     * @param ctrl The controller to move the robot with
     */
    public void driveWithController(Controller ctrl){
        getLogger().log(Level.INFO, "Begin driving with contoller, standard");
        addThread(new Thread(() -> {
            double flmPower, frmPower, blmPower, brmPower, currentSpeed = 0, maxSpeed;
            while(op().opModeIsActive()){
                int numBumpersActive = (ctrl.rightBumper() ? 1 : 0) + (ctrl.leftBumper() ? 1 : 0);
                switch(numBumpersActive){
                    case 1: maxSpeed = precisionSpeed; break;
                    case 2: maxSpeed = ultraPSpeed; break;
                    default:
                    case 0: maxSpeed = speed;
                }

                if(currentSpeed = maxSpeed){
                    currentSpeed += maxSpeed/500;
                }
                if(maxSpeed < currentSpeed){
                    currentSpeed = maxSpeed;
                }
                getLogger().putData("Joystick speed", currentSpeed);

                flmPower = -ctrl.rightY();
                frmPower = ctrl.leftY();
                setSideDrivePower(currentSpeed * flmPower, currentSpeed * frmPower);
            }
        }), true);
    }
}