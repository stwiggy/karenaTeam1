// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.Shoot;


public class RobotContainer {

  public static final Drivetrain drivetrain = new Drivetrain();
  public static final Shooter shooter = new Shooter();
  public static XboxController controller = new XboxController(0);

  public static CANSparkMax intakeMotor = MotorControllerFactory.createSparkMax(2, MotorConfig.NEO);

  public RobotContainer() {
    intakeMotor.set(1);
    configureBindings();
  }

  //bind buttons and commands
  private void configureBindings() {

    JoystickButton buttonA = new JoystickButton(controller, 1);

    //make button to turn on/off intake?
    //JoystickButton buttonB = new JoystickButton(controller, 2);

    JoystickButton buttonX = new JoystickButton(controller, 3);

    JoystickButton buttonY = new JoystickButton(controller, 4);

    buttonA.onTrue(new Shoot(shooter));
    buttonX.onTrue(new InstantCommand(() -> {drivetrain.isTank = true;}));
    buttonY.onTrue(new InstantCommand(() -> {drivetrain.isTank = false;}));
  }

  public void periodic(){
    // also make a thing for where when the intake takes a ball start a timer, when timer hits 4
    // secs and button A is not pressed, automatically eject the ball
    if (drivetrain.isTank == true){
      drivetrain.drive(0 - controller.getLeftY(), 0 - controller.getRightY());   
    }
    else {
      //drivetrain.arcadeDrive(controller.getRawAxis(1), controller.getRawAxis(4));
      drivetrain.arcadeDrive(controller.getLeftY(), 0 - controller.getRightX());
    }
  }

  public Command getAutonomousCommand(){
    return new Autonomous(drivetrain);
  }
}
