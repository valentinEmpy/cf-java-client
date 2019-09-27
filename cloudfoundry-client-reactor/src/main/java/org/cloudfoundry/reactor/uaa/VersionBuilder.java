/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.reactor.uaa;

import io.netty.handler.codec.http.HttpHeaders;
import org.cloudfoundry.uaa.Versioned;

import java.util.Optional;

final class VersionBuilder {

    private VersionBuilder() {
    }

    static void augment(HttpHeaders httpHeaders, Object request) {
        if (request instanceof Versioned) {
            Versioned versioned = (Versioned) request;
            Optional.ofNullable(versioned.getVersion())
                .ifPresent(version -> httpHeaders.set("If-Match", version));
        }
    }

}
