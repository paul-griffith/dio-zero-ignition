package com.griffithindustries.scripting.diozero.common;

import com.diozero.internal.provider.pigpioj.PigpioJDeviceFactory;
import com.inductiveautomation.ignition.common.BundleUtil;
import com.inductiveautomation.ignition.common.script.PyArgParser;
import com.inductiveautomation.ignition.common.script.builtin.KeywordArgs;
import com.inductiveautomation.ignition.common.script.hints.ScriptFunction;
import org.python.core.PyObject;

@SuppressWarnings("unused")
public class DIOZeroScriptingModule {
    public static final Class<?> LED = com.diozero.devices.LED.class;

    static {
        BundleUtil.get().addBundle(
            DIOZeroScriptingModule.class.getSimpleName(),
            DIOZeroScriptingModule.class.getClassLoader(),
            DIOZeroScriptingModule.class.getName().replace('.', '/'));
    }

    @KeywordArgs(
        names = {"host", "port"},
        types = {String.class, Integer.class}
    )
    @ScriptFunction(docBundlePrefix = "gpio")
    public static PigpioJDeviceFactory factory(PyObject[] args, String[] keywords) {
        PyArgParser argMap = PyArgParser.parseArgs(args, keywords, DIOZeroScriptingModule.class, "factory");
        System.setProperty("PIGPIOD_HOST", argMap.getString("host").orElse("localhost"));
        System.setProperty("PIGPIOD_PORT", argMap.getInteger("port").orElse(8888).toString());
        return new PigpioJDeviceFactory();
    }
}
