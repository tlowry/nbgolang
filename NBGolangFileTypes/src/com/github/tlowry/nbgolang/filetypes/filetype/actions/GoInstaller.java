/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions;

import com.github.tlowry.nbgolang.filetypes.filetype.actions.callables.GoInstallCallable;
import java.util.List;
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
public class GoInstaller {

    private final FileObject projectDir;

    public GoInstaller(FileObject ProjectDir) {
        this.projectDir = ProjectDir;
    }

    public int install(List<String> packageNames) {
        int result = 0;
        for (String pkg : packageNames) {
            Callable processCallable = new GoInstallCallable(projectDir, pkg);
            ExecutionDescriptor descriptor = new ExecutionDescriptor().frontWindow(true).controllable(true).showProgress(true);
            ExecutionService service = ExecutionService.newService(processCallable,
                    descriptor, "Go Install "+pkg);
            Future task = service.run();
            try {
                result = ((Integer) task.get()).intValue();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            } catch (ExecutionException ex) {
                Exceptions.printStackTrace(ex);
            }

        }

        return result;
    }
}
