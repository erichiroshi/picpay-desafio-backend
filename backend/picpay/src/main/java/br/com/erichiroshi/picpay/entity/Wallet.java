package br.com.erichiroshi.picpay.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "tb_wallet")
public class Wallet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "cpf_cnpj", unique = true)
	private String cpfCnpj;

	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "balance")
	private BigDecimal balance = BigDecimal.ZERO;

	@ManyToOne
	@JoinColumn(name = "wallet_type_id")
	private WalletType walletType;

	public Wallet(String fullName, String cpfCnpj, String email, String password, WalletType walletType) {
		this.fullName = fullName;
		this.cpfCnpj = cpfCnpj;
		this.email = email;
		this.password = password;
		this.walletType = walletType;
	}
	
	

}