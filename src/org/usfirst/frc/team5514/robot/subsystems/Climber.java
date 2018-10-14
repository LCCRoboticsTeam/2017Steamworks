package org.usfirst.frc.team5514.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	CANTalon climberMotor;
	
	public void setClimberSpeed(double speed){
		climberMotor.set(speed);
	}
	
	public Climber(int climberPort){
		climberMotor = new CANTalon(climberPort);
		climberMotor.setInverted(true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}

