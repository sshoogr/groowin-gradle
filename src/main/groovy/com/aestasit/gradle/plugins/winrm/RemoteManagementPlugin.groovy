/*
 * Copyright (C) 2011-2014 Aestas/IT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.aestasit.gradle.plugins.winrm

import com.aestasit.winrm.dsl.WinRMDslEngine
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Gradle plug-in that injects WinRM functionality into the build script.
 * 
 * @author Aestas/IT
 *
 */
public class RemoteManagementPlugin implements Plugin<Project> {

  void apply(Project project) {
    project.extensions.create("winrmOptions", RemoteManagementPluginSettings)
    project.winrmOptions.logger = new GradleLogger(project, false)
    injectWinRMDslSupport(project)
  }

  void injectWinRMDslSupport(Project project) {
    WinRMDslEngine dslEngine = new WinRMDslEngine(project.winrmOptions)
    project.metaClass.with {
      remoteManagement << { Closure cl ->
        setLogLevel(project)
        dslEngine.remoteManagement(cl)
      }
      remoteManagement << { String url, Closure cl ->
        setLogLevel(project)
        dslEngine.remoteManagement(url, cl)
      }
    }
  }

  static void setLogLevel(Project project) {
    if (project?.winrmOptions?.logger instanceof GradleLogger) {
      ((GradleLogger) project.winrmOptions.logger).verbose = project.winrmOptions.verbose
    }
  }


}
