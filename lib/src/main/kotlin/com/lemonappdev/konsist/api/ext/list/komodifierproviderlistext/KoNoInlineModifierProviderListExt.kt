package com.lemonappdev.konsist.api.ext.list.komodifierproviderlistext

import com.lemonappdev.konsist.api.provider.komodifierprovider.KoNoInlineModifierProvider

/**
 * List containing all declarations with `noinline` modifier.
 *
 * @return A list containing declarations with the `noinline` modifier.
 */
fun <T : KoNoInlineModifierProvider> List<T>.withNoInlineModifier(): List<T> = filter { it.hasNoInlineModifier }

/**
 * List containing all declarations without `noinline` modifier.
 *
 * @return A list containing declarations without the `noinline` modifier.
 */
fun <T : KoNoInlineModifierProvider> List<T>.withoutNoInlineModifier(): List<T> = filterNot { it.hasNoInlineModifier }
