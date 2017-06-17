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
 
package com.github.gradle.bitbucket.rest.tasks.branch

import com.github.gradle.bitbucket.rest.tasks.ProjectRepositoryAware
import org.gradle.api.GradleException

import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Internal

/**
 * Get a <a href="https://github.com/cdancy/bitbucket-rest/blob/master/src/main/java/com/cdancy/bitbucket/rest/features/PullRequestApi.java#L70">PullRequest</a>
 */
class GetPullRequest extends ProjectRepositoryAware {

    @Input
    Closure<Integer> pullRequestId

    @Internal
    private def instance
    
    @Override
    void runRemoteCommand(bitbucketClient) {
        def api = bitbucketClient.api().pullRequestApi()
        def localPullRequestId = pullRequestId.call()
        def localProjectName = projectName()
        def localRepositoryName = repositoryName()
        instance = api.get(localProjectName, localRepositoryName, localPullRequestId)
        if (!instance.errors()) {
            logger.quiet "Successfully retrieved PullRequest @ ${localProjectName}/${localRepositoryName}:${localPullRequestId}"
        } else {
            throw new GradleException("Failed to retrieve PullRequest @ ${localProjectName}/${localRepositoryName}:${localPullRequestId}: errors=${instance.errors().join(',')}")
        }
    }
    
    def instance() {
        instance
    }
}

