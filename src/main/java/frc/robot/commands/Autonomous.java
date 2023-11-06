// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Timer;

//this should work now
public class Autonomous extends CommandBase {
  Drivetrain drivetrain;
  private final Timer time = new Timer();

  /** Creates a new Autonomous. */
  public Autonomous(Drivetrain dt) {
    addRequirements(drivetrain = dt);
  }

  @Override
  public void initialize() {
    time.reset();
    time.start();
    drivetrain.drive(Constants.Autonomous.kLeftAutoSpeed, Constants.Autonomous.kRightAutoSpeed);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.drive(0, 0);
  }

  @Override
  public boolean isFinished() {
    return time.get() > Constants.Autonomous.kAutoLength;
  }
}
