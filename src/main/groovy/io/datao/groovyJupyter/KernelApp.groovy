package io.datao.groovyJupyter

import io.datao.groovyJupyter.models.JupyterConfig
import io.datao.groovyJupyter.parsers.JupyterConfigParsers

/**
 * Created by robertarnold on 9/20/16.
 */

class KernelApp {
    static void main(String[] args) {
        /*
            The first argument will be the path to the jupyter
            connection file.  This is a json file that we'll parse
            into zeroMq bindings
         */

        def propertiesLocation = args[0]
        def String configString = retrieveFile(propertiesLocation)
        if (configString != "") {
            //Attempt to turn the config file into a configuration object
            JupyterConfig jupyterConfig = JupyterConfigParsers.parseJupyterJson(configString)

        } else {
            System.out.println("Unable to instantiate")
        }

    }

    static String retrieveFile(String fileLocation) {
        String fileContents = ""

        try {
            fileContents = new File(fileLocation).text
        }

        catch (e) {
            if (e instanceof FileNotFoundException) {
                System.out.println("Config file not passed to program, not working")
                fileContents = ""
            } else {
                System.out.println(e.getClass())
                System.out.println(e.getMessage())
            }
        }

        return fileContents

    }

    static void eventLoop() {

    }
}
