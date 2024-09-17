/*
 * LibertyBans
 * Copyright © 2021 Anand Beh
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

package space.arim.libertybans.core.importing;

import space.arim.libertybans.api.NetworkAddress;

import java.time.Instant;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

public final class NameAddressRecord {

	private final UUID uuid;
	private final String name;
	private final NetworkAddress address;
	private final Instant timeRecorded;

	public NameAddressRecord(UUID uuid, String name, NetworkAddress address, Instant timeRecorded) {
		this.uuid = Objects.requireNonNull(uuid, "uuid");
		this.name = name;
		this.address = address;
		this.timeRecorded = Objects.requireNonNull(timeRecorded, "timeRecorded");
	}

	public UUID uuid() {
		return uuid;
	}

	public Optional<String> name() {
		return Optional.ofNullable(name);
	}

	public Optional<NetworkAddress> address() {
		return Optional.ofNullable(address);
	}

	public Instant timeRecorded() {
		return timeRecorded;
	}

	public NameAddressRecord withoutName() {
		return new NameAddressRecord(uuid, null, address, timeRecorded);
	}

	public NameAddressRecord withoutAddress() {
		return new NameAddressRecord(uuid, name, null, timeRecorded);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		NameAddressRecord that = (NameAddressRecord) o;
		return uuid.equals(that.uuid) && Objects.equals(name, that.name)
				&& Objects.equals(address, that.address) && timeRecorded.equals(that.timeRecorded);
	}

	@Override
	public int hashCode() {
		int result = uuid.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (address != null ? address.hashCode() : 0);
		result = 31 * result + timeRecorded.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "NameAddressRecord{" +
				"uuid=" + uuid +
				", name='" + name + '\'' +
				", address=" + address +
				", timeRecorded=" + timeRecorded +
				'}';
	}
}
