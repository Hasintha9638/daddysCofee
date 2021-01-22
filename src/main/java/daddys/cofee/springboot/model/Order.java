package daddys.cofee.springboot.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Coustomer_Name")
	private String customerName;
	
	@Column(name = "Coustomer_TelNo")
	private int customerTelno;
	
	@Column(name = "Product_Id")
	private long productid;
	
	@Column(name = "Product_Amount")
	private int amount;
	
	@Column(name = "Order_Date")
	private Date orderDate;

	@Column(name = "Order_State")
	private String orderState;

	
	public Order() {
		
	}
	
	public Order(String customerName, int customerTelno, long productid, int amount,Date orderDate,String orderState) {
		super();
		this.customerName = customerName;
		this.customerTelno = customerTelno;
		this.productid = productid;
		this.amount = amount;
		this.orderDate = orderDate;
		this.orderState = orderState;
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getCustomerTelno() {
		return customerTelno;
	}
	public void setCustomerTelno(int customerTelno) {
		this.customerTelno = customerTelno;
	}
	public long getProductId() {
		return productid;
	}
	public void setProductId(long productid) {
		this.productid = productid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getOrderDate() {
		return (Date) this.orderDate.clone();
	}
	public void setOrderDate(Date date) {
		this.orderDate = (Date) date.clone();
	}
	
	public String getOrderState() {
		return orderState;
	}
	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
}
