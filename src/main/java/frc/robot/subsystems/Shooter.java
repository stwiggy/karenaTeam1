// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {

  CANSparkMax shooterMotor = MotorControllerFactory.createSparkMax(5, MotorConfig.NEO);
  RelativeEncoder shootEncoder = shooterMotor.getEncoder();
  PIDController pid = new PIDController(Constants.kP, Constants.kI, Constants.kD);
  private double goalRPM = 0;

  /** Creates a new Shooter. */
  public Shooter() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Shooter speed", shootEncoder.getVelocity());
    SmartDashboard.putNumber("Shooter goal", goalRPM);

    if (goalRPM != 0){
      double pidOut = pid.calculate(shootEncoder.getVelocity(), goalRPM);
      SmartDashboard.putNumber("PID output", pidOut);
      shooterMotor.set(pidOut);
    }
  }

  //getVelocity gets the RPM
  public void setStdRPM(){
    goalRPM = Constants.kShootWantedRPM;
  }

  public void stopShooter(){
    goalRPM = 0;
  }
}
