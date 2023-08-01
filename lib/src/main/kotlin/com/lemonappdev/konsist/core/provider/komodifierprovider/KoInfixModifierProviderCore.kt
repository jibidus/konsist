package com.lemonappdev.konsist.core.provider.komodifierprovider

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.provider.komodifierprovider.KoInfixModifierProvider
import com.lemonappdev.konsist.core.provider.KoBaseProviderCore

internal interface KoInfixModifierProviderCore :
    KoInfixModifierProvider,
    KoBaseProviderCore,
    KoModifierProviderCore {
    override val hasInfixModifier: Boolean
        get() = hasModifiers(KoModifier.INFIX)
}
