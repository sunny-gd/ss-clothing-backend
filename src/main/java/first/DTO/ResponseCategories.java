package first.DTO;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ResponseCategories {
	
	private List<ProductDetails> hats;
	private List<ProductDetails> jackets;
	private List<ProductDetails> mens;
	private List<ProductDetails> sneakers;
	private List<ProductDetails> womens;
	
	public List<ProductDetails> getHats() {
		return hats;
	}
	public void setHats(List<ProductDetails> hats) {
		this.hats = hats;
	}
	public List<ProductDetails> getJackets() {
		return jackets;
	}
	public void setJackets(List<ProductDetails> jackets) {
		this.jackets = jackets;
	}
	public List<ProductDetails> getMens() {
		return mens;
	}
	public void setMens(List<ProductDetails> mens) {
		this.mens = mens;
	}
	public List<ProductDetails> getSneakers() {
		return sneakers;
	}
	public void setSneakers(List<ProductDetails> sneakers) {
		this.sneakers = sneakers;
	}
	public List<ProductDetails> getWomens() {
		return womens;
	}
	public void setWomens(List<ProductDetails> womens) {
		this.womens = womens;
	}
	
	
	
}
