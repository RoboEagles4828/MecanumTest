package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

class DriveTrain {
    TalonSRX frontLeft, frontRight, backLeft, backRight;

    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
        this.frontLeft = new TalonSRX(frontLeft);
        this.frontRight = new TalonSRX(frontRight);
        this.backLeft = new TalonSRX(backLeft);
        this.backRight = new TalonSRX(backRight);
    }

    double[] math(double x, double y, double t) {
        double[] output = {0,0,0,0};
        output[0] = (y -x +t)/3;
        output[1] =  (y +x -t)/3;
        output[2]= (y +x +t)/3;
        output[3] = (y -x -t)/3;

        // The math for this is:
        // y is added directly to all 4 motors.
        // x is transferred negatively to the front left and back right and additively to the back left and front right.
        // t (twist) is tranferred additively to the left 2 motors and negatively to the right two motors
        // After doing all this crap normalize everything to 0-1.

        return output;
    }

    public void drive(double x, double y, double t) {
        double[] output = math(x,y,t);
        frontLeft.set(ControlMode.PercentOutput, output[0]);
        frontRight.set(ControlMode.PercentOutput, output[1]);
        backLeft.set(ControlMode.PercentOutput, output[2]);
        backRight.set(ControlMode.PercentOutput, output[3]);
        // You wanna put these 3 parameters into math, which spits out the 4 speeds for the wheels
        // Then put those speeds into the actual wheels
        // Example: motor.set(ControlMode.PercentOutput, .5);
    }
}