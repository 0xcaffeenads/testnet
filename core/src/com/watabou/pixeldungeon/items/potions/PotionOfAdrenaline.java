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
package com.watabou.pixeldungeon.items.potions;

import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Speed;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.effects.Speck;
import com.watabou.pixeldungeon.utils.GLog;

/**
 * New potion (added on top of the original Pixel Dungeon source).
 * A weaker, faster alternative to Potion of Healing: it restores less
 * health, but also grants a short burst of Speed, useful for disengaging
 * from a losing fight rather than continuing it.
 */
public class PotionOfAdrenaline extends Potion {

	{
		name = "Potion of Adrenaline";
	}

	@Override
	protected void apply( Hero hero ) {
		setKnown();

		int missing = hero.HT - hero.HP;
		int heal = Math.round( missing * 0.35f );
		if (heal > 0) {
			hero.HP = Math.min( hero.HT, hero.HP + heal );
			hero.sprite.emitter().start( Speck.factory( Speck.HEALING ), 0.4f, 2 );
		}

		Buff.affect( hero, Speed.class, Speed.DURATION );

		GLog.p( "Your heart pounds - wounds close a little and your legs feel light!" );
	}

	@Override
	public String desc() {
		return
			"A bitter, fizzing liquid that floods the body with adrenaline. It " +
			"closes some of the drinker's wounds and grants a short burst of " +
			"speed, though it is far less effective at healing than a proper " +
			"healing potion.";
	}

	@Override
	public int price() {
		return isKnown() ? 25 * quantity : super.price();
	}
}
