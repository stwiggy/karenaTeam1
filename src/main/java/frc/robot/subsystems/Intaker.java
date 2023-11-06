// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intaker extends SubsystemBase {
  public boolean off = false;
  public int onOff = 0;
  private static CANSparkMax intakeMotor = MotorControllerFactory.createSparkMax(3, MotorConfig.NEO);

  /** Creates a new Intaker. */
  public Intaker() {}

  public void suck(){
    intakeMotor.set(0.75);
  }

  public void stop(){
    intakeMotor.set(0);
  }

  //how to call functions in lambda?
  public void onOff(){
    off = !off;
  }

  @Override
  public void periodic(){
    if (onOff % 2 == 0){
      stop();
    }
    else{
      suck();
    }
  }
}
