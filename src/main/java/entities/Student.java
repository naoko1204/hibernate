package entities;

import embeddable.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SecondaryTable(name = "address",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id"))
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(table = "address")
    private String street;

    @Column(table = "address")
    private String city;



}
