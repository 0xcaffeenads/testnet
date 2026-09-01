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
import com.watabou.pixeldungeon.items.Gold;
import com.watabou.utils.Random;

/**
 * New elite mob (added on top of the original Pixel Dungeon source).
 *
 * A rare, much tougher rat that leads a pack. Reuses the regular rat's
 * sprite (RatSprite is inherited from Rat) since no new artwork was added -
 * it's told apart by its name, higher stats and better loot rather than a
 * new look.
 */
public class RatKing extends Rat {

	{
		name = "rat king";

		HP = HT = 40;
		defenseSkill = 10;

		EXP = 6;
		maxLvl = 7;
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange( 4, 12 );
	}

	@Override
	public int attackSkill( Char target ) {
		return 16;
	}

	@Override
	public int dr() {
		return 3;
	}

	@Override
	public void die( Object cause ) {
		super.die( cause );

		Dungeon.level.drop( new Gold( Random.IntRange( 20, 40 ) ), pos ).sprite.drop();
		Badges.validateRare( this );
	}

	@Override
	public String description() {
		return
			"Bigger, meaner and smarter than its kin, this rat has clawed its way " +
			"to the top of the pack. It fights with the confidence of something " +
			"that has never lost a fight - yet.";
	}
}
