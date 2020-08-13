package in.nit.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import in.nit.model.Product;

@Component
public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
	Product p=(Product)target;
	
	//---Text Input---
	if (p.getProdCode() == null || p.getProdCode().isEmpty()) {
				errors.rejectValue("prodCode", null, "Please Enter Product Code!");
			}
			else if(!Pattern.matches("[0-9]{2,6}", p.getProdCode())) { //not matched
				errors.rejectValue("prodCode", null, "Product Code must be 2-6 Uppercase Chars!");
			}
			
			//--Radio button -- choose any one value-- only null/empty
			if(p.getProdModel() == null || p.getProdModel().isEmpty()) {
				errors.rejectValue("prodModel", null,"Please Choose any one Model");
			}
			
			//--Text area-- pattern--
			if(p.getProdNote() == null || p.getProdNote().isEmpty()) {
				errors.rejectValue("prodNote", null, "Please Enter Product Note!");
			}
			else if(!Pattern.matches("[A-Za-z0-9]{5,50}", p.getProdNote())) { //not matched
				errors.rejectValue("prodNote", null, "Note must be 5-50 Chars!");
			}
			
			//DropDown (no pattern) select any one--
			if(p.getProdVendor() == null || p.getProdVendor().length()==0) {
				errors.rejectValue("prodVendor", null,"Please Choose any one Vendor");
			}
			
			//--checkbox => List (size>0) and not null
			if(p.getProdOption()==null || p.getProdOption().isEmpty()) {
				errors.rejectValue("prodOption", null,"Please Choose atleast one option");
			}
		
	}

}
