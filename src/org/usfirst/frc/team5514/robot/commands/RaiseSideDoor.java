package org.usfirst.frc.team5514.robot.commands;

import org.usfirst.frc.team5514.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RaiseSideDoor extends Command {

    Timer timer = new Timer();
	
	public RaiseSideDoor() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sideDoor);
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.sideDoor.setBrakeMode(true);
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.sideDoor.setSideDoorSpeed(.2);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return timer.get() > 8.5*.7;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.sideDoor.setSideDoorSpeed(0);
    	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
