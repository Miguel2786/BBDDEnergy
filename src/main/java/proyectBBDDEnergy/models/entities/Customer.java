package proyectBBDDEnergy.models.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="customers")
public class Customer {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Size(min=4, max=25)
	private String name;
	
	@NotEmpty
	@Size(min=4, max=55)
	private String surnames;
	
	@NotEmpty
	@Size(min=4, max=55)
	private String address;
	
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="hired_potency")
	@NotNull
	@Min(value = 0, message = "Number of books must be greater than 0")
	@Max(value =10)
	private Double hiredPotency;
	
	@Column(name="annual_consum")
	@NotNull
	@Min(value = 0, message = "Number of books must be greater than 0")
	private Double annualConsumption;

	@Column(name = "create_at")
	// formato de los datos en la base de datos AAAA-MM-DD
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate createAt;

	
	
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

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public Double getHiredPotency() {
		return hiredPotency;
	}

	public void setHiredPotency(Double hiredPotency) {
		this.hiredPotency = hiredPotency;
	}

	public Double getAnnualConsumption() {
		return annualConsumption;
	}

	public void setAnnualConsumption(Double annualConsumption) {
		this.annualConsumption = annualConsumption;
	}

	
	
	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
