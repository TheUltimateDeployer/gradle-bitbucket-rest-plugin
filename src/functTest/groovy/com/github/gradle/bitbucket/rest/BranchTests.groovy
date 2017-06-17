package com.github.gradle.bitbucket.rest

import org.gradle.testkit.runner.BuildResult
import spock.lang.Requires

class BranchTests extends AbstractFunctionalTest {

    def "Can delete a branch"() {

        buildFile << """
            task deleteBranch(type: com.github.gradle.bitbucket.rest.tasks.branch.DeleteBranch) {
                projectName { "my-project" }
                repositoryName { "my-repo" }
                branchPath { "my-branch" }
            }
            
            task workflow {
                dependsOn deleteBranch
            }
        """

        when:
        BuildResult result = build('workflow')

        then:
        result.output.contains('Successfully deleted Branch')
    }
}

