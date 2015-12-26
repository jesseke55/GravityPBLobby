package net.gravitynetwork.gravitypblobby.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.util.Arrays;

/**
 * Copyright (c) 2015-2016, ProtocollWeb/jesseke55/Jesse.
 */
public class ItemBuilder
{
    private final ItemStack stack;
    private final ItemMeta meta;

    public ItemBuilder(Material material)
    {
        this.stack = new ItemStack(material);
        this.meta = this.stack.getItemMeta();
    }

    public ItemBuilder amount(Integer amount)
    {
        this.stack.setAmount(amount.intValue());
        return this;
    }

    public ItemBuilder name(String name)
    {
        this.meta.setDisplayName(name);
        this.stack.setItemMeta(this.meta);
        return this;
    }

    public ItemBuilder lore(String... lore)
    {
        this.meta.setLore(Arrays.asList(lore));
        this.stack.setItemMeta(this.meta);
        return this;
    }

    public ItemBuilder enchant(Enchantment enchant, Integer level)
    {
        ItemMeta meta = this.stack.getItemMeta();
        meta.addEnchant(enchant, level.intValue(), true);
        this.stack.setItemMeta(meta);
        return this;
    }

    public ItemBuilder color(Color color)
    {
        if ((this.stack.equals(Material.LEATHER_BOOTS)) || (this.stack.equals(Material.LEATHER_LEGGINGS)) || (this.stack.equals(Material.LEATHER_CHESTPLATE)) ||
                (this.stack.equals(Material.LEATHER_HELMET)))
        {
            LeatherArmorMeta LAmeta = (LeatherArmorMeta)this.meta;
            LAmeta.setColor(color);
            this.stack.setItemMeta(LAmeta);
        }
        else
        {
            throw new IllegalArgumentException("setColor can only be used on leather armour!");
        }
        return this;
    }

    public ItemBuilder durability(int durability)
    {
        if ((durability >= 32768) && (durability <= 32767)) {
            this.stack.setDurability((short)durability);
        } else {
            throw new IllegalArgumentException("The durability must be a short!");
        }
        return this;
    }

    public ItemBuilder data(int data)
    {

        this.stack.setData(new MaterialData(data));
        return this;
    }

    public ItemBuilder flag(ItemFlag flag)
    {
        this.meta.addItemFlags(new ItemFlag[] { flag });
        this.stack.setItemMeta(this.meta);
        return this;
    }

    public ItemBuilder data(MaterialData data)
    {
        this.stack.setData(data);
        this.stack.setItemMeta(this.meta);
        return this;
    }

    public ItemBuilder owner(ItemStack item, String name)
    {
        if ((item.getType() == Material.SKULL) || (item.getType() == Material.SKULL_ITEM))
        {
            SkullMeta SMeta = (SkullMeta)this.meta;
            SMeta.setOwner(name);
            item.setItemMeta(SMeta);
        }
        return this;
    }

    public final ItemStack getStack()
    {
        return this.stack;
    }
}