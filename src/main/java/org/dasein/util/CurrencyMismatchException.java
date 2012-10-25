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

package org.dasein.util;

import java.util.Currency;

/**
 * //TODO javadoc
 *
 * @author Morgan Catlin <morgan.catlin@valtira.com>.
 * @version 1.0
 */
public class CurrencyMismatchException extends RuntimeException {
    private static final long serialVersionUID = 355752221830949671L;

    public CurrencyMismatchException(Currency one, Currency other) {
        super("Failed to operate across currencies " + one + " and "
              + other + ".");
    }
}
