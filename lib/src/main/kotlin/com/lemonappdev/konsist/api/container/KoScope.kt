package com.lemonappdev.konsist.api.container

import com.lemonappdev.konsist.api.declaration.KoAnnotationDeclaration
import com.lemonappdev.konsist.api.declaration.KoBaseDeclaration
import com.lemonappdev.konsist.api.declaration.KoClassDeclaration
import com.lemonappdev.konsist.api.declaration.KoFileDeclaration
import com.lemonappdev.konsist.api.declaration.KoFunctionDeclaration
import com.lemonappdev.konsist.api.declaration.KoImportDeclaration
import com.lemonappdev.konsist.api.declaration.KoInterfaceDeclaration
import com.lemonappdev.konsist.api.declaration.KoObjectDeclaration
import com.lemonappdev.konsist.api.declaration.KoPackageDeclaration
import com.lemonappdev.konsist.api.declaration.KoPropertyDeclaration
import com.lemonappdev.konsist.api.declaration.KoTypeAliasDeclaration

/**
 * Represents a scope of Kotlin declarations.
 */
@Suppress("detekt.TooManyFunctions")
interface KoScope {
    /**
     * The files present in the scope.
     */
    val files: List<KoFileDeclaration>

    /**
     * The imports present in the scope.
     */
    val imports: List<KoImportDeclaration>

    /**
     * The annotations present in the scope.
     */
    val annotations: List<KoAnnotationDeclaration>

    /**
     * The packages present in the scope.
     */
    val packages: List<KoPackageDeclaration>

    /**
     * The type aliases present in the scope.
     */
    val typeAliases: List<KoTypeAliasDeclaration>

    /**
     * The classes present in the scope.
     *
     * @param includeNested specifies whether to include nested classes, by default `false`.
     * @param includeLocal specifies whether to include local classes, by default `false`.
     * @return a list of [KoClassDeclaration] representing the classes in the scope.
     */
    fun classes(
        includeNested: Boolean = false,
        includeLocal: Boolean = false,
    ): List<KoClassDeclaration>

    /**
     * The interfaces present in the scope.
     *
     * @param includeNested specifies whether to include nested interfaces, by default `false`.
     * @return a list of [KoInterfaceDeclaration] representing the interfaces in the scope.
     */
    fun interfaces(
        includeNested: Boolean = false,
    ): List<KoInterfaceDeclaration>

    /**
     * The objects present in the scope.
     *
     * @param includeNested specifies whether to include nested objects, by default `false`.
     * @return a list of [KoObjectDeclaration] representing the objects in the scope.
     */
    fun objects(
        includeNested: Boolean = false,
    ): List<KoObjectDeclaration>

    /**
     * The functions present in the scope.
     *
     * @param includeNested specifies whether to include nested functions, by default `false`.
     * @param includeLocal specifies whether to include local functions, by default `false`.
     * @return a list of [KoFunctionDeclaration] representing the functions in the scope.
     */
    fun functions(
        includeNested: Boolean = false,
        includeLocal: Boolean = false,
    ): List<KoFunctionDeclaration>

    /**
     * The declarations present in the scope.
     *
     * @param includeNested specifies whether to include nested declarations, by default `false`.
     * @param includeLocal specifies whether to include local declarations, by default `false`.
     * @return a list of [KoBaseDeclaration] representing the declarations in the scope.
     */
    fun declarations(
        includeNested: Boolean = false,
        includeLocal: Boolean = false,
    ): List<KoBaseDeclaration>

    /**
     * The properties present in the scope.
     *
     * @param includeNested specifies whether to include nested properties, by default `false`.
     * @param includeLocal specifies whether to include local properties, by default `false`.
     * @return a list of [KoPropertyDeclaration] representing the properties in the scope.
     */
    fun properties(
        includeNested: Boolean = false,
        includeLocal: Boolean = false,
    ): List<KoPropertyDeclaration>

    /**
     * The scope with given predicate.
     *
     * @param predicate the predicate function to filter file declarations.
     * @return a new [KoScope] containing the file declarations that satisfy the predicate.
     */
    fun slice(predicate: (KoFileDeclaration) -> Boolean): KoScope

    /**
     * Add a scope files to this scope.
     *
     * @param scope the scope to be added.
     * @return a new [KoScope] containing the combined file declarations from this scope and the specified scope.
     */
    operator fun plus(scope: KoScope): KoScope

    /**
     * Subtract scope files from this scope.
     *
     * @param scope the scope to be subtracted.
     * @return a new [KoScope] containing the file declarations from this scope excluding the file declarations in the specified scope.
     */
    operator fun minus(scope: KoScope): KoScope

    /**
     * Add a scope files and create a new scope.
     *
     * @param scope the scope to be added.
     */
    operator fun plusAssign(scope: KoScope): Unit

    /**
     * Subtract a scope files and create a new scope.
     *
     * @param scope the scope to be subtracted.
     */
    operator fun minusAssign(scope: KoScope): Unit

    /**
     * String representing the scope.
     *
     * @return a string representing the scope.
     */
    override fun toString(): String

    /**
     * Print the scope.
     */
    fun print(): Unit

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param other the object to compare.
     * @return `true` if the objects are equal, `false` otherwise.
     */
    override fun equals(other: Any?): Boolean

    /**
     * Returns a hash code value for the object.
     *
     * @return the hash code value.
     */
    override fun hashCode(): Int
}