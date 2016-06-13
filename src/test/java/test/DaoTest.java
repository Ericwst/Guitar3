package test;

import java.util.HashMap;
import java.util.Map;

import Model.Guitar;
import Model.Inventory;
import test.BaseClass;

public class DaoTest {
	public static void main(String[] args) {
		Inventory inventory = (Inventory) BaseClass.LoadXML().getBean("inventory");

		Map<String, String> guitarSpec2 = new HashMap<String, String>();
		guitarSpec2.put("backwood", "木头2");
		guitarSpec2.put("topwood", "塑料2");
		guitarSpec2.put("type", "铁2");
		guitarSpec2.put("builder", "zhang2");
		guitarSpec2.put("guitarmodel", "modelzhang2");
		Guitar guitar2 = new Guitar();
		guitar2.setGuitarSpec(guitarSpec2);
		inventory.addGuitar(guitar2);
		System.out.println(inventory.getAllData());
	}

}
