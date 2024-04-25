package org.example.wallet.balance.da.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Atousa Mirhosseini
 * @since 25 Apr, 2024
 */
@Entity
@Table(name = "WALLET_TRANS")
@Setter
@Getter
@NoArgsConstructor
public class WalletTransactionEntity implements Serializable {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TRANS_TYPE", unique = true, nullable = false)
    @Enumerated(value = EnumType.STRING)
    private WalletTransType transType;

    @Column(name = "CREATE_AT", nullable = false)
    private Long creationDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Column(name = "AMOUNT", nullable = false, unique = true)
    private Long amount;

    public WalletTransactionEntity(WalletTransType transType, Long amount, UserEntity user) {
        this.transType = transType;
        this.amount = amount;
        this.creationDate = System.currentTimeMillis();
        this.user = user;
    }
}
