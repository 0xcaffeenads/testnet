/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package com.watabou.pixeldungeon.items.weapon.melee;

import com.watabou.pixeldungeon.sprites.ItemSpriteSheet;

/**
 * New weapon (added on top of the original Pixel Dungeon source).
 * Same tier as the Longsword (4), but trades a bit of raw power for
 * accuracy and attack speed - a lighter, quicker curved blade.
 */
public class Falchion extends MeleeWeapon {

	{
		name = "falchion";
		image = ItemSpriteSheet.FALCHION;
	}

	public Falchion() {
		super( 4, 1.15f, 0.9f );
	}

	@Override
	public String desc() {
		return "A single-edged, curved blade favoring speed and precision over brute force.";
	}
}
