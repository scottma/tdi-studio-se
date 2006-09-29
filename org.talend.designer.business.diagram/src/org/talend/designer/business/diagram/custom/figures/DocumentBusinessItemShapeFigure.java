// ============================================================================
//
// Talend Community Edition
//
// Copyright (C) 2006 Talend – www.talend.com
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
package org.talend.designer.business.diagram.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * DOC mhelleboid class global comment. Detailled comment <br/>
 * 
 * $Id$
 * 
 */
public class DocumentBusinessItemShapeFigure extends BusinessItemShapeFigure {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
     */
    @Override
    protected void paintFigure(Graphics graphics) {
        Rectangle r = getInnerBounds();

        int sinHeight = r.height / 8;
        // PTODO MHE handle zoom and size
        // PTODO MHE have a look at graphics.drawArc
        int sinPoints = 14;

        PointList pointList = new PointList();
        pointList.removeAllPoints();
        pointList.addPoint(r.x + r.width, r.y + r.height - sinHeight / 2);
        pointList.addPoint(r.x + r.width, r.y);
        pointList.addPoint(r.x, r.y);
        pointList.addPoint(r.x, r.y + r.height - sinHeight / 2);

        for (int i = 0; i < sinPoints; i = i + 1) {
            double rad = 2 * i * Math.PI / sinPoints;
            int x = r.x + i * r.width / sinPoints;
            int y = (int) (r.y + r.height - sinHeight / 2 + sinHeight * Math.sin(rad) / 2);
            pointList.addPoint(x, y);
        }

        graphics.fillPolygon(pointList);
        graphics.drawPolygon(pointList);
    }
}