
[![Build Status](https://travis-ci.org/cdancy/gradle-bitbucket-rest-plugin.svg?branch=master)](https://travis-ci.org/cdancy/gradle-bitbucket-rest-plugin)
[![codecov](https://codecov.io/gh/cdancy/gradle-bitbucket-rest-plugin/branch/master/graph/badge.svg)](https://codecov.io/gh/cdancy/gradle-bitbucket-rest-plugin)
[![Download](https://api.bintray.com/packages/cdancy/gradle-plugins/gradle-bitbucket-rest-plugin/images/download.svg) ](https://bintray.com/cdancy/gradle-plugins/gradle-bitbucket-rest-plugin/_latestVersion)
[![Stack Overflow](https://img.shields.io/badge/stack%20overflow-bitbucket-4183C4.svg)](https://stackoverflow.com/questions/tagged/bitbucket)
# gradle-bitbucket-rest-plugin
![alt tag](https://wac-cdn.atlassian.com/dam/jcr:e2a6f06f-b3d5-4002-aed3-73539c56a2eb/bitbucket_rgb_blue.png?cdnVersion=cm)

Gradle plugin for interacting with Bitbucket's REST API.

## Setup

```
buildscript() {
    repositories {
        jcenter()
    }
    dependencies {
        classpath group: 'com.github', name: 'gradle-bitbucket-rest-plugin', version: '0.0.1', changing: true
    }
 }

 apply plugin: 'gradle-bitbucket-rest-plugin'
 ```
 
## On new features

New tasks or features are generally added as needed and/or requested. If there is something you want to see just open an ISSUE and ask or send in a PullRequest. Generally speaking tasks here have a 1-to-1 mapping to endpoints in the [bitbucket-rest](https://github.com/cdancy/bitbucket-rest) java client. The philosophy is that this plugin should be generic in nature acting and act as building blocks for you to potentially build more complicated and specific plugins should you need to do so.

## Documentation

groovydocs can be found via [github pages here](http://cdancy.github.io/gradle-bitbucket-rest-plugin/docs/groovydoc/)

## Extension

The `bitbucketRest` extension is provided to define the `url` and `credentials` for connecting to an Bitbucket instance.
Using the extension, and subsequently exposing this potentially private information, is required only if one does NOT want to use the various means of setting the aforementioned properties noted in the `Credentials` section below.

```
 bitbucketRest {
     url { "http://127.0.0.1:7990" } // Optional and defaults to http://127.0.0.1:7990
     credentials { "admin:password" } // Optional and defaults to null
 }
```

## On Url and Credentials

Because this plugin builds on top of [bitbucket-rest](https://github.com/cdancy/bitbucket-rest) library one can supply
the [url and credentials](https://github.com/cdancy/bitbucket-rest#credentials) in any form this library accepts. Furthermore,
[bitbucket-rest](https://github.com/cdancy/bitbucket-rest#property-based-setup) allows the `url` and `credentials`
to be optionally supplied through properties or environment variables. This gives great flexibility in the way the user
wants to define and/or hide their url or credentials assuming one does not want to use the `bitbucketRest` extension.

## Tasks
### Branch operations

| Name | Description |
| --- | --- |
| [DeleteBranch](https://github.com/cdancy/gradle-bitbucket-rest-plugin/blob/master/src/main/groovy/com/github/gradle/bitbucket/rest/tasks/branch/DeleteBranch.groovy) | Delete a branch |

### PullRequest operations

| Name | Description |
| --- | --- |
| [GetPullRequest](https://github.com/cdancy/gradle-bitbucket-rest-plugin/blob/master/src/main/groovy/com/github/gradle/bitbucket/rest/tasks/pullrequest/GetPullRequest.groovy) | Get a PullRequest |

## Examples

The [functional](https://github.com/cdancy/gradle-bitbucket-rest-plugin/tree/master/src/functTest/groovy/com/github/gradle/bitbucket/rest) tests provide many examples that you can use in your own code.

## Components

- bitbucket-rest \- java library used to interact with bitbucket program

## Testing
	
Running functional tests against an existing bitbucket program can be done like so:

    ./gradlew functionalTest -PbitbucketUrl=http://127.0.0.1:7990 -PbitbucketCredentials=root:root
	
## Contributing
If you're looking for a new feature, or are interested in contributing, we'd love to review your PR. If you don't have a new feature in mind, and are more interested in just hacking on the project, feel free to reach out for suggestions.
	
## Additional Resources

* [bitbucket-rest](https://github.com/cdancy/bitbucket-rest)
