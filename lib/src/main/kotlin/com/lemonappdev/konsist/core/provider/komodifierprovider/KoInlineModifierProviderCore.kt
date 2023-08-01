package com.lemonappdev.konsist.core.provider.komodifierprovider

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.provider.komodifierprovider.KoInlineModifierProvider
import com.lemonappdev.konsist.core.provider.KoBaseProviderCore

internal interface KoInlineModifierProviderCore :
    KoInlineModifierProvider,
    KoBaseProviderCore,
    KoModifierProviderCore {
    override val hasInlineModifier: Boolean
        get() = hasModifiers(KoModifier.INLINE)
}
