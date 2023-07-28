package com.lemonappdev.konsist.core.declaration.kopackagedeclaration

import com.lemonappdev.konsist.TestSnippetProvider
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class KoPackageDeclarationTest {
    @Test
    fun `package-to-string`() {
        // given
        val sut = getSnippetFile("package-to-string")
            .packages
            .first()

        // then
        sut.toString() shouldBeEqualTo sut.locationWithText
    }

    private fun getSnippetFile(fileName: String) =
        TestSnippetProvider.getSnippetKoScope("core/declaration/kopackagedeclaration/snippet/forgeneral/", fileName)
}
