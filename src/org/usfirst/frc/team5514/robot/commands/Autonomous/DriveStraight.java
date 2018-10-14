package org.usfirst.frc.team5514.robot.commands.Autonomous;

import org.usfirst.frc.team5514.robot.Robot;
import org.usfirst.frc.team5514.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraight extends Command {

	Timer timer;
	
    public DriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	timer = new Timer();
    	timer.start();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveTrain.driveInArc(-RobotMap.AUTO_DRIVE_SPEED, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get()>1;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.driveInArc(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
