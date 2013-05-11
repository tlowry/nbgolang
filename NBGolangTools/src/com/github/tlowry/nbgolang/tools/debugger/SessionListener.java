/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.tools.debugger;

import org.netbeans.api.debugger.DebuggerManagerAdapter;
import org.netbeans.api.debugger.Session;

/**
 *
 * @author tony
 */
public class SessionListener extends DebuggerManagerAdapter {
    
    @Override
    public void sessionAdded(Session session) {
        super.sessionAdded(session);
    }
    
    @Override
    public void sessionRemoved(Session session) {
        super.sessionRemoved(session);
    }
}
