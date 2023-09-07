package com.lemonappdev.konsist.core.declaration

import com.intellij.psi.PsiElement
import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.declaration.KoEnumConstantDeclaration
import com.lemonappdev.konsist.api.provider.KoContainingDeclarationProvider
import com.lemonappdev.konsist.core.cache.KoDeclarationCache
import com.lemonappdev.konsist.core.provider.KoAnnotationProviderCore
import com.lemonappdev.konsist.core.provider.KoBaseProviderCore
import com.lemonappdev.konsist.core.provider.KoContainingDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoContainingFileProviderCore
import com.lemonappdev.konsist.core.provider.KoDeclarationFullyQualifiedNameProviderCore
import com.lemonappdev.konsist.core.provider.KoEnumNameProviderCore
import com.lemonappdev.konsist.core.provider.KoKDocProviderCore
import com.lemonappdev.konsist.core.provider.KoLocalClassProviderCore
import com.lemonappdev.konsist.core.provider.KoLocalDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.KoLocalFunctionProviderCore
import com.lemonappdev.konsist.core.provider.KoLocationProviderCore
import com.lemonappdev.konsist.core.provider.KoNameProviderCore
import com.lemonappdev.konsist.core.provider.KoPathProviderCore
import com.lemonappdev.konsist.core.provider.KoResideInOrOutsidePackageProviderCore
import com.lemonappdev.konsist.core.provider.KoResideInPackageProviderCore
import com.lemonappdev.konsist.core.provider.KoTextProviderCore
import com.lemonappdev.konsist.core.provider.packagee.KoPackageDeclarationProviderCore
import com.lemonappdev.konsist.core.provider.util.KoLocalDeclarationProviderCoreUtil
import org.jetbrains.kotlin.psi.KtAnnotated
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtEnumEntry
import org.jetbrains.kotlin.psi.KtTypeParameterListOwner

internal class KoEnumConstantDeclarationCore private constructor(
    override val ktEnumEntry: KtEnumEntry,
    override val containingDeclaration: KoContainingDeclarationProvider,
) : KoEnumConstantDeclaration,
    KoBaseProviderCore,
    KoAnnotationProviderCore,
    KoContainingFileProviderCore,
    KoEnumNameProviderCore,
    KoKDocProviderCore,
    KoLocalClassProviderCore,
    KoLocalDeclarationProviderCore,
    KoLocalFunctionProviderCore,
    KoLocationProviderCore,
    KoNameProviderCore,
    KoContainingDeclarationProviderCore,
    KoPathProviderCore,
    KoDeclarationFullyQualifiedNameProviderCore,
    KoPackageDeclarationProviderCore,
    KoResideInPackageProviderCore,
    KoResideInOrOutsidePackageProviderCore,
    KoTextProviderCore {
    override val ktTypeParameterListOwner: KtTypeParameterListOwner by lazy { ktEnumEntry }

    override val ktAnnotated: KtAnnotated by lazy { ktEnumEntry }

    override val psiElement: PsiElement by lazy { ktEnumEntry }

    override val ktElement: KtElement by lazy { ktEnumEntry }

    override val localDeclarations: List<KoBaseDeclaration> by lazy {
        val psiElements = ktEnumEntry
            .body
            ?.children

        KoLocalDeclarationProviderCoreUtil.getKoLocalDeclarations(psiElements, this)
    }

    /*
    1.0.0 CleanUp - Now declaration implements two providers - KoResideInPackageProvider and KoResideInOrOutsidePackageProvider
    (the second one is deprecated) - with the same methods, so we must override this and choose which implementation
    this method should have. After removing deprecated provider in v1.0.0 it will be unnecessary.
     */
    override fun resideInPackage(name: String): Boolean {
        return super<KoResideInPackageProviderCore>.resideInPackage(name)
    }

    /*
    1.0.0 CleanUp - Now declaration implements two providers - KoResideInPackageProvider and KoResideInOrOutsidePackageProvider
    (the second one is deprecated) - with the same methods, so we must override this and choose which implementation
    this method should have. After removing deprecated provider in v1.0.0 it will be unnecessary.
     */
    override fun resideOutsidePackage(name: String): Boolean {
        return super<KoResideInPackageProviderCore>.resideOutsidePackage(name)
    }

    override fun toString(): String = name

    internal companion object {
        private val cache: KoDeclarationCache<KoEnumConstantDeclaration> = KoDeclarationCache()

        internal fun getInstance(
            ktEnumEntry: KtEnumEntry,
            containingDeclaration: KoContainingDeclarationProvider,
        ): KoEnumConstantDeclaration =
            cache.getOrCreateInstance(ktEnumEntry, containingDeclaration) {
                KoEnumConstantDeclarationCore(ktEnumEntry, containingDeclaration)
            }
    }
}