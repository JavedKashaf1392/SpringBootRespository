package in.nit.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	
	@Id
	@GeneratedValue
    private Integer prodId;
    private String prodCode;
    private String prodModel;
    private String prodNote;
    private String prodVendor;
    
    @ElementCollection
    private List<String> prodOption;
    private String prodKeyCode;
}
