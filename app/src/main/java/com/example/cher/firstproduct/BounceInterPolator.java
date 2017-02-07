package com.example.cher.firstproduct;

/**
 * Created by Cher on 2/4/2017.
 */

class BounceInterPolator implements android.view.animation.Interpolator {
    double mAmplitude = 1;
    double mFrequency = 10;

    BounceInterPolator(double amplitude, double frequency) {
        mAmplitude = amplitude;
        mFrequency = frequency;
    }

    public float getInterpolation(float time) {
        return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                Math.cos(mFrequency * time) + 1);
    }

}
