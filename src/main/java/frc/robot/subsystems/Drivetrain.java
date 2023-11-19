package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.carlmontrobotics.lib199.MotorControllerFactory;
import org.carlmontrobotics.lib199.MotorConfig;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private static CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kLeftDriveID, MotorConfig.NEO);
    private static CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kRightDriveID, MotorConfig.NEO);
    private XboxController controller;
    public boolean isTank = false;
    
    public Drivetrain(XboxController controller){
        this.controller = controller;
    }

    public void drive(double leftY, double rightY){
        leftMotor.set(Math.pow(leftY, 3));
        rightMotor.set(Math.pow(-rightY ,3));
    }

    public void arcadeDrive(double speed, double turn){
        speed *= Constants.Drivetrain.kSpeedSlowdown;
        turn *= Constants.Drivetrain.kTurnSlowdown;
        
        double left = speed + turn;
        double right = speed - turn;
        
        //drive(left, right);
        leftMotor.set(left);
        rightMotor.set(-right);
    }

    @Override
    public void periodic(){
        if (isTank){
            drive(0 - controller.getLeftY(), 0 - controller.getRightY());
        }
        else{
            arcadeDrive(0 - controller.getLeftY(), 0 - controller.getRightX());
        }
    }
}
