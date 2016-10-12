package org.usfirst.frc.team2363.robot.subsystems;

import static org.usfirst.frc.team2363.robot.RobotMap.*;

import org.usfirst.frc.team2363.robot.commands.drivetrain.TractionDrive;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	private SpeedController frontLeft = new Talon(FRONT_LEFT_TALON_CHANNEL);
	private SpeedController frontRight = new Talon(FRONT_RIGHT_TALON_CHANNEL);
	private SpeedController rearLeft = new Talon(REAR_LEFT_TALON_CHANNEL);
	private SpeedController rearRight = new Talon(REAR_RIGHT_TALON_CHANNEL);
	
	private DoubleSolenoid frontOmni = new DoubleSolenoid(FRONT_DROPDOWN_1, FRONT_DROPDOWN_2);
	private DoubleSolenoid rearOmni = new DoubleSolenoid(REAR_DROPDOWN_1, REAR_DROPDOWN_2);
	private DoubleSolenoid shifters = new DoubleSolenoid(SHIFTER_1, SHIFTER_2);
	
	private RobotDrive robotDrive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);

	public void arcadeDrive(double throttle, double turn) {
		robotDrive.arcadeDrive(throttle, turn);
	}
	
	public void deployFront() {
		frontOmni.set(Value.kForward);
	}
	
	public void retractFront() {
		frontOmni.set(Value.kReverse);
	}
	
	public void deployRear() {
		rearOmni.set(Value.kForward);
	}
	
	public void retractRear() {
		rearOmni.set(Value.kReverse);
	}
	
	public void shiftUp() {
		shifters.set(Value.kForward);
	}
	
	public void shiftDown() {
		shifters.set(Value.kReverse);
	}
	
	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new TractionDrive());
	}
	
}
