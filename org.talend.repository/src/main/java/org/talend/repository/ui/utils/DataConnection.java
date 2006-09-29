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
package org.talend.repository.ui.utils;

/**
 * DataConnection describe the data need to make a connection of a DataBase.
 * 
 * $Id$
 * 
 */
public class DataConnection {

    private String label;

    private String string;

    private String regex;
    
    private String defaultPort;

    /**
     * DOC ocarbone DataConnection constructor comment.
     * 
     * @param label
     * @param string
     * @param regex
     * @param defaultPort
     */
    public DataConnection(String label, String string, String regex, String defaultPort) {
        super();
        this.label = label;
        this.string = string;
        this.regex = regex;
        this.defaultPort = defaultPort;        
    }

    /**
     * DOC ocarbone DataConnection constructor comment.
     * 
     * @param label
     * @param string
     * @param regex
     */
    public DataConnection(String label, String string, String regex) {
        this(label, string, regex, null);
    }
    
    /**
     * Getter for label.
     * 
     * @return the label
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the label.
     * 
     * @param label the label to set
     */
    public void setLabel(final String label) {
        this.label = label;
    }

    /**
     * Getter for regex.
     * 
     * @return the regex
     */
    public String getRegex() {
        return this.regex;
    }

    /**
     * Sets the regex.
     * 
     * @param regex the regex to set
     */
    public void setRegex(final String regex) {
        this.regex = regex;
    }

    /**
     * Getter for string.
     * 
     * @return the string
     */
    public String getString() {
        return this.string;
    }

    /**
     * Sets the string.
     * 
     * @param string the string to set
     */
    public void setString(final String string) {
        this.string = string;
    }

    /**
     * Getter for defaultPort.
     * 
     * @return the defaultPort
     */
    public String getDefaultPort() {
        return this.defaultPort;
    }

    /**
     * Sets the defaultPort.
     * 
     * @param defaultPort the defaultPort to set
     */
    public void setDefaultPort(final String defaultPort) {
        this.defaultPort = defaultPort;
    }
    
}
