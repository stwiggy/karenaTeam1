// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shoot extends CommandBase {
  Shooter shooter;
  double startTime;
  double time;
  public boolean shouldShoot = false;

  /** Creates a new Shoot. */
  public Shoot(Shooter shiter) {
    addRequirements(shooter = shiter);
  }

  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
    shooter.setStdRPM();
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    shooter.stopShooter();
  }

  @Override
  public boolean isFinished() {
    return Timer.getFPGATimestamp() - startTime > 5;
  }
}
