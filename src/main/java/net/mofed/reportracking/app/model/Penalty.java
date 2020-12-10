package net.mofed.reportracking.app.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Penalty {
	
       @Id
       @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer id;
       
       
	   private Integer level;
	   private String  penaltytype;
	   private float amount;
	   
	   
	   
	   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getPenaltytype() {
		return penaltytype;
	}
	public void setPenaltytype(String penaltytype) {
		this.penaltytype = penaltytype;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	   

	   
	   
	   
}
