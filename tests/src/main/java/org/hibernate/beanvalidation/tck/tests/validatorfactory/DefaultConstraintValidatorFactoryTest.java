/*
* JBoss, Home of Professional Open Source
* Copyright 2009, Red Hat, Inc. and/or its affiliates, and individual contributors
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
* http://www.apache.org/licenses/LICENSE-2.0
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.hibernate.beanvalidation.tck.tests.validatorfactory;

import javax.validation.ConstraintValidatorFactory;
import javax.validation.ValidationException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.testng.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.test.audit.annotations.SpecAssertion;
import org.jboss.test.audit.annotations.SpecVersion;
import org.testng.annotations.Test;

import org.hibernate.beanvalidation.tck.util.TestUtil;
import org.hibernate.beanvalidation.tck.util.shrinkwrap.WebArchiveBuilder;

import static org.testng.Assert.assertTrue;

/**
 * @author Hardy Ferentschik
 * @author Gunnar Morling
 */
@SpecVersion(spec = "beanvalidation", version = "2.0.0")
public class DefaultConstraintValidatorFactoryTest extends Arquillian {

	@Deployment
	public static WebArchive createTestArchive() {
		return new WebArchiveBuilder()
				.withTestClass( DefaultConstraintValidatorFactoryTest.class )
				.withClass( MyConstraint.class )
				.withClass( MyConstraintValidator.class )
				.withClass( MySecondConstraint.class )
				.withClass( MySecondConstraintValidator.class )
				.build();
	}

	@Test
	@SpecAssertion(section = "5.5.3", id = "c")
	public void testDefaultConstructorInValidatorCalled() {
		ConstraintValidatorFactory factory = TestUtil.getConfigurationUnderTest()
				.getDefaultConstraintValidatorFactory();
		factory.getInstance( MyConstraintValidator.class );
		assertTrue(
				MyConstraintValidator.defaultConstructorCalled,
				"The no-arg default constructor should have been called."
		);
	}

	@SpecAssertion(section = "5.5.3", id = "c")
	@Test(expectedExceptions = ValidationException.class)
	public void testRuntimeExceptionInValidatorCreationIsWrapped() {
		ConstraintValidatorFactory factory = TestUtil.getConfigurationUnderTest()
				.getDefaultConstraintValidatorFactory();
		factory.getInstance( MySecondConstraintValidator.class );
	}
}