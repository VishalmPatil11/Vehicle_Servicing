/*package com.app.pojos;

import javax.persistence.*;

//This Table Must Be Populated and Generated Automatically When User Will Place The Order
@Entity
@Table(name="service_taken")
public class Service_Taken {
		int st_id;						//auto generated @Id
		Order st_o_order_fk;			//order id
		User st_u_user_fk;				//user id
		Service st_s_service_fk;		//Services taken by user	
		Service st_s_price_fk;			//price per service
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		public int getSt_id() {
			return st_id;
		}
		public void setSt_id(int st_id) {
			this.st_id = st_id;
		}
		
		@ManyToOne
		public Order getSt_o_order_fk() {
			return st_o_order_fk;
		}
		public void setSt_o_order_fk(Order st_o_order_fk) {
			this.st_o_order_fk = st_o_order_fk;
		}
		
		@ManyToOne
		public User getSt_u_user_fk() {
			return st_u_user_fk;
		}
		public void setSt_u_user_fk(User st_u_user_fk) {
			this.st_u_user_fk = st_u_user_fk;
		}
		
		@Column(name="st_s_service_fk")
		public Service getSt_s_service_fk() {
			return st_s_service_fk;
		}
		public void setSt_s_service_fk(Service st_s_service_fk) {
			this.st_s_service_fk = st_s_service_fk;
		}
		
		@Column(name="st_s_price_fk")
		public Service getSt_s_price_fk() {
			return st_s_price_fk;
		}
		public void setSt_s_price_fk(Service st_s_price_fk) {
			this.st_s_price_fk = st_s_price_fk;
		}
		
		
		
}
*/