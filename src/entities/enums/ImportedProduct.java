package entities.enums;

public class ImportedProduct extends Product{
	
	private Double customsFee;
	
	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}
	
	public Double totalPrice(Double customsFee) {
		return super.price + customsFee;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $ " + totalPrice(customsFee) + " (Taxa: $ " + customsFee +")";
	}

}
