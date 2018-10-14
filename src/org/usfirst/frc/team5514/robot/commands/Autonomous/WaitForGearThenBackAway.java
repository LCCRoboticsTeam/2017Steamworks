package org.usfirst.frc.team5514.robot.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team5514.robot.Robot;
/**
 *
 */
public class WaitForGearThenBackAway extends Command {

		Timer timer;
	
    public WaitForGearThenBackAway() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(timer == null){
    		if(!Robot.gearSwitch.get()){
    			timer.start();
    		}
    	}else{
    		if(timer.get()<.75){
    			Robot.driveTrain.driveInArc(1, 0);
    		}else if(timer.get() < 1.25){
    			Robot.driveTrain.driveInArc(-.7,1);
    		}else if(timer.get() < 2.5){
    			Robot.driveTrain.driveInArc(-1, 0);
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() > 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
