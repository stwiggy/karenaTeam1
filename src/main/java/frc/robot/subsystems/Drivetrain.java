package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.carlmontrobotics.lib199.MotorControllerFactory;
import org.carlmontrobotics.lib199.MotorConfig;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
    private static CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(0, MotorConfig.NEO);
    private static CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(9, MotorConfig.NEO);

    public boolean isTank = false;
    
    public Drivetrain(){}

    public void drive(double leftY, double rightY){
        leftMotor.set(Math.pow(leftY, 3));
        rightMotor.set(Math.pow(-rightY ,3));
    }

    public void arcadeDrive(double speed, double turn){
        speed *= Constants.kSpeedSlowdown;
        turn *= Constants.kTurnSlowdown;
        
        double left = speed + turn;
        double right = speed - turn;
        
        //drive(left, right);
        leftMotor.set(left);
        rightMotor.set(-right);
    }
}
