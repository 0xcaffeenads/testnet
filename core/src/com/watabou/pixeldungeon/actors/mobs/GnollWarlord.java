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
 * Reuses the regular gnoll's sprite - a rare pack leader, distinguished
 * by name, stats and guaranteed weapon drop only.
 */
public class GnollWarlord extends Gnoll {

	{
		name = "gnoll warlord";

		HP = HT = 30;
		defenseSkill = 8;

		EXP = 5;
		maxLvl = 10;

		loot = null;
		lootChance = 0;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 4, 9 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 14;
	}

	@Override
	public int dr() {
		return 4;
	}

	@Override
	protected void dropLoot() {
		Item loot = Generator.random( Generator.Category.WEAPON );
		Dungeon.level.drop( loot, pos ).sprite.drop();
		Badges.validateRare( this );
	}

	@Override
	public String description() {
		return
			"This gnoll has clearly seen more battles than the rest of its pack - " +
			"scars crisscross its hide, and it carries itself with the confidence " +
			"of something used to giving orders, not taking them.";
	}
}
