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
package org.talend.designer.core.ui.editor.properties;

import org.eclipse.gef.EditPart;
import org.eclipse.ui.views.properties.tabbed.ITypeMapper;

/**
 * Type of mapper returned by this function. It will select a basic EditPart. <br/>
 * 
 * $Id$
 * 
 */
public class GefEditorTypeMapper implements ITypeMapper {

    /**
     * @inheritDoc
     */
    public Class mapType(Object object) {
        Class type = object.getClass();
        if (object instanceof EditPart) {
            type = ((EditPart) object).getModel().getClass();
        }
        return type;
    }
}
