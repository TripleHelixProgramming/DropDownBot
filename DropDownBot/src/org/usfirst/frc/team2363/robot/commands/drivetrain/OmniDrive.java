package org.usfirst.frc.team2363.robot.commands.drivetrain;

import static org.usfirst.frc.team2363.robot.Robot.*;

public class OmniDrive extends AbstractButterflyDrive {
	
	public OmniDrive() {
		requires(drivetrain);
	}

	@Override
	protected void defaultDrive() {
		drivetrain.deployFront();
		drivetrain.deployRear();
	}
}
