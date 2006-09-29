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
package org.talend.designer.core.ui.editor.cmd;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.designer.core.i18n.Messages;
import org.talend.designer.core.model.components.EParameterName;
import org.talend.designer.core.ui.editor.nodes.NodeLabel;

/**
 * Command that change the label of a node. <br/>
 * 
 * $Id$
 * 
 */
public class ChangeNodeTextCommand extends Command {

    private String newName;

    private String oldName;

    private NodeLabel nodeLabel;

    /**
     * Initialisation of the command with the label of the node and the new text.
     * 
     * @param nodeLabel Gef object that contains the label of the node.
     * @param newName new name of the node label
     */
    public ChangeNodeTextCommand(NodeLabel nodeLabel, String newName) {
        if (newName != null) {
            this.newName = newName;
        } else {
            this.newName = ""; //$NON-NLS-1$
        }
        this.nodeLabel = nodeLabel;
        setLabel(Messages.getString("ChangeNodeTextCommand.1")); //$NON-NLS-1$
    }

    private void refreshPropertyView() {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart view = page.findView("org.eclipse.ui.views.PropertySheet");
        PropertySheet sheet = (PropertySheet) view;
        TabbedPropertySheetPage tabbedPropertySheetPage = (TabbedPropertySheetPage) sheet.getCurrentPage();
        tabbedPropertySheetPage.refresh();
    }

    public void execute() {
        oldName = (String) nodeLabel.getPropertyValue(EParameterName.LABEL.getName());
        nodeLabel.setLabelText(newName);
        nodeLabel.setPropertyValue(EParameterName.LABEL.getName(), newName);
        // labelName = (String) nodeLabel.getPropertyValue(EParameterName.LABEL.getName());
        // nodeLabel.setPropertyValue(EParameterName.LABEL.getName(), Node.DEFAULT_LABEL);
        refreshPropertyView();
    }

    public void redo() {
        execute();
    }

    public void undo() {
        nodeLabel.setLabelText(oldName);
        nodeLabel.setPropertyValue(EParameterName.LABEL.getName(), oldName);
        nodeLabel.setPropertyValue(EParameterName.LABEL.getName(), newName);
        refreshPropertyView();
    }
}
