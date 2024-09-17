/*
 * LibertyBans
 * Copyright © 2022 Anand Beh
 *
 * LibertyBans is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * LibertyBans is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */

package space.arim.libertybans.core.addon;

import java.util.Objects;

public abstract class AbstractAddon<C extends AddonConfig> implements Addon<C> {

	private final AddonCenter addonCenter;

	protected AbstractAddon(AddonCenter addonCenter) {
		this.addonCenter = Objects.requireNonNull(addonCenter);
	}

	/**
	 * Convenience method to access the current configuration
	 *
	 * @return the current configuration for this addon
	 */
	public C config() {
		return addonCenter.configurationFor(this);
	}

}
