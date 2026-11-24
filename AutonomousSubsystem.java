 package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AutonomousSubsystem extends SubsystemBase {

    private final SparkMax MDE = Constants.MotorConstants.MDE;
    private final SparkMax MTE = Constants.MotorConstants.MTE;
    private final SparkMax MTD = Constants.MotorConstants.MTD;
    private final SparkMax MDD = Constants.MotorConstants.MDD;

    private final SparkMax intakeMotor = Constants.MotorConstants.intakeMotor;
    private final SparkMax shooterMotor = Constants.MotorConstants.shooterMotor;

    public void moveFrente(double speed) {
        System.out.println("Movendo para frente");
        MDE.set(speed);
        MTE.set(speed);
        MTD.set(-speed);
        MDD.set(-speed);
    }

    public void moveTras(double speed) {
        System.out.println("Movendo para tras");
        MDE.set(-speed);
        MTE.set(-speed);
        MTD.set(speed);
        MDD.set(speed);
    }

    public void viraDireita(double speed) {
        System.out.println("Girando para a direita");
        MDE.set(speed);
        MTE.set(speed);
        MTD.set(speed);
        MDD.set(speed);
    }

    public void viraEsquerda(double speed) {
        System.out.println("Girando para a esquerda");
        MDE.set(-speed);
        MTE.set(-speed);
        MTD.set(-speed);
        MDD.set(-speed);
    }

    public void stopMotors() {
        System.out.println("Parando motores");
        MDE.set(0);
        MTD.set(0);
        MDD.set(0);
        MTE.set(0);
    }

    public void ligarIntake(double speed) {
        System.out.println("Ligando intake");
        intakeMotor.set(speed);
    }

    public void desligarIntake() {
        System.out.println("Desligando intake");
        intakeMotor.set(0);
    }

    public void ligarShooter(double speed) {
        System.out.println("Ligando shooter");
        shooterMotor.set(speed);
    }

    public void desligarShooter() {
        System.out.println("Desligando shooter");
        shooterMotor.set(0);
    }
}