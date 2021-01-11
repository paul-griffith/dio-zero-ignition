package com.griffithindustries.scripting.diozero.common;

import com.diozero.internal.provider.pigpioj.PigpioJDeviceFactory;
import com.inductiveautomation.ignition.common.script.PyArgParser;
import com.inductiveautomation.ignition.common.script.builtin.KeywordArgs;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;
import org.python.core.PyObject;

public class DIOZeroScriptingModule {
    public static final Class<?> LED = com.diozero.devices.LED.class;

    @KeywordArgs(
        names = {"host", "port"},
        types = {String.class, Integer.class}
    )
    @ScriptFunction(docBundlePrefix = "diozero")
    public static PigpioJDeviceFactory factory(PyObject[] args, String[] keywords) {
        PyArgParser argMap = PyArgParser.parseArgs(args, keywords, DIOZeroScriptingModule.class, "factory");
        System.setProperty("PIGPIOD_HOST", argMap.getString("host").orElse("localhost"));
        System.setProperty("PIGPIOD_PORT", argMap.getInteger("port").orElse(8888).toString());
        return new PigpioJDeviceFactory();
    }
}
