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
 *
 * A rare, much tougher skeleton, still made of old bones - it reuses the
 * regular skeleton's sprite (no new artwork), and is told apart by its
 * name, higher stats and guaranteed loot drop.
 */
public class SkeletonChampion extends Skeleton {

	{
		name = "skeleton champion";

		HP = HT = 55;
		defenseSkill = 14;

		EXP = 9;
		maxLvl = 13;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 6, 14 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 18;
	}

	@Override
	public int dr() {
		return 7;
	}

	@Override
	protected void dropLoot() {
		Item loot = Random.Int( 2 ) == 0 ?
			Generator.random( Generator.Category.WEAPON ) :
			Generator.random( Generator.Category.ARMOR );
		Dungeon.level.drop( loot, pos ).sprite.drop();
		Badges.validateRare( this );
	}

	@Override
	public String description() {
		return
			"The bones of this skeleton are reinforced with dark, ancient magic, " +
			"binding it together far more tightly than its lesser kin. It once " +
			"commanded soldiers - it still fights like it does.";
	}
}
