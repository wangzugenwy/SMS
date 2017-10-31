package com.model;

public class BookGroup {
        private int gid;
        private String title;
        private String description;
        private String uid;
		public int getGid() {
			return gid;
		}
		public void setGid(int gid) {
			this.gid = gid;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getUid() {
			return uid;
		}
		public void setUid(String uid) {
			this.uid = uid;
		}
		public BookGroup(String title, String description, String uid) {
			super();
			this.title = title;
			this.description = description;
			this.uid = uid;
		}
		public BookGroup() {
			super();
		}
		@Override
		public String toString() {
			return "Book_group [gid=" + gid + ", title=" + title
					+ ", description=" + description + ", uid=" + uid + "]";
		}
        
        
        
        
		}
