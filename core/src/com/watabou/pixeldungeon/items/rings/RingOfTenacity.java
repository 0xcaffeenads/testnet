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
package com.watabou.pixeldungeon.items.rings;

/**
 * New ring (added on top of the original Pixel Dungeon source).
 * Passively raises damage reduction, similar in spirit to Potion of Stone
 * Skin but permanent while worn. The bonus is read directly in
 * Hero.dr() (see the "// new: Ring of Tenacity" comment there).
 */
public class RingOfTenacity extends Ring {

	{
		name = "Ring of Tenacity";
	}

	@Override
	protected RingBuff buff() {
		return new Tenacity();
	}

	@Override
	public String desc() {
		return isKnown() ?
			"This ring passively toughens the wearer's skin, granting a small " +
			"but permanent bonus to damage reduction." :
			super.desc();
	}

	public class Tenacity extends RingBuff {
	}
}
