/*
 * International System of Units (SI)
 * Copyright (c) 2005-2017, Jean-Marie Dautelle, Werner Keil and others.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363, Units of Measurement nor the names of their contributors may be used to
 *    endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package si.uom;

import static org.junit.Assert.assertEquals;
import static tec.units.ri.unit.MetricPrefix.*;
import static tec.units.ri.unit.Units.GRAM;
import static tec.units.ri.unit.Units.KILOGRAM;
import static tec.units.ri.unit.Units.METRE;

import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Mass;

import org.junit.Test;

import tec.units.ri.function.RationalConverter;

public class PrefixTest {
    @Test
    public void testKilo() {
	// TODO how to handle equals for units?
	assertEquals(KILOGRAM.toString(), KILO(GRAM).toString());
    }

    @Test
    public void testMega() {
	Unit<Mass> m1 = MEGA(GRAM);
	assertEquals("Mg", m1.toString()); // Passes in Maven/CI
    }

    @Test
    public void testNano() {
	Unit<Mass> m1 = NANO(GRAM);
	assertEquals("ng", m1.toString());
    }

    @Test
    public void testPicoNano() {
	Unit<Mass> m1 = PICO(KILOGRAM);
	assertEquals("ng", m1.toString());
    }

    @Test
    public void testBetweenPrefixes() {
	UnitConverter conv = YOTTA(METRE).getConverterTo(ZETTA(METRE));
	assertEquals(conv, new RationalConverter(4.7683715820312499E17, 4.76837158203125E14)); // TODO
											       // value?
    }

    @Test
    public void testBetweenPrefixes2() {
	UnitConverter conv = KILO(METRE).getConverterTo(GIGA(METRE));
	assertEquals(RationalConverter.of(1d, 1000000d), conv);
    }
}
