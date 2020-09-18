package com.mv.creatures.enums;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum MucusVariant implements IStringSerializable {
    mucus(),
    mucus_layers(),
    dried_mucus_layers(),
    dried_mucus();

    @Override
    public String getString() {
        return name().toLowerCase(Locale.ROOT);
    }
}

