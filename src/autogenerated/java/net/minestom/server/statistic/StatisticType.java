package net.minestom.server.statistic;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.key.Keyed;
import net.minestom.server.registry.Registries;
import net.minestom.server.utils.NamespaceID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * AUTOGENERATED by StatisticGenerator
 */
public enum StatisticType implements Keyed {
    LEAVE_GAME(NamespaceID.from("minecraft:leave_game")),

    PLAY_TIME(NamespaceID.from("minecraft:play_time")),

    TOTAL_WORLD_TIME(NamespaceID.from("minecraft:total_world_time")),

    TIME_SINCE_DEATH(NamespaceID.from("minecraft:time_since_death")),

    TIME_SINCE_REST(NamespaceID.from("minecraft:time_since_rest")),

    CROUCH_TIME(NamespaceID.from("minecraft:sneak_time")),

    WALK_ONE_CM(NamespaceID.from("minecraft:walk_one_cm")),

    CROUCH_ONE_CM(NamespaceID.from("minecraft:crouch_one_cm")),

    SPRINT_ONE_CM(NamespaceID.from("minecraft:sprint_one_cm")),

    WALK_ON_WATER_ONE_CM(NamespaceID.from("minecraft:walk_on_water_one_cm")),

    FALL_ONE_CM(NamespaceID.from("minecraft:fall_one_cm")),

    CLIMB_ONE_CM(NamespaceID.from("minecraft:climb_one_cm")),

    FLY_ONE_CM(NamespaceID.from("minecraft:fly_one_cm")),

    WALK_UNDER_WATER_ONE_CM(NamespaceID.from("minecraft:walk_under_water_one_cm")),

    MINECART_ONE_CM(NamespaceID.from("minecraft:minecart_one_cm")),

    BOAT_ONE_CM(NamespaceID.from("minecraft:boat_one_cm")),

    PIG_ONE_CM(NamespaceID.from("minecraft:pig_one_cm")),

    HORSE_ONE_CM(NamespaceID.from("minecraft:horse_one_cm")),

    AVIATE_ONE_CM(NamespaceID.from("minecraft:aviate_one_cm")),

    SWIM_ONE_CM(NamespaceID.from("minecraft:swim_one_cm")),

    STRIDER_ONE_CM(NamespaceID.from("minecraft:strider_one_cm")),

    JUMP(NamespaceID.from("minecraft:jump")),

    DROP(NamespaceID.from("minecraft:drop")),

    DAMAGE_DEALT(NamespaceID.from("minecraft:damage_dealt")),

    DAMAGE_DEALT_ABSORBED(NamespaceID.from("minecraft:damage_dealt_absorbed")),

    DAMAGE_DEALT_RESISTED(NamespaceID.from("minecraft:damage_dealt_resisted")),

    DAMAGE_TAKEN(NamespaceID.from("minecraft:damage_taken")),

    DAMAGE_BLOCKED_BY_SHIELD(NamespaceID.from("minecraft:damage_blocked_by_shield")),

    DAMAGE_ABSORBED(NamespaceID.from("minecraft:damage_absorbed")),

    DAMAGE_RESISTED(NamespaceID.from("minecraft:damage_resisted")),

    DEATHS(NamespaceID.from("minecraft:deaths")),

    MOB_KILLS(NamespaceID.from("minecraft:mob_kills")),

    ANIMALS_BRED(NamespaceID.from("minecraft:animals_bred")),

    PLAYER_KILLS(NamespaceID.from("minecraft:player_kills")),

    FISH_CAUGHT(NamespaceID.from("minecraft:fish_caught")),

    TALKED_TO_VILLAGER(NamespaceID.from("minecraft:talked_to_villager")),

    TRADED_WITH_VILLAGER(NamespaceID.from("minecraft:traded_with_villager")),

    EAT_CAKE_SLICE(NamespaceID.from("minecraft:eat_cake_slice")),

    FILL_CAULDRON(NamespaceID.from("minecraft:fill_cauldron")),

    USE_CAULDRON(NamespaceID.from("minecraft:use_cauldron")),

    CLEAN_ARMOR(NamespaceID.from("minecraft:clean_armor")),

