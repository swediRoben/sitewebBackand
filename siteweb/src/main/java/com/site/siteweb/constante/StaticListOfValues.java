package com.site.siteweb.constante;

import java.util.ArrayList;
import java.util.List;

import com.site.siteweb.constante.Constante.langue;
import com.site.siteweb.constante.Constante.roles;
import com.site.siteweb.constante.Constante.travail;
import com.site.siteweb.constante.Constante.type;
import com.site.siteweb.constante.Constante.typeFichier;
import com.site.siteweb.constante.Constante.typeMail; 
public class StaticListOfValues {
	private List<StaticValue> staticValues = new ArrayList<>();
 

	public StaticValue findByKey(String key, List<StaticValue> slov) {
		StaticValue sv = new StaticValue();
		for (StaticValue _sv : slov) {
			if (_sv.getKey().equals(key)) {
				sv = new StaticValue(_sv.getKey(), _sv.getValue());
				break;
			}
		}
		return sv;
	}

	public List<StaticValue> getType() {
		staticValues.clear();
		int i = 0;
		for (type t : type.values()) {
			StaticValue sv = new StaticValue(i, t.toString());
			staticValues.add(sv); 
			i++;
		
		}
		return staticValues;
	}

		public List<StaticValue> getRoles() {
		staticValues.clear();
		int i = 0;
		for (roles r : roles.values()) {
			StaticValue sv = new StaticValue(i, r.toString());
			staticValues.add(sv); 
			i++;
		
		}
		return staticValues;
	}

	public List<StaticValue> getTypeFichier() {
		staticValues.clear();
		int i = 0;
		for (typeFichier t : typeFichier.values()) {
			StaticValue sv = new StaticValue(i, t.toString());
			staticValues.add(sv); 
			i++;
		
		}
		return staticValues;
	}

	public List<StaticValue> getTypeMail() {
		staticValues.clear();
		int i = 0;
		for (typeMail t : typeMail.values()) {
			StaticValue sv = new StaticValue(i, t.toString());
			staticValues.add(sv); 
			i++;
		
		}
		return staticValues;
	}


		public List<StaticValue> getLangue() {
		staticValues.clear();
		int i = 0;
		for (langue l : langue.values()) {
			StaticValue sv = new StaticValue(i, l.toString());
			staticValues.add(sv); 
			i++;
		
		}
		return staticValues;
	}

		public List<StaticValue> getTravail() {
		staticValues.clear();
		int i = 0;
		for (travail t : travail.values()) {
			StaticValue sv = new StaticValue(i, t.toString());
			staticValues.add(sv); 
			i++;
		
		}
		return staticValues;
	}
}
