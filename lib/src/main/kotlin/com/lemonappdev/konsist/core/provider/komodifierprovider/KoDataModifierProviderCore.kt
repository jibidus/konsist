package com.lemonappdev.konsist.core.provider.komodifierprovider

import com.lemonappdev.konsist.api.KoModifier
import com.lemonappdev.konsist.api.provider.komodifierprovider.KoDataModifierProvider
import com.lemonappdev.konsist.core.provider.KoBaseProviderCore

internal interface KoDataModifierProviderCore :
    KoDataModifierProvider,
    KoBaseProviderCore,
    KoModifierProviderCore {
    override val hasDataModifier: Boolean
        get() = hasModifiers(KoModifier.DATA)
}
