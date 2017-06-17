package com.github.gradle.bitbucket.rest

import org.gradle.testkit.runner.BuildResult
import spock.lang.Requires

class PullRequestTests extends AbstractFunctionalTest {

    def "Can get a PullRequest"() {

        buildFile << """
            task getPullRequest(type: com.github.gradle.bitbucket.rest.tasks.pullrequest.GetPullRequest) {
                projectName { "PRPC" }
                repositoryName { "prpc-platform" }
                pullRequestId { 11567 }
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
}

