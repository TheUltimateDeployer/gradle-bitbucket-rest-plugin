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
 
package com.github.gradle.bitbucket.rest;

import com.github.gradle.bitbucket.rest.tasks.AbstractBitbucketRestTask;
import com.github.gradle.bitbucket.rest.utils.BitbucketRestThreadContextClassLoader
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration

/**
 * Gradle plugin that provides custom tasks for interacting with Bitbucket via its remote API.
 */
class BitbucketRestPlugin implements Plugin<Project> {

    public static final String BITBUCKET_CONFIGURATION_NAME = 'bitbucketRest'
    public static final String BITBUCKET_REST_DEFAULT_VERSION = '0.0.16'
    public static final String EXTENSION_NAME = 'bitbucketRest'
    public static final String DEFAULT_TASK_GROUP = 'BitbucketRest'

    @Override
    void apply(Project project) {

        Configuration configuration = project.configurations.create(BITBUCKET_CONFIGURATION_NAME)
                .setVisible(false)
                .setTransitive(true)
                .setDescription('The Bitbucket Java libraries to be used for this project.')

        BitbucketRestExtension extension = project.extensions.create(EXTENSION_NAME, BitbucketRestExtension)
		configureAbstractBitbucketTask(project, extension)
    }
	
    private void configureAbstractBitbucketTask(Project project, BitbucketRestExtension extension) {
        BitbucketRestThreadContextClassLoader classLoader = new BitbucketRestThreadContextClassLoader(extension, configurePluginClassPath(project))
        project.tasks.withType(AbstractBitbucketRestTask) {
            group = DEFAULT_TASK_GROUP
            threadContextClassLoader = classLoader
        }
    }

    private static Configuration configurePluginClassPath(Project project) {
        project.repositories.addAll(project.buildscript.repositories.collect())
        Configuration configuration = project.configurations.getByName(BITBUCKET_CONFIGURATION_NAME)
        configuration.defaultDependencies { dependencies ->
            dependencies.add(project.dependencies.create("com.cdancy:bitbucket-rest:$BitbucketRestPlugin.BITBUCKET_REST_DEFAULT_VERSION"))
            dependencies.add(project.dependencies.create('org.slf4j:slf4j-simple:1.7.5'))
        }
        configuration
    }
}

