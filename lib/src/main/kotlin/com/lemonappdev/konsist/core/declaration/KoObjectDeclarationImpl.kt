package com.lemonappdev.konsist.core.declaration

import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.declaration.KoObjectDeclaration
import com.lemonappdev.konsist.api.provider.KoParentProvider
import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import com.lemonappdev.konsist.core.provider.util.KoDeclarationCoreProviderUtil
import com.lemonappdev.konsist.core.provider.KoAnnotationDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoClassProviderCore
import com.lemonappdev.konsist.core.provider.KoDeclarationFullyQualifiedNameProviderCore
import com.lemonappdev.konsist.core.provider.KoDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoFunctionProviderCore
import com.lemonappdev.konsist.core.provider.KoInterfaceProviderCore
import com.lemonappdev.konsist.core.provider.KoModifierProviderCore
import com.lemonappdev.konsist.core.provider.KoObjectProviderCore
import com.lemonappdev.konsist.core.provider.KoPackageDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoPropertyProviderCore
import com.lemonappdev.konsist.core.provider.KoRepresentsTypeProviderCore
import com.lemonappdev.konsist.core.provider.KoResideInOrOutsidePackageProviderCore
import com.lemonappdev.konsist.core.provider.KoTopLevelProviderCore
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtObjectDeclaration
import org.jetbrains.kotlin.psi.KtTypeParameterListOwner

internal class KoObjectDeclarationImpl(
    private val ktObjectDeclaration: KtObjectDeclaration,
    override val parentDeclaration: KoParentProvider?,
) :
    KoObjectDeclaration,
    KoDeclarationProviderCore,
    KoClassProviderCore,
    KoInterfaceProviderCore,
    KoObjectProviderCore,
    KoPropertyProviderCore,
    KoFunctionProviderCore,
    KoBaseDeclarationImpl(ktObjectDeclaration),
    KoAnnotationDeclarationProviderCore,
    KoPackageDeclarationProviderCore,
    KoResideInOrOutsidePackageProviderCore,
    KoDeclarationFullyQualifiedNameProviderCore,
    KoModifierProviderCore,
    KoTopLevelProviderCore,
    KoRepresentsTypeProviderCore {
    override val ktAnnotated: KtAnnotated
        get() = ktObjectDeclaration

    override val ktFile: KtFile?
        get() = null

    override val ktTypeParameterListOwner: KtTypeParameterListOwner
        get() = ktObjectDeclaration

    override val name: String by lazy {
        if (hasCompanionModifier() && super<KoBaseDeclarationImpl>.name == "") {
            "Companion"
        } else {
            super<KoBaseDeclarationImpl>.name
        }
    }

    override fun declarations(
        includeNested: Boolean,
        includeLocal: Boolean,
    ): Sequence<KoBaseDeclaration> = KoDeclarationCoreProviderUtil
        .getKoDeclarations(ktObjectDeclaration, includeNested, includeLocal, this)

    internal companion object {
        private val cache: KoDeclarationCache<KoObjectDeclaration> = KoDeclarationCache()

        internal fun getInstance(ktObjectDeclaration: KtObjectDeclaration, parentDeclaration: KoParentProvider?): KoObjectDeclaration =
            cache.getOrCreateInstance(ktObjectDeclaration, parentDeclaration) {
                KoObjectDeclarationImpl(
                    ktObjectDeclaration,
                    parentDeclaration,
                )
            }
    }
}
