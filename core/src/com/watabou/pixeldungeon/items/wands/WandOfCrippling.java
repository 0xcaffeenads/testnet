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
package com.watabou.pixeldungeon.items.wands;

import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.actors.Actor;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Cripple;
import com.watabou.pixeldungeon.effects.MagicMissile;
import com.watabou.pixeldungeon.utils.GLog;
import com.watabou.utils.Callback;

/**
 * New wand (added on top of the original Pixel Dungeon source).
 * Unlike Wand of Slowness (which halves movement AND attack speed),
 * this only weakens the target's attacks, leaving their speed alone -
 * useful against fast, hard-hitting enemies.
 */
public class WandOfCrippling extends Wand {

	{
		name = "Wand of Crippling";
	}

	@Override
	protected void onZap( int cell ) {
		Char ch = Actor.findChar( cell );
		if (ch != null) {

			Buff.affect( ch, Cripple.class, Cripple.DURATION + power() );

		} else {

			GLog.i( "nothing happened" );

		}
	}

	protected void fx( int cell, Callback callback ) {
		MagicMissile.slowness( curUser.sprite.parent, curUser.pos, cell, callback );
		Sample.INSTANCE.play( Assets.SND_ZAP );
	}

	@Override
	public String desc() {
		return
			"This wand saps the strength from a creature's limbs, greatly " +
			"reducing the damage of its attacks for a while, without affecting " +
			"how fast it moves.";
	}
}
