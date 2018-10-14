package org.usfirst.frc.team5514.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc.team5514.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);
	
	Joystick driveStick = new Joystick(0);
	Button a = new JoystickButton(driveStick, 1);
	Button b = new JoystickButton(driveStick, 2);
	Button x = new JoystickButton(driveStick, 3);
	Button y = new JoystickButton(driveStick, 4);
	Button leftBumper = new JoystickButton(driveStick, 5);
	Button rightBumper = new JoystickButton(driveStick, 6);
	Button select = new JoystickButton(driveStick, 7);
	Button start = new JoystickButton(driveStick, 8);
	Button leftStickButton = new JoystickButton(driveStick, 9);
	Button rightStickButton = new JoystickButton(driveStick, 10);
		
	public OI(){ 
		
		//if null button isn't attributed to a command yet
		a.whileHeld(new AutoLineup(Robot.shooterCamerea));
		b.whenPressed(new LowerSideDoor()); 
		x.whenPressed(new ToggleBallLift());
		y.whenPressed(new RaiseSideDoor());
		leftBumper.whenPressed(new Climb());
		leftBumper.whenReleased(new StopClimb());
		rightBumper.whenPressed(new ShootBall());
		rightBumper.whenReleased(new StopShooter());
		//select.whenPressed(null);
		start.whenPressed(new ToggleShooter());
		//leftStickButton.whenPressed(null);
		rightStickButton.whenPressed(new FullyExtendDart());
	}

	
	
	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
