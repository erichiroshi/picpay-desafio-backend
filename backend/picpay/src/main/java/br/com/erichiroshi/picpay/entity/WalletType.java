package br.com.erichiroshi.picpay.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_wallet_type")
public class WalletType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	public enum Enum {

		USER(1L, "user"), MERCHANT(2L, "merchant");

		Enum(Long id, String description) {
			this.id = id;
			this.description = description;
		}

		private Long id;
		private String description;

		public WalletType get() {
			return new WalletType(id, description);
		}
	}

}