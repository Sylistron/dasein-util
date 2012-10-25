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

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {
    private int    count = 1;
    private String name  = "Unknown";
    
    public NamedThreadFactory(Class owner) {
        this(owner, "");
    }
    
    public NamedThreadFactory(Class owner, String name) {
        this.name = "[" + owner.getName() + "] " + name;
    }
    
    public Thread newThread(Runnable r) {
        ThreadFactory factory = Executors.defaultThreadFactory();
        Thread t;
        
        t = factory.newThread(r);
        t.setName(name + " (" + (count++) + ")");
        return t;
    }
    
}
