package com.lemonappdev.konsist.core.architecture

import com.lemonappdev.konsist.api.architecture.DependencyRules
import com.lemonappdev.konsist.api.container.koscope.KoScope

internal data class KoArchitectureScope(val koArchitecture: DependencyRules, val koScope: KoScope)
