package org.example.wallet.balance.da.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Atousa Mirhosseini
 * @since 24 Apr, 2024
 */
@Entity
@Table(name = "WALLET")
@Setter
@Getter
@NoArgsConstructor
public class WalletEntity implements Serializable {
    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "BALANCE", nullable = false, unique = true)
    private Long balance;

    @OneToOne
    @MapsId
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    @Version
    @Column(name = "VERSION")
    private Long version;
}
