package com.fusionflux.gravity_api.api;

import com.fusionflux.gravity_api.config.GravityChangerConfig;

public class RotationParameters {
    private boolean rotateVelocity;
    private boolean rotateView;
    private boolean alternateCenter;
    private int rotationTimeMs;//Milliseconds

    public RotationParameters() {
        this(
                GravityChangerConfig.worldVelocity,
                !GravityChangerConfig.keepWorldLook,
                false,
                GravityChangerConfig.rotationTime
        );
    }

    public RotationParameters(boolean _rotateVelocity, boolean _rotateView, boolean _alternateCenter, int _rotationTimeMs) {
        rotateVelocity = _rotateVelocity;
        rotateView = _rotateView;
        alternateCenter = _alternateCenter;
        rotationTimeMs = _rotationTimeMs;
    }

    public boolean rotateVelocity() {
        return rotateVelocity;
    }

    public boolean rotateView() {
        return rotateView;
    }

    public boolean alternateCenter() {
        return alternateCenter;
    }

    public int rotationTime() {
        return rotationTimeMs;
    }

    public RotationParameters rotateVelocity(boolean rotateVelocity) {
        this.rotateVelocity = rotateVelocity;
        return this;
    }

    public RotationParameters rotateView(boolean rotateView) {
        this.rotateView = rotateView;
        return this;
    }

    public RotationParameters alternateCenter(boolean alternateCenter) {
        this.alternateCenter = alternateCenter;
        return this;
    }

    public RotationParameters rotationTime(int rotationTime) {
        this.rotationTimeMs = rotationTime;
        return this;
    }
}
