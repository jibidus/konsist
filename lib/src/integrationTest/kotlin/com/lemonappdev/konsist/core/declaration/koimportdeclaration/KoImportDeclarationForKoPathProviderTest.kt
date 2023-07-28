package com.lemonappdev.konsist.core.declaration.koimportdeclaration

import com.lemonappdev.konsist.TestSnippetProvider.getSnippetKoScope
import org.amshove.kluent.assertSoftly
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoImportDeclarationForKoPathProviderTest {
    @Test
    fun `import-file-path`() {
        // given
        val sut = getSnippetFile("import-file-path")
            .imports
            .first()

        // then
        assertSoftly(sut.path) {
            startsWith("//") shouldBeEqualTo false
            endsWith("koimportdeclaration/snippet/forkopathprovider/import-file-path.kt") shouldBeEqualTo true
        }
    }

    @Test
    fun `import-project-file-path`() {
        // given
        val sut = getSnippetFile("import-project-file-path")
            .imports
            .first()

        // then
        sut
            .projectPath
            .shouldBeEqualTo(
                "/lib/src/integrationTest/kotlin/com/lemonappdev/konsist/core/declaration/koimportdeclaration/snippet/" +
                    "forkopathprovider/import-project-file-path.kt",
            )
    }

    @Test
    fun `import-reside-in-file-path`() {
        // given
        val sut = getSnippetFile("import-reside-in-file-path")
            .imports
            .first()

        // then
        assertSoftly(sut) {
            resideInPath("..snippet..", true) shouldBeEqualTo true
            resideInPath("..koimportdeclaration/snippet..", true) shouldBeEqualTo true
            resideInPath("..koimportdeclaration..import-reside-in-file-path.kt", true) shouldBeEqualTo true
            resideInPath("koimportdeclaration/snippet/", true) shouldBeEqualTo false
        }
    }

    @Test
    fun `import-reside-in-project-file-path`() {
        // given
        val sut = getSnippetFile("import-reside-in-project-file-path")
            .imports
            .first()

        // then
        assertSoftly(sut) {
            resideInPath("..snippet..", false) shouldBeEqualTo true
            resideInPath("..koimportdeclaration/snippet..", false) shouldBeEqualTo true
            resideInPath("..koimportdeclaration..import-reside-in-project-file-path.kt", false) shouldBeEqualTo true
            resideInPath("koimportdeclaration/snippet/", false) shouldBeEqualTo false
        }
    }

    private fun getSnippetFile(fileName: String) =
        getSnippetKoScope("core/declaration/koimportdeclaration/snippet/forkopathprovider/", fileName)
}
