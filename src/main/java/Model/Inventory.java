package Model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import Dao.GuitarDao;
public class Inventory {
	public Inventory() {
	}
	private  List<Guitar> allData=new ArrayList<Guitar>();
	private GuitarDao guitarDao;
	public void setGuitarDao(GuitarDao guitarDao) {
		this.guitarDao = guitarDao;
	}

	public List<Guitar> getAllData() {
		return allData;
	}
	public void init() {
		Map<String, String> guitarSpec1=new HashMap<String, String>();
		guitarSpec1.put("backwood", "木头1");
		guitarSpec1.put("topwood",  "木头1");
		guitarSpec1.put("type",  "铁1");
		guitarSpec1.put("builder",  "zhang1");
		guitarSpec1.put("guitarmodel",  "modelzhang1");
		Guitar guitar1=new Guitar(1,23D,guitarSpec1);
		Map<String, String> guitarSpec2=new HashMap<String, String>();
		guitarSpec2.put("backwood", "木头2");
		guitarSpec2.put("topwood",  "塑料2");
		guitarSpec2.put("type",  "铁2");
		guitarSpec2.put("builder",  "zhang2");
		guitarSpec2.put("guitarmodel",  "modelzhang2");
		Guitar guitar2=new Guitar(2,23D,guitarSpec2);
		allData.addAll(guitarDao.findAll());
		System.out.println("init:"+allData);
	}

	public void addGuitar(Guitar guitar){

		this.allData.add(guitar);
		guitarDao.save(guitar);

	}
	public void delGuitar(Guitar guitar){
		for (int i = 0; i < allData.size(); i++) {
			Guitar guitar2=(Guitar)allData.get(i);
			if(guitar2.getId()==guitar.getId()){
				allData.remove(i);
				guitarDao.delete(guitar.getId());
			}
		}
	}

	public List<Guitar> search(Guitar searchGuitar){
		List<Guitar> result=new ArrayList<Guitar>();
		Iterator<Guitar> iterator=allData.iterator();
		while (iterator.hasNext()) {
			Guitar guitar = (Guitar) iterator.next();
			if(searchGuitar.equals(guitar)){
				result.add(guitar);
			}
		}
		return  result;
	}
}
