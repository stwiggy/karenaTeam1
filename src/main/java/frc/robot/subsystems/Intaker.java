// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intaker extends SubsystemBase {
  public int onOff = 0;
  private static CANSparkMax intakeMotor = MotorControllerFactory.createSparkMax(0, MotorConfig.NEO);

  /** Creates a new Intaker. */
  public Intaker() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("on(even) or off(odd)", onOff);
  }

  public void suck(){
    intakeMotor.set(0.75);
  }

  public void stop(){
    intakeMotor.set(0);
  }
}
