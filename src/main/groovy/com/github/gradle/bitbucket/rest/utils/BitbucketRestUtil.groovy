package com.github.gradle.bitbucket.rest.utils

import java.lang.reflect.Array

final class BitbucketRestUtil {
	
    private BitbucketRestUtil() {}

    static Object[] toArray(List list) {
        if(list == null) { return null }
        Class clazz = list[0].getClass()
        list.toArray(Array.newInstance(clazz, 0))
    }

	static Class loadClass(ClassLoader classLoader, String className) {
		classLoader.loadClass(className)
	}
	
	/**
	 * Creates the classloader with the given classpath files.
	 *
	 * @param classpathFiles Classpath files
	 * @return URL classloader
	 */
	static URLClassLoader createClassLoader(Set<File> classpathFiles) {
		new URLClassLoader(toURLArray(classpathFiles), ClassLoader.systemClassLoader.parent)
	}
	
	/**
	 * Creates URL array from a set of files.
	 *
	 * @param files Files
	 * @return URL array
	 */
	static URL[] toURLArray(Set<File> files) {
		files.collect { file -> file.toURI().toURL() } as URL[]
	}
}

