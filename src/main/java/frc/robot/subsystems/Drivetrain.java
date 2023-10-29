package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.carlmontrobotics.lib199.MotorControllerFactory;
import org.carlmontrobotics.lib199.MotorConfig;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private static CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(0, MotorConfig.NEO);
    //public static CANSparkMax leftMotor2 = MotorControllerFactory.createSparkMax(1, MotorConfig.NEO);
    private static CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(2, MotorConfig.NEO);
    //public static CANSparkMax rightMotor2 = MotorControllerFactory.createSparkMax(3, MotorConfig.NEO);

    //if this starts as true, it will be tank
    //if this starts as false, it will be arcade

    public boolean isTank = true;
    
    public Drivetrain(){

    }

    public void drive(double leftY, double rightY){
        leftMotor.set(leftY * leftY * leftY);
        //leftMotor2.set(leftY);
        rightMotor.set(rightY * rightY * rightY);
        //rightMotor2.set(rightY);
    }

    public void arcadeDrive(double speed, double turn){
        speed *= Constants.kSpeedSlowdown;
        turn *= Constants.kTurnSlowdown;
        
        double left = speed + turn;
        double right = speed - turn;
        
        drive(left, right);
    }
}
