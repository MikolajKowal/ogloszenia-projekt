package ogloszenia.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	/*
	 * Uzytkownik
    email
    haslo
    nick
    avatar
    city name
	 */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true)
	Integer id;
	
	@Column(nullable=false,unique=true)
	String nick;
	
	@Column(nullable=false)
	String password;
	
	@Lob
	byte[] avatar;
	
	@Column(nullable=false)
	String email;
	
	@Column(nullable=false)
	String cityName;
	
	@ManyToMany(mappedBy="watchers")
	Set<Advertisement> followedAdvertisemets;
	
	@OneToMany(mappedBy="owner")
	Set<Advertisement> ads;
	
	@OneToMany(mappedBy="conversationSender")
	Set<Conversation> sendMessages;
	
	@OneToMany(mappedBy="conversationReceiver")
	Set<Conversation> receivedMessages;
	
	@OneToMany(mappedBy="owner")
	Set<ConversationMessage> conversationMessage;
	
	public User() {}
	
	public User(String nick, String password, String email, String location) {
		this.nick = nick;
		this.password = password;
		this.email = email;
		this.cityName = location;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
