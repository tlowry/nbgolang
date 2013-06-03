/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions.callables;

import java.util.concurrent.Callable;
import org.openide.filesystems.FileObject;

/**
 *
 * @author tony
 */
public abstract class GolangCallable implements Callable<Object> {

    protected final FileObject projectDir;

    public GolangCallable(FileObject projectDir) {
        this.projectDir = projectDir;

    }
}
