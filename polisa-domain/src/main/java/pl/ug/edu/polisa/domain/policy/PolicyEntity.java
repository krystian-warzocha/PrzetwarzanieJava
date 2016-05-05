package pl.ug.edu.polisa.domain.policy;

import java.math.BigDecimal;
import java.util.Date;

import pl.ug.edu.polisa.domain.core.BaseEntity;
import pl.ug.edu.polisa.domain.core.Column;
import pl.ug.edu.polisa.domain.core.Entity;

/**
 * Encja polisy.
 * 
 * @author kwarzocha
 * 
 */
@Entity(tableName = "POLISA")
public class PolicyEntity extends BaseEntity {

	@Column(columnName="policynumber")
	private String policyNumber;

	@Column(columnName="premium")
	private BigDecimal premium; // składka
	
	@Column(columnName="data_od")
	private Date data_od;
	
	@Column(columnName="data_do")
	private Date data_do;
	
	public String getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}

	public BigDecimal getPremium() {
		return premium;
	}

	public void setPremium(BigDecimal skladka) {
		this.premium = skladka;
	}

	public Date getData_od() {
		return data_od;
	}

	public void setData_od(Date data_od) {
		this.data_od = data_od;
	}

	public Date getData_do() {
		return data_do;
	}

	public void setData_do(Date data_do) {
		this.data_do = data_do;
	}

	@Override
	public String displayable() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append(" ").append(getPolicyNumber());
		return sb.toString();
	}

	@Override
	public String tableName() {
		return "POLISA";
	}

}
