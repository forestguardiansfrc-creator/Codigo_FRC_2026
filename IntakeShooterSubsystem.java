package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeShooterSubsystem extends SubsystemBase {

    private final SparkMax shooterMotor = Constants.MotorConstants.shooterMotor;
    private final SparkMax intakeMotor = Constants.MotorConstants.intakeMotor;

    // Altere essas velocidades de acordo com a necessidade
    private double speed_collect = 0.5;
    private double speed_shooter = 0.7;

    // Função principal
    public void operateIntakeShotter(boolean collect, boolean shooter) {
        if (collect) {
            intakeMotor.set(speed_collect);
            intakeMotor.set(-speed_collect);
        } else if (shooter) {
            shooterMotor.set(-speed_shooter);
             shooterMotor.set(speed_shooter);
        } else {
            shooterMotor.set(0);
            intakeMotor.set(0);
        }
    }
}