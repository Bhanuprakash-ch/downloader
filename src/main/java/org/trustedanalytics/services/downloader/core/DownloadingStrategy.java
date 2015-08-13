/**
 * Copyright (c) 2015 Intel Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.trustedanalytics.services.downloader.core;

import org.trustedanalytics.store.ObjectStore;

import java.io.IOException;
import java.io.InputStream;

/**
 * Provides method that is capable of downloading
 */
public interface DownloadingStrategy {

    /**
     * Copies all data from one stream to another one
     */
    default void download(InputStream in, ObjectStore store) throws IOException {
        download(in, store, RequestStatusObserver.EMPTY_REQUEST_STATUS_OBSERVER);
    }

    /**
     * Extra argument is used to provide notifications about changes and progress in downloading
     *
     * @return id that will make object available within object store
     */
    String download(InputStream in, ObjectStore store, RequestStatusObserver requestStatusObserver)
            throws IOException;

}
