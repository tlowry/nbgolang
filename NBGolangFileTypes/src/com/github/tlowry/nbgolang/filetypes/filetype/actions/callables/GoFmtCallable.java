/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions.callables;

import java.util.concurrent.Callable;

/**
 *
 * @author tony
 */
public class GoFmtCallable implements Callable<Object>{
    private final String filePaths;
    
    public GoFmtCallable(String spacedFilePaths){
        this.filePaths = spacedFilePaths;
    }

    @Override
    public Object call() throws Exception {
        return new ProcessBuilder("gofmt", "-w", filePaths).start();
    }
    
}
