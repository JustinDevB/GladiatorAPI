package me.justindevb.gladiator.events;

import me.justindevb.gladiator.playercache.PlayerCache;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ViolationEvent extends Event implements Cancellable {

    private static final HandlerList HANDLERS = new HandlerList();

    private final PlayerCache playerCache;
    private boolean isCancelled;

    private final String checkName;
    private final char checkType;
    private final String checkDescription;
    private final int violationLevel;
    private final int maxViolationLevel;
    private final String checkInfo;
    private final boolean experimental;


    public ViolationEvent(PlayerCache playerCache, String checkName, char checkType, String checkDescription, int violationLevel, int maxViolationLevel,String info, boolean experimental) {
        this.playerCache = playerCache;
        this.isCancelled = false;
        this.checkName = checkName;
        this.checkType = checkType;
        this.checkDescription = checkDescription;
        this.violationLevel = violationLevel;
        this.maxViolationLevel = maxViolationLevel;
        this.checkInfo = info;
        this.experimental = experimental;
    }

    public Player getPlayer() {
        return playerCache.getPlayer();
    }

    public String getCheckInfo() {
        return checkInfo;
    }

    public boolean isExperimental() {
        return experimental;
    }

    public char getCheckType() {
        return checkType;
    }

    public int getMaxViolationLevel() {
        return maxViolationLevel;
    }

    public int getViolationLevel() {
        return violationLevel;
    }

    public PlayerCache getPlayerCache() {
        return playerCache;
    }

    public String getCheckDescription() {
        return checkDescription;
    }

    public String getCheckName() {
        return checkName;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}

