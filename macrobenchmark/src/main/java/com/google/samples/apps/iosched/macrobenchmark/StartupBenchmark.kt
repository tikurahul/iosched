/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.iosched.macrobenchmark

import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@LargeTest
@RunWith(Parameterized::class)
class StartupBenchmark(private val startupMode: StartupMode) {
    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

//    @Test
//    fun startup() = benchmarkRule.measureStartup(
//        profileCompiled = false,
//        startupMode = startupMode,
//        iterations = 3
//    ) {
//        action = "com.google.samples.apps.iosched.STARTUP_ACTIVITY"
//    }

    @Test
    fun startupBaselineProfiles() = benchmarkRule.measureStartup(
        profileCompiled = true,
        startupMode = startupMode,
        iterations = 3
    ) {
        action = "com.google.samples.apps.iosched.STARTUP_ACTIVITY"
    }

    companion object {
        @Parameterized.Parameters(name = "mode={0}")
        @JvmStatic
        fun parameters(): List<Array<Any>> {
            return listOf(StartupMode.COLD)
                .map { arrayOf(it) }
        }
    }
}
