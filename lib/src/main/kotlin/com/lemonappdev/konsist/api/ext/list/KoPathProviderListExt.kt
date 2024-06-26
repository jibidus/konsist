package com.lemonappdev.konsist.api.ext.list

import com.lemonappdev.konsist.api.provider.KoPathProvider

/**
 * List containing declarations with path.
 *
 * @param path The path to include.
 * @param paths The paths to include.
 * @param absolutePath Determines whether the paths should be treated as absolute paths. By default, false.
 * @return A list containing declarations that reside in any of the specified paths.
 */
fun <T : KoPathProvider> List<T>.withPath(
    path: String,
    vararg paths: String,
    absolutePath: Boolean = false,
): List<T> = withPath(listOf(path, *paths), absolutePath)

/**
 * List containing declarations with path.
 *
 * @param paths The paths to include.
 * @param absolutePath Determines whether the paths should be treated as absolute paths. By default, false.
 * @return A list containing declarations that reside in any of the specified paths.
 */
fun <T : KoPathProvider> List<T>.withPath(
    paths: Collection<String>,
    absolutePath: Boolean = false,
): List<T> =
    filter {
        when {
            paths.isEmpty() -> true
            else -> paths.any { path -> it.resideInPath(path, absolutePath) }
        }
    }

/**
 * List containing declarations without path.
 *
 * @param path The path to exclude.
 * @param paths The paths to exclude.
 * @param absolutePath Determines whether the paths should be treated as absolute paths. By default, false.
 * @return A list containing declarations that don't reside in any of the specified paths.
 */
fun <T : KoPathProvider> List<T>.withoutPath(
    path: String,
    vararg paths: String,
    absolutePath: Boolean = false,
): List<T> = withoutPath(listOf(path, *paths), absolutePath)

/**
 * List containing declarations without path.
 *
 * @param paths The paths to exclude.
 * @param absolutePath Determines whether the paths should be treated as absolute paths. By default, false.
 * @return A list containing declarations that don't reside in any of the specified paths.
 */
fun <T : KoPathProvider> List<T>.withoutPath(
    paths: Collection<String>,
    absolutePath: Boolean = false,
): List<T> =
    filter {
        when {
            paths.isEmpty() -> false
            else -> paths.none { path -> it.resideInPath(path, absolutePath) }
        }
    }

/**
 * List containing declarations with absolute path.
 *
 * @param path The absolute path to include.
 * @param paths The absolute paths to include.
 * @return A list containing declarations that reside in any of the specified absolute paths.
 */
fun <T : KoPathProvider> List<T>.withAbsolutePath(
    path: String,
    vararg paths: String,
): List<T> = withAbsolutePath(listOf(path, *paths))

/**
 * List containing declarations with absolute path.
 *
 * @param paths The absolute paths to include.
 * @return A list containing declarations that reside in any of the specified absolute paths.
 */
fun <T : KoPathProvider> List<T>.withAbsolutePath(paths: Collection<String>): List<T> = withPath(paths, absolutePath = true)

/**
 * List containing declarations with absolute path.
 *
 * @param paths The absolute paths to include.
 * @return A list containing declarations that reside in any of the specified absolute paths.
 */
fun <T : KoPathProvider> List<T>.withAbsolutePath(paths: List<String>): List<T> = withPath(paths, absolutePath = true)

/**
 * List containing declarations without absolute path.
 *
 * @param path The absolute path to exclude.
 * @param paths The absolute paths to exclude.
 * @return A list containing declarations that don't reside in any of the specified absolute paths.
 */
fun <T : KoPathProvider> List<T>.withoutAbsolutePath(
    path: String,
    vararg paths: String,
): List<T> = withoutAbsolutePath(listOf(path, *paths))

/**
 * List containing declarations without absolute path.
 *
 * @param paths The absolute paths to exclude.
 * @return A list containing declarations that don't reside in any of the specified absolute paths.
 */
fun <T : KoPathProvider> List<T>.withoutAbsolutePath(paths: Collection<String>): List<T> = withoutPath(paths, absolutePath = true)

/**
 * List containing declarations without absolute path.
 *
 * @param paths The absolute paths to exclude.
 * @return A list containing declarations that don't reside in any of the specified absolute paths.
 */
fun <T : KoPathProvider> List<T>.withoutAbsolutePath(paths: List<String>): List<T> = withoutPath(paths, absolutePath = true)

/**
 * List containing declarations with project path.
 *
 * @param path The project path to include.
 * @param paths The project paths to include.
 * @return A list containing declarations that reside in any of the specified project paths.
 */
fun <T : KoPathProvider> List<T>.withProjectPath(
    path: String,
    vararg paths: String,
): List<T> = withProjectPath(listOf(path, *paths))

/**
 * List containing declarations with project path.
 *
 * @param paths The project paths to include.
 * @return A list containing declarations that reside in any of the specified project paths.
 */
fun <T : KoPathProvider> List<T>.withProjectPath(paths: Collection<String>): List<T> = withPath(paths, absolutePath = false)

/**
 * List containing declarations with project path.
 *
 * @param paths The project paths to include.
 * @return A list containing declarations that reside in any of the specified project paths.
 */
fun <T : KoPathProvider> List<T>.withProjectPath(paths: List<String>): List<T> = withPath(paths, absolutePath = false)

/**
 * List containing declarations without project path.
 *
 * @param path The project path to exclude.
 * @param paths The project paths to exclude.
 * @return A list containing declarations that don't reside in any of the specified project paths.
 */
fun <T : KoPathProvider> List<T>.withoutProjectPath(
    path: String,
    vararg paths: String,
): List<T> = withoutProjectPath(listOf(path, *paths))

/**
 * List containing declarations without project path.
 *
 * @param paths The project paths to exclude.
 * @return A list containing declarations that don't reside in any of the specified project paths.
 */
fun <T : KoPathProvider> List<T>.withoutProjectPath(paths: Collection<String>): List<T> = withoutPath(paths, absolutePath = false)

/**
 * List containing declarations without project path.
 *
 * @param paths The project paths to exclude.
 * @return A list containing declarations that don't reside in any of the specified project paths.
 */
fun <T : KoPathProvider> List<T>.withoutProjectPath(paths: List<String>): List<T> = withoutPath(paths, absolutePath = false)
