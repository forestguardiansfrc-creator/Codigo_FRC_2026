package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public final class Constants {

    public static class MotorConstants {
        public static SparkMax MDE = new SparkMax(1, MotorType.kBrushless); // Motor Dianteiro Esquerdo
        public static SparkMax MTD = new SparkMax(4, MotorType.kBrushless); // Motor Traseiro Direito
        public static SparkMax MDD = new SparkMax(3, MotorType.kBrushless); // Motor Dianteiro Direito
        public static SparkMax MTE = new SparkMax(2, MotorType.kBrushless); // Motor Traseiro Esquerdo
        public static SparkMax shooterMotor = new SparkMax(5, MotorType.kBrushless);  // Motor do Roller
        public static SparkMax intakeMotor = new SparkMax(6, MotorType.kBrushless);  // Motor do Roller
    }

    public static class AxisConstants {
        public static final int axis_speed = 1; // Aceleração
        public static final int axis_rotation = 2; // Rotação
        public static final int axis_controler_velocity = 3; // Controlador de velocidade
    }

    public static class ButtonConstants {
        public static final int button_collect = 1; // Coleta as game pice
        public static final int button_shooter = 2; // Chuta as game pice
        public static final int button_brake = 5; // Freia os motores da tração em caso de emergência
    }
}