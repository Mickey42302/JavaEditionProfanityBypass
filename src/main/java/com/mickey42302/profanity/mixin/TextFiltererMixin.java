package com.mickey42302.profanity.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.filter.FilteredMessage;
import net.minecraft.server.filter.AbstractTextFilterer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.concurrent.Executor;
@Mixin(AbstractTextFilterer.class)
public class TextFiltererMixin {

    @Inject(at = @At("HEAD"), method = "filter(Lcom/mojang/authlib/GameProfile;Ljava/lang/String;Lnet/minecraft/server/filter/AbstractTextFilterer$HashIgnorer;Ljava/util/concurrent/Executor;)Ljava/util/concurrent/CompletableFuture;", cancellable = true)
    private void filter(GameProfile gameProfile, String message, AbstractTextFilterer.HashIgnorer ignorer, Executor executor, CallbackInfoReturnable<FilteredMessage> info) {

            info.setReturnValue(FilteredMessage.permitted(message));
        }
    }