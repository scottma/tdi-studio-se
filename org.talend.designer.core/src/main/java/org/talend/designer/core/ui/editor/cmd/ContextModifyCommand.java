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

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.talend.core.model.process.IContext;
import org.talend.core.model.process.IContextManager;
import org.talend.core.model.process.IContextParameter;

/**
 * Command that will modify a context.
 * 
 * $Id$
 * 
 */
public class ContextModifyCommand extends Command {

    IContext oldContext;

    IContext currentContext;

    IContext tmpContext;

    IContextManager contextManager;

    public ContextModifyCommand(IContextManager contextManager, IContext oldContext, IContext newContext) {
        this.contextManager = contextManager;
        this.oldContext = oldContext;
        this.currentContext = newContext;
        setLabel("Modify Context");
    }

    private void refreshPropertyView() {
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IViewPart view = page.findView("org.eclipse.ui.views.PropertySheet");
        PropertySheet sheet = (PropertySheet) view;
        TabbedPropertySheetPage tabbedPropertySheetPage = (TabbedPropertySheetPage) sheet.getCurrentPage();
        tabbedPropertySheetPage.refresh();
    }

    public void execute() {
        contextManager.fireContextsChangedEvent();
    }

    @Override
    public void redo() {
        tmpContext = currentContext.clone();
        currentContext.setName(oldContext.getName());
        currentContext.setConfirmationNeeded(oldContext.isConfirmationNeeded());

        List<IContextParameter> oldListContextParam = oldContext.getContextParameterList();
        List<IContextParameter> curListContextParam = currentContext.getContextParameterList();

        boolean found;
        IContextParameter oldParam = null;
        IContextParameter curParam;
        String name = null;
        for (int i = 0; i < oldListContextParam.size(); i++) {
            found = false;
            oldParam = oldListContextParam.get(i);
            for (int j = 0; j < curListContextParam.size() && !found; j++) {
                curParam = curListContextParam.get(j);
                name = oldParam.getName();
                if (curParam.getName().equals(name)) {
                    found = true;
                    curParam.setPromptNeeded(oldParam.isPromptNeeded());
                    curParam.setComment(oldParam.getComment());
                    curParam.setPrompt(oldParam.getPrompt());
                    curParam.setType(oldParam.getType());
                    curParam.setValue(oldParam.getValue());
                }
            }
        }

        oldContext = tmpContext;
        contextManager.fireContextsChangedEvent();
        refreshPropertyView();
    }

    @Override
    public void undo() {
        tmpContext = currentContext.clone();
        currentContext.setName(oldContext.getName());
        currentContext.setConfirmationNeeded(oldContext.isConfirmationNeeded());

        List<IContextParameter> oldListContextParam = oldContext.getContextParameterList();
        List<IContextParameter> curListContextParam = currentContext.getContextParameterList();

        boolean found;
        IContextParameter oldParam = null;
        IContextParameter curParam;
        String name = null;
        for (int i = 0; i < oldListContextParam.size(); i++) {
            found = false;
            oldParam = oldListContextParam.get(i);
            for (int j = 0; j < curListContextParam.size() && !found; j++) {
                curParam = curListContextParam.get(j);
                name = oldParam.getName();
                if (curParam.getName().equals(name)) {
                    found = true;
                    curParam.setPromptNeeded(oldParam.isPromptNeeded());
                    curParam.setComment(oldParam.getComment());
                    curParam.setPrompt(oldParam.getPrompt());
                    curParam.setType(oldParam.getType());
                    curParam.setValue(oldParam.getValue());
                }
            }
        }
        oldContext = tmpContext;
        contextManager.fireContextsChangedEvent();
        refreshPropertyView();
    }
}
