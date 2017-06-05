package com.github.gradle.bitbucket.rest

final class TestConfiguration {

    private static final String BITBUCKET_URL_SYS_PROP = 'bitbucketUrl'
    private static final String BITBUCKET_CREDENTIALS_SYS_PROP = 'bitbucketCredentials'

    private TestConfiguration() {}

    static String getBitbucketUrl() {
        System.properties[BITBUCKET_URL_SYS_PROP] ?: 'http://127.0.0.1:7990'
    }
    
    static String getBitbucketCredentials() {
        System.properties[BITBUCKET_CREDENTIALS_SYS_PROP] ?: 'root:root'
    }
}
