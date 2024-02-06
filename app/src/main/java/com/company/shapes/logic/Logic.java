package com.company.shapes.logic;

import com.company.shapes.ui.OutputInterface;

public class Logic implements LogicInterface {

    public static final String TAG = Logic.class.getName();
    private OutputInterface mOut;

    private static double mRadius = 0;
    private static double mLength = 0;
    private static double mWidth = 0;
    private static double mHeight = 0;

    public Logic(OutputInterface out) {
        mOut = out;
    }

    @Override
    public void process() {
        Shapes shapeForCalculations = mOut.getShape();
        mLength = mOut.getLength();
        mWidth = mOut.getWidth();
        mHeight = mOut.getHeight();
        mRadius = mOut.getRadius();

        switch (shapeForCalculations) {
            case Box:
                mOut.print("A " + mLength + " by " + mWidth + " by " + mHeight + " box has a volume of: ");
                mOut.println("" + String.format("%.2f", boxVolume(mLength, mWidth, mHeight)));
                mOut.println("");

                mOut.print("A " + mLength + " by " + mWidth + " by " + mHeight + " box has a surface area of: ");
                mOut.println("" + String.format("%.2f", boxSurfaceArea(mLength, mWidth, mHeight)));
                mOut.println("");
                break;
            case Rectangle:
                mOut.print("A " + mLength + " by " + mWidth + " rectangle has a perimeter of: ");
                mOut.println("" + String.format("%.2f", rectanglePerimeter(mLength, mWidth)));
                mOut.println("");

                mOut.print("A " + mLength + " by " + mWidth + " rectangle has area of: ");
                mOut.println("" + String.format("%.2f", rectangleArea(mLength, mWidth)));
                mOut.println("");
                break;
            case Sphere:
                mOut.print("A sphere with radius " + mRadius + " has a volume of: ");
                mOut.println("" + String.format("%.2f", sphereVolume(mRadius)));
                mOut.println("");

                mOut.print("A sphere with radius " + mRadius + " has surface area of: ");
                mOut.println("" + String.format("%.2f", sphereSurfaceArea(mRadius)));
                mOut.println("");
                break;
            case Circle:
                mOut.print("A circle with radius " + mRadius + " has a perimeter of: ");
                mOut.println("" + String.format("%.2f", circleCircumference(mRadius)));
                mOut.println("");

                mOut.print("A circle with radius " + mRadius + " has area of: ");
                mOut.println("" + String.format("%.2f", circleArea(mRadius)));
                mOut.println("");
                break;
            case Triangle:
                mOut.print("A right triangle with base " + mLength + " and height " + mWidth + " has a perimeter of: ");
                mOut.println("" + String.format("%.2f", rightTrianglePerimeter(mLength, mWidth)));
                mOut.println("");

                mOut.print("A right triangle with base " + mLength + " and height " + mWidth + " has area of: ");
                mOut.println("" + String.format("%.2f", rightTriangleArea(mLength, mWidth)));
                mOut.println("");
                break;
            default:
                break;
        }
    }

    public static double rectangleArea(double length, double width) {
        return length * width;
    }

    public static double rectanglePerimeter(double length, double width) {
        return 2 * (length + width);
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double circleCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double rightTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static double rightTrianglePerimeter(double base, double height) {
        double hypotenuse = Math.sqrt(base * base + height * height);
        return base + height + hypotenuse;
    }

    public static double boxVolume(double length, double width, double depth) {
        return length * width * depth;
    }

    public static double boxSurfaceArea(double length, double width, double depth) {
        return 2 * (length * width + length * depth + width * depth);
    }

    public static double sphereVolume(double radius) {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public static double sphereSurfaceArea(double radius) {
        return 4 * Math.PI * Math.pow(radius, 2);
    }
}
