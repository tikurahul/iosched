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

import android.content.Intent
import androidx.benchmark.macro.ExperimentalBaselineProfilesApi
import androidx.benchmark.macro.junit4.BaselineProfileRule
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalBaselineProfilesApi::class)
class BaselineProfileTest {

    @get:Rule
    val baselineProfileRule = BaselineProfileRule()

    @Test
    fun baselineProfile() {
        baselineProfileRule.collectBaselineProfile(packageName = PACKAGE_NAME) {
            val intent = Intent()
            intent.setPackage(PACKAGE_NAME)
            intent.action = "com.google.samples.apps.iosched.STARTUP_ACTIVITY"
            startActivityAndWait(intent)
            device.waitForIdle()
        }
    }

    companion object {
        const val PACKAGE_NAME = "com.google.samples.apps.iosched"
    }
}
