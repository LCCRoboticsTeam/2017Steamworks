package org.usfirst.frc.team5514.robot.commands.Autonomous;

import org.usfirst.frc.team5514.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoOnlyDriveStraight extends Command {

	Timer timer;

    public AutoOnlyDriveStraight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
		requires(Robot.driveTrain);
		timer = new Timer();
	}

    // Called just before this Command runs the first time
    protected void initialize() {
		timer.start();
	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		Robot.driveTrain.driveInArc(.4, 0);
	}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get()>5;
    }

    // Called once after isFinished returns true
    protected void end() {
	Robot.driveTrain.driveInArc(0, 0);
	timer.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
