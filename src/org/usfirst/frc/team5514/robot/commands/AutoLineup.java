package org.usfirst.frc.team5514.robot.commands;

import org.usfirst.frc.team5514.robot.Robot;
import org.usfirst.frc.team5514.robot.RobotMap;
import org.usfirst.frc.team5514.robot.subsystems.UDPServer;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 *
 */
public class AutoLineup extends Command {

	UDPServer camera;
	int targetOffset = RobotMap.SHOOTER_TARGET_OFFSET;
	int deadZone = RobotMap.SHOOTER_TARGET_DEADZONE;
	int currentOffset = 0;
	int totalArea = 0;
	
    public AutoLineup(UDPServer cameraData) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	camera = cameraData;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	camera.getPacket();
    	currentOffset = camera.getOffset();
    	totalArea = camera.getTotalArea();

    	if(totalArea != 0){
    		if(currentOffset > deadZone+targetOffset || currentOffset < targetOffset-deadZone){// 15
    			if(currentOffset > deadZone+targetOffset ){
        			Robot.driveTrain.driveInArc(RobotMap.AUTO_TURN_SPEED, -1);
        		}else if(currentOffset < targetOffset-deadZone){
        			Robot.driveTrain.driveInArc(RobotMap.AUTO_TURN_SPEED, 1);
        		}
    		}else{
    			Robot.driveTrain.driveInArc(0, 0);
    		}
    	}

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(currentOffset - targetOffset) < deadZone;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
