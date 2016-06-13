package Model;

import java.util.Iterator;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;

@Entity
public class Guitar {
	public Guitar() {
	}

	public Guitar(Integer id, Double price, Map<String, String> guitarSpec) {
		this.id = id;
		this.price = price;
		this.guitarSpec = guitarSpec;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;// 自增ID

	private Double price;// 价格

	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "spec", joinColumns = @JoinColumn(name = "id"))
	@MapKeyColumn(name = "spec")
	@MapKeyClass(String.class)
	@Column(name = "val")
	private Map<String, String> guitarSpec;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setGuitarSpec(Map<String, String> guitarSpec) {
		this.guitarSpec = guitarSpec;
	}

	public Map<String, String> getGuitarSpec() {
		return guitarSpec;
	}

	/**
	 * 比较方法（重写equals()方法）序列化
	 */
	@Override
	public boolean equals(Object obj) {
		Guitar guitar = (Guitar) obj;
		Map<String, String> ObjGuitarSpec = guitar.getGuitarSpec();
		Iterator<String> iterator = ObjGuitarSpec.keySet().iterator();
		while (iterator.hasNext()) {
			String iter = iterator.next();
			String value = guitarSpec.get(iter);
			if (value == null || value.equals("")) {
				continue;
			}
			if (!ObjGuitarSpec.get(iter).equals(value)) {
				System.out.println(iter + ":" + ObjGuitarSpec.get(iter));
				return false;
			}
		}
		return true;
	}


	@Override
	public String toString() {
		return "Guitar [guitarSpec=" + guitarSpec + ", id=" + id + ", price=" + price + "]";
	}

}
