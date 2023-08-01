package com.lemonappdev.konsist.core.provider.komodifierprovider

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.provider.komodifierprovider.KoOpenModifierProvider
import com.lemonappdev.konsist.core.provider.KoBaseProviderCore

internal interface KoOpenModifierProviderCore :
    KoOpenModifierProvider,
    KoBaseProviderCore,
    KoModifierProviderCore {
    override val hasOpenModifier: Boolean
        get() = hasModifiers(KoModifier.OPEN)
}
