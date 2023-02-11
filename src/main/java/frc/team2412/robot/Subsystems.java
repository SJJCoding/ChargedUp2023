package frc.team2412.robot;

import static frc.team2412.robot.Subsystems.SubsystemConstants.*;

import frc.team2412.robot.subsystems.ArmSubsystem;
import frc.team2412.robot.subsystems.DrivebaseSubsystem;
import frc.team2412.robot.subsystems.IntakeSubsystem;
import frc.team2412.robot.subsystems.VisionSubsystem;

public class Subsystems {
	public static class SubsystemConstants {
		public static final boolean DRIVEBASE_ENABLED = true;
		public static final boolean ARM_ENABLED = false;
		public static final boolean INTAKE_ENABLED = false;
		public static final boolean VISION_ENABLED = false;
	}

	public DrivebaseSubsystem drivebaseSubsystem;
	public ArmSubsystem armSubsystem;
	public IntakeSubsystem intakeSubsystem;
	public VisionSubsystem visionSubsystem;

	public Subsystems() {
		boolean comp = Robot.getInstance().isCompetition();

		if (DRIVEBASE_ENABLED) {
			drivebaseSubsystem = new DrivebaseSubsystem();
			if (VISION_ENABLED) {
				visionSubsystem = new VisionSubsystem(drivebaseSubsystem::addVisionMeasurement);
			}
		}
		if (!comp) {
			return;
		}
		if (ARM_ENABLED) {
			armSubsystem = new ArmSubsystem();
		}
		if (INTAKE_ENABLED) {
			intakeSubsystem = new IntakeSubsystem();
		}
	}
}
