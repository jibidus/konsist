package com.lemonappdev.konsist.core.provider

import com.lemonappdev.konsist.api.declaration.KoSecondaryConstructorDeclaration
import com.lemonappdev.konsist.api.provider.KoSecondaryConstructorsProvider
import com.lemonappdev.konsist.core.declaration.KoSecondaryConstructorDeclarationCore
import org.jetbrains.kotlin.psi.KtClass

internal interface KoSecondaryConstructorsProviderCore :
    KoSecondaryConstructorsProvider,
    KoContainingDeclarationProviderCore,
    KoBaseProviderCore {
    val ktClass: KtClass

    override val secondaryConstructors: List<KoSecondaryConstructorDeclaration>
        get() =
            ktClass
                .secondaryConstructors
                .map { KoSecondaryConstructorDeclarationCore.getInstance(it, this) }

    override val numSecondaryConstructors: Int
        get() = secondaryConstructors.size

    override val hasSecondaryConstructors: Boolean
        get() = ktClass.hasSecondaryConstructors()
}