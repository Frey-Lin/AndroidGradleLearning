package com.frey.plugin

import org.gradle.api.Project

/**
 * 扩展属性类
 */
class MyExtension {
    String name
    String id
    boolean isEnable

    private Project mProject

    MyExtension(Project project) {
        println "constructor is called, poject=${project}"
        mProject = project
    }


    @Override
    String toString() {
        return """\
MyExtension{
    name='$name', 
    id='$id', 
    isEnable=$isEnable
}"""
    }
}