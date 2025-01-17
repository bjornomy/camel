/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

import org.apache.camel.Ordered;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.util.IOHelper;
import org.apache.camel.util.OrderedProperties;

public class ClasspathPropertiesSource extends AbstractLocationPropertiesSource implements Ordered {

    public ClasspathPropertiesSource(PropertiesComponent propertiesComponent, PropertiesLocation location) {
        super(propertiesComponent, location);
    }

    @Override
    public String getName() {
        return "ClasspathPropertiesSource[" + getLocation().getPath() + "]";
    }

    @Override
    protected Properties loadPropertiesFromLocation(PropertiesComponent propertiesComponent, PropertiesLocation location) {
        Properties answer = new OrderedProperties();
        String path = location.getPath();

        InputStream is = propertiesComponent.getCamelContext().getClassResolver().loadResourceAsStream(path);
        Reader reader = null;
        if (is == null) {
            if (!propertiesComponent.isIgnoreMissingLocation() && !location.isOptional()) {
                throw RuntimeCamelException.wrapRuntimeCamelException(
                        new FileNotFoundException("Properties file " + path + " not found in classpath"));
            }
        } else {
            try {
                if (propertiesComponent.getEncoding() != null) {
                    reader = new BufferedReader(new InputStreamReader(is, propertiesComponent.getEncoding()));
                    answer.load(reader);
                } else {
                    answer.load(is);
                }
            } catch (IOException e) {
                throw RuntimeCamelException.wrapRuntimeCamelException(e);
            } finally {
                IOHelper.close(reader, is);
            }
        }
        return answer;
    }

    @Override
    public int getOrder() {
        return 200;
    }
}
