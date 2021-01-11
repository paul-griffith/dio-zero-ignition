package com.griffithindustries.scripting.diozero.client;

import com.diozero.internal.provider.pigpioj.PigpioJDeviceFactory;
import com.griffithindustries.scripting.diozero.common.DIOZeroScriptingModule;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.vision.api.client.AbstractClientModuleHook;

/**
 * Client Hook for projects which target Vision
 *
 * @since <DATE>
 */
public class DIOZeroClientHook extends AbstractClientModuleHook {
    @Override
    public void shutdown() {
        new PigpioJDeviceFactory().shutdown();
    }

    @Override
    public void initializeScriptManager(ScriptManager manager) {
        manager.addScriptModule("system.gpio", DIOZeroScriptingModule.class);
    }
}
