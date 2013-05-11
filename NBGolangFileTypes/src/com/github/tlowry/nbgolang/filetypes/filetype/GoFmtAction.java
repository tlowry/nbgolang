/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.netbeans.api.extexecution.ExecutionDescriptor;
import org.netbeans.api.extexecution.ExecutionService;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Build",
        id = "com.github.tlowry.nbgolang.filetypes.filetype.GoFmtAction")
@ActionRegistration(
        iconBase = "com/github/tlowry/nbgolang/filetypes/filetype/fmt.png",
        displayName = "#CTL_GoFmtAction")
@ActionReferences({
    @ActionReference(path = "Loaders/text/x-go/Actions", position = -200),
    @ActionReference(path = "Editors/text/x-go/Popup", position = 765)
})
@Messages("CTL_GoFmtAction=gofmt")
public final class GoFmtAction implements ActionListener {

    private final List<GolangDataObject> context;

    public GoFmtAction(List<GolangDataObject> context) {
        this.context = context;
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        StringBuilder filesToFmt = new StringBuilder(context.size()*50);
        for (GolangDataObject golangDataObject : context) {
            String path = golangDataObject.getPrimaryFile().getPath();
            filesToFmt.append(path).append(" ");
        }
        try {
            if(execute(filesToFmt.toString()).intValue() == 0){
                System.out.println("Go fmt completed Successfully");
            }
            else{
                System.out.println("Go fmt failed");
            }
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        } catch (ExecutionException ex) {
            Exceptions.printStackTrace(ex);
        }
        
        
    }

    public Integer execute(String filesToFmt) throws InterruptedException, ExecutionException {
        Callable processCallable = new GoFmtCallable(filesToFmt);

        ExecutionDescriptor descriptor = new ExecutionDescriptor().frontWindow(true).controllable(true);

        ExecutionService service = ExecutionService.newService(processCallable,
                descriptor, "");

        Future task = service.run();
        return (Integer) task.get();
    }
}
