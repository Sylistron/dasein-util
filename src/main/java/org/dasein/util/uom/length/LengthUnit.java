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

package org.dasein.util.uom.length;

import org.dasein.util.uom.Measured;
import org.dasein.util.uom.UnitOfMeasure;
import org.dasein.util.uom.UnknownUnitOfMeasure;

import javax.annotation.Nonnull;

public abstract class LengthUnit extends UnitOfMeasure {
    static public @Nonnull LengthUnit valueOf(@Nonnull String uom) {
        if( uom.length() < 1 || uom.equals("m") || uom.equals("meter") || uom.equals("meters") || uom.equals("metre") || uom.equals("metres") ) {
            return Length.METER;
        }
        throw new UnknownUnitOfMeasure(uom);
    }
    
    @Nonnull
    @Override
    public Meter getBaseUnit() {
        return Length.METER;
    }
    
    @Nonnull
    @Override
    public Class<LengthUnit> getRootUnitOfMeasure() {
        return LengthUnit.class;
    }
   
    @Nonnull
    @Override
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <B extends UnitOfMeasure, U extends B> Measured<B, U> newQuantity(@Nonnull Number quantity) {
        return new Length(quantity, this);
    }
}
