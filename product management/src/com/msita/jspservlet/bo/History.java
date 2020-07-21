package com.msita.jspservlet.bo;

import java.sql.Date;

public class History {
        private  int idhistory;
        private  int iduser;
		private int idproduct;
		private int total;
		private Date date;
		public int getIdhistory() {
			return idhistory;
		}
		public void setIdhistory(int idhistory) {
			this.idhistory = idhistory;
		}
		public int getIduser() {
			return iduser;
		}
		public void setIduser(int iduser) {
			this.iduser = iduser;
		}
		public int getIdproduct() {
			return idproduct;
		}
		public void setIdproduct(int idproduct) {
			this.idproduct = idproduct;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
		}
}
