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
import com.watabou.pixeldungeon.effects.SpellSprite;
import com.watabou.pixeldungeon.utils.GLog;

/**
 * New scroll (added on top of the original Pixel Dungeon source).
 * Instantly performs the same "search" the hero can already do manually
 * (the 's' action), revealing nearby secret doors and traps at once,
 * without spending several turns standing still.
 */
public class ScrollOfRevelation extends Scroll {

	{
		name = "Scroll of Revelation";
	}

	@Override
	protected void doRead() {
		curUser.search( true );

		SpellSprite.show( curUser, SpellSprite.MAP );
		Sample.INSTANCE.play( Assets.SND_READ );

		GLog.p( "Hidden things nearby reveal themselves to you." );

		setKnown();

		readAnimation();
	}

	@Override
	public String desc() {
		return
			"This scroll instantly reveals any secret doors and traps in the " +
			"hero's immediate surroundings, the same way carefully searching " +
			"the area would.";
	}

	@Override
	public int price() {
		return isKnown() ? 15 * quantity : super.price();
	}
}
