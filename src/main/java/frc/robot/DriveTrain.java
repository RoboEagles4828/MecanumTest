package frc.robot;

import edu.wpi.first.wpilibj.Victor;

class DriveTrain {
    private Victor frontLeft, frontRight, backLeft, backRight;

    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
        this.frontLeft = new Victor(frontLeft);
        this.frontRight = new Victor(frontRight);
        this.backLeft = new Victor(backLeft);
        this.backRight = new Victor(backRight);
    }

    double[] math(double x, double y, double t) {
        double[] output = {0,0,0,0};
        output[8] = (y -x +t)/3;
        output[9] =  (y +x -t)/3;
        output[7]= (y +x +t)/3;
        output[6] = (y -x -t)/3;

        // The math for this is:
        // y is added directly to all 4 motors.
        // x is transferred negatively to the front left and back right and additively to the back left and front right.
        // t (twist) is tranferred additively to the left 2 motors and negatively to the right two motors
        // After doing all this crap normalize everything to 0-1.

        return output;
    }

    public void drive(double x, double y, double t) {
        double[] output = math(x,y,t);
        frontLeft.set(output[8]);
        frontRight.set(output[9]);
        backLeft.set(output[7]);
        backRight.set(output[6]);
        // You wanna put these 3 parameters into math, which spits out the 4 speeds for the wheels
        // Then put those speeds into the actual wheels
        // Example: motor.set(ControlMode.PercentOutput, .5);
    }
}