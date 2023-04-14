package com.fusionflux.gravity_api.item;

import com.fusionflux.gravity_api.GravityChangerMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.Direction;

import java.lang.reflect.Field;
import java.util.Locale;

public abstract class ModItems {
    public static final Item GRAVITY_CHANGER_DOWN = new GravityChangerItem(new Item.Settings().maxCount(1), Direction.DOWN);
    public static final Item GRAVITY_CHANGER_UP = new GravityChangerItem(new Item.Settings().maxCount(1), Direction.UP);
    public static final Item GRAVITY_CHANGER_NORTH = new GravityChangerItem(new Item.Settings().maxCount(1), Direction.NORTH);
    public static final Item GRAVITY_CHANGER_SOUTH = new GravityChangerItem(new Item.Settings().maxCount(1), Direction.SOUTH);
    public static final Item GRAVITY_CHANGER_WEST = new GravityChangerItem(new Item.Settings().maxCount(1), Direction.WEST);
    public static final Item GRAVITY_CHANGER_EAST = new GravityChangerItem(new Item.Settings().maxCount(1), Direction.EAST);

    public static final Item GRAVITY_CHANGER_DOWN_AOE = new GravityChangerItemAOE(new Item.Settings().maxCount(1), Direction.DOWN);
    public static final Item GRAVITY_CHANGER_UP_AOE = new GravityChangerItemAOE(new Item.Settings().maxCount(1), Direction.UP);
    public static final Item GRAVITY_CHANGER_NORTH_AOE = new GravityChangerItemAOE(new Item.Settings().maxCount(1), Direction.NORTH);
    public static final Item GRAVITY_CHANGER_SOUTH_AOE = new GravityChangerItemAOE(new Item.Settings().maxCount(1), Direction.SOUTH);
    public static final Item GRAVITY_CHANGER_WEST_AOE = new GravityChangerItemAOE(new Item.Settings().maxCount(1), Direction.WEST);
    public static final Item GRAVITY_CHANGER_EAST_AOE = new GravityChangerItemAOE(new Item.Settings().maxCount(1), Direction.EAST);

    public static void init() {
        for (Field f : ModItems.class.getDeclaredFields()) {
            if (Item.class.isAssignableFrom(f.getType())) {
                try {
                    Item item = (Item) f.get(null);
                    String name = f.getName().toLowerCase(Locale.ROOT);
                    Registry.register(Registries.ITEM, GravityChangerMod.id(name), item);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
