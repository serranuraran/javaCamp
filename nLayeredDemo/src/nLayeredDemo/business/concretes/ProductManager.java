package nLayeredDemo.business.concretes;

import java.util.List;

import nLayeredDemo.business.abstracts.ProductService;
import nLayeredDemo.core.LoggerService;
import nLayeredDemo.dataAccess.abstracts.ProductDao;
import nLayeredDemo.dataAccess.concretes.HibernateProductDao;
import nLayeredDemo.entities.concretes.Product;
import nLayeredDemo.jLogger.JLoggerManager;

public class ProductManager implements ProductService {

	private ProductDao productDao; // manager hibernate'den asla haberdar degil. manager sadece kullanacagi interfaceinden haberdar.

	private LoggerService loggerService;
	
	public ProductManager(ProductDao productDao, LoggerService loggerService) {  // asla hibernate'e bagimli degilsin. ama onun tutacagi referanslara baglisin.
		super();
		this.productDao = productDao;
		this.loggerService = loggerService;
	}

	@Override
	public void add(Product product) {
		
		// is Kodlari
		
		if(product.getCategoryId() ==1) {
			System.out.println("Bu kategoriye urun kabul edilmiyor . ");
			return;
		}
		// HibernateProductDao dao = new HibernateProductDao(); // bunu yaparsam, calisir. ama ben dogru degil. ben buraya alternatif bir servisi entegre edemem.
		
		
		
		this.productDao.add(product); // hic bir sekilde hibernate'e bagimliligim yok
		
		this.loggerService.logToSystem("Urun eklendi " + product.getName());
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
}


// eger ben newleyerek bunu siki sikiya baglarsam, o zaman unit test de yazamam. (unit test= kodu kodla kontrol etmek)
// ben bunun icin ne yapacag�m? dependency injektion yapacagim. ben buna bagliyim.bunu gevsek baglayacagim.
// sen data access' e baglisin. ama gevsek baglisin. data access'in ancak referans tutucu olan, abstract klasorundeki yapisina
// bagimli olabilirsin. => dependency injection

// return => gordugu anda asagiya bakmaz. metodu bitirir.

// J Logger'a dokunamiyorum. herhangi bir interface veremiyorum. dokunamiyorum. sadece cagirmak istiyorum. bunu ancak ve ancak 
// new'leyerek yapabilirim. (KpsMernis sistemini newlemistik. Ayni onun gibi) adapter pattern ile implement etmek gerekir.
// Loglama her projede kullanildigin icin yeri core katmani.