package org.usfirst.frc.team2363.robot;

import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.drivetrain.OmniDrive;
import org.usfirst.frc.team2363.robot.commands.drivetrain.ShiftCommand;
import org.usfirst.frc.team2363.robot.commands.drivetrain.TractionDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick ps4Controller;
	
	public OI() {
		ps4Controller = new Joystick(PS4_PORT);
		
		new JoystickButton(ps4Controller, L3).whenPressed(new TractionDrive());
		new JoystickButton(ps4Controller, R3).whenPressed(new OmniDrive());
		new JoystickButton(ps4Controller, L1).whenPressed(new ShiftCommand(false));
		new JoystickButton(ps4Controller, R1).whenPressed(new ShiftCommand(true));
	}
	
	public boolean isFrontDeployed() {
		return ps4Controller.getRawAxis(RIGHT_STICK_Y) < -0.6;
	}
	
	public boolean isRearDeployed() {
		return ps4Controller.getRawAxis(RIGHT_STICK_Y) > 0.6;
	}
	
	public double getThrottle() {
		return -ps4Controller.getRawAxis(LEFT_STICK_Y);
	}

	public double getTurn() {
		return -ps4Controller.getRawAxis(RIGHT_STICK_X) * getTurnScaling(getThrottle());
	}

	public static double getTurnScaling(double x) {
		return -Math.abs(LOW_SPEED_SCALING - HIGH_SPEED_SCALING) * x + LOW_SPEED_SCALING;
	}
}

