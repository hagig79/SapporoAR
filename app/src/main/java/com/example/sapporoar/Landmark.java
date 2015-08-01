package com.example.sapporoar;

import android.opengl.Matrix;

public class Landmark {
    private String name;
    private double latitude;
    private double longitude;
    private double screenX;
    private double screenY;

    public Landmark(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setScreenXY(double currentLatitude, double currentLongitude, float[] r2) {
        float[] targetV = new float[]{(float) (latitude - currentLatitude),(float) (longitude - currentLongitude),  0, 0};
        float[] inv = new float[16];
        Matrix.invertM(inv, 0, r2, 0);
        float[] target1 = new float[4];
        Matrix.multiplyMV(target1, 0, inv, 0, targetV, 0);

        double d = target1[0];
        screenX = target1[1] / d;
        screenY = target1[2] / d;
    }

    public double getScreenX() {
        return screenX;
    }
}
