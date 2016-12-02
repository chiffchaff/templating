package com.test.jxls;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;

/**
 * http://jxls.sourceforge.net/getting_started.html
 * 
 * @author sumitjaiswal
 *
 */
public class TestJxls {
	public static void main(String[] args) {
		System.out.println("Running Object Collection demo");
		List<Employee> employees = Arrays.asList(
				Employee.builder().name("Sumit").payment(new BigDecimal("100")).bonus(new BigDecimal("20")).build(),
				Employee.builder().name("Amit").payment(new BigDecimal("1000")).bonus(new BigDecimal("10")).build());
		try {
			InputStream is = TestJxls.class.getResourceAsStream("/object_collection_template.xls");
			System.out.println("Input stream Available :" + is.available());

			OutputStream os = new FileOutputStream("target/object_collection_output.xls");
			Context context = new Context();
			context.putVar("employees", employees);
			//JxlsHelper.getInstance().processTemplate(is, os, context);
			/**
			 * By default JxlsHelper assumes that you want to override the
			 * template sheet with the data. But you may also choose to generate
			 * the data at another sheet by using the following method
			 */
			JxlsHelper.getInstance().processTemplateAtCell(is, os, context,"Result!A1");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
