/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package ru.clevertec

import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import spock.lang.Specification

/**
 * A simple unit test for the 'ru.clevertec.greeting' plugin.
 */
class ReportPluginPluginTest extends Specification {
    def "plugin registers task"() {
        given:
        def project = ProjectBuilder.builder().build()

        when:
        project.plugins.apply("ru.clevertec.greeting")

        then:
        project.tasks.findByName("greeting") != null
    }
}
