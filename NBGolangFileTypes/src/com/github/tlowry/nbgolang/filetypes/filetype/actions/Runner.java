/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions;

import com.github.tlowry.nbgolang.filetypes.filetype.actions.callables.RunCallable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.openide.filesystems.FileObject;
import org.openide.util.Exceptions;

/**
 *
 * @author tony
 */
public class Runner {

    private final FileObject projectDir;

    public Runner(FileObject ProjectDir) {
        this.projectDir = ProjectDir;
    }

    public int run() {
        int result = -1;

        Callable processCallable = new RunCallable(projectDir);
        ExecutionDescriptor descriptor = new ExecutionDescriptor().frontWindow(true).controllable(true);
        ExecutionService service = ExecutionService.newService(processCallable,
                descriptor, "Running ");

        Future task = service.run();

        try {

            result = ((Integer) task.get()).intValue();
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ExecutionException ex) {
            Exceptions.printStackTrace(ex);
        }


        return result;
    }
}
