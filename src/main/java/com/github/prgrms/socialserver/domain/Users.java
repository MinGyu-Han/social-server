package com.github.prgrms.socialserver.domain;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;

	@Column(length = 50, nullable = false, unique = true)
	private String email;

	@Column(length = 80, nullable = false)
	private String passwd;

	@Column(nullable = false)
	@ColumnDefault("0")
	private int loginCount;

	@Column(nullable = true, columnDefinition = "DATETIME DEFAULT NULL")
	private LocalDateTime lastLoginAt;

	@Column(nullable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
	@CreationTimestamp
	private LocalDateTime createAt;


	public Users(String email, String passwd) {
		this.email = email;
		this.passwd = passwd;
	}

	public Users(Long seq, String email, String passwd, int loginCount, LocalDateTime lastLoginAt, LocalDateTime createAt) {
		this.seq = seq;
		this.email = email;
		this.passwd = passwd;
		this.loginCount = loginCount;
		this.lastLoginAt = lastLoginAt;
		this.createAt = createAt;
	}

	public Users() {
	}

	public static UsersBuilder builder() {
		return new UsersBuilder();
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public LocalDateTime getLastLoginAt() {
		return lastLoginAt;
	}

	public void setLastLoginAt(LocalDateTime lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public static class UsersBuilder {
		private Long seq;
		private String email;
		private String passwd;
		private int loginCount;
		private LocalDateTime lastLoginAt;
		private LocalDateTime createAt;

		UsersBuilder() {
		}

		public UsersBuilder seq(Long seq) {
			this.seq = seq;
			return this;
		}

		public UsersBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UsersBuilder passwd(String passwd) {
			this.passwd = passwd;
			return this;
		}

		public UsersBuilder loginCount(int loginCount) {
			this.loginCount = loginCount;
			return this;
		}

		public UsersBuilder lastLoginAt(LocalDateTime lastLoginAt) {
			this.lastLoginAt = lastLoginAt;
			return this;
		}

		public UsersBuilder createAt(LocalDateTime createAt) {
			this.createAt = createAt;
			return this;
		}

		public Users build() {
			return new Users(seq, email, passwd, loginCount, lastLoginAt, createAt);
		}

		public String toString() {
			return "Users.UsersBuilder(seq=" + this.seq + ", email=" + this.email + ", passwd=" + this.passwd + ", loginCount=" + this.loginCount + ", lastLoginAt=" + this.lastLoginAt + ", createAt=" + this.createAt + ")";
		}
	}
}
