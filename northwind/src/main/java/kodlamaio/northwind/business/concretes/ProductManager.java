package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	
	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		    
			return new SuccessDataResult<List<Product>>
			(this.productDao.findAll(),"Data listelendi");			
				
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün eklendi");
	}

}

	//spring nasil calisir ? => normal sartlarda bunlarin injection'inini kullanabilmek icin,generic olarak calisiyor. arka planda jpaRepository de
	// spring bir repository clasi olusturuyor. (bir instance olusturup buraya veriyor. ama ona ait bir bilgi yok. bunun icin @Autowired notation'i)
	// kullaniliyor.
	// beans => javada proje classi
	// factory => arka planda tasarim deseni dedigimiz bir yapiyi calistirir. bir instance verir acikcasi. Autowired'da spring arka planda
	// buna karsilik gelecek projenin bir instance i olacak ( productDao 'nun) bir instance'i olabilecek sinifi uretip/ ona veriyor. 
	// o zaten spring tarafinda tanimli.
	// autowired genellikle bir bagimlilik olur. tek instance uzerinden gider. bunu configure de edebiliriz. ama java dunyasinde bu yaygindir.
	// autofac business module da bunun autowired yapiyor. gidiyor. projeyi taniyor. ona karsilik gelen ne varsa, buraya veriyor.
