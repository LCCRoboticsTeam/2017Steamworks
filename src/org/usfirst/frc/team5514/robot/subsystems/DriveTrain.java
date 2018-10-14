package org.usfirst.frc.team5514.robot.subsystems;

import org.usfirst.frc.team5514.robot.commands.Drive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon frontLeft, backLeft, frontRight, backRight;
	RobotDrive robotDrive;
	Joystick driveStick;
	
	/**
	 * 
	 * @param frontLeft pass the int of the motor controller being used for each motor
	 * @param backLeft
	 * @param frontRight
	 * @param backRight
	 * @param driveStick pass initialized Joystick to be used for driving
	 */
	public DriveTrain(int frontLeft, int backLeft, int frontRight, int backRight, Joystick driveStick){
		this.frontLeft = new CANTalon(frontLeft);
		this.backLeft = new CANTalon(backLeft);
		this.frontRight= new CANTalon(frontRight);
		this.backRight= new CANTalon(backRight);
		
		invertMotors();
		
		this.driveStick = driveStick;
		robotDrive = new RobotDrive(this.frontLeft,this.backLeft, this.frontRight, this.backRight);
	}
	
	public void invertMotors(){
		frontLeft.setInverted(true);
		frontRight.setInverted(true);
		backLeft.setInverted(true);
		backRight.setInverted(true);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new Drive());
    }
    
    /**
     * calls arcadeDrive using the driveStick provided.
     */
    public void arcadeDrive(){
    	robotDrive.arcadeDrive(driveStick);
    }
    
    /**
     * Drive the motors at "outputMagnitude" and "curve". Both outputMagnitude and curve are -1.0 to +1.0 values, where 0.0 represents stopped and not turning. curve < 0 will turn left and curve > 0 will turn right. 

	*The algorithm for steering provides a constant turn radius for any normal speed range, both forward and backward. Increasing sensitivity causes sharper turns for fixed values of curve. 

     *This function will most likely be used in an autonomous routine.

     * @param power
     * @param curve
     * 
     * 

     */
    public void driveInArc(double power, double curve){
    	robotDrive.drive(power, curve);
    }
    
}

