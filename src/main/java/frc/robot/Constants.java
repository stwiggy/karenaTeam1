// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class Autonomous {
        public static final double kLeftAutoSpeed = 0.5;
        public static final double kRightAutoSpeed = 0.5;
        public static final int kAutoLength = 5;
    }

    public static class MotorPort {
        public static final int kLeftDriveID = 0;
        public static final int kRightDriveID = 1;
        public static final int kIntakeID = 2;
        public static final int kShooterID = 3;
    }
    public static class Drivetrain {
        public static final double kTurnSlowdown = 1;
        public static final double kSpeedSlowdown = 1;
    }

    public static class Shooter{
        public static final double kP = 0.01;
        public static final double kI = 0;
        public static final double kD = 0;
        public static final double kShootWantedRPM = 4000;
    }

    public static class OI{
        public static final int kDriverPort = 0;
        public static final int kOperatorPort = 1;

        public static final int kButtonANum = 1;
        public static final int kButtonBNum = 2;
        public static final int kButtonXNum = 3;
        public static final int kButtonYNum = 4;
        public static final int kLeftBumperNum = 5;
        public static final int kRightBumperNum = 6;
    }
}
