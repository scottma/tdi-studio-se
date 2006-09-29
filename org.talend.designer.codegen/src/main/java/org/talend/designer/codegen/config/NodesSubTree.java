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
package org.talend.designer.codegen.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.talend.core.model.process.EConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.INode;
import org.talend.core.model.temp.ECodePart;

/**
 * A process is cut out in a list of NodesSubTree. Each Subtrees are traversed to generate code.
 * 
 * $Id$
 * 
 */
public class NodesSubTree {

    INode rootNode;

    String name;

    List<String> beforeSubProcesses;

    List<String> afterSubProcesses;

    List<INode> nodes;

    HashMap<INode, Boolean> visitedNodesStartCode;

    HashMap<INode, Boolean> visitedNodesMainCode;

    HashMap<INode, Boolean> visitedNodesEndCode;

    /**
     * Constructor for a NodesSubTree.
     * 
     * @param NodesSubTree Root Node
     */
    public NodesSubTree(INode node) {
        this.rootNode = node;
        this.name = node.getUniqueName();
        this.nodes = new ArrayList<INode>();
        afterSubProcesses = new ArrayList<String>();
        beforeSubProcesses = new ArrayList<String>();
        this.visitedNodesMainCode = new HashMap<INode, Boolean>();
        this.visitedNodesStartCode = new HashMap<INode, Boolean>();
        this.visitedNodesEndCode = new HashMap<INode, Boolean>();
        buildSubTree(node);
    }

    /**
     * Build the SubSubTrees..
     * 
     * @param nodes
     */
    private void buildSubTree(INode node) {
        for (IConnection connection : node.getOutgoingConnections()) {
            if (connection.getTarget().isActivate()) {
                if (connection.getLineStyle().getCategory().equals(EConnectionCategory.MAIN)) {
                    buildSubTree((INode) connection.getTarget());
                }
                if (connection.getLineStyle().equals(EConnectionType.RUN_AFTER)) {
                    afterSubProcesses.add(connection.getTarget().getUniqueName());
                }
                if (connection.getLineStyle().equals(EConnectionType.RUN_BEFORE)) {
                    beforeSubProcesses.add(connection.getTarget().getUniqueName());
                }
            }
        }

        visitedNodesMainCode.put(node, false);
        visitedNodesStartCode.put(node, false);
        visitedNodesEndCode.put(node, false);
    }

    /**
     * Tells if this Node is marked for this specific code part in this SubTree.
     * 
     * @param node
     * @return
     */
    public Boolean isMarkedNode(INode node, ECodePart part) {
        Boolean result = false;
        switch (part) {
        case MAIN:
            return visitedNodesMainCode.get(node);
        case START:
            return visitedNodesStartCode.get(node);
        case END:
            return visitedNodesEndCode.get(node);
        default:
            return result;
        }

    }

    /**
     * Mark a Node of this SubTree as Visited for this specific code part.
     * 
     * @param node
     */
    public void markNode(INode node, ECodePart part) {
        switch (part) {
        case MAIN:
            visitedNodesMainCode.put(node, true);
            break;
        case START:
            visitedNodesStartCode.put(node, true);
            break;
        case END:
            visitedNodesEndCode.put(node, true);
            break;
        default:
            // do nothing
        }
    }

    /**
     * Getter for rootNode.
     * 
     * @return the rootNode
     */
    public INode getRootNode() {
        return this.rootNode;
    }

    /**
     * Getter for name.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name.
     * 
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for afterSubProcesses.
     * 
     * @return the afterSubProcesses
     */
    public List<String> getAfterSubProcesses() {
        return this.afterSubProcesses;
    }

    /**
     * Getter for beforeSubProcesses.
     * 
     * @return the beforeSubProcesses
     */
    public List<String> getBeforeSubProcesses() {
        return this.beforeSubProcesses;
    }
}
