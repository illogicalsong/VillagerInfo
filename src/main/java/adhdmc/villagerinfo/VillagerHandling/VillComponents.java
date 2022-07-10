package adhdmc.villagerinfo.VillagerHandling;

import adhdmc.villagerinfo.MiscHandling.MessageHandler;
import adhdmc.villagerinfo.MiscHandling.TimeFormatting;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.HashMap;

public class VillComponents {
    static HashMap<MessageHandler.MESSAGE_TYPE, Component> mMap = MessageHandler.getMessages();

//    public static TextComponent villInventoryContentsBuilder(Inventory inv){
//        TextComponent invContents = Component.text("");
//        for (int i = 0; i < inv.getContents().length; i++){
//            ItemStack invItem = inv.getItem(i);
//            if(invItem != null){
//                invContents.append(Component.newline())
//                .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG)).color(NamedTextColor.AQUA)
//                .append(Component.text(invItem.getType().toString()))
//                .append(Component.text(" (").color(NamedTextColor.GRAY))
//                .append(Component.text(invItem.getAmount()))
//                .append(Component.text(")"));
//            }
//        }
//        return invContents;
//    }

    public static TextComponent villProfessionBuilder(String s){
        TextComponent villProfession;
        if (s.equals("NONE")) {
           villProfession = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.PROFESSION_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.NONE_MSG));
        } else {
           villProfession = (Component.newline())
                   .append(mMap.get(MessageHandler.MESSAGE_TYPE.PROFESSION_MSG))
                   .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                   .append(Component.text(s)).color(NamedTextColor.AQUA);
        }
        return villProfession;
    }

    public static TextComponent villJobsiteBuilder(Location l){
        TextComponent villJobsite;
        if (l != null) {
            villJobsite = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.JOBSITE_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(Component.text(l.getBlockX()))
                    .append(Component.text("x, ")).color(NamedTextColor.AQUA)
                    .append(Component.text(l.getBlockY()))
                    .append(Component.text("y, "))
                    .append(Component.text(l.getBlockZ()))
                    .append(Component.text("z"));
        } else {
            villJobsite = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.JOBSITE_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.NONE_MSG));
        }
        return villJobsite;
    }

    public static TextComponent villLastWorkedBuilder(Long l, long time){
        TextComponent villLastWorked;
        if(l != null){
         long timeToFormat = time - l;
         villLastWorked = (Component.newline())
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.LAST_WORKED_MSG))
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                .append(Component.text(TimeFormatting.timeMath(timeToFormat))).color(NamedTextColor.AQUA);
         } else {
         villLastWorked = (Component.newline())
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.LAST_WORKED_MSG))
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.NEVER_MSG));
         }
         return villLastWorked;
    }

    public static TextComponent villRestocksBuilder(int i){
        TextComponent villRestocks;
        if (i != 0){
            villRestocks = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.RESTOCK_NUMBER_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(Component.text(i)).color(NamedTextColor.AQUA);
        } else {
            villRestocks = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.RESTOCK_NUMBER_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(Component.text("0").color(NamedTextColor.GRAY));
        }
        return villRestocks;
    }

    public static TextComponent villHomeBuilder(Location l){
        TextComponent villHome;
        if (l != null) {
            villHome = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.HOME_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(Component.text(l.getBlockX()))
                    .append(Component.text("x, ")).color(NamedTextColor.AQUA)
                    .append(Component.text(l.getBlockY()))
                    .append(Component.text("y, "))
                    .append(Component.text(l.getBlockZ()))
                    .append(Component.text("z"));
        } else {
            villHome = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.HOME_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.NONE_MSG));
        }
        return villHome;
    }

    public static TextComponent villLastSleptBuilder(Long l, long time){
        TextComponent villLastSlept;
        if(l != null){
            long timeToFormat = time - l;
            villLastSlept = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.LAST_SLEPT_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(Component.text(TimeFormatting.timeMath(timeToFormat))).color(NamedTextColor.AQUA);
        } else {
            villLastSlept = (Component.newline())
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.LAST_SLEPT_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                    .append(mMap.get(MessageHandler.MESSAGE_TYPE.NEVER_MSG));
        }
        return villLastSlept;
    }

    public static TextComponent villReputationBuilder(int i){
        return (Component.newline())
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.REPUTATION_MSG))
                .append(Component.text(ReputationHandler.villagerReputation(i)));
    }

    public static TextComponent villInventoryBuilder(Inventory inv){
        TextComponent villInventory = Component.empty();
        if (!inv.isEmpty()){
            for (int i = 0; i < inv.getContents().length; i++){
            ItemStack invItem = inv.getItem(i);
            if(invItem != null){
                villInventory.append(Component.newline())
                .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG)).color(NamedTextColor.AQUA)
                .append(Component.text(invItem.getType().toString()))
                .append(Component.text(" (").color(NamedTextColor.GRAY))
                .append(Component.text(invItem.getAmount()))
                .append(Component.text(")"));
                }
            }
        }
         else {
            villInventory = (Component.newline())
                           .append(mMap.get(MessageHandler.MESSAGE_TYPE.INVENTORY_MSG))
                           .append(Component.newline())
                           .append(mMap.get(MessageHandler.MESSAGE_TYPE.SEPARATOR_MSG))
                           .append(mMap.get(MessageHandler.MESSAGE_TYPE.EMPTY_MSG));
        }
        return villInventory;
    }
}
