/**
 * 
 */
package org.argouml.modules.container;

import java.awt.Frame;

import javax.swing.Action;

import org.argouml.modules.actions.ActionManager;
import org.argouml.modules.context.ModuleContext;
import org.swixml.ConverterLibrary;
import org.swixml.SwingEngine;

/**
 * @author lmaitre
 *
 */
public class AbstractModuleContainer implements ModuleContainer {

    protected ActionManager actionManager;
    
    protected SwingEngine swingEngine;

    protected Frame parentFrame;

    protected ModuleContext context;
    
    protected static ModuleContainer instance;
    
    public static ModuleContainer getInstance() {
        return instance;
    }
    
    /**
     * 
     */
    public AbstractModuleContainer() {
        super();
    }

    protected void initSwingEngine() {
        swingEngine = new SwingEngine( this );
        swingEngine.setClassLoader(this.getClass().getClassLoader());
        //The action manager must be set by the child class instance before init
        ConverterLibrary.getInstance().register(Action.class, actionManager);
        ConverterLibrary.getInstance().register(ModuleColorConverter.TEMPLATE, 
                new ModuleColorConverter());        
    }
    
    /**
     * @see org.argouml.modules.container.ModuleContainer#getActionManager()
     */
    public ActionManager getActionManager() {
        return actionManager;
    }

    /**
     * @see org.argouml.modules.container.ModuleContainer#getSwingEngine()
     */
    public SwingEngine getSwingEngine() {
        return swingEngine;
    }

    /**
     * @see org.argouml.modules.container.ModuleContainer#getParentFrame()
     */
    public Frame getParentFrame() {
        return parentFrame;
    }

    /**
     * @see org.argouml.modules.container.ModuleContainer#getContext()
     */
    public ModuleContext getContext() {
        return context;
    }

    /**
     * @param actionManager The actionManager to set.
     */
    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    /**
     * @param context The context to set.
     */
    public void setContext(ModuleContext context) {
        this.context = context;
    }

    /**
     * @param parentFrame The parentFrame to set.
     */
    public void setParentFrame(Frame parentFrame) {
        this.parentFrame = parentFrame;
    }

    /**
     * @param swingEngine The swingEngine to set.
     */
    public void setSwingEngine(SwingEngine swingEngine) {
        this.swingEngine = swingEngine;
    }

    /**
     * @param key The key to localize
     * @return String localized
     */
    public String localize(String key) {
        return swingEngine.getLocalizer().getString(key);
    }

}
