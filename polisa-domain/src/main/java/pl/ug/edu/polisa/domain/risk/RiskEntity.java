package pl.ug.edu.polisa.domain.risk;

import java.math.BigDecimal;

import pl.ug.edu.polisa.domain.core.BaseEntity;
import pl.ug.edu.polisa.domain.core.Entity;

@Entity(tableName="Ryzyko")
public class RiskEntity extends BaseEntity {
	
	private BigDecimal riskPremium;

	public BigDecimal getRiskPremium() {
		return riskPremium;
	}

	public void setRiskPremium(BigDecimal riskPremium) {
		this.riskPremium = riskPremium;
	}

	@Override
	public String displayable() {
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append(" ").append(getRiskPremium());
		return sb.toString();
	}

	@Override
	public String tableName() {
		return "RYZYKO";
	}

}
