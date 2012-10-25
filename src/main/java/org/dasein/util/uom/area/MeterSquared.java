/**
 * Copyright (C) 1998-2012 enStratus Networks Inc
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.util.uom.area;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

import org.dasein.util.uom.Measured;
import org.dasein.util.uom.UnitOfMeasure;

import javax.annotation.Nonnull;

public class MeterSquared extends AreaUnit {
    public MeterSquared() { }
    
    @Override
    public double getBaseUnitConversion() {
        return 1.0;
    }
    
    @Nonnull
    @Override
    public String format(@Nonnull Number quantity) {
        MessageFormat fmt = new MessageFormat("{0}");

        fmt.setFormatByArgumentIndex(0, new ChoiceFormat(new double[] {0,1,2}, new String[] {"0 meters","1 meter","{0,number} meters"}));
        return fmt.format(new Object[] { quantity });
    }

    @Nonnull
    @Override
    public Class<? extends UnitOfMeasure> getRootUnitOfMeasure() {
        return AreaUnit.class;
    }

    @Nonnull
    @Override
    public UnitOfMeasure getBaseUnit() {
        return Area.METER_SQUARED;
    }

    @Nonnull
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <B extends UnitOfMeasure, U extends B> Measured<B, U> newQuantity(@Nonnull Number quantity) {
        return new Area(quantity, this);
    }
}
