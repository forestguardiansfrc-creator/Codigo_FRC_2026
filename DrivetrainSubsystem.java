package frc.robot.subsystems;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DrivetrainSubsystem extends SubsystemBase {

    // Motores
    private final SparkMax MDE = Constants.MotorConstants.MDE;
    private final SparkMax MTD = Constants.MotorConstants.MTD;
    private final SparkMax MDD = Constants.MotorConstants.MDD;
    private final SparkMax MTE = Constants.MotorConstants.MTE;

    // Encoders
    private final RelativeEncoder encoderMDE = MDE.getEncoder();
    private final RelativeEncoder encoderMTD = MTD.getEncoder();
    private final RelativeEncoder encoderMDD = MDD.getEncoder();
    private final RelativeEncoder encoderMTE = MTE.getEncoder();
   
    // Função principal
    public void operateDrive(Double speed, Double rotation, double controler, boolean brake) {
        if (!brake) {
            MTE.set(((speed - (rotation / 2.6)) * controler));
            MDD.set(((-speed + (-rotation / 2.6)) * controler));
            MDE.set(((speed - (rotation / 2.6)) * controler));
            MTD.set(((-speed + (-rotation / 2.6)) * controler));
        } else {
            MTE.set(0);
            MDD.set(0);
            MDE.set(0);
            MTD.set(0);
        }
    }

    // Envia valores para SmartDashboard
    public void updateDashboard() {
        SmartDashboard.putNumber("Encoder MDE", encoderMDE.getPosition());
        SmartDashboard.putNumber("Encoder MTE", encoderMTE.getPosition());
        SmartDashboard.putNumber("Encoder MTD", encoderMTD.getPosition());
        SmartDashboard.putNumber("Encoder MDD", encoderMDD.getPosition());
    }

    // Zera encoders
    public void resetEncoders() {
        encoderMDE.setPosition(0);
        encoderMTD.setPosition(0);
        encoderMDD.setPosition(0);
        encoderMTE.setPosition(0);
    }
}