package com.afoxxvi.asteorbar.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public abstract class RenderGui {
    abstract public int leftHeight();

    abstract public int rightHeight();

    abstract public void leftHeight(int i);

    abstract public void rightHeight(int i);

    abstract public Gui gui();

    public Minecraft mc() {
        return Minecraft.getInstance();
    }
}
