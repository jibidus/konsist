package com.lemonappdev.konsist.core.verify.koarchitectureassert

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitecture.assertArchitecture
import com.lemonappdev.konsist.core.architecture.Layer
import com.lemonappdev.konsist.core.exception.KoCheckFailedException
import com.lemonappdev.konsist.core.exception.KoPreconditionFailedException
import com.lemonappdev.konsist.core.filesystem.PathProvider
import org.amshove.kluent.shouldThrow
import org.amshove.kluent.withMessage
import org.junit.jupiter.api.Test

class KoArchitectureAssertTest {
    private val root = PathProvider.getInstance().rootProjectPath

    @Test
    fun `assert-passes`() {
        // given
        val layer1 = Layer("Presentation", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.presentation..")
        val layer2 = Layer("Business", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.business..")
        val scope =
            Konsist.scopeFromDirectory("lib/src/integrationTest/kotlin/com/lemonappdev/konsist/core/verify/koarchitectureassert/project")

        // then
        scope.assertArchitecture { layer1.dependsOn(layer2) }
    }

    @Test
    fun `assert-fails`() {
        // given
        val layer1 = Layer("Presentation", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.presentation..")
        val layer2 = Layer("Business", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.business..")
        val layer3 = Layer("Data", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.data..")
        val scope =
            Konsist.scopeFromDirectory("lib/src/integrationTest/kotlin/com/lemonappdev/konsist/core/verify/koarchitectureassert/project")

        // when
        val func = {
            scope.assertArchitecture {
                layer1.dependsOn(layer3)
                layer2.dependsOnNothing()
            }
        }

        // then
        func shouldThrow KoCheckFailedException::class withMessage """
            Assert 'assert-fails' has failed. Invalid dependencies (1):
            Layer: Presentation. Invalid files:
            $root/lib/src/integrationTest/kotlin/com/lemonappdev/konsist/core/verify/koarchitectureassert/project/presentation/PresentationClass.kt
        """.trimIndent()
    }

    @Test
    fun `throws exception when layer contain no files`() {
        // given
        val layer1 = Layer("Presentation", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.presentation..")
        val layer2 = Layer("EmptyLayer", "com.lemonappdev.konsist.core.verify.koarchitectureassert.project.emptylayer..")
        val scope =
            Konsist.scopeFromDirectory("lib/src/integrationTest/kotlin/com/lemonappdev/konsist/core/verify/koarchitectureassert/project")

        // when
        val func = {
            scope.assertArchitecture { layer1.dependsOn(layer2) }
        }

        // then
        func shouldThrow KoPreconditionFailedException::class withMessage "Layer EmptyLayer doesn't contain any files."
    }
}
