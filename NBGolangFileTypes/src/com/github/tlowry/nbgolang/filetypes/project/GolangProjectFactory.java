/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.tlowry.nbgolang.filetypes.project;

import java.io.IOException;
import java.util.Enumeration;
import org.netbeans.api.project.Project;
import org.netbeans.spi.project.ProjectFactory;
import org.netbeans.spi.project.ProjectState;
import org.openide.filesystems.FileObject;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author tony.lowry
 */
@ServiceProvider(service = ProjectFactory.class)
//@todo implement pjfactory2 for improved performance
public class GolangProjectFactory implements ProjectFactory {

    @Override
    public boolean isProject(FileObject dir) {
        Enumeration<? extends FileObject> en = dir.getFolders(true);
        boolean src = false, pkg = false, bin = false;
        while (en.hasMoreElements()) {
            FileObject f = (FileObject) en.nextElement();
            if ("src".equals(f.getName())) {
                src = true;
            } else if ("pkg".equals(f.getName())) {
                pkg = true;
            } else if ("bin".equals(f.getName())) {
                bin = true;
            }

            if (src && pkg && bin) {
                return true;
            }
        }
        return false;

    }

    @Override
    public Project loadProject(FileObject dir, ProjectState state) throws IOException {
        return isProject(dir) ? new GolangProject(dir, state) : null;
    }

    @Override
    public void saveProject(Project prjct) throws IOException, ClassCastException {
    }
}
