package com.frey.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class CustomPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        println 'custom plugin being used'
        //在project中创建一个名为myExtension的扩展属性，将该属性映射到MyExtension类，
        // create方法的第三个参数project将作为参数传递到MyExtension的构造方法中
        project.extensions.create('myExtension', MyExtension, project)
        //为当前project创建一个名为MyTask的任务
        MyTask myTask = project.tasks.create('MyTask', MyTask)
        project.afterEvaluate {//gradle配置结束后执行以下方法
            def applicationVariants = project.extensions.android.applicationVariants//DefaultDomainObjectSet<ApplicationVariant>
            applicationVariants.all { variant -> //ApplicationVariantImpl
                def variantOutputs = variant.outputs//FactoryNamedDomainObjectContainer
                variantOutputs.each{
                    println '===============' + it.toString()//ApkVariantOutputImpl
                    //将MyTask插入到系统build过程的一系列任务中，这样只要执行build任务，就会在适当的时候执行我们自定义的task
                    myTask.mustRunAfter it.processManifestProvider.get()//在processManifest任务之后
                    it.processResourcesProvider.get().dependsOn myTask//在processResources任务之前
                }
            }
        }
    }
}