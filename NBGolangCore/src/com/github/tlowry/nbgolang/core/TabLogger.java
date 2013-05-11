/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.core;

import org.openide.windows.IOProvider;
import org.openide.windows.InputOutput;

/**
 *
 * @author tony
 */
public class TabLogger {
    private final InputOutput io;
    private final String name;
    
    private TabLogger(String name){
        this.name = name;
        this.io = IOProvider.getDefault().getIO (this.name, true);
    }
    
    public void info(String content){
        io.getOut().println(this.name+": "+content);
    }
    
    public void err(String content){
        io.getErr().println(this.name+": "+content);
    }
    
    public static TabLogger getLogger(String name){
        return new TabLogger(name);
    } 
}
