package com.lemonappdev.konsist.api.declaration

import com.lemonappdev.konsist.api.provider.KoClassProvider
import com.lemonappdev.konsist.api.provider.KoFunctionProvider
import com.lemonappdev.konsist.api.provider.KoPropertyProvider

/**
 * Represents a Kotlin init block declaration.
 */
interface KoInitBlockDeclaration :
    KoClassProvider,
    KoPropertyProvider,
    KoFunctionProvider,
    KoBaseDeclaration
