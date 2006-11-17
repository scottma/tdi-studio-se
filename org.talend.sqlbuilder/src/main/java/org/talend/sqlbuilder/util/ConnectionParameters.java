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
package org.talend.sqlbuilder.util;

import org.talend.core.model.metadata.builder.connection.Query;
import org.talend.repository.ui.utils.DataStringConnection;

/**
 * This class is used for representing connection parameters. <br/>
 * 
 * @author ftang
 * 
 */
public class ConnectionParameters {

    private String query;

    private String port;

    private String userName;

    private String password;

    private String host;

    private String dbName;

    private String dbType;

    private String datasource;

    private String filename;

    private String repositoryName;

    private String selectedComponentName;
    
    private Query queryObject;

    
    /**
     * Getter for queryObject.
     * @return the queryObject
     */
    public Query getQueryObject() {
        return queryObject;
    }

    
    /**
     * Sets the queryObject.
     * @param queryObject the queryObject to set
     */
    public void setQueryObject(Query queryObject) {
        this.queryObject = queryObject;
    }

    /**
     * ConnectionParameters constructor.
     */
    public ConnectionParameters() {

    }

    /**
     * Getter for filename.
     * 
     * @return the filename
     */
    public String getFilename() {
        return this.filename;
    }

    /**
     * Sets the filename.
     * 
     * @param filename the filename to set
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * Getter for datasource.
     * 
     * @return the datasource
     */
    public String getDatasource() {
        return this.datasource;
    }

    /**
     * Sets the datasource.
     * 
     * @param datasource the datasource to set
     */
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    /**
     * Getter for dbType.
     * 
     * @return the dbType
     */
    public String getDbType() {
        return this.dbType;
    }

    /**
     * Sets the dbType.
     * 
     * @param dbType the dbType to set
     */
    public void setDbType(String dbType) {
        this.dbType = trimInvertedComma(dbType);
    }

    public boolean isRepository() {
        return repositoryName != null;
    }

    /**
     * Getter for dbName.
     * 
     * @return the dbName
     */
    public String getDbName() {
        return dbName;
    }

    /**
     * Sets the dbName.
     * 
     * @param dbName the dbName to set
     */
    public void setDbName(String dbName) {
        this.dbName = trimInvertedComma(dbName);
        if (this.datasource == null || this.datasource.equals("")) {
        		this.datasource = this.dbName;
        }
    }

    /**
     * Getter for host.
     * 
     * @return the host
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host.
     * 
     * @param host the host to set
     */
    public void setHost(String host) {
        this.host = trimInvertedComma(host);
    }

    /**
     * Getter for password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     * 
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = trimInvertedComma(password);
    }

    /**
     * Getter for port.
     * 
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * Sets the port.
     * 
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = trimInvertedComma(port);
    }

    /**
     * Getter for query.
     * 
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * Sets the query.
     * 
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = trimInvertedComma(query);
    }

    /**
     * Getter for userName.
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the userName.
     * 
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = trimInvertedComma(userName);
    }

    /**
     * Getter for repositoryName.
     * 
     * @return the repositoryName
     */
    public String getRepositoryName() {
        return repositoryName;
    }

    /**
     * Sets the repositoryName.
     * 
     * @param repositoryName the repositoryName to set
     */
    public void setRepositoryName(String repositoryName) {
        this.repositoryName = trimInvertedComma(repositoryName);
    }

    /**
     * Trims the "'" of the input String.
     * 
     * @param input
     * @return the String without " ' "
     */
    private String trimInvertedComma(String input) {
        String out = input.replaceAll("\'", "");
        return out;
    }

    /**
     * Get url String , use it to create Connection.
     * 
     * @return url String from user input parameters.
     */
    public String getURL() {
        if (isRepository()) {
            throw new RuntimeException("This is a repository , should not call this method.");
        }
        DataStringConnection urlDataStringConnection = new DataStringConnection();
        int dbIndex = urlDataStringConnection.getIndexOfLabel(dbType);
        urlDataStringConnection.setSelectionIndex(dbIndex);
        String url = urlDataStringConnection.getString(-1, getHost(), getUserName(), getPassword(), getPort(),
                getDbName(), getFilename(), getDatasource());
        return url;

    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String enter = "\n";
        sb.append("is Repository? " + isRepository() + enter);
        if (!isRepository()) {
            sb.append("Database driver: " + this.getDbType() + enter);
            sb.append("Database name: " + this.getDbName() + enter);
            sb.append("Host: " + this.getHost() + enter);
            sb.append("Port: " + this.getPort() + enter);
            sb.append("User name: " + this.getUserName() + enter);
            sb.append("Password: " + this.getPassword() + enter);
            sb.append("Query: " + this.getQuery());
        } else {
            sb.append("Repository name: " + this.getRepositoryName() + enter);
        }
        return sb.toString();
    }

    /**
     * Sets selected component name.
     * 
     * @param selectedComponentName
     */
    public void setSelectedComponentName(String selectedComponentName) {
        this.selectedComponentName = selectedComponentName;

    }

    /**
     * Gets selected component name.
     * 
     * @return
     */
    public String getSelectedComponentName() {
        return selectedComponentName != null ? selectedComponentName : "";
    }
}
