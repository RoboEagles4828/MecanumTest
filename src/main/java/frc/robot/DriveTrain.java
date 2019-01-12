package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

class DriveTrain {
    TalonSRX frontLeft, frontRight, backLeft, backRight;

    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
        this.frontLeft = new TalonSRX(frontLeft);
        // TODO: Do the same for the rest of the motors
    }

    private int[] math(double x, double y, double t) {
        int[] output = {0,0,0,0};

        // TODO: The math for this is:
        // y is added directly to all 4 motors.
        // x is transferred negatively to the front two motors and additively to the back two.
        // t (twist) is tranferred additively to the left 2 motors and negatively to the right two motors
        // After doing all this crap normalize everything to 0-1.

        return output;
    }

    
}