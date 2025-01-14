/*
 * Copyright 2021 SkyAPM
 *
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
 *
 */

package org.skyapm.transporter.fetcher.pulsar.provider.handler;

import org.skyapm.transporter.fetcher.pulsar.module.PulsarFetcherConfig;

public abstract class AbstractPulsarHandler implements PulsarHandler {
    protected PulsarFetcherConfig config;

    public AbstractPulsarHandler(PulsarFetcherConfig config) {
        this.config = config;
    }

    @Override
    public String getTopic() {
        StringBuilder builder = new StringBuilder();
        builder.append(config.getDomain())
                .append("://")
                .append(config.getNamespace())
                .append("/")
                .append(getPlainTopic());
        return  builder.toString();
    }

    protected abstract String getPlainTopic();

}
