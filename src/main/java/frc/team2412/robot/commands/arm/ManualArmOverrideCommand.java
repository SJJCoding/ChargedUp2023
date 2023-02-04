package frc.team2412.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.team2412.robot.subsystems.ArmSubsystem;
import java.util.function.DoubleSupplier;

public class ManualArmOverrideCommand extends CommandBase {

	private ArmSubsystem armSubsystem;
	private DoubleSupplier armJoystickInput;
	private DoubleSupplier wristJoystickInput;

	public ManualArmOverrideCommand(
			ArmSubsystem armSubsystem,
			DoubleSupplier armJoystickInput,
			DoubleSupplier wristJoystickInput) {
		this.armSubsystem = armSubsystem;
		this.armJoystickInput = armJoystickInput;
		this.wristJoystickInput = wristJoystickInput;
	}

	@Override
	public void initialize() {
		armSubsystem.setManualOverride(true);
	}

	@Override
	public void execute() {
		armSubsystem.setArmMotor(armJoystickInput.getAsDouble());
		armSubsystem.setWristMotor(wristJoystickInput.getAsDouble());
	}

	@Override
	public boolean isFinished() {
		return false;
	}
}
