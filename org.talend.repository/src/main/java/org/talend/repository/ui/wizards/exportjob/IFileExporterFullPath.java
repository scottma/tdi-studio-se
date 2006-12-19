// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend - www.talend.com
//
// This library is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 2.1 of the License, or (at your option) any later version.
//
// This library is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program; if not, write to the Free Software
// Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
//
// ============================================================================
package org.talend.repository.ui.wizards.exportjob;


import java.io.IOException;

import org.eclipse.core.runtime.CoreException;

/**
 * Interface for file exporters of different file formats.  Used by the
 * zip and tar.gz exporters.
 * 
 * @since 3.1
 */
public interface IFileExporterFullPath {

    /**
     * Do all required cleanup now that we are finished with the
     * currently-open file.
     * 
     * @throws IOException
     */
    public void finished() throws IOException;
    
    /**
     * Write the passed resource to the current archive
     * 
     * @param resource
     * @param destinationPath
     * @throws IOException
     * @throws CoreException
     */
    public void write(String resource, String destinationPath)
        throws IOException, CoreException;

}