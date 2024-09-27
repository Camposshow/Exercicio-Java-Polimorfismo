package entities.enums;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product{
	
	DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //Criando um formato para data padrão Brasil

	private LocalDate manufactureDate;
	
	public UsedProduct() {
		super();
	}

	
	public UsedProduct(String name, double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}


	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	
	@Override
	public String priceTag() {
		return getName() + " (usado) $ " + getPrice() + "( Data de fabricação: "  + manufactureDate.format(fmt1) + ")";
	}
	
	

}
