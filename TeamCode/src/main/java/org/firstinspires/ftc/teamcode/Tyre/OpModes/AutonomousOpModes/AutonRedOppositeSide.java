package org.firstinspires.ftc.teamcode.Tyre.OpModes.AutonomousOpModes;

import static org.firstinspires.ftc.teamcode.Tyre.AutonFunctions.FieldPosition.DIFFERENT;
import static org.firstinspires.ftc.teamcode.Tyre.AutonFunctions.TeamColor.RED;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Tyre.AutonFunctions;

@Autonomous
@Config
public class AutonRedOppositeSide extends LinearOpMode {
    @Override
    public void runOpMode()throws InterruptedException{
        AutonFunctions.startNew(this,RED,DIFFERENT);
    }
}
