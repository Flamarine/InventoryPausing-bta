package io.github.pkstdev.invpausing.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.GuiInventory;
import net.minecraft.src.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = GuiContainer.class, remap = false)
public class GuiContainerMixin extends GuiScreen {
    @ModifyReturnValue(method = "doesGuiPauseGame", at = @At("RETURN"))
    private boolean onDoesGuiPauseGame(boolean original) {
        if (!this.mc.isMultiplayerWorld()) {
            return ((GuiScreen)this) instanceof GuiInventory;
        } else {
            return false;
        }
    }
}
