package com.griffithindustries.scripting.diozero.designer;

import com.diozero.internal.provider.pigpioj.PigpioJDeviceFactory;
import com.griffithindustries.scripting.diozero.common.DIOZeroScriptingModule;
import com.inductiveautomation.ignition.common.licensing.LicenseState;
import com.inductiveautomation.ignition.common.script.ScriptManager;
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook;
import com.inductiveautomation.ignition.designer.model.DesignerContext;


/**
 * This is the Designer-scope module hook.  The minimal implementation contains a startup method.
 */
public class DIOZeroDesignerHook extends AbstractDesignerModuleHook {
    @Override
    public void shutdown() {
        new PigpioJDeviceFactory().shutdown();
    }

    @Override
    public void initializeScriptManager(ScriptManager manager) {
        manager.addScriptModule("system.gpio", DIOZeroScriptingModule.class);
    }
}
