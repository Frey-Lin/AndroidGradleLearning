package com.frey.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 测试任务类
 */
class MyTask extends DefaultTask{

    MyTask(){
        //设置任务组为frey
        group = 'frey'
    }

    /**
     * 被TaskAction注解标注的方法会在任务执行过程中调用
     * 读取project中的myExtension扩展属性
     * @return
     */
    @TaskAction
    def readInfo(){
        def id = project.extensions.myExtension.id
        def name = project.extensions.myExtension.name
        def isEnable = project.extensions.myExtension.isEnable

        println "id = $id name = $name isEnable = $isEnable"
    }

}