package interfaces;

public class CustomerManager {
	
	//private Logger logger; // neye bagimliysak, onun degiskenini yapiyoruz.
	
	// loglamaya gevsek bagimliyiz.
	
	private Logger[] loggers;

	public CustomerManager(Logger[] loggers) {  // loglamalari boyle yazmaliyiz
		
		this.loggers = loggers;
	}
	
	

	// birden fazla loglama icin nasil bir sistem yazilabilir?
	
	// coklu loglama 
	
	
	

	
	
	public void add(Customer customer) {
		System.out.println("M�steri Eklendi : " + customer.getFirstName());
		
	
	   Utils.runLoggers(loggers, customer.getFirstName());
		
	}
	
	public void delete(Customer customer) {
		System.out.println("M�steri Silindi : " + customer.getFirstName());
		
	    Utils.runLoggers(loggers, customer.getLastName());
	   
	
	}
	
	// metotlarda farkli logger kullanmak istersek, metot seviyesinde kullanmak gerek. Bundan kacmak icin aspectleri de
    // kullaniyoruz. bir nevi antipatern.
	
}

//amac�m buraya loglama dahil etmek.


// simple is best :) => musteri managerda sadece musteriyi ilgilendiren kodlar yazilir. Loglama ile ilgili kodlarin yazilmas� icin, 
// service leri sisteme enjekte edersiniz. bu olaya biz bagimlilik diyoruz. Customer manager loglamaya bag�ml�. iki tip bagimlilik var
// birisi;

// loosly coupled bagimlik. digeri tightly coupled (bagimlilik)

// biz yukar�da databaselogger diyerek sistemi siki sikiya bagladik. biz bunlari gevsek baglamaliyiz.

