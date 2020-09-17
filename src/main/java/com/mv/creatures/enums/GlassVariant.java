package com.mv.creatures.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum GlassVariant implements IStringSerializable {
    flail_glass();

    @Override
    public String getString() {
        return name().toLowerCase(Locale.ROOT);
    }
}

