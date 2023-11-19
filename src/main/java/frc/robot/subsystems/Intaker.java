// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intaker extends SubsystemBase {
  public boolean off = true;
  private static CANSparkMax intakeMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kIntakeID, MotorConfig.NEO);

  /** Creates a new Intaker. */
  public Intaker() {}

  public void suck(){
    intakeMotor.set(0.75);
  }

  public void stop(){
    intakeMotor.set(0);
  }

  public void onOff(){
    off = !off;
  }

  @Override
  public void periodic(){
    if (off){stop();}
    else{suck();}
  }
}
