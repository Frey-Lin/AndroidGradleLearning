package com.frey.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project>{

    @Override
    void apply(Project project) {
        println 'custom plugin being used'
    }
}