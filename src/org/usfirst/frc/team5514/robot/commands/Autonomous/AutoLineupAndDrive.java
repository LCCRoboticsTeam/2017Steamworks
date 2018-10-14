package org.usfirst.frc.team5514.robot.commands.Autonomous;

import org.usfirst.frc.team5514.robot.Robot;
import org.usfirst.frc.team5514.robot.RobotMap;
import org.usfirst.frc.team5514.robot.subsystems.UDPServer;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoLineupAndDrive extends Command {

	UDPServer camera;
	int currentArea, currentOffset;
	boolean isFinished;
	
    public AutoLineupAndDrive(UDPServer cameraIn) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	camera = cameraIn;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	 isFinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	camera.getPacket();
    	currentArea = camera.getTotalArea();
    	currentOffset = camera.getOffset();
    	if(currentArea > RobotMap.GEAR_MIN_AREA && currentArea < RobotMap.GEAR_TARGET_AREA){
    		if(currentOffset > RobotMap.GEAR_TARGET_OFFSET + RobotMap.GEAR_DEADZONE){
    			Robot.driveTrain.driveInArc(RobotMap.AUTO_TURN_SPEED, 1);
    		}else if(currentArea < RobotMap.GEAR_MIN_AREA - RobotMap.GEAR_DEADZONE){
    			Robot.driveTrain.driveInArc(RobotMap.AUTO_TURN_SPEED, -1);
    		}else{
    			Robot.driveTrain.driveInArc(RobotMap.AUTO_DRIVE_SPEED, -1);
    		}
    	}else{
    		Robot.driveTrain.driveInArc(0, 0);
    		isFinished = true;
    	}
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
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
