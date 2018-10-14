package org.usfirst.frc.team5514.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallLift extends Subsystem {
	
	CANTalon liftMotor;
	
	public BallLift(int motorNumber){
		liftMotor = new CANTalon(motorNumber);
	}
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void disableLift(){
		liftMotor.set(0);
	}
	
	public void enableLift(){
		liftMotor.set(1);
	}
	
	public double ballLiftSpeed(){
		return liftMotor.get();
	}
	
    public void initDefaultCommand() {
    }
}

