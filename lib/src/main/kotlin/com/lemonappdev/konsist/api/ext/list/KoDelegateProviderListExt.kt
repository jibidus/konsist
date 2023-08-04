package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.provider.KoDelegateProvider

/**
 * List containing elements with delegate with given name.
 *
 * @param names The delegate names to include.
 * @return A list containing elements with the specified delegate name(s) (or any delegate if [names] is empty).
 */
fun <T : KoDelegateProvider> List<T>.withDelegate(vararg names: String): List<T> = filter {
    when {
        names.isEmpty() -> it.hasDelegate()
        else -> names.any { name -> it.hasDelegate(name) }
    }
}

/**
 * List containing elements without delegate with given name.
 *
 * @param names The delegate names to exclude.
 * @return A list containing elements without the specified delegate name(s) (or none delegate if [names] is empty).
 */
fun <T : KoDelegateProvider> List<T>.withoutDelegate(vararg names: String): List<T> = filter {
    when {
        names.isEmpty() -> !it.hasDelegate()
        else -> names.none { name -> it.hasDelegate(name) }
    }
}
