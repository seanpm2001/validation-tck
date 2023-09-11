/**
 * Jakarta Validation TCK
 *
 * License: Apache License, Version 2.0
 * See the license.txt file in the root directory or <http://www.apache.org/licenses/LICENSE-2.0>.
 */
package org.hibernate.beanvalidation.tck.tests.validation.graphnavigation;

import jakarta.validation.Valid;

/**
 * @author Hardy Ferentschik
 */
public class GameReserve<T extends Animal> {
	@Valid
	Herd<T> herd;

	public void setHerd(Herd<T> herd) {
		this.herd = herd;
	}
}
