// ============================================================================
//
// Copyright (C) 2006-2007 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.repository.model.migration;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Arrays;

import org.talend.commons.exception.ExceptionHandler;
import org.talend.core.language.ECodeLanguage;
import org.talend.core.model.components.ModifyComponentsAction;
import org.talend.core.model.components.conversions.AddPropertyLoopTypeConversion;
import org.talend.core.model.components.conversions.IComponentConversion;
import org.talend.core.model.components.conversions.RenameComponentConversion;
import org.talend.core.model.components.filters.IComponentFilter;
import org.talend.core.model.components.filters.NameComponentFilter;
import org.talend.core.model.migration.AbstractJobMigrationTask;
import org.talend.core.model.properties.Item;
import org.talend.core.model.properties.ProcessItem;
import org.talend.designer.core.model.utils.emf.talendfile.ProcessType;

/**
 * DOC Administrator class global comment. Detailled comment
 */
public class RenametForForPerl extends AbstractJobMigrationTask {

    public ExecutionResult execute(Item item) {
    	ProcessType processType = getProcessType(item);
		if (processType == null) {
			return ExecutionResult.NOTHING_TO_DO;
		}	
        try {
            if (getProject().getLanguage().equals(ECodeLanguage.PERL)) {
                IComponentFilter filter1 = new NameComponentFilter("tFor"); //$NON-NLS-1$

                IComponentConversion addProperty = new AddPropertyLoopTypeConversion();
                IComponentConversion renameComponent = new RenameComponentConversion("tLoop");

                ModifyComponentsAction.searchAndModify(item,processType, filter1, Arrays.<IComponentConversion> asList(addProperty,
                        renameComponent));

                return ExecutionResult.SUCCESS_WITH_ALERT;
            } else {
                // do nothing
                return ExecutionResult.NOTHING_TO_DO;
            }
        } catch (Exception e) {
            ExceptionHandler.process(e);
            return ExecutionResult.FAILURE;
        }
    }

    public Date getOrder() {
        GregorianCalendar gc = new GregorianCalendar(2008, 4, 28, 0, 22, 0);
        return gc.getTime();
    }
}