    CLEAN_BANNER(NamespaceID.from("minecraft:clean_banner")),

    CLEAN_SHULKER_BOX(NamespaceID.from("minecraft:clean_shulker_box")),

    INTERACT_WITH_BREWINGSTAND(NamespaceID.from("minecraft:interact_with_brewingstand")),

    INTERACT_WITH_BEACON(NamespaceID.from("minecraft:interact_with_beacon")),

    INSPECT_DROPPER(NamespaceID.from("minecraft:inspect_dropper")),

    INSPECT_HOPPER(NamespaceID.from("minecraft:inspect_hopper")),

    INSPECT_DISPENSER(NamespaceID.from("minecraft:inspect_dispenser")),

    PLAY_NOTEBLOCK(NamespaceID.from("minecraft:play_noteblock")),

    TUNE_NOTEBLOCK(NamespaceID.from("minecraft:tune_noteblock")),

    POT_FLOWER(NamespaceID.from("minecraft:pot_flower")),

    TRIGGER_TRAPPED_CHEST(NamespaceID.from("minecraft:trigger_trapped_chest")),

    OPEN_ENDERCHEST(NamespaceID.from("minecraft:open_enderchest")),

    ENCHANT_ITEM(NamespaceID.from("minecraft:enchant_item")),

    PLAY_RECORD(NamespaceID.from("minecraft:play_record")),

    INTERACT_WITH_FURNACE(NamespaceID.from("minecraft:interact_with_furnace")),

    INTERACT_WITH_CRAFTING_TABLE(NamespaceID.from("minecraft:interact_with_crafting_table")),

    OPEN_CHEST(NamespaceID.from("minecraft:open_chest")),

    SLEEP_IN_BED(NamespaceID.from("minecraft:sleep_in_bed")),

    OPEN_SHULKER_BOX(NamespaceID.from("minecraft:open_shulker_box")),

    OPEN_BARREL(NamespaceID.from("minecraft:open_barrel")),

    INTERACT_WITH_BLAST_FURNACE(NamespaceID.from("minecraft:interact_with_blast_furnace")),

    INTERACT_WITH_SMOKER(NamespaceID.from("minecraft:interact_with_smoker")),

    INTERACT_WITH_LECTERN(NamespaceID.from("minecraft:interact_with_lectern")),

    INTERACT_WITH_CAMPFIRE(NamespaceID.from("minecraft:interact_with_campfire")),

    INTERACT_WITH_CARTOGRAPHY_TABLE(NamespaceID.from("minecraft:interact_with_cartography_table")),

    INTERACT_WITH_LOOM(NamespaceID.from("minecraft:interact_with_loom")),

    INTERACT_WITH_STONECUTTER(NamespaceID.from("minecraft:interact_with_stonecutter")),

    BELL_RING(NamespaceID.from("minecraft:bell_ring")),

    RAID_TRIGGER(NamespaceID.from("minecraft:raid_trigger")),

    RAID_WIN(NamespaceID.from("minecraft:raid_win")),

    INTERACT_WITH_ANVIL(NamespaceID.from("minecraft:interact_with_anvil")),

    INTERACT_WITH_GRINDSTONE(NamespaceID.from("minecraft:interact_with_grindstone")),

    TARGET_HIT(NamespaceID.from("minecraft:target_hit")),

    INTERACT_WITH_SMITHING_TABLE(NamespaceID.from("minecraft:interact_with_smithing_table"));

    private static final StatisticType[] VALUES = values();

    @NotNull
    private final NamespaceID id;

    StatisticType(@NotNull NamespaceID id) {
        this.id = id;
        Registries.statisticTypes.put(id, this);
    }

    @Override
    @NotNull
    public Key key() {
        return this.id;
    }

    public short getId() {
        return (short) ordinal();
    }

    @NotNull
    public NamespaceID getNamespaceID() {
        return this.id;
    }

    @Nullable
    public static StatisticType fromId(short id) {
        if(id >= 0 && id < VALUES.length) {
            return VALUES[id];
        }
        return null;
    }

    @NotNull
    @Override
    public String toString() {
        return "[" + this.id + "]";
    }
}