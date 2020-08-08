/* 
 * LibertyBans-bootstrap
 * Copyright © 2020 Anand Beh <https://www.arim.space>
 * 
 * LibertyBans-bootstrap is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * LibertyBans-bootstrap is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with LibertyBans-bootstrap. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Affero General Public License.
 */
package space.arim.libertybans.bootstrap;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Instantiator {

	private final Class<?> clazz;
	
	public Instantiator(String clazzName, ClassLoader loader) throws ClassNotFoundException {
		clazz = Class.forName(clazzName, true, loader);
	}
	
	public <T> BaseEnvironment invoke(Class<T> parameterType, T parameter)
			throws ReflectiveOperationException, IllegalArgumentException, SecurityException {
		return (BaseEnvironment) clazz.getDeclaredConstructor(parameterType).newInstance(parameter);
	}

	public <T, U> BaseEnvironment invoke(Class<T> parameter1Type, T parameter1, Class<U> parameter2Type, U parameter2)
			throws ReflectiveOperationException, IllegalArgumentException, SecurityException {
		return (BaseEnvironment) clazz.getDeclaredConstructor(parameter1Type, parameter2Type).newInstance(parameter1,
				parameter2);
	}
	
	/**
	 * Creates a reasonable thread pool for downloading dependencies.
	 * 
	 * @return a thread pool for downloading dependencies
	 */
	public static ExecutorService createReasonableExecutor() {
		int threads = 5;
		return Executors.newFixedThreadPool(threads);
	}
	
}
