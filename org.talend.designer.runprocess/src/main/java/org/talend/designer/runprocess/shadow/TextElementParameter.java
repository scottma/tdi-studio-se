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
package org.talend.designer.runprocess.shadow;

import java.util.List;

import org.talend.core.model.metadata.EMetadataType;
import org.talend.core.model.process.EComponentCategory;
import org.talend.core.model.process.EParameterFieldType;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IElementParameterDefaultValue;
import org.talend.core.model.temp.ECodeLanguage;

/**
 * Simple Text implementation of IElementParameter. <br/>
 * 
 * $Id$
 * 
 */
public class TextElementParameter implements IElementParameter {

    private String name;

    private String value;

    /**
     * Constructs a new TextElementParameter.
     */
    public TextElementParameter(String name, String value) {
        super();

        this.name = name;
        this.value = value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getCategory()
     */
    public EComponentCategory getCategory() {
        return EComponentCategory.MAIN;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getDisplayName()
     */
    public String getDisplayName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getExtension()
     */
    public String getExtension() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getField()
     */
    public EParameterFieldType getField() {
        return EParameterFieldType.TEXT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getListItemsID()
     */
    public String[] getListItemsValue() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getListItemsValue()
     */
    public String[] getListItemsDisplayName() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getMetadataType()
     */
    public EMetadataType getMetadataType() {
        return EMetadataType.STRING;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getName()
     */
    public String getName() {
        return name;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getNbLines()
     */
    public int getNbLines() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getNumRow()
     */
    public int getNumRow() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getValue()
     */
    public Object getValue() {
        return value;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getVariableName()
     */
    public String getVariableName() {
        return "__" + name + "__"; //$NON-NLS-1$ //$NON-NLS-2$
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#isReadOnly()
     */
    public boolean isReadOnly() {
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#isRequired()
     */
    public boolean isRequired() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setCategory(org.talend.core.model.process.EComponentCategory)
     */
    public void setCategory(EComponentCategory cat) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setDisplayName(java.lang.String)
     */
    public void setDisplayName(String s) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setExtension(java.lang.String)
     */
    public void setExtension(String extension) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setField(org.talend.core.model.process.EParameterFieldType)
     */
    public void setField(EParameterFieldType type) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setListItemsID(java.lang.String[])
     */
    public void setListItemsValue(String[] list) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setListItemsValue(java.lang.String[])
     */
    public void setListItemsDisplayName(String[] list) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setMetadataType(org.talend.core.model.metadata.EMetadataType)
     */
    public void setMetadataType(EMetadataType metadataType) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setName(java.lang.String)
     */
    public void setName(String s) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setNbLines(int)
     */
    public void setNbLines(int nbLines) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setNumRow(int)
     */
    public void setNumRow(int numRow) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setReadOnly(boolean)
     */
    public void setReadOnly(boolean readOnly) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setRequired(boolean)
     */
    public void setRequired(boolean required) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setShow(boolean)
     */
    public void setShow(boolean show) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setValue(java.lang.Object)
     */
    public void setValue(Object o) {
        // Read-only
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getDefaultClosedListValue(org.talend.core.model.temp.ECodeLanguage)
     */
    public Object getDefaultClosedListValue(ECodeLanguage language) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getListItemsDisplayName(org.talend.core.model.temp.ECodeLanguage)
     */
    public String[] getListItemsDisplayName(ECodeLanguage language) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getListItemsValue(org.talend.core.model.temp.ECodeLanguage)
     */
    public Object[] getListItemsValue(ECodeLanguage language) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setDefaultClosedListValue(org.talend.core.model.temp.ECodeLanguage,
     * java.lang.Object)
     */
    public void setDefaultClosedListValue(ECodeLanguage language, Object o) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setListItemsDisplayName(org.talend.core.model.temp.ECodeLanguage,
     * java.lang.String[])
     */
    public void setListItemsDisplayName(ECodeLanguage language, String[] list) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setListItemsValue(java.lang.Object[])
     */
    public void setListItemsValue(Object[] list) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setListItemsValue(org.talend.core.model.temp.ECodeLanguage,
     * java.lang.Object[])
     */
    public void setListItemsValue(ECodeLanguage language, Object[] list) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getRepositoryValue()
     */
    public String getRepositoryValue() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setRepositoryValue(java.lang.String)
     */
    public void setRepositoryValue(String repositoryValue) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#isRepositoryValueUsed()
     */
    public boolean isRepositoryValueUsed() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setRepositoryValueUsed(boolean)
     */
    public void setRepositoryValueUsed(boolean repositoryUsed) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#getRepositoryListItemsValue(org.talend.core.model.temp.ECodeLanguage)
     */
    public String[] getListRepositoryItems(ECodeLanguage language) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setRepositoryListItemsValue(org.talend.core.model.temp.ECodeLanguage,
     * java.lang.String[])
     */
    public void setListRepositoryItems(ECodeLanguage language, String[] list) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setShowIf(java.lang.String)
     */
    public void setShowIf(String showIf) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#getShowIf()
     */
    public String getShowIf() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.talend.core.model.process.IElementParameter#setNotShowIf(java.lang.String)
     */
    public void setNotShowIf(String notShowIf) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#getNotShowIf()
     */
    public String getNotShowIf() {
        return null;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#testIfShow(java.util.List)
     */
    public boolean isShow(List<? extends IElementParameter> listParam) {
        return false;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#getListItemsDisplayCodeName(org.talend.core.model.temp.ECodeLanguage)
     */
    public String[] getListItemsDisplayCodeName(ECodeLanguage language) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#setListItemsDisplayCodeName(java.lang.String[])
     */
    public void setListItemsDisplayCodeName(String[] list) {
    }

    public void setListItemsDisplayCodeName(ECodeLanguage language, String[] list) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#getListItemsNotShowIf(org.talend.core.model.temp.ECodeLanguage)
     */
    public String[] getListItemsNotShowIf(ECodeLanguage language) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#getListItemsShowIf(org.talend.core.model.temp.ECodeLanguage)
     */
    public String[] getListItemsShowIf(ECodeLanguage language) {
        return null;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#isShow(java.lang.String, java.lang.String, java.util.List)
     */
    public boolean isShow(String conditionShowIf, String conditionNotShowIf, List<? extends IElementParameter> listParam) {
        return false;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#setListItemsNotShowIf(java.lang.String[])
     */
    public void setListItemsNotShowIf(String[] list) {
    }

    public void setListItemsNotShowIf(ECodeLanguage language, String[] list) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#setListItemsShowIf(java.lang.String[])
     */
    public void setListItemsShowIf(String[] list) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#setListItemsShowIf(org.talend.core.model.temp.ECodeLanguage, java.lang.String[])
     */
    public void setListItemsShowIf(ECodeLanguage language, String[] list) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#getDefaultValues()
     */
    public List<IElementParameterDefaultValue> getDefaultValues() {
        return null;
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#setDefaultValues(java.util.List)
     */
    public void setDefaultValues(List<IElementParameterDefaultValue> defaultValues) {
    }

    /* (non-Javadoc)
     * @see org.talend.core.model.process.IElementParameter#setValueToDefault(java.util.List)
     */
    public void setValueToDefault(List<? extends IElementParameter> listParam) {
    }
}
