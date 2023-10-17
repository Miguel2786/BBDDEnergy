package proyectBBDDEnergy.models.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="companies")
public class Company implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=4, max=25)
	private String name;
	
	@Column(name="valley")
	@NotNull
	@Min(value = 0, message = "Number of books must be greater than 0")
	@Max(value =2)
	private Double valleyPower;
	
	@Column(name="peak")
	@NotNull
	@Min(value = 0, message = "Number of books must be greater than 0")
	@Max(value =2)
	private Double peakPower;
	
	@Column(name="consumption")
	@NotNull
	@Min(value = 0, message = "Number of books must be greater than 0")
	@Max(value =2)
	private Double consumptionPrice;

	
	
	//GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Double getValleyPower() {
		return valleyPower;
	}

	public void setValleyPower(Double valleyPower) {
		this.valleyPower = valleyPower;
	}

	public Double getPeakPower() {
		return peakPower;
	}

	public void setPeakPower(Double peakPower) {
		this.peakPower = peakPower;
	}

	public Double getConsumptionPrice() {
		return consumptionPrice;
	}

	public void setConsumptionPrice(Double consumptionPrice) {
		this.consumptionPrice = consumptionPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
