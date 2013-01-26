#JavaGtk

##Overview

Java bindings for GTK+ for Windows.  JavaGtk is free software, licensed under the ISC license.

##Usage

* Checkout and extract the latest GTK bundle.  Currently only 64 bit bundles are available.
* Checkout the source and build.  
  * Build the java portion first
  * Execute the build_jni.bat file.  You may need to modify the JAVA_HOME variable first.
  * Build the c portion next.  You will need to point the gcc compiler and linker to the /include and /lib folders of the extracted GTK bundle.
* Modify src/main/resources/config.properties and change the GTKLibraryPath property value to point to the /bin folder of the extracted GTK bundle.  
