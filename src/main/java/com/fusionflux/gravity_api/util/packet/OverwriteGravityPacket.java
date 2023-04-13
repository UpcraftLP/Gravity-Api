package com.fusionflux.gravity_api.util.packet;

import com.fusionflux.gravity_api.api.RotationParameters;
import com.fusionflux.gravity_api.util.Gravity;
import com.fusionflux.gravity_api.util.GravityComponent;
import com.fusionflux.gravity_api.util.NetworkUtil;
import net.minecraft.network.PacketByteBuf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OverwriteGravityPacket extends GravityPacket {
    public final List<Gravity> gravityList;
    public final boolean initialGravity;

    public OverwriteGravityPacket(List<Gravity> _gravityList, boolean _initialGravity){
        gravityList = _gravityList;
        initialGravity = _initialGravity;
    }

    public OverwriteGravityPacket(PacketByteBuf buf) {
        int listSize = buf.readVarInt();
        gravityList = new ArrayList<>(listSize);
        for (int i = 0; i < listSize; i++)
            gravityList.add(NetworkUtil.readGravity(buf));
        initialGravity = buf.readBoolean();
    }

    @Override
    public void write(PacketByteBuf buf) {
        buf.writeVarInt(gravityList.size());
        for (Gravity gravity : gravityList) NetworkUtil.writeGravity(buf, gravity);
        buf.writeBoolean(initialGravity);
    }

    @Override
    public void run(GravityComponent gc) {
        gc.setGravity(gravityList, initialGravity);
    }

    @Override
    public RotationParameters getRotationParameters() {
        return gravityList.stream().max(Comparator.comparingInt(Gravity::priority)).map(Gravity::rotationParameters)
                .orElseGet(RotationParameters::new);
    }
}
