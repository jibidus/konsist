package com.lemonappdev.konsist.core.util.fortaghelper

import com.lemonappdev.konsist.api.KoKDocTag.RETURN
import com.lemonappdev.konsist.api.declaration.KoKDocDeclaration
import com.lemonappdev.konsist.api.declaration.KoKDocTagDeclaration
import com.lemonappdev.konsist.core.util.TagHelper
import io.mockk.every
import io.mockk.mockk
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class TagHelperForReceiverTagTest {
    @Test
    fun `hasValidReceiverTag returns true when kDoc has receiver tag`() {
        // given
        val receiverTag: KoKDocTagDeclaration = mockk {
            every { name } returns RETURN
        }
        val kDoc: KoKDocDeclaration = mockk()
        every { kDoc.receiverTag } returns receiverTag

        val sut = TagHelper

        // then
        sut.hasValidReceiverTag(true, kDoc) shouldBeEqualTo true
    }

    @Test
    fun `hasValidReceiverTag returns false when kDoc is null`() {
        // given
        val kDoc = null
        val sut = TagHelper

        // then
        sut.hasValidReceiverTag(true, kDoc) shouldBeEqualTo false
    }

    @Test
    fun `hasValidReceiverTag returns true when verifyReceiverTag is false`() {
        // given
        val receiverTag: KoKDocTagDeclaration = mockk {
            every { name } returns RETURN
        }
        val kDoc: KoKDocDeclaration = mockk()
        every { kDoc.receiverTag } returns receiverTag
        val sut = TagHelper

        // then
        sut.hasValidReceiverTag(false, kDoc) shouldBeEqualTo true
    }
}
