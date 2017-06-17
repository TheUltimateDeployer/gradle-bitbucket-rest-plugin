package com.github.gradle.bitbucket.rest

import org.gradle.testkit.runner.BuildResult
import spock.lang.Requires

class PullRequestTests extends AbstractFunctionalTest {

    def "Can get a PullRequest"() {

        buildFile << """
            task getPullRequest(type: com.github.gradle.bitbucket.rest.tasks.pullrequest.GetPullRequest) {
                projectName { "my-repo" }
                repositoryName { "my-project" }
                pullRequestId { 12345 }
            }
            
            task workflow {
                dependsOn getPullRequest
            }
        """

        when:
        BuildResult result = build('workflow')

        then:
        result.output.contains('Successfully retrieved PullRequest')
    }
    
    def "Can get a PullRequest and fail on errors"() {

        buildFile << """
            task getPullRequest(type: com.github.gradle.bitbucket.rest.tasks.pullrequest.GetPullRequest) {
                projectName { "my-repo" }
                repositoryName { "my-project" }
                pullRequestId { 12345 }
            }
            
            task workflow {
                dependsOn getPullRequest
            }
        """

        when:
        BuildResult result = buildAndFail('workflow')

        then:
        result.output.contains('Failed to retrieve PullRequest')
    }
}

