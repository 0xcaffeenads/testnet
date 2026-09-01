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

import com.watabou.pixeldungeon.actors.buffs.Bleeding;
import com.watabou.pixeldungeon.actors.buffs.Blindness;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.buffs.Burning;
import com.watabou.pixeldungeon.actors.buffs.Cripple;
import com.watabou.pixeldungeon.actors.buffs.Poison;
import com.watabou.pixeldungeon.actors.buffs.Vertigo;
import com.watabou.pixeldungeon.actors.buffs.Weakness;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.effects.Speck;
import com.watabou.pixeldungeon.utils.GLog;

/**
 * New potion (added on top of the original Pixel Dungeon source).
 * Unlike Potion of Healing, this doesn't restore health - it only
 * strips away negative status effects. Cheaper, and useful when the
 * hero is already at good health but is poisoned/burning/etc.
 */
public class PotionOfCleansing extends Potion {

	{
		name = "Potion of Cleansing";
	}

	@Override
	protected void apply( Hero hero ) {
		setKnown();

		Buff.detach( hero, Poison.class );
		Buff.detach( hero, Cripple.class );
		Buff.detach( hero, Weakness.class );
		Buff.detach( hero, Bleeding.class );
		Buff.detach( hero, Burning.class );
		Buff.detach( hero, Blindness.class );
		Buff.detach( hero, Vertigo.class );

		hero.sprite.emitter().start( Speck.factory( Speck.HEALING ), 0.4f, 2 );
		GLog.p( "A wave of clarity washes over you, purging the ill effects." );
	}

	@Override
	public String desc() {
		return
			"A clear, effervescent liquid. It does nothing for wounds, but it " +
			"instantly neutralizes poison, bleeding, burning and other afflictions " +
			"currently affecting the drinker.";
	}

	@Override
	public int price() {
		return isKnown() ? 20 * quantity : super.price();
	}
}
