package com.mv.creatures.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum MucusVariant implements IStringSerializable {
    flail_mucus(),
    dried_flail_mucus();

    @Override
    public String getString() {
        return name().toLowerCase(Locale.ROOT);
    }
}

