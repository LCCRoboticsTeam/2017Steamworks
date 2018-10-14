
package org.usfirst.frc.team5514.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team5514.robot.subsystems.*;
import org.usfirst.frc.team5514.robot.commands.MoveDartDown;
import org.usfirst.frc.team5514.robot.commands.MoveDartUp;
import org.usfirst.frc.team5514.robot.commands.StopDart;
/*import org.usfirst.frc.team5514.robot.commands.Autonomous.AutoOnlyDriveStraight;
import org.usfirst.frc.team5514.robot.commands.Autonomous.AutoStartFromCenter;
import org.usfirst.frc.team5514.robot.commands.Autonomous.AutoStartFromLeftSide;
import org.usfirst.frc.team5514.robot.commands.Autonomous.AutoStartFromRightSide;
*/
import org.usfirst.frc.team5514.robot.commands.Autonomous.AutoOnlyDriveStraight;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static Joystick driveStick = new Joystick(RobotMap.DRIVE_STICK_PORT);
	public static DriveTrain driveTrain = new DriveTrain(RobotMap.FRONT_LEFT_MOTOR, RobotMap.BACK_LEFT_MOTOR, RobotMap.FRONT_RIGHT_MOTOR, RobotMap.BACK_RIGHT_MOTOR, driveStick);
	public static Shooter shooter = new Shooter(RobotMap.SHOOTER_MOTOR, RobotMap.LINEAR_ACTUATOR_MOTOR, RobotMap.INDEX_MOTOR, driveStick);
	public static SideDoor sideDoor = new SideDoor(RobotMap.SIDE_DOOR_MOTOR);
	public static BallLift ballLift = new BallLift(RobotMap.BALL_LIFT_MOTOR);
	public static Climber climber = new Climber(RobotMap.CLIMBER_MOTOR);
	public static UsbCamera driverCamera= new UsbCamera("cam1", 1);
	public static UDPServer pegCamera = new UDPServer(RobotMap.PEG_PORT, RobotMap.UDP_PACKET_SIZE);
	public static UDPServer shooterCamerea = new UDPServer(RobotMap.SHOOTER_PORT, RobotMap.UDP_PACKET_SIZE);
	public static DigitalInput gearSwitch = new DigitalInput(RobotMap.GEAR_SWITCH);
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
		/*chooser.addObject("AutoOnlyDriveStraight", new AutoOnlyDriveStraight());
		chooser.addObject("AutoStartFromLeftSide", new AutoStartFromLeftSide());
		chooser.addObject("AutpStartFromCenter", new AutoStartFromCenter());
		chooser.addObject("AutoStartFromRightSide", new AutoStartFromRightSide());*/
		
		SmartDashboard.putData("Auto mode", chooser);
		
		CameraServer.getInstance().addCamera(driverCamera);		
		CameraServer.getInstance().startAutomaticCapture();

		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = new AutoOnlyDriveStraight();//chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

	
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null){
			autonomousCommand.cancel();
		}
		
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	 

		if(driveStick.getPOV() == 0){
			Scheduler.getInstance().add(new MoveDartUp());
		}else if(driveStick.getPOV() == 180){
			Scheduler.getInstance().add(new MoveDartDown());
		}else{
			Scheduler.getInstance().add(new StopDart());
		}
		
		pegCamera.getPacket();
		shooterCamerea.getPacket();
		SmartDashboard.putNumber("PegCamera Offset", pegCamera.getOffset());
		SmartDashboard.putNumber("ShooterCamera Offset", shooterCamerea.getOffset());
		SmartDashboard.putNumber("PegCamera Area", pegCamera.getTotalArea());
		SmartDashboard.putNumber("ShooterCamera Area", shooterCamerea.getTotalArea());
		SmartDashboard.putBoolean("DIO Gear value", gearSwitch.get());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
