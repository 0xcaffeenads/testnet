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

import com.watabou.pixeldungeon.actors.buffs.Barkskin;
import com.watabou.pixeldungeon.actors.buffs.Buff;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.sprites.CharSprite;
import com.watabou.pixeldungeon.utils.GLog;

/**
 * New potion (added on top of the original Pixel Dungeon source).
 * Hardens the hero's skin temporarily, granting the same kind of
 * damage-reduction buff normally given by high grass/Sungrass ("Barkskin"),
 * scaled off the hero's current health.
 */
public class PotionOfStoneSkin extends Potion {

	{
		name = "Potion of Stone Skin";
	}

	@Override
	protected void apply( Hero hero ) {
		setKnown();

		Buff.affect( hero, Barkskin.class ).level( hero.HT / 2 );

		hero.sprite.showStatus( CharSprite.POSITIVE, "stone skin" );
		GLog.p( "Your skin hardens like stone!" );
	}

	@Override
	public String desc() {
		return
			"This gritty, mineral-laden liquid temporarily hardens the drinker's skin, " +
			"granting a strong bonus to damage reduction for a while. The effect fades " +
			"gradually as the stony crust wears away.";
	}

	@Override
	public int price() {
		return isKnown() ? 30 * quantity : super.price();
	}
}
