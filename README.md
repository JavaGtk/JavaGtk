#JavaGtk

##Overview

Java bindings for GTK+ for Windows.  JavaGtk is free software, licensed under the ISC license.

##Usage

1. Checkout and extract the latest GTK bundle.  Currently only 64 bit bundles are available.
2. Checkout the source and build.  You will need to point the gcc compiler and linker to the /include and /lib folders of the extracted GTK bundle.
3. Modify src/main/resources/config.properties and change the GTKLibraryPath property value to point to the /bin folder of the extracted GTK bundle.  
