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

public class Length<T extends LengthUnit> extends Measured<LengthUnit,T> {
    static public final Meter METER = new Meter();
    
    @SuppressWarnings("unchecked")
    static public Length<? extends LengthUnit> valueOf(String str) {
        return Measured.valueOf(Length.class, str);
    }
    
    static public Length<? extends LengthUnit> valueOf(Number quantity, String uomName) {
        LengthUnit uom = LengthUnit.valueOf(uomName);

        return new Length<LengthUnit>(quantity, uom);
    }
    
    protected Length() { }
    
    public Length(Number quantity, T uom) {
        super(quantity, uom);
    }
}
