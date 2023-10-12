package ru.clevertec

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.tasks.testing.TestReport

class ReportPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.sourceSets {
            systemtest {
                main {
                    java {
                        srcDir 'src/main/java'
                    }
                }
                test {
                    java {
                        srcDir 'src/test/java'
                    }
                }
            }
        }

        project.task('report', type: TestReport) {
            doFirst {
                println('**do first**')
            }
            dependsOn('test')
            destinationDir = project.file("${project.buildDir}/reports/mytest")
            println('----STARTS----')
            def tR = getTestResults()
            tR.forEach {println it}
            reportOn(project.getTasks().named('test').get())
        }
    }
}