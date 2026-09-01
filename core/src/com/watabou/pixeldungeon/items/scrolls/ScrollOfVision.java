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
import com.watabou.pixeldungeon.actors.buffs.MindVision;
import com.watabou.pixeldungeon.effects.SpellSprite;
import com.watabou.pixeldungeon.utils.GLog;

/**
 * New scroll (added on top of the original Pixel Dungeon source).
 * Grants the same Mind Vision buff as Potion of Mind Vision, letting the
 * reader sense nearby creatures through walls for a while.
 */
public class ScrollOfVision extends Scroll {

	{
		name = "Scroll of Vision";
	}

	@Override
	protected void doRead() {
		Buff.affect( curUser, MindVision.class, MindVision.DURATION );

		SpellSprite.show( curUser, SpellSprite.MAP );
		Sample.INSTANCE.play( Assets.SND_READ );

		GLog.p( "Your mind reaches out, sensing the creatures nearby." );

		setKnown();

		readAnimation();
	}

	@Override
	public String desc() {
		return
			"Reading this scroll of ancient runes lets you sense the presence " +
			"of every living creature on the level for a short while, even " +
			"through walls.";
	}

	@Override
	public int price() {
		return isKnown() ? 20 * quantity : super.price();
	}
}
