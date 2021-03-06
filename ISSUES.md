# gradle-bitbucket-rest-plugin Issues

## Read through the documentation

Before submitting an issue ensure you've done the following:
* Read through our [documentation](https://github.com/cdancy/gradle-bitbucket-rest-plugin/blob/master/README.asciidoc) making sure you understand the tasks you're using.
* Read through our [groovydocs](http://cdancy.github.io/gradle-bitbucket-rest-plugin/docs/groovydoc/) for a more detailed explanation of how things work. 


## Try troubleshooting bitbucket

Here are a few things you can try to help diagnose the problem yourself:
* Can you reproduce the issue outside of the plugin?
* Have you looked at the bitbucket program logs themselves (i.e. systemctl status bitbucket) to see if anything popped?


## Submitting an ISSUE

If you've made it this far then the assumption is that you've read through our documentation and tried troubleshooting the problem but to no avail.

First check to see if your [issue](https://github.com/cdancy/gradle-bitbucket-rest-plugin/issues) has been previously reported on. 

Because we build on top of the [bitbucket-rest](https://github.com/cdancy/bitbucket-rest) library check also to see if [your issue](https://github.com/cdancy/bitbucket-rest/issues) has been reported on with that project as well. 

If neither of the above then please submit an ISSUE in the following format:

	plugin-version: 0.0.1
	gradle-version: 2.14
	bitbucket-version: 5.0
	platform: ubuntu linux
	description: terse explanation of the problem
	file: copy/paste build.gradle file which can reproduce the problem
	

	