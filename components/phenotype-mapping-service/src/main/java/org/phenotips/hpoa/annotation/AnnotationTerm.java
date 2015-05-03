/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.phenotips.hpoa.annotation;

import org.phenotips.hpoa.ontology.HPO;
import org.phenotips.hpoa.ontology.Ontology;
import org.phenotips.hpoa.ontology.OntologyTerm;
import org.phenotips.hpoa.utils.graph.Node;

public class AnnotationTerm extends Node
{
    private OntologyTerm ontologyTerm;

    public AnnotationTerm(String id)
    {
        super(id);
    }

    public AnnotationTerm(String id, String name)
    {
        super(id, name);
    }

    public void setOntologyTerm(OntologyTerm ontologyTerm)
    {
        this.ontologyTerm = ontologyTerm;
    }

    public OntologyTerm getOntologyTerm()
    {
        return this.ontologyTerm;
    }

    @Override
    public String toString()
    {
        Ontology hpo = HPO.getInstance();
        StringBuilder str = new StringBuilder();
        str.append(this.id).append(' ').append(this.name).append('\n');
        for (String nodeId : this.getNeighbors()) {
            str.append("            ").append(nodeId).append('\t').append(hpo.getName(nodeId)).append('\n');
        }
        return str.toString();
    }
}
