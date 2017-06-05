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

import org.gradle.api.GradleException
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional

abstract class ProjectRepositoryAware extends AbstractBitbucketRestTask {

    /**
     * Project to use for query
     */
    @Input
    Closure<String> projectName

    /**
     * Repository to user for query
     */
    @Input
    @Optional
    Closure<String> repositoryName

    public String projectName() {
        String var = projectName ? projectName.call() : null
        if (var?.trim()) {
            var
        } else {
            throw new GradleException("Project does not resolve to a valid String: projectName=" + projectName)
        }
    }

    public String repositoryName() {
        String var = repositoryName ? repositoryName.call() : null
        if (var?.trim()) {
            var
        } else {
            throw new GradleException("Repository does not resolve to a valid String: repositoryName=" + repositoryName)
        }
    }
}

