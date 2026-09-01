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
package com.watabou.pixeldungeon.items.scrolls;

import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Speed;
import com.watabou.pixeldungeon.effects.SpellSprite;
import com.watabou.pixeldungeon.utils.GLog;

/**
 * New scroll (added on top of the original Pixel Dungeon source).
 * Grants the hero the Speed buff (normally seen from some traps/effects),
 * doubling movement speed for a short time - handy for fleeing or closing
 * distance.
 */
public class ScrollOfHaste extends Scroll {

	{
		name = "Scroll of Haste";
	}

	@Override
	protected void doRead() {
		Buff.affect( curUser, Speed.class, Speed.DURATION );

		SpellSprite.show( curUser, SpellSprite.CHARGE );
		Sample.INSTANCE.play( Assets.SND_READ );

		GLog.p( "Your legs tingle - you feel much faster!" );

		setKnown();

		readAnimation();
	}

	@Override
	public String desc() {
		return
			"A hastily-scrawled scroll that fills the reader's legs with restless " +
			"energy, doubling their movement speed for a short while.";
	}

	@Override
	public int price() {
		return isKnown() ? 20 * quantity : super.price();
	}
}
