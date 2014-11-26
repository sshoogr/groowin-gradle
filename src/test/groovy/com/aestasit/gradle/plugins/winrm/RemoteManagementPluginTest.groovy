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

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.BeforeClass
import org.junit.Test

/**
 * 
 * Test for remote management plugin.
 * 
 * @author Aestas/IT
 *
 */
class RemoteManagementPluginTest {

  static Project project

  @BeforeClass
  def static void buildProject() {
    project = ProjectBuilder.builder().build()
    project.with {
      apply plugin: 'remoteManagement'
    }
  }

  @Test
  public void testSetup() {
    assert project != null
  }
  
}
