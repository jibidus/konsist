package com.lemonappdev.konsist.api.ext.list.komodifierproviderlistext

import com.lemonappdev.konsist.api.provider.komodifierprovider.KoVarModifierProvider

/**
 * List containing declarations with `var` modifier.
 *
 * @return A list containing declarations with the `var` modifier.
 */
fun <T : KoVarModifierProvider> List<T>.withVarModifier(): List<T> = filter { it.hasVarModifier }

/**
 * List containing declarations without `var` modifier.
 *
 * @return A list containing declarations without the `var` modifier.
 */
fun <T : KoVarModifierProvider> List<T>.withoutVarModifier(): List<T> = filterNot { it.hasVarModifier }
