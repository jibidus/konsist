package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.provider.KoPrimaryConstructorProvider

/**
 * List containing elements that have primary constructor.
 *
 * @return A list containing elements with primary constructor.
 */
fun <T : KoPrimaryConstructorProvider> List<T>.withPrimaryConstructor(): List<T> = filter { it.hasPrimaryConstructor }

/**
 * List containing elements that don't have primary constructor.
 *
 * @return A list containing elements without primary constructor.
 */
fun <T : KoPrimaryConstructorProvider> List<T>.withoutPrimaryConstructor(): List<T> = filterNot { it.hasPrimaryConstructor }