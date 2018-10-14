package org.usfirst.frc.team5514.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SideDoor extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	CANTalon sideDoor;
	
	public SideDoor(int sideDoorMotorPort){
		sideDoor = new CANTalon(sideDoorMotorPort);
	}
	
	
	public void setSideDoorSpeed(double speed){
		sideDoor.set(speed);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * 
     * @param brakeEnabled true sets brakeMode to enabled; false sets it to disabled
     */
    public void setBrakeMode(boolean brakeEnabled){
    	sideDoor.enableBrakeMode(brakeEnabled);
    }
}

