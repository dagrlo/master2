package wssw;

import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.RDFNode;

public class GuiaDocente {

	public String getCodigoAsignatura(){
		OntModel modelo=null;
		String resultado="";
		
		modelo=ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_MINI_RULE_INF);
		modelo.read("http://mural.uv.es/dagraulo/ontologias/guia_docente.owl");
		String queryString="PREFIX mia: <http://www.semanticweb.org/yo/ontologies/2015/4/guiaDocente#>"+
					"SELECT ?subject ?object"+
					"WHERE { ?subject mia:codigoAsignatura ?object}";
		Query query=QueryFactory.create(queryString);
		QueryExecution qExec=QueryExecutionFactory.create(query,modelo);
		try{
			ResultSet results=qExec.execSelect();
			StringBuilder result=new StringBuilder();
			while(results.hasNext()){
				QuerySolution solution=results.nextSolution();
				RDFNode title=solution.get("object");
				result.append(title.toString());
				result.append("-");
			}
			resultado+=result;
		} finally{
			qExec.close();
		}
		return resultado;
	}
}