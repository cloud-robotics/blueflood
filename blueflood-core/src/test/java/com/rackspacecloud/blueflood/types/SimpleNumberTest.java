/*
 * Copyright 2013 Rackspace
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.rackspacecloud.blueflood.types;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SimpleNumberTest {

    @Test
    public void constructorWithIntegerSetsValue() {

        // given
        Object testValue = new Integer(4);

        // when
        SimpleNumber simpleNumber = new SimpleNumber(testValue);

        // then
        assertEquals(testValue, simpleNumber.getValue());
        assertEquals(SimpleNumber.Type.INTEGER, simpleNumber.getDataType());
        assertTrue(simpleNumber.hasData());
    }

    @Test
    public void constructorWithDoubleSetsValue() {

        // given
        Object testValue = new Double(5.0);

        // when
        SimpleNumber simpleNumber = new SimpleNumber(testValue);

        // then
        assertEquals(testValue, simpleNumber.getValue());
        assertEquals(SimpleNumber.Type.DOUBLE, simpleNumber.getDataType());
        assertTrue(simpleNumber.hasData());
    }

    @Test
    public void constructorWithLongSetsValue() {

        // given
        Object testValue = new Long(5L);

        // when
        SimpleNumber simpleNumber = new SimpleNumber(testValue);

        // then
        assertEquals(testValue, simpleNumber.getValue());
        assertEquals(SimpleNumber.Type.LONG, simpleNumber.getDataType());
        assertTrue(simpleNumber.hasData());
    }

    @Test
    public void constructorWithBoxedIntegerSetsValue() {

        // given
        Object testValue = 4;

        // when
        SimpleNumber simpleNumber = new SimpleNumber(testValue);

        // then
        assertEquals(testValue, simpleNumber.getValue());
        assertEquals(SimpleNumber.Type.INTEGER, simpleNumber.getDataType());
        assertTrue(simpleNumber.hasData());
    }

    @Test(expected = NullPointerException.class)
    public void constructorWithNullThrowsException() {

        // when
        SimpleNumber simpleNumber = new SimpleNumber(null);

        // then
        // the exception is thrown
    }

    @Test
    public void constructorWithSimpleNumberSetsValue() {

        // given
        Object testValue = new SimpleNumber(123L);

        // when
        SimpleNumber simpleNumber = new SimpleNumber(testValue);

        // then
        assertEquals(123L, simpleNumber.getValue());
        assertEquals(SimpleNumber.Type.LONG, simpleNumber.getDataType());
        assertTrue(simpleNumber.hasData());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithFloatThrowsException() {

        // when
        SimpleNumber simpleNumber = new SimpleNumber(123.45f);

        // then
        // the exception is thrown
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorWithOtherTypeThrowsException() {

        // when
        SimpleNumber simpleNumber = new SimpleNumber(new Object());

        // then
        // the exception is thrown
    }
}
