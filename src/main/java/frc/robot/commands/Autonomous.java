// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Timer;

//this should work now
public class Autonomous extends CommandBase {
  Drivetrain drivetrain;
  private final Timer time = new Timer();
  CANSparkMax TEST = MotorControllerFactory.createSparkMax(2, MotorConfig.NEO);

  /** Creates a new Autonomous. */
  public Autonomous(Drivetrain dt) {
    this.drivetrain = dt;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {
    time.start();
    //drivetrain.drive(0.5, 0.5);
    TEST.set(0.5);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return time.get() > 5;
  }
}
