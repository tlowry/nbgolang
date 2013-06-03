/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.filetype.actions.callables;

import java.util.Enumeration;
import org.openide.filesystems.FileObject;

/**
 *
 * @author tony
 */
public class RunCallable extends GolangCallable {

    public RunCallable(FileObject projectDir) {
        super(projectDir);
    }

    @Override
    public Object call() throws Exception {
        FileObject binDir = projectDir.getFileObject("/bin");
        Enumeration files = binDir.getChildren(false);
        String binaryFileName = "";
        while(files.hasMoreElements()){
            FileObject f = (FileObject) files.nextElement();
            if(f.getNameExt().endsWith(".exe")){
                binaryFileName = f.getNameExt();
            }
        }
        ProcessBuilder b = new ProcessBuilder(projectDir.getPath() + "/bin/"+binaryFileName);
        return b.start();
    }
}
