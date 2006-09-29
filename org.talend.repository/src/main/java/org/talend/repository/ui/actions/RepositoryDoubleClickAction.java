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
package org.talend.repository.ui.actions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.ui.swt.actions.ITreeContextualAction;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.RepositoryNode.ENodeType;
import org.talend.repository.model.RepositoryNode.EProperties;
import org.talend.repository.ui.views.IRepositoryView;

/**
 * DOC smallet class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class RepositoryDoubleClickAction extends Action {

    private List<ITreeContextualAction> contextualsActions = new ArrayList<ITreeContextualAction>();

    private IRepositoryView view;

    public RepositoryDoubleClickAction(IRepositoryView view, List<ITreeContextualAction> contextualsActionsList) {
        super();
        this.view = view;
        for (ITreeContextualAction current : contextualsActionsList) {
            if (current.isDoubleClickAction()) {
                contextualsActions.add(current);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.action.Action#run()
     */
    @Override
    public void run() {
        ISelection selection = getSelection();
        if (selection == null) {
            return;
        }

        Object obj = ((IStructuredSelection) selection).getFirstElement();
        if (obj == null) {
            return;
        }

        RepositoryNode node = (RepositoryNode) obj;

        if (node.getType() == ENodeType.SIMPLE_FOLDER || node.getType() == ENodeType.STABLE_SYSTEM_FOLDER
                || node.getType() == ENodeType.SYSTEM_FOLDER) {
            view.expand(node);
            view.refresh();
        } else {
            ITreeContextualAction actionToRun = getAction(node);
            if (!(actionToRun == null)) {
                actionToRun.init((TreeViewer) getViewPart().getViewer(), (IStructuredSelection) selection);
                actionToRun.run();
            }
        }
    }

    private ITreeContextualAction getAction(RepositoryNode obj) {
        for (ITreeContextualAction current : contextualsActions) {

            ERepositoryObjectType nodeType = (ERepositoryObjectType) obj.getProperties(EProperties.CONTENT_TYPE);
            if (nodeType.equals(ERepositoryObjectType.METADATA_CON_TABLE)) {
                if (current.getClassForDoubleClick().equals(IMetadataTable.class)) {
                    return current;
                }
            } else if (current.getClassForDoubleClick().isInstance(obj.getObject().getProperty().getItem())) {
                return current;
            }
        }
        return null;
    }

    protected ISelection getSelection() {
        return getViewPart().getViewer().getSelection();
    }

    protected IRepositoryView getViewPart() {
        IViewPart viewPart = (IViewPart) getActivePage().getActivePart();
        return (IRepositoryView) viewPart;
    }

    protected IWorkbenchPage getActivePage() {
        return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
    }
}
