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
  public static final XboxController driver = new XboxController(Constants.OI.kDriverPort);
  public static final XboxController operator = new XboxController(Constants.OI.kOperatorPort);
  public static final Drivetrain drivetrain = new Drivetrain(driver);


  public RobotContainer() {
    configureBindings();
  }

  //bind buttons and commands
  private void configureBindings() {
    //these buttons a and b r for testing
    JoystickButton buttonA1 = new JoystickButton(driver, Constants.OI.kButtonANum);
    JoystickButton buttonB1 = new JoystickButton(driver, Constants.OI.kButtonBNum);
    JoystickButton buttonX1 = new JoystickButton(driver, Constants.OI.kButtonXNum);
    JoystickButton buttonY1 = new JoystickButton(driver, Constants.OI.kButtonYNum);

    JoystickButton leftBumper = new JoystickButton(operator, Constants.OI.kLeftBumperNum);
    JoystickButton rightBumper = new JoystickButton(operator, Constants.OI.kRightBumperNum);
    JoystickButton buttonA2 = new JoystickButton(operator, Constants.OI.kButtonANum);
    JoystickButton buttonB2 = new JoystickButton(operator, Constants.OI.kButtonBNum);
    JoystickButton buttonX2 = new JoystickButton(operator, Constants.OI.kButtonXNum);
    JoystickButton buttonY2 = new JoystickButton(operator, Constants.OI.kButtonYNum);

    buttonA1.onTrue(new InstantCommand(() -> {intaker.onOff++;}));
    buttonB1.onTrue(new InstantCommand(() -> {shooter.onOff++;}));
    buttonX1.onTrue(new InstantCommand(() -> {drivetrain.isTank = true;}));
    buttonY1.onTrue(new InstantCommand(() -> {drivetrain.isTank = false;}));
  }

  public Command getAutonomousCommand(){
    return new Autonomous(drivetrain);
  }
}