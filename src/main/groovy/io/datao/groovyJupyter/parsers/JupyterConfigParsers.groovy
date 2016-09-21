package io.datao.groovyJupyter.parsers

import groovy.json.JsonParser
import io.datao.groovyJupyter.models.JupyterConfig
import groovy.json.JsonSlurper

/**
 * Created by robertarnold on 9/20/16.
 */
class JupyterConfigParsers {

    static JupyterConfig parseJupyterJson(String configJson) {

        JupyterConfig jupyterConfig = new JupyterConfig()
        JsonSlurper jsonSlurper = new JsonSlurper()
        def configObject = jsonSlurper.parseText(configJson)

        if (configObject instanceof Map) {
            jupyterConfig.setControlPort(configObject.get("control_port").toString())
            jupyterConfig.setHbPort(configObject.get("hb_port").toString())
            jupyterConfig.setIopubPort(configObject.get("iopub_port").toString())
            jupyterConfig.setIp(configObject.get("ip").toString())
            jupyterConfig.setKey(configObject.get("config_object").toString())
            jupyterConfig.setShellPort(configObject.get("shell_port").toString())
            jupyterConfig.setSignatureScheme(configObject.get("signature_scheme").toString())
            jupyterConfig.setStdinPort(configObject.get("stdin_port").toString())
            jupyterConfig.setTransport(configObject.get("transport").toString())
        }

        return jupyterConfig
    }
}
