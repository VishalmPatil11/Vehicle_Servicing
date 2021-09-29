package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="feedback")
public class Feedback {
		int f_id;						//auto generated  			-->  @Id
		Order f_order;					//Feedback For Which Order 	--> (o_id)
		User f_user;					//Feedback From Which User 	--> (u_id)
		Vendor f_vendor;				//Feedback For Which Vendor	--> (ven_id)
		String description;				//Feedback Description		
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getF_id() {
			return f_id;
		}
		public void setF_id(int f_id) {
			this.f_id = f_id;
		}
		
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="o_id")	
		public Order getF_order() {
			return f_order;
		}
		
		public void setF_order(Order f_order) {
			this.f_order = f_order;
		}
		
		
		
		@OneToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="u_id")
		public User getF_user() {
			return f_user;
		}
		public void setF_user(User f_user) {
			this.f_user = f_user;
		}
		
		

		
		@ManyToOne 
		@JoinColumn(name="ven_id")
		public Vendor getF_vendor() {
			return f_vendor;
		}
	
		public void setF_vendor(Vendor f_vendor) {
			this.f_vendor = f_vendor;
		}	
		
		
		
		@Column(length=150)
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
	
}
