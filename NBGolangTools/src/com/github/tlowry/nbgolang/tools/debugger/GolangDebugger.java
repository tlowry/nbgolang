/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.tools.debugger;

import java.util.Set;
import org.netbeans.api.debugger.DebuggerInfo;
import org.netbeans.api.debugger.DebuggerManager;
import org.netbeans.spi.debugger.ActionsProviderSupport;
import org.netbeans.spi.debugger.SessionProvider;

/**
 *
 * @author tony
 */
public class GolangDebugger extends ActionsProviderSupport {
    public static final String GOLANG_SESSION = "GolangSession";
    private String GOLANG_DEBUGGER_INFO = "Golang Debugger info";
    
    public void startDebugger() {
                DebuggerManager manager = DebuggerManager.getDebuggerManager();
        DebuggerInfo info = DebuggerInfo.create(GOLANG_DEBUGGER_INFO = "Golang Debugger info",
                new Object[]{
                    new SessionProvider() {
                    ;

                        @Override
                        public String getSessionName() {
                            return "Golang Program";
                        }

                        @Override
                        public String getLocationName() {
                            return "localhost";
                        }

                        public String getTypeID() {
                            return GOLANG_SESSION;
                        }

                        public Object[] getServices() {
                            return new Object[]{};
                        }
                    }, null
                });

        manager.startDebugging(info);
    }

    @Override
    public void doAction(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set getActions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
