package com.fusionflux.gravity_api.util;

import net.minecraft.util.math.Axis;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public abstract class QuaternionUtil {

    public static Quaternionf getViewRotation(float pitch, float yaw) {
        Quaternionf r1 = Axis.X_POSITIVE.rotationDegrees(pitch);
        Quaternionf r2 = Axis.Y_POSITIVE.rotationDegrees(yaw + 180.0F);
        return r1.mul(r2);
    }

    // NOTE the "from" and "to" cannot be opposite
    public static Quaternionf getRotationBetween(Vector3f from, Vector3f to) {
        from.normalize();
        to.normalize();
        Vector3f axis = new Vector3f(from).cross(to).normalize();
        float cos = from.dot(to);
        float angle = (float) Math.acos(cos);

        return new Quaternionf().rotationAxis(angle, axis);
    }
}
