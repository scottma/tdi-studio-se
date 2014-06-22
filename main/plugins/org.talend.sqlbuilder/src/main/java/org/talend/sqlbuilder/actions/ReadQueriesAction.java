// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.sqlbuilder.actions;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.talend.commons.ui.runtime.image.EImage;
import org.talend.commons.ui.runtime.image.ImageProvider;
import org.talend.core.model.metadata.IMetadataConnection;
import org.talend.core.model.metadata.builder.ConvertionHelper;
import org.talend.core.model.metadata.builder.connection.Connection;
import org.talend.core.model.metadata.builder.connection.DatabaseConnection;
import org.talend.core.model.properties.DatabaseConnectionItem;
import org.talend.core.model.repository.ERepositoryObjectType;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.core.repository.model.ProxyRepositoryFactory;
import org.talend.core.sqlbuilder.util.ConnectionParameters;
import org.talend.core.sqlbuilder.util.TextUtil;
import org.talend.repository.model.ERepositoryStatus;
import org.talend.repository.model.IProxyRepositoryFactory;
import org.talend.repository.model.QueryRepositoryObject;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.ui.actions.AContextualAction;
import org.talend.repository.ui.views.IRepositoryView;
import org.talend.sqlbuilder.Messages;
import org.talend.sqlbuilder.ui.SQLBuilderDialog;

/**
 * DOC smallet class global comment. Detailled comment <br/>
 * 
 * $Id: talend.epf 1 2006-09-29 17:06:40 +0000 (ven., 29 sept. 2006) nrousseau $
 * 
 */
public class ReadQueriesAction extends AContextualAction {

    private RepositoryNode repositoryNode;

    public ReadQueriesAction() {
        super();
        setText(Messages.getString("EditQueriesAction.textOpenQueries")); //$NON-NLS-1$
        setImageDescriptor(ImageProvider.getImageDesc(EImage.READ_ICON));
    }

    protected void doRun() {
        IStructuredSelection selection = (IStructuredSelection) getSelection();
        IProxyRepositoryFactory factory = ProxyRepositoryFactory.getInstance();
        if (repositoryNode == null && selection != null) {
            repositoryNode = (RepositoryNode) selection.getFirstElement();
        }

        DatabaseConnectionItem dbConnectionItem = null;
        ConnectionParameters connParameters = new ConnectionParameters();
        if (repositoryNode.getObjectType() == ERepositoryObjectType.METADATA_CONNECTIONS) {
            dbConnectionItem = (DatabaseConnectionItem) repositoryNode.getObject().getProperty().getItem();
            connParameters.setRepositoryName(repositoryNode.getObject().getLabel());
            connParameters.setRepositoryId(repositoryNode.getObject().getId());
            connParameters.setQuery(""); //$NON-NLS-1$
        } else if (repositoryNode.getObjectType() == ERepositoryObjectType.METADATA_CON_QUERY) {
            QueryRepositoryObject queryRepositoryObject = (QueryRepositoryObject) repositoryNode.getObject();
            dbConnectionItem = (DatabaseConnectionItem) queryRepositoryObject.getProperty().getItem();
            connParameters.setRepositoryName(dbConnectionItem.getProperty().getLabel());
            connParameters.setRepositoryId(dbConnectionItem.getProperty().getId());
            connParameters.setQueryObject(queryRepositoryObject.getQuery());
            connParameters.setQuery(queryRepositoryObject.getQuery().getValue());
            connParameters.setFirstOpenSqlBuilder(true); // first open Sql Builder,set true
        }

        Shell parentShell = new Shell(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                .findView(IRepositoryView.VIEW_ID).getSite().getShell().getDisplay());
        TextUtil.setDialogTitle(TalendTextUtils.SQL_BUILDER_TITLE_REP);
        SQLBuilderDialog dial = new SQLBuilderDialog(parentShell);

        dial.setReadOnly(true);

        Connection connection = dbConnectionItem.getConnection();
        if (connection instanceof DatabaseConnection) {
            IMetadataConnection imetadataConnection = ConvertionHelper.convert((DatabaseConnection) connection, true);
            connParameters.setSchema(imetadataConnection.getSchema());
        }
        connParameters.setNodeReadOnly(true);
        connParameters.setFromRepository(true);
        dial.setConnParameters(connParameters);
        dial.open();
        refresh(repositoryNode);
    }

    public void init(TreeViewer viewer, IStructuredSelection selection) {
        boolean canWork = !selection.isEmpty() && selection.size() == 1;
        if (canWork) {
            Object o = selection.getFirstElement();
            repositoryNode = (RepositoryNode) o;

            switch (repositoryNode.getType()) {
            case REPOSITORY_ELEMENT:
                if (repositoryNode.getObject().getRepositoryStatus() == ERepositoryStatus.DELETED) {
                    canWork = false;
                }
                if (repositoryNode.getObjectType() != ERepositoryObjectType.METADATA_CONNECTIONS
                        && repositoryNode.getObjectType() != ERepositoryObjectType.METADATA_CON_QUERY) {
                    canWork = false;
                }
                break;
            default:
                canWork = false;
            }
            if (canWork && !isLastVersion(repositoryNode)) {
                canWork = false;
            }
        }
        setEnabled(canWork);
    }
}