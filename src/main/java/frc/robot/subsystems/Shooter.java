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
  private boolean off = true;
  CANSparkMax shooterMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kShooterID, MotorConfig.NEO);
  RelativeEncoder shootEncoder = shooterMotor.getEncoder();

  //ask about using CANSparkMax's built in pid controller vs this one, what are differences?
  PIDController pid = new PIDController(Constants.Shooter.kP, Constants.Shooter.kI, Constants.Shooter.kD);
  private double goalRPM = 0;

  /** Creates a new Shooter. */
  public Shooter() {}

  public void onOff(){
    off = !off;
  }

  public void setStdRPM(){
    goalRPM = Constants.Shooter.kShootWantedRPM;
  }

  public void stopShooter(){
    goalRPM = 0;
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Shooter speed", shootEncoder.getVelocity());
    SmartDashboard.putNumber("Shooter goal", goalRPM);
    SmartDashboard.putBoolean("off", off);

    //getVelocity gets the current RPM
    if (goalRPM != 0){
      double pidOut = pid.calculate(shootEncoder.getVelocity(), goalRPM);
      SmartDashboard.putNumber("PID output", pidOut);
      shooterMotor.set(-pidOut);
    }

    if (off){setStdRPM();}
    else{stopShooter();}
  }

}
