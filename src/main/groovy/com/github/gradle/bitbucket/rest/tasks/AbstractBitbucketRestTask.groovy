/*
 * Copyright 2014 the original author or authors.
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
 
package com.github.gradle.bitbucket.rest.tasks

import com.github.gradle.bitbucket.rest.utils.BitbucketRestThreadContextClassLoader
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.tasks.Internal
import org.gradle.api.tasks.TaskAction

abstract class AbstractBitbucketRestTask extends DefaultTask {

    @Internal
    BitbucketRestThreadContextClassLoader threadContextClassLoader

    @TaskAction
    void start() {
        runInBitbucketClassPath { bitbucketClient ->
            runRemoteCommand(bitbucketClient)
        }
    }

    void runInBitbucketClassPath(Closure closure) {
        threadContextClassLoader.withClosure(closure)
    }

    abstract void runRemoteCommand(bitbucketClient)
    
    public String checkString(String dirtyString) {
        if (dirtyString == null) throw new GradleException("String to sanitize must not be null");
        String tempString = dirtyString.trim();
        if (tempString.length() > 0) {
            return tempString;
        } else {
            throw new GradleException("String to sanitize must not be empty")
        }
    }

    public String randomString() {
        UUID.randomUUID().toString().replaceAll("-", "")
    }
}
