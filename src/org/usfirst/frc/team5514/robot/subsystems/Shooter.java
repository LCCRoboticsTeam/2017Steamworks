package org.usfirst.frc.team5514.robot.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {

    // Put methods for controlling this subsystem
	// here. Call these from Commands.

	CANTalon shooter, linearActuator, indexer;
	Joystick driveStick;
	
	public Shooter(int shooterPort, int linearPort, int indexerPort, Joystick driveStick){
		shooter = new CANTalon(shooterPort);
		linearActuator = new CANTalon(linearPort);
		indexer = new CANTalon(indexerPort);
		
		shooter.setInverted(true);
		
		this.driveStick = driveStick;
		shooter.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(null);
    }
    
    public void setShooterSpeed(double speed){
    	shooter.set(speed);
    }
    
    public void setLinearActuatorSpeed(double speed){
    	linearActuator.set(speed);
    }
    
    public void setIndexerSpeed(double speed){
    	indexer.set(speed);
    }

	public double getShooterSpeed() {
		return shooter.get();
	}
    
    
    
    
}

