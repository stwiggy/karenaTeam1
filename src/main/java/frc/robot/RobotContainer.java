// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.Intaker;

public class RobotContainer {
  public static final Intaker intaker = new Intaker();
  public static final Shooter shooter = new Shooter();
  public static final XboxController controller = new XboxController(0);
  public static final Drivetrain drivetrain = new Drivetrain(controller);


  public RobotContainer() {
    configureBindings();
  }

  //bind buttons and commands
  private void configureBindings() {
    JoystickButton buttonA = new JoystickButton(controller, 1);
    JoystickButton buttonX = new JoystickButton(controller, 3);
    JoystickButton buttonY = new JoystickButton(controller, 4);

    buttonA.onTrue(new InstantCommand(() -> {intaker.onOff++;}));
    buttonX.onTrue(new InstantCommand(() -> {drivetrain.isTank = true;}));
    buttonY.onTrue(new InstantCommand(() -> {drivetrain.isTank = false;}));
  }

  public Command getAutonomousCommand(){
    return new Autonomous(drivetrain);
  }
}