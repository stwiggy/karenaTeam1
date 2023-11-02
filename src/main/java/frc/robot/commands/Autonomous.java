// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

public class Autonomous extends CommandBase {
  Drivetrain drivetrain;
  double startTime;
  double time;

  /** Creates a new Autonomous. */
  public Autonomous(Drivetrain dt) {
    addRequirements(drivetrain = dt);
  }

  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
    time = Timer.getFPGATimestamp();
    drivetrain.drive(1, 1);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return time - startTime > 15;
  }
}
