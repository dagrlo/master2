package es.uv.bdsw.sparrow.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chips database table.
 * 
 */
@Entity
@Table(name="chips")
@NamedQuery(name="Chip.findAll", query="SELECT c FROM Chip c")
public class Chip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String tag;

	private String text;

	//uni-directional many-to-one association to Chip
	@ManyToOne
	@JoinColumn(name="thread")
	private Chip thread;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user")
	private User user;

	public Chip() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Chip getThread() {
		return this.thread;
	}

	public void setThread(Chip thread) {
		this.thread = thread;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}