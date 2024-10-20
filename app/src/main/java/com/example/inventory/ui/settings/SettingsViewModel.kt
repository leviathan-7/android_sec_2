/*
 * Copyright (C) 2023 The Android Open Source Project
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

package com.example.inventory.ui.settings

import androidx.lifecycle.ViewModel
import com.example.inventory.data.SettingsRepo


class SettingsViewModel() : ViewModel() {
    private val repo = SettingsRepo()

    fun isNoData(): Boolean {
        return repo.isNoData()
    }

    fun switchNoData() {
        repo.switchNoData()
    }

    fun isNoShare(): Boolean {
        return repo.isNoShare()
    }

    fun switchNoShare() {
        repo.switchNoShare()
    }

    fun isDefolt(): Boolean {
        return repo.isDefolt()
    }

    fun defolt(): Int {
        return repo.defolt()
    }

    fun switchDefolt() {
        repo.switchDefolt()
    }

    fun newDefolt(it: String) {
        if (it.toIntOrNull() != null && it.toInt() > 0)
            repo.newDefolt(it)
    }


}
