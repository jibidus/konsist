package com.lemonappdev.konsist.api.declaration

import com.lemonappdev.konsist.api.provider.KoAnnotationDeclarationProvider
import com.lemonappdev.konsist.api.provider.KoDeclarationFullyQualifiedNameProvider
import com.lemonappdev.konsist.api.provider.KoModifierProvider
import com.lemonappdev.konsist.api.provider.KoPackageDeclarationProvider
import com.lemonappdev.konsist.api.provider.KoParentProvider
import com.lemonappdev.konsist.api.provider.KoTopLevelProvider
import com.lemonappdev.konsist.core.declaration.KoBaseDeclarationImpl

/**
 * Represents a Kotlin type alias declaration.
 */
interface KoTypeAliasDeclaration :
    KoBaseDeclaration,
    KoAnnotationDeclarationProvider,
    KoPackageDeclarationProvider,
    KoDeclarationFullyQualifiedNameProvider,
    KoModifierProvider,
    KoTopLevelProvider,
    KoParentProvider {
    /**
     * Type alias type.
     */
    val type: KoTypeDeclaration

    /**
     * Whether the type alias has actual modifier.
     *
     * @return `true` if the type alias has the `actual` modifier, `false` otherwise.
     */
    fun hasActualModifier(): Boolean
}
