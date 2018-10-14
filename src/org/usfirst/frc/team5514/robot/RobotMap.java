package org.usfirst.frc.team5514.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;

	//motor controllers 
	public static final int BACK_LEFT_MOTOR = 7;
	public static final int BACK_RIGHT_MOTOR = 5;
	public static final int FRONT_LEFT_MOTOR = 6;
	public static final int FRONT_RIGHT_MOTOR = 4;
	
	public static final int SHOOTER_MOTOR = 8;
	public static final int LINEAR_ACTUATOR_MOTOR = 2;
	public static final int INDEX_MOTOR = 9;
	public static final int SIDE_DOOR_MOTOR = 1;
	public static final int BALL_LIFT_MOTOR = 3;
	public static final int CLIMBER_MOTOR = 0;
	
	//Switches
	public static final int GEAR_SWITCH = 9;
	
	//Communication with jetson data
	public static final int SHOOTER_PORT = 5805;
	public static final int PEG_PORT = 5809;
	public static final int UDP_PACKET_SIZE = 64;

	//joystick
	public static final int DRIVE_STICK_PORT = 0;

	
	//Constants
	public static final double SHOOTER_SPEED = .8;//0 < x < 1
	public static final int SHOOTER_TARGET_OFFSET = 0;//try to test values for this
	public static final int SHOOTER_TARGET_DEADZONE = 5; //pixel difference allowed MUST BE POSITIVE
	public static final double AUTO_TURN_SPEED = .4;
	public static final int GEAR_TARGET_AREA = 18000;
	public static final int GEAR_MIN_AREA = 150;
	public static final double AUTO_DRIVE_SPEED = .5; //0 < x < 1
	public static final int GEAR_TARGET_OFFSET = 0;
	public static final int GEAR_DEADZONE = 5; //pixel difference allowed MUST BE POSITIVE
	
	
	
}

