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
package com.watabou.pixeldungeon.actors.mobs;

import com.watabou.pixeldungeon.Badges;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.items.Generator;
import com.watabou.pixeldungeon.items.Item;
import com.watabou.utils.Random;

/**
 * New elite mob (added on top of the original Pixel Dungeon source).
 * Reuses the regular crab's sprite - a much tougher matriarch guarding
 * the rest of the brood, distinguished by name, stats and loot only.
 */
public class CrabMatriarch extends Crab {

	{
		name = "crab matriarch";

		HP = HT = 45;
		defenseSkill = 9;

		EXP = 7;
		maxLvl = 11;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 5, 10 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 15;
	}

	@Override
	public int dr() {
		return 6;
	}

	@Override
	protected void dropLoot() {
		Item loot = Generator.random( Generator.Category.FOOD );
		Dungeon.level.drop( loot, pos ).sprite.drop();
		Badges.validateRare( this );
	}

	@Override
	public String description() {
		return
			"Larger and far more aggressive than an ordinary sewer crab, this " +
			"matriarch's shell has hardened over many years of guarding her " +
			"brood from anything that gets too close.";
	}
}
