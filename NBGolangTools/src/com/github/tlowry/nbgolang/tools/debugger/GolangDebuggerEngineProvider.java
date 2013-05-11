/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.tools.debugger;

import org.netbeans.api.debugger.DebuggerEngine;
import org.netbeans.spi.debugger.DebuggerEngineProvider;

/**
 *
 * @author tony
 */
public class GolangDebuggerEngineProvider extends DebuggerEngineProvider {

    private DebuggerEngine.Destructor destructor;

    @Override
    public String[] getLanguages() {
        return new String[]{"Golang"};
    }

    @Override
    public String getEngineTypeID() {
        return "DebuggerEngine";
    }

    @Override
    public Object[] getServices() {
        return new Object[]{};
    }

    @Override
    public void setDestructor(DebuggerEngine.Destructor d) {
        this.destructor = d;
    }

    public DebuggerEngine.Destructor getDestructor() {
        return this.destructor;
    }
}
