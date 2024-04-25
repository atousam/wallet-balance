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
@Table(name = "USER")
@Setter
@Getter
@NoArgsConstructor
public class UserEntity implements Serializable {
    @Id
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private WalletEntity wallet;

    @Version
    @Column(name = "VERSION")
    private Long version;
}
