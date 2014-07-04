# groowin-gradle

## Overview

The `groowin-gradle` is a **Gradle** plugin for working with remote **WinRM** (Windows) servers. It allows connecting, executing 
remote commands, coping files and directories in a simple and concise way.

The plugin was jointly developed by **Aestas/IT** (http://aestasit.com) and **NetCompany A/S** (http://www.netcompany.com/) 
to support quickly growing operations and hosting department.

### Quick example

This is a simple example of some **WinRM** features available in the plugin:

    task remoteTask << {
      remoteManagement {
        exec 'rm -rf /tmp/cache/'
        cp "$buildDir/cache.content", '/tmp/cache/cache.content'        
      }
    }

### Adding plugin to the build

The first thing you need to do in order to use the plugin is to define a build script dependency:

    buildscript {
      repositories { mavenCentral() }
      dependencies {
        classpath 'com.aestasit.infrastructure.groowin:groowin-gradle:0.1.2'
      }
    }

And then apply the plugin:
    
    apply plugin: 'remoteManagement'

Plugin can be configured with the help of `winrmOptions` structure:

    winrmOptions {
      ...
    }

It also gives access to a set of methods (`remoteManagment`, `exec`, `cp` etc.) defined by **Groowin** - **Groovy WinRM DSL**. 

For documentation on **WinRM DSL**, please, refer to https://github.com/aestasit/groowin.
 

