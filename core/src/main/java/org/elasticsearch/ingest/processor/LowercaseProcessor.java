/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.ingest.processor;

import java.util.Locale;

/**
 * Processor that converts the content of string fields to lowercase.
 * Throws exception is the field is not of type string.
 */

public class LowercaseProcessor extends AbstractStringProcessor {

    public static final String TYPE = "lowercase";

    LowercaseProcessor(String processorTag, String field) {
        super(processorTag, field);
    }

    @Override
    protected String process(String value) {
        return value.toLowerCase(Locale.ROOT);
    }

    @Override
    public String getType() {
        return TYPE;
    }

    public static class Factory extends AbstractStringProcessor.Factory<LowercaseProcessor> {

        public Factory() {
            super(TYPE);
        }

        @Override
        protected LowercaseProcessor newProcessor(String tag, String field) {
            return new LowercaseProcessor(tag, field);
        }
    }
}
