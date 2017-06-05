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

import org.gradle.api.tasks.Input

/**
 * Delete a <a href="https://github.com/cdancy/bitbucket-rest/blob/master/src/main/java/com/cdancy/bitbucket/rest/features/BranchApi.java#L89">Branch</a>
 */
class DeleteBranch extends ProjectRepositoryAware {

	@Input
	Closure<String> branchPath

    @Override
    void runRemoteCommand(bitbucketClient) {
        def api = bitbucketClient.api().branchApi()
        def success = api.delete(projectName(), repositoryName(), branchPath.call())
        logger.quiet "Branch deletion success: ${success}"
    }
}

