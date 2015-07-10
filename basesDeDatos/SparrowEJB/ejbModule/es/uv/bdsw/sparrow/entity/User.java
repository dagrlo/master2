package es.uv.bdsw.sparrow.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String apellidos;

	private String eMail;

	private String idioma;

	private String nombre;

	private String password;

	private String sexo;

	private String username;

	//bi-directional many-to-one association to Chip
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<Chip> chips;

	//bi-directional many-to-one association to Following
	@OneToMany(mappedBy="followed", fetch=FetchType.EAGER)
	private List<Following> followings;

	//bi-directional many-to-one association to Following
	@OneToMany(mappedBy="follower", fetch=FetchType.EAGER)
	private List<Following> followeds;   //followers seguidores

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Chip> getChips() {
		return this.chips;
	}

	public void setChips(List<Chip> chips) {
		this.chips = chips;
	}

	public Chip addChip(Chip chip) {
		getChips().add(chip);
		chip.setUser(this);

		return chip;
	}

	public Chip removeChip(Chip chip) {
		getChips().remove(chip);
		chip.setUser(null);

		return chip;
	}

	public List<Following> getFollowings() {
		return this.followings;
	}

	public void setFollowings(List<Following> followings) {
		this.followings = followings;
	}

	public Following addFollowing(Following following) {
		getFollowings().add(following);
		following.setFollowed(this);

		return following;
	}

	public Following removeFollowing(Following following) {
		getFollowings().remove(following);
		following.setFollowed(null);

		return following;
	}

	public List<Following> getFolloweds() {
		return this.followeds;
	}

	public void setFolloweds(List<Following> followeds) {
		this.followeds = followeds;
	}

	public Following addFollowed(Following followed) {
		getFolloweds().add(followed);
		followed.setFollower(this);

		return followed;
	}

	public Following removeFollowed(Following followed) {
		getFolloweds().remove(followed);
		followed.setFollower(null);

		return followed;
	}

}