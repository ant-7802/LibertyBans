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

package space.arim.libertybans.core.commands.extra;

import org.junit.jupiter.api.Test;
import space.arim.libertybans.api.NetworkAddress;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddressParserTest {

	static NetworkAddress randomIpv4() {
		Random random = ThreadLocalRandom.current();
		byte[] result = new byte[4];
		random.nextBytes(result);
		return NetworkAddress.of(result);
	}

	private static String ipv4ToString(NetworkAddress ipv4) {
		List<String> octets = new ArrayList<>(4);
		for (byte octet : ipv4.getRawAddress()) {
			octets.add(Integer.toString(Byte.toUnsignedInt(octet)));
		}
		return String.join(".", octets);
	}

	@Test
	public void parseRandomIpv4() {
		NetworkAddress address = randomIpv4();
		assertEquals(address, AddressParser.parseIpv4(ipv4ToString(address)));
	}
}
